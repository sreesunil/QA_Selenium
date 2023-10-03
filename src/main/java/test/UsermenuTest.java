package test;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.FileConstants;
import pages.BasePage;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonFileUtils;
import utils.CommonUtils;
import listeners.CommonListeners;

@Listeners(CommonListeners.class)
public class UsermenuTest extends BaseTest {

	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}

	@Test(priority = 2)
	public void usermenuDropDown_TC05() throws IOException {

		SoftAssert softAssert = new SoftAssert();

		WebDriver driver = BaseTest.getDriver();
		UserMenuPage ump = new UserMenuPage(driver);
		CommonUtils.waitForElements(driver, ump.userMenu);
		ump.userMenu.click();
		Assert.assertTrue(ump.verifyUserMenuItems(driver), "Failed to verify user menu options");

	}

	// description = "Select My Profile From Usermenu Options"

	@Test(priority = 3)
	public void usermenuDropdown_TC06(Method name) throws IOException, InterruptedException {

		WebDriver driver = BaseTest.getDriver();
		UserMenuPage ump = new UserMenuPage(driver);
		if (!BasePage.verifyElementDisplayed(driver, ump.userMenu))
		{
			Assert.assertTrue(BasePage.clickElement(ump.userMenu, driver), "User Menu Clicke failed");
		}
		// CommonUtils.waitForElements(driver, ump.userMenu);
		// ump.userMenu.click();
		Assert.assertTrue(ump.verifyUserMenuItems(driver), "Failed to verify user menu options");
		Assert.assertTrue(ump.selectMyProfile(), "");
		CommonUtils.waitForElements(driver, ump.profilePage);
		BaseTest.test.info("Profile page selected");
		Assert.assertTrue(ump.isProfilePageVisible(), "");
		ump.selectEditContact(driver);
		Assert.assertTrue(ump.verifyEditContactPopUp(driver), "");
		BaseTest.test.info("Edit Contact Verified");

		BaseTest.test.info("Add screen captured");
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, "Sunil"), "");
		BaseTest.test.info("Lastname change in About Tab verified");
		Assert.assertTrue(ump.verifyCreatePost(driver, ump.message));
		BaseTest.test.info("Verified Post Creation");
		Assert.assertTrue(ump.veryifyFileUpload(driver, FileConstants.FILE_TO_POST));
		BaseTest.test.info("File upload verified");
		Assert.assertTrue(ump.verifyPhotoUpload(driver, FileConstants.PHOTO_TO_UPLOAD));
		BaseTest.test.info("Verified photo upload");

	}

	// @Test(priority=4)
	public void usermenuDropdown_TC07(Method name) throws IOException {

		WebDriver driver = BaseTest.getDriver();
		UserMenuPage ump = new UserMenuPage(driver);
		CommonUtils.waitForElements(driver, ump.userMenu);
		ump.userMenu.click();
		Assert.assertTrue(ump.verifyUserMenuItems(driver), "Failed to verify user menu options");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ump.MySettings), "Failed to Select My settings");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ump.personallink), "");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ump.loginHistorylink), "");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ump.fileDownloadLink), "");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ump.DisplayLayoutlink), "");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ump.CustomizedTab), "");
		Assert.assertTrue(BasePage.dropdownList(ump.customApp, "02uHu000001Htnq"), "");
		Assert.assertTrue(BasePage.dropdownList(ump.Availabletab, "report"), "");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ump.Add), "");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ump.Email));
		Assert.assertTrue(ump.verifyEmail(driver,
				CommonFileUtils.readPropertiesFile(FileConstants.USERMENU_TESTDATA_FILE_PATH, "emailname"),
				CommonFileUtils.readPropertiesFile(FileConstants.USERMENU_TESTDATA_FILE_PATH, "emailaddress")));
		Assert.assertTrue(BasePage.selectMenuItem(driver, ump.CalendarAndReminders));

	}

	// @Test(priority = 3)
	public void userMenuDropdown_08() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		UserMenuPage ump = new UserMenuPage(driver);
		CommonUtils.waitForElements(driver, ump.userMenu);
		ump.userMenu.click();
		Assert.assertTrue(ump.verifyUserMenuItems(driver), "Failed to verify user menu options");
		BaseTest.test.info("Verified Usermenu Items");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ump.DevelopersConsole), "");
		ump.DeveloperConsole(driver);

	}

	// description = "Verify Logout"

	// @Test(priority = 1)
	public void userMenuDropdown_09() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		UserMenuPage ump = new UserMenuPage(driver);
		CommonUtils.waitForElements(driver, ump.userMenu);
		ump.userMenu.click();
		Assert.assertTrue(ump.verifyUserMenuItems(driver), "Failed to verify user menu options");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ump.Logout), "Failed to click LogoutMenu");
		Assert.assertTrue(BasePage.verifyElementDisplayed(driver, ump.loginButton));

	}

}
