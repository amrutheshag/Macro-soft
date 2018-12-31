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
import com.pages.MembersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class MembersEditMember {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public  void memberEditTestScript() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		
		System.out.println("\n ********************************************************************");
		System.out.println("Executing Members- Edit Member  ");
	try{
		String Path=Constant.Path_TestData + Constant.File_TestDataToAdd_Members;
		 	    	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		 	    	for (int count=1; count<=rowCount; count++){
		 	    		String mid= ExcelUtils.getCellData(count,1);
			 	   		String mlname=ExcelUtils.getCellData(count, 2);
			 	   		String mfname=ExcelUtils.getCellData(count, 3);
			 	   		String mdob= ExcelUtils.getCellData(count, 4);
			 	   		String ssn =  ExcelUtils.getCellData(count, 5);
			 	    	String maddress= ExcelUtils.getCellData(count,6);
			 	    	String mcity= ExcelUtils.getCellData(count,7);
			 	    	String mstate= ExcelUtils.getCellData(count,8);
			 	    	String mzip	= ExcelUtils.getCellData(count,9);
			 	    	String coverageEffectivePeriod	= ExcelUtils.getCellData(count,13);
			 	    	String relationToSubscriber	= ExcelUtils.getCellData(count,14);
			 	    	String payerCode	= ExcelUtils.getCellData(count,15);
			 	    	String coverageSequence	= ExcelUtils.getCellData(count,16);
			 	    	String coverageExtent	= ExcelUtils.getCellData(count,17);
			 	    	
			 	    	
			 	    	String subject= ExcelUtils.getCellData(count,18);
			 	    	String noteType= ExcelUtils.getCellData(count,19);
			 	    	String details= ExcelUtils.getCellData(count,20);
			 	    	
			 	    	
			 	    	String newmid= ExcelUtils.getCellData(count,21);
			 	    	String newmname= ExcelUtils.getCellData(count,22);
			 	    	String newdob= ExcelUtils.getCellData(count,23);
			 	    	String newhph= ExcelUtils.getCellData(count,24);
			 	    	
			 	    	String hicnid= ExcelUtils.getCellData(count,25);
		 	   		if (mlname.isEmpty() || mid.isEmpty()) {System.out.println("");}
		 	   		else{
		 	   		System.out.println("-------------------------------------------------------------");
		 	   		System.out.println("Running Members- Edit Members Iteration No: " + ExcelUtils.getCellData(count,0));
		 	   		System.out.println("-------------------------------------------------------------");
		 	   		
		 	   	Log.info("----------------------------------------------------");
	   		 	Log.info("Running Members- Edit Members- Iteration No:  " + ExcelUtils.getCellData(count,0));
	   		 	Log.info("----------------------------------------------------");
		 	   		
		 	   		
		 	   		editMultipleMembers(driver, mid, mlname, mdob, ssn, hicnid);
		 	    	}
		 	    	}
	   
	    } catch (IOException e) {
	        System.out.println("Test data file not found");
	    }   
	}
 


public  void editMultipleMembers(WebDriver driver, String mid, String mname, String mdob, String ssn, String hicnid) throws Exception {
	
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
		memberActivityPageObject.clickMembers();
	
		MembersPage membersPageObject= new MembersPage(driver);
		membersPageObject.editMember(mid, mname, mdob, ssn, hicnid);

}
		  
	@AfterMethod
	  public void afterMethod() throws Exception {
	    System.out.println("Done with Members- Edit Member");
		if (driver!=null) driver.quit();
	    if (fis != null) fis.close();
	}
}	

