package ObjectRepository_CrtC_S1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	// Initialization
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Declaration 
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	//Utilization 
	public WebElement getContactHeaderText() {
		return contactHeaderText;
	} 
	
	// Business Logics 
	public String VerifyHeader() {
		 return contactHeaderText.getText();
	}
	

}
