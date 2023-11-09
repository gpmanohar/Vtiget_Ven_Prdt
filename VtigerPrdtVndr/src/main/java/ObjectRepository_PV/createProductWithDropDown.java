package ObjectRepository_PV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class createProductWithDropDown extends WebDriverUtility {
	//Initialization 
	public createProductWithDropDown (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// declaration 
	@FindBy(xpath="//input[@name='productname']")
	private WebElement enterpname;
	
	@FindBy(xpath="//select[@name='productcategory']")
	private WebElement dropdown;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveBtn;

	// Utilization
	public WebElement getEnterpname() {
		return enterpname;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	} 
	
	//Bl 
	public void enterPrdtName(String PNAME) {
		enterpname.sendKeys(PNAME);
	}
	public void selectDropDown(String CATEGORY) {
		handleDropDown(dropdown, CATEGORY);
		
	}
	public void saveDetails() {
		saveBtn.click();
	}

}
