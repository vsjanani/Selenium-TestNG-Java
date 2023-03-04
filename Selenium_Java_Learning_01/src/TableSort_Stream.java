import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableSort_Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jansr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driverObj = new ChromeDriver();
		driverObj.manage().window().maximize();
		driverObj.get("https://the-internet.herokuapp.com/tables");
		driverObj.findElement(By.cssSelector("#table1 tr th:nth-child(1)")).click();
		List<WebElement> LastNameList = driverObj.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]"));
		List<String> actualList = LastNameList.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> expList = LastNameList.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
		System.out.println(expList.equals(actualList));
		Assert.assertEquals(expList, actualList, "This is not equal");
		List<String> mylist = LastNameList.stream().filter(t->t.getText().equalsIgnoreCase("Doe")).map(t->getDueAmount(t)).collect(Collectors.toList());
		System.out.println(mylist.get(0));
		
	}

	private static String getDueAmount(WebElement t) {
		// TODO Auto-generated method stub
		String DoeDueAmount = t.findElement(By.xpath("following-sibling::td[3]")).getText();
		return DoeDueAmount;
	}

}
