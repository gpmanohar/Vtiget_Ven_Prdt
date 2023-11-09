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
import ObjectRepository_CrtC_S1.savePrdtDetails;
import ObjectRepository_PV.getIntoProductPage;
import ObjectRepository_PV.getintovendorPage;
import ObjectRepository_PV.prdtWithVendor;
import ObjectRepository_PV.productsInfo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createprdtWithVendor {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverUtility wutil = new WebDriverUtility();
		ExcelUtility eutil = new ExcelUtility();
		PropertyUtility putil = new PropertyUtility();
		JavaUtility jutil = new JavaUtility();
		WebDriver driver = null;
		
		String URL= putil.readDataFromPropertyFile("url");
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD= putil.readDataFromPropertyFile("password");
		
		// test data 
		String PNAME = eutil.readDataFromExcel("product", 1, 2);
		String VENDOR = eutil.readDataFromExcel("vendor", 1, 2);		// browser 
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
		wutil.maximizeWindow(driver);
		wutil.implicitWait(driver);
		driver.get(URL);
		
		// log into application 
		LoginPage lp = new LoginPage(driver);
		lp.logIntoApp(USERNAME, PASSWORD);
		
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
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		driver.close();
 
	}

}
