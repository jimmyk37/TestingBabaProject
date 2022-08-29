package testingbabapages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Links extends BaseClass{
	public Links() {	PageFactory.initElements(driver, this);}

	@FindBy(xpath="//*[@data-target=\"#elements\"]")
	private WebElement element;

	public void clickonelements() 
	{
		element.click();
	}
}
