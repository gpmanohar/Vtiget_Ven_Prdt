package ObjectRepository_PV;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productsInfo {
	public productsInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement headerInfo;

	public WebElement getHeaderInfo() {
		return headerInfo;
	}
	
	//bl
	public String headerPageInfo() {
		return headerInfo.getText();
	}

}
