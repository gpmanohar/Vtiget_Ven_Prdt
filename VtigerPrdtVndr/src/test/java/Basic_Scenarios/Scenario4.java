package Basic_Scenarios;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Scenario4 {

	public static void main(String[] args) throws Throwable {
//	    Launch Browser	
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Random r = new Random();
		int RANDNUM = r.nextInt(1000);
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
//		Login to application with valid credentials
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
//		Navigate to Organizations link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
//		Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//		Create Organization with Mandatory fields
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Shakthi pvt ltd"+RANDNUM);
//		Select "Energy" in the industry drop down
		WebElement element1 = driver.findElement(By.xpath("//select[@name='industry']"));
		Select s = new Select(element1);
		s.selectByVisibleText("Energy");
//		Select "Customer" in the Type Drop down 
		WebElement element2 = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select st = new Select(element2);
		st.selectByVisibleText("Customer");
		
//		Save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		Thread.sleep(8000);
//      Verify
		String Header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(Header.contains("Shakthi pvt ltd"+RANDNUM)) {
			System.out.println(Header);
			System.out.println("PASS");
		}
		else 
		{
			System.out.println("FAIL");
		}
		
		WebElement element3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element3).perform();
		act.click();
//		logout of Application
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
		
	}

}
