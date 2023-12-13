package Optimization;

import java.util.Iterator;
import java.util.Set;

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
import pomRepository.CampaignHomePage;
import pomRepository.CreateCampaignPage;
import pomRepository.CreatingNewProductPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.ProductsHomePage;

public class OptCreateCampaignWithProduct {

	public static void main(String[] args) throws Throwable
	{
		
		//CREATING OBJECT FOR THE GENERIC UTILITY CLASSES
		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility(); 
		Web_Utility wdlib = new Web_Utility();
		WebDriver driver; // generalizing the WebDriver
		
		//CHOOSING THE BROWSER FROM PROPERTIES FILE
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
		
		//MANAGING THE BROWSER
		wdlib.maximizingWindow(driver);
		wdlib.implicityWait(driver);

		//OBJECT CREATION FOR POM CLASSES
		LoginPage loginPage = new LoginPage(driver); 
		HomePage homePage = new HomePage(driver);
		CreatingNewProductPage creatingNewProd = new CreatingNewProductPage(driver);
		ProductsHomePage prodHomePage = new ProductsHomePage(driver);
		CampaignHomePage campHomePage = new CampaignHomePage(driver);
		CreateCampaignPage createCampPage = new CreateCampaignPage(driver);
		
		//GETTING INPUT FROM PROPERTIES FILE
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		
		//LOGGING INTO THE APPLICATION
		driver.get(URL);
		loginPage.loginToApplication(USERNAME, PASSWORD); //FROM LoginPage POM CLASS 
		
		//CREATING PRODUCT
		homePage.clickonProducts();
		prodHomePage.clickOnCreateNewProdSign();
		
		//GENERATING PRODUCT FROM GENERIC UTILITIES
		int ranNum=jlib.getRandomNum();
		String ProdName = elib.getDataFormatterData("Product", 6, 2)+ranNum;
		System.out.println("Product name is: "+ProdName);
		
		//UPDATING THE GENERATED PRODUCT NAME
		creatingNewProd.updateNewProdName(ProdName);
		creatingNewProd.clickOnSaveProdName();
					
		//VALIDATION - IF THE PRODUCT IS CREATED OR NOT
		creatingNewProd.validateNewProdCreated(ProdName);	
			
		//CREATING CAMPAIGN WITH PRODUCT
		 homePage.clickOnMoreLink();
		 homePage.clickOnCampaigns();
		 campHomePage.clickOnCreateCampaignPlus();
		 createCampPage.clickOnCreateProdWithinCamp();
		 
		 //HANDLING NEW WINDOW 
		 Set<String> allWin = driver.getWindowHandles();
			Iterator<String> win = allWin.iterator();
			
			while(win.hasNext())
			{
				String winText = win.next();
			driver.switchTo().window(winText);
			String title = driver.getTitle();
			
				if(title.contains("Products&action"))
				{
					break;
				}
			
			}
		 Thread.sleep(2000);
		 
		 //SELECTING THE PRODUCT WITHIN CAMPAIGN
		 createCampPage.typeOnSearchBarForProd(ProdName);
		 createCampPage.clickOnSearchNowIcon();
		 createCampPage.selectProdWithinCamp(driver, ProdName);
		 
		 //HANDLING 
		 Set<String> allWin1 = driver.getWindowHandles();
			Iterator<String> win1 = allWin1.iterator();
			
			while(win1.hasNext())
			{
				String winText1 = win1.next();
			driver.switchTo().window(winText1);
			String title1 = driver.getTitle();
			
				if(title1.contains("Campaigns&action"))
				{
					break;
				}
			
			}
			
			String campName = elib.getDataFormatterData("Campaign", 4, 2)+ranNum;
			CreateCampaignPage createCamp = new CreateCampaignPage(driver);
			createCamp.updateCampaignName(campName);
			createCamp.clickOnSavingCampWithProd();
			
			System.out.println("Campaign name is: "+campName);
			System.out.println("Campaign created");
			
		 	//SIGNING OUT
			homePage.clickOnMyPreferences();
			homePage.clickOnSignOut();

	}

}
