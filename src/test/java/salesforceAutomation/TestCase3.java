package salesforceAutomation;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v113.browser.Browser;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase3{
    @Test
	public void ngtest()throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch app
		driver.get("https://login.salesforce.com");
		
		//Enter username
		driver.findElement(By.id("username")).sendKeys("sreeedamana@hon.com");
		
		//Password Enter
		driver.findElement(By.id("password")).sendKeys("asksree530");
		driver.findElement(By.id("rememberUn")).click();
		//Login
		driver.findElement(By.id("Login")).click();
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userNavLabel")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
		String Expected = "sreeedamana@hon.com";
		
		String Actual = driver.findElement(By.xpath("//input[@id = 'username']")).getText();
		System.out.println(Actual);
		driver.close();
		Assert.assertEquals(Actual, Expected);
	}

}
