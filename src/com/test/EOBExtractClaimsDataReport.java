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

public class EOBExtractClaimsDataReport {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void EOBExtractClaimsDataReportTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n***************************************************************\n");
			Log.info("\n***************************************************************\n");
			System.out.println("Executing EOB extract claims data report");
			Log.info("Executing EOB extract claims data report");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Edit_EOBQueryData;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String claimQuery= ExcelUtils.getCellData(count,1);
		    		String newName = ExcelUtils.getCellData(count,2);
		    		String memberQuery = ExcelUtils.getCellData(count, 3);
		    		String providerQuery = ExcelUtils.getCellData(count, 4);
		    		String claimServiceQuery = ExcelUtils.getCellData(count, 5);
		    		String insurerPayerQuery = ExcelUtils.getCellData(count, 6);
		    		
		    			
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("EOB Extract claims data report - Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("EOB Extract claims data report- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		   		 extractEOBClaimsDataReportMultiple(driver, claimQuery,  memberQuery, providerQuery,   claimServiceQuery,  insurerPayerQuery);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void extractEOBClaimsDataReportMultiple(WebDriver driver,String claimQuery, String memberQuery, String providerQuery,  String claimServiceQuery, String insurerPayerQuery) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("opened browser");
						
			//click network user
			LoginPage loginPageObject = new LoginPage(driver);
			loginPageObject.clickNetworkUser();
	
								
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
			
		
			EOBReportDataSetPage EOBDataSetPageObject = new EOBReportDataSetPage(driver);
			EOBDataSetPageObject.extractClaimsData( claimQuery,  memberQuery, providerQuery,   claimServiceQuery,  insurerPayerQuery);
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with EOB Extract claims data report \n\n");
		if (fis != null)
				fis.close();
	}
}
