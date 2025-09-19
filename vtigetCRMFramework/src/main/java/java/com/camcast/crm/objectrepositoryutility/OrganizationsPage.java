package java.com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	
	@FindBy(name = "search_text")
	private WebElement OrgSearchText;
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement OrgCreateBtn;
	
	@FindBy(name = "submit")
	private WebElement OrgSearchbtn;
	
	public OrganizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgSearchText() {
		return OrgSearchText;
	}

	public WebElement getOrgCreateBtn() {
		return OrgCreateBtn;
	}

	public WebElement getOrgSearchbtn() {
		return OrgSearchbtn;
	}
	
	
}
