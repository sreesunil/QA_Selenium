package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.FileConstants;
import java.io.File;
import java.util.jar.Attributes.Name;

public class BaseTest {

	private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	static ExtentReports extent = new ExtentReports();
	static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;
	
	
	public static Logger logger = LogManager.getLogger("BaseTest");

//		Requirements
//		Cross browser support
//		Parallel support -
//		Proper reporting - Accurate Assertion, Screenshots
//		Support of Logs in the framework
	@BeforeMethod
	public void setup(java.lang.reflect.Method name) {
		BaseTest.test = extent.createTest(name.getName());
		logger.info("BaseTest:setup: " + name.getName() + " Test object for reporting is Created");
	}

	@AfterMethod
	public void tearDown(java.lang.reflect.Method name) {
		logger.info("BaseTest:tearDown: " + name+ "Tear down called");

	}
	
	//@Parameters({"browserName" , "isHeadless"})
	@BeforeTest
	public static void setDriver() {
		spark = new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
		extent.attachReporter(spark);
		WebDriver driver = BaseTest.getBrowserType("chrome", false);
		logger.info("BaseTest : setDriver : Spark report configured ");
		threadLocalDriver.set(driver);
	}

	public static WebDriver getDriver() {
		return threadLocalDriver.get();

	}

	@AfterTest
	public static void removeDriver() {
		getDriver().close();
		threadLocalDriver.remove();
		extent.flush();
	}

	public static WebDriver getBrowserType(String browserName, boolean headless) {
		WebDriver driver;
		String browserType = browserName.toLowerCase();
		switch (browserType) {
		case "chrome":
			if (headless) {
				ChromeOptions co = new ChromeOptions();
				logger.info("BaseTest : getBrowserType : Headless Chrome configured");

				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
				logger.info("BaseTest : getBrowserType : Headless Chrome configured");

			}
			break;

		case "firefox":
			if (headless) {
				
				FirefoxOptions fo = new FirefoxOptions();
				logger.info("BaseTest : getBrowserType : Headless Firefox configured");

				fo.addArguments("--headless");
				driver = new FirefoxDriver(fo);
			}
			else {
				driver = new FirefoxDriver();
				logger.info("BaseTest : getBrowserType : Headless Firefox configured");
			}
				
		

			break;

		case "safari":
			driver = new SafariDriver();
			break;

		case "egde":
			driver = new EdgeDriver();
			break;

		default:
			driver = null;
			logger.fatal("BaseTest : getBrowserType : Incorrect browser name supplied");
			break;
		}

		return driver;

	}

}
