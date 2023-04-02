package com.ae.shopping.baseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v111.network.Network;
import org.openqa.selenium.devtools.v111.log.Log;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.ae.shopping.pageObjects.HomePage;
import com.ae.shopping.pageObjects.MegaMenuPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.common.graph.Network;

public class DawnDusk {

	public WebDriver objWebDriver;
	public HomePage objHomePg;
	public MegaMenuPage objMegaMenuPg;
	public DevTools objDevTools;
	public String strErrorCode, strLoadingFailedReason, strConsoleError;
	

	public void driverSetup() throws IOException {
		Properties objProperties = new Properties();
		FileInputStream objFIS = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//com//ae//shopping//resources//GlobalData.properties");
		objProperties.load(objFIS);		
		String strBrowserName = System.getProperty("browserName") != null ? System.getProperty("browserName")
				: objProperties.getProperty("browserName");
		ChromeOptions objChromeOptions = new ChromeOptions();
		EdgeOptions objEdgeOptions = new EdgeOptions();
		if (strBrowserName.contains("chrome")) {
			if (strBrowserName.contains("headless")) {
				objChromeOptions.addArguments("headless");

			}
//			objChromeOptions.setBrowserVersion("109"); 
			objChromeOptions.setPlatformName("Windows 11");
			objWebDriver = new RemoteWebDriver(new URL("http://10.0.0.152:4444"), objChromeOptions);
			
		}

		else if (strBrowserName.equalsIgnoreCase("edge")) {
			
			objEdgeOptions.addArguments("--disable-notifications");
			objWebDriver = new RemoteWebDriver(new URL("http://10.0.0.152:4444"), objEdgeOptions);
		}

		else {
			System.out.println("invalid browser name");
		}
		objWebDriver.manage().window().setSize(new Dimension(1440, 900));
		objWebDriver.manage().window().maximize();
		objWebDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Augmenter objAug = new Augmenter();
		objWebDriver = objAug.augment(objWebDriver);
		objDevTools = ((HasDevTools) objWebDriver).getDevTools();
		objDevTools.createSession();
		objDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		objDevTools.send(Log.enable());
		objDevTools.addListener(Network.responseReceived(), consumingResponse->{
			String strURL = consumingResponse.getResponse().getUrl();
			int intResponseStatusCode = consumingResponse.getResponse().getStatus();
			if(intResponseStatusCode>399) {
				strErrorCode = strURL + " throws " + intResponseStatusCode + " error";
			}
		});
		objDevTools.addListener(Network.loadingFailed(), consumingResponse->{
			strLoadingFailedReason = consumingResponse.getErrorText();
					
		});
		objDevTools.addListener(Log.entryAdded(), consumingResponse->{
			strConsoleError = consumingResponse.getText();
		});
		
		
		
		
	}

	@BeforeClass(alwaysRun = true) // it is to run even if TestNG groups does not cover this method.
	public void launchApp() throws IOException {

		driverSetup();
		objWebDriver.get("https://www.ae.com");
		objHomePg = new HomePage(objWebDriver);
		objMegaMenuPg = objHomePg.clickAcceptAllCookies();
//		return objHomePg; this is not required because it runs without calling through @BeforeClass and the object is made public.

	}

//	@AfterClass(alwaysRun=true)
//	public void dusk() {
//		objWebDriver.close();
//		
//	}
	
	@BeforeMethod
	public void makeItNull() {
		strErrorCode=null;
		strLoadingFailedReason = null;
		strConsoleError =null;
	}
	
	@DataProvider
	public Object[][] exptdDataSetUp() throws IOException {
		String strFilePath = System.getProperty("user.dir")+"/src/test/java/com/ae/shopping/dataSetUp/dataSetUp.json";
		String strFileContent = FileUtils.readFileToString(new File(strFilePath), StandardCharsets.UTF_8);
		ObjectMapper objMapper = new ObjectMapper();
		List<HashMap<String, String>> hmExptdData = objMapper.readValue(strFileContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return new Object[][] {{hmExptdData.get(0)}};
	}

	@DataProvider
	public Object[][] excelToHashMap() throws IOException {
		FileInputStream objFIS = new FileInputStream("C:/Users/jansr/Downloads/DemoDataSetUp.xlsx");
		XSSFWorkbook objWorkBook = new XSSFWorkbook(objFIS);
		XSSFSheet objWorkSheet = objWorkBook.getSheet("AEShopping");
		HashMap<String, String> hmExcelExptdData = new HashMap<String, String>();
		Iterator<Row> objRowIterator = objWorkSheet.rowIterator();

		Row objFirstRow = objRowIterator.next();
		while (objRowIterator.hasNext()) {
			Row objDataRow = objRowIterator.next();
			Iterator<Cell> objCellIterator = objDataRow.cellIterator();
			String Key = objCellIterator.next().getStringCellValue();
			String Value = objCellIterator.next().getStringCellValue();
			hmExcelExptdData.put(Key, Value);
		}
		return new Object[][] { { hmExcelExptdData } };

	}

}
