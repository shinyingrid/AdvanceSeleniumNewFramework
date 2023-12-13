package PomConcepts;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.NewSessionPayload;

import Generic_Utilities_AS.Excel_Utility;
import Generic_Utilities_AS.File_Utility;
import Generic_Utilities_AS.Java_Utility;
import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.CreateNewOrganizationPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.OrganizationsHomePage;

public class pomCreateOrganization {

	public static void main(String[] args)throws Throwable
	{
//---------------------------------------------------------------------------
		
		
		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility(); 
		Web_Utility wdlib = new Web_Utility();
		
		WebDriver driver; // generalizing the WebDriver
		
		String BROWSER = flib.getKeyAndValueData("browser");
		
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
//-------------------------------------------------------------------------------		
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		

		driver.get(URL);
				//FROM LoginPage CLASS
				LoginPage login = new LoginPage(driver); 
				
//				USING BUSINESS LOGIC METHODS FROM POM CLASS
				login.loginToApplication(USERNAME, PASSWORD);
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
			
		
				//FROM HomePage CLASS
				HomePage homePage = new HomePage(driver);
				homePage.clickOnOrganizations();
		//driver.findElement(By.linkText("Organizations")).click();
				
				//FROM OrganizationsHomePage CLASS
				OrganizationsHomePage OrgHomePage = new OrganizationsHomePage(driver);
				OrgHomePage.clickOnCreateNewOrgSign();
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			
//-------------------------------------------------------------------------------	
		int ranNum = jlib.getRandomNum();
		String OrgName = elib.getDataFormatterData("Organization", 2, 1)+ranNum;
		System.out.println("Organization name is: "+OrgName);

//--------------------------------------------------------------------------------------		
		//FROM CreateNewOrganizationPage
		CreateNewOrganizationPage newOrgName = new CreateNewOrganizationPage(driver);
		newOrgName.updateOrgName(OrgName);
		//driver.findElement(By.name("accountname")).sendKeys(OrgName);
		newOrgName.clickOnSaveNewOrg();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
//---------------------------------------------------------------------------------------
		
		//VALIDATION
		//FROM CreateNewOrganizationPage 
		newOrgName.validateNewOrgName(OrgName);
		
//		String Name = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
//		if(Name.contains(OrgName))
//		{
//			System.out.println("Organization Created");
//		}
//		else
//		{
//			System.out.println("Organization not created");
//		}
//-------------------------------------------------------------------------------------------
		
		homePage.clickOnMyPreferences();
		homePage.clickOnSignOut();
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click(); 
		
	}

}
