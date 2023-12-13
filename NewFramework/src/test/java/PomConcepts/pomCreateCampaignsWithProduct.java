package PomConcepts;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

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

import Generic_Utilities_AS.Excel_Utility;
import Generic_Utilities_AS.File_Utility;
import Generic_Utilities_AS.Java_Utility;
import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.CampaignHomePage;
import pomRepository.CreateCampaignPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.ProductsHomePage;
public class pomCreateCampaignsWithProduct 
{
public static void main(String[] args) throws Throwable {
		
		
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
//--------------------------------------------------------------------------
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(USERNAME, PASSWORD);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		
		HomePage homePage = new HomePage(driver);
		homePage.clickonProducts();
		ProductsHomePage prodHomePage = new ProductsHomePage(driver);
		prodHomePage.clickOnCreateNewProdSign();
		//driver.findElement(By.linkText("Products")).click();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		int ranNum=jlib.getRandomNum();
		String ProdName = elib.getDataFormatterData("Product", 6, 2)+ranNum;
		System.out.println("Product name is: "+ProdName);


			driver.findElement(By.name("productname")).sendKeys(ProdName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						
				String prdName = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
					
				if(prdName.contains(ProdName))
					{
						System.out.println("Product Created");
					}
				else
					{
						System.out.println("Product not created");
					}
				
				homePage.clickOnMoreLink();
				homePage.clickOnCampaigns();
//				driver.findElement(By.linkText("More")).click();
//				driver.findElement(By.linkText("Campaigns")).click();

				CampaignHomePage campHomePage = new CampaignHomePage(driver);
				campHomePage.clickOnCreateCampaignPlus();
				//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
				CreateCampaignPage createCampPage = new CreateCampaignPage(driver);
				createCampPage.clickOnCreateProdWithinCamp();
				//driver.findElement(By.xpath("//img[@alt='Select']")).click(); //adding product plus sign within create campaign page
				
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
				createCampPage.typeOnSearchBarForProd(ProdName);
				//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ProdName);
				createCampPage.clickOnSearchNowIcon();
				//driver.findElement(By.xpath("//input[@name='search']")).click();
				
				 createCampPage.selectProdWithinCamp(driver, ProdName);
				//driver.findElement(By.xpath("//a[text()='"+ProdName+"']")).click();
				
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
				//driver.findElement(By.name("campaignname")).sendKeys(campName);
				createCamp.clickOnSavingCampWithProd();
				
				
				System.out.println("Campaign name is: "+campName);
				System.out.println("Campaign created");
				
				homePage.clickOnMyPreferences();
				homePage.clickOnSignOut();
//				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//				driver.findElement(By.linkText("Sign Out")).click();
	}
}
