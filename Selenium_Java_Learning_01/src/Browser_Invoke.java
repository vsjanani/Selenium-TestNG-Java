
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser_Invoke {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jansr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver webdriver_obj = new ChromeDriver();
		webdriver_obj.get("https://www.google.com");
		webdriver_obj.manage().window().maximize();
		System.out.println(webdriver_obj.getTitle());
		System.out.println(webdriver_obj.getCurrentUrl());
		String id = webdriver_obj.getWindowHandle();
		System.out.print(id);
		webdriver_obj.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		Assert.assertEquals("hi", "hello");
		webdriver_obj.navigate().to("https://www.amazon.in");
		webdriver_obj.navigate().back();
		webdriver_obj.navigate().forward();
		System.out.println(webdriver_obj.navigate().getClass());
		JavascriptExecutor js = (JavascriptExecutor)webdriver_obj;
		js.executeScript("window.scrollBy(0,10000)");
		File srcFile = ((TakesScreenshot)webdriver_obj).getScreenshotAs(OutputType.FILE);
		File desFile = new File("C:\\Users\\jansr\\Documents\\myScreenshot");
		FileUtils.moveFile(srcFile, desFile); //can use copyFile as well

		
		
		
		

	}

}
