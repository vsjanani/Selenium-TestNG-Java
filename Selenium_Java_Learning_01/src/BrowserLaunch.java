import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.TemporalUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserLaunch {
	
	
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
//		WebDriver driverObj = new EdgeDriver();
//		driverObj.get("https://www.decathlon.in/");
//		System.out.println(driverObj.getCurrentUrl());

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximised");
		
		WebDriver objWebDriver = new ChromeDriver(options);
		objWebDriver.get("https://www.decathlon.in/");
		URL url = new URL("https://www.google.com");
//		objWebDriver.manage().window().maximize();
		System.out.println(objWebDriver.getTitle());
		System.out.println(objWebDriver.findElement(By.partialLinkText("Decathlon for School")).getAttribute("href"));
		
		
	}

}
