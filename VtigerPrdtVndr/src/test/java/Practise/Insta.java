package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Insta {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.instagram.com/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("gp.manohar");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("GPmanu@340");
		driver.findElement(By.xpath("(//div[contains(@class,\"x9f619 xjbqb8w x78zum5 x168nmei x13lgxp2 x5pf9jr xo71vjh x1xmf6yo x1e56ztr x540dpk x1m\")])[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='More']")).click();
		driver.findElement(By.xpath("//span[text()='Saved']")).click();
		driver.findElement(By.xpath("(//div[@class='_aavc'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='_aagw'])[1]")).click();
		
		//for(int i=0;i<=100;i++) {
//			driver.findElement(By.xpath("(//div[@class=\"x6s0dn4 x78zum5 xdt5ytf xl56j7k\"])[5]")).click();
//			driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
//			driver.findElement(By.xpath("(//div[@class=\"x6s0dn4 x78zum5 xdt5ytf xl56j7k\"])[1]")).click();
//			
		driver.findElement(By.xpath("//div[@aria-disabled='false']")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class=\"x6s0dn4 x78zum5 xdt5ytf xl56j7k\"])[1]")).click();
		
		driver.findElement(By.xpath("//div[@aria-disabled='false']")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class=\"x6s0dn4 x78zum5 xdt5ytf xl56j7k\"])[1]")).click();
		driver.findElement(By.xpath("//div[@class='_aagw']")).click();
		
		driver.findElement(By.xpath("//div[@aria-disabled='false']")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class=\"x6s0dn4 x78zum5 xdt5ytf xl56j7k\"])[1]")).click();
		
		
            
	
			

	}

}
