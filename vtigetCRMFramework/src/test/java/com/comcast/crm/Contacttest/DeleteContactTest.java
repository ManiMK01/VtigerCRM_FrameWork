package com.comcast.crm.Contacttest;

import java.com.camcast.crm.baseclass.BaseClass;
import java.com.camcast.crm.objectrepositoryutility.ContactPage;
import java.com.camcast.crm.objectrepositoryutility.CreateNewContactPage;
import java.com.camcast.crm.objectrepositoryutility.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(java.com.camcast.crm.listenerutility.ListenerImpClass.class)
public class DeleteContactTest extends BaseClass {
	
	
	@Test(groups = "smoke")
	public void deleteContactTest() throws Throwable {
			
		String lastName = eLib.getDataFromExcel("cont", 1, 2)+jLib.getRandomNumber();
		System.out.println(lastName);
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		
		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontIcon().click();
		
		CreateNewContactPage cnp = new CreateNewContactPage(driver);
		cnp.getLastNameTextField().sendKeys(lastName);
		cnp.getSaveBtn().click();
		hp.getContactLink().click();
		
		cp.getSearchTestField().sendKeys(lastName);
		cp.selSearchDrop("Last Name");
		cp.getSearchbtn();
		WebElement LastNA = driver.findElement(By.xpath("//a[text()='"+lastName+"']/../../td[10]/a[text()='del']"));
		wbLib.WaitFirElementPresent(driver, LastNA);
		
		driver.findElement(By.xpath("//a[text()='"+lastName+"']/../../td[10]/a[text()='del']")).click();
	
		wbLib.SwitchToAleartAndAccept(driver);
		
	
		
		
	}
	
}
