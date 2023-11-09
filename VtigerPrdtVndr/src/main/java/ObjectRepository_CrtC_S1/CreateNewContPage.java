package ObjectRepository_CrtC_S1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateNewContPage extends WebDriverUtility {
	// Intialization 
	public CreateNewContPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Declaration 
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement clickonLastnameField; 
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement clickonsaveBtn;
	
	@FindBy(xpath="(//img[@alt='Select'])[1]")
	private WebElement clickonOrgLookUp;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement clickonSearchtText;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement clickonSearchBtn;

	public WebElement getClickonLastnameField() {
		return clickonLastnameField;
	}

	public WebElement getClickonsaveBtn() {
		return clickonsaveBtn;
	}

	public WebElement getClickonOrgLookUp() {
		return clickonOrgLookUp;
	}

	public WebElement getClickonSearchtText() {
		return clickonSearchtText;
	}

	public WebElement getClickonSearchBtn() {
		return clickonSearchBtn;
	}
	
	//business logics
	public void clickonCreateNewC(String LASTNAME) throws Throwable {
		clickonLastnameField.sendKeys(LASTNAME);
	
		clickonsaveBtn.click();
	}
	public void clickonCreateNewCont(WebDriver driver,String ORGNAME,String LASTNAME) {
		clickonLastnameField.sendKeys(LASTNAME);
		clickonOrgLookUp.click();
		switchToWindow(driver,"Accounts");
		clickonSearchtText.sendKeys(ORGNAME);
		clickonSearchtText.click();
		driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		clickonsaveBtn.click();
		
		
		
	}
	

}
