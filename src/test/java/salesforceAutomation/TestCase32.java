package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase32 {

	

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver =   Reusablecodes.SalesforceLogin();
		
		
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
		System.out.println("Login is Successful");
		}
		else {
			System.out.println("home page is not Lunched");
		}
		Thread.sleep(3000);
		WebElement contact = driver.findElement(By.linkText("Contacts"));
		contact.click();
		
		WebElement editcontact = driver.findElement(By.name("new"));
		editcontact.click();
		
		WebElement lastname = driver.findElement(By.id("name_lastcon2"));
		lastname.sendKeys("Indian");
		
		driver.findElement(By.cssSelector("#con4")).sendKeys("Global Media");
		driver.findElement(By.xpath("//input[@title='Save & New']")).click();
		
		String ExpectedText = "New Contact";
		String ActualText = driver.findElement(By.xpath("//h2[@class='pageDescription']")).getText();
		
		if(ActualText.equalsIgnoreCase(ExpectedText)) {
			System.out.println("Test is Successfull");
		}else {
			System.out.println("Test is Failed");
				
			}
		}


	}


