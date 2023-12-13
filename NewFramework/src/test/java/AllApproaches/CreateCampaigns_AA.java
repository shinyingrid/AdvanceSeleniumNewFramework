package AllApproaches;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

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
public class CreateCampaigns_AA 
{
	public static void main(String[] args) throws Throwable {

		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
//*************************************************************************************************************			
		//Approach 2: call the generic method from File_Utilities
		File_Utility flib = new File_Utility();
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		
		/*Approach 1: 
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonDataFramework.properties.txt");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("username");
		String PASSWORD = prop.getProperty("password");
		*/
//*************************************************************************************************************			
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
//***********************************************************************************************************		
		
		//Random Approach To avoid Duplicates
		//Approach 2: call the generic method from Generic_Utilities
		Java_Utility jlib = new Java_Utility();
		int ranNum=jlib.getRandomNum();
	
		/*Approach 1: 
		 * Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		*/
//*************************************************************************************************************		
		
		//Fetching data from Excel
		
		Excel_Utility elib = new Excel_Utility();
		String campName = elib.getDataFormatterData("Campaign", 4, 2)+ranNum;
		
		
		//Approach 1: 
//		FileInputStream fes = new FileInputStream("D:\\AdvancedSelenium\\NameFile.xlsx");
//		Workbook book = WorkbookFactory.create(fes);
//		Sheet sheet = book.getSheet("Campaign");
//		Row row = sheet.getRow(1);
//		Cell cell = row.getCell(2);
//		String campName = cell.getStringCellValue()+ranNum;
//		
		
		//String campName = "Marketing"+ranNum;
		driver.findElement(By.name("campaignname")).sendKeys(campName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String campaignName = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		
		if(campaignName.contains(campName))
		{
			System.out.println("Campaign Created");
		}
		else
		{
			System.out.println("Campaign not created");
		}
	   driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}
}
