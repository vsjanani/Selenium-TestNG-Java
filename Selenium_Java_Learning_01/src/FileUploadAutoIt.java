
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FileUploadAutoIt {
	@Test
	public void fileUpload() throws IOException, InterruptedException {
		ChromeOptions objChromeOptions = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", System.getProperty("user.dir"));		
		WebDriver objWebDriver = new ChromeDriver(objChromeOptions);
		objWebDriver.get("https://smallpdf.com/pdf-to-jpg");
		objWebDriver.findElement(By.cssSelector(".ggoliT")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C://Users//jansr//Downloads//SeleniumDemo.exe");
		Thread.sleep(3000);
		WebDriverWait objExplicitWait = new WebDriverWait(objWebDriver, Duration.ofSeconds(10));
//		System.out.println(objExplicitWait.until(ExpectedConditions.visibilityOf(objWebDriver.findElement(By.tagName("h1")))).getText());
//		JavascriptExecutor jse = (JavascriptExecutor)objWebDriver;
//		String javascript = "document.getElementsByClassName('sc-6ytb27-1 fnaLLy')[0]";    
//		WebElement element = (WebElement) jse.executeScript(javascriYpt);
//		element.click();
		//below code isn't working as below weblement is flex and it couldn't be accessed via jse as well. Just know how to download and verify the file exists or not as shown below.
		//to verify, refer FileExistsVerify class.
		objExplicitWait.until(ExpectedConditions.visibilityOf(objWebDriver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")))).click();
		objWebDriver.findElement(By.xpath("//span[contains(text(),'option')]")).click();
		objExplicitWait.until(ExpectedConditions.visibilityOf(objWebDriver.findElement(By.cssSelector(".DVOwC")))).click();
		File f = new File("user.dir"+"//Authorization Letter.jpg");
		System.out.println(f.exists());
		
	}

}
