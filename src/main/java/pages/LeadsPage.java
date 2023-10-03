package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFileUtils;

public class LeadsPage extends BasePage {

	public LeadsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Lead_Tab")
	public WebElement leadspage;

	@FindBy(xpath = "//*[@id='fcf']/option")
	public List<WebElement> leadsview;

	@FindBy(id = "fcf")
	public WebElement leadview;

	@FindBy(xpath = "//select[@id='fcf']")
	public WebElement leadsSelect;

	@FindBy(id = "userNavLabel")
	public WebElement userMenu;

	@FindBy(linkText = "Logout")
	public WebElement Logout;

	@FindBy(xpath = "//*[@name='fcf']//option[@selected='selected']")
	public WebElement leadsviewDropdown;

	@FindBy(name = "go")
	public WebElement goButton;

	@FindBy(name = "new")
	public WebElement newButton;
	
	@FindBy(xpath = "//h2[@class='pageDescription']")
	public WebElement newLeadsPage;
	
	@FindBy(id = "name_lastlea2")
	public WebElement lastName;
	
	@FindBy(id = "lea3")
	public WebElement companyName;
	
	@FindBy(xpath = "//select[@id='lea13']")
	public WebElement leadStatus;
	
	
	@FindBy(name = "save")
	public WebElement saveButton;
	
	

	public boolean selectAllView(WebDriver driver) {

		boolean isOptionSelected = false;
		WebElement leadsviewItems = driver.findElement(By.xpath("//*[@id='fcf']/option"));
		if (leadsviewItems.isDisplayed()) {
			leadsviewItems.click();
			isOptionSelected = true;

		}
		return isOptionSelected;

	}

	public boolean verifyAllLeadsViewItems() throws IOException {

		System.out.println("Entered verifyAllLeadsViewItems ");
		boolean isOptionsVerified = true;

		String[] expectedleadsviewItems = CommonFileUtils.readLeadsTestData("leadsview").split(",");
		List<String> actualElementText = new ArrayList<String>();
		for (WebElement element : leadsview) {
			actualElementText.add(element.getText());
		}
		for (int i = 0; i < expectedleadsviewItems.length; i++) {
			if (actualElementText.contains(expectedleadsviewItems[i])) {
				System.out.println("Expected Option: " + expectedleadsviewItems[i]);
			} else {
				System.out.println(
						"Expected Option: " + expectedleadsviewItems[i] + "failed to match with Actual Option");

				isOptionsVerified = false;
			}
		}
		return isOptionsVerified;

	}

	public boolean selectLeadsView(WebDriver driver) {

		boolean isLeadsViewSelected = false;
		BasePage.dropdownList(leadsSelect, "00BHu00000GsLM1");
		BasePage.selectMenuItem(driver, userMenu);
		BasePage.selectMenuItem(driver, Logout);
		isLeadsViewSelected = true;

		return isLeadsViewSelected;
	}

	public boolean selectTodaysLeadsView(WebDriver driver) {

		boolean isLeadsViewSelected = false;
		BasePage.dropdownList(leadsSelect, "00BHu00000GsLMF");
		isLeadsViewSelected = true;

		return isLeadsViewSelected;

	}
	
	
	public boolean verifyCreateNewLeads(WebDriver driver) {
		
		boolean isnewLeadsCreated = false;
		if(newLeadsPage.isDisplayed()) {
			
			BasePage.dropdownList(leadStatus, "Open - Not Contacted");
			lastName.click();
			BasePage.assignInputValue(driver, lastName, "Sam");
			BasePage.assignInputValue(driver, companyName, "Target");
			saveButton.click();
			isnewLeadsCreated = true;
		}
		
		
		return isnewLeadsCreated;
		
		
		
	}

}
