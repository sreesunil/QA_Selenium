package salesforceAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase26 {

	public static void main(String[] args) throws InterruptedException, AWTException {
	ChromeDriver driver =   Reusablecodes.SalesforceLogin();
	driver.findElement(By.id("Contact_Tab")).click();
	Thread.sleep(3000);
	
	WebElement newviewlink = driver.findElement(By.linkText("Create New View"));
	newviewlink.click();
	Thread.sleep(3000);
	Robot name = new Robot();
	driver.findElement(By.id("fname")).sendKeys("pqr");
	driver.findElement(By.id("devname")).sendKeys("pqr");
	
	name.keyPress(KeyEvent.VK_ENTER);
	name.keyRelease(KeyEvent.VK_ENTER);
	
	driver.findElement(By.xpath("//input[@name='save']")).click();
	
	System.out.println("The new view in the contactpage is successful");
	

}
}