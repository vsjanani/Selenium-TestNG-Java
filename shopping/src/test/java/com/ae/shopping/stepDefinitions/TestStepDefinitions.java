package com.ae.shopping.stepDefinitions;

import org.testng.Assert;

import com.ae.shopping.baseTest.DawnDusk;
import com.ae.shopping.pageObjects.QuickShopPage;
import com.ae.shopping.pageObjects.WomenTopsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestStepDefinitions extends DawnDusk {
	
	WomenTopsPage objWomenTopsPg;
	QuickShopPage objQuickShopPg;
	Boolean blnOptFrmWomen;

	  @Given("^American Eagle website is opened accepting cookies and popup offer$")
	    public void american_eagle_website_is_opened_accepting_cookies_and_popup_offer() throws Throwable {
	       launchApp(); 
	    }

	    @Given("^(.+) presence is validated$")
	    public void presence_is_validated(String strOptFrmWomen) throws Throwable {
	    	blnOptFrmWomen = objMegaMenuPg.getOptionFromWomen(strOptFrmWomen);
			 
	    }
	    
	    @And ("^(.+) is clicked$")
	    public void is_clicked(String strOptFrmWomen) throws Throwable {
			objWomenTopsPg = objMegaMenuPg.clickOptFrmWomen(strOptFrmWomen); 
	    }

	    @When("^Quick Shop option for selected (.+) is entered$")
	    public void quick_shop_option_for_selected_is_clicked(String strProductName) throws Throwable {
	    	objQuickShopPg = objWomenTopsPg.clickQuickShopForSelectedProduct(strProductName);
	    }

	    @Then("^(.+) is displayed as product title$")
	    public void is_displayed_as_product_title(String strProductName) throws Throwable {
	    	String strActProductName = objQuickShopPg.getProductTitle();
			Assert.assertEquals(strActProductName, strProductName);
	       
	    }
	    
	    @Then("assertion returns false")
	    public void assertion_returns_false() {
			Assert.assertFalse(blnOptFrmWomen, "No such option is present in Mega Menu Women");
	    }
    

}
