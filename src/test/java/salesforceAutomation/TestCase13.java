package salesforceAutomation;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestCase13 {


    @Test
	public void loginTest() throws InterruptedException, AWTException {
   	 
   	 FirefoxDriver driver = Reusablecodes.SalesforceLoginfirefox();
   	 
		System.out.println("Login  is Successfull");
        Thread.sleep(4000);
		
		driver.findElement(By.id("Account_Tab")).click();
		
		 String expected = "Accounts: Home ~ Salesforce - Developer Edition";
	       String actual = driver.getTitle();
	       
	       if(actual.equals(expected)) {
	    	   System.out.println("Passed");
	       }else {
	    	   System.out.println("Failed");
	       }
	       System.out.print("Accout Page is displayed");
	       // To Merge Accounts
	       driver.findElement(By.linkText("Merge Accounts")).click();
	       
	       driver.findElement(By.id("srch")).sendKeys("abc");
	       driver.findElement(By.name("srchbutton")).click();
	       Thread.sleep(3000);
	     
			/*
			 * List<WebElement> elements =
			 * driver.findElements(By.xpath("//table[@class='list']//input[@name='cid']"));
			 * if(elements.size() > 1) { for(int i=0;i < 2;i++) { elements.get(i).click(); }
			 * }
			 */
	       
	       driver.findElement(By.name("goNext")).click();
	       Thread.sleep(3000);
	       driver.findElement(By.name("save")).click();
	       driver.switchTo().alert().accept();
	       
	       System.out.println("Merge Account is Completed");
	       driver.close();
	       
	}

}
