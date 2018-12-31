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


public class PayerListingEdit {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public  void PayerListingEditTestScript () throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n********************************************************************");
		System.out.println("Executing Payers- Edit  ");
		Log.info("Executing Payers- Edit  ");
	try{
		 	    	
					String Path=Constant.Path_TestData + Constant.File_TestDataToAdd_Payers;
		 	    	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		 	    	for (int count=1; count<=rowCount; count++){
		 	    	String code= ExcelUtils.getCellData(count,1);
		 	   		String name=ExcelUtils.getCellData(count, 2);
		 	   		String payerPhone=ExcelUtils.getCellData(count, 8);
		 	    	
		 	   		if (code.isEmpty() || name.isEmpty()) {
		 	   			
		 	   		}
		 	   		else{
		 	   		System.out.println("----------------------------------------------------");
		   		 	System.out.println("Running Payers -Edit- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("----------------------------------------------------");
	 	    		
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Running Payers -Edit- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		 	   		editMultiplePayers(driver, code, name, payerPhone);

}
}

   } catch (IOException e) {
	        System.out.println("Test data file not found");
	    }   
	}
 


public  void editMultiplePayers(WebDriver driver, String code, String name, String payerPhone) throws Exception {
	
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
		PayersListingPageObject.insurerPayerEdit( code, name, payerPhone);
	
}
		  
	@AfterMethod
	  public void afterMethod() throws Exception {
	    System.out.println("Done with Payers- Edit Payer");
	    Log.info("Done with Payers- Edit Payer");
		if (driver !=null) driver.quit();
		if (fis != null) fis.close();
	}
	
	
	
	
	
	
}


