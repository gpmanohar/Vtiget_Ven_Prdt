package Basic_Scenarios;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CampToProd_HC {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Random r = new Random();
		int RANDNUM = r.nextInt(1000);
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys("DQ Tech"+RANDNUM);
		
		WebElement element = driver.findElement(By.xpath("//select[@name='productcategory']"));
		Select s = new Select(element);
		s.selectByVisibleText("Software");
		driver.findElement(By.xpath("//input[@name='productcode']")).sendKeys("P245487S");
		
		WebElement element1 = driver.findElement(By.xpath("//select[@name='manufacturer']"));
		Select St = new Select(element1);
		St.selectByVisibleText("LexPon Inc.");
		
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		Thread.sleep(8000);
		
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']")).click();
		
		// mouse_hover
		WebElement element2 = driver.findElement(By.xpath("//a[text()='More']"));
		Actions act = new Actions(driver);
		act.moveToElement(element2).perform();
		act.click();
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys("Capgemini"+RANDNUM);
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		WebElement element3 = driver.findElement(By.xpath("//select[@name='campaigntype']"));
		Select sst = new Select(element3);
		sst.selectByVisibleText("Email");
		driver.findElement(By.xpath("//input[@name='targetaudience']")).sendKeys("1500");
		WebElement element4 = driver.findElement(By.xpath("//select[@name='campaignstatus']"));
		Select stt = new Select(element4);
		stt.selectByVisibleText("Active");
		
		String parentwindowhandle = driver.getWindowHandle();
		System.out.println(parentwindowhandle);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
		
		//switching frame 
		Set<String> childwindow = driver.getWindowHandles();
		for(String all :childwindow) {
			System.out.println(all);
			if(!all.equals(parentwindowhandle)) {
			 driver.switchTo().window(all);
			 //work 
			 driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("DQ Tech163");
			 driver.findElement(By.xpath("//input[@name='search']")).click();
			 driver.findElement(By.xpath("//a[text()='DQ Tech163']")).click();
			 
				
			}
		}
		driver.switchTo().window(parentwindowhandle);
		driver.findElement(By.xpath("//textarea[@class='detailedViewTextBox']")).sendKeys("COMPLETED SUCCESFULLY");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		Thread.sleep(5000);
		WebElement element5 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions acts = new Actions(driver);
		acts.moveToElement(element5).perform();
		act.click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
		
	
		

	}

}
