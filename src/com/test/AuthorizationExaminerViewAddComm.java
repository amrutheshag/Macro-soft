package com.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.AuthorizationListingPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MemberActivityPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class AuthorizationExaminerViewAddComm {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public  void AuthorizationsExaminerViewAddCommunicationTestScript () throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n********************************************************************");
		System.out.println("Executing  Authorizations Examiner View- Add Communication ");
		Log.info("Executing  Authorizations Examiner View- Add Communication ");
	try{
		 	    	
					String Path=Constant.Path_TestData + Constant.File_TestDataToAdd_AEV;
		 	    	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		 	    	for (int count=1; count<=rowCount; count++){
		 	    	String mid= ExcelUtils.getCellData(count,1);
		 	   		String mlname=ExcelUtils.getCellData(count, 2);
		 	   		String mfname=ExcelUtils.getCellData(count, 3);
		 	   		String mdob= ExcelUtils.getCellData(count, 4);
		 	   		String mssn= ExcelUtils.getCellData(count,5);
		 	    	//String maddress= ExcelUtils.getCellData(count,6);
		 	    	//String mcity= ExcelUtils.getCellData(count,7);
		 	    	String pNPI= ExcelUtils.getCellData(count,8);
		 	   	//String providerName= ExcelUtils.getCellData(count,10);
		 	    	String refCertNo= ExcelUtils.getCellData(count,21);
		 	    	String subject= ExcelUtils.getCellData(count,24);
		 	    	String noteType= ExcelUtils.getCellData(count,25);
		 	    	String details= ExcelUtils.getCellData(count,26);
		 	    	
		 	    	
		 	   		if (mlname.isEmpty() || mid.isEmpty()) {System.out.println("");}
		 	   		else{
		 	   		System.out.println("----------------------------------------------------");
		   		 	System.out.println("Running Authorizations Examiner View -Add Comm- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("----------------------------------------------------");
	 	    		
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Running Authorizations Examiner View -Add Comm- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		 	   		AEVaddCommMultiple(driver, mid, mlname, mfname, mdob, mssn, refCertNo, pNPI, subject, noteType, details);

}
}

   } catch (IOException e) {
	        System.out.println("Test data file not found");
	    }   
	}
 


public  void AEVaddCommMultiple(WebDriver driver, String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo, String pNPI, String subject, String noteType, String details) throws Exception {
	
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
		homePageObject.clickMemberActivity();	
		
	
		MemberActivityPage memberActivityPageObject = new MemberActivityPage(driver);
		memberActivityPageObject.clickAuthorizationsExaminerView();
		

		AuthorizationListingPage authorizationsExaminerViewPageObject= new AuthorizationListingPage(driver);
		authorizationsExaminerViewPageObject.AEVaddComm( mid, mlname, mfname, mdob, mssn, refCertNo, pNPI, subject, noteType,details);
	
}
		  
	@AfterMethod
	  public void afterMethod() throws Exception {
	    System.out.println("Done with Authorizations Examiner View- Add Communication");
	    Log.info("Done with Authorizations Examiner View- Add Communication");
		if (driver !=null) driver.quit();
		
	    if (fis != null) 
				fis.close();
				
	}
	
	



}
