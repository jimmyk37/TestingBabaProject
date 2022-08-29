package testingbabapages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import actiondriver.Action;
import base.BaseClass;

public class RadioButton extends BaseClass{
	public RadioButton() {	PageFactory.initElements(driver, this);}

	@FindBy(xpath="//*[@data-target=\"#elements\"]")
	private WebElement element;
	@FindBy(xpath="//a[text()='radio buttons']")
	private WebElement radiobutton;
	@FindBy(xpath="//input[@id='yes']")
	private WebElement yes;
	@FindBy(xpath="//input[@id='impressive']")
	private WebElement impressive;
	@FindBy(xpath="//input[@id='no']")
	private WebElement no;
	@FindBy(xpath="//p[@id='radio-content']")
	private WebElement outputmassage;
	

	public void clickonelements() 
	{
		Action.click(driver, element);
		boolean result =Action.isDisplayed(driver, radiobutton);
		Assert.assertEquals(result, true);
		
	}
	
	public void RadioButtonClick() 
	{
		
		Action.click(driver, radiobutton);		
		Action.click(driver, yes);
		String Actual=outputmassage.getText().trim();
		Assert.assertEquals(Actual, "You have selected yes");
		Action.click(driver, impressive);
		String Actual1=outputmassage.getText().trim();
		Assert.assertEquals(Actual1, "You have selected impressive");
		Action.click(driver, no);
		String Actual2=outputmassage.getText().trim();
		Assert.assertEquals(Actual2, "You have selected no");
		
	}
	
	
}
