package java.com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Calendar")
	private WebElement calendetLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLnk;
	
	@FindBy(partialLinkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	@FindBy(partialLinkText = "Sign Out")
	private WebElement signoutlink;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCalendetLink() {
		return calendetLink;
	}

	public WebElement getOrgLnk() {
		return orgLnk;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}
	
	public void NavigateToCamp() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignsLink.click();
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminIcon).perform();
		signoutlink.click();
	}
}
