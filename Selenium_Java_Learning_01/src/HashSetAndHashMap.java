import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class HashSetAndHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> h = new HashSet<Integer>();
		h.add(1);
		h.add(1);
		h.add(3);
		System.out.println(h);
		System.out.println(h.size());
		Iterator<Integer> itrObj = h.iterator();
		while(itrObj.hasNext()) {
			System.out.println(itrObj.next());
		}
		
		HashMap<Integer, String> hello = new HashMap<Integer, String>();
		hello.put(1, "janani");
		hello.put(2, "krishna");
		System.out.println(hello);
		//now lets put this map into hashset and display value one after another like  list.
		Set<Entry<Integer, String>> hi = hello.entrySet();
		Iterator<Entry<Integer, String>> itrHi = hi.iterator();
		while(itrHi.hasNext()) {
			System.out.println(itrHi.next().getKey() + itrHi.next().getValue());
			//to separate this one after one
//			System.out.println(itrHi.next().getKey());
//			System.out.println(itrHi.next().getValue());
		
		}
	}

}
