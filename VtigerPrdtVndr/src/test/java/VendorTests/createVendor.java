package VendorTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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

public class createVendor {

	public static void main(String[] args) throws IOException, InterruptedException {
		JavaUtility jutil = new JavaUtility();
		PropertyUtility putil = new PropertyUtility();
		ExcelUtility eutil = new ExcelUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		WebDriver driver = null;
		
		// Read the required data 
		String URL = putil.readDataFromPropertyFile("url");
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		// Test data
		String VNAME = eutil.readDataFromExcel("vendor", 1, 2);
		String SNAME = eutil.readDataFromExcel("vendor", 1, 3);
		String CNAME = eutil.readDataFromExcel("vendor", 1, 4);
		String STATE = eutil.readDataFromExcel("vendor", 1, 5);
		String COUNTRY = eutil.readDataFromExcel("vendor",1, 6);
		
		
		// Browser setting 
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else 
		{
			System.out.println("--INVALID BROWSER--");
		}
		
		driver.get(URL);
		wutil.maximizeWindow(driver);
		wutil.implicitWait(driver);
		// Login to application 
		LoginPage lp = new LoginPage(driver);
		lp.logIntoApp(USERNAME, PASSWORD);
		
		
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
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		driver.quit();
		
		

	}

}
