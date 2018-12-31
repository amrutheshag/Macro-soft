package com.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.ClaimListingPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MemberActivityPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CEVCopyClaim {
	WebDriver driver;
	FileInputStream fis;
	//public static void main(String args[]) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException{
		
	@Test
	public void ClaimExaminerViewCopyClaimTestScript() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n**********************************************************************\n");
		System.out.println("\n\n Executing Claims Examiner View-  Copy Multiple Claims");
			
		try{
			String Path=Constant.Path_TestData + Constant.File_TestDataForAddClaim_CEV;
			 int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
			 for (int count=1; count<=rowCount; count++){
			 	   String mid= ExcelUtils.getCellData(count,1);
			 	  String mlname=ExcelUtils.getCellData(count,2);	
		    		String mfname=ExcelUtils.getCellData(count,3);	
		    		String mdob=ExcelUtils.getCellData(count,4);	
		    		String mssn=ExcelUtils.getCellData(count,5);	
			 	   String claimNo=ExcelUtils.getCellData(count, 22);
			 	   String newDOS= ExcelUtils.getCellData(count,26);
			 	   if (claimNo.isEmpty() || mid.isEmpty()) {System.out.println("");}
			 	   else{
			 	   	//System.out.println("Running test case " + ExcelUtils.getCellData(count,0));
			 		  System.out.println("\n----------------------------------------------------\n");
			   		 	System.out.println("Running Claims Examiner View- Copy Claim Iteration No:  " + ExcelUtils.getCellData(count,0));
			   		 	System.out.println("\n----------------------------------------------------\n");
			   		 Log.info("----------------------------------------------------");
			   		 	Log.info("Running Claims Examiner View- Copy Claims- Iteration No:  " + ExcelUtils.getCellData(count,0));
			   		 	Log.info("----------------------------------------------------");
			 	   	
			 	   	String newClaim= CEVcopyMultipleClaims(driver, mid, claimNo, newDOS);
			 	    ExcelUtils.setCellData(Path, newClaim, count,27);
			 	    }
			 }
		  } catch (IOException e) {
		        System.out.println("Test data file not found");
		  }   
	}
	public static String CEVcopyMultipleClaims(WebDriver driver, String mid, String claimNo, String newDOS) throws Exception{
		
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
		
		//click claim examiner view
		MemberActivityPage memberActivityPageObject = new MemberActivityPage(driver);
		memberActivityPageObject.clickClaimsExaminerView();
		
		//search claim				
		ClaimListingPage claimListingPageObject = new ClaimListingPage(driver);
		claimListingPageObject.CEVsearchClaim( claimNo);   
	Thread.sleep(2000);
	
		//Step 11 - copy Claim and make changes and save it, capture the new claim no.
		String newClaim= claimListingPageObject.CEVcopyClaim( claimNo, newDOS);
		return newClaim;
		
	}
	
	@AfterMethod
		  public void afterMethod() throws Exception {
			if (driver!=null) driver.quit();
			if (fis != null)  fis.close();
		    
		    System.out.println("Done with Claims Examiner View- Copy Claim");
		    Log.info("Done with Examiner View- Copy Claim");
				
		}

}
