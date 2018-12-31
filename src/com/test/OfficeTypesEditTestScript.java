package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.OfficeTypes;
import com.pages.HomePage;
import com.pages.LoginPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class OfficeTypesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void OfficeTypesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Office Types- Edit");
			Log.info("Executing  Office Types- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_OfficeTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String OfficeTypesCode= ExcelUtils.getCellData(count,1);
		    		String OfficeTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String OfficeTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String OfficeTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String OfficeTypesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String OfficeTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String OfficeTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String OfficeTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String OfficeTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Office Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Office Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editOfficeTypesMultiple(driver,OfficeTypesCode, OfficeTypesDescription, OfficeTypesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editOfficeTypesMultiple(WebDriver driver,String OfficeTypesCode, String OfficeTypesDescription, String OfficeTypesRecordMark) throws Exception
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

			homePageObject.clickReferencegotoOfficeTypes();	
			
			OfficeTypes OfficeTypesPageObject = new OfficeTypes(driver);
			OfficeTypesPageObject.editOfficeTypes( OfficeTypesCode, OfficeTypesDescription, OfficeTypesRecordMark);
			
			}

		    @AfterMethod
      		public void afterMethod() throws Exception {
      		if (driver!=null) driver.quit();
      		System.out.println("Done with Office Types-Edit \n\n");
      		Log.info("log4j -Done with Office Types-Edit \n\n");
      		if (fis != null) 	fis.close();
      	}
      }