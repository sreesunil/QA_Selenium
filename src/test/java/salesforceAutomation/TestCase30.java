package salesforceAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase30 {

	

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		ChromeDriver driver =   Reusablecodes.SalesforceLogin();
		driver.manage().window().maximize();
		
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();
		if(actualTitle.equalsIgnoreCase(expectedTitle)) {
		System.out.println("Login is Successful");
		}
		else {
			System.out.println("home page is not Lunched");
		}
		Thread.sleep(3000);
		WebElement contact = driver.findElement(By.linkText("Contacts"));
		contact.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Create New View")).click();
		
		Robot name = new Robot();
		
		driver.findElement(By.id("devname")).sendKeys("EFGH");
		
		name.keyPress(KeyEvent.VK_ENTER);
		name.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement Save = driver.findElement(By.name("save"));
		String expectedText = "Error: You must enter a value";
		String actualText = driver.findElement(By.xpath("//div[@class ='errorMsg']")).getText();
		if(actualText.contains(expectedText)) {
			System.out.println("Test is Successful");
		}else {
			System.out.println("Test is Failed");
		}
		driver.close();
	}

}
