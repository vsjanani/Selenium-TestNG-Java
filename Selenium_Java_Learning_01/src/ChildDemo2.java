import org.testng.annotations.Test;

public class ChildDemo2 extends ParentDemo {
	@Test
	public void Child2() {
		System.out.println("Child2");
		System.out.println(driver.getTitle());
		
	}
}
