package ObjectRepository_PV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class getIntoProductPage {
	// Initialization
	public getIntoProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Declaration 
	@FindBy(xpath="//a[text()='Products']")
	private WebElement clickonPrdt;
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement clickonPrdtLookup;
	
    //utilization
	public WebElement getClickonPrdt() {
		return clickonPrdt;
	}

	public WebElement getClickonPrdtLookup() {
		return clickonPrdtLookup;
	}
	
	//Business Logics
	public void productLink() {
		clickonPrdt.click();
	}
	
	public void productLookupIcon() {
		clickonPrdtLookup.click();
	}
	

}
