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

public class CarrierCoverageTypesAddComm {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void CarrierCoverageTypesAddCommTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Carrier Coverage Types- Add Comm");
			Log.info("Executing  Carrier Coverage Types- Add Comm ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_CarrierCoverageTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String carriercoverageTypesCode= ExcelUtils.getCellData(count,1);
		    		String carriercoverageTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String carriercoverageTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String carriercoverageTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String carriercoverageTypesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String carriercoverageTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String carriercoverageTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String carriercoverageTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String carriercoverageTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Carrier Coverage Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Carrier Coverage Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addCommCarrierCoverageTypesMultiple(driver,carriercoverageTypesCode, carriercoverageTypesCommSubject, carriercoverageTypesCommNoteType, carriercoverageTypesCommNoteMedium, carriercoverageTypesCommDetails);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addCommCarrierCoverageTypesMultiple(WebDriver driver,String carriercoverageTypesCode, String carriercoverageTypesSubject, String carriercoverageTypesNoteType, String carriercoverageTypesMedium, String carriercoverageTypesNotes) throws Exception
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

			homePageObject.clickPayersEmps();	
			
			
			Thread.sleep(2000);
			
			
			PayersPage payersPageObject = new PayersPage(driver);
			payersPageObject.clickOnCarrierCoverageTypes();
					
			Thread.sleep(2000);
			
		
			CarrierCoverageTypes carriercoverageTypesPageObject = new CarrierCoverageTypes(driver);
			carriercoverageTypesPageObject.addCommCarrierCoverageTypes( carriercoverageTypesCode, carriercoverageTypesSubject, carriercoverageTypesNoteType, carriercoverageTypesMedium, carriercoverageTypesNotes);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Carrier Coverage Types-Add Comm  \n\n");
		if (fis != null)
				fis.close();
				
	}
}

