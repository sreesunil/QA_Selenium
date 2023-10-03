package selenium;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println(result.getName()+ " Test Failed");
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println(result.getName()+ " Test Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		System.out.println(result.getName()+ " Test is success");
	}
	
	

}
