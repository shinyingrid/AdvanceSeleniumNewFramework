package Generic_Utilities_AS;

import java.util.Random;

public class Java_Utility 
{
	/*
	 * This method is used to avoid duplicates
	 * @author : Shiny
	 */
	public int getRandomNum()
	{
		Random random = new Random();
		int ranNum = random.nextInt(1000);
		return ranNum;
	}
}
