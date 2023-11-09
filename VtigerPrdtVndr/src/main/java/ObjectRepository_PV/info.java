package ObjectRepository_PV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class info {
	public info (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement infodetails;
	
	public WebElement getInfodetails() {
		return infodetails;
	}
	
	public String getinfo() {
		 return infodetails.getText();
	}

}
