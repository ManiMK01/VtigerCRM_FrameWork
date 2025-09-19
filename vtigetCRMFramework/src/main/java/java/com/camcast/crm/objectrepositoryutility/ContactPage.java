package java.com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createcontIcon;
	
	@FindBy(name = "search_text")
	private WebElement searchTestField;
	
	@FindBy(name = "search_field")
	private WebElement searchDropDown;
	
	@FindBy(name = "submit")
	private WebElement searchbtn;
	

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreatecontIcon() {
		return createcontIcon;
	}

	public WebElement getSearchTestField() {
		return searchTestField;
	}

	public WebElement getSearchDropDown() {
		return searchDropDown;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	public void selSearchDrop(String data) {
		Select sel = new Select(searchDropDown);
		sel.selectByVisibleText(data);
		
	}
}
