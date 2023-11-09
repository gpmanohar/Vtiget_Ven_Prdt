package GenericUtility;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {
	
	/**
	 * This method is used to maximize the window
	 * @param driver
	 * @author gpmanohar
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
	/**
	 * This method is used to minimize the window
	 * @param driver
	 * @author gpmanohar
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method is used to load web page for a 10 seconds  
	 * @param driver
	 * @author gpmanohar
	 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	public void explicitWait(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));

}
	/**
	 * this method will hand drop down by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
		
	}
	/**
	 * This method will hand drop down by value 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select se = new Select(element);
		se.selectByValue(value);
	}
	/**
	 * this method is used to hand dropdown by visible text
	 * @param element
	 * @param value
	 */
	public void handleDropDown( String text,WebElement element) {
		Select sec = new Select(element);
		sec.selectByVisibleText(text);
	}
	/**
	 * This method perform mouse hovering action 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverActions(WebDriver driver,WebElement element) {
	   Actions act = new Actions(driver);
	   act.moveToElement(element).perform();

	}
	public void DoubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void righClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	public void dragAndDrop(WebDriver driver,WebElement srcElement, WebElement targetElement) {
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, targetElement).perform();
		
	}
	public void clickAndHoldAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	/**
	 * This method is scroll down for 500 units
	 * @param driver
	 */
	public void scrollDownAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", " "); 
	}
	/**
	 * This method will scroll up for 500 units 
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy()0,-500", "");
	}
	public void scrollRightAction(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(500,0)", " ");
		
	}
	public void scrollLeftAction(WebDriver driver ) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(-500,0)", " ");
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String getAlertText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}
	public void swithToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameorId) {
		driver.switchTo().frame(nameorId);
	}
	public void swithcToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
		
	}
	public void switchToWindow(WebDriver driver , String partialWindowTitle) {
		// step1: capture all the windows ids
		Set<String> allWindowIDs = driver.getWindowHandles();
		// step 2 : Navigate through each window 
		for (String windowID : allWindowIDs)
		{
			//step3: switch to each window and capture the title
			String actTitle = driver.switchTo().window(windowID).getTitle();
			//step4: Compare the actual title with expected partial window title
			if(actTitle.contains(partialWindowTitle))
					{
				break; 
					}
		}
	}
	public String captureScreenshot(WebDriver driver, String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver; 
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+screenShotName+".png");
		Files.copy(src, dst);
		
		return dst.getAbsolutePath();
		
	}
	
}
