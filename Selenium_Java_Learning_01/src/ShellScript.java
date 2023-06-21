import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class ShellScript {
	@Test
	public void hello() throws IOException {
		Runtime.getRuntime().exec(
		        "cmd /c start he.sh",
		        null,
		        new File("C:\\Users\\jansr\\Downloads\\"));
	}}

