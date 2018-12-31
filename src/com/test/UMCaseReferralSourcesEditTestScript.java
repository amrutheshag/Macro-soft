package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.UMCaseReferralSources;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class UMCaseReferralSourcesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void UMCaseReferralSourcesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing UM Case Referral Sources- Edit");
			Log.info("Executing  UM Case Referral Sources- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_UMCaseReferralSources;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String umcasereferralSourcesCode= ExcelUtils.getCellData(count,1);
		    		String umcasereferralSourcesDescription=ExcelUtils.getCellData(count,2);	
		    		String umcasereferralSourcesNewCode= ExcelUtils.getCellData(count, 3);
		    		String umcasereferralSourcesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String umcasereferralSourcesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String umcasereferralSourcesCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String umcasereferralSourcesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String umcasereferralSourcesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String umcasereferralSourcesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("UM Case Referral Sources Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("UM Case Referral Sources Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editUMCaseReferralSourcesMultiple(driver,umcasereferralSourcesCode, umcasereferralSourcesDescription, umcasereferralSourcesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editUMCaseReferralSourcesMultiple(WebDriver driver,String UMCaseReferralSourcesCode, String UMCaseReferralSourcesDescription, String UMCaseReferralSourcesRecordMark) throws Exception
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

			homePageObject.clickReferencegotoUMCaseReferralSources();	
			
			
			Thread.sleep(2000);
			
            
			UMCaseReferralSources umcasereferralSourcesPageObject = new UMCaseReferralSources(driver);
			umcasereferralSourcesPageObject.editUMCaseReferralSources(UMCaseReferralSourcesCode, UMCaseReferralSourcesDescription, UMCaseReferralSourcesRecordMark);
			
			}

			   @AfterMethod
        		public void afterMethod() throws Exception {
        		if (driver!=null) driver.quit();
        		System.out.println("Done with UM Case Referral Sources-Edit \n\n");
        		Log.info("log4j-Done with UM Case Referral Source-Edit \n\n");
        		if (fis != null)
        				fis.close();
        	}
        }

