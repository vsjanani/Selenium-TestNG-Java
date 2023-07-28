import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v114.emulation.Emulation;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CDPusingRemoteWebDriver {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriver driver = new RemoteWebDriver(new URL("http://10.0.0.152:4444"), chromeOptions);
		Augmenter objAug = new Augmenter();
		driver = objAug.augment(driver);
		DevTools devTools = ((HasDevTools) driver).getDevTools();
		devTools.createSession();
		// lattitude, longitude and accuracy of russia
		devTools.send(Emulation.setGeolocationOverride(Optional.of(17), Optional.of(78), Optional.of(1)));

		driver.get("https://my-location.org/");
		driver.get("https://www.google.com");
		driver.findElement(By.cssSelector(".gLFyf")).sendKeys("netflix", Keys.ENTER);
		driver.findElement(By.xpath("(//h3[contains(@class, 'LC20lb')])[1]")).click();
//		driver.quit();

	}

}
