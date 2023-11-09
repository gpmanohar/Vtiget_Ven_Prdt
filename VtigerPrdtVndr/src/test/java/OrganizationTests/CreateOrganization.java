package OrganizationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository_CrtC_S1.CreateNewOrgPage;
import ObjectRepository_CrtC_S1.HomePage;
import ObjectRepository_CrtC_S1.LoginPage;
import ObjectRepository_CrtC_S1.OraganizationPage;
import ObjectRepository_CrtC_S1.OrgInfoPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {

	public static void main(String[] args) throws IOException, InterruptedException {
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
		String ORGNAME = eutil.readDataFromExcel("organization", 1, 2);
		// browser 
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
		// log into app 
		LoginPage lp = new LoginPage(driver);
		lp.logIntoApp(USERNAME, PASSWORD);
		// click on org 
		HomePage hp = new HomePage(driver);
		hp.clickonOrg();
		OraganizationPage op = new OraganizationPage(driver);
		op.createOrg();
		// create with details 
		CreateNewOrgPage cnop = new CreateNewOrgPage(driver);
		cnop.createNewOrg(ORGNAME+jutil.RandomNumber());
		cnop.saveData();
		// verifying 
		OrgInfoPage oip = new OrgInfoPage(driver);
		String header = oip.getOrgHeaderText();
		if(header.contains(ORGNAME)) {
			System.out.println(header);
			System.out.println("PASS");
		}
		else 
		{
			System.out.println("FAIL");
		}
		hp.logoutOfApp(driver);
		driver.close();
		
	}

}
