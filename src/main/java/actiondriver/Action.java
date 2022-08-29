package actiondriver;


import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import base.BaseClass;


public class Action extends BaseClass {
	
	public static void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) 
	{
		JavascriptExecutor js=  (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	public static void click(WebDriver driver, WebElement ele) {
		
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}

	public static void mouseOverElement(WebDriver driver, WebElement ele) {
	boolean flag=false;
	try {
		new Actions(driver).moveToElement(ele).build().perform();
		flag=true;
	} catch (Exception e) {
		flag=false;
	}finally {
		if(flag) {
			System.out.println("MouseOver Action performed");
		}else {System.out.println("MouseOver Action not performed");}
	}
		
	}

	public static void fluentWait(WebDriver driver, WebElement ele, int timeOut) {
		Wait<WebDriver> wait = null;
		
		try {
			wait= new FluentWait<WebDriver>((WebDriver) driver).withTimeout(Duration.ofSeconds(2)).ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.click();
			
		} catch (Exception e) {
			
		}
		
	}

	public static void implicitWait(WebDriver driver, int timeOut) {
	driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		
	}

	public static void explicitWait(WebDriver driver, WebElement ele, int timeOut) {
		WebDriverWait wait=new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		
	}

	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
		
	}

	public static String screenShot(WebDriver driver, String filename) {

       String datename= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
       TakesScreenshot takesscreenshot=(TakesScreenshot) driver;
       File source=takesscreenshot.getScreenshotAs(OutputType.FILE);
       String destination= System.getProperty("user.dir"+"\\Screenshot\\"+filename+"_"+datename+".png");
		
       try {
    	   FileUtils.copyFile(source, new File(destination));
	} catch ( Exception e) {
		e.getMessage();
	}
		String newImageString= "";
		return newImageString;
	}

	public static String getCurrrentTime() {
		String currentdate=new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		
		return currentdate;
	}

	public static String getCurrentURL(WebDriver driver) {
		boolean flag=false;
		String text=driver.getCurrentUrl();
		if(flag) {
			System.out.println("Current url is "+text);
		}
		
		return text;
	}

	public static String getTitle(WebDriver driver) {
		boolean flag=false;
		String text=driver.getTitle();
		if(flag) {
			System.out.println("Current url is "+text);
		}
		
		return text;
	}

	public static boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag=false;
		flag=findElement(driver, ele);
		if (flag) {
			flag=ele.isDisplayed();
			if(flag) {
				System.out.println("Element is Displayed");
			} else {System.out.println("Element is not displayed");}
		} else {System.out.println("Not displayed");}
		
		return flag;
	}
	
	public static boolean type(WebElement ele, String text) {
		
		boolean flag=false;
		try {
			ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag=true;
			
		} catch (Exception e) {
			System.out.println("Element not Found");
			flag=false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else 
			{
				System.out.println("Unable to Enter Value");
			}
		}
		return flag;
	}
	
