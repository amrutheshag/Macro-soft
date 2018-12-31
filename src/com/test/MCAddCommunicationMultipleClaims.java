package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class MCAddCommunicationMultipleClaims {
	FileInputStream fis;
	static WebDriver driver;
	static WebDriverWait wait;
	
	@Test
	public void MemberClaimsAddCommunicationTestScript() throws Exception{
		DOMConfigurator.configure("log4j.xml");	
		System.out.println("Executing Member Claims Add Communication Multiple Claims");	
		Log.info(" Executing Member Claims Add Communication Multiple Claims");	
			try{
	 	    	String Path=Constant.Path_TestData + Constant.File_TestDataForAddClaim_MC;
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
	 	   	
	 	   	if (ExcelUtils.getCellData(count,0).isEmpty()) System.out.println("");
 	   		else{
	 	   		System.out.println("----------------------------------------------------");
   		 	System.out.println("Running Iteration No:  " + ExcelUtils.getCellData(count,0));
   		 	System.out.println("----------------------------------------------------");
	 	   	  
	 	    
	 	   	Log.info("----------------------------------------------------");
   		 	Log.info("Running Member's Claims- Add Communication- Iteration No:  " + ExcelUtils.getCellData(count,0));
   		 	Log.info("----------------------------------------------------");
	 	   		
	 	   		addCommunicationForMultipleClaims(driver, mid, mlname, mfname, mdob, mssn, claimNo, subject, noteType, details);
	 	    	} 
	 	    	}
    } catch (IOException e) {
        System.out.println("Test data file not found");
    }   
	}
			
public static void addCommunicationForMultipleClaims(WebDriver Driver, String mid, String mlname, String mfname, String mdob, String mssn, String claimNo, String subject, String noteType, String details)	throws Exception{
					
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
			
			//Step 11 -  add communication
			MembersClaimsHistoryPage membersClaimsHistoryPageObject = new MembersClaimsHistoryPage(driver);
			membersClaimsHistoryPageObject.addCommunicationMC( mid, mlname, mfname, mdob, mssn, claimNo, subject, noteType, details);
		}
	
		@AfterMethod
		 public void afterMethod() throws Exception {
			if (driver!=null) driver.quit();
			System.out.println("Done with MC Add Communication Multiple Claims\n\n");
		  
		    if (fis != null) fis.close();
		} 
}

