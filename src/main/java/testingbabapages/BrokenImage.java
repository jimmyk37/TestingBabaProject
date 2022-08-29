package testingbabapages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class BrokenImage extends BaseClass{
	public BrokenImage() {	PageFactory.initElements(driver, this);}

	@FindBy(xpath="//*[@data-target=\"#elements\"]")
	private WebElement element;

	public void clickonelements() 
	{
		element.click();
	}
}
