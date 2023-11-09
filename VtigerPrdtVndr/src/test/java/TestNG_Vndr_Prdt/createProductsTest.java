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
import ObjectRepository_PV.CreateProductDetails;
import ObjectRepository_PV.getIntoProductPage;
import ObjectRepository_PV.productsInfo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createProductsTest extends BaseClass {

	@Test
	public void createProductsTest () throws IOException, InterruptedException {
		
		// Test data 
		String PRODUCT = eutil.readDataFromExcel("product", 1, 2);
		
		
		
		getIntoProductPage gipp = new getIntoProductPage(driver);
		gipp.productLink();
		gipp.productLookupIcon();
		
		CreateProductDetails cpd = new CreateProductDetails(driver);
		cpd.ProductDetails(PRODUCT);
		cpd.Save();
		
		productsInfo pi = new productsInfo(driver);
		String header = pi.headerPageInfo();
		if(header.contains(PRODUCT )) {
			System.out.println(header);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAILED");
		}
	
		}

	}


