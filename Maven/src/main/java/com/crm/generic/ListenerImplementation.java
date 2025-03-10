package com.crm.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementation extends BaseClass implements ITestListener
{
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getName();
		Reporter.log(methodName+" is started",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getName();
		Reporter.log(methodName+" is passed",true);
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		String methodName = result.getName();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/"+methodName+".png");
		try 
		{
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e) 
		{

		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getName();
		Reporter.log(methodName+" is skipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}