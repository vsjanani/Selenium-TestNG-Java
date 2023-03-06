package com.ae.shopping.testCases;
import java.util.HashMap;
import java.util.Optional;

import org.junit.Assert;
import org.openqa.selenium.devtools.v108.network.Network;
import org.openqa.selenium.devtools.v108.network.model.ConnectionType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ae.shopping.baseTest.DawnDusk;
import com.ae.shopping.pageObjects.MegaMenuPage;

public class ErrorScenario extends DawnDusk{
	
//	@Test(groups = {"chromeinvokation"}, dataProvider = "excelToHashMap")
//	public void F2301_AE_F2301_AE_womenMenu_topsOption_invalid(HashMap<String, String> exptdDataSetUp) {
//		Boolean blnOptFrmWomen = objMegaMenuPg.getOptionFromWomen(exptdDataSetUp.get("exptdOptrmWomen"));
//		Assert.assertFalse("No such option is present in Mega Menu Women", blnOptFrmWomen);
////		System.out.println(exptdDataSetUp.get("exptdOptFrmWomen"));
//		
//			}
	
	@Test
	public void checkDevToolsBrokenLink() {
		objWebDriver.get("https://www.amazon.com/hell");	
		System.out.println("from link broken testcase " + strErrorCode);
		Assert.assertTrue(false);
		
		
	}
	
	@Test
	public void checkNetworkLoadingFailed() throws InterruptedException  {
//		Thread.sleep(2000);
		System.out.println("from networkloadingfailed test case" + strErrorCode);
		objDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		objDevTools.send(Network.emulateNetworkConditions(true, 3000, 20000, 10000, Optional.of(ConnectionType.WIFI)));
		objWebDriver.get("https://www.amazon.com");
		Assert.assertTrue(false);
		
		
	}
	

}
