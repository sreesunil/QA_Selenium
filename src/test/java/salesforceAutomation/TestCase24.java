package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase24 {

     @Test
	public void testing() throws InterruptedException {
		
		ChromeDriver driver =   Reusablecodes.SalesforceLogin();
		Thread.sleep(4000);
		
		//selecting leads tab
		driver.findElement(By.id("Lead_Tab")).click();
		
		//Checking Result
		
		String expected = "Leads: Home ~ Salesforce - Developer Edition";
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		
		System.out.println("Leads Homepage displayed");
		
		// To create new Leads
		
		driver.findElement(By.xpath("//input[@title ='New']")).click();
		
		
     }

}
