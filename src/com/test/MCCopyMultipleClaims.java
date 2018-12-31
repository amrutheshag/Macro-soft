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

public class MCCopyMultipleClaims {
	WebDriver driver;
	FileInputStream fis;
		
	@Test
	public void MemberClaimsCopyTestScript() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		System.out.println("Executing Member Claims Copy Multiple Claims");
		Log.info(" Executing Member Claims Copy Multiple Claims");
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
			 	   		String newDOS= ExcelUtils.getCellData(count,26);
			 	   		
			 	   		if (ExcelUtils.getCellData(count,0).isEmpty()) System.out.println("");
			 	   		else{
			 	   	System.out.println("----------------------------------------------------");
		   		 	System.out.println("Running Member's Claims - Copy Claims-Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("----------------------------------------------------");
			 	    	
			 	    	
			 	    	
			 	    	Log.info("----------------------------------------------------");
			   		 	Log.info("Running Member's Claims - Copy Claims- Iteration No:  " + ExcelUtils.getCellData(count,0));
			   		 	Log.info("----------------------------------------------------");
			 	    	
			 	    	String newClaim= copyMultipleClaims(driver, mid, mlname, mfname, mdob, mssn,claimNo, newDOS);
			 	    	ExcelUtils.setCellData(Path, newClaim, count,27);
			 	    	}
			 	    	}
		   
		    } catch (IOException e) {
		        System.out.println("Test data file not found");
		    }   
	}
	public static String copyMultipleClaims(WebDriver driver, String mid, String mlname, String mfname, String dob, String ssn, String claimNo, String newDOS) throws Exception{
		
		//Step 2 - open chrome
		driver= BrowserUtils.openChromeBrowser();
			
		//Step 4 - open risk manager		
		driver.get(Constant.URL);
			
		//Step 5 - click network user
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.clickNetworkUser();
		
		//Step 6 - open Member Activity
		HomePage homePageObject = new HomePage(driver);
		
		try{
			homePageObject.clickExitMyOpenCaseListing();
		}catch(Exception e)
		{ System.out.println("Blank Home Page");
		Log.info("log4j - msg -Blank Home Page");}
		
		homePageObject.clickMemberActivity();	
		
		//Step 7 - click Member's claims
		MemberActivityPage memberActivityPageObject = new MemberActivityPage(driver);
		memberActivityPageObject.clickMembersClaims();
			
		
		//Step 10 - click on claim to be copied and click copy
		MembersClaimsHistoryPage membersClaimsHistoryPageObject = new MembersClaimsHistoryPage(driver);
				
		//Step 11 - copy Claim and make changes and save it, capture the new claim no.
		String newClaim= membersClaimsHistoryPageObject.copyClaimMC( mid, mlname,mfname, dob, ssn, claimNo, newDOS);
		return newClaim;
		
	}
	
	@AfterMethod
		  public void afterMethod() throws Exception {
			if (driver!=null) driver.quit();
		
		    System.out.println("Done with Member Claims- Copy Multiple claims. \n \n");
		    Log.info("log4j - Done with Member Claims- Copy Multiple claims. \n \n");
		    if (fis != null)	fis.close();
		}

}


