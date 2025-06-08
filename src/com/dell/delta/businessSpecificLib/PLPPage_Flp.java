package com.dell.delta.businessSpecificLib;

import com.dell.core.framework.seWebDriver.SelWebDriver;
import com.dell.core.framework.seWebElement.SelWebElement;
import com.dell.delta.pageObject.PLPPage;

public class PLPPage_Flp
{
	public SelWebDriver sDriver;
	public SelWebElement sElm;
	
	public PLPPage_Flp(SelWebDriver sDriver, SelWebElement sElm)
	{
		this.sDriver = new SelWebDriver(); 
		this.sElm = new SelWebElement(sDriver);
	}
	
	public void filterProduct(String productName)
	{
		try
		{
			sElm.setValue("xpath", PLPPage.search_brand_txt_box, productName);
			
			sElm.clickOnWebElement("xpath", PLPPage.select_brand);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
