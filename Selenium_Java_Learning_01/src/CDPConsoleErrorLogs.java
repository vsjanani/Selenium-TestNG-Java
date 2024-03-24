import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.emulation.Emulation;
import org.openqa.selenium.devtools.v120.log.Log;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.ConnectionType;


public class CDPConsoleErrorLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver objChromeDriver = new ChromeDriver();
		DevTools objDevTools = objChromeDriver.getDevTools();
		objDevTools.createSession();
		objDevTools.send(Log.enable());
		objDevTools.addListener(Log.entryAdded(), consumingRequest->{
			System.out.println(consumingRequest.getText());
		});
		objChromeDriver.get("https://www.amazon.com/hell");
		objDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		objDevTools.send(Network.emulateNetworkConditions(true, 3000, 20000, 10000, Optional.of(ConnectionType.WIFI)));
		objDevTools.send(Emulation.setGeolocationOverride(Optional.of(17), Optional.of(78), Optional.of(1)));

		objChromeDriver.get("https://my-location.org/");

//		objChromeDriver.get("https://www.amazon.com");
		
	}

}
