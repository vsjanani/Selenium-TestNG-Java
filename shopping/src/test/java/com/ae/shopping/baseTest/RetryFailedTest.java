package com.ae.shopping.baseTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {
	int intCountTestRun = 0;
	int intRetryTestRun = 1;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(intCountTestRun < intRetryTestRun) {
			intCountTestRun++;
			return true;
			
		}
		return false;
	}

}
