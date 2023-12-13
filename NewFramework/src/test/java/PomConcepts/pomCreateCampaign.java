package PomConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities_AS.Excel_Utility;
import Generic_Utilities_AS.File_Utility;
import Generic_Utilities_AS.Java_Utility;
import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.CreateCampaignPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.ValidateCreateCampaignPage;

public class pomCreateCampaign {

	public static void main(String[] args) throws Throwable 
	{
		

		Java_Utility jlib = new Java_Utility();
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		Web_Utility wlib = new Web_Utility();
//-------------------------------------------------------------------------------		
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
		wlib.maximizingWindow(driver);
		wlib.implicityWait(driver);
//-------------------------------------------------------------------------------		
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		
		
		driver.get(URL);
		
		//FROM LOGINPAGE CLASS
		LoginPage loginPage = new LoginPage(driver); 
		
//		USING BUSINESS LOGIC METHODS FROM POM CLASS
		loginPage.loginToApplication(USERNAME, PASSWORD);
		
//		USING CONVENTIONAL METHOD	
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
//		WITH GETTER METHODS FROM POM CLASS
//		login.getUserTextField().sendKeys(USERNAME);
//		login.getPasswordTextField().sendKeys(PASSWORD);;
//		login.getLoginButton().click();
		
		
		
		//FROM HOMEPAGE CLASS
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMoreLink();
		homePage.clickOnCampaigns();
		CreateCampaignPage createCamp = new CreateCampaignPage(driver);
		createCamp.clickOnCreateCampIcon();
//		
//		driver.findElement(By.linkText("More")).click();
//		driver.findElement(By.linkText("Campaigns")).click();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
//-------------------------------------------------------------------------------
		
		int ranNum=jlib.getRandomNum();
		//CreateCampaignPage campName = elib.getDataFormatterData("Campaign", 4, 2)+ranNum;
		String campName = elib.getDataFormatterData("Campaign", 4, 2)+ranNum;
		System.out.println("Campaign name is: "+campName);
		
		createCamp.updateCampaignName(campName);
		//driver.findElement(By.name("campaignname")).sendKeys(campName);
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		createCamp.clickOnSaveButton();

//-------------------------------------------------------------------------------------
		//VALIDATION
		
		ValidateCreateCampaignPage validate = new ValidateCreateCampaignPage(driver);
		validate.validateGeneratedCampName();
//		
//		String campaignName = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
//		if(campaignName.contains(campName))
//		{
//			System.out.println("Campaign Created");
//		}
//		else
//		{
//			System.out.println("Campaign not created");
//		}
//	    
		
//----------------------------------------------------------------------------------------------------	
		
		homePage.clickOnMyPreferences();
		homePage.clickOnSignOut();
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.linkText("Sign Out")).click();

	}

}
