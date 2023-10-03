package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.FileConstants;
import constants.WaitConstants;

public class CommonUtils {
    //this method is for Wait duration
	public static boolean waitForElements(WebDriver driver, WebElement element) {
		boolean isElementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver,WaitConstants.WAIT_FOR_ELEMENTS);
		//driver.manage().timeouts().implicitlyWait(null);
		try {;
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClickable= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementClickable;
	}
	public static boolean waitForElementsToAppear(WebDriver driver, WebElement element) {
		boolean isElementFound = false;
		WebDriverWait wait = new WebDriverWait(driver,WaitConstants.WAIT_FOR_ELEMENTS_TO_DISAPPEAR);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			isElementFound= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementFound;
	}
	
	public static boolean waitForElementsToDisappear(WebDriver driver, WebElement element) {
		boolean isElementFound = false;
		WebDriverWait wait = new WebDriverWait(driver,WaitConstants.WAIT_FOR_ELEMENTS_TO_DISAPPEAR);
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
			isElementFound= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementFound;
	}
	public static String getStringDateAndTimestamp() {
		String value = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		return value;
	}
	
	public static String getScreenshot(WebDriver driver) throws IOException {
		String path = FileConstants.SCREENSHOT_PATH;
		TakesScreenshot screen = (TakesScreenshot)driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(src, destination);
		return path;
	}
	
	public static void moveToElement(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}
		
	
}
		
		

	


