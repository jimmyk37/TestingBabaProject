package base;


import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import utility.Log;




public class BaseClass {
	public static WebDriver driver;
	
	
	@BeforeSuite
	public void beforesuit() {
		DOMConfigurator.configure("log4j.xml");
		Log.info("This is Before suit Method");
		
	}
	public void getlaunchurl(String url) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jimmy\\eclipse-workspace\\TestingBabaProject\\Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		Log.info("Launched Chrome");
		driver.manage().window().maximize();
		Log.info("Maximised Window");
		driver.get(url);
		Log.info("Launched Testing Baba URL");
		
			
	}
	
	@AfterTest
	public void teardown() 
	{
		
		Log.info("This is after suit Method");
		driver.quit();
	}
	

}
