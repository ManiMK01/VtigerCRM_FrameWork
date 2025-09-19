package java.com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationPage {
	WebDriver driver;
	
	@FindBy(name ="accountname")
	private WebElement OrgNameText;
	
	@FindBy(id = "phone")
	private WebElement PhoneNumText;
	
	@FindBy(name = "industry")
	private WebElement IndustrySel;
	
	@FindBy(name = "accounttype")
	private WebElement TypeSel;
	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameText() {
		return OrgNameText;
	}

	public WebElement getPhoneNumText() {
		return PhoneNumText;
	}

	public WebElement getIndustrySel() {
		return IndustrySel;
	}

	public WebElement getTypeSel() {
		return TypeSel;
	}
	
	
	public void selectIndustry(String name) {
		Select sel = new Select(IndustrySel);
		sel.selectByVisibleText(name);
	}
	
	public void selectTye(String name) {
		Select sel = new Select(TypeSel);
		sel.selectByVisibleText(name);
	}
}
