package Verify;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAnnotaionsMisc {
	@Test(expectedExceptions = { IOException.class })
	public void checkExceptions() throws IOException {
		System.out.println("exception printing");
		throw new IOException();
	}
	
	//below is miscellaneous to say the, even if the method is depends on another method, if alwaysRun= true. 
	//This is called soft dependancy. 
	// if alwaysRun is not set or false, it is called hard dependancy coz, the depending method will get skipped. It wont run.
	//Note: alwaysRun is false by default. 
	//for successful running always run in verifyDependsOnMethods is set to false and assertion in heroMethod is set commented.
	@Test
	public void heroMethod() {
		System.out.println("This is the hero method");
//		Assert.assertTrue(false);
		
	}

	@Test(dependsOnMethods = {"heroMethod"}, alwaysRun = false)
	public void verifyDependsOnMethods() {
		System.out.println("hard dependancy working");
	}
	

	

	
	
}
