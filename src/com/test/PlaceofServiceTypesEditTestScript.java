package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PlaceofServiceTypes;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class PlaceofServiceTypesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void PlaceofServiceTypesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Place of Service Types- Edit");
			Log.info("Executing  Place of Service Types- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_PlaceofServiceTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String placeofserviceTypesCode= ExcelUtils.getCellData(count,1);
		    		String placeofserviceTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String placeofserviceTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String placeofserviceTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String placeofserviceTypesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String placeofserviceTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String placeofserviceTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String placeofserviceTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String placeofserviceTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Place of Service Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Place of Service Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editPlaceofServiceTypesMultiple(driver,placeofserviceTypesCode, placeofserviceTypesDescription, placeofserviceTypesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editPlaceofServiceTypesMultiple(WebDriver driver,String PlaceofServiceTypesCode, String PlaceofServiceTypesDescription, String PlaceofServiceTypesRecordMark) throws Exception
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
								
			//click Payers-Emps
			HomePage homePageObject = new HomePage(driver);
			try{
                homePageObject.clickExitMyOpenCaseListing();
           }
			catch(Exception e){ 
				System.out.println("Blank Home Page");
				Log.info("log4j - msg -Blank Home Page");
			}

			homePageObject.clickReferencegotoPlaceofServiceTypes();	
			
			
			Thread.sleep(2000);
			
            
        	PlaceofServiceTypes placeofserviceTypesPageObject = new PlaceofServiceTypes(driver);
			placeofserviceTypesPageObject.editPlaceofServiceTypes(PlaceofServiceTypesCode, PlaceofServiceTypesDescription, PlaceofServiceTypesRecordMark);
			
			}

			@AfterMethod
     		public void afterMethod() throws Exception {
     		if (driver!=null) driver.quit();
     		System.out.println("Done with Place of Service Types-Edit \n\n");
     		Log.info("log4j -Done with Place of Service Types-Edit \n\n");
     		if (fis != null) 	fis.close();
     	}
     }





