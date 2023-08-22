package salesforceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase7 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver =   Reusablecodes.SalesforceLogin();
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userNavLabel")).click();
		
		driver.findElement(By.linkText("My Settings")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id = 'PersonalInfo']//a")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Login History")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Download login history for last six months, including logins from outside the website, such as API logins (Excel .csv file) »")).click();
		
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@id = 'DisplayAndLayout']//a")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Customize My Tabs")).click();
		
		WebElement dropdown = driver.findElement(By.id("p4"));
		
		Select select = new Select(dropdown);
		
		select.selectByValue("02uHu000001Htnq");
		
		WebElement dropdown1 = driver.findElement(By.id("duel_select_0"));
		
		Select select1 = new Select(dropdown1);
		select1.selectByValue("report");
		
		driver.findElement(By.id("duel_select_0_right")).click();
		
		driver.findElement(By.xpath("//div[@id = 'EmailSetup']//a")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("My Email Settings")).click();
		driver.findElement(By.name("save")).click();
		
		String Expected = "Your settings have been successfully saved.";
		
		String Actual = driver.findElement(By.xpath("//div[@class ='messageText']")).getText();
		
		if(Actual.equals(Expected)) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
		
		System.out.println("Email Options Saved");

		driver.findElement(By.xpath("//div[@id = 'CalendarAndReminders']//a")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Activity Reminders")).click();
		driver.findElement(By.id("testbtn")).click();
		
	}
	
	

}
