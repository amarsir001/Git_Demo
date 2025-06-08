package com.dell.core.framework.seWebElement;


import java.io.File;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.dell.core.framework.seWebDriver.SelWebDriver;

public class SelWebElement 
{
	public SelWebDriver selDriver;
	
	
	public SelWebElement(SelWebDriver selDriver)
	{
		this.selDriver = selDriver;
	}
	
	public void clickOnWebElement(String locator, String locatorValue)
	{
		try
		{
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			w1.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void setValue(String locator, String locatorValue, String value)
	{
		try
		{
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			w1.sendKeys(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getVisibleText(String locator, String locatorValue)
	{
		String value = null;
		try
		{
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			value = w1.getText();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return value;
	}
	
	public String getAttributeValue(String locator, String locatorValue, String attValue)
	{
		String value = null;
		try
		{
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			value =  w1.getAttribute(attValue);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return value;
	}
	
	public boolean isWebElementDispaly(String locator, String locatorValue)
	{
		boolean flag = false;
		
		try
		{
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			flag = w1.isDisplayed();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean isWebElementEnabled(String locator, String locatorValue)
	{
		boolean flag = false;
		
		try
		{
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			flag = w1.isEnabled();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean isWebElementSelected(String locator, String locatorValue)
	{
		boolean flag = false;
		
		try
		{
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			flag = w1.isSelected();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public List<Integer> getWebElemLocation(String locator, String locatorValue)
	{

		List<Integer> xyAxis = null;
		
		try
		{
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			Point p =  w1.getLocation();
			
			int xAxis = p.x;
			xyAxis.add(xAxis);
			
			int yAxis = p.y;
			xyAxis.add(yAxis);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return xyAxis;
	}
	
	public void captureScreenShot(String screenShotName)
	{
		try
		{
			TakesScreenshot ts = (TakesScreenshot)selDriver.driver;
			 
			File sourceFile =  ts.getScreenshotAs(OutputType.FILE);
			
			File destinationFile = new File("../ScreenShot/"+screenShotName+".jpg");
			
			FileHandler.copy(sourceFile, destinationFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void clickbyJSExecuter(String locator, String locatorValue)
	{
		try
		{
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			
			JavascriptExecutor js = (JavascriptExecutor)selDriver.driver;
			js.executeScript("arguments[0].click();", w1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void setValueByJsExecuter(String locator, String locatorValue, String val)
	{
		try
		{
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			
			JavascriptExecutor js = (JavascriptExecutor)selDriver.driver;
			js.executeScript("arguments[0].value='"+val+"';", w1);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Select class wrapper method
	 */
	
	public Select getSelect(String locator, String locatorValue)
	{
		Select sel = null;
		try
		{
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			sel = new Select(w1);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return sel;
	}
	
	public void selectByValue(String locator, String locatorValue, String ddValue)
	{
		try
		{
			Select sel = getSelect(locator, locatorValue);
			sel.selectByValue(ddValue);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void selectDDValueByIndex(String locator, String locatorValue, int index)
	{
		try
		{
			Select sel = getSelect(locator, locatorValue);
			sel.selectByIndex(index);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void selectDDValueByVisibleText(String locator, String locatorValue, String ddValue)
	{
		try
		{
			Select sel = getSelect(locator, locatorValue);
			sel.selectByVisibleText(ddValue);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean isDDMultiple(String locator, String locatorValue)
	{
		boolean flag = false;
		
		try
		{
			Select sel = getSelect(locator, locatorValue);
			flag =  sel.isMultiple();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return flag;
	}
	
	public void deSelectByValue(String locator, String locatorValue, String ddValue)
	{
		try
		{
			Select sel = getSelect(locator, locatorValue);
			sel.deselectByValue(ddValue);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void deSelectDDValueByIndex(String locator, String locatorValue, int index)
	{
		try
		{
			Select sel = getSelect(locator, locatorValue);
			sel.deselectByIndex(index);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void deSelectDDValueByVisibleText(String locator, String locatorValue, String ddValue)
	{
		try
		{
			Select sel = getSelect(locator, locatorValue);
			sel.deselectByVisibleText(ddValue);
			sel.getAllSelectedOptions();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public List<WebElement> getAllSelectedDDValue(String locator, String locatorValue)
	{
		List<WebElement> lst = null;
		
		try
		{
			Select sel = getSelect(locator, locatorValue);
			
			lst = sel.getAllSelectedOptions();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return lst;
	}
	
	public void deSelecteAllDDValue(String locator, String locatorValue)
	{
		try
		{
			Select sel = getSelect(locator, locatorValue);
			
			sel.deselectAll();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*
	 * Actions class wrapper method
	 */
	
	public Actions getAction()
	{
		Actions act = null;
		
		try
		{
			act = new Actions(selDriver.driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		return act;
	}
	
	public void moveToWebElement(String locator, String locatorValue)
	{
		try
		{
			Actions act = getAction();
			
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			
			act.moveToElement(w1).perform();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void clickByActions(String locator, String locatorValue)
	{
		try
		{
			Actions act = getAction();
			
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			
			act.click(w1).perform();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void clickAndHold(String locator, String locatorValue)
	{
		try
		{
			Actions act = getAction();
			
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			
			act.clickAndHold(w1).perform();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void setValueByActions(String locator, String locatorValue, String value)
	{
		try
		{
			Actions act = getAction();
			
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			
			act.sendKeys(w1, value).perform();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void rightClickOnWebElement(String locator, String locatorValue)
	{
		try
		{
			Actions act = getAction();
			
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			
			act.contextClick(w1).perform();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void doubleClickOnWebElement(String locator, String locatorValue)
	{
		try
		{
			Actions act = getAction();
			
			WebElement w1 = selDriver.findWebElement(locator, locatorValue);
			
			act.doubleClick(w1).perform();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
	
}
