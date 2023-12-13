package pomRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.python.antlr.PythonParser.return_stmt_return;

import Generic_Utilities_AS.Web_Utility;

public class ProductsHomePage 
{
	//INITIALIZATIONS
	
	public ProductsHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//-------------------------------------------------------------------------------------
	
	//DECLARATION
	
	
	@FindBy(xpath = "//img[@title='Create Product...']") //plus sign to create product
	private WebElement createNewProdSign;
	
	@FindBy(xpath = "(//a[text()='Products'])[1]") // PRODUCTS TAB
	private WebElement productsTab;
	
	@FindBy(xpath = "//a[text()='Product Name']/parent::td/preceding-sibling::td[2]//input") //Header - check box
	private WebElement checkBoxOfProdNameList;
	
	//@FindBy(xpath = "//input[@value='Delete']") // Delete - Full Product list
	@FindBy(xpath = "(//input[@class='crmbutton small delete'])[2]")
	private WebElement deleteProdButton;
	
	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr/td[3]") //Header - Product name
	private WebElement productNameListTab;
	
	@FindBy(xpath = "//a[text()='\"+ProdName+\"']/../preceding-sibling::td[2]/input")
	private WebElement checkBoxOfNewProdCreated;
	
	@FindBy(xpath = "(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]")
	private List<WebElement> listOfProducts;
	
//---------------------------------------------------------------------------------------
	
	//GETTER METHODS
	
	public WebElement getCreateNewProdSign()
	{
		return createNewProdSign;
	}
	
	public WebElement getProdNameList()
	{
		return productsTab;
	}
	
	public WebElement getCheckBoxOfProdList()
	{
		return checkBoxOfProdNameList;
	}
	
	public WebElement getDeleteProd()
	{
		return deleteProdButton;
	}
	
	public WebElement getProdNameListTab()
	{
		return productNameListTab;
	}
	
	public WebElement getCheckBoxOfNewProdCreated()
	{
		return checkBoxOfNewProdCreated;
	}
	
	public List<WebElement> getListOfProducts()
	{
		return listOfProducts;
	}
//----------------------------------------------------------------------------------------
	
	//BUSINESS LOGIC METHODS
	
	public void clickOnCreateNewProdSign()
	{
		createNewProdSign.click();
	}
	
	public void clickOnProductsTab()
	{
		productsTab.click();
	}
	
	public void clickOnCheckBoxOfProdList()
	{
		checkBoxOfProdNameList.click();
	}
	
	public void clickOnDeleteProdButton()
	{
		deleteProdButton.click();
	}
	
	public void clickOnProdNameTabList()
	{
		productNameListTab.click();
	}
	
	public void clickOnCheckBoxOfNewProdCreated()
	{
		checkBoxOfNewProdCreated.click();
	}
	
	public void selectProduct(WebDriver driver, String ProductName)
	{
	
		driver.findElement(By.xpath("//a[text()='"+ProductName+"']/../preceding-sibling::td[2]/input")).click();
	}
	
	public void validateIfProductIsDeleted(String ProductName)
	{
		List<WebElement> prdList = listOfProducts;
		
		boolean flag=false;
		for(WebElement prodList : prdList)
		{
			String ProdListData = prodList.getText();
			if(ProdListData.contains(ProductName))
					{
						flag = true;
						break;
					}
		}
		if(flag)
		{
			System.out.println("Product is deleted");
		}
		else
		{
			System.out.println("No product found");
		}
	}
	
//----------------------------------------------------------------------------------------	
}
