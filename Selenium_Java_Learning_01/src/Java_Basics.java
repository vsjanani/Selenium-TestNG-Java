import java.util.ArrayList;
import java.util.Arrays;

public class Java_Basics {
	public static void main(String[] args) {
//	****************	arrays *******************************	
		int[] mylist = {1, 2, 3, 4, 5};
		System.out.println(mylist[1]);
		mylist[1] = 100;
		System.out.println(Arrays.toString(mylist));
		for (int i : mylist) {
			System.out.println(i);
		}
		System.out.println(mylist.length + "is the length of mylist");
		for(int i=0; i < mylist.length; i++) {
			System.out.println(mylist[i]);
		}
		// ***********************If else*****************************;******
		for(int i=0; i < mylist.length; i++) {
			System.out.println(mylist[i]*2);
		}
		for(int i : mylist) { 
			if (i != 100) {
			System.out.println(i*2);
			}
			else {
				System.out.println("Value cannot be multiplied as it is equal to" + i);
			}
		}
		ArrayList<String> mylist1 = new ArrayList<String>();
		mylist1.add("my name is janani");
		mylist1.add("sanjeev krishna");
		System.out.println(mylist1.size());
		System.out.println(mylist1.isEmpty());
		System.out.println("here it is" + mylist1.get(0));
		System.out.println(mylist1);
		for (String i : mylist1) {
			String[] j = i.split(" ");
			for (String k : j) {
				System.out.println(k);
				
			}
		}
		String k = new String("my name is janani");
		String[] m = k.split(" ");
		System.out.println(m[0]);
		String f = "hi hello";
		String[] b = f.split(" ");
		System.out.println(b[0]);
		
	
		
		
	}

}

