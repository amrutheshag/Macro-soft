package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.UMCaseStatusCodes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class UMCaseStatusCodesAddCommTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void UMCaseStatusCodesAddCommTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing UM Case Status Codes- Add Comm");
			Log.info("Executing  UM Case Status Codes- Add Comm ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_UMCaseStatusCodes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String umcasestatusCodesCode= ExcelUtils.getCellData(count,1);
		    		String umcasestatusCodesDescription=ExcelUtils.getCellData(count,2);	
		    		String umcasestatusCodesNewCode= ExcelUtils.getCellData(count, 3);
		    		String umcasestatusCodesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String umcasestatusCodesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String umcasestatusCodesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String umcasestatusCodesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String umcasestatusCodesCommMedium = ExcelUtils.getCellData(count, 8);
		    						String umcasestatusCodesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("UM Case Status Codes Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("UM Case Status Codes Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addCommUMCaseStatusCodesMultiple(driver, umcasestatusCodesCode, umcasestatusCodesDescription, umcasestatusCodesCommSubject, umcasestatusCodesCommNoteType, umcasestatusCodesCommMedium, umcasestatusCodesCommDetails);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addCommUMCaseStatusCodesMultiple(WebDriver driver,String umcasestatusCodesCode, String umcasestatusCodesDescription, String umcasestatusCodesCommSubject, String umcasestatusCodesCommNoteType, String umcasestatusCodesCommMedium, String umcasestatusCodesCommDetails) throws Exception
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
           }
			catch(Exception e){ 
				System.out.println("Blank Home Page");
				Log.info("log4j - msg -Blank Home Page");
			}

			homePageObject.clickReferencegotoUMCaseStatusCodes();	
			
			Thread.sleep(2000);
			
			UMCaseStatusCodes umcasestatusCodesPageObject = new UMCaseStatusCodes(driver);
			umcasestatusCodesPageObject.addCommUMCaseStatusCodes(  umcasestatusCodesCode,  umcasestatusCodesDescription,  umcasestatusCodesCommSubject,  umcasestatusCodesCommNoteType,  umcasestatusCodesCommMedium,  umcasestatusCodesCommDetails);
			
			}

			   @AfterMethod
        		public void afterMethod() throws Exception {
        		if (driver!=null) driver.quit();
        		System.out.println("Done with UM Case Status Codes-Add Comm \n\n");
        		Log.info("log4j-Done with UM Case Status Codes-Add Comm \n\n");
        		if (fis != null) 
        				fis.close();
        	}
        }







