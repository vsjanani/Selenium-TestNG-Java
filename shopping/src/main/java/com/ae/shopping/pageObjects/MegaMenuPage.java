package com.ae.shopping.pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ae.shopping.utilities.Reusable;

public class MegaMenuPage extends Reusable {
	WebDriver objWebDriver;

	public MegaMenuPage(WebDriver objWebDriver) {
		super(objWebDriver);
		this.objWebDriver = objWebDriver;
		PageFactory.initElements(objWebDriver, this);			
	}
	
	
	
//	By popup = By.cssSelector(".bx-close");
	
	@FindBy(xpath="//div[@aria-label='Women category']")
	private WebElement mnuWomen;
	
	@FindBy(xpath="//a[text() = 'Categories']")
	private WebElement subMnuWomen;
	
	@FindBy(xpath="(//a[text() = 'Categories']/following-sibling::div)[1]/a")
	private List<WebElement> lstWomen;
	
		
	public Boolean getOptionFromWomen(String strFrmLstWomen) {
	hoverMouseTo(mnuWomen);
	waitForVisibility(subMnuWomen);	
	Boolean blnOptFrmWomen = lstWomen.stream().anyMatch(s->s.getText().equalsIgnoreCase(strFrmLstWomen));
	return blnOptFrmWomen;	
	}
	
	public WomenTopsPage clickOptFrmWomen(String strFrmLstWomen) {
		WebElement optFrmLstWomenEle = lstWomen.stream().filter(s->s.getText().equalsIgnoreCase(strFrmLstWomen)).findFirst().orElse(null);
		optFrmLstWomenEle.click();
		WomenTopsPage objWomenTopsPg = new WomenTopsPage(objWebDriver);
		return objWomenTopsPg;
		}

	
	
}
