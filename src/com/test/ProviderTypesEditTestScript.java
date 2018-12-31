package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.ProviderTypes;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ProviderTypesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void ProviderTypesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Provider Types- Edit");
			Log.info("Executing  Provider Types- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_ProviderTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String providerTypesCode= ExcelUtils.getCellData(count,1);
		    		String providerTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String providerTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String providerTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String providerTypesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String providerTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String providerTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String providerTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String providerTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Provider Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Provider Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editProviderTypesMultiple(driver,providerTypesCode, providerTypesDescription, providerTypesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editProviderTypesMultiple(WebDriver driver,String ProviderTypesCode, String ProviderTypesDescription, String ProviderTypesRecordMark) throws Exception
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

			homePageObject.clickReferencegotoProviderTypes();	
			
			
			Thread.sleep(2000);
			
            
          	ProviderTypes providerTypesPageObject = new ProviderTypes(driver);
			providerTypesPageObject.editProviderTypes( ProviderTypesCode, ProviderTypesDescription, ProviderTypesRecordMark);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Provider Types-Edit \n\n");
		Log.info("log4j -Done with Provider Types-Edit \n\n");
		if (fis != null)	fis.close();
	}
}



