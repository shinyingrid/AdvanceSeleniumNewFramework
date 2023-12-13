package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsHomePage 
//--------------------------------------------------------------------------
{
	//INITIALIZATION
	
	public OrganizationsHomePage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
//-------------------------------------------------------------------------
	
	// DECLARATION
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createNewOrgSign;
	
//--------------------------------------------------------------------------
	
	//GETTER METHOD
	
	public WebElement getCreateNewOrgSign()
	{
		return createNewOrgSign;
	}
	
//----------------------------------------------------------------------------
	
	//BUSINESS LOGIC METHODS
	
	public void clickOnCreateNewOrgSign()
	{
		createNewOrgSign.click();
	}
//-----------------------------------------------------------------------------	
	
	
}
