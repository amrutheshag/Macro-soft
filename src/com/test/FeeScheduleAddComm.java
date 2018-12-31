package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.FeeScheduleListingPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProvidersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class FeeScheduleAddComm {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void FeeScheduleAddCommTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Fee Schedule- add comm");
			Log.info("Executing  Fee Schedule- add comm ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_FeeSchedulesData;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String code= ExcelUtils.getCellData(count,1);
		    		String name=ExcelUtils.getCellData(count,2);	
		    		String newCode= ExcelUtils.getCellData(count, 3);
		    		String newName= ExcelUtils.getCellData(count, 4);
		    		String editNotes= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String subject= ExcelUtils.getCellData(count, 6);
		    						String type = ExcelUtils.getCellData(count, 7);
		    						String status = ExcelUtils.getCellData(count, 8);
		    						String priority = ExcelUtils.getCellData(count, 9);
		    						String followupDate = ExcelUtils.getCellData(count, 10);
		    						String noteType = ExcelUtils.getCellData(count, 11);
		    						String medium = ExcelUtils.getCellData(count, 12);
		    						String details = ExcelUtils.getCellData(count, 13);
		    						
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Fee Schedule Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Fee Schedule Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addCommFeeSchedulesMultiple(driver,code, name, subject, type, followupDate, priority, noteType, medium, details);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addCommFeeSchedulesMultiple(WebDriver driver,String code, String name, String subject, String type, String followupDate, String priority, String notetype, String medium, String details) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("opened browser");
						
			//click network user
			LoginPage loginPageObject = new LoginPage(driver);
			loginPageObject.clickNetworkUser();
								
			//click providers
			HomePage homePageObject = new HomePage(driver);
			
			try{
				homePageObject.clickExitMyOpenCaseListing();
			}catch(Exception e)
			{ System.out.println("Blank Home Page");
			Log.info("log4j - msg -Blank Home Page");}
			
			homePageObject.clickProviders();	
			
			
			Thread.sleep(2000);
			
			//click fee schedules
			ProvidersPage providersPageObject = new ProvidersPage(driver);
			providersPageObject.clickOnFeeSchedules();
			Thread.sleep(2000);
			
			//add Comm
			FeeScheduleListingPage feeScheduleListingPageObject = new FeeScheduleListingPage(driver);
			feeScheduleListingPageObject.addCommFeeSchedule(code, name, subject, type, followupDate, priority, notetype, medium, details);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Fee Schedules-Add Comm \n\n");
		if (fis != null) 
				fis.close();
	}
}
