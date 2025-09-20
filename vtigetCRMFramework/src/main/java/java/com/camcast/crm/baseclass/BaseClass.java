package java.com.camcast.crm.baseclass;

import java.com.camcast.crm.objectrepositoryutility.HomePage;
import java.com.camcast.crm.objectrepositoryutility.LoginPage;
import java.com.comcast.crm.generic.Fileutility.ExcelUtility;
import java.com.comcast.crm.generic.Fileutility.FileUtility;
import java.com.comcast.crm.generic.Fileutility.JsonUtility;
import java.com.comcast.crm.generic.Webdriverutility.JavaUtility;
import java.com.comcast.crm.generic.Webdriverutility.UtilityClassObject;
import java.com.comcast.crm.generic.Webdriverutility.WebDriverUtility;
import java.com.comcast.crm.generic.databaseutility.DataBaseUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 * @author Manikandan
 */
public class BaseClass {

	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JsonUtility jsLib = new JsonUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wbLib = new WebDriverUtility();
	public UtilityClassObject ucLib = new UtilityClassObject();

	public WebDriver driver;
	public static WebDriver sDriver;

	@BeforeSuite(groups = { "smoke", "regression", "regional regression" })
	public void configBS() {
		dbLib.getDbconnection();
	}

	@BeforeClass(groups = { "smoke", "regression", "regional regression" })
	public void configBC() throws Throwable {
		System.out.println("---------------");
		String URL = System.getProperty("url", fLib.getDataFromProerties("url"));
		String BROWSER = System.getProperty("browser", fLib.getDataFromProerties("browser"));

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new ChromeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sDriver = driver;
		UtilityClassObject.setDriver(driver);
//		driver.get(URL);
//		driver.manage().window().maximize();
//		wbLib.WaitForPageLoad(driver);
	}

	@BeforeMethod(groups = { "smoke", "regression", "regional regression" })
	public void configBM() throws Throwable {
		String URL = System.getProperty("url", fLib.getDataFromProerties("url"));
		String USERNAME = System.getProperty("username", fLib.getDataFromProerties("username"));
		String PASSWORD = System.getProperty("password", fLib.getDataFromProerties("password"));
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smoke", "regression", "regional regression" })
	public void configAM() {
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "smoke", "regression", "regional regression" })
	public void configAC() {
		driver.quit();
	}

	@AfterSuite(groups = { "smoke", "regression", "regional regression" })
	public void configAS() {
		dbLib.closeDbconnection();
	}
}
