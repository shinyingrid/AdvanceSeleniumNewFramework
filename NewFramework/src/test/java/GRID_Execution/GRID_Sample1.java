package GRID_Execution;

import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GRID_Sample1 extends BaseClass_GRID

{
	@Test
	public void m1Test()
	{
		driver.get("https://www.facebook.com");
	}
}
