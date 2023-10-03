package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase27 {
	 
	
    
      WebDriver driver =new FirefoxDriver();

        @Test 
       public void LoginTest() throws InterruptedException {


        WebDriverManager.firefoxdriver().setup();

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
         
         driver.findElement(By.id("Contact_Tab")).click();
     	Thread.sleep(3000);
     	
     	WebElement dropdown = driver.findElement(By.id("hotlist_mode"));
     	
     	Select select = new Select(dropdown);
         select.selectByValue("2");
         
         String ExpectedText = "Recently Created";
         String ActualText = driver.findElement(By.xpath("//select[@id='hotlist_mode']/option[@selected='selected']")).getText();
         
         if(ActualText.equals(ExpectedText)) {
        	 System.out.println("Test is Successful");
         }else {
        	 System.out.println("Test is Failed");
        	 
         }
         
         
        }


	

}
