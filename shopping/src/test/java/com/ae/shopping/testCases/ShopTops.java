package com.ae.shopping.testCases;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.ae.shopping.baseTest.DawnDusk;
import com.ae.shopping.baseTest.RetryFailedTest;
import com.ae.shopping.pageObjects.MegaMenuPage;
import com.ae.shopping.pageObjects.QuickShopPage;
import com.ae.shopping.pageObjects.WomenTopsPage;

public class ShopTops extends DawnDusk {
//	public MegaMenuPage objMegaMenuPg;
	public WomenTopsPage objWomenTopsPg;
	public QuickShopPage objQuickShopPg;	 
			
	@Test(dataProvider= "exptdDataSetUp")
	public void F2301_AE_product_description_display(HashMap<String, String> exptdDataSetUp) {
		objMegaMenuPg.getOptionFromWomen(exptdDataSetUp.get("exptdOptFrmWomen"));
		objWomenTopsPg = objMegaMenuPg.clickOptFrmWomen(exptdDataSetUp.get("exptdOptFrmWomen"));
		objQuickShopPg = objWomenTopsPg.clickQuickShopForSelectedProduct(exptdDataSetUp.get("exptdProdName"));
		String strProductName = objQuickShopPg.getProductTitle();
		Assert.assertEquals(strProductName, exptdDataSetUp.get("exptdProdName"));
	}
	
	
}
