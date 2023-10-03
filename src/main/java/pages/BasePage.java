package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.CommonUtils;

public class BasePage {

	public static Logger logger = LogManager.getLogger("BaseTest");

	public static boolean verifyElementDisplayed(WebDriver driver, WebElement element) {
		boolean elementDisplayed = false;
		if (CommonUtils.waitForElements(driver, element)) {
			if (element.isDisplayed())
				elementDisplayed = true;
			logger.info("Page : verifyElementDisplayed ");
		}

		return elementDisplayed;
	}

	public static boolean clickElement(WebElement element, WebDriver driver) {

		boolean isButtonClicked = false;

		if (CommonUtils.waitForElements(driver, element)) {
			if (CommonUtils.waitForElementsToAppear(driver, element)) {
				if (element.isDisplayed()) {
					element.click();
					
					isButtonClicked = true;
				}
			}
		}

		return isButtonClicked;
	}

	public static boolean verifyDisplayMessage(WebElement element, String sMessage) {

		boolean messageDisplayed = false;
		if (element.isDisplayed()) {
			String sActualMessage = element.getText();
			System.out.println("sActualMessage: " + sActualMessage);
			if (sActualMessage.equals(sMessage)) {
				messageDisplayed = true;
			}
		}

		return messageDisplayed;
	}

	public static boolean verifyDisplayMessage(WebDriver driver, WebElement element, String sMessage) {

		boolean messageDisplayed = false;
		if (CommonUtils.waitForElements(driver, element)) {
			if (element.isDisplayed()) {
				String sActualMessage = element.getText();
				System.out.println("sActualMessage: " + sActualMessage);
				if (sActualMessage.equals(sMessage)) {
					messageDisplayed = true;
				}
			}
		}
		return messageDisplayed;
	}

	public static boolean validateTitle(WebDriver driver, String expectedMessage) {

		boolean messageDisplayed = false;

		String sActualMessage = driver.getTitle();

		if (sActualMessage.equals(expectedMessage)) {
			messageDisplayed = true;
		}

		return messageDisplayed;
	}

	public static boolean performActtion(WebDriver driver, WebElement element) {
		boolean actionPerformed = false;
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		action.click(element).build().perform();

		return actionPerformed;
	}

	public static boolean selectMenuItem(WebDriver driver, WebElement element) {

		boolean isSelected = false;
		if (CommonUtils.waitForElements(driver, element)) {

			if (element.isDisplayed()) {
				element.click();
				isSelected = true;
			}
		}
		return isSelected;

	}

	public static boolean dropdownList(WebElement element, String sOptionValue) {

		boolean isSelected = false;
		if (element.isDisplayed()) {
			Select select = new Select(element);
			select.selectByValue(sOptionValue);
			logger.info("Page : Dropdown Selected ");
			isSelected = true;
		}
		return isSelected;

	}

	public static boolean assignInputValue(WebDriver driver, WebElement element, String sValue) {

		boolean isValueAssigned = false;
		if (CommonUtils.waitForElements(driver, element)) {
			element.clear();
			element.sendKeys(sValue);
			logger.info("Page : assaigned InputValue ");
			isValueAssigned = true;
		}
		return isValueAssigned;

	}

}
