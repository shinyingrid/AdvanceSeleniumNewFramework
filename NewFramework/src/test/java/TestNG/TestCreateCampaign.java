package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utilities_AS.BaseClass;
import Generic_Utilities_AS.Excel_Utility;
import Generic_Utilities_AS.File_Utility;
import Generic_Utilities_AS.Java_Utility;
import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.CampaignHomePage;
import pomRepository.CreateCampaignPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.OrganizationsHomePage;
import pomRepository.ValidateCreateCampaignPage;

@Listeners(Generic_Utilities_AS.ListenerImplementation.class)
public class TestCreateCampaign extends BaseClass{

	@Test
	public void TestCreateCamp() throws Throwable
	{
		
		//DECLARING AS PUBLIC IN BASE CLASS
		//***************************************
		//CREATING OBJECT FOR THE GENERIC UTILITY CLASSES
//		Excel_Utility elib = new Excel_Utility();
//		File_Utility flib = new File_Utility();
//		Java_Utility jlib = new Java_Utility(); 
//		Web_Utility wdlib = new Web_Utility();
		//WebDriver driver; // generalizing the WebDriver
		
		//CHOOSING THE BROWSER FROM PROPERTIES FILE
//		String BROWSER = flib.getKeyAndValueData("browser");
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else if (BROWSER.equalsIgnoreCase("edge"))
//		{
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//		}
//		else
//		{
//		WebDriverManager.firefoxdriver().setup();
//		driver=new FirefoxDriver();
//		}
		
//**********************************************************************

		
		//MANAGING THE BROWSER
//		wdlib.maximizingWindow(driver);
//		wdlib.implicityWait(driver);

		
		//OBJECT CREATION FOR POM CLASSES
		//LoginPage loginPage = new LoginPage(driver); 
		HomePage homePage = new HomePage(driver);
		CreateCampaignPage createCamp = new CreateCampaignPage(driver);
		ValidateCreateCampaignPage validate = new ValidateCreateCampaignPage(driver);
		
		//GETTING INPUT FROM PROPERTIES FILE
//		String URL=flib.getKeyAndValueData("url");
//		String USERNAME=flib.getKeyAndValueData("username");
//		String PASSWORD=flib.getKeyAndValueData("password");
//		
		//LOGGING INTO THE APPLICATION
//		driver.get(URL);
//		loginPage.loginToApplication(USERNAME, PASSWORD); //FROM LoginPage POM CLASS 
		
		//CREATING A CAMPAIGN
		homePage.clickOnMoreLink(); //FROM HomePage POM CLASS
		homePage.clickOnCampaigns();
		createCamp.clickOnCreateCampIcon();
		
		
		//Using Hard Assert to check if screenshot is being taken - Listeners Concept
		Assert.assertEquals(false, true);
		
		//GENERATING CAMPAIGN NAME - INPUT FROM EXCEL FILE AND JAVA LIBRARY
		int ranNum=jlib.getRandomNum();
		String campName = elib.getDataFormatterData("Campaign", 4, 2)+ranNum;
		System.out.println("Campaign name is: "+campName);
		
		//UPDATING THE GENERATED CAMPAIGN NAME AND SAVING THE NAME
		createCamp.updateCampaignName(campName);
		createCamp.clickOnSaveButton();
		
		
		//VALIDATION - IF THE CAMPAIGN IS CREATED OR NOT
		validate.validateGeneratedCampName();
		
		//VALIDATION - HARD ASSERT
		//String foundData = validate.campValidate();
		//Assert.assertEquals(foundData, campName);
		
		//VALIDATION - SOFT ASSERT
		String foundData = validate.campValidate();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(foundData, campName);
		soft.assertAll();
		
		
		//SIGNING OUT
//		homePage.clickOnMyPreferences();
//		homePage.clickOnSignOut();

	}
}

