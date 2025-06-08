package com.dell.core.framework.dataLayer;

import java.io.FileInputStream;
import java.util.Properties;

import com.dell.core.framework.utils.Constants;

public class Property 
{
	
	public static String readProp(String key)
	{
		String val = null;
		try
		{
			Properties pro = new Properties();
			
			// Open the file in Read mode
			FileInputStream fis = new FileInputStream(Constants.sConfigFilePath);
			
			// Load the Properties file to properties class Object
			pro.load(fis);
			
			// Fetching the value from Properties file
			val = pro.getProperty(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
	}
}