package com.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class CEVAddCommunication {

	FileInputStream fis;
	static WebDriver driver;
	static WebDriverWait wait;
	
	//public static void main(String args[]) throws Exception{
	@Test
	public void ClaimsExaminerViewAddCommunicationTestScript() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n*****************************************************\n");
	
		System.out.println("Executing Member claims Claim Communiccation");	
			
			try{
	 	    	String Path=Constant.Path_TestData + Constant.File_TestDataForAddClaim_CEV;
	 	    	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	 	    	for (int count=1; count<=rowCount; count++){
	 	    	String mid= ExcelUtils.getCellData(count,1);
	 	    	String mlname=ExcelUtils.getCellData(count,2);	
	    		String mfname=ExcelUtils.getCellData(count,3);	
	    		String mdob=ExcelUtils.getCellData(count,4);	
	    		String mssn=ExcelUtils.getCellData(count,5);	
	 	   		String claimNo=ExcelUtils.getCellData(count,22);
	 	   		String subject= ExcelUtils.getCellData(count,23);
	 	   		String noteType= ExcelUtils.getCellData(count,24);
	 	   		String details=ExcelUtils.getCellData(count,25);
	 	    	
	 	   	if (claimNo.isEmpty() || mid.isEmpty()) {System.out.println("");}
 	   		else{
	 	   		//System.out.println("Running test case " + ExcelUtils.getCellData(count,0));     
	 	   	System.out.println("\n----------------------------------------------------\n");
   		 	System.out.println("Running Claims Examiner View Claim Communication -Iteration No:  " + ExcelUtils.getCellData(count,0));
   		 	System.out.println("\n----------------------------------------------------\n");
	 	   		
   		 Log.info("----------------------------------------------------");
		 	Log.info("Running Claims Examiner View Claim Communication Iteration No:  " + ExcelUtils.getCellData(count,0));
		 	Log.info("----------------------------------------------------");
   		 	
   		 	addCommunicationForMultipleClaims(driver, mid, claimNo, subject, noteType, details);
 	   		}
	 	   }
	}catch (IOException e) {
	 	           System.out.println("Test data file not found");
	}   
}
			
	public static void addCommunicationForMultipleClaims(WebDriver Driver, String mid, String claimNo, String subject, String noteType, String details)	throws Exception{
	 				
	 				
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
			
			
		
	 		//Step 11 -  add communication
	 		claimListingPageObject.CEVaddCommunication( claimNo, subject, noteType, details);
	 		}
	 		
			
			
			
			
		@AfterMethod
		  public void afterMethod() throws Exception {
			try{if (driver!=null) driver.quit();}
			catch(Exception e) {System.out.println("After method, null pointer exception for driver");}
		    System.out.println("Done with Claims Examiner View- Add Multiple Claim Communication\n\n");
		  Log.info("Done with Claims Examiner View- Add Multiple Claim Communication\n\n");
		    if (fis != null) 
					fis.close();
			
		} 

}
