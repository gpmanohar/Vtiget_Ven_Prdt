package Basic_Scenarios;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// open the document in java readable format 
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties.txt");
        // create an object properties from java.util
		Properties pro = new Properties();
		// load to input stream into properties 
	    pro.load(fis);
	    //provide the keys to read the value 
	    String value = pro.getProperty("url");
	    System.out.println(value);
	    
	    
	}

}
