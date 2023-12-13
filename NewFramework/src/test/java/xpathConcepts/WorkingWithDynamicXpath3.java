package xpathConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_Utilities_AS.Web_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithDynamicXpath3 {

	public static void main(String[] args) 
	{
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		Web_Utility wlib = new Web_Utility();
		wlib.maximizingWindow(driver);
		wlib.implicityWait(driver);
		driver.get("https://www.hindustantimes.com/");
		
		driver.switchTo().frame("webpush-onsite");
		driver.findElement(By.xpath("//button[@id='deny']")).click();
		driver.switchTo().defaultContent();
		
		//With parent//indirect child/direct child
		//String topNews = driver.findElement(By.xpath("//div[@class='cartHolder bigCart track timeAgo']//h2[@class='hdg3']/a")).getText();
		
		//with parent//indirect child
		String topNews = driver.findElement(By.xpath("//div[@class='cartHolder bigCart track timeAgo']//a")).getText();
		System.out.println(topNews);
		
		String timeUpdated = driver.findElement(By.xpath("//div[@id='topnews']//div[@id='actionDivInlineStory-101700574393830']//div[@class='dateTime secTime ftldateTime ']")).getText();
		System.out.println(timeUpdated);
		
		String newsline1 = driver.findElement(By.xpath("//div[@class='cartHolder listView track timeAgo']/h3[@class='hdg3']/a")).getText();
		System.out.println(newsline1);
	}

}
