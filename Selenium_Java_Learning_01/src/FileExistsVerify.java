import java.io.File;

public class FileExistsVerify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("user.dir"));
		File f = new File(System.getProperty("user.dir")+"/src/Streams.java");
		
		System.out.println(f.exists());
			
	}

}
