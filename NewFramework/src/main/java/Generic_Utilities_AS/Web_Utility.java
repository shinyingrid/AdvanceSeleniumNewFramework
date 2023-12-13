package Generic_Utilities_AS;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Web_Utility 
{
//---------------------------------------------------------------------------------------------	
	//Method to maximize the window
	//@param : driver
	public void maximizingWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
//--------------------------------------------------------------------------------------------	
	//Method to minimize the window
		//@param : driver
	public void minimizingWindow(WebDriver driver)
	{
		 //driver.manage().window().minimize();
	}

//------------------------------------------------------------------------------------------
	
	//Method to make the elements wait to get loaded in the GUI
	public void implicityWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
//------------------------------------------------------------------------------------------	
	
	//This method is used to switch to another window
	public void windowSwitching(WebDriver driver,String partialVisibleText)
	{
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> win = allWindows.iterator();
		
		while(win.hasNext())
		{
			String winText = win.next();
			driver.switchTo().window(winText);
			String title = driver.getTitle();
			
			if(title.contains(partialVisibleText))
			{
				break;
			}
		}
	}
//-----------------------------------------------------------------------------------------	
	
	
	//This method is used to handle the alert pop-up
	public void alertAccept(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
		
	public void alertDismiss(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
//---------------------------------------------------------------------------------------------	
	
	//This method is used to point the element
	public void ActionsMoveToElement(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}
	
//-----------------------------------------------------------------------------------------------
	
	//This method is used to take screenshot (Using this in ExtentReports)
	
	public static String takeScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(".ScreenShots/"+screenShotName+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();
		
	}

	
}
