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

public class MCDeleteMultipleClaims {
	WebDriver driver;
	FileInputStream fis;
	
	@Test
	public void MemberClaimsDeleteTestScript() throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
	//public static void main(String args[]) throws InterruptedException{
		
		System.out.println("Executing Member Claims Delete Multiple Claims");
		
		
		try{
 	    	String Path=Constant.Path_TestData + Constant.File_TestDataForAddClaim_MC;
 	    	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
 	    	for (int count=1; count<=rowCount; count++){
 	    		//String mid= ExcelUtils.getCellData(count,1);
 	    		//String mlname=ExcelUtils.getCellData(count,2);	
	    		//String mfname=ExcelUtils.getCellData(count,3);	
	    	//	String mdob=ExcelUtils.getCellData(count,4);	
	    	//	String mssn=ExcelUtils.getCellData(count,5);	
	 	    	String claimNo=ExcelUtils.getCellData(count, 22);
	 	    	
	 	    	String mid= ExcelUtils.getCellData(count,28);
	    		String mlname=ExcelUtils.getCellData(count,29);	
	    		String mfname=ExcelUtils.getCellData(count,30);	
	    		String mdob=ExcelUtils.getCellData(count,31);	
	    		String mssn=ExcelUtils.getCellData(count,32);
	 	    	if (ExcelUtils.getCellData(count,0).isEmpty()) System.out.println("");
	 	   		else{
 	    		System.out.println("----------------------------------------------------");
	   		 	System.out.println("Running Member's Claims- Delete Claims -Iteration No:  " + ExcelUtils.getCellData(count,0));
	   		 	System.out.println("----------------------------------------------------");
 	    		
	   		 	Log.info("----------------------------------------------------");
	   		 	Log.info("Running Member's Claims- Delete Claims -Iteration No:  " + ExcelUtils.getCellData(count,0));
	   		 	Log.info("----------------------------------------------------");
 	    		
 	    		
 	    		deleteMultipleMC(driver, mid,mlname, mfname, mdob, mssn, claimNo);
 	    	} 
		}
		}
 	    	catch (IOException e) {
			
		
 	    		System.out.println("Test data file not found");
 	    }   
	}	
		
	public static void deleteMultipleMC(WebDriver driver, String mid, String mlname, String mfname, String mdob, String mssn, String claimNo) throws Exception{
		
		//STEP 2 - OPEN CHROME BROWSER
		driver= BrowserUtils.openChromeBrowser();
		
		//STEP 3 - OPEN RISK MANAGER
		driver.get(Constant.URL);
		
		//STEP 4 - Click Network User
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.clickNetworkUser();
		
		//STEP 5 - click Member Activity
		HomePage homePageObject = new HomePage(driver);
		
		try{
			homePageObject.clickExitMyOpenCaseListing();
		}catch(Exception e)
		{ System.out.println("Blank Home Page");
		Log.info("log4j - msg -Blank Home Page");}
		
		homePageObject.clickMemberActivity();	
				
		// STEP 6 - Click Membersclaims
		MemberActivityPage memberActivityPageObject = new MemberActivityPage(driver);
		memberActivityPageObject.clickMembersClaims();
		
		
		//STEP 8 - ENTER CLAIM NUMBER, 	// STEP 8  press RETURN
		MembersClaimsHistoryPage membersClaimsHistoryPageObject = new MembersClaimsHistoryPage(driver);
						
		//STEP 9 - click on the claim number to be deleted
		membersClaimsHistoryPageObject.deleteClaimNumberMC(mid,mlname, mfname, mdob, mssn, claimNo);	
		}

	
	@AfterMethod
	  public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
	    System.out.println("Done with Delete- Member Claim");
	    Log.info("log4j - msg -Done with Delete- Member Claim");
		if (fis != null)	fis.close();
	}

}
