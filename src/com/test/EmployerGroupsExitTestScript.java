package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.EmployerGroups;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class EmployerGroupsExitTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void EmployerGroupsExitTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Employer Groups- Exit");
			Log.info("Executing  Employer Groups- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_EmployerGroups;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String employerGroupsCode= ExcelUtils.getCellData(count,1);
		    		String employerGroupsDescription=ExcelUtils.getCellData(count,2);	
		    		String employerGroupsNewCode= ExcelUtils.getCellData(count, 3);
		    		String employerGroupsNewDescription= ExcelUtils.getCellData(count, 4);
		    		String employerGroupsEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String employerGroupsCommSubject= ExcelUtils.getCellData(count, 6);
		    						String employerGroupsCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String employerGroupsCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String employerGroupsCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Employer Groups Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Employer Groups Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitEmployerGroupsMultiple(driver,employerGroupsCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitEmployerGroupsMultiple(WebDriver driver,String employerGroupsCode) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("opened browser");
						
			//click network user
			LoginPage loginPageObject = new LoginPage(driver);
			loginPageObject.clickNetworkUser();
								
			//click EDI
			HomePage homePageObject = new HomePage(driver);
			homePageObject.clickPayersEmps();	
			
			
			Thread.sleep(2000);
			
			//click 
			PayersPage payersPageObject = new PayersPage(driver);
			payersPageObject.clickOnEmployerGroups();
					
			Thread.sleep(2000);
			
			//exit EDI Submitters
			EmployerGroups employerGroupsPageObject = new EmployerGroups(driver);
			employerGroupsPageObject.exitEmployerGroups(employerGroupsCode);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Employer Groups-Exit  \n\n");
		if (fis != null) 
				fis.close();
	}
}

