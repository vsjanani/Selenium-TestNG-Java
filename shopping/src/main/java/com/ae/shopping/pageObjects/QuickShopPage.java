package com.ae.shopping.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickShopPage {
	WebDriver objWebDriver;

	public QuickShopPage(WebDriver objWebDriver){
		this.objWebDriver = objWebDriver;
		PageFactory.initElements(objWebDriver, this);
		
	}
	
	@FindBy(css=".qv-wrap h1")
	private WebElement lblProductTitle;
	
	public String getProductTitle() {
		return lblProductTitle.getText();
	}
}
