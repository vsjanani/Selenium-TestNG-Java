package moulton.scanning.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import moulton.scanning.utilities.ReusableMethods;

public class LoginPage extends ReusableMethods {
	
	WebDriver objWebDriver;
	public LoginPage(WebDriver objWebDriver) {
		super(objWebDriver);
		this.objWebDriver = objWebDriver;
		PageFactory.initElements(objWebDriver, this);		
	}
	
	@FindBy(css="#login_session_email")
	private WebElement lblUserName;
	
	@FindBy(css="#login_session_password")
	private WebElement lblPassword;
	
	@FindBy(css="#login-form-submit")
	private WebElement btnLogin;
	
	public void login() {
		lblUserName.sendKeys("joman@moultonlaw.com");
		lblPassword.sendKeys("MLOffices2023");
		btnLogin.click();		
	}
	
	
	
 
	
}
