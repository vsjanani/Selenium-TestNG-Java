package com.ae.shopping.baseTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ae.shopping.resources.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listener implements ITestListener {
	

	WebDriver objWebDriver;
	ExtentReporterNG objExtentReport = new ExtentReporterNG();
	ExtentReports objExtentReports = objExtentReport.report();
//	ExtentTest objExtentTestDetails;
	public ThreadLocal<ExtentTest> objThreadLocal = new ThreadLocal<ExtentTest>();
	DevTools objDevTools;
	String strNetworkError  = "strErrorCode";
	String strNetworkLoadingFailedReason = "strLoadingFailedReason";
	String strConsoleOutput = "strConsoleError";
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		
//		System.out.println("trying to print from ITestListener" + result.getName());
		ExtentTest objExtentTestDetails = objExtentReports.createTest(result.getMethod().getMethodName());
		objThreadLocal.set(objExtentTestDetails);
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		objThreadLocal.get().pass("Trying janani code as TestCase Passed");
		objThreadLocal.get().log(Status.PASS, "trying rahul style of code");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		objThreadLocal.get().fail(result.getThrowable());
		String[] errorArray = {strNetworkError,strNetworkLoadingFailedReason,strConsoleOutput};
		for(String i : errorArray) {
			String strErrorCodeToReport = getInstantVariableFromTestCases(result, i);
			if(strErrorCodeToReport!=null) {
				objThreadLocal.get().fail(strErrorCodeToReport);
			}
		} 
		String strTestCaseName = result.getName();
		try {
			objWebDriver = (WebDriver) result.getTestClass().getRealClass().getField("objWebDriver")
					.get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String strScreenShotPath = System.getProperty("user.dir") + "//reports//" + strTestCaseName + ".png";
		File fileScreenshotSource = ((TakesScreenshot) objWebDriver).getScreenshotAs(OutputType.FILE);
		File fileScreenshotDest = new File(strScreenShotPath);
		try {
			FileUtils.copyFile(fileScreenshotSource, fileScreenshotDest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objThreadLocal.get().addScreenCaptureFromPath(strScreenShotPath, strTestCaseName);

	}

	public String getInstantVariableFromTestCases(ITestResult result, String strErrorLog) {
		// TODO Auto-generated method stub
		String strErrorToReturn = null;
		
			  try {
				strErrorToReturn = (String) result.getTestClass().getRealClass().getField(strErrorLog).get(result.getInstance());
//				System.out.println("checking this from listener inside method:"+strErrorToReturn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  return strErrorToReturn;
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		objExtentReports.flush();

	}
}
