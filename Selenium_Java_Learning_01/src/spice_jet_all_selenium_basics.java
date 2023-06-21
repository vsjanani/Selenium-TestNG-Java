import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class spice_jet_all_selenium_basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
//		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		options.addArguments("--start-maximized");
		options.setAcceptInsecureCerts(true);
		WebDriver driverObj = new ChromeDriver(options);
		driverObj.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driverObj.manage().timeouts().imp
		driverObj.get("https://www.spicejet.com/");
		WebDriverWait expWaitObj = new WebDriverWait(driverObj, Duration.ofSeconds(10));
		expWaitObj
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@data-testid = 'to-testID-origin']/div/div/input")))
				.sendKeys("mum");

		driverObj.findElement(By.xpath("//div[@data-testid = 'to-testID-destination']/div/div/input")).sendKeys("del");
		expWaitObj.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='r-16ru68']")))
				.click();
//		div[text() = 'Return Date']
		if (driverObj.findElement(By.xpath("//div[text()= 'Return Date']")).getAttribute("style").contains("0.5")) {
			Assert.assertTrue(true);
			System.out.println("0.5 is present");
		}

		else {
			Assert.assertTrue(false);
		}
		driverObj.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
		for (int i = 1; i < 6; i++) {
			driverObj.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();

		}
		driverObj.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();

		WebElement FamilyCheck = driverObj.findElement(By.xpath(
				"//div[text() = 'Family & Friends']/parent::div/preceding-sibling::div //*[local-name()='svg']"));
		getcount(FamilyCheck);

		FamilyCheck.click();
		getcount(driverObj.findElement(By.xpath(
				"//div[text() = 'Family & Friends']/parent::div/preceding-sibling::div //*[local-name()='svg']")));

//		driverObj.findElement(By.xpath("//div[text()='Search Flight']")).click();
//	
//		expWaitObj.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Search Flight']"))).click();
		Actions mouseHover = new Actions(driverObj);
		mouseHover.moveToElement(driverObj.findElement(By.xpath("//div[text()='Search Flight']"))).click().build()
				.perform();
		driverObj.findElement(By.cssSelector(".r-1ww30s9")).click();
		System.out.println(driverObj.findElement(By.cssSelector(".r-1ap4h1l")).isEnabled());
		expWaitObj.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".r-1ap4h1l .r-zchlnj")));
		mouseHover.moveToElement(driverObj.findElement(By.cssSelector(".r-1ap4h1l .r-zchlnj"))).click().build()
				.perform();
		JavascriptExecutor js = (JavascriptExecutor) driverObj;
		js.executeScript("window.scrollBy(0,10000)");

//		((JavascriptExecutor) driverObj).executeScript("arguments[0].click();", driverObj.findElement(By.cssSelector(".r-1ap4h1l .r-zchlnj")));

//		try {
//			driverObj.switchTo().alert().dismiss();
//		}
//		catch(Exception e) {
//			System.out.println("no alerts found" + e);
//		}/
//		driverObj.findElement(By.xpath("//div[text()=\"Passengers\"]")).click();
//		

//		driverObj.findElement(By.xpath("//div[text()='Search Flight']")).click();

	}

	public static void getcount(WebElement child) {
		List<WebElement> children = child.findElements(By.tagName("g"));
		if (children.size() > 0) {
			System.out.println("g is present, it is selected");
		} else {
			System.out.println("g is not present, it is not selected");
		}

	}

}
