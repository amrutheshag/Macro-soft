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

public class CEVEditClaim {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public void ClaimsExaminerViewEditClaim() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		//public static void main (String args[]) throws InterruptedException, EncryptedDocumentException, FileNotFoundException, InvalidFormatException, IOException{
	
		System.out.println("\n\n Executing Claims Examiner View -Edit Multiple Claims");
		
	
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
 	    	
	    	if (claimNo.isEmpty() || mid.isEmpty()) {System.out.println("");}
 	   		else{
     
 	   	System.out.println("\n----------------------------------------------------\n");
		 	System.out.println("Executing Claims Examiner View -Edit Claims Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		 	System.out.println("\n----------------------------------------------------\n");
		 	Log.info("----------------------------------------------------");
   		 	Log.info("Running Claims Examiner View- Edit Claims- Iteration No:  " + ExcelUtils.getCellData(count,0));
   		 	Log.info("----------------------------------------------------");
 	   		
 	    	CEVeditMultiple(driver, mid, claimNo);
 	    	}
 	    	}
} catch (IOException e) {
    System.out.println("Test data file not found");
}   
}
	
	public static void CEVeditMultiple(WebDriver driver, String mid, String claimNo) throws Exception{
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
				

		//click claim examiner view
		MemberActivityPage memberActivityPageObject = new MemberActivityPage(driver);
		memberActivityPageObject.clickClaimsExaminerView();
								
		ClaimListingPage claimListingPageObject = new ClaimListingPage(driver);
		claimListingPageObject.CEVsearchClaim( claimNo);   
				Thread.sleep(2000);
				
		//find disposition & adjudicate of not already done
		claimListingPageObject.CEVeditClaim( mid, claimNo);
					
			}
	
	@AfterMethod
	  public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		
	    System.out.println("Done with Claims Examiner View-Edit Multiple claims \n\n");
	    Log.info("Done with Claims Examiner View-Edit Multiple claims \n\n");
	    if (fis != null) 
				fis.close();
			
	
	}
}


