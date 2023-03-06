package com.ae.shopping.testCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.shopping.baseTest.DawnDusk;
import com.ae.shopping.baseTest.RetryFailedTest;
import com.ae.shopping.pageObjects.WomenTopsPage;

public class FieldPresenceValidations extends DawnDusk {
	public WomenTopsPage objWomenTopsPg;
	
	@Test(dataProvider= "exptdDataSetUp", groups = {"chromeinvokation"}, retryAnalyzer=RetryFailedTest.class, priority=1)
	public void F2301_AE_url_title(HashMap<String, String> exptdDataSetUp) throws IOException  {
		String strUrlTitle = objWebDriver.getTitle();
		System.out.println(strUrlTitle);
		Assert.assertEquals(strUrlTitle, exptdDataSetUp.get("exptdUrlTitle"));
//		Thread.sleep(3000);
	}
		
	@Test(dataProvider= "exptdDataSetUp",priority=2)	
	public void F2301_AE_womenMenu_topsOption_display(HashMap<String, String> exptdDataSetUp) {
		Boolean blnOptFromWomen = objMegaMenuPg.getOptionFromWomen(exptdDataSetUp.get("exptdOptFrmWomen"));
		Assert.assertTrue(blnOptFromWomen, "Expected option from menu Women is not present");
					
	}
	
	@Test(dataProvider= "exptdDataSetUp",priority=3)
	public void F2301_AE_product_display(HashMap<String, String> exptdDataSetUp) {
		objWomenTopsPg = objMegaMenuPg.clickOptFrmWomen(exptdDataSetUp.get("exptdOptFrmWomen"));
		Boolean blnOptFrmNowTrending = objWomenTopsPg.getNowTrendingProdName(exptdDataSetUp.get("exptdProdName"));
		Assert.assertTrue(blnOptFrmNowTrending, "Expected product name from Now Trending header is not present");
	}
	
	@DataProvider
	public  Object[][] exptdDataSetUp() throws IOException {
		List<HashMap<String, String>> hmExptdDataSetUp =  convertJsontoHashMap(System.getProperty("user.dir")+"/src/test/java/com/ae/shopping/dataSetUp/dataSetUp.json");
		return new Object[][] {{hmExptdDataSetUp.get(0)}};
		
	}

}
