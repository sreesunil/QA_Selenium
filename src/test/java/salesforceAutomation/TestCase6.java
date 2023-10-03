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
		driver.findElement(By.id("username")).sendKeys("sreeedamana@qa.com");
		driver.findElement(By.id("password")).sendKeys("asksree530");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.id("userNavLabel")).click();
		
		driver.findElement(By.linkText("My Profile")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class= 'contactInfo profileSection']//img")).click();
		Thread.sleep(3000);
       
		driver.switchTo().frame(2);
		driver.findElement(By.linkText("About")).click();
		// User Profile page change lastname 
		
		WebElement lastname =driver.findElement(By.id("lastName"));
		lastname.clear();
		lastname.sendKeys("kumar");
		driver.findElement(By.xpath("//input[@value = 'Save All']")).click();
		driver.switchTo().parentFrame();
		//Edit Post Link
		driver.findElement(By.id("publisherAttachTextPost")).click();
		WebElement postIframe =  driver.findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, publisherRichTextEditor')]"));
		driver.switchTo().frame(postIframe);
		WebElement postBody = driver.findElement(By.xpath("//html[1]/body[1]"));
		postBody.click();
		postBody.sendKeys("Test data");
		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);
		driver.findElement(By.id("publishersharebutton")).click();
		
		// Uploading a file
		Thread.sleep(3000);
		driver.findElement(By.id("publisherAttachContentPost")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("chatterUploadFileAction")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='chatterFile']")).sendKeys("C:\\Users\\smann\\OneDrive\\Pictures\\hey bro.png");
		Thread.sleep(3000);
		driver.findElement(By.id("publishersharebutton")).click();
		Thread.sleep(5000);
		//
		
		//Change profile photo
		driver.findElement(By.xpath("//div[@id='photoSection']//img[@class='chatter-photo']")).click();
		driver.findElement(By.id("uploadLink")).click();
		Thread.sleep(3000);
		WebElement editImage =  driver.findElement(By.id("uploadPhotoContentId"));
		driver.switchTo().frame(editImage);
		driver.findElement(By.id("j_id0:uploadFileForm:uploadInputFile")).sendKeys("C:\\Users\\smann\\OneDrive\\Pictures\\hey bro.png");
		driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("j_id0:j_id7:save")).click();
	}    

}
