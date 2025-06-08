package com.dell.delta.businessSpecificLib;

import com.dell.core.framework.seWebDriver.SelWebDriver;
import com.dell.core.framework.seWebElement.SelWebElement;
import com.dell.delta.pageObject.HomePage;

public class HomePage_Flp 
{
	public SelWebDriver sDriver;
	public SelWebElement sElm;
	
	public HomePage_Flp(SelWebDriver sDriver, SelWebElement sElm)
	{
		this.sDriver = new SelWebDriver(); 
		this.sElm = new SelWebElement(sDriver);
	}
	
	public void searchProduct(String productName)
	{
		try
		{
			sElm.setValue("xpath", HomePage.search_txt_box, productName);
			sElm.clickOnWebElement("xpath", HomePage.search_btn);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
