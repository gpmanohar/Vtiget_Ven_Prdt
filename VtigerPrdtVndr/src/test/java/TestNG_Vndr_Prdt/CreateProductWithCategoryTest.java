package TestNG_Vndr_Prdt;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository_CrtC_S1.HomePage;
import ObjectRepository_CrtC_S1.LoginPage;
import ObjectRepository_PV.createProductWithDropDown;
import ObjectRepository_PV.getIntoProductPage;
import ObjectRepository_PV.info;
import ObjectRepository_PV.productsInfo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductWithCategoryTest extends BaseClass {
	
	@Test(groups="SmokeSuite")
	public void CreateProductWithCategoryTest () throws IOException, InterruptedException {
		
		// Test data 
		String PNAME = eutil.readDataFromExcel("product", 4, 2);
		String MANUFC = eutil.readDataFromExcel("product", 4, 3);
		
		
		getIntoProductPage gipp = new getIntoProductPage(driver);
		gipp.productLink();
		gipp.productLookupIcon();
		
		createProductWithDropDown cpwdd = new createProductWithDropDown(driver);
		cpwdd.enterPrdtName(PNAME);
		cpwdd.selectDropDown(MANUFC);
		cpwdd.saveDetails();
		
		//productsInfo pi = new productsInfo(driver);
		info in = new info(driver);
		String header = in.getinfo();
		if(header.contains(PNAME)) {
			
			System.out.println(header);
			System.out.println("PASS");
		}
		else 
		{
			System.out.println("FAIL");
		}
		
		
		
	}

}
