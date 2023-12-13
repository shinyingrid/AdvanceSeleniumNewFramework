package xpathConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithDynamicXpath1 {

	public static void main(String[] args) 
	{

		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		Web_Utility wlib = new Web_Utility();
		wlib.maximizingWindow(driver);
		wlib.implicityWait(driver);
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.partialLinkText("Jewelry")).click();
		WebElement dropDown = driver.findElement(By.id("products-orderby"));
		Select select = new Select(dropDown);
		
		for(int i=0;i<6;i++)
		{
			select.selectByIndex(i);
			String name = driver.findElement(By.xpath("//div[@class='product-grid']/div[1]/div//h2[@class='product-title']/a")).getText();
			System.out.println(name);
			//re-initializing is done here to handle stale element exception error
			dropDown = driver.findElement(By.id("products-orderby"));
			select = new Select(dropDown);
		}

	}

}
