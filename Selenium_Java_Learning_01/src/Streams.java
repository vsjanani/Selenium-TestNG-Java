import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> mylist2 = new ArrayList<String>();
		mylist2.add("hi");
		mylist2.add("ant");
		mylist2.add("bat");
		mylist2.add("Vanthanam");
//		mylist2.sort(Comparator.reverseOrder());
		System.out.println(mylist2);
		long mycount = mylist2.stream().filter(s->s.startsWith("V")).count();
		System.out.println(mycount);
		mylist2.stream().filter(s->s.equals("hello")).map(s->s.toUpperCase()).forEach(System.out::println);
		List collectList = mylist2.stream().filter(s->s.startsWith("V")).collect(Collectors.toList());
		System.out.println("my new list is " + collectList);
		System.out.println(Stream.of("janani","dinesh", "krishna", "darshini").count());
		mylist2.stream().filter(s->s.length()<3).forEach(System.out::println);		
//		Stream.of("janani","dinesh", "krishna", "darshini").filter(s->s.toUpperCase()).forEach(s->System.out.println(s));
//		ArrayList<String> mylist3 = new ArrayList<String>();
		ArrayList<Integer> answers = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		answers.stream().filter(s->s % 2 == 0).forEach(System.out::println); //this can also be written as forEach(s->System.out.println(s));
		Stream.of("janani", "dinesh", "darshini", "krishna").map(s->s.toUpperCase()).forEach(System.out::println);
		Stream.of("janani", "dinesh", "darshini", "krishna").filter(s->s.startsWith("d")).map(s->s.toUpperCase()).forEach(System.out::println);
		Stream.of("janani", "dinesh", "barshini", "arishna").sorted().forEach(System.out::println);
		ArrayList<String> mylist3 = new ArrayList(Arrays.asList("Kavitha", "Darani", "Keshu", "Sarvesh"));
		
//		Supplier<Stream<String>> mylist4 = () -> Stream.of("janani", "dinesh", "barshini", "arishna");
		Stream mylist4 = Stream.concat(mylist2.stream(), mylist3.stream());
//		 mylist4.sorted().forEach(System.out::println);
		boolean value =mylist4.anyMatch(s->s.equals("Keshu"));
//		mylist4.anyMatch(s->s.equals("Darani"));
//		System.out.println(value);
		List<Integer> mylist5 = Arrays.asList(2, 8, 5, 2, 8, 7, 5, 9, 3);
		List mylist6 = mylist5.stream().sorted().distinct().collect(Collectors.toList());
		int k = mylist5.stream().findFirst().orElse(null);
		Optional<Integer> j = mylist5.stream().findAny();
		if (j.isPresent()) {
			System.out.println("j value is" + j.get());
		}
		System.out.println("value of k is" + k);
		
		System.out.println("mylist6" + mylist6);
		mylist5.sort(Comparator.reverseOrder());
		System.out.println("mylist5" + mylist5);
		
		List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		System.out.println("Filtered List: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
		List<String>mylist7 = Arrays.asList("janani", "dinesh", "krishna");
		mylist7.sort(Comparator.reverseOrder());;
		System.out.println("comparator in string " + mylist7);
		
		
	}

}
