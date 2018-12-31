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

public class ProviderAdd {

	static WebDriver driver;
	FileInputStream fis;
		@Test
		public void providerAddTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Providers- Add Providers");
			Log.info("Executing Providers- Add Providers");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_TestDataToAdd_Providers;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String pLastname= ExcelUtils.getCellData(count,1);
		    		String pFirstname=ExcelUtils.getCellData(count,2);	
		    		String pMiddleInitial= ExcelUtils.getCellData(count, 3);
		    		String pDOB=ExcelUtils.getCellData(count,4);	
		    		String pGender=ExcelUtils.getCellData(count,5);	
		    		String pCode=ExcelUtils.getCellData(count,6);	
		    		String pNPI= ExcelUtils.getCellData(count,7);
		 
		    		String pType=ExcelUtils.getCellData(count,8);
		    		//String pAPIid=ExcelUtils.getCellData(count,9);
		    		String pTAXid=ExcelUtils.getCellData(count,10);
		    		String pTAXONOMYcode=ExcelUtils.getCellData(count,11);
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
		    		
		    		//String subject= ExcelUtils.getCellData(count,29);
    				//String caseNote=ExcelUtils.getCellData(count,30);
    				//String noteType=ExcelUtils.getCellData(count,31);
    				//String details= ExcelUtils.getCellData(count,32);
		    		
		    		String providerDegree= ExcelUtils.getCellData(count, 33);
    				String providerCounty=ExcelUtils.getCellData(count, 34);
    				String providerFAX= ExcelUtils.getCellData(count, 35);
    				String specialitiesCurrentStatus = 	ExcelUtils.getCellData(count, 36);
    				String specialitiesEffectivePeriod= ExcelUtils.getCellData(count, 37);	
    				String specialityInfo	= ExcelUtils.getCellData(count, 38);
    				String IDType = 	ExcelUtils.getCellData(count, 39);
    				String IDNumber	= 	ExcelUtils.getCellData(count, 40);
    				String IDEffectivePeriod	= 	ExcelUtils.getCellData(count, 41);
    				String ProviderContractEndDate	= 	ExcelUtils.getCellData(count, 42);
    				String payer	= 	ExcelUtils.getCellData(count, 43);
    				String benefitClass	= ExcelUtils.getCellData(count, 44);
    				String serviceSite	= ExcelUtils.getCellData(count, 45);
    				String paymentsCreditToTIN	= ExcelUtils.getCellData(count, 46);
    				String redirectToPayee	= ExcelUtils.getCellData(count, 47);
    				String feeSchedule	= ExcelUtils.getCellData(count, 48);
    				String vendorName	= ExcelUtils.getCellData(count, 49);
    				String vendorType = ExcelUtils.getCellData(count, 50);
    				String vendorNPI = ExcelUtils.getCellData(count, 51);
    				String vendorAPID = ExcelUtils.getCellData(count, 52);
    				String vendorActiveStatusEndDate =	ExcelUtils.getCellData(count, 53);
    				String vendorDefaultTaxID= ExcelUtils.getCellData(count, 54);
    				

		    		
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Provider Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Provider Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		   		 addProviderMultiple(driver,pLastname, pFirstname, pMiddleInitial, pCode, pNPI, pType, providerDegree, pDOB, pGender, pActiveFrom, pTerminationDate, pTAXid, pSpeciality,pSiteStartDate, pSiteEndDate,pSiteType, pTAXONOMYcode, pAddr, pCity, pState, pZIP, providerCounty,  pPhNo,providerFAX,    pUserField, specialitiesCurrentStatus, specialitiesEffectivePeriod, specialityInfo, IDType, IDNumber, IDEffectivePeriod, ProviderContractEndDate, payer, benefitClass, serviceSite, paymentsCreditToTIN, redirectToPayee, feeSchedule, vendorName, vendorType, vendorNPI, vendorAPID, vendorActiveStatusEndDate, vendorDefaultTaxID);}
			}
			}
		    	catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addProviderMultiple(WebDriver driver,String pLastname, String pFirstname, String pMiddleInitial, String pCode, String pNPI, String pType, String providerDegree, String pDOB, String pGender, String pActiveFrom, String pTerminationDate, String pTAXid, String pSpeciality,String pSiteStartDate, String pSiteEndDate,String pSiteType, String pTAXONOMYcode, String pAddr, String pCity, String pState, String pZIP, String pCounty,  String pPhNo, String providerFAX,  String pUserField, String specialitiesCurrentStatus, String specialitiesEffectivePeriod, String specialityInfo, String IDType, String IDNumber, String IDEffectivePeriod, String ProviderContractEndDate, String payer, String benefitClass, String serviceSite, String paymentsCreditToTIN, String redirectToPayee, String feeSchedule, String vendorName, String vendorType, String vendorNPI, String vendorAPID, String vendorActiveStatusEndDate, String vendorDefaultTaxID) throws Exception
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
			//add new Provider
			ProviderListingPage providerListingPageObject = new ProviderListingPage(driver);
			providerListingPageObject.addProvider(pLastname, pFirstname, pMiddleInitial, pCode, pNPI, pType, providerDegree, pDOB, pGender, pActiveFrom, pTerminationDate, pTAXid, pSpeciality,pSiteStartDate, pSiteEndDate,pSiteType, pTAXONOMYcode, pAddr, pCity, pState, pZIP, pCounty,  pPhNo,providerFAX,    pUserField, specialitiesCurrentStatus, specialitiesEffectivePeriod, specialityInfo, IDType, IDNumber, IDEffectivePeriod, ProviderContractEndDate, payer, benefitClass, serviceSite, paymentsCreditToTIN, redirectToPayee, feeSchedule, vendorName, vendorType, vendorNPI, vendorAPID, vendorActiveStatusEndDate, vendorDefaultTaxID);
		
			}

		@AfterMethod
		public void afterMethod() throws Exception {
			
		if (driver!=null) driver.quit();
		System.out.println("Done with Providers-Add Providers \n\n");
		if (fis != null) fis.close();
	}
		
}


	
	
	
	
	
	
	
	

