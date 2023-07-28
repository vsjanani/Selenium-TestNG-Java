import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v114.network.Network.GetResponseBodyForInterceptionResponse;
import org.openqa.selenium.devtools.v85.network.Network;

public class CDPNetworkReqAndRes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver objChromeDriver = new ChromeDriver();
		DevTools objDevTool = objChromeDriver.getDevTools();
		objDevTool.createSession();
		objDevTool.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//		objDevTool.addListener(Network.requestWillBeSent(), consumingRequest -> {
//			System.out.println(consumingRequest.getRequest().getUrl());
//
//		});
		objDevTool.addListener(Network.responseReceived(), consumingResponse -> {
			String strURL = consumingResponse.getResponse().getUrl();
			int intStatusCode = consumingResponse.getResponse().getStatus();
			if(intStatusCode>399) {System.out.println(strURL + "throws"+ intStatusCode);}
		});

		objChromeDriver.get("https://www.amazon.com/hell");
		objChromeDriver.get("https://www.microsoft.com/hell");
		

	}

}
