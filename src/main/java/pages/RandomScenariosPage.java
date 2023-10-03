package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.FileConstants;
import test.BaseTest;
import utils.CommonFileUtils;
import utils.CommonUtils;

public class RandomScenariosPage extends BasePage {

	public RandomScenariosPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "home_Tab")
	public WebElement homeTab;

	@FindBy(xpath = "//span[@id ='userNavLabel']")
	public WebElement myProfilePage;

	@FindBy(xpath = "//h1[@class='currentStatusUserName']//a")
	public WebElement userName;

	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	public WebElement Userprofilepagenamedisplay;

	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement MyProfile;

	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']//img")
	public WebElement editContactButton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement EditProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement Abouttab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement Abouttablastname;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "AllTab_Tab")
	public WebElement allTab;

	@FindBy(xpath = "//input[contains(@title,'Customize My Tabs')]")
	public WebElement customizeTab;

	@FindBy(xpath = "//option[@value='Chatter']")
	public WebElement chatter;

	@FindBy(xpath = "//img[@class='leftArrowIcon']")
	public WebElement removeButton;

	@FindBy(name = "save")
	public WebElement saveButton;

	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(linkText = "Logout")
	public WebElement Logout;

	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(xpath = "//h1[@class='currentStatusUserName']")
	public WebElement currentUsername;

	@FindBy(xpath = "//span[@class='pageDescription']/a[1]")
	public WebElement currentDate;

	@FindBy(xpath = "//a[contains(text(),'8:00 PM')]")
	public WebElement time8pm;

	@FindBy(xpath = "//*[@class='comboboxIcon']")
	public WebElement subjectComboxIcon;

	@FindBy(xpath = "//h2[@class='pageDescription']")
	public WebElement newEventPage;

	@FindBy(xpath = "//div[@class='choicesBox tertiaryPalette brandSecondaryBrd']//li//a")
	public List<WebElement> eventSubjects;

	@FindBy(id = "EndDateTime")
	public WebElement endDate;

	@FindBy(id = "EndDateTime_time")
	public WebElement endDateTime;

	@FindBy(xpath = "//div[@id='timePickerItem_42']")
	public WebElement select9PM;

	@FindBy(xpath = "//a[contains(text(),'4:00 PM')]")
	public WebElement time4pm;

	@FindBy(xpath = "//div[@id='timePickerItem_38']")
	public WebElement select7PM;

	@FindBy(id = "IsRecurrence")
	public WebElement checkboxReoccurance;

	@FindBy(id = "rectypeftw")
	public WebElement weeklyRadioButton;

	@FindBy(id = "16")
	public WebElement selectThursday;

	@FindBy(id = "RecurrenceEndDateOnly")
	public WebElement recurrenceEndDate;

	@FindBy(xpath = "//img[@class='monthViewIcon']")
	public WebElement monthViewIcon;

	@FindBy(xpath = "//h1[@class='pageType']")
	public WebElement monthview;

	@FindBy(xpath = "//span[@class='feeditemfirstentity'][1]")
	public WebElement FeedItemListValue;

	public boolean verifyUsername(WebDriver driver) {
		boolean isusernameverified = false;
		if (BasePage.verifyElementDisplayed(driver, userName)) {
			if (BasePage.clickElement(userName, driver)) {
				if (BasePage.verifyDisplayMessage(driver,myProfilePage, "Sree Sunil")) {
					isusernameverified = true;
				}
			}
		}
		return isusernameverified;

	}

	public boolean selectEditContact(WebDriver driver) throws InterruptedException {
		boolean isEditContactSelected = false;

		if (BasePage.clickElement(userName, driver)) {
			if (CommonUtils.waitForElementsToAppear(driver, FeedItemListValue)) {
				if (BasePage.clickElement(editContactButton, driver)) {
					isEditContactSelected = true;
				}
			}
		}
		return isEditContactSelected;
	}

	public boolean verifyEditContactPopUp(WebDriver driver) throws InterruptedException {
		boolean isContactPopUpVerified = false;

		if (CommonUtils.waitForElements(driver, iframeAboutTab)) {
			System.out.println("Before edit contact button");
			driver.switchTo().frame(iframeAboutTab);
			System.out.println("After edit contact button");
			if (Abouttab.isDisplayed() && contactTab.isDisplayed()) {
				isContactPopUpVerified = true;
			}
		}
		// NOTE: Maybe required to switch to parent frame
		return isContactPopUpVerified;
	}

	public boolean verifyLastNameChangeInAboutTab(WebDriver driver, String sLastName) throws InterruptedException {
		boolean isLastNameVerified = false;
		if (Abouttab.isDisplayed()) {
			Abouttab.click();
			Abouttablastname.clear();
			Abouttablastname.sendKeys(sLastName);
			saveAllButton.click();
			logger.info("Page : verifyLastNameChangeInAboutTa ");
			driver.switchTo().parentFrame();
			System.out.println("verifyLastNameChangeInAboutTab 1");
			if (Userprofilepagenamedisplay.isDisplayed()) {
				System.out.println("verifyLastNameChangeInAboutTab 2");
				String sActualName = Userprofilepagenamedisplay.getText();
				if (sActualName.contains(sLastName)) {
					isLastNameVerified = true;
				}
			}
		} else {
			System.out.println("RandomScenariosPage : verifyLastNameChangeInAboutTab : About tab is not visible");
		}
		return isLastNameVerified;
	}

	public boolean verifySelectCustomization(WebDriver driver) {

		boolean isTabCustomizationSelected = false;
		BasePage.clickElement(allTab, driver);
		BasePage.clickElement(customizeTab, driver);
		isTabCustomizationSelected = true;
		return isTabCustomizationSelected;

	}

	public boolean verifySelectTabs(WebDriver driver) {

		boolean isSelected = false;
		isSelected = BasePage.clickElement(chatter, driver);
		isSelected = BasePage.clickElement(removeButton, driver);
		isSelected = BasePage.clickElement(saveButton, driver);

		return isSelected;
	}

	public boolean verifyLogOut(WebDriver driver) {

		boolean isLogoutVerified = false;
		isLogoutVerified = BasePage.selectMenuItem(driver, userMenu);
		isLogoutVerified = BasePage.selectMenuItem(driver, Logout);

		return isLogoutVerified;

	}

	public boolean verifyLaunchAndLogin(WebDriver driver) throws IOException {

		boolean isLoginVerified = false;

		driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		driver.manage().window().maximize();
		logger.info("LoginPage : loginToApp : started");
		if (BasePage.verifyElementDisplayed(driver, username)) {
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(driver);
			isLoginVerified = true;

		}

		return isLoginVerified;

	}

	public boolean VerifyCalenderPageDisplayed(WebDriver driver) {

		boolean isCalenderPageVerified = false;
		if (BasePage.verifyElementDisplayed(driver, currentUsername)) {
			BasePage.clickElement(currentDate, driver);
			BasePage.clickElement(time8pm, driver);
			isCalenderPageVerified = true;

		}
		return isCalenderPageVerified;

	}

	public boolean SelectSubject(WebDriver driver) {

		boolean isSubjectSelected = false;
		if (BasePage.verifyElementDisplayed(driver, newEventPage)) {
			isSubjectSelected = BasePage.clickElement(subjectComboxIcon, driver);
		}
		Set<String> windowHandles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		windowHandles.remove(currentHandle);
		String newHandle = windowHandles.iterator().next();
		driver.switchTo().window(newHandle);
		for (WebElement evntSubject : eventSubjects) {
			if (BasePage.verifyDisplayMessage(driver, evntSubject, "Other")) {
				if (BasePage.clickElement(evntSubject, driver)) {
					isSubjectSelected = true;
					break;
				}
			}
		}
		driver.switchTo().window(currentHandle);
		return isSubjectSelected;

	}

	public boolean CreateEvent(WebDriver driver) {
		boolean isNewEventCreated = false;
		BasePage.clickElement(endDateTime, driver);
		BasePage.clickElement(select9PM, driver);
		BasePage.clickElement(saveButton, driver);
		isNewEventCreated = true;
		return isNewEventCreated;
	}

	public boolean VerifyCalenderPageDisplay(WebDriver driver) {

		boolean isCalenderPageVerified = false;
		if (BasePage.verifyElementDisplayed(driver, currentUsername)) {
			BasePage.clickElement(currentDate, driver);
			BasePage.clickElement(time4pm, driver);
			isCalenderPageVerified = true;

		}
		return isCalenderPageVerified;

	}

	public boolean CreateNewEvent(WebDriver driver) {
		boolean isNewEventCreated = false;
		isNewEventCreated = BasePage.clickElement(endDateTime, driver);
		isNewEventCreated = BasePage.clickElement(select7PM, driver);
		isNewEventCreated = BasePage.clickElement(checkboxReoccurance, driver);
		isNewEventCreated = BasePage.clickElement(weeklyRadioButton, driver);
		isNewEventCreated = BasePage.clickElement(selectThursday, driver);
		isNewEventCreated = BasePage.assignInputValue(driver, recurrenceEndDate, "10/24/2023");
		isNewEventCreated = BasePage.clickElement(saveButton, driver);

		return isNewEventCreated;
	}

	public boolean verifyMonthview(WebDriver driver) {

		boolean isSelected = false;
		BasePage.clickElement(monthViewIcon, driver);
		if (BasePage.verifyElementDisplayed(driver, monthview)) {
			isSelected = true;
		}
		return isSelected;

	}

}
