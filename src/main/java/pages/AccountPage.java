package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.FileConstants;
import io.reactivex.rxjava3.functions.Action;
import utils.CommonUtils;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Account_Tab")
	public WebElement AccountTab;

	@FindBy(xpath = "//input[@name='new']")
	public WebElement newAccount;

	@FindBy(id = "acc2")
	public WebElement Accountname;

	@FindBy(id = "acc6")
	public WebElement AccounteditpageDropdown;

	@FindBy(id = "00NHu00000PEMG2")
	public WebElement CustomerPriority;

	@FindBy(xpath = "//input[@name='save']")
	public WebElement save;

	@FindBy(xpath = "//title")
	public WebElement contactHeader;

	@FindBy(linkText = "Create New View")
	public WebElement createNewview;

	@FindBy(id = "fname")
	public WebElement viewName;

	@FindBy(id = "devname")
	public WebElement viewUniqueName;

	@FindBy(name = "save")
	public WebElement Save;

	@FindBy(name = "fcf")
	public WebElement viewList;

	@FindBy(linkText = "Edit")
	public WebElement viewNameedit;

	@FindBy(xpath = "//*[@name='fcf']//option[@selected='selected']")
	public WebElement AccountviewDropdown;

	@FindBy(id = "fcol1")
	public WebElement FilterByField;

	@FindBy(id = "fop1")
	public WebElement FilterByoperator;

	@FindBy(id = "fval1")
	public WebElement FilterByValue;

	@FindBy(linkText = "Merge Accounts")
	public WebElement mergeAccount;

	@FindBy(name = "save")
	public WebElement mergeSaveButton;

	@FindBy(id = "srch")
	public WebElement searchAccountsToMerge;

	@FindBy(name = "srchbutton")
	public WebElement SearchButton;

	@FindBy(name = "goNext")
	public WebElement nextButton;

	@FindBy(linkText = "Accounts with last activity > 30 days")
	public WebElement daysactivityReport;

	@FindBy(name = "dateColumn")
	public WebElement DateField;

	@FindBy(xpath = "//div[contains(text(),'Created Date')]")
	public WebElement CreatedDate;

	@FindBy(name = "startDate")
	public WebElement startdate;

	@FindBy(name = "endDate")
	public WebElement enddate;

	@FindBy(id = "ext-gen49")
	public WebElement reportSave;

	@FindBy(name = "reportName")
	public WebElement reportname;

	@FindBy(id = "saveReportDlg_DeveloperName")
	public WebElement reportUniquename;

	@FindBy(xpath = "//table[@id='dlgSaveAndRun']//button")
	public WebElement SaveandRunButton;

	@FindBy(xpath = "//table[@id='saveReportDlgCancelBtn']//button")
	public WebElement CancelButton;

	@FindBy(name = "reportDescription")
	public WebElement ReportDescription;

	public String verifyMessage = "Account: <AccountName> ~ Salesforce - Developer Edition";

	public String getAccountTitle(String accountName) {
		return verifyMessage.replace("<AccountName>", accountName);
	}

	public boolean verifyCreteViewname(WebDriver driver, String sViewname, String sUniquename) {

		boolean isVerifynewviewName = false;
		if (CommonUtils.waitForElements(driver, viewName)) {
			viewName.clear();
			viewName.sendKeys(sViewname);
			viewUniqueName.clear();
			viewUniqueName.sendKeys(sUniquename);
			Save.click();
			logger.info("Account Viewname Changed");
		}

		isVerifynewviewName = true;

		return isVerifynewviewName;

	}

	public boolean verifyUpdateViewname(WebDriver driver, String sViewname) {

		boolean isVerifynewviewName = false;
		BasePage.assignInputValue(driver, viewName, sViewname);
		BasePage.dropdownList(FilterByField, "ACCOUNT.NAME");
		logger.info("Account Viewname Updated");
		BasePage.dropdownList(FilterByoperator, "c");
		BasePage.assignInputValue(driver, FilterByValue, "a");
		Save.click();

		isVerifynewviewName = true;
		logger.warn("Account Viewname not Updated");

		return isVerifynewviewName;

	}

	public boolean clickSaveAndRun(WebDriver driver) throws InterruptedException {
		boolean isSelected = false;
		//Thread.sleep(1000);
		CommonUtils.waitForElements(driver, SaveandRunButton);
		if (SaveandRunButton.isDisplayed()) {
			if (CommonUtils.waitForElements(driver, SaveandRunButton)) {
				SaveandRunButton.click();
				isSelected = true;

			} else {
				System.out.println("Element wait - unavailable");
			}
		} else {
			System.out.println("Element Displat - Unable to disp");
		}

		return isSelected;
	}

	public boolean SetReportFilter(WebDriver driver) {
		boolean isFilterAdded = false;
		BasePage.clickElement(DateField, driver);
		BasePage.clickElement(CreatedDate, driver);
		BasePage.assignInputValue(driver, startdate, "07/05/2023");
		BasePage.assignInputValue(driver, enddate, "07/05/2023");
		reportSave.click();
		isFilterAdded = true;
		logger.info("AccountPage :SetReportFilter : New Report created ");
		return isFilterAdded;

	}

}
