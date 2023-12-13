package Optimization;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities_AS.Excel_Utility;
import Generic_Utilities_AS.File_Utility;
import Generic_Utilities_AS.Java_Utility;
import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.CreatingNewProductPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.ProductsHomePage;

public class OptCreateProductAndDeleteProduct {

	public static void main(String[] args) throws Throwable
	{
		//CREATING OBJECT FOR THE GENERIC UTILITY CLASSES
		Excel_Utility elib = new Excel_Utility();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility(); 
		Web_Utility wlib = new Web_Utility();
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
		wlib.maximizingWindow(driver);
		wlib.implicityWait(driver);

		
		//OBJECT CREATION FOR POM CLASSES
		LoginPage loginPage = new LoginPage(driver); 
		HomePage homePage = new HomePage(driver);
		CreatingNewProductPage creatingNewProd = new CreatingNewProductPage(driver);
		ProductsHomePage prodHomePage = new ProductsHomePage(driver);
		
		//GETTING INPUT FROM PROPERTIES FILE
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		
		//LOGGING INTO THE APPLICATION
		driver.get(URL);
		loginPage.loginToApplication(USERNAME, PASSWORD); //FROM LoginPage POM CLASS 
		
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
		
		//DELETING THE PRODUCT
		homePage.clickonProducts();
		prodHomePage.selectProduct(driver, ProdName);
		prodHomePage.clickOnDeleteProdButton();
		wlib.alertAccept(driver);
		
		//VALIDATION - IF THE PRODUCT IS DELETED OR NOT
		 List<WebElement> prdList=prodHomePage.getListOfProducts();
		    
		    boolean flag = false;
		    for(WebElement prod : prdList)
		    {
		    	String prodListData = prod.getText();
		    	  	
		    	if(prodListData.contains(ProdName))
		    	{
		    		flag = true;
		    		break;
		    	}
		    	System.out.println(prodListData);
		    }	
		    if(flag)
		    {
		    	System.out.println("Product is deleted");
		    }
		    else
		    {
		    	System.out.println("Product is not deleted");
			}
		    
		  //SIGNING OUT
		  homePage.clickOnMyPreferences();
		  homePage.clickOnSignOut();
		  wlib.alertAccept(driver);
	}

}
