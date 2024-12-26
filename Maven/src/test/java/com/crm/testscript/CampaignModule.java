package com.crm.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.BaseClass;

@Listeners(com.crm.generic.ListenerImplementation.class)
public class CampaignModule extends BaseClass {
	@Test
	public void createCampaign() 
	{
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.cssSelector("input[value='New Campaign']")).click();
		driver.findElement(By.cssSelector("input[name='property(Campaign Name)']")).sendKeys("Praveen Laptop Expo");
		driver.findElement(By.cssSelector("input[value='Save']")).click();
		String campName = driver.findElement(By.id("value_Campaign Name")).getText();
		/*
		 * if(campName.equals("Praveen Laptop Expo"))
		 * System.out.println("Praveen Laptop Expo created"); else
		 * System.out.println("Praveen Laptop Expo not created");
		 */
		Assert.assertEquals(campName, "Praveen Laptop Expo");
		Reporter.log("Campaign created",true);
	}
	
	@Test
	public void deleteCampaign() throws InterruptedException
	{
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.linkText("Praveen Laptop Expo")).click();
		driver.findElement(By.cssSelector("input[value='Delete']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Reporter.log("Campaign deleted",true);
	}
}
