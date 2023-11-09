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
import ObjectRepository_PV.CreateVendorDetails;
import ObjectRepository_PV.getintovendorPage;
import ObjectRepository_PV.savevendorDetails;
import ObjectRepository_PV.vendorInfo;
import ObjectRepository_PV.vendorsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createVendorTest extends BaseClass {

	@Test(groups="SmokeSuite")
	public void createVendorTest() throws IOException, InterruptedException {
		
		
		// Test data
		String VNAME = eutil.readDataFromExcel("vendor", 1, 2);
		String SNAME = eutil.readDataFromExcel("vendor", 1, 3);
		String CNAME = eutil.readDataFromExcel("vendor", 1, 4);
		String STATE = eutil.readDataFromExcel("vendor", 1, 5);
		String COUNTRY = eutil.readDataFromExcel("vendor",1, 6);
		
		
		
		
		
		getintovendorPage givp = new getintovendorPage(driver);
		givp.clickonMore(driver);
		
		vendorsPage vp = new vendorsPage(driver);
		vp.clickonvendorlookup();
		
		CreateVendorDetails cvd = new CreateVendorDetails(driver);
		//cvd.enterDetails(VNAME, null, null, null, null);
		cvd.enterDetails(VNAME, SNAME, CNAME, STATE, COUNTRY);
		cvd.saveVendorDetails();
		
		vendorInfo vi = new vendorInfo(driver);
		String header = vi.headerinfo();
		if(header.contains(VNAME)) {
			System.out.println(header);
			System.out.println("PASS");
		}
		else {
			System.out.println("FAIL");
		}
		
		

	}

}
