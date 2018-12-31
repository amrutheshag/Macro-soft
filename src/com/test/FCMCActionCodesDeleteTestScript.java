package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.FCMCActionCodes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class FCMCActionCodesDeleteTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void FCMCActionCodesDeleteTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing FCMC Action Codes- Delete");
			Log.info("Executing  FCMC Action Codes- Delete ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Delete_FCMCActionCodes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String fcmcactionCodesCode= ExcelUtils.getCellData(count,1);
		    		String fcmcactionCodesDescription=ExcelUtils.getCellData(count,2);	
		    		String fcmcactionCodesNewCode= ExcelUtils.getCellData(count, 3);
		    		String fcmcactionCodesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String fcmcactionCodesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String fcmcactionCodesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String fcmcactionCodesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String fcmcactionCodesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String fcmcactionCodesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("FCMC Action Codes Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("FCMC Action Codes Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	deleteFCMCActionCodesMultiple(driver,fcmcactionCodesCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void deleteFCMCActionCodesMultiple(WebDriver driver,String fcmcactionCodesCode) throws Exception
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

			homePageObject.clickReferencegotoFCMCActionCodes();	
			
			
			Thread.sleep(2000);
		
			FCMCActionCodes fcmcactionCodesPageObject = new FCMCActionCodes(driver);
			fcmcactionCodesPageObject.deleteFCMCActionCodes( fcmcactionCodesCode);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with FCMC Action Codes-Delete \n\n");
		if (fis != null) 
				fis.close();
			
	}
}



