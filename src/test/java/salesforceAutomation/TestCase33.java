package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase33 {


    @Test
	public void testing() throws InterruptedException {
		
		ChromeDriver driver =   Reusablecodes.SalesforceLogin();
		
		String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
		String actualTitle = driver.getTitle();
		if(actualTitle.contains(expectedTitle)) {
		System.out.println("Home Page is Displayed ");
		}
		else {
			System.out.println("home page is not Lunched");
		}
		Thread.sleep(3000);
		driver.findElement(By.id("home_Tab")).click();
		driver.findElement(By.linkText("Sree kumar")).click();
		
		String ExpectedName = "Sree kumar";
		String ActualName = driver.findElement(By.xpath("//span[@id ='userNavLabel']")).getText();
		if(ActualName.equals(ExpectedName)) {
			System.out.println("Test is Passed");
		}else {
			System.out.println("Test is Failed");
		}
		
		
		
		
    }

}
