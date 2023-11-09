package ObjectRepository_PV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vendorInfo {
	public vendorInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement headerdetail;

	public WebElement getHeaderdetail() {
		return headerdetail;
	} 
	
	//bl 
	public String headerinfo() {
		return headerdetail.getText();
	}

}
