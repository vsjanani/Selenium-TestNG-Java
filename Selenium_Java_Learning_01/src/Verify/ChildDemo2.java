package Verify;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ChildDemo2 extends ParentDemo {
	@Test
	public void Child2() {
		System.out.println("Child2");
		driver.findElement(By.cssSelector("#nav-cart-text-container")).click();
		System.out.println(driver.getTitle());
	}
}
