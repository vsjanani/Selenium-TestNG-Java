import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InjectCookies {
	
	@Test
	
	public void inject() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://mychart.multicare.org/mymulticare/Authentication/Login?");
//		driver.manage().addCookie();
	}

}
