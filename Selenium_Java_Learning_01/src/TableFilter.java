import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jansr\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driverObj = new ChromeDriver();
		driverObj.manage().window().maximize();
		driverObj.get("https://computer-database.gatling.io/computers");
		driverObj.findElement(By.id("searchbox")).sendKeys("dell");
		driverObj.findElement(By.id("searchsubmit")).click();
		List<WebElement> mylist = driverObj.findElements(By.xpath("//tbody/tr/td[1]"));
		List<Boolean> response= mylist.stream().map(s->s.getText().contains("dello")).collect(Collectors.toList());
		System.out.println(response);
		

	}

}
