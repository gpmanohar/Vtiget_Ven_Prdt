package DDT;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario_5With_DDT {
	

	public static void main(String[] args) throws Throwable {
		
		Random r = new Random();
		int RANDNUM = r.nextInt(1000);
		
		// read the values 
		FileInputStream fis = new FileInputStream("src/test/resources/CommonData.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		
		String BROWSER = pro.getProperty("browser");
		String URL =pro.getProperty("url");
		String USERNAME =pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		// test data 
		FileInputStream fes = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fes);
		String Contact = book.getSheet("contacts").getRow(4).getCell(2).getStringCellValue();
		String ORGNAME = book.getSheet("contacts").getRow(4).getCell(3).getStringCellValue();
		
		// Launching the browser 
		WebDriver driver = null; 
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
		
//		Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		Navigate to Contacts link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Thread.sleep(5000);
//		Click on Create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
//		Create contact with manadatory fields
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Contact+RANDNUM);
//		Select the Organization from organization look up image
		// switching window
		String WindowsHandle = driver.getWindowHandle();
		System.out.println(WindowsHandle);
		// add sign
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click(); 
		Set<String> handle = driver.getWindowHandles();
		for(String hand : handle) {
			System.out.println(hand);
			if(!hand.equals(WindowsHandle)) {
				driver.switchTo().window(hand);
				//work 
				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ORGNAME);
				driver.findElement(By.xpath("//input[@type='button']")).click();
				driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
				
				//driver.close();
				Thread.sleep(8000);
				
			}
		}
		
		driver.switchTo().window(WindowsHandle);
		driver.findElement(By.xpath("//input[@name='department']")).sendKeys("Engineering");
		//switching windows end............
//		Save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
//      Verify
		String Header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(Header.contains(Contact)) {
			System.out.println(Header);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//logout
		WebElement element =driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		act.click();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("LOGOUT SUCCESSFULLY");
		driver.close();
	}

}
