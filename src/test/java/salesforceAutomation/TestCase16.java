package salesforceAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase16 {

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
			
			//To create new Opportunity
			Thread.sleep(4000);
			driver.findElement(By.name("new")).click();
			Thread.sleep(2000);
			  
	        Robot r = new Robot();
	        driver.findElement(By.id("opp3")).sendKeys("Shine");
	        driver.findElement(By.id("opp4")).sendKeys("abc");
	        
	        r.keyPress(KeyEvent.VK_ENTER);
	        r.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(3000);
	    
	        
             WebElement dropdown = driver.findElement(By.id("opp11"));
			
			Select select = new Select(dropdown);
			select.selectByValue("Prospecting");
			
			driver.findElement(By.id("opp9")).sendKeys("08/23/2023");
			driver.findElement(By.id("datePicker")).click();
			//
			
			driver.findElement(By.id("opp17_lkwgt")).click();
			
			driver.findElement(By.name("save")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("lookup701Hu000001eVdAopp17")).sendKeys("DM Campaign to Top Customers - Nov 12-23, 2001");
			driver.findElement(By.id("lksrch")).click();
			
			Thread.sleep(3000);
			 
		Set<String> getAllWindows = driver.getWindowHandles();
			String[] getWindow = getAllWindows.toArray(new String[getAllWindows.size()]);
			driver.switchTo().window(getWindow[1]);
		    driver.findElement(By.xpath("//html/body/form/div/div[2]/div/div[2]/table/tbody/tr[2]/th/a")).click();
			
			//Thread.sleep(10000);
			//driver.close();
	
			
	 }		

}
