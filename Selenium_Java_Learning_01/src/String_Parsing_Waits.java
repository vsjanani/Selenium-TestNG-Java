import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class String_Parsing_Waits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jansr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver webdriver_obj = new ChromeDriver();
//		webdriver_obj.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		webdriver_obj.get("http://the-internet.herokuapp.com/dynamic_loading");
		webdriver_obj.findElement(By.partialLinkText("that is hidden")).click();
		webdriver_obj.findElement(By.xpath("//button[text() = 'Start']")).click();


//		In below piece of code, am trying to retrieve visibility of element from function getmystr (it is a webelement, hence return type in getmystr function is mentioned as webelement. 
//	    from the retrieved webelement, am trying to get text, "Hello World!", where, splitting it with space and taking only World!, splitting again with !, taking first element of array from World and !.
		String mystr = getmystr(webdriver_obj).getAttribute("textContent").split(" ")[1].split("!")[0]; // it returns output "World"
		
		Assert.assertEquals(mystr, "World");
		
		
//		String mystr = webdriver_obj.findElement(By.cssSelector("#finish h4")).getAttribute("textContent");
		System.out.println(mystr);	
//		Select mydrop = new Select(webdriver_obj.findElement(By.partialLinkText("that is hidden")));
////		mydrop.
		
	    StringBuilder str = new StringBuilder("Hello");
	    System.out.println(str.reverse());
	    String he = "1hel@%lo3";
		String ste = he.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(ste);
		
	}

	public static WebElement getmystr(WebDriver webdriver_obj) {
		
		return new WebDriverWait(webdriver_obj, Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish h4")));
//		return mystr;
	
	}
}

