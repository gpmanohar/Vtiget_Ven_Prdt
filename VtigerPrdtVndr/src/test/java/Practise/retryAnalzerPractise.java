package Practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class retryAnalzerPractise {
	
	@Test(retryAnalyzer = GenericUtility.RetryAnalyzerImlementation.class)
	
	public void sample() {
		Assert.fail();
		System.out.println("hello");
	}
	
	public void sample1() {
		System.out.println("hello");
	}

}
