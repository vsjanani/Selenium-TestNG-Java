import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportAndScreenshotDemo {

	public ExtentReports objExtentReports;
	
	@BeforeTest
	public void extentReporting() {
		String strReportPath = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter objExtentSpark = new ExtentSparkReporter(strReportPath);
		objExtentSpark.config().setDocumentTitle("SeleniumJavaLearning");
		objExtentSpark.config().setReportName("Basics Selenium Java");
		objExtentReports = new ExtentReports();
		objExtentReports.attachReporter(objExtentSpark);
		objExtentReports.setSystemInfo("Tester", "Janani.VS");		
		
	}
	
	@Test
	public void launchSite() throws IOException {
		objExtentReports.createTest("TestResults");
		WebDriver objWebDriver = new ChromeDriver();
		objWebDriver.get("https://www.amazon.com");
		File screenshotSourceFile = ((TakesScreenshot) objWebDriver).getScreenshotAs(OutputType.FILE);
		File screenshotDestFile = new File(System.getProperty("user.dir")+"//reports//" + "launchSite" + ".png");
		FileUtils.copyFile(screenshotSourceFile, screenshotDestFile);
		Assert.assertEquals(objWebDriver.getTitle(), "123");		
		objExtentReports.flush();
		}
}
