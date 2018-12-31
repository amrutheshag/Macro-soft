package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.UMDegreesofClinicalUrgency;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class UMDegreesofClinicalUrgencyExitTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void umdegreesofclinicalUrgencyExitTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing UM Degrees of Clinical Urgency- Exit");
			Log.info("Executing  UM Degrees of Clinical Urgency- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_UMDegreesofClinicalUrgency;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String umdegreesofclinicalUrgencyCode= ExcelUtils.getCellData(count,1);
		    		String umdegreesofclinicalUrgencyDescription=ExcelUtils.getCellData(count,2);	
		    		String umdegreesofclinicalUrgencyNewCode= ExcelUtils.getCellData(count, 3);
		    		String umdegreesofclinicalUrgencyNewDescription= ExcelUtils.getCellData(count, 4);
		    		String umdegreesofclinicalUrgencyEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String umdegreesofclinicalUrgencyCommSubject= ExcelUtils.getCellData(count, 6);
		    						String umdegreesofclinicalUrgencyCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String umdegreesofclinicalUrgencyCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String umdegreesofclinicalUrgencyCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("UM Degrees of Clinical Urgency Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("UM Degrees of Clinical Urgency Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitumdegreesofclinicalUrgencyMultiple(driver,umdegreesofclinicalUrgencyCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitumdegreesofclinicalUrgencyMultiple(WebDriver driver,String umdegreesofclinicalUrgencyCode) throws Exception
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

			homePageObject.clickReferencegotoUMDegreesofClinicalUrgency();	
			
			
			Thread.sleep(2000);
			
			UMDegreesofClinicalUrgency umdegreesofclinicalUrgencyPageObject = new UMDegreesofClinicalUrgency(driver);
			umdegreesofclinicalUrgencyPageObject.exitUMDegreesofClinicalUrgency(umdegreesofclinicalUrgencyCode);
			
			}

			 @AfterMethod
     		public void afterMethod() throws Exception {
     		if (driver!=null) driver.quit();
     		System.out.println("Done with UM Degrees of Clinical Urgency-Exit \n\n");
     		Log.info("log4j-Done with UM Degrees of Clinical Urgency-Exit \n\n");
     		if (fis != null) fis.close();
     	}
     }

