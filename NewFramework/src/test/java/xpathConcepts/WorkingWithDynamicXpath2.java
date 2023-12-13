package xpathConcepts;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithDynamicXpath2 {

	public static void main(String[] args) throws Throwable 
	{

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		Web_Utility wlib = new Web_Utility();
		wlib.maximizingWindow(driver);
		wlib.implicityWait(driver);
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.partialLinkText("Digital downloads")).click();
		List<WebElement> allAddToCart = driver.findElements(By.xpath("//input[@value='Add to cart']"));
		
		for(WebElement allToCart : allAddToCart)
		{
			allToCart.click();
			Thread.sleep(3000);
		}
		
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
		
		List<WebElement> allRemoveCB = driver.findElements(By.xpath("//table[@class='cart']//input[@type='checkbox']"));
		
		for(WebElement removeCB : allRemoveCB)
		{
			removeCB.click();
		}
		driver.findElement(By.name("updatecart")).click();
		
		String summary = driver.findElement(By.xpath("//div[@class='page shopping-cart-page']//div[@class='order-summary-content']")).getText();

		System.out.println(summary);
	}

}
