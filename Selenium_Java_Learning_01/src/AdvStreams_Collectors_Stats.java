import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdvStreams_Collectors_Stats {
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		ArrayList<Integer> num = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		int count = num.stream().mapToInt(Integer::intValue).sum();
		System.out.println("checking addition" + count);
		System.out.println("adding all numbers" +num.addAll(0, num));
		int sum = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);
		int sumAgain = numbers.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println(sumAgain);		

		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
		
		String string = "Item1 10 Item2 25 Item3 30 Item4 45";

		Integer sum1 = Arrays.stream(string.split(" ")).filter(s->s.matches("\\d+")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(sum1);	
		Integer sum11 = Arrays.stream(string.split(" ")).filter(s->s.matches("\\d+")).mapToInt(Integer::parseInt).sum();
		System.out.println(sum11);	
		List<Integer> mynum = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		Double value = mynum.stream().collect(Collectors.averagingInt(Integer::intValue));
		System.out.println(value);  
		List numbers1 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		//checking git commands	
		//second git commit hello
		
		
	}

}
