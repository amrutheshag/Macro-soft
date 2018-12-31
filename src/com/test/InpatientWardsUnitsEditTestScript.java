package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.InpatientWardsUnits;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class InpatientWardsUnitsEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void InpatientWardsUnitsEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Inpatient Wards/Units- Edit");
			Log.info("Executing  Inpatient Wards/Units- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_InpatientWardsUnits;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String InpatientWardsUnitsCode= ExcelUtils.getCellData(count,1);
		    		String InpatientWardsUnitsDescription=ExcelUtils.getCellData(count,2);	
		    		String InpatientWardsUnitsNewCode= ExcelUtils.getCellData(count, 3);
		    		String InpatientWardsUnitsNewDescription= ExcelUtils.getCellData(count, 4);
		    		String InpatientWardsUnitsRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String InpatientWardsUnitsCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String InpatientWardsUnitsCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String InpatientWardsUnitsCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String InpatientWardsUnitsCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Inpatient Wards/Units Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Inpatient Wards/Units Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editInpatientWardsUnitsMultiple(driver,InpatientWardsUnitsCode, InpatientWardsUnitsDescription, InpatientWardsUnitsRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editInpatientWardsUnitsMultiple(WebDriver driver,String InpatientWardsUnitsCode, String InpatientWardsUnitsDescription, String InpatientWardsUnitsRecordMark) throws Exception
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

			homePageObject.clickReferencegotoInpatientWardsUnits();	
			InpatientWardsUnits InpatientWardsUnitsPageObject = new InpatientWardsUnits(driver);
			InpatientWardsUnitsPageObject.editInpatientWardsUnits(InpatientWardsUnitsCode, InpatientWardsUnitsDescription, InpatientWardsUnitsRecordMark);
			
			}

		       @AfterMethod
	      		public void afterMethod() throws Exception {
	      		if (driver!=null) driver.quit();
	      		System.out.println("Done with Inpatient Wards/Units-Edit \n\n");
	      		Log.info("log4j -Done with Inpatient Wards/Units-Edit \n\n");
	      		if (fis != null)
	      				fis.close();
	      	}
	      }


