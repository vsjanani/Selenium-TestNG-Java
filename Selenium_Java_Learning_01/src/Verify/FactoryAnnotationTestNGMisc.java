package Verify;

import org.testng.annotations.Factory;

public class FactoryAnnotationTestNGMisc {

	@Factory
	public Object[] verifyFactoryAnnotation() {
		return new Object[] {new FactoryAnnotationTestNGMainClass("poda")};
	} 
}
