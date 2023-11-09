package scenariosUsingGeneric;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;


public class Scenario2 {

	
		public static void main(String[] args) throws IOException, InterruptedException {
			
			PropertyUtility putil = new PropertyUtility();
			JavaUtility jutil = new JavaUtility();
			ExcelUtility eutil = new ExcelUtility();
			WebDriverUtility wutil = new WebDriverUtility();
			WebDriver driver = null;
			
			int RANDNUM = jutil.RandomNumber();


			
			// Read all the required data 
			
			
			String BROWSER = putil.readDataFromPropertyFile("browser");
			String URL = putil.readDataFromPropertyFile("url");
			String USERNAME = putil.readDataFromPropertyFile("username");
			String PASSWORD = putil.readDataFromPropertyFile("password");
			
			//Test Data 
			String Orgname = eutil.readDataFromExcel("organization",1,2);
			
			
			
			// Launching the browser 
			
			if(BROWSER.equalsIgnoreCase("chrome")) {
				//WebDriverManager.chromedriver().setup();
				driver = new  ChromeDriver();
			}
			else if (BROWSER.equalsIgnoreCase("firefox")) {
				//WebDriverManager.firefoxdriver().setup();
				driver = new  FirefoxDriver();
			}
			else if (BROWSER.equalsIgnoreCase("edge")) {
				//WebDriverManager.edgedriver().setup();
				driver = new  EdgeDriver();
			}
			else 
			{
				System.out.println("INVALID BROWSER");
			}
			driver.get(URL);
			wutil.maximizeWindow(driver);
			wutil.implicitWait(driver);
			
			
//			Login to application with valid credentials
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
//			Navigate to Organizations link
			driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
//			Click on Create Organization look Up Image
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//			Create Organization with Mandatory fields
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(Orgname+RANDNUM);
//			Save
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
			Thread.sleep(5000);
			//Verify
			 String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			 if(header.contains(Orgname)) {
				 System.out.println(header);
				 System.out.println("PASSED");
			 }
			 else 
			 {
				 System.out.println("FAILED");
			 }
			Thread.sleep(8000);
			WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
			act.click();
			// Logout of Application 
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			System.out.println("LOGOUT OF APPLICATION SUCCESSFULLY");
			driver.close();

	}

}
