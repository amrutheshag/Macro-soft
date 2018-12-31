package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.FCMCLevelofCareCodes;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class FCMCLevelOfCareCodesDeleteTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void FCMCLevelofCareCodesDeleteTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing FCMC Level of Care Codes- Delete");
			Log.info("Executing  FCMC Level of Care Codes- Delete ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Delete_FCMCLevelofCareCodes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String fcmclevelofcareCodesCode= ExcelUtils.getCellData(count,1);
		    		String fcmclevelofcareCodesDescription=ExcelUtils.getCellData(count,2);	
		    		String fcmclevelofcareCodesNewCode= ExcelUtils.getCellData(count, 3);
		    		String fcmclevelofcareCodesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String fcmclevelofcareCodesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String fcmclevelofcareCodesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String fcmclevelofcareCodesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String fcmclevelofcareCodesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String fcmclevelofcareCodesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("FCMC Level of Care Codes Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("FCMC Level of Care Codes Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	deleteFCMCLevelofCareCodesMultiple(driver,fcmclevelofcareCodesCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void deleteFCMCLevelofCareCodesMultiple(WebDriver driver,String fcmclevelofcareCodesCode) throws Exception
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

			homePageObject.clickReferencegotoFCMCLevelofCareCodes();	
			
			
			Thread.sleep(2000);
			
			//add new Tier Copay Schedule
			FCMCLevelofCareCodes fcmclevelofcareCodesPageObject = new FCMCLevelofCareCodes(driver);
			fcmclevelofcareCodesPageObject.deleteFCMCLevelofCareCodes( fcmclevelofcareCodesCode);
			
			}
			 @AfterMethod
     		public void afterMethod() throws Exception {
     		if (driver!=null) driver.quit();
     		System.out.println("Done with FCMC Level of Care Codes- Delete  \n\n");
     		Log.info("log4j -Done with FCMC Level of Care Codes- Delete  \n\n");
     		if (fis != null) 
     				fis.close();
     				
     	}
      }





