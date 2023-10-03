package salesforceAutomation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase15 {
	
     @Test
	public void loginTest() throws InterruptedException {
    	 
    	 FirefoxDriver driver = Reusablecodes.SalesforceLoginfirefox();
    	 
		System.out.println("Login  is Successfull");
         Thread.sleep(4000);
		//for Opportunity page display
		driver.findElement(By.linkText("Opportunities")).click();
		String expected = "Opportunities: Home ~ Salesforce - Developer Edition";
		String actual = driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		
		
		
		  List<WebElement> webelements = new ArrayList<WebElement>(); 
		  String expected1[]= {"Closing Next Month","Closing This Month" ,"My Opportunities" ,"New This Week" ,"Won"};
		  
		  List<String> Actual1 = new ArrayList<String>(); 
		  webelements = driver.findElements(By.xpath("//*[@id='fcf']//option") );
		  

		  for(WebElement element : webelements) 
		  {
			  System.out.println(element.getText());
			  Actual1.add(element.getText()); 
			  
		  }
		  boolean pass = true; 
		  for(String Expected2 : expected1) {
			  if(!Actual1.contains(Expected2)) { 
				  pass = false; 
				  break; 
				  } 
		  } 
		  if(pass) {
		  System.out.println("Passed");
		  
		  } else { System.out.println("Failed 2");
		  
		  }
		  
		  Thread.sleep(4000);
		  
		  driver.close();
		 
     }
}

