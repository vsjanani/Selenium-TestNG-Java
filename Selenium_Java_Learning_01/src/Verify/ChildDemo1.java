package Verify;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ChildDemo1 extends ParentDemo {
	@Test
	public void Child1() {
		System.out.println("Child1");
		driver.findElement(By.cssSelector("#nav-cart-text-container")).click();
		System.out.println(driver.getTitle());
	}
}
