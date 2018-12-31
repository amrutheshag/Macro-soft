package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.PayerTypes;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class PayerTypesDeleteTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void PayerTypesDeleteTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Payer Types- Delete");
			Log.info("Executing  Payer Types- Delete ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Delete_PayerTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String payerTypesCode= ExcelUtils.getCellData(count,1);
		    		String payerTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String payerTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String payerTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String payerTypesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String payerTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String payerTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String payerTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String payerTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Payer Types Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Payer Types Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	deletePayerTypesMultiple(driver,payerTypesCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void deletePayerTypesMultiple(WebDriver driver,String payerTypesCode) throws Exception
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
								
			HomePage homePageObject = new HomePage(driver);
            try{
                homePageObject.clickExitMyOpenCaseListing();
           }
            catch(Exception e){ 
            	System.out.println("Blank Home Page");
          	Log.info("log4j - msg -Blank Home Page");
            }

			homePageObject.clickReferencegotoPayerTypes();	
			
			
			Thread.sleep(2000);
			PayerTypes payerTypesPageObject = new PayerTypes(driver);
			payerTypesPageObject.deletePayerTypes( payerTypesCode);
			
			}

			   @AfterMethod
         		public void afterMethod() throws Exception {
         		if (driver!=null) driver.quit();
         		System.out.println("Done with Payer Types-Delete \n\n");
         		Log.info("Done with Payer Types-Delete \n\n");
         		if (fis != null)	fis.close();
         	}
         }


