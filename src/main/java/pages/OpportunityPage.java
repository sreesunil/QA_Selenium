package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonFileUtils;

public class OpportunityPage extends BasePage {

	public OpportunityPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Opportunities")
	public WebElement opportunities;

	@FindBy(xpath = "//h2[@class='pageDescription']")
	public WebElement opportunityHomepage;

	@FindBy(id = "fcf")
	public WebElement Allopportunities;

	@FindBy(xpath = "//*[@id='fcf']//option")
	public List<WebElement> opportunityOptions;

	@FindBy(name = "new")
	public WebElement newButton;

	@FindBy(id = "opp3")
	public WebElement opportunityName;

	@FindBy(id = "opp4")
	public WebElement accountName;

	@FindBy(id = "opp9")
	public WebElement closeDate;

	@FindBy(id = "opp11")
	public WebElement stage;

	@FindBy(id = "opp6")
	public WebElement leadSource;

	@FindBy(name = "save")
	public WebElement save;

	

	@FindBy(linkText = "Opportunity Pipeline")
	public WebElement opportunittyPipeline;

	@FindBy(linkText = "Stuck Opportunities")
	public WebElement stuckOpportunities;

	@FindBy(xpath = "//select[@id='quarter_q']")
	public WebElement valuesIntervel;

	@FindBy(xpath = "//select[@id='open']")
	public WebElement allOpportunitiesInclude;

	@FindBy(xpath = "//input[@title='Run Report']")
	public WebElement runReport;

	public boolean selectAllOpportunities(WebDriver driver) {

		boolean isAllOpportunitieselected = false;
		if (BasePage.verifyElementDisplayed(driver, opportunityHomepage)) {
			BasePage.clickElement(Allopportunities, driver);
			isAllOpportunitieselected = true;
		}

		return isAllOpportunitieselected;

	}

	public boolean verifyAllopportunitiesItems() throws IOException {

		System.out.println("Entered verifyAllopportunitiesItems ");
		boolean isOptionsVerified = true;
		String[] expectedallOpportunityItems = CommonFileUtils.readOppertunityTestData("allOpportunities").split(",");
		List<String> actualElementText = new ArrayList<String>();
		for (WebElement element : opportunityOptions) {
			actualElementText.add(element.getText());
		}

		for (int i = 0; i < expectedallOpportunityItems.length; i++) {
			if (actualElementText.contains(expectedallOpportunityItems[i])) {
				System.out.println("Expected Option: " + expectedallOpportunityItems[i]);
			} else {
				logger.info("OpportunityPage :verifyAllopportunitiesItems : Failed To Match Opportunity Items ");

				System.out.println(
						"Expected Option: " + expectedallOpportunityItems[i] + "failed to match with Actual Option");

				isOptionsVerified = false;
			}
		}
		return isOptionsVerified;

	}

	public boolean verifyNewEditOpportunity(WebDriver driver) {

		boolean isNeweditOpportunityVerified = false;
		BasePage.clickElement(newButton, driver);
		if (BasePage.verifyElementDisplayed(driver, opportunityHomepage)) {
			isNeweditOpportunityVerified = BasePage.assignInputValue(driver, opportunityName, "Base");
			
			isNeweditOpportunityVerified = BasePage.assignInputValue(driver, accountName, "Clerk");
			isNeweditOpportunityVerified = BasePage.dropdownList(leadSource, "Phone Inquiry");

			
			
			isNeweditOpportunityVerified = BasePage.assignInputValue(driver, closeDate, "10/29/2023");
			
			isNeweditOpportunityVerified = BasePage.dropdownList(stage, "Prospecting");
			save.click();
		}

		return isNeweditOpportunityVerified;

	}

	public boolean verifyQuarterlySummeryLink(WebDriver driver) {

		boolean isQuarterlySummeryLinkverified = false;

		BasePage.dropdownList(valuesIntervel, "current");
		BasePage.dropdownList(valuesIntervel, "next1");
		BasePage.dropdownList(allOpportunitiesInclude, "open");
		BasePage.dropdownList(allOpportunitiesInclude, "closed");
		runReport.click();
		logger.info("OpportunityPage :verifyQuarterlySummeryLink : SummeryLink ");
		isQuarterlySummeryLinkverified = true;
		return isQuarterlySummeryLinkverified;

	}

}
