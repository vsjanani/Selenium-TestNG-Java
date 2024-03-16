import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Cookies {
	
	@Test(enabled = true)
	public void check() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://mychart.multicare.org/mymulticare/Authentication/Login?");
		driver.findElement(By.id("Login")).sendKeys("jansree90@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Kels3road");
		driver.findElement(By.id("submit")).click();
		driver.get("https://mychart.multicare.org/MyMultiCare/app/communication-center/");
	}}
//		File file = new File("Cookies.data");							 
//        try		 
//        {	   
//            // Delete old file if exists 
//			file.delete();		 
//            file.createNewFile();			 
//            FileWriter fileWrite = new FileWriter(file);							 
//            BufferedWriter Bwrite = new BufferedWriter(fileWrite);							 
//            // loop for getting the cookie information 		 
//            	 
//            // loop for getting the cookie information 		 
//            for(Cookie ck : driver.manage().getCookies())							 
//            {			 
//                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));																									 
//                Bwrite.newLine();              
//            }			 
//            Bwrite.close();			 
//            fileWrite.close();	 
//             
//        } 
//        catch(Exception ex)					 
//        {		 
//            ex.printStackTrace();			 
//        }		 
//    }		 
//		
//		
//		
//	
//	
//	@Test(enabled = true)
//	public void another() {
//		WebDriver driver = new ChromeDriver();
//		try{			
//			
//				      
//	        File file = new File("Cookies.data");							 
//	        FileReader fileReader = new FileReader(file);							 
//	        BufferedReader Buffreader = new BufferedReader(fileReader);							 
//	        String strline;			 
//	        while((strline=Buffreader.readLine())!=null){									 
//	        StringTokenizer token = new StringTokenizer(strline,";");									 
//	        while(token.hasMoreTokens()){					 
//	        String name = token.nextToken();					 
//	        String value = token.nextToken();					 
//	        String domain = token.nextToken();					 
//	        String path = token.nextToken();					 
//	        Date expiry = null;					 
//	        		 
//	        String val;			 
//	        if(!(val=token.nextToken()).equals("null")) 
//			{		 
//	        	expiry = new Date(val);					 
//	        }		 
//	        Boolean isSecure = new Boolean(token.nextToken()).								 
//	        booleanValue();		 
//	        Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);			 
//	        System.out.println(ck); 			 
//	        System.out.println(ck); 
//	        driver.manage().addCookie(ck); // This will add the stored cookie to your current session					 
//	        }		 
//	        }		 
//	        }catch(Exception ex){					 
//	        ex.printStackTrace();			 
//	        }		 
//		driver.get("https://mychart.multicare.org/mymulticare/Authentication/Login?");					 
//	}	 
//	


