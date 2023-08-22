package salesforceAutomation;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase10 {

	
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		ChromeDriver driver =   Reusablecodes.SalesforceLogin();
		driver.manage().window().maximize();
		
		driver.findElement(By.id("Account_Tab")).click();
		
		/*
		 * String Expected = "Accounts";
		 * 
		 * String Actual =
		 * driver.findElement(By.xpath("//div[@class ='content']")).getText();
		 * 
		 * System.out.println("Actual"); if(Actual.equals(Expected)) {
		 * System.out.println("Passed");
		 * 
		 * } else { System.out.println("Failed"); }
		 * 
		 * System.out.println("Accounts Page displayed");
		 */
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input")).click();
		
		//Robot r = new Robot();
		
		driver.findElement(By.id("acc2")).sendKeys("bcf");
		
		WebElement dropdown = driver.findElement(By.id("acc6"));
		Select select = new Select(dropdown);
		select.selectByValue("Installation Partner");
		
		WebElement dropdown2 = driver.findElement(By.id("00NHu00000PEMG2"));
		Select select1 = new Select(dropdown2);
		select1.selectByValue("High");
		Thread.sleep(4000);
		driver.findElement(By.name("save")).click();
		
		String expected = "bcf";
		
		String actual = driver.findElement(By.xpath("//div[@id='contactHeaderRow']//h2")).getText();
		
		if(actual.equals(expected)) {
			
			System.out.println("Pass");
			
		}
		else {
			System.out.println("Fail");
			
		}
		
		
		
		
		
		
		
		
		
	}

}
