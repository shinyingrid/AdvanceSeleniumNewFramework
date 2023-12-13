package Listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities_AS.BaseClass;
import Generic_Utilities_AS.Excel_Utility;
import Generic_Utilities_AS.File_Utility;
import Generic_Utilities_AS.Java_Utility;
import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.CreateNewOrganizationPage;
import pomRepository.HomePage;
import pomRepository.LoginPage;
import pomRepository.OrganizationsHomePage;

@Listeners(Generic_Utilities_AS.ExtentImplementation.class)
/*Since we have declared @Listeners here, it is not required to add in the suite.xml file
 * In Extent.CreateOrg.xml file, 
 * <listeners>
		<listener class-name="Generic_Utilities_AS.ExtentImplementation"></listener>
	</listeners>
 *  can be added if @Listener is not written in the Test Script
 * 
*/
public class Extent_CreateOrganization extends BaseClass
{
	//for iRetryAnalyser execution
	//@Test(retryAnalyzer = Generic_Utilities_AS.RetryImplementation.class)
	@Test
	public void TestCreateOrg() throws Throwable
	{
			
				HomePage homePage = new HomePage(driver);
				OrganizationsHomePage OrgHomePage = new OrganizationsHomePage(driver);
				CreateNewOrganizationPage newOrgName = new CreateNewOrganizationPage(driver);
				
				
				homePage.clickOnOrganizations();
				OrgHomePage.clickOnCreateNewOrgSign(); 
											
				Assert.assertEquals(false, true);
								
				int ranNum = jlib.getRandomNum();
				String OrgName = elib.getDataFormatterData("Organization", 2, 1)+ranNum;
				System.out.println("Organization name is: "+OrgName);
				
				
				newOrgName.updateOrgName(OrgName);
				newOrgName.clickOnSaveNewOrg();
				Thread.sleep(1000);
				
				
				newOrgName.validateNewOrgName(OrgName);
				
			
				String foundData = newOrgName.validateOrg();
				Assert.assertEquals(foundData, OrgName);


				
	}

}
