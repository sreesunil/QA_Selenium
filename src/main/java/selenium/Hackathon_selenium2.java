package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hackathon_selenium2 {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.xe.com/");
		driver.manage().window().maximize();
 
		Thread.sleep(3000);
		
		 
		
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("inr");
		driver.findElement(By.xpath("//*[(contains(@class,'c') or contains(@class,'ListboxOption')) and contains(.,'INR')]")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/section/div[2]/div/main/div/div[2]/button")).click();
		
		
		String expected = "Xe: Currency Exchange Rates and International Money Transfer";
		String actual = driver.getTitle();
		if(actual.contains(expected)) {
			System.out.println("Test is Successful");
			
		}else {
			System.out.println("Test is Failed");
		}
			
      System.out.println(actual);
		

	}
	
	
	
}