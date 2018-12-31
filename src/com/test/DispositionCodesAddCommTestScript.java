package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.DispositionCodes;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class DispositionCodesAddCommTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void DispositionCodesAddCommTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Disposition Codes- Add Comm");
			Log.info("Executing  Disposition Codes- Add Comm ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_DispositionCodes;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String dispositionCodesCode= ExcelUtils.getCellData(count,1);
		    		String dispositionCodesDescription=ExcelUtils.getCellData(count,2);	
		    		String dispositionCodesNewCode= ExcelUtils.getCellData(count, 3);
		    		String dispositionCodesNewDescription= ExcelUtils.getCellData(count, 4);
		    		String dispositionCodesEditDescription= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						String dispositionCodesCommSubject= ExcelUtils.getCellData(count, 6);
		    						String dispositionCodesCommNoteType = ExcelUtils.getCellData(count, 7);
		    						String dispositionCodesCommMedium = ExcelUtils.getCellData(count, 8);
		    						String dispositionCodesCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Disposition Codes Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Disposition Codes Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	addCommDispositionCodesMultiple(driver, dispositionCodesCode, dispositionCodesDescription, dispositionCodesCommSubject, dispositionCodesCommNoteType, dispositionCodesCommMedium, dispositionCodesCommDetails);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addCommDispositionCodesMultiple(WebDriver driver,String dispositionCodesCode, String dispositionCodesDescription, String dispositionCodesCommSubject, String dispositionCodesCommNoteType, String dispositionCodesCommMedium, String dispositionCodesCommDetails) throws Exception
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

			homePageObject.clickReferencegotoDispositionCodes();	
			
			Thread.sleep(2000);
			
		/*	MemberSupportingCodes MemberSupportingCodesObject = new MemberSupportingCodes(driver);
			MemberSupportingCodesObject.clickOnDispositionCodes();
					
			Thread.sleep(2000);
	*/		
			DispositionCodes dispositionCodesPageObject = new DispositionCodes(driver);
			dispositionCodesPageObject.addCommDispositionCodes(  dispositionCodesCode,  dispositionCodesDescription,  dispositionCodesCommSubject,  dispositionCodesCommNoteType,  dispositionCodesCommMedium,  dispositionCodesCommDetails);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Disposition Codes-Add Comm  \n\n");
		if (fis != null)
				fis.close();
	}
}







