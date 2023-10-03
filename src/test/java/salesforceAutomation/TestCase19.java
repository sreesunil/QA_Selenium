package salesforceAutomation;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase19 {
	

	 @Test
		public void loginTest() throws InterruptedException, AWTException {
	    	 
	    	 FirefoxDriver driver = Reusablecodes.SalesforceLoginfirefox();
	    	 
			System.out.println("Login  is Successfull");
	         Thread.sleep(4000);
			//for Opportunity page display
			driver.findElement(By.linkText("Opportunities")).click();
			String expected = "Opportunities: Home ~ Salesforce - Developer Edition";
			String actual = driver.getTitle();
			System.out.println(actual);
			Assert.assertEquals(actual, expected);
			
			WebElement currentfq = driver.findElement(By.id("quarter_q"));
			currentfq.click();
			
			
	 }
			

}
