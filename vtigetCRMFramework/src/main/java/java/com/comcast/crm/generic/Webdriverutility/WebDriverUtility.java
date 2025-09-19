package java.com.comcast.crm.generic.Webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * 
	 * @param driver
	 */
	public void WaitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void WaitFirElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * 
	 * @param driver
	 * @param Partial_Url
	 */
	public void SwitchToTabOnUrl(WebDriver driver,String Partial_Url) {
		Set<String> allwindowIds = driver.getWindowHandles();
		for(String Id : allwindowIds) {
			driver.switchTo().window(Id);
			if(driver.getCurrentUrl().equals(Partial_Url)) {
				break;
			}
		}
	}
	
	/**
	 * 
	 * @param driver
	 * @param Tittle
	 */
	public void SwitchToTabOnTittle(WebDriver driver,String Tittle){
		Set<String> allwindowIds = driver.getWindowHandles();
		for(String Id : allwindowIds) {
			driver.switchTo().window(Id);
			if(driver.getTitle().equals(Tittle)) {
				break;
			}
		}
	}
	
	/**
	 * 
	 * @param driver
	 * @param index
	 */
	public void SwitchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * 
	 * @param driver
	 * @param name_id
	 */
	public void SwitchToFrame(WebDriver driver, String name_id) {
		driver.switchTo().frame(name_id);
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void SwitchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	/**
	 * 
	 * @param driver
	 */
	public void SwitchToAleartAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * 
	 * @param driver
	 */
	public void SwitchToAleartAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * 
	 * @param driver
	 * @param index
	 * @param element
	 */
	public void select(WebDriver driver, int index, WebElement element) {
		Select sel = new Select(element);
		sel.deselectByIndex(index);
	}
	
	/**
	 * 
	 * @param driver
	 * @param text
	 * @param element
	 */
	public void select(WebDriver driver, String text, WebElement element) {
		Select sel = new Select(element);
		sel.deselectByVisibleText(text);
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseMoveOnElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void ScrollToElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element);
	}
	
	
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleclick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element);
	}
}
