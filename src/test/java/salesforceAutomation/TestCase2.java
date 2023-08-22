package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase2 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver =  Reusablecodes.SalesforceLogin();
		
		String Expected = "Home";
		
		String Actual = driver.findElement(By.id("home_Tab")).getText();
		
		
		if(Actual.equals(Expected)) {
			System.out.println("Passed");
				
			}
		else {
			System.out.println("Failed");
		}
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
