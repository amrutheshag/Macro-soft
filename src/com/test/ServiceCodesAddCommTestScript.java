package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.ServiceCodes;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ServiceCodesAddCommTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void ServiceCodesAddCommTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Service Codes- Add Comm");
			Log.info("Executing  Service Codes- Add Comm ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_ServiceCodes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String serviceCodesCode= ExcelUtils.getCellData(count,1);
		    		String serviceCodesDescription=ExcelUtils.getCellData(count,2);	
		    		String serviceCodesNewCode= ExcelUtils.getCellData(count, 3);
		    		String serviceCodesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String serviceCodesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String serviceCodesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String serviceCodesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String serviceCodesCommMedium = ExcelUtils.getCellData(count, 8);
		    						String serviceCodesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Service Codes Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Service Codes Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addCommServiceCodesMultiple(driver, serviceCodesCode, serviceCodesDescription, serviceCodesCommSubject, serviceCodesCommNoteType, serviceCodesCommMedium, serviceCodesCommDetails);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addCommServiceCodesMultiple(WebDriver driver,String serviceCodesCode, String serviceCodesDescription, String serviceCodesCommSubject, String serviceCodesCommNoteType, String serviceCodesCommMedium, String serviceCodesCommDetails) throws Exception
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

			homePageObject.clickReferencegotoServiceCodes();	
			
			Thread.sleep(2000);
			ServiceCodes serviceCodesPageObject = new ServiceCodes(driver);
			serviceCodesPageObject.addCommServiceCodes( serviceCodesCode,  serviceCodesDescription,  serviceCodesCommSubject,  serviceCodesCommNoteType,  serviceCodesCommMedium,  serviceCodesCommDetails);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Service Codes-Add Comm  \n\n");
		if (fis != null) 
				fis.close();
	}
}








