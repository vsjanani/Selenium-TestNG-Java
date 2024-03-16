package moulton.scanning.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriter {
	
	@Test
	//String strFirstName, String strLastName, String strClientID
	public void writeOuputToExcel(String strFirstName, String strLastName, String strClientID) throws IOException {
	FileInputStream objFIS = new FileInputStream("C://Users//jansr//Downloads//Client_Contact_Details.xlsx");
	XSSFWorkbook objWorkBook = new XSSFWorkbook(objFIS);
	XSSFSheet objWorkSheet = objWorkBook.getSheet("Client_Contact_Details");
	XSSFRow objRow = objWorkSheet.createRow(objWorkSheet.getLastRowNum()+1);
	objRow.createCell(0).setCellValue(strFirstName);
	objRow.createCell(1).setCellValue(strLastName);
	objRow.createCell(2).setCellValue(strClientID);
	FileOutputStream objFOS = new FileOutputStream("C://Users//jansr//Downloads//Client_Contact_Details.xlsx");
	objWorkBook.write(objFOS);
	
	
	
	}

}
