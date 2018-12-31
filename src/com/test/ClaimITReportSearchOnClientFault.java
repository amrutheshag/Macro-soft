package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.ClaimITReportPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ReportsList;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class ClaimITReportSearchOnClientFault {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void ClaimITReportWithClientFaultTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Claim IT Report with client fault");
			Log.info("Executing Claim IT Report with Client fault");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_ClaimITReportTestData;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String approvedServiceOnly= ExcelUtils.getCellData(count,1);
		    		String openClaimsOnly= ExcelUtils.getCellData(count,2);
		    		String extractClaimAndServiceData= ExcelUtils.getCellData(count,3);
		    		String denyServices= ExcelUtils.getCellData(count,4);
		    		String providerID= ExcelUtils.getCellData(count,5);
		    		String memberID= ExcelUtils.getCellData(count,6);
		    		String payor= ExcelUtils.getCellData(count,7);
		    		String from= ExcelUtils.getCellData(count,8);
		    		String to= ExcelUtils.getCellData(count,9); 
		    		String claimQuery= ExcelUtils.getCellData(count,10); 
		    		String insurerPayor= ExcelUtils.getCellData(count,11); 
		    		String checkBilaterals= ExcelUtils.getCellData(count,12);
		    		String checkCCI= ExcelUtils.getCellData(count,13);
		    		String checkGlobalPeriods= ExcelUtils.getCellData(count,14); 
		    		String checkLCPDiagnosis= ExcelUtils.getCellData(count,15);
		    		String assistantSurgeon = ExcelUtils.getCellData(count,16);
		    		
		    		
		    		String clientFault= ExcelUtils.getCellData(count,17);
		    		String providerIDInClaimITReport= ExcelUtils.getCellData(count,18);
		    		String payorInClaimITReport= ExcelUtils.getCellData(count,19); 
		    
		    		
		    		
		    		
		    		
		    		
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Claim IT Report with client fault- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Claim IT Report with client fault- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		   		 claimITReportWithClientFaultMultiple(driver, approvedServiceOnly, openClaimsOnly, extractClaimAndServiceData, denyServices, providerID, memberID, payor, from, to, claimQuery, insurerPayor, checkBilaterals, checkCCI, checkGlobalPeriods, checkLCPDiagnosis, assistantSurgeon, clientFault, providerIDInClaimITReport, payorInClaimITReport);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void claimITReportWithClientFaultMultiple(WebDriver driver, String approvedServiceOnly, String openClaimsOnly, String extractClaimAndServiceData, String denyServices, String providerID, String memberID, String payor, String from, String to, String claimQuery, String insurerPayor, String checkBilaterals, String checkCCI, String checkGlobalPeriods, String checkLCPDiagnosis, String assistantSurgeon, String clientFault, String providerIDInClaimITReport, String payorInClaimITReport) throws Exception{
			
			
			
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
			
			//click claim IT Report
			ReportsList reportsListObject = new ReportsList(driver);
			reportsListObject.clickClaimITReport();					
			Thread.sleep(2000);
			
			//print claim IT Report with client fault
			ClaimITReportPage ClaimITReportPageObject = new ClaimITReportPage(driver);
			ClaimITReportPageObject.searchOnFaultPrintClaimITReport(approvedServiceOnly, openClaimsOnly, extractClaimAndServiceData, denyServices, providerID, memberID, payor, from, to, claimQuery, insurerPayor, checkBilaterals, checkCCI, checkGlobalPeriods, checkLCPDiagnosis, assistantSurgeon, clientFault, providerIDInClaimITReport, payorInClaimITReport);
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Claim IT Report- with Client Fault \n\n");
		if (fis != null) 
				fis.close();
			
	}
}

