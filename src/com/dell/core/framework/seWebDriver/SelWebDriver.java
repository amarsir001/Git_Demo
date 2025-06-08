package com.dell.core.framework.seWebDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dell.core.framework.dataLayer.Property;
import com.dell.core.framework.utils.Constants;

public class SelWebDriver 
{
	public WebDriver driver;
	public String mainWinId = null;
	
	public WebDriver getDriver()
	{	
		if(Constants.browserType.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		
		else if(Constants.browserType.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else
		{
			driver = new InternetExplorerDriver();
		}
		
		return driver;
	}
	
	public void enterUrlToBrowser()
	{
		driver.get(Property.readProp("url"));
	}
	
	public WebElement findWebElement(String locator, String locatorValue)
	{
		WebElement elm = null;
		try
		{
			elm =  driver.findElement(FindBy.seByLocator(locator, locatorValue));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return elm;
	}
	
	public List<WebElement> findWebElements(String locator, String locatorValue)
	{
		List<WebElement> elms = null;
		try
		{
			elms=  driver.findElements(FindBy.seByLocator(locator, locatorValue));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return elms;
	}
	
	public String getPageSourceCode()
	{
		String val = null;
		try
		{
			val = driver.getPageSource();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
	}
	
	public String getBrowserTitle()
	{
		String title = null;
		try
		{
			title = driver.getTitle();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return title;
	}
	
	public String getWindowId()
	{
		String winId = driver.getWindowHandle();
		return winId;
	}
	
	public Set<String> getAllWindowId()
	{
		Set<String> winIds = driver.getWindowHandles();
		return winIds;
	}
	
	public void switchToExpectedWindow(String expectedTitle)
	{
		try
		{
			// capture the window id where the control is presently active
			mainWinId = getWindowId();
			
			// Capture the all window ID
			Set<String> winIds = getAllWindowId();
			
			Iterator<String>  itr = winIds.iterator();
			
			while(itr.hasNext())
			{
				String Id = itr.next();
				
				driver.switchTo().window(Id);
				
				String actualTitle = driver.getTitle();
				
				if(expectedTitle.equals(actualTitle))
				{
					System.out.println("we are in expected windows");
				}	
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void getControlOnMainWindows()
	{
		try
		{
			driver.switchTo().window(mainWinId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void waitForExpectedWebElement(String locator, String locatorValue)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(FindBy.seByLocator(locator, locatorValue)));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
