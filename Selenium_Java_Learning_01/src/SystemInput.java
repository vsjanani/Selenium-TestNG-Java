import java.util.Scanner;

public class SystemInput {

	public static void main(String[] args) {
		
//		System.getProperty(System.in);
		System.out.println(System.in + "is the input value");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("value is "+n);
		
		
	}
	
}
