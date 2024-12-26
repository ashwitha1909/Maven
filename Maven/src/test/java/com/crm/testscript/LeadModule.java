package com.crm.testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.BaseClass;
@Listeners(com.crm.generic.ListenerImplementation.class)
public class LeadModule extends BaseClass{
		@Test
	public void createLead() {
			driver.findElement(By.linkText("New Lead")).click();
			driver.findElement(By.name("property(First Name)")).sendKeys("Prafull");
			driver.findElement(By.name("property(Company)")).sendKeys("Sobha");
			driver.findElement(By.name("property(Last Name)")).sendKeys("ullagedde");
			WebElement leadsource = driver.findElement(By.name("property(Lead Source)"));
			Select s= new Select(leadsource);
			s.selectByIndex(5);
			driver.findElement(By.name("Button")).click();
			Reporter.log("Lead created",true);
		}
	@Test
	public void deleteLead() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("Leads")).click();Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Prafull ullagedde']")).click();Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[value='Delete']")).click();Thread.sleep(2000);
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Reporter.log("Lead deleted",true);
	}


}