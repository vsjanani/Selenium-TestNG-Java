import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.log.Log;
import org.openqa.selenium.devtools.v108.network.Network;
import org.openqa.selenium.devtools.v108.network.model.ConnectionType;


public class CDPConsoleErrorLogs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver objChromeDriver = new ChromeDriver();
		DevTools objDevTools = objChromeDriver.getDevTools();
		objDevTools.createSession();
		objDevTools.send(org.openqa.selenium.devtools.v108.log.Log.enable());
		objDevTools.addListener(Log.entryAdded(), consumingRequest->{
			System.out.println(consumingRequest.getText());
		});
		objChromeDriver.get("https://www.amazon.com/hell");
		objDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		objDevTools.send(Network.emulateNetworkConditions(true, 3000, 20000, 10000, Optional.of(ConnectionType.WIFI)));
		objChromeDriver.get("https://www.amazon.com");
		
	}

}
