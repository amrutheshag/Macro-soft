package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.AdjustmentTypes;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class AdjustmentTypesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void AdjustmentTypesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Adjustment Types- Edit");
			Log.info("Executing  Adjustment Types- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_AdjustmentTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String AdjustmentTypesCode= ExcelUtils.getCellData(count,1);
		    		String AdjustmentTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String AdjustmentTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String AdjustmentTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String AdjustmentTypesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Adjustment Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Adjustment Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editAdjustmentTypesMultiple(driver,AdjustmentTypesCode, AdjustmentTypesDescription, AdjustmentTypesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editAdjustmentTypesMultiple(WebDriver driver,String AdjustmentTypesCode, String AdjustmentTypesDescription, String AdjustmentTypesRecordMark) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("Browser Launched");
						
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

			homePageObject.clickReferencegotoAdjustmentTypes();	
			
			
			
				AdjustmentTypes AdjustmentTypesPageObject = new AdjustmentTypes(driver);
			AdjustmentTypesPageObject.editAdjustmentTypes( AdjustmentTypesCode, AdjustmentTypesDescription, AdjustmentTypesRecordMark);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Adjustment Types-Edit \n\n");
		Log.info("Done with Adjustment Types-Edit \n\n");
		if (fis != null) 
				fis.close();
				
	}
}


