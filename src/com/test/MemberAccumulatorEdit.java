package com.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MemberAccumulatorListingPage;
import com.pages.MemberActivityPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class MemberAccumulatorEdit {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public  void MemberAccumulatorEditTestScript () throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n********************************************************************");
		System.out.println("Executing Member Accumulators- Edit Accumulator ");
	try{
		 	    	
			String Path=Constant.Path_TestData + Constant.File_TestDataToEdit_Accumulator;
			int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		 	for (int count=1; count<=rowCount; count++){
		 	String mid= 		ExcelUtils.getCellData(count,1);
		 	String mlname=		ExcelUtils.getCellData(count, 2);
		 	String mfname=		ExcelUtils.getCellData(count, 3);
		 	String mdob= 		ExcelUtils.getCellData(count, 4);
		 	String mssn= 		ExcelUtils.getCellData(count,5);
		 	
		 	String deniedClaimNo= ExcelUtils.getCellData(count,6);
		 	String deniedServiceFromDate = ExcelUtils.getCellData(count,7);
		 	String deniedServiceToDate = ExcelUtils.getCellData(count,8);
		 	
		 	String subject = ExcelUtils.getCellData(count,9);
		 	String  type= ExcelUtils.getCellData(count,10);
		 	String  noteType	= ExcelUtils.getCellData(count,11);
		 	String  medium = ExcelUtils.getCellData(count,12);
		 	String  details = ExcelUtils.getCellData(count,13);
		 	
		 	   		
		 	    	
		 	   		if (mlname.isEmpty() || mid.isEmpty()) {System.out.println("");}
		 	   		else{
		 	   		System.out.println("----------------------------------------------------");
		   		 	System.out.println("Running Member Accumulators -Edit Accum- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("----------------------------------------------------");
	 	    		
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Running Member Accumulaotrs -Edit Accum- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		 	   		memberAccumulatorEditMultiple(driver, mid, mlname, mfname, mdob, mssn,deniedClaimNo, deniedServiceFromDate, deniedServiceToDate);
		 	   
}
}

   } catch (IOException e) {
	        System.out.println("Test data file not found");
	    }   
	}
 


public void memberAccumulatorEditMultiple(WebDriver driver, String mid, String mlname, String mfname, String mdob, String mssn, String deniedClaimNo, String deniedServiceFromDate, String deniedServiceToDate) throws Exception {
	
		// Start a browser driver and navigate to Google
		driver= BrowserUtils.openChromeBrowser();
		
		//open risk manager
		driver.get(Constant.URL);
		
		//click network user
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.clickNetworkUser();
		
		//click member activity
		HomePage homePageObject = new HomePage(driver);
		
		try{
			homePageObject.clickExitMyOpenCaseListing();
		}catch(Exception e)
		{ System.out.println("Blank Home Page");
		Log.info("log4j - msg -Blank Home Page");}
		
		homePageObject.clickMemberActivity();	
	
		
		//click claim examiner view
		MemberActivityPage memberActivityPageObject = new MemberActivityPage(driver);
		
		//click member accumulator
		memberActivityPageObject.clickMemberAccumulators();
		
		//click member accumulator
		MemberAccumulatorListingPage memberAccumulatorListingPageObject= new MemberAccumulatorListingPage(driver);
		memberAccumulatorListingPageObject.memberAccumulatorEdit( mid, mlname, mfname, mdob, mssn,deniedClaimNo, deniedServiceFromDate, deniedServiceToDate);
	
		
}
		  
	@AfterMethod
	  public void afterMethod() throws Exception {
	    System.out.println("Done with Member Accumulators- Edit Accumulator");
	    if (driver!=null) driver.quit();
	    if (fis != null)	fis.close();
	}


}



	
	

