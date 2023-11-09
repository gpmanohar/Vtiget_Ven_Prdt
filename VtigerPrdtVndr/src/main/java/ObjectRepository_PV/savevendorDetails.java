package ObjectRepository_PV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class savevendorDetails {
	public savevendorDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="savevendorDetails")
	private WebElement savebtn;

	public WebElement getSavebtn() {
		return savebtn;
	}
	// bl 
	public void SaveVendorDetails() {
		savebtn.click();
	}

}
