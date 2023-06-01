import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileExistsVerify {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		File f = new File(System.getProperty("user.dir")+"/src/Streams.java");		
		System.out.println(f.exists());
		FileInputStream objFIS = new FileInputStream(System.getProperty("user.dir")+"/src/global.properties");
		Properties objProp = new Properties();
		objProp.load(objFIS);
		System.out.println(objProp.getProperty("browser"));
		
			
	}

}
