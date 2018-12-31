package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProviderTypes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ModifiersExitTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void ProviderTypesExitTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Modifiers- Exit");
			Log.info("Executing  Modifiers- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_ProviderTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String ModifiersCode= ExcelUtils.getCellData(count,1);
		    		String ModifiersDescription=ExcelUtils.getCellData(count,2);	
		    		String ModifiersNewCode= ExcelUtils.getCellData(count, 3);
		    		String ModifiersNewDescription= ExcelUtils.getCellData(count, 4);
		    		String ModifiersEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String ModifiersCommSubject= ExcelUtils.getCellData(count, 6);
		    						String ModifiersCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String ModifiersCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String ModifiersCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Modifiers Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Modifiers Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitProviderTypesMultiple(driver,ModifiersCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitProviderTypesMultiple(WebDriver driver,String ModifiersCode) throws Exception
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

			homePageObject.clickReferencegotoProviderTypes();
			
			
			Thread.sleep(2000);
			
           	ProviderTypes ModifiersPageObject = new ProviderTypes(driver);
			ModifiersPageObject.exitProviderTypes( ModifiersCode);
			
			}

			 @AfterMethod
	      		public void afterMethod() throws Exception {
	      		if (driver!=null) driver.quit();
	      		System.out.println("Done with Modifiers-Exit \n\n");
	      		Log.info("log4j -Done with Modifiers-Exit \n\n");
	      		if (fis != null) 	fis.close();
	      	}
	      }