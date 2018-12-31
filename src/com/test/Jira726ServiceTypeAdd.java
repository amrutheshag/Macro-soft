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

public class Jira726ServiceTypeAdd {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void FeeScheduleAddServiceQueryTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Fee Schedule- add- Add Service Query ");
			Log.info("Executing  Fee Schedule- add - Add Service Query ");
			
			
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
		    		String serviceModifier = ExcelUtils.getCellData(count, 14);
		    		String claimQueryName =  ExcelUtils.getCellData(count, 15);
		    		String serviceQueryName =  ExcelUtils.getCellData(count, 16);
		    		String claimRequired = ExcelUtils.getCellData(count, 17);
		    		String claimField = ExcelUtils.getCellData(count, 18);
		    		String claimRelates =  ExcelUtils.getCellData(count, 19);
		    		String claimToValues =  ExcelUtils.getCellData(count, 20);
		    		String claimIgnoreCase =  ExcelUtils.getCellData(count, 21);		    			
		    		String serviceRequired = ExcelUtils.getCellData(count, 22);
		    		String serviceField = ExcelUtils.getCellData(count, 23);
		    		String serviceRelates =  ExcelUtils.getCellData(count, 24);
		    		String serviceToValues =  ExcelUtils.getCellData(count, 25);
		    		String serviceIgnoreCase =  ExcelUtils.getCellData(count, 26);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Fee Schedule Add- Add Query- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Fee Schedule Add- Add Query -Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addFeeSchedulesAddServiceQueryMultiple(driver,code, name, serviceModifier, claimQueryName, serviceQueryName, claimRequired, claimField, claimRelates, claimToValues, claimIgnoreCase, serviceRequired, serviceField, serviceRelates, serviceToValues, serviceIgnoreCase);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addFeeSchedulesAddServiceQueryMultiple(WebDriver driver,String code, String name, String serviceModifier, String claimQueryName, String serviceQueryName, String claimRequired, String claimField, String claimRelates, String claimToValues, String claimIgnoreCase, String serviceRequired, String serviceField, String serviceRelates, String serviceToValues, String serviceIgnoreCase) throws Exception
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
			
			//add query
			FeeScheduleListingPage feeScheduleListingPageObject = new FeeScheduleListingPage(driver);
			feeScheduleListingPageObject.addServiceQueryFeeSchedules( code, name,serviceModifier, claimQueryName, serviceQueryName, claimRequired, claimField, claimRelates, claimToValues, claimIgnoreCase, serviceRequired, serviceField, serviceRelates, serviceToValues, serviceIgnoreCase);
			
			}
			@AfterMethod
      		public void afterMethod() throws Exception {
      		if (driver!=null) driver.quit();
      		System.out.println("Done with Add Service Query \n\n");
      		Log.info("log4j -Done with Add Service Query \n\n");
      		if (fis != null) 
      				fis.close();
      	}
}
