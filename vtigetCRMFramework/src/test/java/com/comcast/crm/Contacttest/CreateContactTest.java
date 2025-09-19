package com.comcast.crm.Contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateContactTest {
	
	@Test(groups = "smoke")
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
		Sheet sh = wb.getSheet("cont");
		Row row = sh.getRow(1);
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
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(actHeader.contains(lastName)) {
			System.out.println(lastName + " Cont is Created ==> PASS");
		}else {
			System.out.println(lastName + " Cont is Not Created ==> FAIL");
		}
		
		String actName = driver.findElement(By.id("dtlview_Last Name")).getText();
		
		if(actName.contains(lastName)) {
			System.out.println(lastName + "is Created ==> PASS");
		}else {
			System.out.println(lastName + " is Not Created ==> FAIL");
		}
		driver.quit();
	}
}
