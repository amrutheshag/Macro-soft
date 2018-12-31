package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.CommunicationCaseStatuses;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CommunicationCaseStatusesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void CommunicationCaseStatusesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Communication Case Statuses- Edit");
			Log.info("Executing  Communication Case Statuses- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_CommunicationCaseStatuses;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String CommunicationCaseStatusesCode= ExcelUtils.getCellData(count,1);
		    		String CommunicationCaseStatusesDescription=ExcelUtils.getCellData(count,2);	
		    		String CommunicationCaseStatusesNewCode= ExcelUtils.getCellData(count, 3);
		    		String CommunicationCaseStatusesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String CommunicationCaseStatusesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String CommunicationCaseStatusesCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String CommunicationCaseStatusesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String CommunicationCaseStatusesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String CommunicationCaseStatusesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Communication Case Statuses Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Communication Case Statuses Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editCommunicationCaseStatusesMultiple(driver,CommunicationCaseStatusesCode, CommunicationCaseStatusesDescription, CommunicationCaseStatusesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editCommunicationCaseStatusesMultiple(WebDriver driver,String CommunicationCaseStatusesCode, String CommunicationCaseStatusesDescription, String CommunicationCaseStatusesRecordMark) throws Exception
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

			homePageObject.clickReferencegotoCommunicationCaseStatuses();	
			
			
			
		/*	
			
			MemberSupportingCodes payersPageObject = new MemberSupportingCodes(driver);
			payersPageObject.clickOnCommunicationCaseStatuses();
					
			Thread.sleep(2000);
			*/
		
			CommunicationCaseStatuses CommunicationCaseStatusesPageObject = new CommunicationCaseStatuses(driver);
			CommunicationCaseStatusesPageObject.editCommunicationCaseStatuses( CommunicationCaseStatusesCode, CommunicationCaseStatusesDescription, CommunicationCaseStatusesRecordMark);
			
			}

			@AfterMethod
    		public void afterMethod() throws Exception {
    		if (driver!=null) driver.quit();
    		System.out.println("Done with Communication Case Statuses-Edit  \n\n");
    		Log.info("log4j -Done with Communication Case Statuses-Edit  \n\n");
    		if (fis != null)
    				fis.close();
    				
    	}
    }




