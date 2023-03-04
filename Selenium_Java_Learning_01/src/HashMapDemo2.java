import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HashMapDemo2 {

	@Test(dataProvider = "credentials")
	public void launchApp(HashMap<String, String> dataSetUp) throws IOException {
//		HashMap<String, String> myMap = HashMapDemo2.credentials();
		
		
//		WebDriver objWebDriver = new ChromeDriver();
//		objWebDriver.get("https://mychart.med.utah.edu/mychart/Authentication/Login?");
//		objWebDriver.manage().window().maximize();
//		objWebDriver.findElement(By.cssSelector("#Login")).sendKeys(dataSetUp.get("email"));
//		objWebDriver.findElement(By.cssSelector("#Password")).sendKeys(dataSetUp.get("password"));
		System.out.println(dataSetUp);

	}

	@DataProvider
	public static Object[][] credentials() throws IOException {
		FileInputStream objFIS = new FileInputStream("C://Users//jansr//Downloads//DemoDataSetUp.xlsx");
		XSSFWorkbook objWorkBook = new XSSFWorkbook(objFIS);
		XSSFSheet objWorkSheet = objWorkBook.getSheet("AEShopping");
		HashMap<String, String> myMap = new HashMap<String, String>();
//		System.out.println(objWorkSheet.getSheetName());
		Iterator<Row> iteratorRow = objWorkSheet.rowIterator();
		Row rowFirst = iteratorRow.next();
		Iterator<Cell> iteratorCell = rowFirst.cellIterator();
		int intColumnHeading;
		while (iteratorCell.hasNext()) {
			Cell cell = iteratorCell.next();
			if (cell.toString().equalsIgnoreCase("exptdParams")) {
				intColumnHeading = cell.getColumnIndex();
				while (iteratorRow.hasNext()) {
					Row rowNext = iteratorRow.next();
					Cell cellExptdParams = rowNext.getCell(intColumnHeading);
					Cell cellExptdValues = rowNext.getCell(intColumnHeading + 1);
					myMap.put(cellExptdParams.toString(), cellExptdValues.toString());

				}
			}
		}
		System.out.println(myMap);
		return new Object[][] {{myMap}};
	}
}
