import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.network.Network;
import org.openqa.selenium.devtools.v111.network.model.ConnectionType;

public class CDPNetworkErrorMessageDisplay {
	public static void main(String[] args) {
		ChromeDriver objChromeDriver = new ChromeDriver();
		DevTools objDevTools = objChromeDriver.getDevTools();
		objDevTools.createSession();
		objDevTools.send(
				Network.enable(java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
		objDevTools.addListener(Network.loadingFailed(), consumingRequest -> {
			System.out.println(consumingRequest.getErrorText());
			System.out.println(consumingRequest.getTimestamp());
		});
		//here, internet is disconnected by giving true. Lets check if systemoutput is printed appropriately.
		objDevTools.send(Network.emulateNetworkConditions(true, 3000, 20000, 10000, Optional.of(ConnectionType.WIFI)));
		objChromeDriver.get("https://www.google.com");
		objChromeDriver.findElement(By.cssSelector(".gLFyf")).sendKeys("netflix", Keys.ENTER);
		objChromeDriver.findElement(By.xpath("(//h3[contains(@class, 'LC20lb')])[1]")).click();
	}

}
