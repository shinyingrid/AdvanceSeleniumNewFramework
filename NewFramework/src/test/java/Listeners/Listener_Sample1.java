package Listeners;

import org.python.antlr.ast.Slice.step_descriptor;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities_AS.BaseClass;

@Listeners(Generic_Utilities_AS.ListenerImplementation.class)
public class Listener_Sample1 extends BaseClass

{
	@Test
	public void m1()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		Assert.assertEquals(false, true);
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
	}
	@Test
	public void m2()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		Assert.assertEquals(false, true);
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
	}
	@Test
	public void m3()
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		Assert.assertEquals(true, true);
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
	}
	
	
}
