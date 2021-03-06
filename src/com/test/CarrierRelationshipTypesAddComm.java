package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.CarrierRelationshipTypes;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CarrierRelationshipTypesAddComm {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void CarrierRelationshipTypesAddCommTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Carrier Relationship Types- Add Comm");
			Log.info("Executing  Carrier Relationship Types- Add Comm ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_CarrierRelationshipTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String carrierrelationshipTypesCode= ExcelUtils.getCellData(count,1);
		    		String carrierrelationshipTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String carrierrelationshipTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String carrierrelationshipTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String carrierrelationshipTypesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String carrierrelationshipTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String carrierrelationshipTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String carrierrelationshipTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String carrierrelationshipTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Carrier Relationship Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Carrier Relationship Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addCommCarrierRelationshipTypesMultiple(driver,carrierrelationshipTypesCode, carrierrelationshipTypesCommSubject, carrierrelationshipTypesCommNoteType, carrierrelationshipTypesCommNoteMedium, carrierrelationshipTypesCommDetails);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addCommCarrierRelationshipTypesMultiple(WebDriver driver,String carrierrelationshipTypesCode, String carrierrelationshipTypesSubject, String carrierrelationshipTypesNoteType, String carrierrelationshipTypesMedium, String carrierrelationshipTypesNotes) throws Exception
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
			payersPageObject.clickOnCarrierRelationshipTypes();
					
			Thread.sleep(2000);
			
		
			CarrierRelationshipTypes carrierrelationshipTypesPageObject = new CarrierRelationshipTypes(driver);
			carrierrelationshipTypesPageObject.addCommCarrierRelationshipTypes( carrierrelationshipTypesCode, carrierrelationshipTypesSubject, carrierrelationshipTypesNoteType, carrierrelationshipTypesMedium, carrierrelationshipTypesNotes);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Carrier Relationship Types-Add Comm  \n\n");
		if (fis != null) 
				fis.close();
				
	}
}


