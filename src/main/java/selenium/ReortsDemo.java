package selenium;

import java.io.File;

import org.apache.commons.compress.harmony.pack200.NewAttribute.PassAttribute;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FileConstants;

public class ReortsDemo {
	
	public static void main(String[] args) {
		
	
	//Creating ExtentReport class
	ExtentReports extent = new ExtentReports();
	
	ExtentSparkReporter spark = new ExtentSparkReporter(new File(FileConstants.REPORT_PATH));
	extent.attachReporter(spark);
	ExtentTest test = extent.createTest("Tc01");
	test.log(Status.PASS, "" );
	
	test.info("Password is entered");
	test.info("login button clicked");
	test.pass("TC01 PASSED");
	
	extent.flush();
	
	
	
	}
	
	
}
