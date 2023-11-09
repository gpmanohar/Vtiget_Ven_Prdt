package Basic_Scenarios;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario5 {

	public static void main(String[] args) throws Throwable {
//		Launch Browser
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
//		Navigate to Contacts link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//		Click on Create contact look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
//		Create contact with manadatory fields
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("mouni"+RANDNUM);
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
				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("TCS");
				driver.findElement(By.xpath("//input[@type='button']")).click();
				driver.findElement(By.xpath("//a[text()='TCS']")).click();
				
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
		if(Header.contains("mouni"+RANDNUM)) {
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
		
	}

}
