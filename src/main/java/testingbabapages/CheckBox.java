package testingbabapages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import actiondriver.Action;
import base.BaseClass;

public class CheckBox extends BaseClass{
public CheckBox() {	PageFactory.initElements(driver, this);}

@FindBy(xpath="//*[@data-target=\"#elements\"]")
private WebElement element;
@FindBy(xpath="//a[text()=\"check box\"]")
private WebElement Checkbox;
@FindBy(xpath="//*[@id=\"tab_2\"]/div/iframe")
private WebElement frame1;
@FindBy(xpath="//*[@id=\"myCheck\"]")
private WebElement myCheck;
@FindBy(xpath="//*[@id=\"mylaptop\"]")
private WebElement mylaptop;
@FindBy(xpath="//*[@id=\"mydesktop\"]")
private WebElement mydesktop;

@FindBy (xpath="//*[@id=\"text\"]")
private WebElement SelectedMobile;
@FindBy (xpath="//*[@id=\"text1\"]")
private WebElement SelectedLaptop;
@FindBy (xpath="//*[@id=\"text2\"]")
private WebElement SelectedDesktop;

public void clickonelements() 
{
	Action.click(driver, element);
	boolean result=Action.isDisplayed(driver, Checkbox);
	Assert.assertEquals(result, true);
}



public void checkboxtest() 
{
	Action.click(driver, Checkbox);
	boolean result=Action.switchtoframe(frame1);
	Assert.assertEquals(result, true);
	Action.implicitWait(driver, 5);
	Action.click(driver, myCheck);
	Action.isSelected(driver, myCheck);
	String actual1=driver.findElement(By.xpath("//*[@id=\"text\"]")).getText().trim();
	System.out.println(actual1);
	Assert.assertEquals(actual1, "You are selected Mobile");	
	Action.click(driver, mylaptop);
	Action.isSelected(driver, mylaptop);
	String actual2=driver.findElement(By.xpath("//*[@id=\"text1\"]")).getText().trim();
	System.out.println(actual2);
	Assert.assertEquals(actual2, "You are Selected Laptop");
	Action.click(driver, mydesktop);
	Action.isSelected(driver, mydesktop);
	String actual3=driver.findElement(By.xpath("//*[@id=\"text2\"]")).getText().trim();	
	System.out.println(actual3);
	Assert.assertEquals(actual3, "You are Selected Desktop");
	Action.switchToDefaultFrame(driver);
	
}

}
