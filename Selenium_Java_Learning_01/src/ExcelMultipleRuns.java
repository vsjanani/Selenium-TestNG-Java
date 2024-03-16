import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelMultipleRuns {
	@DataProvider 
	public static Object[][] ETH() throws IOException {
		FileInputStream objFIS = new FileInputStream("C://Users//jansr//Downloads//DemoDataSetUp.xlsx");
		XSSFWorkbook objWorkBook = new XSSFWorkbook(objFIS);
		XSSFSheet objWorkSheet = objWorkBook.getSheet("check");
		Iterator<Row> iteratorRow = objWorkSheet.rowIterator();
		Row rowFirst = iteratorRow.next();
		int intTotalRows = objWorkSheet.getLastRowNum();
		int intTotalColumns = objWorkSheet.getRow(0).getLastCellNum();
		String[][] mystr = new String[intTotalRows][intTotalColumns];
		System.out.println(intTotalRows);		
		for (int i = 0; i <= intTotalRows - 1; i++) {
			Row nextRow = iteratorRow.next();
			for (int j = 0; j <= intTotalColumns - 1; j++) {
				Cell cell = nextRow.getCell(j);
				mystr[i][j] = cell.getStringCellValue();
//				System.out.println(mystr[i][j]);
			}		
			
		}
		Object[][] myObj = mystr;
		return myObj;
	}
	
	@Test(dataProvider = "ETH")
	public void hello(String t1, String t2, String t3) throws IOException {
//		String[][] myobj = ExcelToHashMap.ETH();
		assert true;
	}
}