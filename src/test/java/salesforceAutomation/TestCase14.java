package salesforceAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class TestCase14 {

	
	public static void main(String[] args) throws InterruptedException {
		
		  FirefoxDriver driver = Reusablecodes.SalesforceLoginfirefox();
		   driver.manage().window().maximize();
			
		   driver.findElement(By.id("Account_Tab")).click();
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		   
		   // for go to accounts
		   driver.findElement(By.id("Account_Tab")).click();
			
	       String expected = "Accounts: Home ~ Salesforce - Developer Edition";
	       String actual = driver.getTitle();
	       
	       if(actual.equals(expected)) {
	    	   System.out.println("Passed");
	       }else {
	    	   System.out.println("Failed");
	       }
	       System.out.print("Accout Page is displayed");
	       
	       
	      // To create Account Report
	       
	       driver.findElement(By.linkText("Accounts with last activity > 30 days")).click();
	       
	       
	       WebElement dropdown = driver.findElement(By.id("ext-gen20"));
	       dropdown.click();
	       Thread.sleep(2000);
	       WebElement createddate = driver.findElement(By.linkText("Created Date"));
	       createddate.click();
	       driver.findElement(By.id("ext-comp-1042")).sendKeys("8/25/2023");
	       driver.findElement(By.id("ext-gen49")).click();
	       
	       
	       WebElement reportname =driver.findElement(By.id("saveReportDlg_reportNameField"));
	       reportname.clear();
	    	reportname.sendKeys("Urg Repots");
	    	WebElement uniqreportname = driver.findElement(By.id("saveReportDlg_DeveloperName"));
	    	uniqreportname.click();
	       Thread.sleep(4000);
	       driver.findElement(By.xpath("//table[@id='dlgSaveAndRun']")).click();
	       
	       String expected1 = "My reports";
	       String actual1 = driver.findElement(By.linkText("My Reports")).getText();
	       
	       String expectedtext = "Urg Repots ~ Salesforce - Developer Edition";
	       String actualtext = driver.getTitle();
	       
	       if(actualtext.contains(expectedtext)) {
	    	   System.out.println("Report page is Displayed");
	       }else {
	    	   System.out.println("Report page is not Displayed\n");
	       }
	       
		

	}      
}
