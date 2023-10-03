package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.CommonListeners;
import pages.BasePage;
import pages.ContactsPage;
import pages.LoginPage;

@Listeners(CommonListeners.class)
public class ContactsTest extends BaseTest {

	@BeforeClass
	public void navigateToHome() throws IOException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver);
	}

	@Test(description = "Create New Contact")
	public void TastCase25() {

		WebDriver driver = BaseTest.getDriver();
		ContactsPage ctp = new ContactsPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ctp.contactTab), "Failed to navigate to contact page");
		BaseTest.test.info("Contact Page is Displayed");
		Assert.assertTrue(ctp.verifyCreatedNewContact(driver), "Failed to create new contact");
		BaseTest.test.info("New Contact Created");

	}

	// @Test(description = "Create new View in the Contact Page")
	public void TestCase26() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		ContactsPage ctp = new ContactsPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ctp.contactTab), "Failed to navigate to contact page");
		BaseTest.test.info("Contact Page is Displayed");
		Assert.assertTrue(ctp.verifyCreatedNewView(driver), "Failed to create New  ContactView");
		BaseTest.test.info("Created New Contact View ");

	}

	// @Test(description = "Check recently created contact in the Contact Page")
	public void TestCase27() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		ContactsPage ctp = new ContactsPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ctp.contactTab), "Failed to navigate to contact page");
		BaseTest.test.info("Contact Page is Displayed");
		Assert.assertTrue(ctp.verifyRecentlyCreatedContact(driver),"");

	}
	
	//description = "Check My ContactView in the ContactPage"
    @Test(priority = 1)
	public void TestCase28() {
		
		
		

		WebDriver driver = BaseTest.getDriver();
		ContactsPage ctp = new ContactsPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ctp.contactTab), "Failed to navigate to contact page");
		BaseTest.test.info("ContactPage is  Displayed");
		Assert.assertTrue(ctp.SelectMyContactView(driver),"Failed to Select My Contact view");		
		Assert.assertTrue(ctp.verifyMyContactView(driver),"Failed to show My Contact view");
	}
	
	
	//description = "view a Contact in the contact Page"
	@Test(priority = 2)
	public void TestCase29() {
		
		
		
		WebDriver driver = BaseTest.getDriver();
		ContactsPage ctp = new ContactsPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ctp.contactTab), "Failed to navigate to contact page");
		BaseTest.test.info("ContactPage is  Displayed");
		Assert.assertTrue(ctp.selectContactName(driver),"");
		BaseTest.test.info("new Contact name is  Displayed");
		
		
		
		
		
		
	}
	
	//description = "check error Message"
	@Test(priority = 3)
	public void TestCase30() {
		
		
		WebDriver driver = BaseTest.getDriver();
		ContactsPage ctp = new ContactsPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ctp.contactTab), "Failed to navigate to contact page");
		BaseTest.test.info("ContactPage is  Displayed");
		Assert.assertTrue(ctp.checkErrorMessageNewViwLink(driver));
		Assert.assertTrue(BasePage.verifyDisplayMessage(ctp.errorMessage, ctp.errorMsg),"");
		BaseTest.test.info("Error Message is  Displayed");
		
		
	}
      //description ="Craete New View"
	 @Test(priority = 4)
	public void TestCase31() throws IOException {

		WebDriver driver = BaseTest.getDriver();
		ContactsPage ctp = new ContactsPage(driver);
		BaseTest.test.info("LoginPage Displayed");
		Assert.assertTrue(BasePage.selectMenuItem(driver, ctp.contactTab), "Failed to navigate to contact page");
		BaseTest.test.info("ContactPage is  Displayed");
		Assert.assertTrue(ctp.verifyCreateNewView(driver), "");
	}
	 
	 
	// @Test(description = "Check the Save and New Button in new Contact page")
	 public void TestCase32() {
		 
		 
		 
		 WebDriver driver = BaseTest.getDriver();
			ContactsPage ctp = new ContactsPage(driver);
			BaseTest.test.info("LoginPage Displayed");
			Assert.assertTrue(BasePage.selectMenuItem(driver, ctp.contactTab), "Failed to navigate to contact page");
			BaseTest.test.info("ContactPage is  Displayed");
			Assert.assertTrue(ctp.checkNewAndSaveButton(driver),"Failed to create new Contact");
		 
		 
	 }

}
