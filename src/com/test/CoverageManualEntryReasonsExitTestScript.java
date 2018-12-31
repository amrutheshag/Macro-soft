package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.CoverageManualEntryReasons;
import com.pages.HomePage;
import com.pages.LoginPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CoverageManualEntryReasonsExitTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void CoverageManualEntryReasonsExitTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Coverage Manual Entry Reasons- Exit");
			Log.info("Executing  Coverage Manual Entry Reasons- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_CoverageManualEntryReasons;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String coveragemanualentryReasonsCode= ExcelUtils.getCellData(count,1);
		    		String coveragemanualentryReasonsDescription=ExcelUtils.getCellData(count,2);	
		    		String coveragemanualentryReasonsNewCode= ExcelUtils.getCellData(count, 3);
		    		String coveragemanualentryReasonsNewDescription= ExcelUtils.getCellData(count, 4);
		    		String coveragemanualentryReasonsEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String coveragemanualentryReasonsCommSubject= ExcelUtils.getCellData(count, 6);
		    						String coveragemanualentryReasonsCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String coveragemanualentryReasonsCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String coveragemanualentryReasonsCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Coverage Manual Entry Reasons Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Coverage Manual Entry Reasons Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitcoveragemanualentryReasonsMultiple(driver,coveragemanualentryReasonsCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitcoveragemanualentryReasonsMultiple(WebDriver driver,String coveragemanualentryReasonsCode) throws Exception
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
            try{
                homePageObject.clickExitMyOpenCaseListing();
           }
            catch(Exception e){ 
            	System.out.println("Blank Home Page");
           Log.info("log4j - msg -Blank Home Page");
            }

			homePageObject.clickReferencegotoCoverageManualEntryReasons();	
			
			
			Thread.sleep(2000);
			
			CoverageManualEntryReasons coveragemanualentryReasonsPageObject = new CoverageManualEntryReasons(driver);
			coveragemanualentryReasonsPageObject.exitCoverageManualEntryReasons( coveragemanualentryReasonsCode);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Coverage Manual Entry Reasons-Exit  \n\n");
		if (fis != null) 
				fis.close();
				
	}
}

