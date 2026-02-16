package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.utils.ExtentManager;
import com.utils.ExtentTestManager;
import com.utils.ScreenshotUtils;

public class TestListener implements ITestListener{
	// Initialize report.
	@Override
	public void onStart(ITestContext context) {
		ExtentManager.getInstance();
	}
	
	//Create test entry in report.
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTestManager.setTest(ExtentManager.getInstance().createTest(result.getMethod().getMethodName()));
	}
	
	//Mark pass.
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
	}
	
	//Attach screenshot 
	@Override
	public void onTestFailure(ITestResult result) {
		String path = ScreenshotUtils.captureScreenshot(result.getMethod().getMethodName());
		
		ExtentTestManager.getTest().fail(result.getThrowable()).addScreenCaptureFromPath(path);
	}
	
	//Write data to HTML file.
	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.getInstance().flush();
	}

}
