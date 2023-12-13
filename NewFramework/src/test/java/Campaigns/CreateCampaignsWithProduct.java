package Campaigns;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities_AS.Excel_Utility;
import Generic_Utilities_AS.File_Utility;
import Generic_Utilities_AS.Java_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
public class CreateCampaignsWithProduct 
{
public static void main(String[] args) throws Throwable {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		

		Java_Utility jlib = new Java_Utility();
		File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
	
		
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		int ranNum=jlib.getRandomNum();
		String ProdName = elib.getDataFormatterData("Product", 6, 2)+ranNum;
		System.out.println("Product name is: "+ProdName);


			driver.findElement(By.name("productname")).sendKeys(ProdName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						
				String prdName = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
					
				if(prdName.contains(ProdName))
					{
						System.out.println("Product Created");
					}
				else
					{
						System.out.println("Product not created");
					}
					
				driver.findElement(By.linkText("More")).click();
				driver.findElement(By.linkText("Campaigns")).click();
				driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
				driver.findElement(By.xpath("//img[@alt='Select']")).click();
				
				Set<String> allWin = driver.getWindowHandles();
				Iterator<String> win = allWin.iterator();
				
				while(win.hasNext())
				{
					String winText = win.next();
				driver.switchTo().window(winText);
				String title = driver.getTitle();
				
					if(title.contains("Products&action"))
					{
						break;
					}
				
				}
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ProdName);
				driver.findElement(By.xpath("//input[@name='search']")).click();
				
				
				driver.findElement(By.xpath("//a[text()='"+ProdName+"']")).click();
				
				Set<String> allWin1 = driver.getWindowHandles();
				Iterator<String> win1 = allWin1.iterator();
				
				while(win1.hasNext())
				{
					String winText1 = win1.next();
				driver.switchTo().window(winText1);
				String title1 = driver.getTitle();
				
					if(title1.contains("Campaigns&action"))
					{
						break;
					}
				
				}
				
				
				String campName = elib.getDataFormatterData("Campaign", 4, 2)+ranNum;
				driver.findElement(By.name("campaignname")).sendKeys(campName);
				System.out.println("Campaign name is: "+campName);
				System.out.println("Campaign created");
				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
				driver.findElement(By.linkText("Sign Out")).click();
	}
}
