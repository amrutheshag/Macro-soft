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

public class PayerListingCopy {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public  void PayerListingCopyTestScript () throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n********************************************************************");
		System.out.println("Executing Payers- Copy  ");
	try{
		 	    	
					String Path=Constant.Path_TestData + Constant.File_TestDataToAdd_Payers;
		 	    	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		 	    	for (int count=1; count<=rowCount; count++){
		 	    	String code= ExcelUtils.getCellData(count,1);
		 	   		String name=ExcelUtils.getCellData(count, 2);
		 	   		String payerContact=ExcelUtils.getCellData(count, 3);
		 	   		String payerMainAddress=ExcelUtils.getCellData(count, 4);
		 	   		String payerCity=ExcelUtils.getCellData(count, 5);
		 	   		String payerState=ExcelUtils.getCellData(count, 6);
		 	   		String payerZIP=ExcelUtils.getCellData(count, 7);
		 	   		String payerPhone=ExcelUtils.getCellData(count, 8);
		 	   		String payerFAX=ExcelUtils.getCellData(count, 9);
		 	   		String payerBusinessUnitNumber=ExcelUtils.getCellData(count, 10);
		 	   		String payerContractNumber=ExcelUtils.getCellData(count, 11);
		 	   		String payerType=ExcelUtils.getCellData(count, 12);
		 	   		String payerExclusiveProviderNetwork=ExcelUtils.getCellData(count, 13);
		 	   		String payerUserField=ExcelUtils.getCellData(count, 14);
		 	    
			 	
		 	   		String newName=ExcelUtils.getCellData(count, 27);
		 	   		String newCode=ExcelUtils.getCellData(count, 28);
		 	   		String newBusinessUnitNumber=ExcelUtils.getCellData(count, 29);
		 	   		String newContractNumber=ExcelUtils.getCellData(count, 30);
				 	String newAddress=ExcelUtils.getCellData(count, 31);
			 	   		
			 	if (code.isEmpty() || name.isEmpty()) {
		 	   		}
		 	   		else{
		 	   		System.out.println("----------------------------------------------------");
		   		 	System.out.println("Running Payers -Copy- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("----------------------------------------------------");
	 	    		
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Running Payers -Copy- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		 	   		copyMultiplePayers(driver, code, name, newName, newCode, newBusinessUnitNumber, newContractNumber, newAddress);

}
}

   } catch (IOException e) {
	        System.out.println("Test data file not found");
	    }   
	}
 


public  void copyMultiplePayers(WebDriver driver, String code, String name,String newName, String newCode, String newBusinessUnitNumber, String newContractNumber, String newAddress) throws Exception {
	
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
		PayersListingPageObject.insurerPayerCopy( code, name, newName, newCode, newBusinessUnitNumber, newContractNumber, newAddress);
	
}
		  
	@AfterMethod
	  public void afterMethod() throws Exception {
	    System.out.println("Done with Payers- Copy Payer");
		if (driver !=null) driver.quit();
		
	    if (fis != null) 
				fis.close();
	}
	
	
}


