package test;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.CommonListeners;
import pages.BasePage;
import pages.LeadsPage;
import pages.LoginPage;

@Listeners(CommonListeners.class)
public class LeadsTest extends BaseTest {

	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}
	
	//(description = "Leads Tab ")

	@Test(priority = 2)
	public void TestCase20() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		LeadsPage lds = new LeadsPage(driver);
		Assert.assertTrue(BasePage.selectMenuItem(driver, lds.leadspage), "Failed to navigate Leadspage");

	}
	
	//(description = "Leads Select View")

	@Test(priority = 1)
	public void TestCase21() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		LeadsPage lds = new LeadsPage(driver);
		Assert.assertTrue(BasePage.selectMenuItem(driver, lds.leadspage), "Failed to navigate Leadspage");
		Assert.assertTrue(BasePage.clickElement(lds.leadview, driver));
		Assert.assertTrue(lds.verifyAllLeadsViewItems(), "Failed to verify all Leads view items");

	}
	
	//description = "Default View"
	
    @Test(priority = 3)
	public void TastCase22() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		LeadsPage lds = new LeadsPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, lds.leadspage), "Failed to navigate Leadspage");
		BaseTest.test.info("Navigated to Leads Page");
		Assert.assertTrue(lds.selectLeadsView(driver),"");
		
		 LoginPage lp = new LoginPage(driver);
		 
		  lp.loginToApp(driver); 
		  BaseTest.test.info("Log out and again login to Home Page");
		  Assert.assertTrue(BasePage.selectMenuItem(driver, lds.leadspage), "Failed to navigate Leadspage");
		  BaseTest.test.info("Navigated to Leads Page again");
		  
		  Assert.assertTrue(BasePage.verifyDisplayMessage(driver, lds.leadsviewDropdown, "My Unread Leads"));
		  Assert.assertTrue(BasePage.clickElement(lds.goButton, driver));
		  Assert.assertTrue(BasePage.verifyDisplayMessage(driver, lds.leadsviewDropdown, "My Unread Leads"));
		  BaseTest.test.info("My Unread Leads page displayed");
		  
			

	}
    
    //description = "Select Today's Leads"
    @Test(priority = 4)
    public void TestCase23( ) {
    	
    	

		WebDriver driver = BaseTest.getDriver();
		LeadsPage lds = new LeadsPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, lds.leadspage), "Failed to navigate Leadspage");
		BaseTest.test.info("Navigated to Leads Page");
		Assert.assertTrue(lds.selectTodaysLeadsView(driver),"Failed to click Today's Leads");
		BaseTest.test.info("Today's Leads page is Displayed");
    	
    	
    	
    }
    
    
    //description = "Craeting New Leads"
    @Test(priority = 5)
    public void TestCase24(Method name) {
    	
    	
    	WebDriver driver = BaseTest.getDriver();
		LeadsPage lds = new LeadsPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, lds.leadspage), "Failed to navigate Leadspage");
		Assert.assertTrue(BasePage.selectMenuItem(driver, lds.newButton),"");
		Assert.assertTrue(lds.verifyCreateNewLeads(driver),"Failed to craete new Leads");
    	
    	
    }
    
    
    
}
