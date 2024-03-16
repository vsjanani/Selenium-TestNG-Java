package moulton.scanning.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import moulton.scanning.utilities.ExcelWriter;
import moulton.scanning.utilities.ReusableMethods;

public class ClientContactsPage extends ReusableMethods{
	
	WebDriver objWebDriver;
	public ClientContactsPage(WebDriver objWebDriver) {
		super(objWebDriver);
		this.objWebDriver = objWebDriver;
		PageFactory.initElements(objWebDriver, this);		
	}
	
	private By eleContactRows = By.cssSelector(".test-contact-row");
	
	private By eleClientID = By.cssSelector(".first-name a");
	
	private By eleFirstName = By.cssSelector(".test-contact-row .first-name");
	
	private By eleLastName = By.cssSelector(".test-contact-row .last-name");
	
	public void extractDetails() throws IOException {
		List<WebElement> lstContactRows = objWebDriver.findElements(eleContactRows);
		for(WebElement eachContact : lstContactRows)
		{
			String strClientID = eachContact.findElement(eleClientID).getAttribute("href").split("/")[5];
			String strFirstName = eachContact.findElement(eleFirstName).getText();
			String strLastName = eachContact.findElement(eleLastName).getText();
			ExcelWriter objExcelWriter = new ExcelWriter();
			objExcelWriter.writeOuputToExcel(strFirstName, strLastName, strClientID);			
		}
		
	}

}
