package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MemberActivityPage;
import com.pages.MembersPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CreateTestData {
	static WebDriver driver;
	FileInputStream fis;
		@Test
		public void createTestDataTestScript() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing  Create Test Data");
			Log.info("Executing Create Test Data");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_TestDataToAdd;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String mid= 		ExcelUtils.getCellData(count,1);
				 	String mlname=		ExcelUtils.getCellData(count, 2);
				 	String mfname=		ExcelUtils.getCellData(count, 3);
				 	String mdob= 		ExcelUtils.getCellData(count, 4);
				 	String mssn= 		ExcelUtils.getCellData(count,5);
				 	
				 	String maddress= ExcelUtils.getCellData(count,6);
		 	    	String mcity= ExcelUtils.getCellData(count,7);
		 	    	String mstate= ExcelUtils.getCellData(count,8);
		 	    	String mzip	= ExcelUtils.getCellData(count,9);
		 	    	String coverageEffectivePeriod	= ExcelUtils.getCellData(count,13);
		 	    	String relationToSubscriber	= ExcelUtils.getCellData(count,14);
		 	    	String payerCode	= ExcelUtils.getCellData(count,15);
		 	    	String coverageSequence	= ExcelUtils.getCellData(count,16);
		 	    	String coverageExtent	= ExcelUtils.getCellData(count,17);
		 	    	
		 	    	
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Create Test Data- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Create Test Data- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		   		 addTestDataMultiple(driver,mid, mlname,mfname,mdob, mssn,maddress, mcity, mstate, mzip, coverageEffectivePeriod, relationToSubscriber,payerCode, coverageSequence, coverageExtent);}
			}
			}
		    	catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void addTestDataMultiple(WebDriver driver,String mid, String mlname, String mfname, String mdob, String mssn, String maddress, String mcity, String mstate, String mzip, String coverageEffectivePeriod, String relationToSubscriber,String payerCode, String coverageSequence, String coverageExtent) throws Exception
			{
			
			
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
			
			//create member activity page object
			MemberActivityPage memberActivityPageObject = new MemberActivityPage(driver);
			//click members
			memberActivityPageObject.clickMembers();
			MembersPage membersPageObject= new MembersPage(driver);
			membersPageObject.addMember( mid, mlname, mfname, mdob, mssn, maddress,mcity, mstate, mzip, coverageEffectivePeriod, relationToSubscriber,payerCode, coverageSequence, coverageExtent);
			
			
		//	membersPageObject.findApprovedClaim(driver);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
			if (driver!=null) driver.quit();
				System.out.println("Done with Create Test Data \n\n");
			if (fis != null) 
				fis.close();
		}
			
}
