package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.FCMCActionCodes;
import com.pages.LoginPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class FCMCActionCodesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void FCMCActionCodesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing FCMC Action Codes- Edit");
			Log.info("Executing  FCMC Action Codes- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_FCMCActionCodes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String FCMCActionCodesCode= ExcelUtils.getCellData(count,1);
		    		String FCMCActionCodesDescription=ExcelUtils.getCellData(count,2);	
		    		String FCMCActionCodesNewCode= ExcelUtils.getCellData(count, 3);
		    		String FCMCActionCodesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String FCMCActionCodesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String FCMCActionCodesCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String FCMCActionCodesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String FCMCActionCodesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String FCMCActionCodesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("FCMC Action Codes Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("FCMC Action Codes Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editFCMCActionCodesMultiple(driver,FCMCActionCodesCode, FCMCActionCodesDescription, FCMCActionCodesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editFCMCActionCodesMultiple(WebDriver driver,String FCMCActionCodesCode, String FCMCActionCodesDescription, String FCMCActionCodesRecordMark) throws Exception
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
			
			
	
			FCMCActionCodes FCMCActionCodesPageObject = new FCMCActionCodes(driver);
			FCMCActionCodesPageObject.editFCMCActionCodes(FCMCActionCodesCode, FCMCActionCodesDescription, FCMCActionCodesRecordMark);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with FCMC Action Codes-Edit \n\n");
		if (fis != null) 
				fis.close();
	}
}


