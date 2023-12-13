package Generic_Utilities_AS;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class BaseClass 
{
	public WebDriver driver;
	//For Listener concept we are creating a static webdriver. This sdriver focuses on the failures and takes screenshot
	public static WebDriver sDriver;
	public Excel_Utility elib = new Excel_Utility();
	public File_Utility flib = new File_Utility();
	public Java_Utility jlib = new Java_Utility(); 
	public Web_Utility wdlib = new Web_Utility();
	
	
	@BeforeSuite(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void beforeSuite()
	{
		System.out.println("Database Connection");
	}
	
	@BeforeTest(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void beforeTest()
	{
		System.out.println("Parallel Execution starts");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void beforeClass() throws Throwable
	{
		File_Utility flib1 = new File_Utility();
		String BROWSER = flib1.getKeyAndValueData("browser");
	
	//	public void beforeClass(String BROWSER) throws Throwable
		//{
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		}
		wdlib.maximizingWindow(driver);
		wdlib.implicityWait(driver);
		System.out.println("Launching browser");
		
		//Reinitializing the browser - For ListenerImplementation class
		sDriver=driver;
	}
	
	@BeforeMethod(groups= {"SmokeTest","RegressionTest","SanityTest"})
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
	
	@AfterMethod(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void afterMethod()
	{
		HomePage homePage1 = new HomePage(driver);
		homePage1.clickOnMyPreferences();
		homePage1.clickOnSignOut();
		System.out.println("Logout Of Applications");
	}
	
	@AfterClass(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void afterClass()
	{
		driver.quit();
		System.out.println("Close the browser");
	}
	
	@AfterTest(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void afterTest()
	{
		System.out.println("Parallel Execution Done");
	}
	
	@AfterSuite(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void afterSuite()
	{
		System.out.println("Database connection closes");
	}
}
