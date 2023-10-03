package salesforceAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase25 {
	
	
	        
	        WebDriver driver =new FirefoxDriver();

	@Test 
	  public void LoginTest() throws InterruptedException {
		
		
		 WebDriverManager.firefoxdriver().setup();
		
		driver.get("https://login.salesforce.com/");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("sreeedamana@qa.com");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("asksree530");
		
		driver.findElement(By.id("Login")).click();
		driver.manage().window().maximize();
		
		String expected = "Home Page ~ Salesforce - Developer Edition";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		
		System.out.println("Salesforce Homepage is displayed");
		
		Thread.sleep(4000);
		
		// To create New Contact
		driver.findElement(By.id("Contact_Tab")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name ='new']")).click();
		WebElement lastname = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		lastname.sendKeys("Tester");
		driver.findElement(By.xpath("//input[@id='con4']")).sendKeys("BMW");
		driver.findElement(By.xpath("//input[@name ='save']")).click();
		
		String expectedresult = "Contact: Tester ~ Salesforce - Developer Edition";
		String actualresult = driver.getTitle();
		if(actualresult.contains(expectedresult)) {
			System.out.println("New Contact created");
		}else {
			System.out.println("New Contact not created");
		}
		
	
		
		
		

	
	}

}
