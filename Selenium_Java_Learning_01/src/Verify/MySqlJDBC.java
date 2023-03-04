package Verify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class MySqlJDBC {
	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub
		//url is "jdbc:mysql://localhost:3306/qadbt" where 3306 is a port number and localhost is the host name(since its local machine, for other machine either ip address may be used, check this once you joined work) hence this should be written as:
		Connection DBConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qadbt", "root", "SanjeevKrish@01");
		Statement objDBConnected = DBConn.createStatement();
		ResultSet objResultSet = objDBConnected.executeQuery("select * from SeleniumDemo where id=2");
		objResultSet.next(); //by default it is in base or null row, give next to get first output. just like excel data driver where row iterator. next is used to get first header itself.
		System.out.println(objResultSet.getString("location"));
		WebDriver objWebDriver = new ChromeDriver();
		objWebDriver.get("https://www.google.com");
		objWebDriver.findElement(By.cssSelector(".gLFyf")).sendKeys(objResultSet.getString("location"), Keys.ENTER);
		
		
	}

}
