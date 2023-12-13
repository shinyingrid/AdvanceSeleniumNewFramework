package pomRepository;

import javax.management.loading.PrivateClassLoader;
import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//***********************************************************************************************
//***********************************************************************************************
	
	//Declaration
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(xpath = "//table[@class='hdrTabBg']//a")
	private WebElement homeimgIconLink;
	
	@FindBy(linkText = "Calendar")
	private WebElement calendarLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsLink;
	
	@FindBy(linkText = "Email")
	private WebElement emailLink;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement troubleTicketsLink;
	
	@FindBy(linkText = "Dashboard")
	private WebElement dashboardLink;
	
	@FindBy(xpath="//input[@value='Search...']")
	private WebElement searchLink;
	
	@FindBy(xpath =  "//input[@class='searchBtn']")
	private WebElement magnifierSearchLink;
	
	@FindBy(xpath = "(//select[@class='small'])[1]")
	private WebElement quickCreateDropdownLink;
	
	@FindBy(xpath = "(//td[@class='small'])[3]//img")
	private WebElement helpLink; 
	
	@FindBy(xpath = "//td[@class='small'])[4]/img")
	private WebElement crmSettingsLink;
	
	@FindBy(xpath = "//table[@class='small homePageButtons']//td/a")
	private WebElement homeLink;
	
	@FindBy(xpath = "//table[@class='small homePageButtons']//img[1]")
	private WebElement addIconLink;
	
	@FindBy(xpath = "(//table[@class='small homePageButtons'])//td[4]//img")
	private WebElement openCalendarIconLink;
	
	@FindBy(xpath = "(//table[@class='small homePageButtons'])//td[5]/img")
	private WebElement showWorldClockLink;
	
	@FindBy(xpath = "(//table[@class='small homePageButtons'])//td[6]/img")
	private WebElement openCalculatorLink;
	
	@FindBy(xpath = "(//table[@class='small homePageButtons'])//td[7]/img")
	private WebElement chatLink;
	
	@FindBy(xpath = "(//table[@class='small homePageButtons'])//td[8]/img")
	private WebElement lastViewedLink;
	
	@FindBy(xpath = "(//table[@class='small homePageButtons'])//td[9]/img")
	private WebElement changeLayoutLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement myPreferences;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutElement;

	
	
//***********************************************************************************************
//***********************************************************************************************
	
	//Getter Methods
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}
	
		
	public WebElement getProductsLink()
	{
		return productsLink;
	}
	
	public WebElement getOrganizationsLink()
	{
		return organizationsLink;
	}
	
	public WebElement gethomeIconLink()
	{
		return homeimgIconLink;
	}
	
	public WebElement getCalendarLink()
	{
		return calendarLink;
	}
	
	public WebElement getLeadsLink()
	{
		return leadsLink;
	}
	
	public WebElement getContactsLink()
	{
		return contactsLink;
	}

	public WebElement getHomeimgIconLink() {
		return homeimgIconLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getEmailLink() {
		return emailLink;
	}

	public WebElement getTroubleTicketsLink() {
		return troubleTicketsLink;
	}

	public WebElement getDashboardLink() {
		return dashboardLink;
	}

	public WebElement getSearchLink() {
		return searchLink;
	}

	public WebElement getMagnifierSearchLink() {
		return magnifierSearchLink;
	}

	public WebElement getQuickCreateDropdownLink() {
		return quickCreateDropdownLink;
	}

	public WebElement getCrmSettingsLink() {
		return crmSettingsLink;
	}

	public WebElement getHelpLink() {
		return helpLink;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getAddIconLink() {
		return addIconLink;
	}

	public WebElement getOpenCalendarIconLink() {
		return openCalendarIconLink;
	}

	public WebElement getShowWorldClockLink() {
		return showWorldClockLink;
	}

	public WebElement getOpenCalculatorLink() {
		return openCalculatorLink;
	}

	public WebElement getChatLink() {
		return chatLink;
	}

	public WebElement getLastViewedLink() {
		return lastViewedLink;
	}

	public WebElement getChangeLayoutLink() {
		return changeLayoutLink;
	}
	
	public WebElement getMyPreferences()
	{
		return myPreferences;
	}
	
	public WebElement getSignOut()
	{
		return signOutElement;
	}
//***********************************************************************************************
//***********************************************************************************************	
	
	//Business Logic Methods
	
	

	public void clickOnMoreLink() 
	{
		moreLink.click();
	}
	
	public void clickOnCampaigns()
	{
		campaignLink.click();
	}
			
	public void clickonProducts()
	{
		productsLink.click();
	}
	
	public void clickOnOrganizations()
	{
		organizationsLink.click();
	}
	
	public void clickOnHomeIcon()
	{
		homeimgIconLink.click();
	}
	
	public void clickOnCalendar()
	{
		calendarLink.click();
	}
	
	public void clickOnLeads()
	{
		leadsLink.click();
	}
	
	public void clickOnContacts()
	{
		contactsLink.click();
	}
	
	public void clickOnOpportunities()
	{
		opportunitiesLink.click();
	}
	
	public void clickOnDocuments()
	{
		documentsLink.click();
	}
	
	public void clickOnEmail()
	{
		emailLink.click();
	}
	
	public void clickOnTroubledTickets()
	{
		troubleTicketsLink.click();
	}
	
	public void clickOnDashboardLink()
	{
		dashboardLink.click();
	}
	
//	public void clickOnSearch()
//	{
//		searchLink.click();
//	}
	
	public void clickOnMagnifierSearchLink()
	{
		magnifierSearchLink.click();
	}
	
//	public void clickOnQuickCreateDropDown()
//	{
//		
//	}
	
//	public void clickOnQuickCreate()
//	{
//		
//	}
	
	
	public void clickOnHelpLink()
	{
		helpLink.click();
	}
	
	public void clickOnCrmSettings()
	{
		crmSettingsLink.click();
	}
	
	public void clickOnHomeLink()
	{
		homeLink.click();
	}

	public void clickOnAddIcon()
	{
		addIconLink.click();
	}
	
	public void clickOnOpenCalendar()
	{
		openCalculatorLink.click();
	}
	
	public void clickOnShowWorldClock()
	{
		showWorldClockLink.click();
	}
	
	public void clickOnOpenCalculator()
	{
		openCalculatorLink.click();
	}
	
	public void clickOnChat()
	{
		chatLink.click();
	}
	
	public void clickOnLastViewed()
	{
		lastViewedLink.click();
	}
	
	public void clickOnChangeLayout()
	{
		changeLayoutLink.click();
	}
	
	public void clickOnMyPreferences()
	{
		myPreferences.click();
	}
	
	public void clickOnSignOut()
	{
		signOutElement.click();
	}
	
//***********************************************************************************************
//***********************************************************************************************	

}
