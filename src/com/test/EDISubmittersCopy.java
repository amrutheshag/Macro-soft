package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.EDIPage;
import com.pages.EDISubmitterListingPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class EDISubmittersCopy {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void EDISubmitterCopyTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing EDISubmitter- Copy");
			Log.info("Executing  EDISubmitter- Copy ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_EDISubmittersTestData;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String ediSubmitterName= ExcelUtils.getCellData(count,1);
		    		String ediSubmitterID=ExcelUtils.getCellData(count,2);	
		    		String definition= ExcelUtils.getCellData(count, 3);
		    		String mappingFormat= ExcelUtils.getCellData(count, 4);
		    		String splitServiceCode= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String subject= ExcelUtils.getCellData(count, 6);
		    						String noteType = ExcelUtils.getCellData(count, 7);
		    						String details = ExcelUtils.getCellData(count, 8);
		    						
		    						String newName = ExcelUtils.getCellData(count, 9);
		    						String newID = ExcelUtils.getCellData(count, 10);				
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("EDI SUbmitter Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("EDI Submitter Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	copyEDISubmitterMultiple(driver,ediSubmitterName, ediSubmitterID, newName, newID);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void copyEDISubmitterMultiple(WebDriver driver,String name, String id, String newName, String newID) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("opened browser");
						
			//click network user
			LoginPage loginPageObject = new LoginPage(driver);
			loginPageObject.clickNetworkUser();
								
		
			HomePage homePageObject = new HomePage(driver);
			homePageObject.clickEDI();	
			
			
			Thread.sleep(2000);
			
			//click BatchClaimsAdjudication
			EDIPage EDIPageObject = new EDIPage(driver);
			EDIPageObject.clickEDISubmitters();
					
			Thread.sleep(2000);
			
			//Copy EDI Submitters
			EDISubmitterListingPage EDISubmittersListingPageObject = new EDISubmitterListingPage(driver);
			EDISubmittersListingPageObject.copyEDISubmitter( name, id, newName, newID);
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with EDI Submitterss-Copy  \n\n");
		if (fis != null) 
				fis.close();
	}
}
