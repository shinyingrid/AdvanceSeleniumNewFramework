package DataProviderConcept;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jnr.ffi.Struct.int16_t;

public class DataProviderOrganization 
{

	@Test(dataProvider = "getData")
	public void m1(String OrgName,String PhoneNum,String emailID) throws Throwable
	{
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		driver.findElement(By.name("phone")).sendKeys(PhoneNum);
		driver.findElement(By.id("email1")).sendKeys(emailID);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		System.out.println(OrgName);
		System.out.println(PhoneNum);
		System.out.println(emailID);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click(); 
		Thread.sleep(1000);
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		Random ran = new Random();
		int ranNum=ran.nextInt(1000);
		Object[][] obj = new Object[3][3];
		obj[0][0]="AAA"+ranNum;
		obj[0][1]="57687686993";
		obj[0][2]="abcd@gmail.com";
		
		obj[1][0]="BBB"+ranNum;
		obj[1][1]="8868879877070";
		obj[1][2]="shiny@gmail.com";
		
		obj[2][0]="CCC"+ranNum;
		obj[2][1]="343242345554";
		obj[2][2]="ingrid@gmail.com";
		return obj;
	}
}
