package ObjectRepository_PV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vendorsPage {
	
	public vendorsPage(WebDriver driver ) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Vendor...']")
	private WebElement vendorLookupicon;

	public WebElement getVendorLookupicon() {
		return vendorLookupicon;
	}
	
	//BL
	public void clickonvendorlookup() {
		vendorLookupicon.click();
	}

}
