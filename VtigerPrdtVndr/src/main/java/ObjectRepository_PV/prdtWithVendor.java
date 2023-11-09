package ObjectRepository_PV;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class prdtWithVendor extends WebDriverUtility {
	public prdtWithVendor( WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement prdtFiled;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement lookupIcon;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchField;
	
	
	
	public WebElement getPrdtFiled() {
		return prdtFiled;
	}

	public WebElement getLookupIcon() {
		return lookupIcon;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;
	
	//BL
	public void EnterDetails( WebDriver driver,String PNAME, String VENDOR) {
		prdtFiled.sendKeys(PNAME);
		lookupIcon.click();
		switchToWindow(driver, "Vendors");
		searchField.sendKeys(VENDOR);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+VENDOR+"']")).click();
		switchToWindow(driver, "Products");
		
		
	}

}
