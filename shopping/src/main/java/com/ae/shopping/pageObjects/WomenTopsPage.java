package com.ae.shopping.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ae.shopping.utilities.Reusable;

public class WomenTopsPage extends Reusable{
	
	WebDriver objWebDriver;
	
	public WomenTopsPage(WebDriver objWebDriver) {
		super(objWebDriver);
		this.objWebDriver = objWebDriver;
		PageFactory.initElements(objWebDriver, this);
	}
	
//	@FindBy(xpath="//div[@id='scrollable-area-ember54']/parent::div/h3")
//	WebElement sptlthdrNowTrending;
	
	@FindBy(css=".top-content .spotlight-header")
	private WebElement lblNowTrending; //it is changed now, check website and change label if this element using script has to be passed.
	
	@FindBy(xpath="(//div[@class='_wrapper_1c1emu'])[1] //h3")
	private List<WebElement> lstNowTrendingProducts;
	
	private By imgProduct = By.xpath("../../preceding-sibling::div");
	
	private By lblQuickShop = By.xpath("../../preceding-sibling::div/a[2]");
	
	
//	(//div[@class='_wrapper_1c1emu'])[1] //h3/../../preceding-sibling::div/a[2]
	
	public Boolean getNowTrendingProdName(String strFrmNowTrending) {
		waitForVisibility(lblNowTrending);
		Boolean blnOptFrmNowTrending = lstNowTrendingProducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(strFrmNowTrending));
		return blnOptFrmNowTrending;
	}
	
		
	public QuickShopPage clickQuickShopForSelectedProduct(String strFrmNowTrending) {
		WebElement lblProduct = lstNowTrendingProducts.stream().filter(s->s.getText().equalsIgnoreCase(strFrmNowTrending)).findFirst().orElse(null);
		System.out.println(lblProduct.isDisplayed());
		System.out.println(lblProduct.getText());
		JavascriptExecutor jse = (JavascriptExecutor) objWebDriver;
		jse.executeScript("window.scrollBy(0,700)");
//		jse.executeScript("arguments[0].scrollIntoView();", lblProduct);
		Actions action = new Actions(objWebDriver);
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
		hoverMouseTo(lblProduct.findElement(imgProduct));
		hoverMouseTo(lblProduct.findElement(lblQuickShop));	
		System.out.println(lblProduct.findElement(lblQuickShop).getText());
		clickMouseOn(lblProduct.findElement(lblQuickShop));
		QuickShopPage objQuickShopPg = new QuickShopPage(objWebDriver);
		return objQuickShopPg;
		
		

	}

	

	
	
	

}
