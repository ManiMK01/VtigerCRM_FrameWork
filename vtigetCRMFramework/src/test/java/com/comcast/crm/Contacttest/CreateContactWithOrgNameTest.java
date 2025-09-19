package com.comcast.crm.Contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateContactWithOrgNameTest {

	@Test(groups = "regression")
	public void createContactTest() throws Throwable {
		WebDriver driver;
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
		
		Sheet sh1 = wb.getSheet("cont");
		Row row1 = sh1.getRow(7);
		String lastName = row1.getCell(3).toString()+ ranNum;
		String orgName = row1.getCell(2).toString()+ ranNum;
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
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Create Org Name
		driver.findElement(By.partialLinkText("Organization")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		System.out.println(orgName);
		driver.navigate().refresh();
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		//driver.findElement(By.xpath("//td[text()='Organization Name 			']/following-sibling::td/img")).click();
		driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img")).click();
		
		Thread.sleep(2000);
		Set<String> allIds = driver.getWindowHandles();
		for(String id : allIds) {
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains("module=Accounts")) {
				break;	
			}
		}
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		for(String id : allIds) {
			driver.switchTo().window(id);
			if(driver.getCurrentUrl().contains("Contacts&action")) {
				break;
				
			}
		}
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		String actHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(actHeader.contains(lastName)) {
			System.out.println(lastName + " Cont is Created ==> PASS");
		}else {
			System.out.println(lastName + " Cont is Not Created ==> FAIL");
		}
		
		String actorgName = driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']/..//a[text()='"+orgName+"']")).getText();
		
		if(actorgName.contains(orgName)) {
			System.out.println(orgName + " is Created ==> PASS");
		}else {
			System.out.println(orgName + " is Not Created ==> FAIL");
		}
		driver.quit();
	}

}
