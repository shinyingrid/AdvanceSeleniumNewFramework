package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities_AS.Excel_Utility;
import Generic_Utilities_AS.File_Utility;
import Generic_Utilities_AS.Java_Utility;
import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class pomclasspractice

{
	public static void main(String[] args) throws Throwable {
		
	
	WebDriverManager.edgedriver().setup();
	WebDriver driver=new EdgeDriver();
	Excel_Utility elib = new Excel_Utility();
	File_Utility flib = new File_Utility();
	Java_Utility jlib = new Java_Utility(); 
	Web_Utility wdlib = new Web_Utility();
	
	wdlib.maximizingWindow(driver);
	wdlib.implicityWait(driver);
	
	String URL=flib.getKeyAndValueData("url");
	String USERNAME=flib.getKeyAndValueData("username");
	String PASSWORD=flib.getKeyAndValueData("password");
	

	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(3000);
	//driver.findElement(By.xpath("//table[@class='hdrTabBg']//a")).click();
	//driver.findElement(By.linkText("Calendar")).click();
	driver.findElement(By.xpath("")).click();	
}	
}
	