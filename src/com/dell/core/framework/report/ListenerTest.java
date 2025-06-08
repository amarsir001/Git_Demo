package com.dell.core.framework.report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerTest implements ITestListener
{
	public void onTestStart(ITestResult result)
	{
		Reporter.log(result.getMethod().getMethodName()+" Test Started");
	}

	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log(result.getMethod().getMethodName()+" Test PASSED ");
	}

	public void onTestFailure(ITestResult result) 
	{
		Reporter.log(result.getMethod().getMethodName()+" Test FAILED ");
	}

	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log(result.getMethod().getMethodName()+" Test SKIPPED ");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
	
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
	    onTestFailure(result);
	}

	public void onStart(ITestContext context) 
	{
		Reporter.log(context.getName()+" Test Started");
	}

	public void onFinish(ITestContext context) 
	{
		Reporter.log(context.getName()+" Test Finished");
	}
}
