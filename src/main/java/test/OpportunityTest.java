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
import pages.LoginPage;
import pages.OpportunityPage;

@Listeners(CommonListeners.class)
public class OpportunityTest extends BaseTest {

	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}
   // (description = "dropdown all opportunities")
	@Test(priority = 1)
	public void TestCase15() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		OpportunityPage opt = new OpportunityPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, opt.opportunities), " Failed to click Opportunity tab");
		BaseTest.test.info("Opportunity page is Displayed");
		Assert.assertTrue(opt.selectAllOpportunities(driver),"");
		Assert.assertTrue(opt.verifyAllopportunitiesItems(),"");
		BaseTest.test.info("Verified all Opportunity items");

	}

	@Test(priority =2)
	public void TestCase16() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		OpportunityPage opt = new OpportunityPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, opt.opportunities), " Failed to click Opportunity tab");
		BaseTest.test.info("Opportunity page is Displayed");
		Assert.assertTrue(opt.verifyNewEditOpportunity(driver));

	}
	
	//(description = "Test Opportunity PipelineReport")
	
	@Test(priority = 3)
	public void TestCase17(Method name) {
		
		
		
		WebDriver driver = BaseTest.getDriver();
		OpportunityPage opt = new OpportunityPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, opt.opportunities), " Failed to click Opportunity tab");
		Assert.assertTrue(BasePage.selectMenuItem(driver, opt.opportunittyPipeline),"Failed to Display Pipeline Report");
		
		
		
	}
	
	
	//description = "Test Stuck Opportunity Report"
	
	@Test(priority = 4)
	public void TestCase18() {
		
		
		
		WebDriver driver = BaseTest.getDriver();
		OpportunityPage opt = new OpportunityPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, opt.opportunities), " Failed to click Opportunity tab");
		BaseTest.test.info("Opportunity Page displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, opt.stuckOpportunities),"Failed to click on Stuck Opportunity ");
		BaseTest.test.info("Stuck Opportunity Page displayed");
			
		
	}
	
	
	
	//@Test(description = "Test Quarterly Summery Report")
	public void TestCase19() {
		
		
		WebDriver driver = BaseTest.getDriver();
		OpportunityPage opt = new OpportunityPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, opt.opportunities), " Failed to click Opportunity tab");
		BaseTest.test.info("Opportunity Page Displayed");
		Assert.assertTrue(opt.verifyQuarterlySummeryLink(driver),"");
		BaseTest.test.info("Quaterly Summery Report Created ");
		
		
		
	}

}
