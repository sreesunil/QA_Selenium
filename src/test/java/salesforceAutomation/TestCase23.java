package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TestCase23 {


    public static void main(String []args) throws InterruptedException {
 
		
		ChromeDriver driver =   Reusablecodes.SalesforceLogin();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		//selecting leads tab
		driver.findElement(By.id("Lead_Tab")).click();
		

		//Checking Result
		
		String expected = "Leads: Home ~ Salesforce - Developer Edition";
		
		String actual = driver.getTitle();
		
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		
		System.out.println("Leads Homepage displayed");
		
    }	

}
