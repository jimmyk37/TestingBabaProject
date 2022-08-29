package testingbabascripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testingbabapages.CheckBox;

public class CheckBoxTest extends CheckBox{
	
	CheckBox ob;
	@BeforeTest
	public void geturllaunch() 
	{
		getlaunchurl("http://testingbaba.com/newdemo.html");
		ob= new CheckBox();		
	}

	
	@Test(priority=0, groups="smoke")
	public void clickonelements() 
    {
    	ob.clickonelements();
    }
	@Test(priority=1, groups= {"smoke", "sanity"})
	public void checkboxtest() 
	{
		ob.checkboxtest();
	}
}
