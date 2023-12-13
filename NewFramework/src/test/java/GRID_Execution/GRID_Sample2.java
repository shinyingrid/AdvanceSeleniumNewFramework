package GRID_Execution;

import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class GRID_Sample2 extends BaseClass_GRID
{
	@Test
	public void m2Test()
	{
		driver.get("https://www.amazon.in");
	}
}