public static boolean switchtoframe(WebElement frame) {
		
		boolean flag=false;
		try {
			driver.switchTo().frame(frame);
			flag=true;
			
		} catch (Exception e) {
			System.out.println("Frame not Found");
			flag=false;
		} finally {
			if (flag) {
				System.out.println("Successfully Switched To Frame");
			} else 
			{
				System.out.println("Unable to Switch To Frame");
			}
		}
		return flag;
	}
	
	public static boolean findElement(WebDriver Idriver, WebElement ele) {
		boolean flag=false;
		try {
			ele.isDisplayed();
			flag=true;
			
		} catch (Exception e) {
			flag=false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found Element");
			} else 
			{
				System.out.println("Unable to find Element");
			}
		}
		return flag;
	}
	
	public static boolean isSelected(WebDriver Idriver, WebElement ele) {
		boolean flag=false;
		flag=findElement(driver, ele);
		if (flag) {
			flag=ele.isSelected();
			flag=true;
		} else {flag=false;}
		
		return flag;
	}
	
	public static boolean isEnabled(WebDriver Idriver, WebElement ele) {
		boolean flag=false;
		flag=findElement(driver, ele);
		if (flag) {
			flag=ele.isEnabled();
			if(flag) {
				System.out.println("Element is Enabled");
			} else {System.out.println("Element is not Enabled");}
		} else {System.out.println("Not Enabled");}
		
		return flag;
	}

	public static boolean selectBySendkeys(String value, WebElement ele) {
		boolean flag=false;
		try {
			ele.sendKeys(value);
			flag=true;
			
		} catch (Exception e) {
			flag=false;
		} finally {
			if (flag) {
				System.out.println("Select value from the dropdown");
			} else 
			{
				System.out.println("Not Selected value from Dropdown");
			}
		}
		return flag;
	}

	public static boolean selectByIndex(WebElement element, int index) {
		boolean flag=false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag=true;
			
		} catch (Exception e) {
			flag=false;
		} finally {
			if(flag) {
				System.out.println("Element is Selcted by Index" +index);
			}else {System.out.println("Element is not selected");}
		}
		
		return flag;
	}

	public static boolean selectByValue(WebElement ele, String value) {
		boolean flag=false;
		try {
			Select s = new Select(ele);
			s.selectByValue(value);
			flag=true;
			
		} catch (Exception e) {
			flag=false;
		} finally {
			if(flag) {
				System.out.println("Element is Selcted by value" +value);
			}else {System.out.println("Element is not selected");}
		}
		
		return flag;
	}
	
	public static boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag=false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag=true;
			
		} catch (Exception e) {
			flag=false;
		} finally {
			if(flag) {
				System.out.println("Element is Selcted by value" +visibletext);
			}else {System.out.println("Element is not selected");}
		}
		
		return flag;
	}

	
	public static boolean mouseHoverByJavaScript(WebElement ele) {
		boolean flag=false;
		try {
			WebElement mo=ele;
			String javaScript="var evObj = document.createEvent('MouseEvents');"
			                  +"evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0,false,false,false,false,false,0,null);"
			                  +"arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag=true;
			
		} catch (Exception e) {
			flag=false;
		} finally {
			if(flag) {System.out.println("MouseOver action is performed");				
			}else {System.out.println("Mouseover Action is not performed");}
		}
		return flag;
	}

	
	public static boolean JSClick(WebDriver driver, WebElement ele) throws Exception{
		boolean flag=false;
		try {
			JavascriptExecutor executer= (JavascriptExecutor) driver;
			executer.executeScript("arguments[0].click();", ele);
			flag=true;
		} catch (Exception e) {
			throw e;
		
		} finally {
			if(flag) {
				System.out.println("Click action is performed");
			}else if (!flag) {System.out.println("Click Action is not performed");}
		}
		return flag;
	}


	public static boolean switchToFrameByIndex(WebDriver driver, int index) {
		boolean flag=false;
		try {
			new WebDriverWait(driver, 15).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(index);
			flag=true;
		} catch (Exception e) {
			flag=false;
		}finally {
			if(flag) {
				System.out.println("Frame with index "+index+"is selected");
			}else {System.out.println("Frame with index "+index+"is not selected");}
		}
		
		return flag;
	}

	
	public static boolean switchToFrameByID(WebDriver driver, String idValue) {
		boolean flag=false;
		try {
			
			driver.switchTo().frame(idValue);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				System.out.println("Frame with id "+idValue+"is selected");
			}else {System.out.println("Frame with id "+idValue+"is not selected");}
		}
		
		return flag;
	}
	
	
	public static boolean switchToFrameByname(WebDriver driver, String nameValue) {
		boolean flag=false;
		try {
			
			driver.switchTo().frame(nameValue);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				System.out.println("Frame with name "+nameValue+"is selected");
			}else {System.out.println("Frame with name "+nameValue+"is not selected");}
		}
		
		return flag;
	}

	
	public static boolean switchToDefaultFrame(WebDriver driver) {
		boolean flag=false;
		try {
			
			driver.switchTo().defaultContent();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				System.out.println("switched To Default Frame");
			}else {System.out.println("not switched To Default Frame");}
		}
		
		return flag;
	}


	public static boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag=false;
         try {
			JavascriptExecutor executer=(JavascriptExecutor) driver;
			executer.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions= new Actions(driver);
			actions.moveToElement(ele).build().perform();
			flag=true;
			
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}		
		return flag;
	}

	
	public static boolean mouseover(WebDriver driver, WebElement ele) {
		boolean flag=false;
        try {
			new Actions(driver).moveToElement(ele).build().perform();			
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				System.out.println("Mouse Over Action is performed " );
			}else {System.out.println("Mouse Over Action is not performed");}
		}

		
		return flag;
	}
	
	
	public static boolean draggable(WebDriver driver, WebElement source, int x, int y) {
		boolean flag=false;
        try {
			new Actions(driver).dragAndDropBy(source, x, y)	;
			Thread.sleep(5000);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				System.out.println("Draggable Action is performed on "+source );
			}else {System.out.println("Draggable Action is not performed on "+source);}
		}

		
		return flag;
	}

	
	public static boolean draganddrop(WebDriver driver, WebElement ele, WebElement target) {
		boolean flag=false;
        try {
			new Actions(driver).dragAndDrop(ele, target);
			Thread.sleep(5000);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				System.out.println("Drag and drop action is performed on ");
			}else {System.out.println("Drag and drop action is not performed on ");}
		}

		
		return flag;
	}

	
	public static boolean slider(WebDriver driver, WebElement ele, int x, int y) {
		boolean flag=false;
        try {
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();
			Thread.sleep(5000);
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				System.out.println("Slider Action is performed  ");
			}else {System.out.println("Slider Action is not performed  ");}
		}

		
		return flag;
	}

	
	public static boolean rightclick(WebDriver driver, WebElement ele) {
		boolean flag=false;
        try {
			Actions actions=new Actions(driver);
			actions.contextClick().perform();
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
			flag=false;
		}finally {
			if(flag) {
				System.out.println("Right Click is performed  ");
			}else {System.out.println("Right Click is not performed  ");}
		}

		
		return flag;
	}

	
	public static boolean switchWindowByTitle(WebDriver driver, String windowTitle, int count) {
		boolean flag=false;
		try {
			Set<String> windowList = driver.getWindowHandles();
			String[] array = windowList.toArray(new String[0]);
			driver.switchTo().window(array[count-1]);
			
			if (driver.getTitle().contains(windowTitle)) {
				flag=true;
			}else {flag=false; }
			
		} catch (Exception e) {
			flag=false;
		} finally {
			if(flag){
				System.out.println("Window is switched by "+windowTitle);
			}else {System.out.println("Window is not switched by "+windowTitle);}
		} 
		
		return flag;
	}

	
	public static boolean switchToNewWindow(WebDriver driver) {
		boolean flag=false;
		try {
			Set<String> s = driver.getWindowHandles();
			Object[] popup = s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag=true;
		} catch (Exception e) {
			flag=false;
		}finally {
			if(flag){
				System.out.println("Window is Navigated to new Window ");
			}else {System.out.println("Window is not Navigated to new Window  ");}
		} 

		return flag;
	}

	
	public static boolean switchToOldWindow(WebDriver driver) {
		boolean flag=false;
		try {
			Set<String> s = driver.getWindowHandles();
			Object[] popup = s.toArray();
			driver.switchTo().window(popup[0].toString());
			flag=true;
		} catch (Exception e) {
			flag=false;
		}finally {
			if(flag){
				System.out.println("Window is Navigated to old Window ");
			}else {System.out.println("Window is not Navigated to old Window  ");}
		} 

		return flag;
	}

	
	public static boolean Alert(WebDriver driver) {
		
		return false;
	}

	
	public static boolean launchUrl(WebDriver driver, String url) {
		boolean flag=false;
		try {
			driver.navigate().to(url);
			flag=true;
		} catch (Exception e) {
			flag=false;
		}finally {
			if(flag){
				System.out.println("Successfully launched URL-  "+url);
			}else {System.out.println("Fail to launch URL-  "+url);}
		}  
		
		
		return flag;
	}

	
	public static boolean isAlertPresent(WebDriver driver) {
		boolean flag=false;
		try {
			driver.switchTo().alert();
			flag=true;
			
		} catch (NoAlertPresentException e) {
			flag=false;
		}
		return flag;
	}

	
	public static boolean click1(WebElement locator, String locatorname) {
		boolean flag=false;
		try {
			locator.click();
			flag=true;
		} catch (Exception e) {
			flag=false;
		}finally {
			if(flag){
				System.out.println("Able to click on-  "+locatorname);
			}else {System.out.println("Not able to click on-  "+locatorname);}
		}  
		
		
		return flag;
	}

	
	public static int getColumnCount(WebElement column) {
		List<WebElement> columns = column.findElements(By.tagName("td"));
		int a=columns.size();
		System.out.println(a);
		for (WebElement column1:columns) {
			System.out.println(column1.getText());
			System.out.println("|");
		}
		return a;
	}

	
	public static int getRowCount(WebElement row) {
		List<WebElement> rows = row.findElements(By.tagName("tr"));
		int a=rows.size()-1;
	
		return a;
	}

}
