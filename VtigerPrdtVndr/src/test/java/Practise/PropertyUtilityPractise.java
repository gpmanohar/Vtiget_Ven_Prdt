package Practise;

import java.io.IOException;

import GenericUtility.PropertyUtility;

public class PropertyUtilityPractise {

	public static void main(String[] args) throws IOException {
		PropertyUtility putil = new PropertyUtility();
		String value = putil.readDataFromPropertyFile("url");
		System.out.println(value);

	}

}
