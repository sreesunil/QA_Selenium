package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnnotationExaple {
	
	
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void loginApplication() {
		
		WebDriverManager.chromedriver().setup();
		
		//Launch app
				driver.get("https://login.salesforce.com");
				
				//Enter username
				driver.findElement(By.id("username")).sendKeys("sreeedamana@hon.com");
				
				//Password Enter
				driver.findElement(By.id("password")).sendKeys("asksree530");
				driver.findElement(By.id("rememberUn")).click();
				//Login
				driver.findElement(By.id("Login")).click();
				driver.manage().window().maximize();
				
				
	}
	          @AfterTest
				public void logoutApplication1() throws InterruptedException {
	        	  
	        	  driver.findElement(By.id("userNavLabel")).click();
	      		Thread.sleep(3000);
	      		
	      		driver.findElement(By.linkText("Logout")).click();
	      		Thread.sleep(3000);
					
				}
	          @Test (priority =1,description= "This is a Login Test")
	          
	          
	          public void aloginTest() {
	        	  
	        	  System.out.println("Login is successful");
	          }
	          @Test (priority = 2 , description = "This is a logout Test")
	          
	          public void blogoutTest() {
	        	  
	        	  System.out.println("Logout is successful");
	          }
		
		
	

	
		
	}



