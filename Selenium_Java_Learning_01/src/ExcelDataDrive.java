import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDataDrive {
//@Test
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		ArrayList<String> arrlstDataFromExcel = new ArrayList<String>();
		FileInputStream objFIS = new FileInputStream("C://Users//jansr//Downloads//DemoDataSetUp.xlsx");
		XSSFWorkbook objWorkBook = new XSSFWorkbook(objFIS);
		XSSFSheet objWorkSheet = objWorkBook.getSheet("SeleniumDemo");
//		System.out.println(objWorkSheet.getRow(0).getCell(0));
		Iterator<Row> objIteratorRow = objWorkSheet.rowIterator();
		Row objFirstRow = objIteratorRow.next(); // next() refers to first row. If next is used again, second row will
													// be selected.
		Iterator<Cell> objIteratorCell = objFirstRow.cellIterator();
		Cell objCellForHeading = null;
//		int intColumn = -1; //so that first increment would be 0 and it can be assumed as first column. in excel first row or column starts with 0.
		while (objIteratorCell.hasNext()) {
			objCellForHeading = objIteratorCell.next();
			//			intColumn++;

			if (objCellForHeading.getStringCellValue().equalsIgnoreCase("TestCase")) {
				System.out.println(objCellForHeading.getAddress());
				break;

			}
		}

		System.out.println("column is" + objCellForHeading.getAddress().getColumn());
		int intColumnContainsHeading = objCellForHeading.getAddress().getColumn();
		while (objIteratorRow.hasNext()) {
			Row nextRow = objIteratorRow.next();			
//			nextRow.getLas
			if (nextRow.getCell(intColumnContainsHeading).getStringCellValue().equalsIgnoreCase("SeleniumDemo")) {
				// fetch other cell values in that row.
				Iterator<Cell> objCellForValues = nextRow.cellIterator();
				while (objCellForValues.hasNext()) {
//					System.out.println(objCellForValues.next().getStringCellValue());
					Cell cellOutput = objCellForValues.next();
//					System.out.println(cellOutput.getCellType());
					arrlstDataFromExcel.add(cellOutput.toString());
//					arrlstDataFromExcel.add(objCellForValues.next().getStringCellValue());
					
				}
				break;
			}

		}
//		Object[][] myobj = new Object[][] {{arrlstDataFromExcel.get(0)},{arrlstDataFromExcel.get(1)}, {arrlstDataFromExcel.get(2)}};
		Object[][] myobj = new Object[][] {{arrlstDataFromExcel}};
		System.out.println(arrlstDataFromExcel.size());
		System.out.println("myobj length is "+myobj.length);
		System.out.println(myobj[0][0]);
//		System.out.println(myobj[1][0]);
//		System.out.println(myobj[2][0]);
	}
	
//	@Test(dataProvider = "hehe")
//	public void hello(String t1) throws IOException {
//
//		assert true;
//	}


}
