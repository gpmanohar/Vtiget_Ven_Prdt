package ObjectRepository_CrtC_S1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OraganizationPage {
	//initialization
	public OraganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Declaration 
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgBtn;
	
	// Utilization
	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}
	
	//Business Logics 
	public void createOrg() {
		createOrgBtn.click();
	}
	
	

}
