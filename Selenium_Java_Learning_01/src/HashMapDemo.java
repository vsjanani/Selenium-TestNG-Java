import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HashMapDemo {

	@Test(dataProvider="credentials")
	public void launchApp(HashMap<String, String> dataSetUp) {
		WebDriver objWebDriver = new ChromeDriver();
		objWebDriver.get("https://mychart.med.utah.edu/mychart/Authentication/Login?");
		objWebDriver.manage().window().maximize();
		objWebDriver.findElement(By.cssSelector("#Login")).sendKeys(dataSetUp.get("email"));
		objWebDriver.findElement(By.cssSelector("#Password")).sendKeys(dataSetUp.get("password"));
		
	}
	
	@DataProvider
	public Object[][] credentials() {
		HashMap<String, String> objHashMap1 = new HashMap<String, String>();
		objHashMap1.put("email", "darshini@gmail.com");
		objHashMap1.put("password", "dar@123");	
		System.out.println(objHashMap1);
		
		HashMap<String, String> objHashMap2 = new HashMap<String, String>();
		objHashMap2.put("email", "krishna@.com");
		objHashMap2.put("password", "kri@123");
		return new Object[][] {{objHashMap1}, {objHashMap2}}; 
	}	

}
