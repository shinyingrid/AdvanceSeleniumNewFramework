package Optimization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities_AS.Excel_Utility;
import Generic_Utilities_AS.File_Utility;
import Generic_Utilities_AS.Java_Utility;
import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.CreateNewOrganizationPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.OrganizationsHomePage;

public class OptCreateOrganization {

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
				LoginPage login = new LoginPage(driver); 
				HomePage homePage = new HomePage(driver);
				OrganizationsHomePage OrgHomePage = new OrganizationsHomePage(driver);
				CreateNewOrganizationPage newOrgName = new CreateNewOrganizationPage(driver);
				
				//GETTING INPUT FROM PROPERTIES FILE
				String URL=flib.getKeyAndValueData("url");
				String USERNAME=flib.getKeyAndValueData("username");
				String PASSWORD=flib.getKeyAndValueData("password");
				
				//LOGGING INTO THE APPLICATION
				driver.get(URL);
				login.loginToApplication(USERNAME, PASSWORD); //FROM LoginPage POM CLASS 
				
				//CREATING AN ORGANIZATION
				homePage.clickOnOrganizations();//FROM HomePage POM CLASS 
				OrgHomePage.clickOnCreateNewOrgSign(); //FROM OrganizationsHomePage POM CLASS
				
				//GENERATING ORGANIZATION NAME - INPUT FROM EXCEL FILE AND JAVA LIBRARY
				int ranNum = jlib.getRandomNum();
				String OrgName = elib.getDataFormatterData("Organization", 2, 1)+ranNum;
				System.out.println("Organization name is: "+OrgName);
				
				//UPDATING THE GENERATED ORGANIZATION NAME AND SAVING THE NAME
				newOrgName.updateOrgName(OrgName);
				newOrgName.clickOnSaveNewOrg();
				Thread.sleep(1000);
				
				//VALIDATION - IF THE ORGANIZATION IS CREATED OR NOT
				newOrgName.validateNewOrgName(OrgName);//FROM CreateNewOrganizationPage POM CLASS

				//SIGNING OUT
				homePage.clickOnMyPreferences();
				homePage.clickOnSignOut();
				
	}

}
