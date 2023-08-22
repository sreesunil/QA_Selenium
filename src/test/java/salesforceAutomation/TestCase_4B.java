package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_4B {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch app
		driver.get("https://login.salesforce.com");
		driver.findElement(By.name("username")).sendKeys("123");
		driver.findElement(By.name("pw")).sendKeys("22131");
		driver.findElement(By.xpath("//input[@id = 'Login']")).click();
		
		String Expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		String Actual = driver.findElement(By.id("error")).getText();
		
		if(Actual.equals(Expected)) {
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}

	}

}
