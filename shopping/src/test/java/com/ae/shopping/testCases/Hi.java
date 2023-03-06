package com.ae.shopping.testCases;
import java.util.HashMap;
import java.util.Optional;

import org.junit.Assert;
import org.openqa.selenium.devtools.v108.network.Network;
import org.openqa.selenium.devtools.v108.network.model.ConnectionType;
import org.testng.annotations.Test;

import com.ae.shopping.baseTest.DawnDusk;
import com.ae.shopping.pageObjects.MegaMenuPage;

public class Hi extends DawnDusk{	

	@Test
	public void micheck() {
		System.out.println("from micheck test case" + strErrorCode);
		objDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		objDevTools.send(Network.emulateNetworkConditions(true, 3000, 20000, 10000, Optional.of(ConnectionType.WIFI)));
		objWebDriver.get("https://www.amazon.com");
		Assert.assertTrue(false);
		
		
	}
	

}
