package xpathConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithAbsoluteXpath {

	public static void main(String[] args)
	{
	
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		Web_Utility wlib = new Web_Utility();
		wlib.maximizingWindow(driver);
		wlib.implicityWait(driver);
		
		driver.get("file:///D:/AdvancedSelenium/Locators%20demo.html");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[1]")).sendKeys("Shiny");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[2]")).sendKeys("Ingrid");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[4]")).click();
	    driver.findElement(By.xpath("/html/body/div[2]/form/input[6]")).sendKeys("admin");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[7]")).sendKeys("admin");
		driver.findElement(By.xpath("/html/body/div[2]/form/button[1]")).click();
		String confmsg = driver.findElement(By.xpath("/html/body/div[2]/form/div[6]")).getText();
		System.out.println(confmsg);
	}
}
