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
public class AppTest2 
{
    /**
     * Rigorous Test :-)
     * @throws MalformedURLException 
     */
    
    
    @Test
    public void shouldAnswerWithTrue1() throws MalformedURLException
    {
    	EdgeOptions options = new EdgeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        driver.get("https://www.google.com");
    	System.out.println(driver.getCurrentUrl());
    	Assert.assertTrue( true );
    }
    }
