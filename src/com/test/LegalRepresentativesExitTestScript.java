package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.LegalRepresentatives;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class LegalRepresentativesExitTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void LegalRepresentativesExitTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Legal Representatives- Exit");
			Log.info("Executing  Legal Representatives- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_LegalRepresentatives;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String legalRepresentativesCode= ExcelUtils.getCellData(count,1);
		    		String legalRepresentativesDescription=ExcelUtils.getCellData(count,2);	
		    		String legalRepresentativesNewCode= ExcelUtils.getCellData(count, 3);
		    		String legalRepresentativesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String legalRepresentativesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String legalRepresentativesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String legalRepresentativesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String legalRepresentativesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String legalRepresentativesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Legal Representatives Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Legal Representatives Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitLegalRepresentativesMultiple(driver,legalRepresentativesCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitLegalRepresentativesMultiple(WebDriver driver,String legalRepresentativesCode) throws Exception
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
			homePageObject.clickPayersEmps();	
			
			
			Thread.sleep(2000);
			
			PayersPage payersPageObject = new PayersPage(driver);
			payersPageObject.clickOnLegalRepresentatives();
					
			Thread.sleep(2000);
			LegalRepresentatives legalRepresentativesPageObject = new LegalRepresentatives(driver);
			legalRepresentativesPageObject.exitLegalRepresentatives(legalRepresentativesCode);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Legal Representatives-Exit  \n\n");
		if (fis != null) 
				fis.close();
	}
}


