package ObjectRepository_PV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductDetails {
	// initialization 
	public CreateProductDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Declaration 
	@FindBy(xpath="//input[@name='productname']")
	private WebElement clickonPrdt;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement clickonSave;

	// Utilization 
	public WebElement getClickonPrdt() {
		return clickonPrdt;
	}

	public WebElement getClickonSave() {
		return clickonSave;
	} 
	//Business Logics 
	public void ProductDetails(String PRODUCT) {
		clickonPrdt.sendKeys(PRODUCT);
	}
	public void Save() {
		clickonSave.click();
	}
	
	

}
