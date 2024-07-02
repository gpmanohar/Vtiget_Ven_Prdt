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
import ObjectRepository_PV.createPrdtWith2dd;
import ObjectRepository_PV.getIntoProductPage;
import ObjectRepository_PV.productsInfo;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePrdtwithDropDsTest extends BaseClass {

	@Test(groups="RegressionSuite")
	public void CreatePrdtwithDropDs() throws IOException, InterruptedException {
		
		// Test data 
		String PRODUCT = eutil.readDataFromExcel("product", 4, 2);
		String CATEGORY = eutil.readDataFromExcel("product", 4, 3);
		String MANUFAC = eutil.readDataFromExcel("product", 4, 4);
		
		
		
		getIntoProductPage gipp = new getIntoProductPage(driver);
		gipp.productLink();
		gipp.productLookupIcon();
		
		createPrdtWith2dd cpwd = new createPrdtWith2dd(driver);
		cpwd.EnterPrdtName(PRODUCT);
		cpwd.categoryDrop(CATEGORY);
		cpwd.manufacDrop(MANUFAC);
		cpwd.saveData();
		
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
		Thread.sleep(3000);

		

	}

}
