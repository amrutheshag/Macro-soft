package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.CarrierCoverageTypes;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CarrierCoverageTypesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void CarrierCoverageTypesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Carrier Coverage Types- Edit");
			Log.info("Executing  Carrier Coverage Types- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_CarrierCoverageTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String CarrierCoverageTypesCode= ExcelUtils.getCellData(count,1);
		    		String CarrierCoverageTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String CarrierCoverageTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String CarrierCoverageTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String CarrierCoverageTypesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String CarrierCoverageTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String CarrierCoverageTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String CarrierCoverageTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String CarrierCoverageTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Carrier Coverage Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Carrier Coverage Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editCarrierCoverageTypesMultiple(driver,CarrierCoverageTypesCode, CarrierCoverageTypesDescription, CarrierCoverageTypesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editCarrierCoverageTypesMultiple(WebDriver driver,String CarrierCoverageTypesCode, String CarrierCoverageTypesDescription, String CarrierCoverageTypesRecordMark) throws Exception
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
            homePageObject.clickPayersEmps();	
			
			
			Thread.sleep(2000);
			

			PayersPage payersPageObject = new PayersPage(driver);
			payersPageObject.clickOnCarrierCoverageTypes();
					
			CarrierCoverageTypes CarrierCoverageTypesPageObject = new CarrierCoverageTypes(driver);
			CarrierCoverageTypesPageObject.editCarrierCoverageTypes( CarrierCoverageTypesCode, CarrierCoverageTypesDescription, CarrierCoverageTypesRecordMark);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Carrier Coverage Types-Edit \n\n");
		if (fis != null) 
				fis.close();
				
	}
}


