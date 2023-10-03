package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium_hackathon1 {

	

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebElement product = driver.findElement(By.id("twotabsearchtextbox"));
		product.sendKeys("kindel");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		driver.findElement(By.xpath("//span[contains(@class,'a-badge-text')][contains(text(),'Choice')]")).click();
		
		Thread.sleep(3000);
		
	    driver.findElement(By.id("add-to-cart-button")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//html/body/div[@class='a-modal-scroller a-declarative']/div[@class='a-popover a-popover-modal a-declarative  a-popover-modal-fixed-height']/div/div/div/div[@id='abb-intl-pop-cta']/span[@class='a-button a-button-base abb-intl-decline']/span/input")).click();
	    driver.findElement(By.id("nav-cart")).click();
	    Thread.sleep(3000);
	    String expected = "Kindle Paperwhite (8 GB) – Now with a 6.8\" display and adjustable warm light – Black";
	    String actual = driver.findElement(By.xpath("//span[contains(@class,'a-truncate-cut')][contains(text(),'Kindle')]")).getText();
	    if(actual.contains(expected)) {
	    	System.out.println("Item is available in the cart");
	    }else {
	    	System.out.println("Item is not available in the cart");
	    	
	    	
	    	
	    }
	    
	    System.out.println(actual);
	}
	  
}


