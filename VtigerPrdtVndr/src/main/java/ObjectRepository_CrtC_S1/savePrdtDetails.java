package ObjectRepository_CrtC_S1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class savePrdtDetails {
	public savePrdtDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveBtn;

	public WebElement getSaveBtn() {
		return saveBtn;
	} 
	
	//bl
	public void saveBtnnn() {
		saveBtn.click();
	}

}
