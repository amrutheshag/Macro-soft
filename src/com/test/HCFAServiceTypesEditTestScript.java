package com.test;

import java.io.FileInputStream;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HCFAServiceTypes;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class HCFAServiceTypesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void HCFAServiceTypesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing HCFA Service Types- Edit");
			Log.info("Executing  HCFA Service Types- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_HCFAServiceTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String hcfaserviceTypesCode= ExcelUtils.getCellData(count,1);
		    		String hcfaserviceTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String hcfaserviceTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String hcfaserviceTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String hcfaserviceTypesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String hcfaserviceTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String hcfaserviceTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String hcfaserviceTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String hcfaserviceTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("HCFA Service Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("HCFA Service Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editHCFAServiceTypesMultiple(driver,hcfaserviceTypesCode, hcfaserviceTypesDescription, hcfaserviceTypesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editHCFAServiceTypesMultiple(WebDriver driver,String HCFAServiceTypesCode, String HCFAServiceTypesDescription, String HCFAServiceTypesRecordMark) throws Exception
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

			homePageObject.clickReferencegotoHCFAServiceTypes();	
			
			
			Thread.sleep(2000);
			
          	HCFAServiceTypes hcfaserviceTypesPageObject = new HCFAServiceTypes(driver);
			hcfaserviceTypesPageObject.editHCFAServiceTypes( HCFAServiceTypesCode, HCFAServiceTypesDescription, HCFAServiceTypesRecordMark);
			
			}

			  @AfterMethod
	      		public void afterMethod() throws Exception {
	      		if (driver!=null) driver.quit();
	      		System.out.println("Done with HCFA Service Types-Edit  \n\n");
	      		Log.info("log4j -Done with HCFA Service Types-Edit  \n\n");
	      		if (fis != null)
	      				fis.close();
	      	}
	      }



