package salesforceAutomation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase21 {
	
	
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
		
		
		
		List<WebElement> webelements = new ArrayList<WebElement>();
		webelements = driver.findElements(By.xpath("//*[@id='fcf']/option"));
		String expectedresult[] = {"All Open Leads" , "My Unread Leads" , "Recently Viewed Leads" , "Today's Leads"};
		
		List<String> actualresult = new ArrayList<String>();
		Thread.sleep(4000);
		for(WebElement element : webelements) {
			actualresult.add(element.getText());	
			System.out.println(element.getText());
		}
		boolean pass = true;
		for(String expected2 : expectedresult) {
			if(!actualresult.contains(expected2)) {
				pass = false;
				break;
			}
		}
		
		
		  if(pass) { System.out.println("Passed");
		 
	         } else { System.out.println("Failed"); }
		 
         driver.close();

	
    }
}
