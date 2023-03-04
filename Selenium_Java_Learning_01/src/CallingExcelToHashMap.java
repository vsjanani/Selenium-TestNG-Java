import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

public class CallingExcelToHashMap {

	@Test(dataProvider="hello", dataProviderClass =ExcelMultipleRuns.class )
	public void E2H(HashMap<String, String> myMap) throws IOException {
//		ExcelToHashMap objEH = new ExcelToHashMap();
//		objEH.ETH();
		System.out.println(myMap);
	}
}
