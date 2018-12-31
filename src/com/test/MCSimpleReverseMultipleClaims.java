package com.test;

import java.io.FileInputStream;
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

public class MCSimpleReverseMultipleClaims {

	WebDriver driver;
	FileInputStream fis;
	@Test
	public void MemberClaimsSimpleReverseTestScript() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		System.out.println("Executing Member Claims-Simple Claim Reversal for Multiple Claims");
		
		
		try{
			String Path=Constant.Path_TestData + Constant.File_TestDataForAddClaim_MC;
		   	System.out.println("getting data from excel");
		   	
		   	
			int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	    	for (int count=1; count<=rowCount; count++){
	    		String mid= ExcelUtils.getCellData(count,1);
	    		String mlname=ExcelUtils.getCellData(count,2);	
	    		String mfname=ExcelUtils.getCellData(count,3);	
	    		String mdob=ExcelUtils.getCellData(count,4);	
	    		String mssn=ExcelUtils.getCellData(count,5);	
	 	    	String claimNo=ExcelUtils.getCellData(count, 22); 		
	    		String receivedDate= ExcelUtils.getCellData(count,7);
	    		
	    		if (mid.isEmpty() ||claimNo.isEmpty() || receivedDate.isEmpty()){
	    			System.out.println("  "); 
	    		}
	    		else{
	    			System.out.println("----------------------------------------------------");
		   		 	System.out.println("Running Member's Claims- Simple Reverse-Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("----------------------------------------------------");
	 	    		
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Running Member's Claims- Simple Reverse- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
	    		 	simpleReverseClaimMultiple(driver,mid, mlname,mfname, mdob, mssn, claimNo, receivedDate);
	    		}
	    	}
		}
	    catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
	}
	public void simpleReverseClaimMultiple(WebDriver driver, String mid, String mlname, String mfname, String mdob, String mssn, String claimNo, String receivedDate) throws Exception{
		
		System.out.println(mid +"mid");	
		System.out.println(mlname +"mlname");	
		System.out.println(mfname +"mfname");	
		System.out.println(mdob +"mdob");	
		System.out.println(mssn +"mssn");	
		
		System.out.println(claimNo +"claim Number");			
		System.out.println(receivedDate +"received Date");
	
		// Launch Chrome Browser
		driver= BrowserUtils.openChromeBrowser();
		
		//open risk manager
		driver.get(Constant.URL);
		System.out.println("opened browser");
		
		//click network user
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.clickNetworkUser();
		System.out.println("clicked Network user");
				
		//click member activity
		HomePage homePageObject = new HomePage(driver);
		
		try{
			homePageObject.clickExitMyOpenCaseListing();
		}catch(Exception e)
		{ System.out.println("Blank Home Page");
		Log.info("log4j - msg -Blank Home Page");}
		
		homePageObject.clickMemberActivity();	
		System.out.println("clicked Member activity");
		
		//click on members claims
		MemberActivityPage memberActivityPageObject = new MemberActivityPage(driver);
		memberActivityPageObject.clickMembersClaims();
		System.out.println("clicked Members claims");
		
	
		//simple reverse
		

		MembersClaimsHistoryPage membersClaimsHistoryPageObject = new MembersClaimsHistoryPage(driver);
		membersClaimsHistoryPageObject.simpleReverseClaim(mid,mlname, mfname, mdob, mssn, claimNo, receivedDate);
		
	}	

 @AfterMethod
  public void afterMethod() throws Exception {
	if (driver!=null) driver.quit();
    System.out.println("Done with Member Claims Multiple claim reversal \n \n");
    Log.info("Done with Member Claims Multiple claim reversal \n \n");
    if (fis != null || driver!=null) 
			fis.close();
 }
	
}
