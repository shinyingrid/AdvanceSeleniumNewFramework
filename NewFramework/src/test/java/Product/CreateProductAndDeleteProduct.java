package Product;
import java.io.FileInputStream;
import java.util.List;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities_AS.Excel_Utility;
import Generic_Utilities_AS.File_Utility;
import Generic_Utilities_AS.Java_Utility;
import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
public class CreateProductAndDeleteProduct 
{
	public static void main(String[] args) throws Throwable {
		
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		File_Utility flib = new File_Utility();
		Java_Utility jlib = new Java_Utility(); 
		Excel_Utility elib = new Excel_Utility();
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
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

				
		int ranNum = jlib.getRandomNum();		
		String ProdName = elib.getDataFormatterData("Product", 6, 2)+ranNum;
	
		driver.findElement(By.name("productname")).sendKeys(ProdName);
		System.out.println("Product name is: "+ProdName);
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
		
			
			driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
			
			driver.findElement(By.xpath("//a[text()='"+ProdName+"']/../preceding-sibling::td/input")).click();
			//                           //a[text()='Phone115']/../preceding-sibling::td[2]
			driver.findElement(By.xpath("//input[@value='Delete']")).click();
			
			
			wdlib.implicityWait(driver);
			wdlib.alertAccept(driver);
			

			List<WebElement> prdList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
			
			boolean flag=false;
			
			for (WebElement prd : prdList)
			{
				String actData = prd.getText();//phone456
				if(actData.contains(ProdName))//phone360
				{
					flag=true;
					break;
				}
			}
			if(flag)
				{
					System.out.println("product deleted");
				}
			else
				{
					System.out.println("Product not deleted");
				}
				
		
	
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			wdlib.alertAccept(driver);
			}
			
			}
