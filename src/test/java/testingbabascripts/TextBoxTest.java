package testingbabascripts;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testingbabapages.Testbox;

public class TextBoxTest extends Testbox {
	
	
	Testbox ob;
	@BeforeTest
	public void geturllaunc() 
	{
		getlaunchurl(dataprovider.Propertyutility.getreaddata("url"));
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
