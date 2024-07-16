package testComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportsTestNG;

public class Listeners extends BaseTest implements ITestListener  {
	ExtentReports ex = ExtentReportsTestNG.extentReport();
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		test = ex.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL,"Test case failed due to timeout");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS,"Test case pass");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		String path=null;
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//take screenshot and attach it to ExtentReport
		try {
			path=takeScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	ex.flush();	
	}
}
