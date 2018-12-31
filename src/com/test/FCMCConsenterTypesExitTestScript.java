package com.test;

import java.io.FileInputStream;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.FCMCConsenterTypes;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class FCMCConsenterTypesExitTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void FCMCConsenterTypesExitTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing FCMC Consenter Types- Exit");
			Log.info("Executing  FCMC Consenter Types- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_FCMCConsenterTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String fcmcconsenterTypesCode= ExcelUtils.getCellData(count,1);
		    		String fcmcconsenterTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String fcmcconsenterTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String fcmcconsenterTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String fcmcconsenterTypesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String fcmcconsenterTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String fcmcconsenterTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String fcmcconsenterTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String fcmcconsenterTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("FCMC Consenter Types Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("FCMC Consenter Types Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitfcmcconsenterTypesMultiple(driver,fcmcconsenterTypesCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitfcmcconsenterTypesMultiple(WebDriver driver,String fcmcconsenterTypesCode) throws Exception
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

			homePageObject.clickReferencegotoFCMCConsenterTypes();	
			
			
			Thread.sleep(2000);
	
			FCMCConsenterTypes fcmcconsenterTypesPageObject = new FCMCConsenterTypes(driver);
			fcmcconsenterTypesPageObject.exitFCMCConsenterTypes(fcmcconsenterTypesCode);
			
			}

			  @AfterMethod
      		public void afterMethod() throws Exception {
      		if (driver!=null) driver.quit();
      		if (fis != null)	fis.close();
      		System.out.println("Done with FCMC Consenter Types-Edit  \n\n");
      		Log.info("log4j -Done with FCMC Consenter Types-Edit  \n\n");
      	}
      }







