package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utilities_AS.BaseClass;
import Generic_Utilities_AS.Excel_Utility;
import Generic_Utilities_AS.File_Utility;
import Generic_Utilities_AS.Java_Utility;
import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.CreatingNewProductPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.ProductsHomePage;


public class TestCreateProduct extends BaseClass {

	@Test
	public void TestCreateProd() throws Throwable 
	{
				//DECLARING AS PUBLIC IN BASE CLASS
				//***************************************
				//CREATING OBJECT FOR THE GENERIC UTILITY CLASSES
//				Excel_Utility elib = new Excel_Utility();
//				File_Utility flib = new File_Utility();
//				Java_Utility jlib = new Java_Utility(); 
//				Web_Utility wdlib = new Web_Utility();
//				WebDriver driver; // generalizing the WebDriver
				
				//CHOOSING THE BROWSER FROM PROPERTIES FILE
//				String BROWSER = flib.getKeyAndValueData("browser");
//				if(BROWSER.equalsIgnoreCase("chrome"))
//				{
//					WebDriverManager.chromedriver().setup();
//					driver=new ChromeDriver();
//				}
//				else if (BROWSER.equalsIgnoreCase("edge"))
//				{
//					WebDriverManager.edgedriver().setup();
//					driver=new EdgeDriver();
//				}
//				else
//				{
//				WebDriverManager.firefoxdriver().setup();
//				driver=new FirefoxDriver();
//				}
				
				//MANAGING THE BROWSER
//				wdlib.maximizingWindow(driver);
//				wdlib.implicityWait(driver);

				
				//OBJECT CREATION FOR POM CLASSES
				//LoginPage loginPage = new LoginPage(driver); 
				HomePage homePage = new HomePage(driver);
				CreatingNewProductPage creatingNewProd = new CreatingNewProductPage(driver);
				ProductsHomePage prodHomePage = new ProductsHomePage(driver);
				
				//GETTING INPUT FROM PROPERTIES FILE
//				String URL=flib.getKeyAndValueData("url");
//				String USERNAME=flib.getKeyAndValueData("username");
//				String PASSWORD=flib.getKeyAndValueData("password");
				
				//LOGGING INTO THE APPLICATION
//				driver.get(URL);
//				loginPage.loginToApplication(USERNAME, PASSWORD); //FROM LoginPage POM CLASS 
				
				//CREATING A PRODUCT
				homePage.clickonProducts();
				prodHomePage.clickOnCreateNewProdSign();
				
				//GENERATING PRODUCT NAME - INPUT FROM EXCEL FILE AND JAVA LIBRARY
				int ranNum = jlib.getRandomNum();
				String ProdName = elib.getDataFormatterData("Product", 6, 2)+ranNum;
				
				//UPDATING THE GENERATED PRODUCT NAME AND SAVING THE NAME
				creatingNewProd.updateNewProdName(ProdName);
				System.out.println("Product name is :"+ ProdName);
				creatingNewProd.clickOnSaveProdName();
				
				//VALIDATION - IF THE PRODUCT IS CREATED OR NOT
				creatingNewProd.validateNewProdCreated(ProdName);
				
//				//VALIDATION - HARD ASSERT
//				String foundData = creatingNewProd.validateProd();
//				Assert.assertEquals(foundData, ProdName);
				
				//VALIDATION - SOFT ASSERT
				String foundData = creatingNewProd.validateProd();
				SoftAssert soft = new SoftAssert();
				soft.assertEquals(foundData, ProdName);
				soft.assertAll();
				
				//SIGNING OUT
//				homePage.clickOnMyPreferences();
//				homePage.clickOnSignOut();

	}

}
