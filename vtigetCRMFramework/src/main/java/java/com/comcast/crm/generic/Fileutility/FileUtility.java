package java.com.comcast.crm.generic.Fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * It is used to get the properties file data
	 * @param key
	 * @return String
	 * @throws Throwable
	 */
	public String getDataFromProerties(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String data = pobj.getProperty(key);
		return data;
		
	}
}
