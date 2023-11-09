package ObjectRepository_CrtC_S1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	// initialization 
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	// Declaration 
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement createContBtn;
	
	//utilization
	public WebElement getCreateContBtn() {
		return createContBtn;
	}
	
	// Business Logics 
	public void clickonCreateCont() {
		createContBtn.click();
	}
	

}
