package ItestListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository_CrtC_S1.ContactInfoPage;
import ObjectRepository_CrtC_S1.ContactsPage;
import ObjectRepository_CrtC_S1.CreateNewContPage;
import ObjectRepository_CrtC_S1.HomePage;
import ObjectRepository_CrtC_S1.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(GenericUtility.ListinersImplementation.class)
public class CreateContactsDetailsTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void CreateContactsDetails() throws Throwable {
		       
		
				
				// Test data
				String Lastname = eutil.readDataFromExcel("contacts", 1, 2);
				
				// click on contacts moudle
				HomePage hp = new HomePage(driver);
				hp.clickonCont();
				//click on create cont
				ContactsPage cp = new ContactsPage(driver);
				cp.clickonCreateCont();
				// enter mandatory details 
				CreateNewContPage cncp = new CreateNewContPage(driver);
				cncp.clickonCreateNewC(Lastname);
				// validating name 
				ContactInfoPage cip = new ContactInfoPage(driver);
				String header = cip.VerifyHeader();
				Assert.assertTrue(header.contains(Lastname));
				/* if(header.contains(Lastname)) {
					System.out.println(header);
					System.out.println("PASS");
				}
				else
				{
					System.out.println("FAIL");
				}*/
			

	}

}
