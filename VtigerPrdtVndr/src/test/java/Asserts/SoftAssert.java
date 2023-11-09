package Asserts;

import org.testng.annotations.Test;

public class SoftAssert {
	@Test
	public void softassertPractise( ) {
	
		//org.testng.asserts.SoftAssert sa = new org.testng.asserts.SoftAssert();
		org.testng.asserts.SoftAssert sa = new org.testng.asserts.SoftAssert(); 
		
		System.out.println("pass1");
		sa.assertEquals(1, 1);
		sa.assertAll();
	}

}
