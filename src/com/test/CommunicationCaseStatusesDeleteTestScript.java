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

public class CommunicationCaseStatusesDeleteTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void CommunicationCaseStatusesDeleteTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Communication Case Statuses- Delete");
			Log.info("Executing  Communication Case Statuses- Delete ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Delete_CommunicationCaseStatuses;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String communicationcaseStatusesCode= ExcelUtils.getCellData(count,1);
		    		String communicationcaseStatusesDescription=ExcelUtils.getCellData(count,2);	
		    		String communicationcaseStatusesNewCode= ExcelUtils.getCellData(count, 3);
		    		String communicationcaseStatusesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String communicationcaseStatusesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String communicationcaseStatusesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String communicationcaseStatusesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String communicationcaseStatusesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String communicationcaseStatusesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Communication Case Statuses Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Communication Case Statuses Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	deleteCommunicationCaseStatusesMultiple(driver,communicationcaseStatusesCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void deleteCommunicationCaseStatusesMultiple(WebDriver driver,String communicationcaseStatusesCode) throws Exception
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

			homePageObject.clickReferencegotoCommunicationCaseStatuses();	
			
			
			Thread.sleep(2000);
		/*	
			
			PayersPage payersPageObject = new PayersPage(driver);
			payersPageObject.clickOnCommunicationCaseStatuses();
					
			Thread.sleep(2000);
		*/	
		
			CommunicationCaseStatuses communicationcaseStatusesPageObject = new CommunicationCaseStatuses(driver);
			communicationcaseStatusesPageObject.deleteCommunicationCaseStatuses( communicationcaseStatusesCode);
			
			}

			@AfterMethod
    		public void afterMethod() throws Exception {
    		if (driver!=null) driver.quit();
    		System.out.println("Done with Communication Case Statuses-Delete  \n\n");
    		Log.info("log4j -Done with Communication Case Statuses-Delete  \n\n");
    		if (fis != null) 
    				fis.close();
    	}
    }







