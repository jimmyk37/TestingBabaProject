package testingbabapages;

import org.testng.Assert;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	public void gettitle() 
	{
		String tital=driver.getTitle();
		System.out.println("Tital is -"+tital);
		Assert.assertEquals(tital, "Testing Baba");
	}
}
