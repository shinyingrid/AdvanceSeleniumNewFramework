package pomRepository;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.python.antlr.PythonParser.return_stmt_return;

public class CreateCampaignPage

{
	//INITIALIZATION
	
	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//------------------------------------------------------------------------------
	
	// DECLARATION
	
	@FindBy(name="campaignname")
	private WebElement campaignNameElement;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButtonElement;
	
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement creatingCampaignIcon;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement creatingProdWithinCamp;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchBarForProd;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchNowIcon;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[2]")
	private WebElement savingCampWithProdIcon;
	
	@FindBy(xpath ="//a[text()='\"+ProdName+\"']")
	private WebElement prodNameToBeSelected;
//---------------------------------------------------------------------------------
	
	//GETTER METHODS
	
	 public WebElement getCampaignNameElement()
	 {
		 return campaignNameElement;
	 }
	
	 public WebElement getSaveButtonElement()
	 {
		 return saveButtonElement;
	 }
	
	 public WebElement getCreateCampaignIcon()
	 {
		 return creatingCampaignIcon;
	 }
	 
	 public WebElement getCreateProdWithinCamp()
	 {
		 return creatingProdWithinCamp;
	 }
	 
	 public WebElement getSearchBarForProd()
	 {
		 return searchBarForProd;
	 }
	 
	 public WebElement getSelectingTheProdName()
	 {
		 return searchNowIcon;
	 }
	 
	 public WebElement getSavingCampWithProdIcon()
	 {
		 return savingCampWithProdIcon;
	 }
	 
	 public WebElement getProdNameToBeSelected()
	 {
		 return prodNameToBeSelected;
	 }
	 //----------------------------------------------------------------------------------
	 
	 
	 //BUSINESS LOGIC
	 
	 public void updateCampaignName(String campaignName)
	 {
		campaignNameElement.sendKeys(campaignName); 
	 }
	
	 public void clickOnSaveButton()
	 {
		 saveButtonElement.click();
	 }
	 
	 public void clickOnCreateCampIcon()
	 {
		 creatingCampaignIcon.click();
	 }
	 
	 public void clickOnCreateProdWithinCamp()
	 {
		 creatingProdWithinCamp.click();
	 }
	 
	public void typeOnSearchBarForProd(String ProductName)
	{
		searchBarForProd.sendKeys(ProductName);
	}
	
	public void clickOnSearchNowIcon()
	{
		searchNowIcon.click();
	}
	
	public void clickOnSavingCampWithProd()
	{
		savingCampWithProdIcon.click();
	}
	
	public void selectProdWithinCamp(WebDriver driver, String ProductName)
	{
		 driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
	}

	
}
