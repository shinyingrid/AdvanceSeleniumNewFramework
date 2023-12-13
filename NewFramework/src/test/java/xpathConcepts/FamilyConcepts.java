package xpathConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.github.dockerjava.api.model.Driver;

import Generic_Utilities_AS.Excel_Utility;
import Generic_Utilities_AS.File_Utility;
import Generic_Utilities_AS.Java_Utility;
import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.HomePage;
import pomRepository.LoginPage;

public class FamilyConcepts {

	public static void main(String[] args) throws Throwable 
	{

		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility(); 
		Excel_Utility elib = new Excel_Utility();
		Web_Utility wdlib = new Web_Utility();
		
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(USERNAME, PASSWORD);
		
		HomePage homePage = new HomePage(driver);
		homePage.clickonProducts();
		
		//SELF
		
		

	}

}
