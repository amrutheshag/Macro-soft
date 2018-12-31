package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ServiceSets;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ServiceSetsEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void ServiceSetsEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Service Sets- Edit");
			Log.info("Executing  Service Sets- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_ServiceSets;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String serviceSetsCode= ExcelUtils.getCellData(count,1);
		    		String serviceSetsDescription=ExcelUtils.getCellData(count,2);	
		    		String serviceSetsNewCode= ExcelUtils.getCellData(count, 3);
		    		String serviceSetsNewDescription= ExcelUtils.getCellData(count, 4);
		    		String serviceSetsRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String serviceSetsCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String serviceSetsCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String serviceSetsCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String serviceSetsCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Service Sets Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Service Sets Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editServiceSetsMultiple(driver,serviceSetsCode, serviceSetsDescription, serviceSetsRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editServiceSetsMultiple(WebDriver driver,String ServiceSetsCode, String ServiceSetsDescription, String ServiceSetsRecordMark) throws Exception
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

			homePageObject.clickReferencegotoServiceSets();	
			
			
			Thread.sleep(2000);
			
         	ServiceSets serviceSetsPageObject = new ServiceSets(driver);
			serviceSetsPageObject.editServiceSets(ServiceSetsCode, ServiceSetsDescription, ServiceSetsRecordMark);
			
			}

			 @AfterMethod
      		public void afterMethod() throws Exception {
      		if (driver!=null) driver.quit();
      		System.out.println("Done with Service Sets-Edit \n\n");
      		Log.info("log4j-Done with Service Sets-Edit \n\n");
      		if (fis != null) 
      				fis.close();
      	}
      }


