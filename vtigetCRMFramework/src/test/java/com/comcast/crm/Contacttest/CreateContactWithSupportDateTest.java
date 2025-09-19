package com.comcast.crm.Contacttest;

import java.com.comcast.crm.generic.Webdriverutility.JavaUtility;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;



public class CreateContactWithSupportDateTest {
	
	@Test(groups = "regression")
	public void createContactWithSupportDateTest() throws Throwable {
		WebDriver driver;
		JavaUtility ju = new JavaUtility();
		FileInputStream fis = new FileInputStream("C:\\Users\\Manikandan\\OneDrive\\Desktop\\data file\\commondata.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String BROWSER = pro.getProperty("browser");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Manikandan\\OneDrive\\Desktop\\data file\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("cont");
		Row row = sh.getRow(4);
		String lastName = row.getCell(2).toString()+ ranNum;// + randomInt; for random number
		
		wb.close();
		
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("edge")) {
			driver = new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver = new ChromeDriver();
		}else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.partialLinkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		String StartData = ju.getSystemDateYYYYMMDD();
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(StartData);
		
		String EndDate = ju.getReqiredDateYYYYMMDD(30);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(EndDate);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actStartDate.contains(StartData)) {
			System.out.println(StartData + " Contact  date is Created ==> PASS");
		}else {
			System.out.println(StartData + " Contact  date is Not Created ==> FAIL");
		}
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actEndDate.contains(EndDate)) {
			System.out.println(EndDate + " Contact date is Created ==> PASS");
		}else {
			System.out.println(EndDate + " Contact date is Not Created ==> FAIL");
		}
		driver.quit();
	}

}
