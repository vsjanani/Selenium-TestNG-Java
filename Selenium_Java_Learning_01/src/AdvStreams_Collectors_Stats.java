import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdvStreams_Collectors_Stats {
	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		ArrayList<Integer> num = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		int count = num.stream().mapToInt(Integer::intValue).sum();
		System.out.println("checking addition" + count);
		System.out.println("adding all numbers" + num.addAll(0, num));
		int sum = numbers.stream().mapToInt(s -> Integer.valueOf(s)).sum();
		// above can be written as Integer::intValue
		System.out.println(sum);
		int sumAgain = numbers.stream().collect(Collectors.summingInt(Integer::intValue));
		System.out.println(sumAgain);
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
		String string = "Item1 10 Item2 25 Item3 30 Item4 45";
		Integer sum1 = Arrays.stream(string.split(" ")).filter(s -> s.matches("\\d+"))
				.collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(sum1);
		Integer sum11 = Arrays.stream(string.split(" ")).filter(s -> s.matches("\\d+"))
				.mapToInt(s -> Integer.parseInt(s)).sum(); // this can also be written as mapToInt(Integer::parseInt)
		System.out.println(sum11);
		List<Integer> mynum = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		Double value = mynum.stream().collect(Collectors.averagingInt(Integer::intValue));
		System.out.println(value);
		ArrayList<Integer> mylist = new ArrayList<Integer>();
		// To print biggest number in a matrix. Use flatMapToInt to convert all the
		// matrix elements into a flat one single array of elements like
		// {1,2,3,4,5,6,7,89}
		List numbers1 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		int[][] t = { { 4, 2, 3 }, { 9, 1, 6 }, { 7, 8, 9 } };
		List<int[]> hello = Arrays.asList(t);
		int hi = hello.stream().flatMapToInt(s->IntStream.of(s)).min().getAsInt();
//		OptionalInt hi = hello.stream().flatMapToInt(Arrays::stream).min();
		// above two lines are valid only. Can use both.
		// below is to get largest number in a column which has the lowest number in the
		// matrix. so far, lowest number is found.
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[i].length; j++) {
				if (t[i][j] == hi) {
					System.out.println("values are" + i + j);
					for (int k = 0; k < t.length; k++) {

						mylist.add(t[k][j]);
					}
				}
			}
		}
		System.out.println(mylist.stream().mapToInt(x -> x).max());
		System.out.println(hi + "check");
		
		List<String> subList = new ArrayList<String>();  
        subList.add("Maths");  
        subList.add("English");  
        subList.add("French");  
        subList.add("Sanskrit");
        subList.add("Abacus");
        System.out.println("------------Subject List--------------"); 
        
        subList.forEach(sub -> System.out.println(sub));
        System.out.println(subList);
		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		List<Float> productPriceList2 = productsList.stream().filter(p -> p.price > 30000)// filtering data
				.map(p -> p.price) // fetching price
				.collect(Collectors.toList()); // collecting as list
		System.out.println(productPriceList2);

	}

}

class Product {
	int id;
	String name;
	float price;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}
