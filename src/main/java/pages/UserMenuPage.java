package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.WaitConstants;
import utils.CommonFileUtils;
import utils.CommonUtils;

public class UserMenuPage extends BasePage {

	public UserMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userNavButton")
	public WebElement userNavButton;

	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(xpath = "//div[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;

	@FindBy(xpath = "//a[@title='My Profile']")
	public WebElement MyProfile;

	@FindBy(linkText = "My Settings")
	public WebElement MySettings;

	@FindBy(linkText = "Developer Console")
	public WebElement DevelopersConsole;

	@FindBy(id = "userNav-menuItems/a[4]")
	public WebElement SwitchtoLightningExperience;

	@FindBy(linkText = "Logout")
	public WebElement Logout;

	// My profile
	@FindBy(xpath = "//a[@class='contactInfoLaunch editLink']")
	public WebElement editContactButton;

	@FindBy(xpath = "//div/h2[@id='contactInfoTitle']")
	public WebElement EditProfilePopupwindow;

	@FindBy(id = "aboutTab")
	public WebElement Abouttab;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement Abouttablastname;

	@FindBy(xpath = "//*[@value='Save All']")
	public WebElement saveAllButton;

	@FindBy(xpath = "//*[@id='tailBreadcrumbNode']")
	public WebElement Userprofilepagenamedisplay;

	// Postlink
	@FindBy(css = "#publishereditablearea")
	public WebElement postLink;

	@FindBy(xpath = "/html/body")
	public WebElement postTextArea;

	@FindBy(xpath = "//input[@id='publishersharebutton']")
	public WebElement shareButton;

	// filelink

	@FindBy(xpath = "//*[@id='publisherAttachContentPost']")
	public WebElement filelink;

	@FindBy(xpath = "//a[@id='publisherAttachContentPost']/span[1]")
	public WebElement contentpost;

	@FindBy(css = "#chatterUploadFileAction")
	public WebElement Uploadfile;

	@FindBy(css = "#chatterFile")
	public WebElement Fileopen;

	@FindBy(css = "#publishersharebutton")
	public WebElement publish;

	@FindBy(xpath = "//input[@value='Cancel Upload']")
	public WebElement cancelUpload;

	@FindBy(id = "uploadLink")
	public WebElement updateButton;
	// Photo link

	@FindBy(xpath = "//*[@id=\"publisherAttachLinkPost\"]/span[1]")
	public WebElement photolink;

	@FindBy(id = "j_id0:uploadFileForm:uploadInputFile")
	public WebElement uploadphoto;

	@FindBy(name = "j_id0:uploadFileForm:uploadBtn")
	public WebElement uploadbutton;

	@FindBy(id = "publishersharebutton")
	public WebElement photosharebutton;

	@FindBy(id = "uploadPhotoContentId")
	public WebElement photoUploadIframe;

	@FindBy(xpath = "//input[@id='j_id0:uploadFileForm:uploadBtn']")
	public WebElement photoSaveButton;

	@FindBy(xpath = "//input[@id='j_id0:j_id7:save']")
	public WebElement photoSaveButton2;
	// My Settings
	// personallink

	@FindBy(xpath = "//div[@id = 'PersonalInfo']//a")
	public WebElement personallink;

	@FindBy(xpath = "//*[@id='LoginHistory_font']")
	public WebElement loginHistorylink;

	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement logindisplay;

	@FindBy(id = "contactInfoContentId")
	public WebElement iframeAboutTab;
	// Display&layoutlink

	@FindBy(xpath = "//*[@id='DisplayAndLayout_font']")
	public WebElement DisplayLayoutlink;

	@FindBy(id = "CustomizeTabs_font")
	public WebElement CustomizedTab;

	@FindBy(xpath = "//*[@id='p4']")
	public WebElement customApp;

	@FindBy(xpath = "//*[@id ='duel_select_0']")
	public WebElement Availabletab;

	@FindBy(id = "duel_select_0_right")
	public WebElement Add;

	@FindBy(xpath = "//input[@name='save']")
	public WebElement save;

	@FindBy(id = "tabBar")
	public WebElement tabList;

	// Emaillink
	@FindBy(xpath = "//div[@id = 'EmailSetup']//a")
	public WebElement Email;

	@FindBy(xpath = "//span[@id='EmailSetup_font']")
	public WebElement Emaillink;

	@FindBy(id = "EmailSettings_font")
	public WebElement MyEmailSettings;

	@FindBy(id = "sender_name")
	public WebElement Emailname;

	@FindBy(id = "sender_email")
	public WebElement Emailaddress;

	@FindBy(id = "auto_bcc1")
	public WebElement BCCradiobutton;

	@FindBy(xpath = "//input[@title='Save']")
	public WebElement Saveonemail;

	// Calendar and Remainders
	@FindBy(id = "CalendarAndReminders_font")
	public WebElement CalendarAndReminders;

	@FindBy(xpath = "//*[@id=\"Reminders_font\"]")
	public WebElement ActivityRemainder;

	@FindBy(id = "testbtn")
	public WebElement OpenaTestRemainder;

	@FindBy(xpath = "//*[@id=\"summary\"]")
	public WebElement SampleEventPopup;

	@FindBy(xpath = "//div[@id='photoSection']//img[@class='chatter-photo']")
	public WebElement moderatorButton;

	@FindBy(id = "profileTab_sfdc.ProfilePlatformFeed")
	public WebElement profilePage;

	@FindBy(id = "contactTab")
	public WebElement contactTab;

	@FindBy(xpath = "//div[@class='cxfeeditem feeditem'][1]//p")
	public WebElement firstPostText;

	@FindBy(xpath = "(//*[@class='contentFileTitle'])[1]")
	public WebElement verifyFilePostElement;

	@FindBy(name = "j_id0:waitingForm")
	public WebElement spinnerIcon;

	@FindBy(id = "cropWaitingPage:croppingForm")
	public WebElement spinnerWhileCropping;

	@FindBy(id = "progressIcon")
	public WebElement fileUploadSpinner;

	@FindBy(linkText = "Download login history for last six months, including logins from outside the website, such as API logins (Excel .csv file) »")
	public WebElement fileDownloadLink;

	@FindBy(id = "Login")
	public WebElement loginButton;

	@FindBy(id = "userNav")
	public WebElement userNav;
	/**
	 * This function can be called to select option from user menu options
	 * 
	 * @param driver  Webdriver instance has to be passed
	 * @param sOption Option value eg: "My Profile"
	 * @return {boolean} true if given option is selected else false
	 */

	public boolean SelectOptionFromUserMenuOptions(WebDriver driver, String sOption) {

		boolean isOptionSelected = false;
		if (BasePage.verifyElementDisplayed(driver, userMenu)) {
			BasePage.clickElement(userMenu, driver);
		}

		WebElement userMenuItem = driver.findElement(By.xpath("//*[text()='" + sOption + " ']"));
		if (userMenuItem.isDisplayed()) {
			userMenuItem.click();
			isOptionSelected = true;
		}
		return isOptionSelected;

	}

	/**
	 * This is for verifying usermenu items.
	 * 
	 * @return if all the usermenu items in the list true or else false
	 * 
	 * 
	 */

	public boolean verifyUserMenuItems(WebDriver driver) throws IOException {

		boolean isOptionsVerified = true;
		if (BasePage.verifyElementDisplayed(driver, userNavButton)) {
			String[] expectedUserMenuItems = CommonFileUtils.readUsermenuTestData("usermenuitems").split(",");
		
			for (int i = 0; i < expectedUserMenuItems.length; i++) {
				String actualOption = userMenuOptions.get(i).getText();
				if (expectedUserMenuItems[i].equals(actualOption)) {
					System.out.println("Expected Option: " + expectedUserMenuItems[i] + ", Actual Option: " + actualOption);
				} else {
					logger.warn("UserMenuPage : verifyUserMenuItems : Failed to match the order of usermenu");
					System.out.println("Expected Option: " + expectedUserMenuItems[i]
							+ " failed to match with Actual Option: " + actualOption);
					isOptionsVerified = false;
				}
			}
		}
		return isOptionsVerified;

	}

	public boolean selectMyProfile() throws IOException {

		boolean isSelected = false;
		if (MyProfile.isDisplayed()) {
			MyProfile.click();
			isSelected = true;
		}
		return isSelected;

	}

	public boolean isProfilePageVisible() {
		return profilePage.isDisplayed();
	}

	public void selectEditContact(WebDriver driver) {
		if (CommonUtils.waitForElements(driver, editContactButton)) {
			editContactButton.click();
		}
	}

	public boolean verifyEditContactPopUp(WebDriver driver) throws InterruptedException {
		boolean isContactPopUpVerified = false;

		if (CommonUtils.waitForElements(driver, iframeAboutTab)) {
			driver.switchTo().frame(iframeAboutTab);

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
			System.out.println("UserMenuPage : verifyLastNameChangeInAboutTab : About tab is not visible");
		}
		return isLastNameVerified;
	}

	public boolean verifyCreatePost(WebDriver driver, String sMessageToPost) throws InterruptedException {

		boolean verifyCreatePost = false;
		if (CommonUtils.waitForElements(driver, postLink)) {
			postLink.click();
			driver.switchTo().frame(0);
			postTextArea.sendKeys(sMessageToPost);
			driver.switchTo().parentFrame();
			if (shareButton.isDisplayed()) {
				shareButton.click();

				verifyCreatePost = true;
				if (CommonUtils.waitForElements(driver, firstPostText)) {
					if (firstPostText.isDisplayed()) {
						verifyCreatePost = true;

					}
				}
			}
			return verifyCreatePost;
		}

		return false;
	}

	public String message = "Hello There";

	public boolean veryifyFileUpload(WebDriver driver, String sFilePath) throws InterruptedException {

		boolean isFileUploadSuccess = false;
		if (CommonUtils.waitForElements(driver, filelink)) {
			filelink.click();
			if (CommonUtils.waitForElements(driver, Uploadfile)) {
				Uploadfile.click();
			}
			if (CommonUtils.waitForElements(driver, Fileopen)) {
				Fileopen.sendKeys(sFilePath);
				shareButton.click();
				Thread.sleep(WaitConstants.WAIT_FOR_UPLOAD_TO_FINISH);
				if (CommonUtils.waitForElementsToDisappear(driver, cancelUpload)) {
					if (verifyFilePostElement.isDisplayed()) {
						isFileUploadSuccess = true;

					}

				}

			}
		}
		return isFileUploadSuccess;

	}

	public void clickOnUpdatePhotoButton(WebDriver driver) {

		// CommonUtils.moveToElement(driver, moderatorButton);
		if (moderatorButton.isDisplayed()) {
			moderatorButton.click();
			if (updateButton.isDisplayed()) {
				updateButton.click();
			}
		}
	}

	public boolean verifyPhotoUpload(WebDriver driver, String sPhotoPath) throws InterruptedException {
		boolean isUploadSuccess = false;
		clickOnUpdatePhotoButton(driver);
		driver.switchTo().frame(photoUploadIframe);
		if (CommonUtils.waitForElements(driver, uploadphoto)) {
			uploadphoto.sendKeys(sPhotoPath);
			photoSaveButton.click();

		}
		if (CommonUtils.waitForElementsToDisappear(driver, spinnerIcon)
				&& CommonUtils.waitForElements(driver, photoSaveButton2)) {
			photoSaveButton2.click();
			if (CommonUtils.waitForElementsToDisappear(driver, spinnerWhileCropping)) {
				isUploadSuccess = true;
			}
		}
		driver.switchTo().parentFrame();
		return isUploadSuccess;
	}

	public boolean customizeMyTabs(WebDriver driver) {
		boolean isEmailverified = false;

		isEmailverified = true;
		return isEmailverified;
	}

	public boolean verifyEmail(WebDriver driver, String sName, String sEmailaddress) {

		boolean isEmailverified = false;

		MyEmailSettings.click();

		if (MyEmailSettings.isDisplayed()) {
			Emailname.clear();
			Emailname.sendKeys(sName);
			Emailaddress.clear();
			Emailaddress.sendKeys(sEmailaddress);
			BCCradiobutton.click();
			Saveonemail.click();
			isEmailverified = true;

		}
		return isEmailverified;

	}

	public void DeveloperConsole(WebDriver driver) {
		driver.switchTo().parentFrame();
		driver.quit();

	}

	public boolean verifyLogout(WebDriver driver) {

		boolean isLogoutverified = false;
		String expected = "Login | Salesforce";
		String actual = driver.getTitle();
		System.out.println("Print act: " + actual);
		if (actual.equals(expected)) {
			isLogoutverified = true;

		}
		return isLogoutverified;

	}

}
