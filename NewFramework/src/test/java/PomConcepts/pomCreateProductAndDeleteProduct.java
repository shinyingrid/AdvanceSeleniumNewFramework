package PomConcepts;

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

public class pomCreateProductAndDeleteProduct {

	public static void main(String[] args) throws Throwable 
	
	{
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility(); 
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
		//driver.findElement(By.linkText("Products")).click();
		
		//FROM ProductsHomePage
		ProductsHomePage prodHomePage = new ProductsHomePage(driver);
		prodHomePage.clickOnCreateNewProdSign();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
//--------------------------------------------------------------------------
				
		int ranNum = jlib.getRandomNum();		
		String ProdName = elib.getDataFormatterData("Product", 6, 2)+ranNum;
//-------------------------------------------------------------------------------------------
		
		//FROM ProductsHomePage
		CreatingNewProductPage createNewProd = new CreatingNewProductPage(driver);
		createNewProd.updateNewProdName(ProdName);
		//driver.findElement(By.name("productname")).sendKeys(ProdName);
		System.out.println("Product name is: "+ProdName);
		createNewProd.clickOnSaveProdName();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//--------------------------------------------------------------------------------------------------
		
		//VALIDATION
		createNewProd.validateNewProdCreated(ProdName);
		
//		String prdName = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
//		
//		if(prdName.contains(ProdName))
//			{
//				System.out.println("Product Created");
//			}
//		else
//			{
//				System.out.println("Product not created");
//			}
//-----------------------------------------------------------------------------------------------------------	
		homePage.clickonProducts();
		//prodHomePage.clickOnCheckBoxOfNewProdCreated();
		prodHomePage.selectProduct(driver, ProdName);
		//driver.findElement(By.xpath("//a[text()='"+ProdName+"']/../preceding-sibling::td[2]/input")).click();
		prodHomePage.clickOnDeleteProdButton();
		wlib.alertAccept(driver);

//-----------------------------------------------------------------------------------------------------------------		
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
	    
//---------------------------------------------------------------------------------------------------------------	    
	    homePage.clickOnMyPreferences();
		homePage.clickOnSignOut();
		wlib.alertAccept(driver);

	}

}
