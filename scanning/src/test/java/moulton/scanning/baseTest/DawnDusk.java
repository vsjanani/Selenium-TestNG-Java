package moulton.scanning.baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class DawnDusk {
	
	 public WebDriver objWebDriver;
	
	@BeforeClass
	
	public void launchWebsite() {
		objWebDriver = new ChromeDriver();
		objWebDriver.manage().window().maximize();
		objWebDriver.get("https://moulton-law-offices-ps.mycase.com");		
	}
	

}
