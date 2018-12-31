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

public class EDISubmittersExit {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void EDISubmitterExitTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing EDISubmitter- Exit");
			Log.info("Executing  EDISubmitter- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_EDISubmittersTestData;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String ediSubmitterName= ExcelUtils.getCellData(count,1);
		    		String ediSubmitterID=ExcelUtils.getCellData(count,2);	
		    		String ediSubmitterDefinition= ExcelUtils.getCellData(count, 3);
		    		String ediSubmitterMappingFormat= ExcelUtils.getCellData(count, 4);
		    		String ediSubmitterSplitServiceCode= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String employerGroupsCommSubject= ExcelUtils.getCellData(count, 6);
		    						String employerGroupsCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String employerGroupsCommDetails = ExcelUtils.getCellData(count, 8);
		    						
		    						String newName = ExcelUtils.getCellData(count, 9);
		    						String newID = ExcelUtils.getCellData(count, 10);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("EDI SUbmitter Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("EDI Submitter Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitEDISubmitterMultiple(driver,ediSubmitterName, ediSubmitterID);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitEDISubmitterMultiple(WebDriver driver,String name, String id) throws Exception
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
			homePageObject.clickEDI();	
			
			
			Thread.sleep(2000);
			
			//click BatchClaimsAdjudication
			EDIPage EDIPageObject = new EDIPage(driver);
			EDIPageObject.clickEDISubmitters();
					
			Thread.sleep(2000);
			
			//Exit EDI Submitters
			EDISubmitterListingPage EDISubmittersListingPageObject = new EDISubmitterListingPage(driver);
			EDISubmittersListingPageObject.exitEDISubmitter( name, id);
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with EDI Submitterss-Exit  \n\n");
		Log.info ("Done with EDI Submitterss-Exit  \n\n");
		if (fis != null)
				fis.close();
	}
}
