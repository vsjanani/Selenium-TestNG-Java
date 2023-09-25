package Verify;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngCheck {
	
	String hello;
	int i = 10;
	int j = i + 1;

	@BeforeClass(alwaysRun = true)
	public void before() {
		System.out.println("before class");
//		Assert.assertEquals(null, hello);
	}

	@Test(priority = 1, groups = { "out" }, dependsOnMethods = "checkagain", alwaysRun = true)
	public void testAnnotationCheck() {
		i = i + 10;
		System.out.println("it is working fine" + i + j);
//		hello.chars();
		
	}

	@Test(priority = 2)
	public void checkagain() {
		i = i+1;
		System.out.println("second method" + i);
//		Assert.assertTrue(false);
	}
	
//	public static void main(String[] args) {
//		//hello variable will not work here
//		System.out.println("main function");
//	}

}
