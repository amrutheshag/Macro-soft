package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProvidersPage;
import com.pages.TaxPayerAndRateListingPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class TaxPayerAndRateCopy {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void TaxPayersAndRateCopyTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing TaxPayersAndRates- Copy");
			Log.info("Executing  TaxPayersAndRates- Copy ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_TaxPayersAndRatesData;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String name= ExcelUtils.getCellData(count,1);
		    		String taxid=ExcelUtils.getCellData(count,2);
		    		
		    		String taxExemptionStartDate = ExcelUtils.getCellData(count,3);
		    		String taxExemptionEndDate= ExcelUtils.getCellData(count,4);
		    		String taxExemptionAmount= ExcelUtils.getCellData(count,5);
		    		
		    		String taxRateStartDate= ExcelUtils.getCellData(count,6);
		    		String taxRateEndDate= ExcelUtils.getCellData(count,7);
		    		String taxRatePercentage= ExcelUtils.getCellData(count,8);
		    		
		    		String claimType= ExcelUtils.getCellData(count,9);
		    		String serviceType= ExcelUtils.getCellData(count,10);
		    		
		    	
		    		String newName= ExcelUtils.getCellData(count, 11);
		    		String newTaxid= ExcelUtils.getCellData(count, 12);
		    		
		    		String editClaimType = ExcelUtils.getCellData(count, 13);
    				String editServiceType=	ExcelUtils.getCellData(count, 14);
		    				    				
		    		String subject= ExcelUtils.getCellData(count, 15);
		    		String type = ExcelUtils.getCellData(count, 16);
		    		String status = ExcelUtils.getCellData(count, 17);
		    		String priority = ExcelUtils.getCellData(count, 18);
		    		String followupDate = ExcelUtils.getCellData(count, 19);
		    		String noteType = ExcelUtils.getCellData(count, 20);
		    		String medium = ExcelUtils.getCellData(count, 21);
		    		String details = ExcelUtils.getCellData(count, 22);
		    						
		    					if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("TaxPayersAndRates Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("TaxPayersAndRates Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	copyTaxPayersAndRateMultiple(driver,taxid, name, newTaxid, newName);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void copyTaxPayersAndRateMultiple(WebDriver driver,String code, String name, String newTaxid, String newName) throws Exception
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
								
			//click providers
			HomePage homePageObject = new HomePage(driver);
			
			try{
				homePageObject.clickExitMyOpenCaseListing();
			}catch(Exception e)
			{ System.out.println("Blank Home Page");
			Log.info("log4j - msg -Blank Home Page");}
			
			homePageObject.clickProviders();	
			
			
			Thread.sleep(2000);
			
			//click TaxPayersAndRatess
			ProvidersPage providersPageObject = new ProvidersPage(driver);
			providersPageObject.clickOnTaxpayersAndRates();
			Thread.sleep(2000);
			
			//exit
			TaxPayerAndRateListingPage taxPayersAndRatesListingPageObject = new TaxPayerAndRateListingPage(driver);
			taxPayersAndRatesListingPageObject.copyTaxPayerAndRate( code, name, newTaxid, newName);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with TaxPayersAndRates-Copy  \n\n");
		if (fis != null) 
				fis.close();
	}
}
