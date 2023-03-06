package com.ae.shopping.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public ExtentReports report() {
	String strReportPath = System.getProperty("user.dir") + "//reports//index.html";
	ExtentSparkReporter objExtentSpark = new ExtentSparkReporter(strReportPath);
	objExtentSpark.config().setDocumentTitle("Ae.com:Shopping Test Report");
	objExtentSpark.config().setReportName("Shopping");
	ExtentReports objExtentReport = new ExtentReports();
	objExtentReport.attachReporter(objExtentSpark);
	objExtentReport.setSystemInfo("Tester", "Janani.VS");
	return objExtentReport;
	}
//	ExtentReports objExtentReport = new ExtentReports();

}
