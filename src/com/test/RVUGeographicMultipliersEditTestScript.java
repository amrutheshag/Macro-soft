package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.RVUGeographicMultipliers;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class RVUGeographicMultipliersEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void RVUGeographicMultipliersEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing RVU Geographic Multipliers- Edit");
			Log.info("Executing  RVU Geographic Multipliers- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_RVUGeographicMultipliers;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String rvugeographicMultipliersCode= ExcelUtils.getCellData(count,1);
		    		String rvugeographicMultipliersDescription=ExcelUtils.getCellData(count,2);	
		    		String rvugeographicMultipliersNewCode= ExcelUtils.getCellData(count, 3);
		    		String rvugeographicMultipliersNewDescription= ExcelUtils.getCellData(count, 4);
		    		String rvugeographicMultipliersRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String rvugeographicMultipliersCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String rvugeographicMultipliersCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String rvugeographicMultipliersCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String rvugeographicMultipliersCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("RVU Geographic Multipliers Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("RVU Geographic Multipliers Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editRVUGeographicMultipliersMultiple(driver,rvugeographicMultipliersCode, rvugeographicMultipliersDescription, rvugeographicMultipliersRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editRVUGeographicMultipliersMultiple(WebDriver driver,String RVUGeographicMultipliersCode, String RVUGeographicMultipliersDescription, String RVUGeographicMultipliersRecordMark) throws Exception
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

			homePageObject.clickReferencegotoRVUGeographicMultipliers();	
			
			
			Thread.sleep(2000);
			
           	RVUGeographicMultipliers rvugeographicMultipliersPageObject = new RVUGeographicMultipliers(driver);
			rvugeographicMultipliersPageObject.editRVUGeographicMultipliers(RVUGeographicMultipliersCode, RVUGeographicMultipliersDescription, RVUGeographicMultipliersRecordMark);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with RVU Geographic Multipliers-Edit \n\n");
		Log.info("log4j-Done with RVU Geographic Multipliers-Edit \n\n");
		if (fis != null)
				fis.close();
	}
}



