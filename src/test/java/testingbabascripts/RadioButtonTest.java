package testingbabascripts;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import testingbabapages.RadioButton;

public class RadioButtonTest extends BaseClass{
	RadioButton ob;
	@BeforeTest
	public void getlaunchurl() 
	{
		getlaunchurl(dataprovider.Propertyutility.getreaddata("url"));
		ob= new RadioButton();		
	}
	
	@Test(priority=0, groups="smoke")
	public void clickonelements() 
    {
    	ob.clickonelements();
    }
	
	@Test(priority=1, groups="smoke")
	public void RadioButtonClick() 
    {
    	ob.RadioButtonClick();
    }
	
}
