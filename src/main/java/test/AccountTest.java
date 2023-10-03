package test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.FileConstants;
import pages.AccountPage;
import pages.BasePage;
import pages.LoginPage;
import utils.CommonFileUtils;
import listeners.CommonListeners;

@Listeners(CommonListeners.class)
public class AccountTest extends BaseTest {

	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}

	// @Test(description = "Create an account")
	public void TestCase10() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		AccountPage ap = new AccountPage(driver);
		Assert.assertTrue(BasePage.selectMenuItem(driver, ap.AccountTab), "");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ap.newAccount), "");
		Assert.assertTrue(BasePage.assignInputValue(driver, ap.Accountname,
				CommonFileUtils.readPropertiesFile(FileConstants.ACCOUNT_DATA_PATH, "accountname")));
		Assert.assertTrue(BasePage.dropdownList(ap.AccounteditpageDropdown,
				CommonFileUtils.readPropertiesFile(FileConstants.ACCOUNT_DATA_PATH, "type")));
		Assert.assertTrue(BasePage.dropdownList(ap.CustomerPriority,
				CommonFileUtils.readPropertiesFile(FileConstants.ACCOUNT_DATA_PATH, "priority")));
		ap.save.click();
		Assert.assertTrue(BasePage.validateTitle(driver,
				ap.getAccountTitle(CommonFileUtils.readPropertiesFile(FileConstants.ACCOUNT_DATA_PATH, "accountname"))));

	}

	//@Test(description ="Create new View")
	public void TestCase11() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		AccountPage ap = new AccountPage(driver);
		Assert.assertTrue(BasePage.selectMenuItem(driver, ap.AccountTab), "");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ap.createNewview), "");
		Assert.assertTrue(ap.verifyCreteViewname(driver,
				CommonFileUtils.readPropertiesFile(FileConstants.ACCOUNT_DATA_PATH, "viewname"),
				CommonFileUtils.readPropertiesFile(FileConstants.ACCOUNT_DATA_PATH, "uniquename")));
		BaseTest.test.info("New view name and unique name Created");
		Assert.assertTrue(BasePage.verifyDisplayMessage(driver, ap.AccountviewDropdown,
				CommonFileUtils.readPropertiesFile(FileConstants.ACCOUNT_DATA_PATH, "viewname")));

	}

	//@Test
	public void Testcase12() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		AccountPage ap = new AccountPage(driver);
		Assert.assertTrue(BasePage.selectMenuItem(driver, ap.AccountTab), "");
		BaseTest.test.info("Account page selected");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ap.viewNameedit));
		Assert.assertTrue(ap.verifyUpdateViewname(driver,
				CommonFileUtils.readPropertiesFile(FileConstants.ACCOUNT_DATA_PATH, "newviewname")));

	}

	// @Test(description = "Merging Accounts")
	public void TestCase13() throws IOException, InterruptedException {

		WebDriver driver = BaseTest.getDriver();
		AccountPage ap = new AccountPage(driver);
		Assert.assertTrue(BasePage.selectMenuItem(driver, ap.AccountTab), "");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ap.mergeAccount), "Failed to Merge");
		Assert.assertTrue(BasePage.assignInputValue(driver, ap.searchAccountsToMerge,
				CommonFileUtils.readPropertiesFile(FileConstants.ACCOUNT_DATA_PATH, "accountnametomerge")));
		Assert.assertTrue(BasePage.selectMenuItem(driver, ap.SearchButton));
		Assert.assertTrue(BasePage.selectMenuItem(driver, ap.nextButton));
		Assert.assertTrue(BasePage.selectMenuItem(driver, ap.mergeSaveButton));
		Assert.assertTrue(ap.clickSaveAndRun(driver));
		BaseTest.test.info("Accounts Merged");
		
	}

	@Test(description = " Create account report")
	public void TestCase14() throws IOException, InterruptedException {

		WebDriver driver = BaseTest.getDriver();
		AccountPage ap = new AccountPage(driver);
		Assert.assertTrue(BasePage.selectMenuItem(driver, ap.AccountTab), "");
		BasePage.selectMenuItem(driver, ap.daysactivityReport);
		BaseTest.test.info("Selected To Update repotactivity");
		Assert.assertTrue(ap.SetReportFilter(driver),"");
		Assert.assertTrue(BasePage.assignInputValue(driver, ap.reportname, CommonFileUtils.readPropertiesFile(FileConstants.ACCOUNT_DATA_PATH, "reportname")));
		Assert.assertTrue(BasePage.assignInputValue(driver, ap.reportUniquename, CommonFileUtils.readPropertiesFile(FileConstants.ACCOUNT_DATA_PATH, "reportuniquename")));
			
		Assert.assertTrue(ap.clickSaveAndRun(driver),"Failed to Click the button");
		//Assert.assertTrue(BasePage.clickElement(ap.SaveandRunButton, driver));
	 
	
		BaseTest.test.info("New Report Saved");

	}
}
