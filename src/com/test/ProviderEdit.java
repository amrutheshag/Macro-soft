package com.test;

import java.io.FileInputStream;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProviderListingPage;
import com.pages.ProvidersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ProviderEdit {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void providerEditTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Providers- Edit Providers");
			Log.info("Executing Providers- Edit Providers");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_TestDataToEdit_Providers;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String pLastname= ExcelUtils.getCellData(count,1);
		    		String pFirstname=ExcelUtils.getCellData(count,2);	
		    		String pMiddleInitial= ExcelUtils.getCellData(count, 3);
		    		//String pDOB=ExcelUtils.getCellData(count,4);	
		    		//String pGender=ExcelUtils.getCellData(count,5);	
		    		String pCode=ExcelUtils.getCellData(count,6);	
		    		String pNPI= ExcelUtils.getCellData(count,7);
		 
		    		//String pType=ExcelUtils.getCellData(count,8);
		    		//String pAPIid=ExcelUtils.getCellData(count,9);
		    		String pTAXid=ExcelUtils.getCellData(count,10);
		    		//String pTAXONOMYcode=ExcelUtils.getCellData(count,11);
		    		String pAddr=ExcelUtils.getCellData(count,12);
		    		String pCity=ExcelUtils.getCellData(count,13);
		    		String pState=ExcelUtils.getCellData(count,14);
		    		String pZIP=ExcelUtils.getCellData(count,15);
		    		//String pSSN=ExcelUtils.getCellData(count,16);
		    		//String pEmail=ExcelUtils.getCellData(count,17);
		    		//String pLanguage=ExcelUtils.getCellData(count,18);
		    		//String pAccepting=ExcelUtils.getCellData(count,19);
		    		//String networkRefNo=ExcelUtils.getCellData(count,20);
		    		String pActiveFrom=ExcelUtils.getCellData(count,21);
		    		String pTerminationDate=ExcelUtils.getCellData(count,22);
		    		String pPhNo=ExcelUtils.getCellData(count,23);
		    		String pUserField=ExcelUtils.getCellData(count,24);	
		    		String pSiteType=ExcelUtils.getCellData(count,25);
		    		String pSpeciality = ExcelUtils.getCellData(count,  26);
		    		String pSiteStartDate = ExcelUtils.getCellData(count,27);
		    		String pSiteEndDate=ExcelUtils.getCellData(count, 28);
		    		//String payer=ExcelUtils.getCellData(count,29);
		    		//String feeSchedule=ExcelUtils.getCellData(count,30);
		    		String pEditField = "E-mail" ;
		    		String pNewValue= "provider@email.com";

		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Provider Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Provider Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editProviderMultiple(driver,pLastname, pFirstname, pMiddleInitial, pCode, pNPI, pTAXid, pAddr, pCity, pState, pZIP, pSpeciality, pEditField, pNewValue);}
			}
			}
		    	catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editProviderMultiple(WebDriver driver,String pLastname, String pFirstname,String pMiddleInitial, String pCode, String pNPI,String pTAXid, String pAddress, String pCity, String pState, String pZIP, String pSpeciality, String pEditField, String pNewValue) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("opened browser");
						
			//click network user
			LoginPage loginPageObject = new LoginPage(driver);
			loginPageObject.clickNetworkUser();
			System.out.println("clicked Network user");
								
			HomePage homePageObject = new HomePage(driver);
			
			try{
				homePageObject.clickExitMyOpenCaseListing();
			}catch(Exception e)
			{ System.out.println("Blank Home Page");
			Log.info("log4j - msg -Blank Home Page");}
			
			homePageObject.clickProviders();	
			
			
			Thread.sleep(2000);
			
			//click Providers
			ProvidersPage providersPageObject = new ProvidersPage(driver);
			providersPageObject.clickOnProviders();
					
			Thread.sleep(2000);
		
			ProviderListingPage providerListingPageObject = new ProviderListingPage(driver);
			providerListingPageObject.editProvider( pLastname, pFirstname, pMiddleInitial, pCode, pNPI, pTAXid,pAddress, pCity, pState, pZIP, pSpeciality, pEditField, pNewValue );				
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Providers-Edit Providers \n\n");
		if (fis != null) 
				fis.close();
	}
}
