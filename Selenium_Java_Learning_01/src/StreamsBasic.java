import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class StreamsBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> mylist2 = new ArrayList<String>();
		mylist2.add("hi");
		mylist2.add("ant");
		mylist2.add("bat");
		mylist2.add("Vanthanam");
//		mylist2.sort(Comparator.reverseOrder());
		System.out.println(mylist2);
		long mycount = mylist2.stream().filter(s -> s.startsWith("V")).count();
		System.out.println(mycount);
		mylist2.stream().filter(s -> s.equals("hello")).map(s -> s.toUpperCase()).forEach(System.out::println);
		System.out.println("printing below");
		mylist2.stream().map(s -> s.length()).forEach(System.out::println);
		List collectList = mylist2.stream().filter(s -> s.startsWith("V")).collect(Collectors.toList());
		System.out.println("my new list is " + collectList);
		System.out.println(Stream.of("janani", "dinesh", "krishna", "darshini").count());
		mylist2.stream().filter(s -> s.length() < 3).forEach(System.out::println);
//		Stream.of("janani","dinesh", "krishna", "darshini").filter(s->s.toUpperCase()).forEach(s->System.out.println(s));
//		ArrayList<String> mylist3 = new ArrayList<String>();
		ArrayList<Integer> answers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		answers.stream().filter(s -> s % 2 == 0).forEach(System.out::println); // this can also be written as
																				// forEach(s->System.out.println(s));

		ArrayList<Integer> toin = new ArrayList<Integer>();
		toin.add(5);
		toin.add(3);
		List<Integer> tu = toin.stream().collect(Collectors.toList());
		System.out.println("tu is" + tu);

		Stream.of("janani", "dinesh", "darshini", "krishna").map(s -> s.toUpperCase()).forEach(System.out::println);
		Stream.of("janani", "dinesh", "darshini", "krishna").filter(s -> s.startsWith("d")).map(s -> s.toUpperCase())
				.forEach(System.out::println);
		Stream.of("janani", "dinesh", "barshini", "arishna").sorted().forEach(System.out::println);
		ArrayList<String> mylist3 = new ArrayList<String>(Arrays.asList("Kavitha", "Darani", "Keshu", "Sarvesh"));

//		Supplier<Stream<String>> mylist4 = () -> Stream.of("janani", "dinesh", "barshini", "arishna");
		Stream mylist4 = Stream.concat(mylist2.stream(), mylist3.stream());
//		mylist4.sorted().forEach(System.out::println);
		boolean value = mylist4.anyMatch(s -> s.equals("Keshu"));
//		mylist4.anyMatch(s->s.equals("Darani"));
		System.out.println(value);
		List<Integer> mylist5 = Arrays.asList(2, 8, 5, 2, 8, 7, 5, 9, 3);
//		ArrayList<Integer> mylist5 = new ArrayList();
		mylist5.add(2);
		mylist5.add(6);
		mylist5.add(4);
		
//		mylist5.add(6);
		List mylist6 = mylist5.stream().sorted().distinct().collect(Collectors.toList());
		List mylist8 = mylist5.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(mylist8 + "mylist8");
		Integer arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		List<Integer> he = Arrays.asList(arr);
		List<Integer> po = he.stream().map(s -> s).sorted().collect(Collectors.toList());
		System.out.println(po);

		// note: below code is used when arr[] datatype is int instead of Integer.
//		List<int[]> he = Arrays.asList(arr);
//		List<int[]> po = he.stream().map(s->s).sorted().collect(Collectors.toList());
//		for(int[] i : po) {
//			for(int k : i) {System.out.println(k);}
//		}

		int sum = 0;

		int k = mylist5.stream().findFirst().orElse(null);
		Optional<Integer> j = mylist5.stream().findAny();
		if (j.isPresent()) {
			System.out.println("j value is" + j.get());
		}
		System.out.println("value of k is" + k);

		System.out.println("mylist6" + mylist6);
		mylist5.sort(Comparator.reverseOrder());
		System.out.println("mylist5" + mylist5);

		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

		System.out.println("Filtered List: " + filtered);
		String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Merged String: " + mergedString);
		List<String> mylist7 = Arrays.asList("janani", "dinesh", "krishna");
		mylist7.sort(Comparator.reverseOrder());
		System.out.println("comparator in string " + mylist7);
		String h = " heloz";
		System.out.println(h.strip());
		StringBuilder q = new StringBuilder("heloz");
		System.out.println("using stringbuilder" + q.reverse());
		char[] r = h.toCharArray();
		Arrays.sort(r);
		System.out.println(new String(r));
		String[] myuse = { "janani", "dinesh" };
		List<String> users = Arrays.asList(myuse);
		System.out.println(users.indexOf("dinesh"));
//		users.stream().map(user -> user)
//			    .collect(Collectors.toList()).ind
		String inputValues = "799, 719, 720, 850, 1200";
		int i = 4000;
		Integer.toString(i);
		System.out.println(i + "hello");
		String[] str = inputValues.split(", ");
		System.out.println(str[0]);
		List<String> myli = Arrays.asList(str);
		OptionalInt hi = myli.stream().mapToInt(s -> Integer.parseInt(s)).min();
		System.out.println(hi);
		
		
		//Below is to learn a Stream object can be used only once. If distinct line is uncommented, code throws error. To avoid this supplier can be used.
		Stream din = Stream.of(1,2,3);
		din.sorted().anyMatch(s->s.equals(1));
//		din.distinct();
		
		//below is the work around using supplier.
		Supplier<Stream<Integer>> dar = ()->Stream.of(1,2,3);
		dar.get().anyMatch(s->s.equals(1));
		dar.get().distinct();
	}
}
