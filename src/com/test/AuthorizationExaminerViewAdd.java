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

public class AuthorizationExaminerViewAdd {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public  void AuthorizationsExaminerViewAddAuthTestScript () throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n********************************************************************");
		System.out.println("Executing Authorizations Examiner View- Add authorizations ");
	try{
		 	    	
			String Path=Constant.Path_TestData + Constant.File_TestDataToAdd_AEV;
			int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		 	for (int count=1; count<=rowCount; count++){
		 	String mid= 		ExcelUtils.getCellData(count,1);
		 	String mlname=		ExcelUtils.getCellData(count, 2);
		 	String mfname=		ExcelUtils.getCellData(count, 3);
		 	String mdob= 		ExcelUtils.getCellData(count, 4);
		 	String mssn= 		ExcelUtils.getCellData(count,5);
		 	String refReason= 	ExcelUtils.getCellData(count,6);
		 	String caseManager= ExcelUtils.getCellData(count,7);
		 	String npi= 		ExcelUtils.getCellData(count,8);
		 	String taxID= 		ExcelUtils.getCellData(count,9);
		 	String pname= 		ExcelUtils.getCellData(count,10);
		 	String paddr= 		ExcelUtils.getCellData(count,11);
		 	String pspeciality= ExcelUtils.getCellData(count,12);
		 	String pos= 		ExcelUtils.getCellData(count,13);
		 	String icdCode= 	ExcelUtils.getCellData(count,14);
		 	String refCertType= ExcelUtils.getCellData(count,15);
		 	String treatmentPeriodEndDate= 	ExcelUtils.getCellData(count,16);
		 	String printedProcessedDate= 	ExcelUtils.getCellData(count,17);
		 	String pFollowupDate= 			ExcelUtils.getCellData(count,18);
		 	String extensionDate= 			ExcelUtils.getCellData(count,19);
		 	String serviceSet= 				ExcelUtils.getCellData(count,20);
		 	String modifier1 = ExcelUtils.getCellData(count,27);
		 			String modifier2= ExcelUtils.getCellData(count,28);
		 			String modifier3= ExcelUtils.getCellData(count,29);
		 			String disposition = ExcelUtils.getCellData(count,30);
		 			String treatmentPeriodStartDate = ExcelUtils.getCellData(count,31);		
		 			
		 			
		 	
		 	   		
		 	    	
		 	   		if (mlname.isEmpty() || mid.isEmpty()) {System.out.println("");}
		 	   		else{
		 	   		System.out.println("----------------------------------------------------");
		   		 	System.out.println("Running Authorizations Examiner View -Add Auth- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("----------------------------------------------------");
	 	    		
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Running Authorizations Examiner View -Add Auth- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		 	   		String authCode= addMultipleMemAuth(driver, mid, mlname, mfname, mdob, mssn,refReason,caseManager,npi,taxID,pname, paddr,pspeciality, pos, icdCode, refCertType, treatmentPeriodEndDate, printedProcessedDate, pFollowupDate, extensionDate, serviceSet, modifier1, modifier2, modifier3);
		 	   		
		 	   		ExcelUtils.setCellData(Path, authCode, count, 21);
}
}

   } catch (IOException e) {
	        System.out.println("Test data file not found");
	        e.printStackTrace();
	    }   
	}
 


public  String addMultipleMemAuth(WebDriver driver, String mid, String mlname, String mfname, String mdob, String mssn, String refReason,String caseManager,String npi,String taxID,String pname, String paddr,String pspeciality, String pos, String icdCode, String refCertType, String treatmentPeriodEndDate, String printedProcessedDate, String pFollowupDate, String extensionDate, String serviceSet, String modifier1, String modifier2, String modifier3) throws Exception {
	
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
		String authCode = authorizationsExaminerViewPageObject.AEVaddAuth( mid, mlname, mfname, mdob, mssn, refReason,caseManager,npi,taxID,pname, paddr,pspeciality, pos, icdCode, refCertType, treatmentPeriodEndDate, printedProcessedDate, pFollowupDate, extensionDate, serviceSet , modifier1, modifier2, modifier3);
		int i=authCode.length();
		return authCode.substring(1, i);
}
		  
	@AfterMethod
	  public void afterMethod() throws Exception {
	    System.out.println("Done with Authorizations Examiner View- Add ");
	    Log.info("Done with Authorizations Examiner View- Add ");
		if (driver !=null) driver.quit();
		
	    if (fis != null)
				fis.close();
				
	}
	

}

