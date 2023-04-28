import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class IntStreamRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] employees = {
			    new Employee("Alexandru", "alexandru@gmail.com", 22),
			    new Employee("Emanuela", "ema@gmail.com", 20),
			    new Employee("George", "george@gmail.com", 32),
			    new Employee("John", "john123@gmail.com", 25),
			    new Employee("Liam", "liam123@gmail.com", 45),
			    new Employee("Noah", "noah@outlook.com", 30),
			    new Employee("Oliver", "oliver@yahoo.com", 47)
			};
		List<Employee> hi = Arrays.asList(employees);

		
		System.out.println(hi.size());
	
		IntStream.range(0, hi.size())
        .filter(i -> i % 2 == 0)
        .mapToObj(i -> employees[i].name)
        .forEach(System.out::println);
		
		
		
	}
	public static class Employee {

	    public Employee(String name, String email, int age) {
			// TODO Auto-generated constructor stub
	    	this.name = name;
	    	this.email = email;
	    	this.age = age;
		}
		private String name;
	    private String email;
	    private int age;
	}

}
