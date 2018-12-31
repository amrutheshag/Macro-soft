package com.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayerListingPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class PayerListingAddComm {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public  void PayerListingAddCommTestScript () throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n********************************************************************");
		System.out.println("Executing Payers- Add Comm  ");
		Log.info("Executing Payers- Add Comm  ");
		try{
		 	    	
					String Path=Constant.Path_TestData + Constant.File_TestDataToAdd_Payers;
		 	    	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		 	    	for (int count=1; count<=rowCount; count++){
		 	    	String code= ExcelUtils.getCellData(count,1);
		 	   		String name=ExcelUtils.getCellData(count, 2);
		 	    		
		 	   		String subject=ExcelUtils.getCellData(count, 34);
		 	   		String type=ExcelUtils.getCellData(count, 35);
		 	   		String noteType=ExcelUtils.getCellData(count, 36);
		 	   		String medium=ExcelUtils.getCellData(count, 37);
		 	   		String details=ExcelUtils.getCellData(count, 38);
		 	
		 	   		
		 	   		
		 	   		
		 	   		if (code.isEmpty() || name.isEmpty()) {
		 	   			
		 	   		}
		 	   		else{
		 	   		System.out.println("----------------------------------------------------");
		   		 	System.out.println("Running Payers -Add Comm- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("----------------------------------------------------");
	 	    		
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Running Payers -Add Comm- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		 	   		addCommMultiplePayers(driver, code, name, subject, type, noteType, medium, details);

}
}

   } catch (IOException e) {
	        System.out.println("Test data file not found");
	    }   
	}
 


public  void addCommMultiplePayers(WebDriver driver, String code, String name, String subject, String type, String noteType, String medium, String details) throws Exception {
	
		// Start a browser driver and navigate to Google
		driver= BrowserUtils.openChromeBrowser();
		
		//open risk manager
		driver.get(Constant.URL);
		
		//click network user
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.clickNetworkUser();
		
		HomePage homePageObject = new HomePage(driver);
		
		try{
			homePageObject.clickExitMyOpenCaseListing();
		}catch(Exception e)
		{ System.out.println("Blank Home Page");
		Log.info("log4j - msg -Blank Home Page");}
		
		homePageObject.clickPayersEmps();	
		
		PayersPage PayersPageObject = new PayersPage(driver);
		PayersPageObject.clickOnPayers();
		
		PayerListingPage PayersListingPageObject= new PayerListingPage(driver);
		PayersListingPageObject.insurerPayerAddComm( code, name, subject, type, noteType, medium, details);
	
}
		  
	@AfterMethod
	  public void afterMethod() throws Exception {
	    
		if (driver !=null) driver.quit();
		if (fis != null) 		fis.close();
		System.out.println("Done with Payers- Add Comm Payer");
	    Log.info("Done with Payers- Add Comm Payer");
				
	}
	
	
	
	
	
	
}


