package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase29 {

	

	public static void main(String[] args) throws InterruptedException {
		
		     WebDriverManager.chromedriver().setup();
		     WebDriver driver =new ChromeDriver();
		 
		    driver.get("https://login.salesforce.com/");
			WebElement username = driver.findElement(By.id("username"));
			username.sendKeys("sreeedamana@hon.com");
			WebElement password = driver.findElement(By.id("password"));
			password.sendKeys("asksree530");
			
			driver.findElement(By.id("Login")).click();
			driver.manage().window().maximize();
			
			String expected = "Home Page ~ Salesforce - Developer Edition";
			String actual = driver.getTitle();
			Assert.assertEquals(actual, expected);
			
			System.out.println("Salesforce Homepage is displayed");
			
			Thread.sleep(4000);
			
			 driver.findElement(By.id("Contact_Tab")).click();
			 
			 WebElement contactname = driver.findElement(By.linkText("Tester"));
			 contactname.click();
			 
			 String ExpectedText = "Tester";
			 
			 String ActualText = driver.findElement(By.xpath("//h2[@class ='topName']")).getText();
			 
			 System.out.println(ActualText);
			 
			 if(ActualText.contains(ExpectedText)) {
				 System.out.println("The test is Successful");
			 }else {
				 System.out.println("Test is Failed");
			 }
		
////*[@id="bodyCell"]/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a
	}

}
