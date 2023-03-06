package BrowserStack.CloudTesting;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class CrossBrowserTesting {

	@Test
	public void crossBrowser() throws IOException {
		
//		MutableCapabilities caps = new MutableCapabilities();
		MutableCapabilities caps = new MutableCapabilities();
		
		WebDriver driver = new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"),caps);
		driver.get("https://rahulshettyacademy.com");
	    Assert.assertTrue(driver.getTitle().matches("Rahul Shetty Academy"));

	}
	
}
