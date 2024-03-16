import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class ExceptionHandling {

	public static void main(String[] args) throws IOException   {
		Path myPath = Paths.get("C:\\Users\\jansr\\Downloads\\mock.txt");
		String path = "C:\\Users\\jansr\\Downloads\\mocks.txt";
		File file = new File(path);
		if(!file.exists()) {
			throw new FileNotFoundException(path);
		}
		String chec = null;
		
			chec = Files.readString(myPath);
		
			System.out.println(chec);
			System.out.println("executing other statements");
		
//		chec.forEach(System.out::println);
//		List<String> check = Files.newBufferedReader(myPath).lines().map(s->s).collect(Collectors.toList());
//		check.forEach(System.out::println);
		

	}

}
