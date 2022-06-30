package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class MyListeners extends Base implements ITestListener{
	
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;

	@Override
	public void onTestStart(ITestResult result) {
		
		extentTest = extentReport.createTest(result.getName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		extentTest.fail(result.getThrowable());
		
		WebDriver driver = null;
		
		String testMethodName = result.getName();
		
		try {
			
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			
			e1.printStackTrace();
		}
		
		try {
			
			String screenshotFilePath = takeScreenshot(testMethodName,driver);
			extentTest.addScreenCaptureFromPath(screenshotFilePath,testMethodName);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		
	}
	
	

}
