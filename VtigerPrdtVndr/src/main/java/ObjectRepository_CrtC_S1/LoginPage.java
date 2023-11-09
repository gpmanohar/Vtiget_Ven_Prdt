package ObjectRepository_CrtC_S1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// Initilization 
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// declaration 
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement userbtn;
	
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement passBtn;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;
    
	// uilization 
	public WebElement getUserbtn() {
		return userbtn;
	}

	public WebElement getPassBtn() {
		return passBtn;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	// business Logics 
	public void logIntoApp(String USERNAME, String PASSWORD) {
		userbtn.sendKeys(USERNAME);
		passBtn.sendKeys(PASSWORD);
		loginBtn.click();
		
	}
	

}

