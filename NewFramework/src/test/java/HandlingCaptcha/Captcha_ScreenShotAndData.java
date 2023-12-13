package HandlingCaptcha;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import JDBC_Concepts.newFetchDataFromDB;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Captcha_ScreenShotAndData {

	public static void main(String[] args)
	{
		  //ChromeOptions options = new ChromeOptions();
		  //options.addArguments("--disable-notifications");
		  
		  EdgeOptions options = new EdgeOptions();
		 // options.setCapability("--disable-notifications", true);
  
				
		  WebDriverManager.edgedriver().setup();
		  WebDriver driver = new EdgeDriver();
		  
		 driver.get("https://www.irctc.co.in/nget/train-search");
		 driver.manage().window().maximize();
		 driver.findElement(By.xpath("(//i[@class='fa fa-align-justify'])[1]")).click();
		 options.setCapability("--disable-notifications", true);
		 driver.findElement(By.xpath("//a[text()=' LOGIN ']")).click();
		 
	}

}
