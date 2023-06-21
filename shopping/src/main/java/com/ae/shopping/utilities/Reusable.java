package com.ae.shopping.utilities;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable {
	WebDriver objWebDriver;
	
	
	public Reusable(WebDriver objWebDriver) {
		this.objWebDriver = objWebDriver;
	}
	
	public void waitForVisibility(WebElement webElement) {
		WebDriverWait objExplicitWait = new WebDriverWait(objWebDriver, Duration.ofSeconds(8));
		objExplicitWait.until(ExpectedConditions.visibilityOf(webElement));
		
	}
//	
//	public WebElement checkForPresence(By byLocator) {
//		WebDriverWait objExplicitWait = new WebDriverWait(objWebDriver, Duration.ofSeconds(8));
//		return objExplicitWait.until(ExpectedConditions.alertIsPresent(byLocator));
//		
//	} 
	
	public void hoverMouseTo(WebElement webElement) {
		Actions objMouseHover = new Actions(objWebDriver);
		objMouseHover.moveToElement(webElement).build().perform();		
	}
	
	public void clickMouseOn(WebElement webElement) {
		Actions objMouseHover = new Actions(objWebDriver);
		objMouseHover.moveToElement(webElement).click().build().perform();		
	}
	
	
	
	
	
}
	
