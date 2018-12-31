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

public class CarriersDeleteTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void CarriersDeleteTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Carriers- Delete");
			Log.info("Executing  Carriers- Delete ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Delete_Carriers;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String carriersCode= ExcelUtils.getCellData(count,1);
		    		String carriersDescription=ExcelUtils.getCellData(count,2);	
		    		String carriersNewCode= ExcelUtils.getCellData(count, 3);
		    		String carriersNewDescription= ExcelUtils.getCellData(count, 4);
		    		String carriersEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String carriersCommSubject= ExcelUtils.getCellData(count, 6);
		    						String carriersCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String carriersCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String carriersCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Carriers Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Carriers Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	deleteCarriersMultiple(driver,carriersCode, carriersDescription);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void deleteCarriersMultiple(WebDriver driver,String carriersCode, String carriersDescription) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			
						
			//click network user
			LoginPage loginPageObject = new LoginPage(driver);
			loginPageObject.clickNetworkUser();
			
			//click Payers-Emps
			HomePage homePageObject = new HomePage(driver);
			try{  homePageObject.clickExitMyOpenCaseListing();   }
	         catch(Exception e){ 	System.out.println("Blank Home Page");  Log.info("log4j - msg -Blank Home Page");   }
			homePageObject.clickPayersEmps();	
			
			
			Thread.sleep(2000);
			
		
			PayersPage payersPageObject = new PayersPage(driver);
			payersPageObject.clickOnCarriers();
					
			Thread.sleep(2000);
			
		
			Carriers carriersPageObject = new Carriers(driver);
			carriersPageObject.deleteCarriers( carriersCode, carriersDescription);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Carriers-Delete \n\n");
		if (fis != null)
				fis.close();
				
	}
}
