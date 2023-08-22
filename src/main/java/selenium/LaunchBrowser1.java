package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://selenium-prd.firebaseapp.com/  ");
		
		//driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		//driver.findElement(By.id("password_field")).sendKeys("admin123");
	
		//driver.findElement(By.xpath("//*[text()='Login to Account']")).click();
		//Thread.sleep(3000);
		
		driver.get("https://login.salesforce.com/");
		
		//ID
		//driver.findElement(By.id("username")).sendKeys("sreeedamana@hon.com");
		
		Thread.sleep(3000);
		
		//name
		driver.findElement(By.name("username")).sendKeys("sreeedamana@hon.com");
		driver.findElement(By.name("pw")).sendKeys("enteammu40");
		driver.findElement(By.xpath("//*[@name = 'Login']")).click();
		
		//*[@id="Login"]
		
		//Xpath
		//driver.findElement(By.xpath("//*[@name = 'username']")).sendKeys("sreeedamana@hon.com");
		
		//css
		//driver.findElement(By.cssSelector("#username")).sendKeys("sreeedamana@hon.com");
		//linktext
		//driver.findElement(By.linkText("Forgot Your Password?")).click();
		//partial linktext
		//driver.findElement(By.partialLinkText("Forgot")).click();
		
		//Thread.sleep(3000);
		//driver.close();
		
		
		
		
}
}