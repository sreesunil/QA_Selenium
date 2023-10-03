package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase8 {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeDriver driver =   Reusablecodes.SalesforceLogin();
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userNavLabel")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Developer Console")).click();
		Thread.sleep(3000);
		String parent = driver.getWindowHandle();
		driver.switchTo().window(parent);
		System.out.println("Developer Console Window is Displayed");
		driver.close();
	}

}
