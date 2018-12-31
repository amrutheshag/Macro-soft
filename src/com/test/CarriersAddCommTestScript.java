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

public class CarriersAddCommTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void CarriersAddCommTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Carriers- Add Comm");
			Log.info("Executing  Carriers- Add Comm ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_Carriers;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String CarriersCode= ExcelUtils.getCellData(count,1);
		    		String CarriersDescription=ExcelUtils.getCellData(count,2);	
		    		String CarriersNewCode= ExcelUtils.getCellData(count, 3);
		    		String CarriersNewDescription= ExcelUtils.getCellData(count, 4);
		    		String CarriersEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String CarriersCommSubject= ExcelUtils.getCellData(count, 6);
		    						String CarriersCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String CarriersCommMedium = ExcelUtils.getCellData(count, 8);
		    						String CarriersCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Carriers Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Carriers Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addCommCarriersMultiple(driver, CarriersCode, CarriersDescription, CarriersCommSubject, CarriersCommNoteType, CarriersCommMedium, CarriersCommDetails);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addCommCarriersMultiple(WebDriver driver,String CarriersCode, String CarriersDescription, String CarriersCommSubject, String CarriersCommNoteType, String CarriersCommMedium, String CarriersCommDetails) throws Exception
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
			 try{  homePageObject.clickExitMyOpenCaseListing();   }
	         catch(Exception e){ 	System.out.println("Blank Home Page");  Log.info("log4j - msg -Blank Home Page");   }
			homePageObject.clickPayersEmps();	
			
			
			Thread.sleep(2000);
			
			PayersPage payersPageObject = new PayersPage(driver);
			payersPageObject.clickOnCarriers();
					
			Thread.sleep(2000);
			
			Carriers CarriersPageObject = new Carriers(driver);
			CarriersPageObject.addCommCarriers(  CarriersCode,  CarriersDescription,  CarriersCommSubject,  CarriersCommNoteType,  CarriersCommMedium,  CarriersCommDetails);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Carriers-Add Comm  \n\n");
		if (fis != null)
				fis.close();
				
	}
}



