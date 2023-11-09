package DDT;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_3With_DDT {

	public static void main(String[] args) throws Throwable {
		Random r = new Random();
		int RANDNUM = r.nextInt(1000);
		
		// Read all the required data 
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		
		String URL = pro.getProperty("url");
		String BROWSER = pro.getProperty("browser");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		// Test Data 
		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book= WorkbookFactory.create(fes);
		String OrgName = book.getSheet("organization").getRow(1).getCell(2).getStringCellValue();
	    
		// Launching the browser 
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("Firefox")) {
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
		
//		Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
//		Navigate to Organizations link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
//		Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//		Create Organization with Mandatory fields
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName+RANDNUM);
//		Select "Chemicals" in the industry drop down
		WebElement element1 = driver.findElement(By.xpath("//select[@name='industry']"));
		Select s = new Select(element1);
		s.selectByVisibleText("Chemicals");
//		Save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		Thread.sleep(8000);
//      Verify 
		String Header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(Header.contains(OrgName)) {
			System.out.println(Header);
			System.out.println("PASSED");
		}
		else
		{
			System.out.println("FAILED");
		}
		
//      Logout 
		WebElement element2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element2).perform();
		act.click();
//		logout of Application
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("LOGOUT SUCCESFULLY");
		driver.close();

	}

}
