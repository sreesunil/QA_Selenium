package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch app
		driver.get("https://login.salesforce.com");
		
		//Enter username  
		driver.findElement(By.id("username")).sendKeys("sreeedamana@qa.com");
		//Login
		driver.findElement(By.id("Login")).click();
		
		String Expected = "Please enter your password.";
		
		String Actual = driver.findElement(By.id("error")).getText();
		
		if(Actual.equals(Expected)) {
			System.out.println("Passed");
				
			}
		else {
			System.out.println("Failed");
		}
		Thread.sleep(4000);
		driver.close();

	}

}
