import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.ConnectionType;

public class CDPNetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver objChromeDriver = new ChromeDriver();
		DevTools objDevTools = objChromeDriver.getDevTools();
		objDevTools.createSession();
		objDevTools.send(Network.enable(Optional.empty(), Optional.empty(),Optional.empty()));
		objDevTools.send(Network.emulateNetworkConditions(false, 3000, 20000, 10000, Optional.of(ConnectionType.WIFI)));
		objChromeDriver.get("https://www.google.com");
		objChromeDriver.findElement(By.cssSelector(".gLFyf")).sendKeys("netflix", Keys.ENTER);
		objChromeDriver.findElement(By.xpath("(//h3[contains(@class, 'LC20lb')])[1]")).click();
		
	}

}
