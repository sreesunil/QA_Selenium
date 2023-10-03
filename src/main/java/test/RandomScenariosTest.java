package test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.CommonListeners;
import pages.BasePage;
import pages.LoginPage;
import pages.RandomScenariosPage;

@Listeners(CommonListeners.class)
public class RandomScenariosTest extends BaseTest{
	
	
	
	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}
	
	//@Test
	public void TestCase33(){
		
		WebDriver driver = BaseTest.getDriver();
		RandomScenariosPage rsp = new RandomScenariosPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, rsp.homeTab),"");
		Assert.assertTrue(rsp.verifyUsername(driver),"");
	}
	
	
	
	//(description = "Edit Profile LastName")
	//@Test(priority = 2)
	public void TestCase34() throws InterruptedException {
		
		
		WebDriver driver = BaseTest.getDriver();
		RandomScenariosPage rsp = new RandomScenariosPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, rsp.homeTab));
		BaseTest.test.info("Home Page is Displayed");
		Assert.assertTrue(rsp.selectEditContact(driver),"Failed to select Edit contact");
		Assert.assertTrue(rsp.verifyEditContactPopUp(driver),"");
		Assert.assertTrue(rsp.verifyLastNameChangeInAboutTab(driver, "Sunil"));
		
		
	}
	
	//(description = "Verify the Tab Customization ")
	
	//@Test (priority = 3)
	public void TestCase35() throws IOException {
		
		
		WebDriver driver = BaseTest.getDriver();
		RandomScenariosPage rsp = new RandomScenariosPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(rsp.verifySelectCustomization(driver),"");
		BaseTest.test.info("Navigete to Customize My Tab");
		Assert.assertTrue(rsp.verifySelectTabs(driver),"Failed to Select");
		BaseTest.test.info("Verified select Tabs");
		Assert.assertTrue(rsp.verifyLogOut(driver),"Failed to LogOut");
		BaseTest.test.info("Logout");
		Assert.assertTrue(rsp.verifyLaunchAndLogin(driver),"Failed to Login");
		
		
		
	}
	
	//@Test(description = "Blocking an Event in the Calender")
	public void TestCase36() {
		
		

		WebDriver driver = BaseTest.getDriver();
		RandomScenariosPage rsp = new RandomScenariosPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, rsp.homeTab));
		BaseTest.test.info("Home Page is Displayed");
		Assert.assertTrue(rsp.VerifyCalenderPageDisplayed(driver),"");
		BaseTest.test.info("Calender page is Displayed");
		Assert.assertTrue(rsp.SelectSubject( driver),"");
		Assert.assertTrue(rsp.CreateEvent( driver),"");
		BaseTest.test.info("New Event is Created");
	}
	
	
	@Test(description = "Blocking an event in the ")
	public void TestCase37() {
		
		

		WebDriver driver = BaseTest.getDriver();
		RandomScenariosPage rsp = new RandomScenariosPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, rsp.homeTab));
		BaseTest.test.info("Home Page is Displayed");
		Assert.assertTrue(rsp.VerifyCalenderPageDisplay(driver),"");
		BaseTest.test.info("Calender page is Displayed");
		Assert.assertTrue(rsp.SelectSubject( driver),"");
		Assert.assertTrue(rsp.CreateNewEvent(driver),"Failed to create New Evenet");
		BaseTest.test.info("New Evenet is Created");
		Assert.assertTrue(rsp.verifyMonthview(driver),"Faild to open Calender");
		BaseTest.test.info("Calender is Displayed");
		
		
		
	}
	
	
	
	
	
	

}
