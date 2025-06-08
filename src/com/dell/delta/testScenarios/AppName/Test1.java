package com.dell.delta.testScenarios.AppName;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dell.core.framework.seWebDriver.SelWebDriver;
import com.dell.core.framework.seWebElement.SelWebElement;
import com.dell.core.framework.utils.Global;
import com.dell.delta.businessSpecificLib.HomePage_Flp;
import com.dell.delta.businessSpecificLib.PLPPage_Flp;
import com.dell.delta.pageObject.HomePage;
import com.dell.delta.pageObject.PLPPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ATUReportsListener.class, ConfigurationListener.class, MethodListener.class})
public class Test1 
{
	{
		System.setProperty("atu.reporter.config", "/Users/pritamkumar/Documents/JavaBatch_01/Phase1_MileStone1/Resources/atu.properties");
	}

	public SelWebDriver sDriver;
	public SelWebElement seElm;
	public HomePage_Flp hPage;
	public PLPPage_Flp plpPage;
	
	@BeforeClass
	public void openBroser()
	{
		sDriver = new SelWebDriver();
		sDriver.getDriver();
		seElm = new SelWebElement(sDriver);
		hPage = new HomePage_Flp(sDriver, seElm);
		plpPage = new PLPPage_Flp(sDriver, seElm);
		
	}
	
	@Test
	public void loginToApp()
	{	
		
		
		sDriver.enterUrlToBrowser();
		sDriver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		
		hPage.searchProduct("Jeans");
		
		sDriver.waitForExpectedWebElement("xpath", PLPPage.search_brand_txt_box);
		
		plpPage.filterProduct("LEE");
       
	}
	
	@AfterMethod
	public void tearDown(ITestResult itr)
	{
		boolean flag = itr.isSuccess();
		
		if(flag)
		{
			ATUReports.add(itr.getMethod().getMethodName()+"_PASS", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}
		else
		{
			ATUReports.add(itr.getMethod().getMethodName()+"_FAIL", LogAs.FAILED, new CaptureScreen(ScreenshotOf.DESKTOP));
		}
	}
}
