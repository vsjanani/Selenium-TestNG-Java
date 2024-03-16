package moulton.scanning.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import moulton.scanning.baseTest.DawnDusk;
import moulton.scanning.pageObjects.ClientContactsPage;
import moulton.scanning.pageObjects.LoginPage;

public class TestCases extends DawnDusk {
	
	@Test(priority=1)
	public void loginWebsite() {
		LoginPage objLoginPage = new LoginPage(objWebDriver);
		objLoginPage.login();
		Assert.assertEquals(objWebDriver.getTitle(), "Dashboard - MyCase", "Not logged into MyCase. Incorrect homepage title");
	}
	
	@Test(priority=2)
	public void fetchClientID() throws InterruptedException, IOException {	
		
		for(int i=11; i<=15; i++) {
		String strPageURLs = "https://moulton-law-offices-ps.mycase.com/contacts/clients?page="+i;
		objWebDriver.get(strPageURLs);
		Thread.sleep(2000);
		ClientContactsPage objClientContactsPage = new ClientContactsPage(objWebDriver);
		objClientContactsPage.extractDetails();
		
		
		
		}
	}

}
