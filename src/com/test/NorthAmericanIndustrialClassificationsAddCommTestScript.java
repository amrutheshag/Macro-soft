package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.NorthAmericanIndustrialClassifications;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class NorthAmericanIndustrialClassificationsAddCommTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void NorthAmericanIndustrialClassificationsAddCommTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing North American Industrial Classifications- Add Comm");
			Log.info("Executing  North American Industrial Classifications- Add Comm ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_NorthAmericanIndustrialClassifications;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String northamericanindustrialClassificationsCode= ExcelUtils.getCellData(count,1);
		    		String northamericanindustrialClassificationsDescription=ExcelUtils.getCellData(count,2);	
		    		String northamericanindustrialClassificationsNewCode= ExcelUtils.getCellData(count, 3);
		    		String northamericanindustrialClassificationsNewDescription= ExcelUtils.getCellData(count, 4);
		    		String northamericanindustrialClassificationsEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String northamericanindustrialClassificationsCommSubject= ExcelUtils.getCellData(count, 6);
		    						String northamericanindustrialClassificationsCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String northamericanindustrialClassificationsCommMedium = ExcelUtils.getCellData(count, 8);
		    						String northamericanindustrialClassificationsCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("North American Industrial Classifications Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("North American Industrial Classifications Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addCommNorthAmericanIndustrialClassificationsMultiple(driver, northamericanindustrialClassificationsCode, northamericanindustrialClassificationsDescription, northamericanindustrialClassificationsCommSubject, northamericanindustrialClassificationsCommNoteType, northamericanindustrialClassificationsCommMedium, northamericanindustrialClassificationsCommDetails);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addCommNorthAmericanIndustrialClassificationsMultiple(WebDriver driver,String northamericanindustrialClassificationsCode, String northamericanindustrialClassificationsDescription, String northamericanindustrialClassificationsCommSubject, String northamericanindustrialClassificationsCommNoteType, String northamericanindustrialClassificationsCommMedium, String northamericanindustrialClassificationsCommDetails) throws Exception
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
			homePageObject.clickPayersEmps();	
			
			
			Thread.sleep(2000);
			
	
			PayersPage payersPageObject = new PayersPage(driver);
			payersPageObject.clickOnNorthAmericanIndustrialClassifications();
					
			Thread.sleep(2000);
			

			NorthAmericanIndustrialClassifications northamericanindustrialClassificationsPageObject = new NorthAmericanIndustrialClassifications(driver);
			northamericanindustrialClassificationsPageObject.addCommNorthAmericanIndustrialClassifications(  northamericanindustrialClassificationsCode,  northamericanindustrialClassificationsDescription,  northamericanindustrialClassificationsCommSubject,  northamericanindustrialClassificationsCommNoteType,  northamericanindustrialClassificationsCommMedium,  northamericanindustrialClassificationsCommDetails);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with North American Industrial Classifications-Add Comm  \n\n");
		if (fis != null)
				fis.close();
	}
}



