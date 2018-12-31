package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.BatchClaimProcessingPage;
import com.pages.EDIPage;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CancelClaimsProcessingWithDisposition {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void CancelClaimsProcessingWithDispositionTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing  Cancel Claims processing with disposition");
			Log.info("Executing  cancel Claims Processing with disposition ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_BatchClaimsTestData;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String batchNo= ExcelUtils.getCellData(count,1);
		    		String disposition=ExcelUtils.getCellData(count,2);	
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Cancel claims processing with disposition- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Process claims processing with disposition- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	cancelClaimsWithDispositionMultiple(driver,disposition);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void cancelClaimsWithDispositionMultiple(WebDriver driver,String disposition) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("opened browser");
						
			//click network user
			LoginPage loginPageObject = new LoginPage(driver);
			loginPageObject.clickNetworkUser();
		
								
			//click EDI
			HomePage homePageObject = new HomePage(driver);
			homePageObject.clickEDI();	
			
			
			Thread.sleep(2000);
			
			//click BatchClaimsAdjudication
			EDIPage EDIPageObject = new EDIPage(driver);
			EDIPageObject.clickBatchClaimsAdjudication();
					
			Thread.sleep(2000);
			
			//Process with Batch number
			BatchClaimProcessingPage BatchClaimProcessingPageObject = new BatchClaimProcessingPage(driver);
			BatchClaimProcessingPageObject.dispositionCancel( disposition);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Cancel claims processing with given Disposition  \n\n");
		if (fis != null) 
				fis.close();
				
	}


}
