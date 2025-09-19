package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

import com.mysql.cj.jdbc.Driver;

public class CreateOrganizationWithIndustriesTest {
	@Test(groups = "regression")
	public void creatOrgtest(XmlTest test) throws Throwable, IOException, ParseException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Manikandan\\OneDrive\\Desktop\\data file\\commondata.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		String BROWSER = pro.getProperty("browser");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Manikandan\\OneDrive\\Desktop\\data file\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(4);
		String orgName = row.getCell(2).toString();// + randomInt; for random number
		String industry = row.getCell(3).toString();
		String type = row.getCell(4).toString();
		wb.close();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.partialLinkText("Organization")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		Select sel1 = new Select(driver.findElement(By.name("industry")));
		sel1.selectByVisibleText(industry);
		Select sel2 = new Select(driver.findElement(By.name("accounttype")));
		sel2.selectByVisibleText(type);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+s])[1]']")).click();
		
		// verify Header msg Expected Result TC_01
		String headInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headInfo.contains(orgName)) {
			System.out.println(orgName + "is Created ==> PASS");
		}else {
			System.out.println(orgName + "is not Created ==> FAIL");
		}
		
		//verify Header orgName info Expected Result 
		String actOrgName = driver.findElement(By.id("dtlview_Organization ")).getText();
		if(actOrgName.contains(orgName)) {
			System.out.println(actOrgName + "is Created ==> PASS");
		}else {
			System.out.println(actOrgName + "is not Created ==> FAIL");
		}
		driver.quit();
		
	}
}
