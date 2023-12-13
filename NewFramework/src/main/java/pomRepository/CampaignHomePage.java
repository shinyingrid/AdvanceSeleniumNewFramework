package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignHomePage
{
	//INITIALIZATION
	public CampaignHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//---------------------------------------------------------------------------------------------
	
	//DECLARATION
	
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCampaignPlus;
	
//-------------------------------------------------------------------------------------------
	
	//GETTER METHOD
	
	public WebElement getCreateCampaignPlus()
	{
		return createCampaignPlus;
	}

//--------------------------------------------------------------------------------------------
	
	//BUSINESS LOGIC
		
	public void clickOnCreateCampaignPlus()
	{
		createCampaignPlus.click();
	}
}
