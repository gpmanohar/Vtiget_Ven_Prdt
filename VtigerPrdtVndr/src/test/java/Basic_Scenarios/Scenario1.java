package Basic_Scenarios;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scenario1 {

	public static void main(String[] args) throws Throwable {
		//Launching Browser 
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Login to application 
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		//Navigate to contact Links 
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//Create contact with mandatory fields 
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Mounika");
		//save the contact 
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		//Validation 
		String Header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(Header.contains("Mounika")) {
			System.out.println(Header);
			System.out.println("Passed");
		}
		else 
		{
			System.out.println("Failed");
		}
		//Logout of Application 
		Thread.sleep(8000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("Logout Succesfully");
		driver.close();

	}

}
