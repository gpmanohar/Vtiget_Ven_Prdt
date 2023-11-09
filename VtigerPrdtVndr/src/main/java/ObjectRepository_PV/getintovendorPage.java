package ObjectRepository_PV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class getintovendorPage extends WebDriverUtility {
	//initialization 
	public getintovendorPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// declaration 
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreBtn;
	
	@FindBy(xpath="//a[text()='Vendors']")
	private WebElement vendorBtn;

	//Utilization 
	public WebElement getMoreBtn() {
		return moreBtn;
	}

	public WebElement getVendorBtn() {
		return vendorBtn;
	}
	
	// business Logics 
	public void clickonMore(WebDriver driver) throws InterruptedException {
		mouseHoverActions(driver, moreBtn);
		Thread.sleep(3000);
		vendorBtn.click();
	}
	
}
