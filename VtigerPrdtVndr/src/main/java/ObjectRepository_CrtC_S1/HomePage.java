package ObjectRepository_CrtC_S1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	// initialization 
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	// declaration 
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement orgBtn;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement cntBtn;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement prdtBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutBtn;
	
	// utilization 
	public WebElement getOrgBtn() {
		return orgBtn;
	}

	public WebElement getCntBtn() {
		return cntBtn;
	}

	public WebElement getPrdtBtn() {
		return prdtBtn;
	}

	public WebElement getAdminIcon() {
		return adminIcon;
	}

	public WebElement getSignoutBtn() {
		return signoutBtn;
	}
	
	// Business Logics
	public void clickonCont() {
		cntBtn.click();
	}
	public void clickonOrg() {
		orgBtn.click();
	}
	public void clickonPrdt() {
		prdtBtn.click();
	}
	
	public void logoutOfApp(WebDriver driver) throws InterruptedException {
		mouseHoverActions(driver, adminIcon);
		Thread.sleep(6000);
		signoutBtn.click();
	}
	
	
	

}
