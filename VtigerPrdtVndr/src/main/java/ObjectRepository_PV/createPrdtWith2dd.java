package ObjectRepository_PV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class createPrdtWith2dd extends WebDriverUtility{
	public createPrdtWith2dd(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement prdtField; 
	
	@FindBy(xpath="//select[@name='productcategory']")
	private WebElement categoryDrop;
	
	@FindBy(xpath="//select[@name='manufacturer']")
	private WebElement manufDrop;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveBtn;

	public WebElement getPrdtField() {
		return prdtField;
	}

	public WebElement getCategoryDrop() {
		return categoryDrop;
	}

	public WebElement getManufDrop() {
		return manufDrop;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//bl
	public void EnterPrdtName(String PNAME) {
		prdtField.sendKeys(PNAME);
	}
	public void categoryDrop(String CATEGORY) {
		handleDropDown(categoryDrop, CATEGORY);
	}
	public void manufacDrop(String MANUFAC) {
		handleDropDown(manufDrop, MANUFAC);
	}
	public void saveData() {
		saveBtn.click();
	}
}
