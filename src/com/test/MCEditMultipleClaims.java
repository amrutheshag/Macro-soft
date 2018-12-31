package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MemberActivityPage;
import com.pages.MembersClaimsHistoryPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class MCEditMultipleClaims {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public void MemberClaimsEditTestScript() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		System.out.println("Executing Member Claims -Edit Multiple Claims");
		
	
		try{
 	    	String Path=Constant.Path_TestData + Constant.File_TestDataForAddClaim_MC;
 	    	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
 	    	for (int count=1; count<=rowCount; count++){
 	    	String mid= ExcelUtils.getCellData(count,1);
 	    	String mlname=ExcelUtils.getCellData(count,2);	
    		String mfname=ExcelUtils.getCellData(count,3);	
    		String mdob=ExcelUtils.getCellData(count,4);	
    		String mssn=ExcelUtils.getCellData(count,5);	
 	    	String claimNo=ExcelUtils.getCellData(count, 22);
 	    	if (ExcelUtils.getCellData(count,0).isEmpty()) System.out.println("no valid data");
 	   		else{
 	   		
 	   		System.out.println("----------------------------------------------------");
		 	System.out.println("Running  Member's Claims- Edit Claims Iteration No:  " + ExcelUtils.getCellData(count,0));
		 	System.out.println("----------------------------------------------------");
 		
		 	Log.info("----------------------------------------------------");
		 	Log.info("Running- Member's Claims- Edit Claims- Iteration No:  " + ExcelUtils.getCellData(count,0));
		 	Log.info("----------------------------------------------------");
     
 	    	editMultipleMC(driver, mid, mlname, mfname,mdob, mssn, claimNo);
 	    	}
 	    	}
} catch (IOException e) {
    System.out.println("Test data file not found");
}   
}
	
	public static void editMultipleMC(WebDriver driver, String mid, String mlname, String mfname, String dob, String ssn, String claimNo) throws Exception{
		//step 1- open chrome
		driver= BrowserUtils.openChromeBrowser();
		
		//step 2 - open risk manager
		driver.get(Constant.URL);
	
		//click network user	
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.clickNetworkUser();
	
		//step  - open Member Activity
		HomePage homePageObject = new HomePage(driver);
		
		try{
			homePageObject.clickExitMyOpenCaseListing();
		}catch(Exception e)
		{ System.out.println("Blank Home Page");
		Log.info("log4j - msg -Blank Home Page");}
		
		
		homePageObject.clickMemberActivity();	
				
	
		//click member's claims
		MemberActivityPage memberActivityPageObject = new MemberActivityPage(driver);
		memberActivityPageObject.clickMembersClaims();
	
		
		//click on claim- to select the claim
  		MembersClaimsHistoryPage membersClaimsHistoryPageObject = new MembersClaimsHistoryPage(driver);
  	
  		//edit the claim
  		membersClaimsHistoryPageObject.editClaimMC( mid, mlname, mfname,dob, ssn, claimNo);	
}
	
	@AfterMethod
	  public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
	    System.out.println("Done with Member Claims -Edit Multiple claims \n\n");
	    Log.info("log4j - msg -Done with Member Claims-Edit Multiple claims \n\n");
	    if (fis != null)	fis.close();
	
	}
}


