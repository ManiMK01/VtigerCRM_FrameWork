package java.com.camcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	//WebDriverUtility wbLib = new WebDriverUtility();
	
	@FindBy(name = "user_name")
	private WebElement userNameText;
	
	@FindBy(name = "user_password")
	private WebElement PasswordText;
	
	@FindBy(id = "submitButton")
	private WebElement loginbtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserNameText() {
		return userNameText;
	}

	public WebElement getPasswordText() {
		return PasswordText;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
public void LoginToApp(String username, String password) {
		
		userNameText.sendKeys(username);
		PasswordText.sendKeys(password);
		loginbtn.click();
	}
	public void LoginToApp(String url, String username, String password) {
		
		driver.get(url);
		userNameText.sendKeys(username);
		PasswordText.sendKeys(password);
		loginbtn.click();
	}

}
