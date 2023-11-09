package DDT;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Scenario_1With_DDT {

	public static void main(String[] args) throws Throwable {
		// Step1 read all the required data
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		String BROWSER = pro.getProperty("browser");
		
		// Test Data
		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
	    Workbook book = WorkbookFactory.create(fes);
	    String Lastname = book.getSheet("contacts").getRow(1).getCell(2).getStringCellValue();
	    WebDriver driver= null;
	    // Launching the browser pholymorphism - runtime - browser
	   
	    
		if(BROWSER.equalsIgnoreCase("chrome")) {
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
			System.out.println("INVALID BROWSER");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
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

	

	

