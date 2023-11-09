package Practise;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository_CrtC_S1.ContactInfoPage;
import ObjectRepository_CrtC_S1.ContactsPage;
import ObjectRepository_CrtC_S1.CreateNewContPage;
import ObjectRepository_CrtC_S1.HomePage;
import ObjectRepository_CrtC_S1.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateContactsDetailsTest{

		
	
@Test
	public void CreateContactsDetailsTest() throws Throwable {
		       
		// read 
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
				String Lastname = eutil.readDataFromExcel("contacts", 1, 2);
				
				
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
				// click on contacts moudle
				HomePage hp = new HomePage(driver);
				hp.clickonCont();
				//click on create cont
				ContactsPage cp = new ContactsPage(driver);
				cp.clickonCreateCont();
				// enter mandatory details 
				CreateNewContPage cncp = new CreateNewContPage(driver);
				cncp.clickonCreateNewC(Lastname);
				// validating name 
				ContactInfoPage cip = new ContactInfoPage(driver);
				String header = cip.VerifyHeader();
				if(header.contains(Lastname)) {
					System.out.println(header);
					System.out.println("PASS");
				}
				else
				{
					System.out.println("FAIL");
				}
				// logout 
				hp.logoutOfApp(driver);
				// close 
				driver.close();
		
				
				
		
	    

	}

}
