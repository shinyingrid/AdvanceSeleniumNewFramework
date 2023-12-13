package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.python.antlr.PythonParser.return_stmt_return;

public class ValidateCreateCampaignPage 

{
	//INITIALIZATION
	public ValidateCreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//------------------------------------------------------------------------------------------
	
	//DECLARATION
	
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement generatedCampName;
	
//------------------------------------------------------------------------------------------
	
	//GETTER METHOD
	
	public WebElement getGeneratedCampName()
	{
		return generatedCampName;
	}
	
//-------------------------------------------------------------------------------------------
	
	//BUSINESS LOGIC METHOD
	
	public void validateGeneratedCampName()
	{
		String genCampName = generatedCampName.getText();
		if(genCampName.contains(genCampName))
		{
			System.out.println("Campaign Created");
		}
		else
		{
			System.out.println("Campaign not created");
		}
	}
	
	//Validation through Assertion - Business Logic
	
	public String campValidate()
	{
		return generatedCampName.getText();
	}
	
}
