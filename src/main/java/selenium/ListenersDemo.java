package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ListenerClass.class)
public class ListenersDemo {
    
	@Test
	public void test01() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://login.salesforce.com");
		
		Assert.assertEquals(driver.getTitle(), "Login | Salesforce");
		
	}
}
