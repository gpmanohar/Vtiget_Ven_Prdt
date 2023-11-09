package ObjectRepository_CrtC_S1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateNewOrgPage extends WebDriverUtility {
	//initialization
	public  CreateNewOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// declaration 
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement clickonOrgNameFiled;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement clickonIndustry;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement clickonAccType;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement clickonsaveBtn;

	//utilization
	public WebElement getClickonOrgNameFiled() {
		return clickonOrgNameFiled;
	}

	public WebElement getClickonIndustry() {
		return clickonIndustry;
	}

	public WebElement getClickonAccType() {
		return clickonAccType;
	}

	public WebElement getClickonsaveBtn() {
		return clickonsaveBtn;
	}
	
	//business logics 
	public void createNewOrg(String ORGNAME) {
		clickonOrgNameFiled.sendKeys(ORGNAME);
		//clickonsaveBtn.click();
	}
	public void createNewOrgD(String ORGNAME) {
		clickonOrgNameFiled.sendKeys(ORGNAME);
		
		
	}
	public void indDrop(String INDUSTRY) {
		handleDropDown(clickonIndustry, INDUSTRY);
		
	}
	public void CreateNewOrgT(String TYPE){
		
		handleDropDown(clickonAccType, TYPE);
		
	}
	public void saveData() {
		clickonsaveBtn.click();
	}
	
	
	

}
