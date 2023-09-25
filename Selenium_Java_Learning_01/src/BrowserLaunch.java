import java.time.Duration;
import java.time.temporal.TemporalUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserLaunch {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		WebDriver driverObj = new EdgeDriver();
//		driverObj.get("https://www.decathlon.in/");
//		System.out.println(driverObj.getCurrentUrl());

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximised");
		
		WebDriver objWebDriver = new ChromeDriver(options);
		objWebDriver.get("https://www.decathlon.in/");
//		objWebDriver.manage().window().maximize();
		System.out.println(objWebDriver.getTitle());
		
	}

}
