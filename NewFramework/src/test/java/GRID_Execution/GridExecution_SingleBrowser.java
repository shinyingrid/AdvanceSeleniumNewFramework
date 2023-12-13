package GRID_Execution;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridExecution_SingleBrowser
{
	RemoteWebDriver driver;
	
	@Test
	public void m1Test() throws MalformedURLException
	{
		URL url = new URL("http://192.168.91.1:5555/wd/hub");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		driver=new RemoteWebDriver(url, cap);
		driver.get("https://www.amazon.in");
	}
	
}
