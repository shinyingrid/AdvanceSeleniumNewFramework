package sikuliConcepts;

import org.sikuli.script.Screen;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
public class sikuliExecution {

	public static void main(String[] args) throws Throwable
	{
		Screen scr = new Screen();
		
		
		Pattern minimize = new Pattern("D:\\AdvancedSelenium\\SnippingTool\\minimize.png");
		scr.click(minimize);
		
		Pattern searchBar = new Pattern("D:\\AdvancedSelenium\\SnippingTool\\searchBar.png");
		scr.click(searchBar);
		scr.type("paint");
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
	}

}
