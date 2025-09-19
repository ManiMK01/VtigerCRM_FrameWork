package java.com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
	
	WebDriver driver;

	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name = "firstname")
	private WebElement firstNameTextField;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement createIconbtn;
	
	@FindBy(name = "support_start_date")
	private WebElement startDateCal;
	
	@FindBy(name = "support_end_date")
	private WebElement endDateCal;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getCreateIconbtn() {
		return createIconbtn;
	}

	public WebElement getStartDateCal() {
		return startDateCal;
	}

	public WebElement getEndDateCal() {
		return endDateCal;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
}
