package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase6 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("sreeedamana@hon.com");
		driver.findElement(By.id("password")).sendKeys("asksree530");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.id("userNavLabel")).click();
		
		driver.findElement(By.linkText("My Profile")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class= 'contactInfo profileSection']//img")).click();
		Thread.sleep(3000);
       
		driver.switchTo().frame(2);
		driver.findElement(By.linkText("About")).click();
		
		driver.findElement(By.id("lastName")).sendKeys("kumar");
		driver.findElement(By.xpath("//input[@value = 'Save All']")).click();
		driver.switchTo().parentFrame();
		
		driver.findElement(By.id("publisherAttachTextPost")).click();
		driver.findElement(By.xpath("//*[@id=\"cke_43_contents\"]/iframe")).sendKeys("Text is Here");
		//WebElement postIframe = driver.findElement(By.xpath("//iframe[contains9@title,'Rich Text Editor,publisherRichTextEditor')]"));
		//driver.switchTo().frame(1);
		
		///html
	}    ////*[@id="cke_43_contents"]/iframe

}
