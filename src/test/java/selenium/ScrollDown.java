package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollDown {
  @Test
  public void scrollDown() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.amazon.com/");
	  
	 WebElement element =driver.findElement(By.xpath("/a[@class='a-link-normal as-title-block-right see-more truncate-1line']"));
	  
	  Actions action = new Actions(driver);
	  action.moveToElement(element);
	  action.perform();
	  element.click();
	 
	 
	 
  }
}
