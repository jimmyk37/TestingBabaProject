package testingbabapages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import actiondriver.Action;
import base.BaseClass;
import utility.Log;


public class Testbox extends BaseClass{
	

	public Testbox() {PageFactory.initElements(driver, this);	}
	
	@FindBy(xpath="//*[@data-target=\"#elements\"]")
	private WebElement element;
	@FindBy(xpath="//a[text()=\"text box\"]")
	private WebElement textbox;
	@FindBy(xpath="//*[@id=\"fullname1\"]")
	private WebElement fullname;
	@FindBy(xpath="//*[@id=\"fullemail1\"]")
	private WebElement email;
	@FindBy(xpath="//*[@id=\"fulladdresh1\"]")
	private WebElement currentadd;
	@FindBy(xpath="//*[@id=\"paddresh1\"]")
	private WebElement permanentadd;
	@FindBy(xpath="//*[@value=\"Submit\"]")
	private WebElement submit;
	@FindBy (xpath="//*[@class=\"col-md-6 mt-5\"]/label")
	private WebElement OutputElement;
	
	
		
	public void clickonelements() 	{
		
		
		Action.click(driver, element);
		Log.info("clicked on Element");
		boolean result=Action.isDisplayed(driver, textbox);
		Assert.assertEquals(result, true);		
		
	}
	
	
	public void formfill() 
	{
		
		Action.click(driver, textbox);
		Log.info("clicked on Text Box");
		Action.type(fullname, dataprovider.ExcelUtility.getreaddata(2, 0,  1));
		Log.info("Provide Full Name ");
		Action.type(email, dataprovider.ExcelUtility.getreaddata(2, 1,  1));
		Log.info("Provided Email ");
		Action.type(currentadd, dataprovider.ExcelUtility.getreaddata(2, 2,  1));
		Log.info("Provided CUrrent Address ");
		Action.type(permanentadd, dataprovider.ExcelUtility.getreaddata(2, 3, 1));
		Log.info("Provided Permanent Address ");
		Action.click(driver, submit);
		Log.info("Clicked on submit button");
		
		boolean result=Action.isDisplayed(driver, OutputElement);
		Assert.assertEquals(result, true);	
	}
	
	public void inputoutputcheck() 
	{
		List<WebElement> output = driver.findElements(By.xpath("//*[@class=\"col-md-6 mt-5\"]/label"));
		
		ArrayList<String> Actual=new ArrayList<String>(); 
		
		
		for (int i=1;i<8;i++) 
		{
			String test=output.get(i).getText();
			Actual.add(test);
			i++;
		}
		
		for (int i=0;i<4;i++) {
			Assert.assertEquals(Actual.get(i), dataprovider.ExcelUtility.getreaddata(2, i,  1));;
		}
		
		
	}
}
