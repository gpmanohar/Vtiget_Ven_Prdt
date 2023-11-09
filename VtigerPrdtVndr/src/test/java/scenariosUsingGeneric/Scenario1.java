package scenariosUsingGeneric;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Scenario1 {

	public static void main(String[] args) throws IOException, Throwable {
		//WebDriver driver = new FirefoxDriver();
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
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge")) {
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			System.out.println("--INVALID BROWSER--");
		}
		driver.get(URL);
		wutil.maximizeWindow(driver);
		wutil.implicitWait(driver);

		//Login to application 
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//Navigate to contact Links 
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				
				//Create contact with mandatory fields 
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Lastname);
				
				//save the contact 
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
				
				//Validation 
				String Header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(Header.contains(Lastname)) {
					System.out.println(Header);
					System.out.println("Passed");
				}
				else 
				{
					System.out.println("Failed");
				}
				
				//Logout of Application 
				Thread.sleep(5000);
				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				System.out.println("Logout Succesfully");
				driver.close();

			}
		
		
	}
	

