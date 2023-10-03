package salesforceAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase11 {

	

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		
	   FirefoxDriver driver = Reusablecodes.SalesforceLoginfirefox();
	   driver.manage().window().maximize();
		
	   driver.findElement(By.id("Account_Tab")).click();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   
	   driver.findElement(By.id("Account_Tab")).click();
		
       String expected = "Accounts";
       String actual = driver.findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td[2]/div[1]/div[1]/div[1]/h1")).getText();
       
       if(actual.equals(expected)) {
    	   System.out.println("Passed");
       }else {
    	   System.out.println("Failed");
       }
       System.out.print("Accout Page is displayed");
       
        driver.findElement(By.linkText("Create New View")).click();
        Thread.sleep(3000);
        Robot r = new Robot();
        driver.findElement(By.id("fname")).sendKeys("Netgears");
        driver.findElement(By.id("devname")).sendKeys("NGears");
        
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
        
        driver.findElement(By.name("save")).click();
        

	}
	

}
