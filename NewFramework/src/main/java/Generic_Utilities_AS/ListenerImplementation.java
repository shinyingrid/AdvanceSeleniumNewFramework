package Generic_Utilities_AS;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener

{

	public void onTestFailure(ITestResult result)
	{
		String failedTestData = result.getMethod().getMethodName();
		
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(BaseClass.sDriver);
		
		File src = eventDriver.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File("./SampleScreenshotListener/"+failedTestData+".png"));
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
}
