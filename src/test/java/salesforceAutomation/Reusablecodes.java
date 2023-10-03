package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v113.browser.Browser;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reusablecodes {
	
	public String url = "https://login.salesforce.com/";
	public String username = "sreeedamana@hon.com";
	public String password = "asksree530";
	public static WebDriver driver;
	     
	 public static ChromeDriver SalesforceLogin() {
		 WebDriverManager.chromedriver().setup();
		 ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://login.salesforce.com");
			
			driver.findElement(By.id("username")).sendKeys("sreeedamana@qa.com");
			
			driver.findElement(By.id("password")).sendKeys("asksree530");
			
			driver.findElement(By.id("Login")).click();
			driver.manage().window().maximize();
			
			return driver;
	}   

	 
	 
	 public static FirefoxDriver SalesforceLoginfirefox() {
		 WebDriverManager.firefoxdriver().setup();
		 FirefoxDriver driver = new FirefoxDriver();
			
			driver.get("https://login.salesforce.com");
			
			driver.findElement(By.id("username")).sendKeys("sreeedamana@hon.com");
			
			driver.findElement(By.id("password")).sendKeys("asksree530");
			
			driver.findElement(By.id("Login")).click();
			driver.manage().window().maximize();
			
			return driver;
	}     

}
