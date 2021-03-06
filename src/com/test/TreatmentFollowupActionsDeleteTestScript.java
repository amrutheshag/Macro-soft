package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.TreatmentFollowupActions;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class TreatmentFollowupActionsDeleteTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void TreatmentFollowupActionsDeleteTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Treatment Followup Actions- Delete");
			Log.info("Executing  Treatment Followup Actions- Delete ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Delete_TreatmentFollowupActions;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String treatmentfollowupActionsCode= ExcelUtils.getCellData(count,1);
		    		String treatmentfollowupActionsDescription=ExcelUtils.getCellData(count,2);	
		    		String treatmentfollowupActionsNewCode= ExcelUtils.getCellData(count, 3);
		    		String treatmentfollowupActionsNewDescription= ExcelUtils.getCellData(count, 4);
		    		String treatmentfollowupActionsEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String treatmentfollowupActionsCommSubject= ExcelUtils.getCellData(count, 6);
		    						String treatmentfollowupActionsCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String treatmentfollowupActionsCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String treatmentfollowupActionsCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Treatment Followup Actions Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Treatment Followup Actions Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	deleteTreatmentFollowupActionsMultiple(driver,treatmentfollowupActionsCode, treatmentfollowupActionsDescription);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void deleteTreatmentFollowupActionsMultiple(WebDriver driver,String treatmentfollowupActionsCode, String treatmentfollowupActionsDescription) throws Exception
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
			try{
                homePageObject.clickExitMyOpenCaseListing();
           }
			catch(Exception e){ 
				System.out.println("Blank Home Page");
				Log.info("log4j - msg -Blank Home Page");
			}

			homePageObject.clickReferencegotoTreatmentFollowupActions();	
			
			Thread.sleep(2000);
			
            
           	TreatmentFollowupActions treatmentfollowupActionsPageObject = new TreatmentFollowupActions(driver);
			treatmentfollowupActionsPageObject.deleteTreatmentFollowupActions(treatmentfollowupActionsCode, treatmentfollowupActionsDescription);
			
			}

			 @AfterMethod
        		public void afterMethod() throws Exception {
        		if (driver!=null) driver.quit();
        		System.out.println("Done with Treatment Followup Actions-Delete \n\n");
        		Log.info("log4j-Done with Treatment Followup Actions-Delete \n\n");
        		if (fis != null) 
        				fis.close();
        	}
        }

