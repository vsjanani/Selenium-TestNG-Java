import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\jansr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--start-maximized");
		option.addArguments("--disable-notifications");
		WebDriver driverObj = new ChromeDriver(option);
		driverObj.get("https://www.irctc.co.in/nget/train-search");
//		driverObj.findElement(By.cssSelector(".ui-dialog .btn")).click();
		System.out.println(driverObj.findElements(By.cssSelector(".footer-icons a")).size());
		List<WebElement> mylist = driverObj.findElements(By.cssSelector(".footer-icons a"));
		SoftAssert softObj = new SoftAssert();
		for (WebElement eachURLElement : mylist) {
//			String myLink = eachURLElement.findElement(By.tagName("i")).getAttribute("class").split("-")[1];
			String eachURL = eachURLElement.getAttribute("href");
			URL myURL = new URL(eachURL);
			HttpURLConnection urlConnectObj = (HttpURLConnection) myURL.openConnection();
//			urlConnectObj.setRequestMethod("HEAD");
			urlConnectObj.connect();
			softObj.assertTrue(urlConnectObj.getResponseCode() < 400, urlConnectObj.getURL()+"is broken with status code"+urlConnectObj.getResponseCode()); //simplified model for below if loop.
//			softObj.assertT
//			if (urlConnectObj.getResponseCode() > 200) {
//				System.out.println(myLink + "is broken");
//			}

		}
		softObj.assertAll();

	}

}
