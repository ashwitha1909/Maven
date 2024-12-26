package com.crm.generic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass
{
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://192.168.161.128:8080/crm/HomePage.do");
		Reporter.log("open browser",true);
	}
	@BeforeMethod
	public void login()
	{
		driver.findElement(By.id("userName")).sendKeys("rashmi@dell.com");
		driver.findElement(By.id("passWord")).sendKeys("123456");
		driver.findElement(By.cssSelector("input[title='Sign In']")).click();
		Reporter.log("login",true);
	}
	@AfterMethod
	public void logout()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Logout ')]")).click();
		Reporter.log("logout",true);
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.manage().window().minimize();
		driver.quit();
		Reporter.log("close browser",true);
	}
}