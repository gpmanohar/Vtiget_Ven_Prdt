package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestNG {
	@Test(dataProvider = "getData")
	public void readData(String Name, String model, int qty, int price) {
		System.out.println(Name+" --"+model+"--"+qty+"--"+price);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][4];
		
		data[0][0] = "Samsung";
		data[0][1] = "S23";
		data[0][2] = 15;
		data[0][3] = 125000;
		
		data[1][0] = "Iphone";
		data[1][1] = "14ProMax";
		data[1][2] = 20;
		data[1][3] = 155000;
		
		data[2][0] = "oneplus";
		data[2][1] = "O5";
		data[2][2] = 10;
		data[2][3] = 32000;
		
		return data;
		
		
	}
}
