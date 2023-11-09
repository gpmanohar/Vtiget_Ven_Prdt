package GenericUtility;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	private Object currentdate;
	/**
	 * This method is used to run a random number
	 * @return
	 * @author gpmanohar
	 */
	public int RandomNumber() {
		Random r = new Random();
		int value = r.nextInt(1000);
		return value; 
		
	}
	/**
	 * This method will retun the current date in specified format
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
	    String currentdate = formatter.format(d);
	    return currentdate;
	}
	
	
	
	
	

}
