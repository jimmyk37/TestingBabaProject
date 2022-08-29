package testingbabascripts;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import testingbabapages.LoginPage;

public class LoginTest extends BaseClass{
	
	
	LoginPage ob;
	@BeforeTest
	public void getlaunchurl() 
	{
		getlaunchurl(dataprovider.Propertyutility.getreaddata("url"));
		ob= new LoginPage();		
	}
	
	@Test
	public void gettital() 
	{
		ob.gettitle();
		
	}

}
