package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtility {
	/**
	 * This method will read all the data from propertyfile and retuen the data value to caller 
	 * @param key
	 * @return
	 * @throws IOException
	 * @author gpmanohar
	 */
	public String readDataFromPropertyFile(String key) throws IOException  {
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
		
	}

}
