package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;
import com.pages.TierCopaySchedule;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class TierCopayscheduleAdd {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void TierCopayScheduleAddTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Tier Copay Schedule- Add");
			Log.info("Executing  Tier Copay Schedule- Add ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_TestDataToAdd_TierCopaySchedule;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String tierCopayName= ExcelUtils.getCellData(count,1);
		    		String tierCopayAllowanceLo=ExcelUtils.getCellData(count,2);	
		    		String tierCopayAllowanceHi= ExcelUtils.getCellData(count, 3);
		    		String tierCopayAddAmt= ExcelUtils.getCellData(count, 4);
		    		String tierCopayAddNotes= ExcelUtils.getCellData(count, 5);
		    		String tierCopayNewName= ExcelUtils.getCellData(count, 6);
		    				String tierCopayNewCopay= ExcelUtils.getCellData(count, 7);		
		    						String tierCopayCommSubject= ExcelUtils.getCellData(count, 8);
		    						String tierCopayCommNoteType = ExcelUtils.getCellData(count, 9);
		    						String tierCopayCommNoteMedium = ExcelUtils.getCellData(count, 10);
		    						String tierCopayCommNoteDetails = ExcelUtils.getCellData(count, 11);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Tier Copay Schedule Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Tier Copay Schedule Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addTierCopayScheduleMultiple(driver,tierCopayName, tierCopayAllowanceLo, tierCopayAllowanceHi, tierCopayAddAmt, tierCopayAddNotes );
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addTierCopayScheduleMultiple(WebDriver driver,String tierCopayName, String tierCopayAllowanceLo, String tierCopayAllowanceHi, String tierCopayAddAmt, String tierCopayAddNotes ) throws Exception
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
			}catch(Exception e)
			{ System.out.println("Blank Home Page");
			Log.info("log4j - msg -Blank Home Page");}
			
			homePageObject.clickPayersEmps();	
			
			
			Thread.sleep(2000);
			
			//click Tier Copay Schedules
			PayersPage payersPageObject = new PayersPage(driver);
			payersPageObject.clickOnTierCopaySchedules();
					
			Thread.sleep(2000);
			
			//add new Tier Copay Schedule
			TierCopaySchedule tierCopaySchedulePageObject = new TierCopaySchedule(driver);
			tierCopaySchedulePageObject.addTierCopaySchedule( tierCopayName, tierCopayAllowanceLo, tierCopayAllowanceHi, tierCopayAddAmt, tierCopayAddNotes );
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Tier Copay Schedule-Add  \n\n");
		if (fis != null) 	fis.close();
	}
}
