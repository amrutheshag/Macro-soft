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

public class PayerListingDelete {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public  void PayerListingDeleteTestScript () throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n********************************************************************");
		System.out.println("Executing Payers- Delete  ");
	try{
		 	    	
					String Path=Constant.Path_TestData + Constant.File_TestDataToDelete_Payers;
		 	    	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		 	    	for (int count=1; count<=rowCount; count++){
		 	    	String code= ExcelUtils.getCellData(count,1);
		 	   		String name=ExcelUtils.getCellData(count, 2);
		 	   		
		 	    	
		 	   		if (code.isEmpty() || name.isEmpty()) {
		 	   		
		 	   		}
		 	   		else{
		 	   		System.out.println("----------------------------------------------------");
		   		 	System.out.println("Running Payers -Delete- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("----------------------------------------------------");
	 	    		
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Running Payers -Delete- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		 	   		deleteMultiplePayers(driver, code, name);

}
}

   } catch (IOException e) {
	        System.out.println("Test data file not found");
	    }   
	}
 


public  void deleteMultiplePayers(WebDriver driver, String code, String name) throws Exception {
	
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
		PayersListingPageObject.insurerPayerDelete(code, name);
	
}
		  
	@AfterMethod
	  public void afterMethod() throws Exception {
	    System.out.println("Done with Payers- Delete Payer");
		if (driver !=null) driver.quit();
		if (fis != null) 
				fis.close();
	}
	
	
	
	
	
	
}


