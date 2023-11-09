package ItestListeners;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtility.BaseClass;
import ObjectRepository_CrtC_S1.ContactInfoPage;
import ObjectRepository_CrtC_S1.ContactsPage;
import ObjectRepository_CrtC_S1.CreateNewContPage;
import ObjectRepository_CrtC_S1.HomePage;

@Listeners(GenericUtility.ListinersImplementation.class)
public class CreateContWithOrgTest extends BaseClass {

	@Test
	public void CreateContWithOrg() throws Throwable {
	       
			
					
					// Test data
					String Lastname = eutil.readDataFromExcel("contacts", 4, 2);
					String ORGNAME = eutil.readDataFromExcel("contacts", 4, 3);
					
					
					// click on cont module
					HomePage hp = new HomePage(driver);
					hp.clickonCont();
					// click on contact page 
					ContactsPage cp = new ContactsPage(driver);
					cp.clickonCreateCont();
					Assert.fail();
					CreateNewContPage cncp = new CreateNewContPage(driver);
					cncp.clickonCreateNewCont(driver, ORGNAME, Lastname);
					// verify 
					ContactInfoPage cip = new ContactInfoPage(driver);
					String header = cip.VerifyHeader();
					Assert.assertTrue(header.contains(Lastname));
					
					/*if(header.contains(Lastname)) {
						System.out.println(header);
						System.out.println("PASS");
					}
					else
					{
						System.out.println("FAIL");
					} */ 
					

	}

}
