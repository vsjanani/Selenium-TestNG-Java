import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestngCheck {
	WebDriver driver = new ChromeDriver();
	
	int i =10;
	int j = i+1;
	
	@Test (priority=1)
	public void testAnnotationCheck() {
		i=i+10;
		System.out.println("it is working fine" + i + j);
		driver.get("https://www.google.com");
	}
	
	@Test(priority=2)
	public void checkagain() {
		System.out.println("second method" + i);
	}

}
