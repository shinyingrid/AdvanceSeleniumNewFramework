package TestNG;

import org.testng.annotations.Test;

public class TesNT1 
{
	
	@Test(groups = {"SanityTest","SmokeTest"})
	public void createProduct()
	{
			System.out.println("Product Created");
	}
	
	@Test(groups= {"RegressionTest"})
	public void modifyProduct()
	{
		System.out.println("Product modified");
	}
	@Test
	public void deleteProduct()
	{
		System.out.println("Product deleted");
	}
	
	@Test
	public void testingForRegression1()
	{
		System.out.println("RegionalRegressionTesting 1");
	}
	@Test
	public void testingForRegression2()
	{
		System.out.println("RegionalRegressionTesting 2");
	}
	@Test
	public void testingForRegression3()
	{
		System.out.println("RegionalRegressionTesting 3");
	}

}
