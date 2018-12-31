package com.test;

import java.io.FileInputStream;
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

public class CEVAddClaim {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void ClaimsExaminerViewAddClaimsTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Claims Examiner View- Add Multiple Claims");
			Log.info("Executing Claims Examiner View- Add Multiple Claims");
			try{
				String Path=Constant.Path_TestData + Constant.File_TestDataForAddClaim_CEV;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String mid= ExcelUtils.getCellData(count,1);
		    		String mlname=ExcelUtils.getCellData(count,2);	
		    		String mfname=ExcelUtils.getCellData(count,3);	
		    		String mdob=ExcelUtils.getCellData(count,4);	
		    		String mssn=ExcelUtils.getCellData(count,5);	
		    		String claimPeriod= ExcelUtils.getCellData(count,6);
		    		String receivedDate=ExcelUtils.getCellData(count,7);
		    		String taxID=ExcelUtils.getCellData(count,8);
		    		String npi=ExcelUtils.getCellData(count,9);
		    		String pname=ExcelUtils.getCellData(count,10);
		    		String paddress=ExcelUtils.getCellData(count,11);
		    		String pspecial=ExcelUtils.getCellData(count,12);
		    		String pos=ExcelUtils.getCellData(count,13);
		    		String icd=ExcelUtils.getCellData(count,14);
		    		String diagnosisCode=ExcelUtils.getCellData(count,15);
		    		String cptCode=ExcelUtils.getCellData(count,16);
		    		String charges=ExcelUtils.getCellData(count,17);
		    		String quantity=ExcelUtils.getCellData(count,18);
		    		
		    		
		    		
		    		String modifier1=ExcelUtils.getCellData(count,19);
		    		String modifier2=ExcelUtils.getCellData(count,20);
		    		String modifier3=ExcelUtils.getCellData(count,21);
		    		
		    		if ( mid.isEmpty() ||mdob.isEmpty()) {System.out.println("");}
		 	   		else{
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Claims Examiner View-Add Claim-Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Claims Examiner View-Add Claim-Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		   		 	String newClaimNo= addClaimMultiple(driver,mid,mlname,mfname,mdob, mssn, claimPeriod,receivedDate,taxID,npi,pname,paddress,pspecial,pos,icd,diagnosisCode,cptCode,charges,quantity, modifier1, modifier2, modifier3);
		    	
		   		 ExcelUtils.setCellData(Path, newClaimNo, count, 22);
		 	   		}
		    	}
			}
		    catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
			
			public String addClaimMultiple(WebDriver driver,String mid,String mlname, String mfname, String mdob, String mssn, String claimPeriod,String receivedDate,String taxID,String npi,String pname,String paddress,String pspecial,String pos,String icd,String diagnosisCode,String cptCode,String charges,String quantity, String modifier1, String modifier2, String modifier3) throws Exception
			{
			
			System.out.println(mid +"mid");		
			System.out.println(mlname +"mlname");	
			System.out.println(mfname+"mfname");
			System.out.println(mdob+"mdob");
			System.out.println(mssn+"mssn");
			System.out.println(claimPeriod +"claim Period");			
			System.out.println(receivedDate +"received Date");			
			System.out.println(taxID +"taxID");			
			System.out.println(npi +"npi");			
			System.out.println(pname +"pname");			
			System.out.println(paddress +"paddress");			
			System.out.println(pspecial +"pspecial");			
			System.out.println(pos +"pos");			
			System.out.println(icd +"icd");		
			System.out.println(diagnosisCode +"diagnosis code");			
			System.out.println(cptCode +"cptcode");					
			System.out.println(charges +"charges");		
			System.out.println(quantity +"quantity");
			System.out.println(modifier1 +"modifier1");
			System.out.println(modifier2 +"modifier2");
			System.out.println(modifier3 +"modifier3");
			
				
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("opened browser");
						
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
			System.out.println("clicked Member activity");
						
			//click claim examiner view
			MemberActivityPage memberActivityPageObject = new MemberActivityPage(driver);
			memberActivityPageObject.clickClaimsExaminerView();
					
			
			//add new claim
			ClaimListingPage claimListingPageObject = new ClaimListingPage(driver);
			String newClaimNo= claimListingPageObject.CEVaddClaim(mid,mlname,mfname, mdob, mssn, claimPeriod,receivedDate,taxID,npi,pname,paddress,pspecial,pos,icd,diagnosisCode,cptCode,charges,quantity, modifier1, modifier2, modifier3);				
			return newClaimNo;
			}

		@AfterMethod
		public void afterMethod() throws Exception {
			try{if (driver!=null) driver.quit();}
			catch(Exception e) {System.out.println("After method, null pointer exception for driver");}
		System.out.println("Done with Claims Examiner View-Add Multiple claims \n\n");
		Log.info("Done with Claims Examiner View-Add Multiple claims \n\n");
		if (fis != null) 
				fis.close();
	}
			
}

