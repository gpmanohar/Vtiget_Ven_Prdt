package AutoIT_Demo;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class qtalk {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://chat.qspiders.com/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("9030207720");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("GPmanu@340");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//a[@href='/student-dashboard/QCO-SOEAJD-M5']")).click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("chaitra");
		driver.findElement(By.xpath("//div[@class='_chat_conversation__wGPeN']")).click();
		WebElement element = driver.findElement(By.xpath("//input[@class='chatMessageInput']"));
		element.sendKeys("Test");
		element.clear();
		driver.findElement(By.xpath("//div[@role='toolbar']")).click();
		driver.findElement(By.xpath("//div[@class='Modal_fileupload__UGOP9']")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\gpman.000\\Desktop\\Testit.exe");

	}

}
