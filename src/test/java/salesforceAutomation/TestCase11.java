package salesforceAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase11 {

	

	public static void main(String[] args) {
		
		
	   FirefoxDriver driver = Reusablecodes.SalesforceLoginfirefox();
	   driver.manage().window().maximize();
		
	   driver.findElement(By.id("Account_Tab")).click();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		


	}

}
