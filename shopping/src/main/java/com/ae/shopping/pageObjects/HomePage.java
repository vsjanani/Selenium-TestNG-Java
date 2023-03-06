package com.ae.shopping.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ae.shopping.utilities.Reusable;
 
public class HomePage extends Reusable {
	
	
	public WebDriver objWebDriver;

		public HomePage(WebDriver objWebDriver){
			super(objWebDriver);
			this.objWebDriver = objWebDriver;
			PageFactory.initElements(objWebDriver, this);						
		}
		
		@FindBy(id="onetrust-accept-btn-handler")
		private WebElement btnAcceptAllCookies;
		
		@FindBy(css=".bx-close")
		private WebElement popupOffer;
		
		public MegaMenuPage clickAcceptAllCookies() {
			try {
			waitForVisibility(btnAcceptAllCookies);
			btnAcceptAllCookies.click();
			System.out.println("Accepted cookies");
			}
			catch(Exception e) {
				System.out.println(e);
			}
			try {
			waitForVisibility(popupOffer);
			popupOffer.click();
			}
			catch(Exception e) {
				System.out.println(e);
			}
			MegaMenuPage objMegaMenuPg = new MegaMenuPage(objWebDriver);
			return objMegaMenuPg;
						
		}		
		
}
