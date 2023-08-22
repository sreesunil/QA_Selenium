package selenium;

import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;  
import org.openqa.selenium.interactions.Actions;  
import org.openqa.selenium.remote.DesiredCapabilities;  
  
public class Dragdrp_Test {  
  
    public static void main(String[] args) {  
          
        ChromeDriver driver = new ChromeDriver();
        
          
  
        // Launch Website  
           driver.get("https://login.salesforce.com/");  
           
         //Enter username
   		driver.findElement(By.id("username")).sendKeys("sreeedamana@hon.com");
   		
   		//Password Enter
   		driver.findElement(By.id("password")).sendKeys("asksree530");
   		//Login
   		driver.findElement(By.id("Login")).click();
   		
              
        //WebElement on which drag and drop operation needs to be performed  
            WebElement from = driver.findElement(By.id("userNavLabel"));  
  
        //WebElement to which the above object is dropped  
            WebElement to = driver.findElement(By.linkText("My Settings"));  
               
        //Creating object of Actions class to build composite actions  
            Actions act = new Actions(driver);  
               
        //Performing the drag and drop action  
            act.dragAndDrop(from,to).build().perform();   
    }  
  
}  