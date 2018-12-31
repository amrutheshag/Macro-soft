package com.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SetupPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.Log;

public class UnlockClaims {
	WebDriver driver;
	@Test
	public  void UnlockClaimsTestScript () throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n********************************************************************");
		System.out.println("Executing Unlock Claims ");
		System.out.println("\n********************************************************************");
		Log.info("\n********************************************************************");
		Log.info("Executing Unlock Claims");
		Log.info("\n********************************************************************");
	try{
		
		driver= BrowserUtils.openChromeBrowser();
		
		//open risk manager
		driver.get(Constant.URL);
		
		//click network user
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.clickNetworkUser();
		
	
		HomePage homePageObject = new HomePage(driver);
		try{
			homePageObject.clickExitMyOpenCaseListing();
		}catch(Exception e)
		{ System.out.println("Blank Home Page");
		Log.info("log4j - msg -Blank Home Page");}
		homePageObject.clickSetup();	
		
		SetupPage setupPageObject = new SetupPage(driver);
		setupPageObject.clickUnlockClaims();
	}catch(Exception e)	{ System.out.println("error in unlock claims");; Log.info("Error in unlock claims");}
		
	
}
		  
	@AfterMethod
	  public void afterMethod() throws Exception {
	 		System.out.println("Done with  Unlock claims");
			Log.info("Done with  unlock claims");
			if (driver !=null) driver.quit();	
	
	}
	
	

}




