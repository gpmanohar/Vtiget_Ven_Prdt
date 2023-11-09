package AutoIT_Demo;

import java.awt.Rectangle;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class P1 {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.naukri.com/nlogin/login?URL=https://www.naukri.com/mnjuser/homepage");
		driver.findElement(By.xpath("//input[@placeholder='Enter Email ID / Username']")).sendKeys("gpmanohar403@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwordField']")).sendKeys("GPmanu@340");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("(//a[@href='/mnjuser/profile'])[1]")).click();
		/*WebElement element = driver.findElement(By.xpath("//label[@class='_label_gq6c0_9']"));
		org.openqa.selenium.Rectangle rectangle = element.getRect();
		System.out.println(rectangle.getX());
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,404)", " "); */
		
	}

}
