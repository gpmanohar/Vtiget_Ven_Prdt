package Basic_Scenarios;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {

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
//		Navigate to Organizations link
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
//		Click on Create Organization look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//		Create Organization with Mandatory fields
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Techpark"+RANDNUM);
//		Save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		//Verify
		 String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 if(header.contains("Techpark"+RANDNUM)) {
			 System.out.println(header);
			 System.out.println("Pass");
		 }
		 else 
		 {
			 System.out.println("Failed");
		 }
		Thread.sleep(8000);
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		act.click();
		// Logout of Application 
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
		
		
		

	}

}
