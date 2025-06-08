package com.dell.core.framework.seWebDriver;

import org.openqa.selenium.By;

public class FindBy
{
	public static By seByLocator(String locatorType, String locatorValue)
	{
		By by = null;
		
		try
		{
			switch(locatorType.toLowerCase())
			{
				case "id":
					by = By.id(locatorValue);
					break;
					
				case "name":
					by = By.name(locatorValue);
					break;
					
				case "class_name":
					by = By.className(locatorValue);
					break;
					
				case "linkText":
					by = By.linkText(locatorValue);
					break;
					
				case "partialLinkText":
					by = By.partialLinkText(locatorValue);
					break;
					
				case "tagName":
					by = By.tagName(locatorValue);
					break;
					
				case "xpath":
					by = By.xpath(locatorValue);
					break;
					
				case "css":
					by = By.cssSelector(locatorValue);
					break;
					
				default:
					throw new Exception(
							"seByLocator: Unable to figure out valid find by locator");
					
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return by;
	}
}
