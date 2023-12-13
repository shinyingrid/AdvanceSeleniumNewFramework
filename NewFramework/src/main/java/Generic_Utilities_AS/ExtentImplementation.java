package Generic_Utilities_AS;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentImplementation implements ITestListener

{		ExtentReports report;
		ExtentTest test;

	public void onTestStart(ITestResult result) 
	{
		test=report.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	public void onTestFailure(ITestResult result)
	{
		String testData = result.getMethod().getMethodName();
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sDriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File("./ExtentScreenshot/"+testData+".png") );
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP,result.getMethod().getMethodName());

	}

	public void onStart(ITestContext context) 
	{
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Report.html"+ranNum);
		spark.config().setTheme(Theme.DARK); //DARK or STANDARD - as required
		spark.config().setDocumentTitle("Testing");
		spark.config().setReportName("Shiny");
		
		//system configuration
		
		report=new ExtentReports();
		
		report.attachReporter(spark);
		report.setSystemInfo("platform", "windows10");
		report.setSystemInfo("executed by", "Shiny");
		report.setSystemInfo("Reviwed by", "Shoba");

	}

	public void onFinish(ITestContext context)
	{
		report.flush();

	}
	
}
