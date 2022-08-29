package dataprovider;

import java.io.FileInputStream;
import java.util.Properties;

public class Propertyutility {
	static String path="C:\\Users\\Jimmy\\eclipse-workspace\\TestingBabaProject\\Configration\\config.properties";
	public static String getreaddata(String key)
	{
		String value="";
		try 
		{
			FileInputStream fis= new FileInputStream(path);
			Properties prop= new Properties();
			prop.load(fis);
			value=prop.getProperty(key)
;
		} catch (Exception e) 
		{
			System.out.println("Issue iin Get read data "+e);
		}
		return value;
	}
}
