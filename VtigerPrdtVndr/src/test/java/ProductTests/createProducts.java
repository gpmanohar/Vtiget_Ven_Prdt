package ProductTests;

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
import ObjectRepository_PV.CreateProductDetails;
import ObjectRepository_PV.getIntoProductPage;
import ObjectRepository_PV.productsInfo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createProducts {

	public static void main(String[] args) throws IOException, InterruptedException {
		JavaUtility jutil = new JavaUtility();
		PropertyUtility putil = new PropertyUtility();
		ExcelUtility eutil = new ExcelUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		WebDriver driver = null;
		
		String URL = putil.readDataFromPropertyFile("url");
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		// Test data 
		String PRODUCT = eutil.readDataFromExcel("product", 1, 2);
		
		//Browser setting
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("INVALID BROWSER");
		}
		
		driver.get(URL);
		wutil.maximizeWindow(driver);
		wutil.implicitWait(driver);
		// log into app 
		LoginPage lp = new LoginPage(driver);
		lp.logIntoApp(USERNAME, PASSWORD);
		
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
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		driver.close();
			
		}

	}


