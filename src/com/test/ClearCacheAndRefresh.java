package com.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.Log;

public class ClearCacheAndRefresh {
	WebDriver driver;
	@Test
	public void startTimeTestScript() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		System.out.println("Need to clear cache and Refresh");
		Log.info("Need to clear cache and Refresh");
		
		// Launch Chrome Browser
					driver= BrowserUtils.openChromeBrowser();
								
					//open risk manager
					driver.get(Constant.URL);
					System.out.println("opened browser");
								
					//click network user
					LoginPage loginPageObject = new LoginPage(driver);
					loginPageObject.clickNetworkUser();
					System.out.println("clicked Network user");
										
		
		}
}
