package Generic_Utilities_AS;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility
{
	
	/* This method is used to fetch common data in appication
	 * @param key
	 * @return
	 * @throws Throwable
	 * @Author Shiny
	 */
	public String getKeyAndValueData(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonDataFramework.properties.txt");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
}
