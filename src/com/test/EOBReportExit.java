package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.EOBReportDataSetPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ReportsList;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class EOBReportExit {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void EOBExitReportTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing EOB - Exit");
			Log.info("Executing EOB - Exit");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Edit_EOBQueryData;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String claimQuery= ExcelUtils.getCellData(count,1);
		    		String newName = ExcelUtils.getCellData(count,2);
		    		
		    			
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("EOB Exit  - Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("EOB Exit - Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		   		 editEOBClaimQueryMultiple(driver,claimQuery, newName);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editEOBClaimQueryMultiple(WebDriver driver,String claimQuery, String newName) throws Exception
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
								
			//click Reports
			HomePage homePageObject = new HomePage(driver);
			try{
				homePageObject.clickExitMyOpenCaseListing();
			}catch(Exception e)
			{ System.out.println("Blank Home Page");
			Log.info("log4j - msg -Blank Home Page");}
			homePageObject.clickReports();	
			
			
			Thread.sleep(2000);
			
			//click Explanation of Benefits
			ReportsList reportsListObject = new ReportsList(driver);
			reportsListObject.clickExplanationOfBenefitsReport();					
			Thread.sleep(2000);
			
			//exit EOB Report
			EOBReportDataSetPage EOBDataSetPageObject = new EOBReportDataSetPage(driver);
			EOBDataSetPageObject.exitEOBReport();
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Exit EOB Report \n\n");
		if (fis != null)
				fis.close();
	}
}
