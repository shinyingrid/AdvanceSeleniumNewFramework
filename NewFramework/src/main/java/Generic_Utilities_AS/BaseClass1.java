package Generic_Utilities_AS;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.python.modules.thread.thread;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.HomePage;
import pomRepository.LoginPage;

public class BaseClass1 
{
	public WebDriver driver;
	public Excel_Utility elib = new Excel_Utility();
	public File_Utility flib = new File_Utility();
	public Java_Utility jlib = new Java_Utility(); 
	public Web_Utility wdlib = new Web_Utility();
	
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Database Connection");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Parallel Execution starts");
	}
	
	@Parameters("BROWSER")
	@BeforeClass
	public void configuration(String BROWSER) throws MalformedURLException
	{
		URL url = new URL("http://192.168.91.1:5555/wd/hub");
		DesiredCapabilities cap = new DesiredCapabilities();
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WINDOWS);
		}
		driver=new RemoteWebDriver(url, cap);
//		wdlib.maximizingWindow(driver);
//		wdlib.implicityWait(driver);
//		System.out.println("Launching browser");
	}
	
	@BeforeMethod
	public void beforeMethod()throws Throwable
	{
		LoginPage login = new LoginPage(driver); 
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		System.out.println("Login to Applications");
		driver.get(URL);
		Thread.sleep(2000);
		login.loginToApplication(USERNAME, PASSWORD); 
	}
	
	@AfterMethod
	public void afterMethod()
	{
		HomePage homePage1 = new HomePage(driver);
		homePage1.clickOnMyPreferences();
		homePage1.clickOnSignOut();
		System.out.println("Logout Of Applications");
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
		System.out.println("Close the browser");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("Parallel Execution Done");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Database connection closes");
	}
}
