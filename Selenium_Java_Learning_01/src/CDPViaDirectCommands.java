import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class CDPViaDirectCommands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver objChromeDriver = new ChromeDriver();
//		DevTools objDevTools = objChromeDriver.getDevTools();
//		objDevTools.createSession();
		HashMap params = new HashMap();
		params.put("width", 600);
		params.put("height", 1000);
		params.put("deviceScaleFactor", 50);
		params.put("mobile", true);
		objChromeDriver.executeCdpCommand("Emulation.setDeviceMetricsOverride", params);
		objChromeDriver.get("https://www.microsoft.com");
		Thread.sleep(3000);
		objChromeDriver.findElement(By.cssSelector(".c-uhfh-gcontainer-st button")).click();
		Thread.sleep(3000);
		objChromeDriver.findElement(By.cssSelector("#l0_Teams-mo")).click();

	}

}
