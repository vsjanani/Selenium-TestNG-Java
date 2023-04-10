package PipelinesDemo;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest4 
{
    /**
     * Rigorous Test :-)
     * @throws MalformedURLException 
     */
        @Test
    public void shouldAnswerWithTrue3() throws MalformedURLException
    {
    	ChromeOptions options = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        driver.get("https://www.ae.com");
    	System.out.println(driver.getCurrentUrl());
    	Assert.assertTrue( true );
    }
   
   
    
}
