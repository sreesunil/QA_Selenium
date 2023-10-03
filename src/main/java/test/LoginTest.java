package test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import constants.FileConstants;
import pages.BasePage;
import pages.LoginPage;
import pages.UserMenuPage;
import utils.CommonFileUtils;
import utils.CommonUtils;

public class LoginTest extends BaseTest {

	@Test(priority = 2)
	public void loginTest1() throws IOException {

		WebDriver driver = BaseTest.getDriver();

		LoginPage lp = new LoginPage(driver);
		driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		lp.username.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));

		lp.password.clear();

		lp.loginButton.click();
		Assert.assertTrue(BasePage.verifyDisplayMessage(lp.errorMessage, lp.missingPasswordMessage), "Error");
	}

	@BeforeClass
	public void loginTest() throws InvalidFormatException, IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);

		lp.loginToApp(driver);

	}

	@Test(priority = 1)
	public void loginTest2() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(BasePage.verifyDisplayMessage(lp.homeTab, "Home"));

	}

	// description = "Check RememberMe"

	@Test(priority = 5)
	public void LoginTest03(Method name) throws IOException {

		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);

		driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		Assert.assertTrue(lp.selectRememberMeCheckBox(), "");
		lp.username.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
		lp.password.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
		lp.loginButton.click();

		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.verifyDisplayMessage(lp.homeTab, "Home"));
		CommonUtils.waitForElements(driver, ump.userMenu);
		ump.userMenu.click();
		Assert.assertTrue(ump.verifyUserMenuItems(driver), "Failed to verify user menu options");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ump.Logout), "Failed to click LogoutMenu");

	}

	// (description = "Forgot Password")
	@Test(priority = 3)
	public void LoginTest04A() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		lp.username.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
		Assert.assertTrue(BasePage.selectMenuItem(driver, lp.ForgotPassword),
				"Failed to click Forgot your Password Link");
		lp.forgotUsername
				.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
		Assert.assertTrue(BasePage.selectMenuItem(driver, lp.Continue),
				"Failed to verify message : reset your password ");
	}

	@Test(priority = 4)
	public void LoginTest04B() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
		lp.username.sendKeys("123");
		lp.password.sendKeys("22131");
		lp.loginButton.click();
		Assert.assertTrue(BasePage.verifyDisplayMessage(lp.errorMessage, lp.checkCredentialMessage));
	}

	/*
	 * // @Test(priority =3) public void loginTest03() throws
	 * InvalidFormatException, IOException { WebDriver driver =
	 * BaseTest.getDriver(); LoginPage lp = new LoginPage(driver);
	 * 
	 * driver.get(CommonFileUtils.readPropertiesFile(FileConstants.
	 * LOGIN_TESTDATA_FILE_PATH2, "prod.url"));
	 * lp.username.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.
	 * LOGIN_TESTDATA_FILE_PATH2, "username"));
	 * lp.password.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.
	 * LOGIN_TESTDATA_FILE_PATH2, "password"));
	 * 
	 * Assert.assertEquals(lp.selectRememberMeCheckBox(), "");
	 * 
	 * lp.loginButton.click();
	 */

}
