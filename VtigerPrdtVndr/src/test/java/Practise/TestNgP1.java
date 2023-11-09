package Practise;

import org.testng.annotations.Test;

public class TestNgP1 {

	@Test(invocationCount = 2, priority = 1 )
	public void createcustomer() {
		System.out.println("Customer created sucessfully");
	}
	@Test (invocationCount = 3, priority = -2 )
	public void modifycustomer( ) {
		System.out.println("Modify customer succesfully");
	}
	@Test(enabled = false)
	public void customerdeleted() {
		System.out.println("Customer deleted succesfully");
	}
}
