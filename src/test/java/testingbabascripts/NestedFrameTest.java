package testingbabascripts;

import org.testng.annotations.BeforeTest;

import base.BaseClass;
import testingbabapages.LoginPage;

public class NestedFrameTest extends BaseClass{
	LoginPage ob;
	@BeforeTest
	public void getlaunchurl() 
	{
		getlaunchurl(dataprovider.Propertyutility.getreaddata("url"));
		ob= new LoginPage();		
	}
}