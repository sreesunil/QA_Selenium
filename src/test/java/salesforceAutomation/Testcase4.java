package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase4 {

	public static void main(String[] args) {
		
	
		WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch app
		driver.get("https://login.salesforce.com");
		
		//Enter username
		driver.findElement(By.id("username")).sendKeys("sreeedamana@hon.com");
		driver.findElement(By.linkText("Forgot Your Password?")).click();
		driver.findElement(By.id("un")).sendKeys("ammuedamana@gmail.com");
		driver.findElement(By.id("continue")).click();
		
		String Expected = "We’ve sent you an email with a link to finish resetting your password.";
		String Actual = driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/div/p[1]")).getText();
		
		if(Actual.equals(Expected)) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
	

	}

}
