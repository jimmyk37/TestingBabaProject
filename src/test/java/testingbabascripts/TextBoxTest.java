package testingbabascripts;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testingbabapages.Testbox;
import utility.Log;

public class TextBoxTest extends Testbox {
	
	
	Testbox ob;
	@BeforeTest
	public void geturllaunc() 
	{
		Log.starttest(getClass().getName());
		getlaunchurl("https://www.testingbaba.com/newdemo.html");
		ob = new Testbox();
	}
	
	@Test(priority=0, groups="smoke")
	public void clickonelements() 
    {
    	ob.clickonelements();
    }
	@Test(priority=1, groups= {"smoke","sanity","regression"})
	public void formfil() 
    {
    	ob.formfill();
    }
	
	@Test(priority=2, groups= {"sanity","regression"})
	public void inputoutputcheck() 
    {
    	ob.inputoutputcheck();
    }
	
	

}
