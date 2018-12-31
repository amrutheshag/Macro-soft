package com.test;

import java.io.FileInputStream;
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

public class MCMoveMultipleClaims {
	static WebDriverWait wait;
	WebDriver driver;
	FileInputStream fis;
	
	@Test
	public void MemberClaimsMoveTestScript() throws Exception{
	DOMConfigurator.configure("log4j.xml");	
	System.out.println("Executing Member Claims- Move Multiple Claims");
	Log.info(" Executing Member Claims- Move Multiple Claims");
	
	try{
		
    		
    		
    		String Path=Constant.Path_TestData + Constant.File_TestDataForAddClaim_MC;
		   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	    	for (int count=1; count<=rowCount; count++){
	    		String oldMID= ExcelUtils.getCellData(count,1);
	    		String oldmlname=ExcelUtils.getCellData(count,2);	
	    		String oldmfname=ExcelUtils.getCellData(count,3);	
	    		String oldmdob=ExcelUtils.getCellData(count,4);	
	    		String oldmssn=ExcelUtils.getCellData(count,5);	
	    		
	    		
	    		
	    		String claimNo=ExcelUtils.getCellData(count,22);	
	    		String newMID= ExcelUtils.getCellData(count,28);
	    		String newmlname=ExcelUtils.getCellData(count,29);	
	    		String newmfname=ExcelUtils.getCellData(count,30);	
	    		String newmdob=ExcelUtils.getCellData(count,31);	
	    		String newmssn=ExcelUtils.getCellData(count,32);	
    		
    		if (claimNo.isEmpty() || oldMID.isEmpty() || newMID.isEmpty()) {System.out.println("");}
 	   			else{
    		System.out.println("----------------------------------------------------");
   		 	System.out.println("Running Member's Claims- Move Claims Iteration No:  " + ExcelUtils.getCellData(count,0));
   		 	System.out.println("----------------------------------------------------");
	    		
   		 	Log.info("----------------------------------------------------");
   		 	Log.info("Running Member's Claims- Move Claims- Iteration No:  " + ExcelUtils.getCellData(count,0));
   		 	Log.info("----------------------------------------------------");

   		 	moveClaimMultiple(driver, oldMID,oldmlname,oldmfname,oldmdob, oldmssn, claimNo, newMID, newmlname, newmfname, newmdob, newmssn);
	 	}
	}
	}
    catch (Exception e) {System.out.println("Test Data File not found");}
}
	
	public void  moveClaimMultiple(WebDriver driver, String oldMID, String oldmlname, String oldmfname, String oldmdob, String oldmssn,String claimNo, String newMID, String newmlname, String newmfname, String newmdob, String newmssn) throws Exception{
		
		// Launch Chrome Browser
		driver= BrowserUtils.openChromeBrowser();
					
		//open risk manager
		driver.get(Constant.URL);
					
		//click network user
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.clickNetworkUser();
							
		//click member activity
		HomePage homePageObject = new HomePage(driver);
		
		try{
			homePageObject.clickExitMyOpenCaseListing();
		}catch(Exception e)
		{ System.out.println("Blank Home Page");
		Log.info("log4j - msg -Blank Home Page");}
		
		
		homePageObject.clickMemberActivity();	
							
		//click on members claims
		MemberActivityPage memberActivityPageObject = new MemberActivityPage(driver);
		memberActivityPageObject.clickMembersClaims();			
		
		MembersClaimsHistoryPage membersClaimsHistoryPageObject = new MembersClaimsHistoryPage(driver);
		
		String x= membersClaimsHistoryPageObject.moveClaim( oldMID,  oldmlname, oldmfname, oldmdob, oldmssn, claimNo, newMID, newmlname, newmfname, newmdob, newmssn);
		if (x=="fail") {System.out.println("Move Claim failed"); Log.info("log4j - msg - Move Claim failed");}
		else {System.out.println("Move Claim successful"); Log.info("log4j - msg - Move Claim successful");}
		
	}
		
	
	@AfterMethod
	  public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
	    System.out.println("Done with Member Claims move multiple claims.\n\n");
	    Log.info("log4j - msg - Done with Member Claims move multiple claims.\n\n");
	    if (fis != null) 	fis.close();
	}
}

