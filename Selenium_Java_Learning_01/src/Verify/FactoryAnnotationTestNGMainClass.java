package Verify;

import org.testng.annotations.Test;

public class FactoryAnnotationTestNGMainClass {
	String param;

	public FactoryAnnotationTestNGMainClass(String param) {
		this.param = param;
	}
	
	@Test
	public void method1() {
		System.out.println("method1:" + param);
	}
	
	@Test
	public void method2() {
		System.out.println("method2:" + param);
	}

}
