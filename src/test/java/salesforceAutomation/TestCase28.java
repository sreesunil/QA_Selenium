package salesforceAutomation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase28 {
	 WebDriver driver =new ChromeDriver();
	 
	 @BeforeTest
	public void loginTest() {
		
		 WebDriverManager.chromedriver().setup();
			
			driver.get("https://login.salesforce.com/");
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys("sreeedamana@qa.com");
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("asksree530");
			
			driver.findElement(By.id("Login")).click();
			driver.manage().window().maximize();
			
	}
	 @AfterTest
	 public void mycontactsTest() throws InterruptedException {
		 
		 driver.findElement(By.id("Contact_Tab")).click();
			Thread.sleep(3000);
			WebElement dropdown = driver.findElement(By.xpath("//*[@name='fcf']"));
			Select select = new Select(dropdown);
			select.selectByValue("00BHu00000GsLMw");
			
			driver.findElement(By.xpath("//input[@title='Go!']")).click();
			
	 }
	 
	 @Test (priority =1,description= "This is a Login Test")
     
     
     public void aloginTest() {
   	  
   	  System.out.println("Login is successful");
     }
	 @Test (priority = 2 , description = "This is a Mycontactview Test")
     
	 public void bconviewTest() {
		 
		 System.out.println("My Contactview is successful");
		 
		 
		 
		 
	 }

}
