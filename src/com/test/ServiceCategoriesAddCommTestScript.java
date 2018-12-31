package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ServiceCategories;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ServiceCategoriesAddCommTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void ServiceCategoriesAddCommTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Service Categories- Add Comm");
			Log.info("Executing  Service Categories- Add Comm ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_ServiceCategories;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String serviceCategoriesCode= ExcelUtils.getCellData(count,1);
		    		String serviceCategoriesDescription=ExcelUtils.getCellData(count,2);	
		    		String serviceCategoriesNewCode= ExcelUtils.getCellData(count, 3);
		    		String serviceCategoriesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String serviceCategoriesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String serviceCategoriesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String serviceCategoriesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String serviceCategoriesCommMedium = ExcelUtils.getCellData(count, 8);
		    						String serviceCategoriesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Service Categories Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Service Categories Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		   		 	addCommServiceCategoriesMultiple(driver, serviceCategoriesCode, serviceCategoriesDescription, serviceCategoriesCommSubject, serviceCategoriesCommNoteType, serviceCategoriesCommMedium, serviceCategoriesCommDetails);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addCommServiceCategoriesMultiple(WebDriver driver,String serviceCategoriesCode, String serviceCategoriesDescription, String serviceCategoriesCommSubject, String serviceCategoriesCommNoteType, String serviceCategoriesCommMedium, String serviceCategoriesCommDetails) throws Exception
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

			homePageObject.clickReferencegotoServiceCategories();	
			
			Thread.sleep(2000);
			
				ServiceCategories serviceCategoriesPageObject = new ServiceCategories(driver);
			serviceCategoriesPageObject.addCommServiceCategories( serviceCategoriesCode,  serviceCategoriesDescription,  serviceCategoriesCommSubject,  serviceCategoriesCommNoteType,  serviceCategoriesCommMedium,  serviceCategoriesCommDetails);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Service Categories-Add Comm  \n\n");
		Log.info("log4j-Done with Service Categories-Add Comm \n\n");
		if (fis != null) fis.close();
	}
}







