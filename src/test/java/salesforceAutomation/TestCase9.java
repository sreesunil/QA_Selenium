package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase9 {

	

	public static void main(String[] args) throws InterruptedException {
		
		

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch app
		driver.get("https://login.salesforce.com");
		
		//Enter username
		driver.findElement(By.id("username")).sendKeys("sreeedamana@hon.com");
		
		//Password Enter
		driver.findElement(By.id("password")).sendKeys("asksree530");
		
		driver.findElement(By.id("Login")).click();
		driver.manage().window().maximize();
		driver.findElement(By.id("userNavLabel")).click();
		
		driver.findElement(By.linkText("Logout")).click();
		
		Thread.sleep(3000);
		String Expected = "Log In";
		Thread.sleep(4000);
		String Actual = driver.findElement(By.id("Login")).getText();
		
		if(Actual.equals(Expected)) {
			System.out.println("Passed");
				
			}
		else {
			System.out.println("Failed");
		}
		
        driver.close();
	}

}
