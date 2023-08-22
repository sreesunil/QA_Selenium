package salesforceAutomation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase5 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("sreeedamana@hon.com");
		driver.findElement(By.id("password")).sendKeys("asksree530");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.id("userNavLabel")).click();
		//to store webelements return form the findelements
		List<WebElement> webelements = new ArrayList<WebElement>();
		
	    webelements = driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));
		String Expected[] = {"My Profile","My Settings", "Developer Console", "Switch to Lightning Experience", "Logout"};
		//to store the text of each elements
		List<String> Actual = new ArrayList<String>();
	
		for(WebElement element : webelements) {
			Actual.add(element.getText());	
		}
		boolean pass = true;
		for(String Expected1 : Expected) {
			if(!Actual.contains(Expected1)) {
				pass = false;
				break;
			}
		}
		
		if(pass) {
			System.out.println("Passed");
			
		}
		else {
			System.out.println("Failed");
		}
      driver.close();
	}

}
