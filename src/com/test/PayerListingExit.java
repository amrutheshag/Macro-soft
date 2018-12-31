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

public class PayerListingExit {


	FileInputStream fis;
	WebDriver driver;
	@Test
	public  void PayerListingExitTestScript () throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n********************************************************************");
		System.out.println("Executing Payers- Exit  ");
	try{
		 	    	
					String Path=Constant.Path_TestData + Constant.File_TestDataToAdd_Payers;
		 	    	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		 	    	for (int count=1; count<=rowCount; count++){
		 	    	String code= ExcelUtils.getCellData(count,1);
		 	   		String name=ExcelUtils.getCellData(count, 2);
		 	   		
		 	    	
		 	   		if (code.isEmpty() || name.isEmpty()) {		 	   			 	   			
		 	   		}
		 	   		else{
		 	   		System.out.println("----------------------------------------------------");
		   		 	System.out.println("Running Payers -Exit- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("----------------------------------------------------");
	 	    		
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Running Payers -Exit- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		 	   		exitMultiplePayers(driver, code, name);

}
}

   } catch (IOException e) {
	        System.out.println("Test data file not found");
	    }   
	}
 


public  void exitMultiplePayers(WebDriver driver, String code, String name) throws Exception {
	
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
		PayersListingPageObject.insurerPayerExit( code, name);
	
}
		  
@AfterMethod
public void afterMethod() throws Exception {
	if (driver!=null) driver.quit();
	System.out.println("Done with Exit \n\n");
	Log.info("Done with Exit \n\n");
   if (fis != null) fis.close();
} 
	
}
