package ObjectRepository_PV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorDetails {
	public CreateVendorDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@name='vendorname']")
	private WebElement vendorNameFiled;
	
	@FindBy(xpath="//textarea[@name='street']")
	private WebElement streetField;
	
	@FindBy(xpath="//input[@name='city']")
	private WebElement cityField;
	
	@FindBy(xpath="//input[@name='state']")
	private WebElement stateField; 
	
	@FindBy(xpath="//input[@name='country']")
	private WebElement contryFiled;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement savebtn;
	
	
	
	//bl
	public void enterDetails(String VNAME, String SNAME, String CNAME,String STATE, String COUNTRY ) {
		vendorNameFiled.sendKeys(VNAME);
		streetField.sendKeys(SNAME);
		cityField.sendKeys(CNAME);
		stateField.sendKeys(STATE);
		contryFiled.sendKeys(COUNTRY);
		
	}
	public void saveVendorDetails() {
		savebtn.click();
	}
	
	

}
