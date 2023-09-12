import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateLambda {

	public static void main(String[] args) {
		Predicate<Integer> expression = i->i>10;
		Predicate<Integer> expression1 = i->i<20;
		System.out.println(expression.and(expression1).test(15));
		System.out.println(expression.and(expression1).negate().test(15));
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		List<Integer> arr2 = new ArrayList<Integer>();
		arr2.addAll(arr);
		System.out.println(arr2);
		
		    
		    
		    List<Integer> arr3 = new ArrayList<Integer>();
		    for(int i=3; i<=9; i++){
		        arr3.add(i);
		        
		        
		    }
		    
		    List<Integer> arr5 = arr3.stream().filter(s->!(s%2==0)).collect(Collectors.toList());
		    System.out.println(arr5);
		    
		    
		   		
//		String hi = "janani";
		
		
	}
}
