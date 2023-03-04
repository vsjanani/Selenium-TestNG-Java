import java.io.IOException;
import java.util.Map;

import org.testng.annotations.Test;
public class ExcelReaderTest2 {
    
	@Test(dataProvider="mydataclass", dataProviderClass=ExcelReader2.class)
    public void comeon(Map<String, Map<String, String>> excelData) {
//        ExcelReader2 ex = new ExcelReader2("C://Users//jansr//Downloads//DemoDataSetUp.xlsx", 0);
//        Map<String, Map<String, String>> excelData =ex.getExcelAsMap();
        System.out.println("Excel Data for 2nd row and column- AccountNo : "+excelData.get("2").get("AccountNo"));
        System.out.println("excelData as Map: "+excelData);
    }
}  