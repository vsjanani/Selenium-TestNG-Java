import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HashMapFrmJson {
	
	@Test(dataProvider="dataSetUp")	
	public void launchApp(HashMap<String, String> myDataSetUp) {
//		WebDriver objWebDriver = new ChromeDriver();
//		objWebDriver.get("https://mychart.med.utah.edu/mychart/Authentication/Login?");
//		objWebDriver.manage().window().maximize();
//		objWebDriver.findElement(By.cssSelector("#Login")).sendKeys(myDataSetUp.get("email"));
//		objWebDriver.findElement(By.cssSelector("#Password")).sendKeys(myDataSetUp.get("password"));
		System.out.println(myDataSetUp);
	}
	
	@DataProvider
	public Object[][] dataSetUp() throws IOException {
		List<HashMap<String, String>> lstDataSetUp= jsonToHashMap(System.getProperty("user.dir")+"/src/datasetup.json");
		return new Object[][] {{lstDataSetUp.get(0)}, {lstDataSetUp.get(1)}};
	}
	
	
	public static List<HashMap<String,String>> jsonToHashMap(String strFilePath) throws IOException{
		String strFileContent = FileUtils.readFileToString(new File(strFilePath), StandardCharsets.UTF_8);
		ObjectMapper objMapper = new ObjectMapper();
		List<HashMap<String, String>> lstDataFrmMapper = objMapper.readValue(strFileContent, new TypeReference<List<HashMap<String, String>>>(){});		
		return lstDataFrmMapper;
		
	}
	

}
