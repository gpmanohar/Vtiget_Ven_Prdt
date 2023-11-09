package ObjectRepository_CrtC_S1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	// initialization
	public OrgInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	// declaration 
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	// utilization
	public WebElement getHeaderText() {
		return headerText;
	}
	
	// business logics 
	
	public String getOrgHeaderText() {
		return headerText.getText();
	}
	

}
