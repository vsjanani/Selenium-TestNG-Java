import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class ParentDemo {
	public WebDriver driver;
	@BeforeTest
	public void invokeChrome() {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		
	}
}
