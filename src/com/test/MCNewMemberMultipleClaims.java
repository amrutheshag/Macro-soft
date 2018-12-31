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
import com.pages.SelectMemberPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class MCNewMemberMultipleClaims {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public void MemberClaimsNewMemberTestScript() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		System.out.println("Executing Member Claims- New Member- Multiple Claims");
		Log.info("Executing Member Claims- New Member- Multiple Claims");
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
	   		 	System.out.println("Running Member's Claims- New Member- Iteration No:  " + ExcelUtils.getCellData(count,0));
	   		 	System.out.println("----------------------------------------------------");
 	    		
	   		 	Log.info("----------------------------------------------------");
	   		 	Log.info("Running Member's Claims- New Member-  Iteration No:  " + ExcelUtils.getCellData(count,0));
	   		 	Log.info("----------------------------------------------------");
 
	   		 	newMemberMultiple(driver, oldMID, oldmlname, oldmfname, oldmdob, oldmssn,claimNo, newMID, newmlname, newmfname, newmdob, newmssn);
	    	}
		}
		}
	    catch (Exception e) {System.out.println("Test Data File not found");}
	}
		
		
		
		
		

		public void newMemberMultiple(WebDriver driver, String oldMID, String oldmlname, String oldmfname, String oldmdob, String oldmssn, String claimNo, String newMID, String newmlname, String newmfname, String newmdob, String newmssn) throws Exception{
			
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
			
			
			// - search on mid and return selection
			SelectMemberPage selectMemberPageObject= new SelectMemberPage(driver);
			selectMemberPageObject.searchMember( oldMID, oldmlname,oldmfname, oldmdob, oldmssn);
			
			
			// select on claim no
			MembersClaimsHistoryPage membersClaimsHistoryPageObject = new MembersClaimsHistoryPage(driver);
			membersClaimsHistoryPageObject.selectClaim( claimNo);
			
			driver= membersClaimsHistoryPageObject.newMemberMC( oldMID, claimNo, newMID);
			selectMemberPageObject.searchMember( newMID, newmlname, newmfname, newmdob, newmssn);
			System.out.println("New member selected, check new member claim history");	
			Thread.sleep(1000);
			driver.close();
		}
		@AfterMethod
		  public void afterMethod() throws Exception {
			if (driver!=null) driver.quit();
		    System.out.println("Done with Member Claims- New Member- Multiple Claims\n\n");
		    Log.info("Done with Member Claims- New Member- Multiple Claims\n\n");
		    if (fis != null)	fis.close();
		}
}
