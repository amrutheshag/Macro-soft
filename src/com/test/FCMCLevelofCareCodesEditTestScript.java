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

public class FCMCLevelofCareCodesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void FCMCLevelofCareCodesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing FCMC Level of Care Codes- Edit");
			Log.info("Executing  FCMC Level of Care Codes- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_FCMCLevelofCareCodes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String FCMCLevelofCareCodesCode= ExcelUtils.getCellData(count,1);
		    		String FCMCLevelofCareCodesDescription=ExcelUtils.getCellData(count,2);	
		    		String FCMCLevelofCareCodesNewCode= ExcelUtils.getCellData(count, 3);
		    		String FCMCLevelofCareCodesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String FCMCLevelofCareCodesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String FCMCLevelofCareCodesCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String FCMCLevelofCareCodesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String FCMCLevelofCareCodesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String FCMCLevelofCareCodesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("FCMC Level of Care Codes Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("FCMC Level of Care Codes Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editFCMCLevelofCareCodesMultiple(driver,FCMCLevelofCareCodesCode, FCMCLevelofCareCodesDescription, FCMCLevelofCareCodesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editFCMCLevelofCareCodesMultiple(WebDriver driver,String FCMCLevelofCareCodesCode, String FCMCLevelofCareCodesDescription, String FCMCLevelofCareCodesRecordMark) throws Exception
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

			homePageObject.clickReferencegotoFCMCLevelofCareCodes();	
			
			
			
		/*	
			MemberSupportingCodes payersPageObject = new MemberSupportingCodes(driver);
			payersPageObject.clickOnFCMCLevelofCareCodes();
					
			Thread.sleep(2000);
			*/
			FCMCLevelofCareCodes FCMCLevelofCareCodesPageObject = new FCMCLevelofCareCodes(driver);
			FCMCLevelofCareCodesPageObject.editFCMCLevelofCareCodes( FCMCLevelofCareCodesCode, FCMCLevelofCareCodesDescription, FCMCLevelofCareCodesRecordMark);
			
			}

			  @AfterMethod
      		public void afterMethod() throws Exception {
      		if (driver!=null) driver.quit();
      		if (fis != null) fis.close();
      		System.out.println("Done with FCMC Level of Care Codes-Edit  \n\n");
      		Log.info("log4j -Done with FCMC Level of Care Codes-Edit  \n\n");
      		
      				
      	}
      }

