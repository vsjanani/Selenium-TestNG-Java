import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RepetitionStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] a = {2,3,4,4,5,7};
		List<Integer> q = Arrays.asList(a);		
		HashSet t = new HashSet();
		q.stream().filter(s->!t.add(s)).forEach(System.out::println);
		Map<Integer, Integer> tic = q.stream().collect(Collectors.toMap(c->c, c->1, Integer::sum));
		//instead of c->Function.identity() also can be used. both refers to Key of a map. whereas Integer::sum output gives value.
		System.out.println(tic);
		List<String> companies = Arrays.asList("Meta","Meta","Apple");	 
		
        // 1.2 print original List to console
        System.out.println("1. Original List with duplicates : \n");
        companies.forEach(System.out::println);
 
 
        // 2. get duplicate count using Map
        Map<String, Integer> duplicateCountMap = companies
                .stream()
                .collect(
                        Collectors.toMap(Function.identity(), company -> 1, Integer::sum)
                        );
 
 
        // 2.1 print Map for duplicate count
        System.out.println("\n2. Map with Key and its duplicate count : \n");
        duplicateCountMap.forEach(
                (key, value) -> System.out.println("Key : " + key + "\t Count : " + value)
                );
 
		
		
		
		
		
		
		

	}

}
