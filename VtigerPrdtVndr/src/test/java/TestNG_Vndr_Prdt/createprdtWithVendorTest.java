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
import ObjectRepository_CrtC_S1.savePrdtDetails;
import ObjectRepository_PV.getIntoProductPage;
import ObjectRepository_PV.getintovendorPage;
import ObjectRepository_PV.prdtWithVendor;
import ObjectRepository_PV.productsInfo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createprdtWithVendorTest extends BaseClass {

	@Test
	public void createprdtWithVendorTest() throws InterruptedException, IOException {
		
		// test data 
		String PNAME = eutil.readDataFromExcel("product", 1, 2);
		String VENDOR = eutil.readDataFromExcel("vendor", 1, 2);		// browser 
		
		
		getIntoProductPage gipp = new getIntoProductPage(driver);
		gipp.productLink();
		gipp.productLookupIcon();
		
		prdtWithVendor pwv = new prdtWithVendor(driver);
		pwv.EnterDetails(driver, PNAME, VENDOR);
		
		savePrdtDetails spd = new savePrdtDetails(driver);
		spd.saveBtnnn();
		productsInfo pi = new productsInfo(driver);
		String header = pi.headerPageInfo();
		if(header.contains(PNAME)) {
			System.out.println(header);
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
	
 
	}

}
