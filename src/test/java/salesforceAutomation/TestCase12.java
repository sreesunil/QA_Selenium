package salesforceAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase12 {
	

    @Test
	public void loginTest() throws InterruptedException, AWTException {
   	 
   	 FirefoxDriver driver = Reusablecodes.SalesforceLoginfirefox();
   	 
		System.out.println("Login  is Successfull");
        Thread.sleep(4000);
		
		driver.findElement(By.id("Account_Tab")).click();
		
		 String expected = "Accounts";
	       String actual = driver.findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div[1]/h1")).getText();
	       
	       if(actual.equals(expected)) {
	    	   System.out.println("Passed");
	       }else {
	    	   System.out.println("Failed");
	       }
	       System.out.print("Accout Page is displayed");
	       //Change new view name
	       driver.findElement(By.linkText("Edit")).click();
	       
	      
	        driver.findElement(By.id("fname")).sendKeys("BaseTeam");
	        
             //to select filters field
			
			//To select Operator
			WebElement dropdown1 = driver.findElement(By.id("fop1"));
			Select select1 = new Select(dropdown1);
			select1.selectByValue("c");

			WebElement value =driver.findElement(By.id("fval1"));
			value.clear();
			value.sendKeys("a");
			
			Thread.sleep(3000);
			
			driver.findElement(By.name("save")).click();
			
			
			String actual1 = driver.findElement(By.name("fcf")).getText();
			System.out.println(actual1);
			driver.close();
		

	
    }
	

}
