package GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository_CrtC_S1.HomePage;
import ObjectRepository_CrtC_S1.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public PropertyUtility putil = new PropertyUtility();
	public ExcelUtility eutil = new ExcelUtility();
	public WebDriverUtility wutil = new WebDriverUtility();
	public JavaUtility jutil = new JavaUtility();
	public  WebDriver driver = null;
	
	public static WebDriver sdriver;  // used in listiners implementaion for screenshot
	
	@BeforeSuite(alwaysRun = true)
	public void bsConfig() {
		System.out.println("--DB CONNECTION SUCCESSFULLY--");
	}
	//@Parameters("browser")
	//@BeforeTest
	// bcConfig(String BROWSER) 
	@BeforeClass (alwaysRun = true)
	public void bcConfig() throws IOException {
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String URL = putil.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else 
		{
			System.out.println("INVALID BROWSER");
		}
		sdriver = driver; // used in listiners implementaion for screenshot
		wutil.minimizeWindow(driver);
		wutil.implicitWait(driver);
		driver.get(URL);
	}
	@BeforeMethod (alwaysRun = true)
	public void bnConfig() throws IOException {
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.logIntoApp(USERNAME, PASSWORD);
		System.out.println("---LOGIN SUCCESSFULLY--");
	}
	@AfterMethod (alwaysRun = true)
	public void amConfig() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("---LOGOUT SUCCESSFULLY--");
	}
	@AfterClass (alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("---BROWSER CLOSED SUCCESSFULLY--");
	}
	@AfterSuite (alwaysRun = true)
	public void asConfig() {
		System.out.println("--DB CONNECTION CLOSED SUCCESSFULLY--");
	}

}
