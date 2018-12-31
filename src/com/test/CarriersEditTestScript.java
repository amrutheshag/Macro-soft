package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.Carriers;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CarriersEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void CarriersEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Carriers- Edit");
			Log.info("Executing  Carriers- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_Carriers;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String carriersCode= ExcelUtils.getCellData(count,1);
		    		String carriersDescription=ExcelUtils.getCellData(count,2);	
		    		String carriersNewCode= ExcelUtils.getCellData(count, 3);
		    		String carriersNewDescription= ExcelUtils.getCellData(count, 4);
		    		String carriersPhoneNumber= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String carriersCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String carriersCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String carriersCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String carriersCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Carriers Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Carriers Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editCarriersMultiple(driver,carriersCode, carriersDescription, carriersPhoneNumber);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editCarriersMultiple(WebDriver driver,String carriersCode, String carriersDescription, String carriersPhoneNumber) throws Exception
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
			try{  homePageObject.clickExitMyOpenCaseListing();   }
	         catch(Exception e){ 	System.out.println("Blank Home Page");  Log.info("log4j - msg -Blank Home Page");   }
			homePageObject.clickPayersEmps();	
			
			
			Thread.sleep(2000);
			
			//click Tier Copay Schedules
			PayersPage payersPageObject = new PayersPage(driver);
			payersPageObject.clickOnCarriers();
					
			Thread.sleep(2000);
			
			//add new Tier Copay Schedule
			Carriers carriersPageObject = new Carriers(driver);
			carriersPageObject.editCarriers( carriersCode, carriersDescription, carriersPhoneNumber);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Carriers-Edit \n\n");
		if (fis != null) 
				fis.close();
			
	}
}

