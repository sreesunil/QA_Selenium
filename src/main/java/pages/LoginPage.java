package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.FileConstants;
import utils.CommonFileUtils;
import utils.CommonUtils;

public class LoginPage extends BasePage{
	
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(id = "error")
	public WebElement errorMessage;
	
	@FindBy(id = "rememberUn")
	public  WebElement rememberMe;
	
	@FindBy(id = "idcard-identity")
	public WebElement savedUsername;

	@FindBy(id = "un")
	public WebElement forgotUsername;

	@FindBy(xpath = "//a[text()='Return to Login']")
	public WebElement returnToLoginButton;
	
	@FindBy(id = "home_Tab")
	public WebElement homeTab;
	
	@FindBy(linkText = "Forgot Your Password?")
	public WebElement ForgotPassword;
	
	@FindBy(id = "continue")
	public WebElement Continue;
	
	
	public String checkCredentialMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
    public String missingPasswordMessage = "Please enter your password.";
	
	
	
	  public  boolean selectRememberMeCheckBox() { 
		  logger.info("LoginPage : selectRememberMeCheckBox : Started ");
		  boolean isSelected = false;
	  
		if(!rememberMe.isSelected()) {
			rememberMe.click(); 
			isSelected = true; 
	}
		 logger.info("LoginPage : selectRememberMeCheckBox : Ended ");
	  return isSelected;
	  }
	 
	
	public void loginToApp(WebDriver driver) throws IOException {
		  driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url")); driver.manage().window().maximize();
		  logger.info("LoginPage : loginToApp : started");
		  if(CommonUtils.waitForElements(driver, username)) {
			  username.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
			  password.sendKeys(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password")); 
			  loginButton.click(); 
			  logger.info("LoginPage : LoginToApp : Closed ");
		  }
		 
	}
	
	public boolean verifyRememberMe(WebDriver driver) throws IOException {
		
		boolean isRemembermeSelected = false;
		
		driver.get(CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "prod.url")); driver.manage().window().maximize();
		  logger.info("LoginPage : loginToApp : started");
		  BasePage.assignInputValue(driver, username, CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "username"));
		  BasePage.assignInputValue(driver, password, CommonFileUtils.readPropertiesFile(FileConstants.LOGIN_TESTDATA_FILE_PATH2, "password"));
		  BasePage.clickElement(rememberMe, driver);
		  BasePage.clickElement(loginButton, driver);
		  
		  isRemembermeSelected = true;
		
		return isRemembermeSelected;
		
		
	}
	
	
	

}
