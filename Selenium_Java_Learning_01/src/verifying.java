import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class verifying {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		publicCheck name = new publicCheck();
		System.out.print(name.myMessageString);
		String check = args[0].equals("try")? "output from iternory expression" : "not fine";
		System.out.println(check);
//		EdgeOptions options = new EdgeOptions();
//		WebDriver objWebDriver = new RemoteWebDriver(new URL("http://10.0.0.152:4444"), options);
//		objWebDriver.get("https://www.google.com");
//		System.out.println(objWebDriver.getTitle());
		EdgeDriver driver = new EdgeDriver();
//		driver.maybeGetBiDi()
		
	}

}
