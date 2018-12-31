package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.CommunicationCaseTypes;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CommunicationCaseTypesDeleteTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void CommunicationCaseTypesDeleteTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Communication Case Types- Delete");
			Log.info("Executing  Communication Case Types- Delete ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Delete_CommunicationCaseTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String communicationcaseTypesCode= ExcelUtils.getCellData(count,1);
		    		String communicationcaseTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String communicationcaseTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String communicationcaseTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String communicationcaseTypesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String communicationcaseTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String communicationcaseTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String communicationcaseTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String communicationcaseTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Communication Case Types Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Communication Case Types Delete- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	deleteCommunicationCaseTypesMultiple(driver,communicationcaseTypesCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void deleteCommunicationCaseTypesMultiple(WebDriver driver,String communicationcaseTypesCode) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("opened browser");
						
			//click network user
			LoginPage loginPageObject = new LoginPage(driver);
			loginPageObject.clickNetworkUser();
			
			//click Payers-Emps
			HomePage homePageObject = new HomePage(driver);
            try{
                homePageObject.clickExitMyOpenCaseListing();
            }
            catch(Exception e){ 
            	System.out.println("Blank Home Page");
            	Log.info("log4j - msg -Blank Home Page");
            }

			homePageObject.clickReferencegotoCommunicationCaseTypes();	
			
			
			Thread.sleep(2000);
		/*	
			
			PayersPage payersPageObject = new PayersPage(driver);
			payersPageObject.clickOnCommunicationCaseTypes();
					
			Thread.sleep(2000);
		*/	
			
			CommunicationCaseTypes communicationcaseTypesPageObject = new CommunicationCaseTypes(driver);
			communicationcaseTypesPageObject.deleteCommunicationCaseTypes( communicationcaseTypesCode);
			
			}

			 @AfterMethod
     		public void afterMethod() throws Exception {
     		if (driver!=null) driver.quit();
     		System.out.println("Done with Communication Case Types-Delete  \n\n");
     		Log.info("log4j -Done with Communication Case Types-Delete  \n\n");
     		if (fis != null) 
     				fis.close();
     				
     	}
     }






