package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage
{
	//INITIALIZATION
	public CreatingNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//------------------------------------------------------------------------------------	
	//DECLARATION
	@FindBy(name = "productname")
	private WebElement newProdName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveProdName;
	
	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement prodNameCreated;
	
//------------------------------------------------------------------------------------
	
	//GETTER METHODS
	
	public WebElement getNewProdName()
	{
		return newProdName;
	}
	
	public WebElement getSaveProdName()
	{
		return saveProdName;
	}
	
	public WebElement getProdNameCreated()
	{
		return prodNameCreated;
	}
	
//-------------------------------------------------------------------------------------
	
	//BUSINESS LOGIC METHODS
	
	public void updateNewProdName(String generatedProdName)
	{
		newProdName.sendKeys(generatedProdName);
	}
	
	public void clickOnSaveProdName()
	{
		saveProdName.click();
	}
	
	//validation
	public void validateNewProdCreated(String ProdName)
	{
		String ProdNameText = prodNameCreated.getText();
		if(ProdNameText.contains(ProdName))
		{
			System.out.println("Product created successfully");
		}
		else 
		{
			System.out.println("Product is not created");
		}
	}
	
	//validation - for Assertion Method
	public String validateProd()
	{
		return prodNameCreated.getText();
	}
}
