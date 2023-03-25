package jenkinsgitintegration;

import static org.junit.Assert.assertTrue;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");    	
    	WebDriver objWebDriver = new ChromeDriver(options);
    	objWebDriver.get("https://www.amazon.com");
    	System.out.println("This is jenkinsgitintegration testing by Janani");
        Assert.assertTrue( true );
    }
}
