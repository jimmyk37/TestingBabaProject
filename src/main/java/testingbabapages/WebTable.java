package testingbabapages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import actiondriver.Action;
import base.BaseClass;
import utility.Log;

public class WebTable extends BaseClass{
	public WebTable() {	PageFactory.initElements(driver, this);}

	@FindBy(xpath="//a[text()='web tables']")
	private WebElement WebTable;
	@FindBy(xpath="//*[@id=\"tab_4\"]/div/iframe")
	private WebElement frame;
	@FindBy(xpath="//*[text()='Name:']/following::input[@name='name']")
	private WebElement Name;
	@FindBy(xpath="//*[text()='Email:']/following::input[@name='email']")
	private WebElement Email;
	@FindBy(xpath="//button[text()='Save']")
	private WebElement Save;
	@FindBy(xpath="//*[@data-target=\"#elements\"]")
	private WebElement element;
	

	public void clickonelements() 
	{
		Action.click(driver, element);
		Log.info("Clicked on Element");
		boolean result=Action.isDisplayed(driver, WebTable);		
		Assert.assertEquals(result, true);
		Log.info("WebTable Displayed");
	}
	
	public void InsertDataInTable() 
	{
		Action.click(driver, WebTable);
		Log.info("Clicked on Web Table");
		Action.switchtoframe(frame);
		Log.info("Switched to frame");
		for(int i=0;i<10;i++) {
		Action.type(Name, dataprovider.ExcelUtility.getreaddata(i, 0,  0));
		Log.info("Entered Name"+dataprovider.ExcelUtility.getreaddata(i, 0,  0));
		Action.type(Email, dataprovider.ExcelUtility.getreaddata(i, 1, 0));
		Log.info("Entered Email"+dataprovider.ExcelUtility.getreaddata(i, 1,  0));
		Action.click(driver, Save);
		Log.info("Data Saved");
		
		}
		}
		
		public void checkinserteddata() 
		{
			Action.click(driver, WebTable);
			Log.info("Clicked on Web Table");
			Action.switchtoframe(frame);
			Log.info("Switched to frame");
			for(int i=0;i<10;i++) {
			Action.type(Name, dataprovider.ExcelUtility.getreaddata(i, 0,  0));
			Log.info("Entered Name"+dataprovider.ExcelUtility.getreaddata(i, 0,  0));
			Action.type(Email, dataprovider.ExcelUtility.getreaddata(i, 1, 0));
			Log.info("Entered Email"+dataprovider.ExcelUtility.getreaddata(i, 1,  0));
			Action.click(driver, Save);
			Log.info("Data Saved");
			
			
			}
	
	}
}
