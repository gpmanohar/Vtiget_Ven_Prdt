package Practise;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;

public class ExcelUtilityPractise {

	public static void main(String[] args) throws IOException {
		ExcelUtility eutil = new ExcelUtility();
		String orgname = eutil.readDataFromExcel("organization", 1, 2);
		System.out.println(orgname);
		
		JavaUtility jutil = new JavaUtility();
		int RAN = jutil.RandomNumber();
		System.out.println(RAN);
		
		String date = jutil.getSystemDateInFormat();
		System.out.println(date);

		
	}

}
