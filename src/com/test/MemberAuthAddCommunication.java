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
import com.pages.MembersAuthorizationsPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class MemberAuthAddCommunication {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public  void memberAuthorizationAddCommunicationTestScript () throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n********************************************************************");
		System.out.println("Executing Members Authorizations- Add Communication ");
	try{
		 	    	
					String Path=Constant.Path_TestData + Constant.File_TestDataToAdd_MemAuth;
		 	    	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		 	    	for (int count=1; count<=rowCount; count++){
		 	    	String mid= ExcelUtils.getCellData(count,1);
		 	   		String mlname=ExcelUtils.getCellData(count, 2);
		 	   		String mfname=ExcelUtils.getCellData(count, 3);
		 	   		String mdob= ExcelUtils.getCellData(count, 4);
		 	   		String mssn= ExcelUtils.getCellData(count,5);
		 	    	//String maddress= ExcelUtils.getCellData(count,6);
		 	    	//String mcity= ExcelUtils.getCellData(count,7);
		 	    	//String mstate= ExcelUtils.getCellData(count,8);
		 	    	String refCertNo= ExcelUtils.getCellData(count,21);
		 	    	String subject= ExcelUtils.getCellData(count,24);
		 	    	String noteType= ExcelUtils.getCellData(count,25);
		 	    	String details= ExcelUtils.getCellData(count,26);
		 	    	
		 	    	
		 	   		if (mlname.isEmpty() || mid.isEmpty()) {System.out.println("");}
		 	   		else{
		 	   		System.out.println("----------------------------------------------------");
		   		 	System.out.println("Running Members Authorizations -Add Comm- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("----------------------------------------------------");
	 	    		
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Running Members Authorizations -Add Comm- Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
		 	   		addCommMultipleMA(driver, mid, mlname, mfname, mdob, mssn, refCertNo, subject, noteType, details);

}
}

   } catch (IOException e) {
	        System.out.println("Test data file not found");
	    }   
	}
 


public  void addCommMultipleMA(WebDriver driver, String mid, String mlname, String mfname, String mdob, String mssn, String refCertNo, String subject, String noteType, String details) throws Exception {
	
		// Start a browser driver and navigate to Google
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
		
		//click members
		MemberActivityPage memberActivityPageObject = new MemberActivityPage(driver);
		memberActivityPageObject.clickMembersAuthorizations();
		
		MembersAuthorizationsPage membersAuthorizationsPageObject= new MembersAuthorizationsPage(driver);
		membersAuthorizationsPageObject.addCommMemAuth( mid, mlname, mfname, mdob, mssn, refCertNo, subject, noteType,details);
	
}
		  
	@AfterMethod
	  public void afterMethod() throws Exception {
	    System.out.println("Done with Member's Authorizations- Add Communication");
		if (driver !=null) driver.quit();
	    if (fis != null)	fis.close();
	}
	
	

}
