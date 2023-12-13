package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage
{
	//INITIALIZATION
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//-----------------------------------------------------------------------------------
	
	//DECLARATION
	
	@FindBy(name = "accountname")
	private WebElement orgNamElement;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveNewOrgName;
	
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement NewOrgName;
//-------------------------------------------------------------------------------------
	
	// GETTER METHODS
	
	public WebElement getOrgNamElement()
	{
		return orgNamElement;
	}
	
	public WebElement getSaveNewOrgNAme()
	{
		return saveNewOrgName;
	}
	
	public WebElement getNewOrgName()
	{
		return NewOrgName;
	}
//-----------------------------------------------------------------------------------
	
	//BUSINESS LOGIC METHODS
	
	public void updateOrgName(String newOrgName)
	{
		orgNamElement.sendKeys(newOrgName);
	}
	
	public void clickOnSaveNewOrg()
	{
		saveNewOrgName.click();
	}
	
	//Validation method
	public void validateNewOrgName(String generatedOrgName)
	{
		String OrgNameText = NewOrgName.getText();
		if(OrgNameText.contains(generatedOrgName))
		{
			System.out.println("Organization created successfully");
		}
		else
		{
			System.out.println("Organization is not created");
		}
		
	}
	
	//Validation for Assertion
	public String validateOrg()
	{
		return NewOrgName.getText();
	}
}
