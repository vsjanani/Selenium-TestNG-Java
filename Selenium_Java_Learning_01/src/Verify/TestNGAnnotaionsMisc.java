package Verify;

import java.io.IOException;

import org.testng.annotations.Test;

public class TestNGAnnotaionsMisc {
	@Test(expectedExceptions = {IOException.class})
	public void checkExceptions() throws IOException {
		throw new IOException();
		
	@Test(invocationCount=3, invocationTimeOut)
		
	}

}
