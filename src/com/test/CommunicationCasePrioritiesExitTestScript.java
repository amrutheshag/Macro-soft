package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.CommunicationCasePriorities;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CommunicationCasePrioritiesExitTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void CommunicationCasePrioritiesExitTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Communication Case Priorities- Exit");
			Log.info("Executing  Communication Case Priorities- Exit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_CommunicationCasePriorities;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String communicationcasePrioritiesCode= ExcelUtils.getCellData(count,1);
		    		String communicationcasePrioritiesDescription=ExcelUtils.getCellData(count,2);	
		    		String communicationcasePrioritiesNewCode= ExcelUtils.getCellData(count, 3);
		    		String communicationcasePrioritiesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String communicationcasePrioritiesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String communicationcasePrioritiesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String communicationcasePrioritiesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String communicationcasePrioritiesCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    						String communicationcasePrioritiesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Communication Case Priorities Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Communication Case Priorities Exit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	exitCommunicationCasePrioritiesMultiple(driver,communicationcasePrioritiesCode);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void exitCommunicationCasePrioritiesMultiple(WebDriver driver,String communicationcasePrioritiesCode) throws Exception
			{
			
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("opened browser");
						
			//click network user
			LoginPage loginPageObject = new LoginPage(driver);
			loginPageObject.clickNetworkUser();
	
		
			HomePage homePageObject = new HomePage(driver);
			try{
                homePageObject.clickExitMyOpenCaseListing();
			}
			catch(Exception e){ 
				System.out.println("Blank Home Page");
				Log.info("log4j - msg -Blank Home Page");
}

			homePageObject.clickReferencegotoCommunicationCasePriorities();
			
			
			Thread.sleep(2000);
			
            
            /*          
                         MemberSupportingCodes MemberSupportingCodesObject = new MemberSupportingCodes(driver);
                 		MemberSupportingCodesObject.clickOnCommunicationCasePriorities(); 
                      
               */    
			
	
			CommunicationCasePriorities communicationcasePrioritiesPageObject = new CommunicationCasePriorities(driver);
			communicationcasePrioritiesPageObject.exitCommunicationCasePriorities(communicationcasePrioritiesCode);
			
			}

			@AfterMethod
			public void afterMethod() throws Exception {
			if (driver!=null) driver.quit();
			System.out.println("Done with Communication Case Priorities-Exit  \n\n");
			Log.info("log4j -Done with Communication Case Priorities-Exit  \n\n");
			if (fis != null) 
					fis.close();
					
		}
	}





