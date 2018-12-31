package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.CaseManagerListingPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProvidersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CaseManagerExit {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void CaseManagerExitTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Case Manager- Exit");
			Log.info("Executing  Case Manager- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_CaseManagersData;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String code= ExcelUtils.getCellData(count,1);
		    		String name=ExcelUtils.getCellData(count,2);	
		    		String newCode= ExcelUtils.getCellData(count, 3);
		    		String newName= ExcelUtils.getCellData(count, 4);
		    		String city= ExcelUtils.getCellData(count, 5);
		    		
		    		
		    		String startDate= ExcelUtils.getCellData(count, 6);
		    		String endDate= ExcelUtils.getCellData(count, 7);
		    		String Active= ExcelUtils.getCellData(count, 8);
		    		
		    		
		    		
		    						String subject= ExcelUtils.getCellData(count, 9);
		    						String type = ExcelUtils.getCellData(count, 10);
		    						String status = ExcelUtils.getCellData(count, 11);
		    						String priority = ExcelUtils.getCellData(count, 12);
		    						String followupDate = ExcelUtils.getCellData(count, 13);
		    						String noteType = ExcelUtils.getCellData(count, 14);
		    						String medium = ExcelUtils.getCellData(count, 15);
		    						String details = ExcelUtils.getCellData(count, 16);
		    						
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Case Manager Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Case Manager Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitCaseManagerMultiple(driver,code, name);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitCaseManagerMultiple(WebDriver driver,String code, String name) throws Exception
			{
			
			
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
			
			//click case managers
			ProvidersPage providersPageObject = new ProvidersPage(driver);
			providersPageObject.clickOnCaseManagers();
			Thread.sleep(2000);
			
			//exit
			CaseManagerListingPage caseManagerListingPageObject = new CaseManagerListingPage(driver);
			caseManagerListingPageObject.exitCaseManager( code, name);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Case Manager-Exit  \n\n");
		if (fis != null) 
				fis.close();
				
	}
}


