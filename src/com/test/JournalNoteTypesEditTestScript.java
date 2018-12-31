package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.JournalNoteTypes;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class JournalNoteTypesEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void JournalNoteTypesEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Journal Note Types- Edit");
			Log.info("Executing  Journal Note Types- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_JournalNoteTypes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String JournalNoteTypesCode= ExcelUtils.getCellData(count,1);
		    		String JournalNoteTypesDescription=ExcelUtils.getCellData(count,2);	
		    		String JournalNoteTypesNewCode= ExcelUtils.getCellData(count, 3);
		    		String JournalNoteTypesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String JournalNoteTypesRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String JournalNoteTypesCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String JournalNoteTypesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String JournalNoteTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String JournalNoteTypesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Journal Note Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Journal Note Types Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editJournalNoteTypesMultiple(driver,JournalNoteTypesCode, JournalNoteTypesDescription, JournalNoteTypesRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editJournalNoteTypesMultiple(WebDriver driver,String JournalNoteTypesCode, String JournalNoteTypesDescription, String JournalNoteTypesRecordMark) throws Exception
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

			homePageObject.clickReferencegotoJournalNoteTypes();	
			
			
			JournalNoteTypes JournalNoteTypesPageObject = new JournalNoteTypes(driver);
			JournalNoteTypesPageObject.editJournalNoteTypes(JournalNoteTypesCode, JournalNoteTypesDescription, JournalNoteTypesRecordMark);
			
			}

			@AfterMethod
      		public void afterMethod() throws Exception {
      		if (driver!=null) driver.quit();
      		System.out.println("Done with edit \n\n");
      		Log.info("log4j -Done with edit \n\n");
      		if (fis != null) 
      				fis.close();
      	}
	      }

