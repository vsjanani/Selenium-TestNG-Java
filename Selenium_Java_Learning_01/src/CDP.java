import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.emulation.Emulation;

public class CDP {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver objChromeDriver = new ChromeDriver();
		objChromeDriver.manage().window().maximize();
		try (DevTools objDevTools = objChromeDriver.getDevTools()) {
			objDevTools.createSession();		
			//select any domain from this link either network or emulation or anything:https://chromedevtools.github.io/devtools-protocol/tot/Emulation/
			//few below options can be set to empty through autosuggestion itself.
			objDevTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
		}
		objChromeDriver.get("https://www.microsoft.com/");
		Thread.sleep(3000);
		objChromeDriver.findElement(By.cssSelector(".c-uhfh-gcontainer-st button")).click();
		Thread.sleep(3000);
		objChromeDriver.findElement(By.cssSelector("#l0_Teams-mo")).click();
		
	}

}
