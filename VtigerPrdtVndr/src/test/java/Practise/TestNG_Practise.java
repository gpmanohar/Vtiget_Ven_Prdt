package Practise;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

public class TestNG_Practise {
	@Test(priority = 1)
	public void sampleTest() {
		
		System.out.println("hello");
	
	}
	@Test(priority = 2)
	public void sampleT2() {
		System.out.println("hi");
	}
	@Test(priority = 3)
	public void sample3() {
		System.out.println("Test");
	}

}
