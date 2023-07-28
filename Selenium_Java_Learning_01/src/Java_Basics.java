import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Java_Basics {
	public static void main(String[] args) {
//	****************	arrays *******************************	
		int[] mylist = {1, 2, 3, 4, 5};
		System.out.println(mylist[1]);
		mylist[1] = 100;
		System.out.println("arrays to string" + Arrays.toString(mylist));
		for (int i : mylist) {
			System.out.println(i);
		}
		System.out.println(mylist.length + "is the length of mylist");
		Arrays.sort(mylist);
		for(int i : mylist) {
			System.out.println(i);
		}
		for(int i=0; i < mylist.length; i++) {
			System.out.println(mylist[i]);
		}
		System.out.println("check here");
		
		
		// ***********************If else*****************************;******
		for(int i=0; i < mylist.length; i++) {
			System.out.println("next one" + mylist[i]*2);
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
		System.out.println("here it is" + mylist1);
		System.out.println(mylist1 + "checking");
		mylist1.forEach(System.out::println);
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
		
		HashMap<String, Integer> myMap = new HashMap<String, Integer>();
		myMap.put("apple", 10);
		myMap.put("orange", 20);
		for(Entry<String, Integer> my : myMap.entrySet()) {
		System.out.println(my.getKey()+"costs"+ my.getValue());
		}
	
		
		
	}

}

