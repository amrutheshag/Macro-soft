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

public class FCMCConsenterTypesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void FCMCConsenterTypesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing FCMC Consenter Types- Edit");
			Log.info("Executing  FCMC Consenter Types- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_FCMCConsenterTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String FCMCConsenterTypesCode= ExcelUtils.getCellData(count,1);
		    		String FCMCConsenterTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String FCMCConsenterTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String FCMCConsenterTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String FCMCConsenterTypesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String FCMCConsenterTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String FCMCConsenterTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String FCMCConsenterTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String FCMCConsenterTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("FCMC Consenter Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("FCMC Consenter Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editFCMCConsenterTypesMultiple(driver,FCMCConsenterTypesCode, FCMCConsenterTypesDescription, FCMCConsenterTypesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editFCMCConsenterTypesMultiple(WebDriver driver,String FCMCConsenterTypesCode, String FCMCConsenterTypesDescription, String FCMCConsenterTypesRecordMark) throws Exception
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
			
			
		
			FCMCConsenterTypes FCMCConsenterTypesPageObject = new FCMCConsenterTypes(driver);
			FCMCConsenterTypesPageObject.editFCMCConsenterTypes(FCMCConsenterTypesCode, FCMCConsenterTypesDescription, FCMCConsenterTypesRecordMark);
			
			}

			  @AfterMethod
      		public void afterMethod() throws Exception {
      		if (driver!=null) driver.quit();
      		System.out.println("Done with FCMC Consenter Types-Edit  \n\n");
      		Log.info("log4j -Done with FCMC Consenter Types-Edit  \n\n");
      		if (fis != null) 
      				fis.close();
      	}
      }


