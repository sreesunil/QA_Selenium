package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.FileConstants;
import utils.CommonFileUtils;
import utils.CommonUtils;

public class ContactsPage extends BasePage {

	public ContactsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "Contact_Tab")
	public WebElement contactTab;

	@FindBy(name = "new")
	public WebElement newButton;

	@FindBy(id = "name_firstcon2")
	public WebElement firstName;

	@FindBy(id = "name_lastcon2")
	public WebElement lastName;

	@FindBy(id = "con4")
	public WebElement accountName;

	@FindBy(name = "save")
	public WebElement saveButton;

	@FindBy(xpath = "//h2[@class='topName']")
	public WebElement newContactText;

	@FindBy(linkText = "Create New View")
	public WebElement newViewLink;

	@FindBy(id = "fname")
	public WebElement viewName;

	@FindBy(id = "devname")
	public WebElement uniqueViewName;

	@FindBy(xpath = "//*[@name='fcf']//option")
	public List<WebElement> contactViewDropdown;

	@FindBy(name = "cancel")
	public WebElement cancelButton;

	@FindBy(xpath = "//h2[@class='pageDescription']")
	public WebElement contactHomePage;

	@FindBy(xpath = "//select[@id='fcf']")
	public WebElement contactsView;

	@FindBy(xpath = "//table[@class='list']//a")
	public List<WebElement> contactNameList;

	@FindBy(xpath = "//select[@name='fcf']//option[@selected='selected']")
	public WebElement SelectedContactViewItem;

	@FindBy(xpath = "//div[@class='errorMsg']")
	public WebElement errorMessage;

	@FindBy(name = "save_new")
	public WebElement saveAndNewButton;

	public String myContactViewName = "My Contacts";

	public boolean verifyCreatedNewContact(WebDriver driver) {
		boolean isnewContactCreated = false;
		isnewContactCreated = BasePage.clickElement(newButton, driver);
		isnewContactCreated = BasePage.assignInputValue(driver, lastName, "Poster");
		isnewContactCreated = BasePage.assignInputValue(driver, accountName, "BMW");
		saveButton.click();

		isnewContactCreated = BasePage.verifyDisplayMessage(driver, newContactText, "Poster");

		return isnewContactCreated;

	}

	public boolean verifyCreatedNewView(WebDriver driver) throws IOException {

		boolean isnewViewnameCreated = false;
		BasePage.selectMenuItem(driver, newViewLink);
		BasePage.assignInputValue(driver, viewName,
				CommonFileUtils.readPropertiesFile(FileConstants.CONTACTS_TESTDATA_FILE_PATH, "viewname"));
		BasePage.assignInputValue(driver, uniqueViewName,
				CommonFileUtils.readPropertiesFile(FileConstants.CONTACTS_TESTDATA_FILE_PATH, "uniquename"));
		BasePage.clickElement(saveButton, driver);
		isnewViewnameCreated = true;

		return isnewViewnameCreated;

	}

	public boolean verifyRecentlyCreatedContact(WebDriver driver) throws IOException {

		boolean isRecentltcreatedcontactItem = false;

		if (BasePage.verifyElementDisplayed(driver, contactsView)) {
			for (WebElement element : contactViewDropdown) {

				if (element.getText().equals(
						CommonFileUtils.readPropertiesFile(FileConstants.CONTACTS_TESTDATA_FILE_PATH, "viewname"))) {
					isRecentltcreatedcontactItem = true;
					break;
				}
			}
		}

		return isRecentltcreatedcontactItem;

	}

	public boolean verifyCreateNewView(WebDriver driver) throws IOException {

		boolean isnewViewnameCreated = false;
		BasePage.selectMenuItem(driver, newViewLink);
		BasePage.assignInputValue(driver, viewName,
				CommonFileUtils.readPropertiesFile(FileConstants.CONTACTS_TESTDATA_FILE_PATH, "viewName"));
		BasePage.assignInputValue(driver, uniqueViewName,
				CommonFileUtils.readPropertiesFile(FileConstants.CONTACTS_TESTDATA_FILE_PATH, "uniqueName"));
		BasePage.clickElement(cancelButton, driver);
		if (contactHomePage.isDisplayed()) {
			isnewViewnameCreated = true;
		}
		return isnewViewnameCreated;

	}

	public boolean selectContactName(WebDriver driver) {

		boolean isSelected = false;

		isSelected = BasePage.verifyElementDisplayed(driver, contactHomePage);
		if (contactNameList.size() > 0) {
			WebElement contactLink = contactNameList.get(0);
			String ContactNameText = contactLink.getText();
			if (BasePage.clickElement(contactLink, driver)) {
				isSelected = BasePage.verifyDisplayMessage(driver, newContactText, ContactNameText);
			}

		}

		return isSelected;

	}

	public boolean SelectMyContactView(WebDriver driver) {

		boolean isSelected = false;
		if (BasePage.verifyElementDisplayed(driver, contactsView)) {
			for (WebElement element : contactViewDropdown) {

				if (element.getText().equals(myContactViewName)) {
					isSelected = BasePage.clickElement(element, driver);
					break;
				}
			}
		}
		return isSelected;
	}

	public boolean verifyMyContactView(WebDriver driver) {
		boolean isSelected = false;
		System.out.println("Inside verifyMyContactView: " + SelectedContactViewItem.getText());
		if (BasePage.verifyDisplayMessage(driver, SelectedContactViewItem, myContactViewName)) {
			isSelected = true;
		}

		return isSelected;
	}

	public String errorMsg = "Error: You must enter a value";

	public boolean checkErrorMessageNewViwLink(WebDriver driver) {

		boolean isErrorMessageCheck = false;
		BasePage.selectMenuItem(driver, newViewLink);
		BasePage.assignInputValue(driver, uniqueViewName, "EFGH");
		BasePage.clickElement(saveButton, driver);

		isErrorMessageCheck = true;

		return isErrorMessageCheck;
	}

	public boolean checkNewAndSaveButton(WebDriver driver) {

		boolean isNewAndSaveverified = false;
		if (BasePage.clickElement(newButton, driver)) {
			if (BasePage.verifyElementDisplayed(driver, contactHomePage)) {
				isNewAndSaveverified = BasePage.assignInputValue(driver, lastName, "Indian");
				isNewAndSaveverified = BasePage.assignInputValue(driver, accountName, "Global Media");
				isNewAndSaveverified = BasePage.clickElement(saveAndNewButton, driver);

			}
		}
		return isNewAndSaveverified;

	}
}
	
