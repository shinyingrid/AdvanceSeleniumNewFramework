package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities_AS.File_Utility;

public class LoginPage 

{
	
//-------------------------------------------------------------------------------------------------	
	//INITIALIZATION
	//USING CONSTRUCTOR
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//--------------------------------------------------------------------------------------------------	
	
	//DECLARATION
	
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindBy(name="user_password")
	//@FindBys({@FindBy(css="input[type=password]"),@FindBy(name="user_password")})
	private WebElement PasswordTextField;
	
	//@FindBy(id="submitButton")
	@FindAll({@FindBy(css="input[type=submit]"),@FindBy(id="submitButton")})
	private WebElement loginButton;

	
//--------------------------------------------------------------------------------------------------
	
	//GENERATE GETTER METHODS
	
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

//---------------------------------------------------------------------------------------------------
	
	//BUSINESS LOGIC
	
	public void loginToApplication(String Username,String Password) throws Throwable
	{
		
		UserTextField.sendKeys(Username);
		PasswordTextField.sendKeys(Password);
		loginButton.click();
	}
	
}
