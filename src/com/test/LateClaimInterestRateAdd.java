package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.ClaimInterestPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProvidersPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class LateClaimInterestRateAdd {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void LateClaimsInterestRatesAddTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Late Claims Interest Rates- Add");
			Log.info("Executing  Late Claims Interest Rates Add ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_LateClaimInterestRatesTestData;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String effectiveDate= ExcelUtils.getCellData(count,1);
		    		String termDate=ExcelUtils.getCellData(count,2);
		    		
		    		String state = ExcelUtils.getCellData(count,3);
		    		String benefitProduct= ExcelUtils.getCellData(count,4);
		    		String submissionMethod= ExcelUtils.getCellData(count,5);
		    		
		    		String ageLo= ExcelUtils.getCellData(count,6);
		    		String ageHi= ExcelUtils.getCellData(count,7);
		    		String annualInterestRate= ExcelUtils.getCellData(count,8);
		    		
		    		String annualPenaltyRate= ExcelUtils.getCellData(count,9);
		    		String minTotalToBeMet= ExcelUtils.getCellData(count,10);
		    		
		    	
		    		String assessedOnCleanClaimsOnly= ExcelUtils.getCellData(count, 11);
		    		String countBusinessDaysOnly= ExcelUtils.getCellData(count, 12);
		    		
		    		String notes= ExcelUtils.getCellData(count, 13);
    				String noEdit=	ExcelUtils.getCellData(count, 14);
		    				    				
		    		String noDelete= ExcelUtils.getCellData(count, 15);
		    		String recordMark = ExcelUtils.getCellData(count, 16);
		    		String subject = ExcelUtils.getCellData(count, 17);
		    		String notetype = ExcelUtils.getCellData(count, 18);
		    		String notesDetails = ExcelUtils.getCellData(count, 19);
		    		String newAnnualInterestRate = ExcelUtils.getCellData(count, 20);
		    		String newAnnualPenaltyRate = ExcelUtils.getCellData(count, 21);
		    		String newNotes = ExcelUtils.getCellData(count, 22);
		    						
		    								
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Late Claims Interest Rates Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Late Claims Interest Rates Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addInterestRatesMultiple(driver,effectiveDate, state, benefitProduct, termDate, submissionMethod, ageLo, ageHi, annualInterestRate, annualPenaltyRate, minTotalToBeMet, assessedOnCleanClaimsOnly, countBusinessDaysOnly, notes);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addInterestRatesMultiple(WebDriver driver, String effectiveDate,  String state, String benefitProduct, String termDate, String submissionMethod, String ageLo, String ageHi, String annualInterestRate, String annualPenaltyRate, String minTotalToBeMet, String assessedOnCleanClaimsOnly, String countBusinessDaysOnly, String notes) throws Exception {
			
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("opened browser");
						
			//click network user
			LoginPage loginPageObject = new LoginPage(driver);
			loginPageObject.clickNetworkUser();
			//click providers
			HomePage homePageObject = new HomePage(driver);
			
			try{
				homePageObject.clickExitMyOpenCaseListing();
			}catch(Exception e)
			{ System.out.println("Blank Home Page");
			Log.info("log4j - msg -Blank Home Page");}
			
			homePageObject.clickProviders();	
			
			
			Thread.sleep(2000);
			
			//click Late Claim Interest Rates
			ProvidersPage providersPageObject = new ProvidersPage(driver);
			providersPageObject.clickOnLateClaimInterestRates();
			Thread.sleep(2000);
			
			//exit
			ClaimInterestPage claimInterestObject = new ClaimInterestPage(driver);
			claimInterestObject.InterestRateAdd(effectiveDate, state, benefitProduct, termDate, submissionMethod, ageLo, ageHi, annualInterestRate, annualPenaltyRate, minTotalToBeMet, assessedOnCleanClaimsOnly, countBusinessDaysOnly, notes);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Late Claim Interest Rates-Add  \n\n");
		if (fis != null) 
				fis.close();
	}
}
