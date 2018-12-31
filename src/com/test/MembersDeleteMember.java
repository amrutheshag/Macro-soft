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

public class MembersDeleteMember {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public  void memberDeleteTestScript() throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n ********************************************************************");
		System.out.println("Executing Members- Delete Member  ");
	try{
		 	    	String Path=Constant.Path_TestData + Constant.File_TestDataToDelete_Members;
		 	    	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		 	    	for (int count=1; count<=rowCount; count++){
		 	    	String mid= ExcelUtils.getCellData(count,1);
		 	   		String mlname=ExcelUtils.getCellData(count, 2);
		 	   		String mfname= ExcelUtils.getCellData(count, 3);
		 	   		String mdob= ExcelUtils.getCellData(count, 4);
		 	   		String ssn= ExcelUtils.getCellData(count, 5);
		 	    	String maddr= ExcelUtils.getCellData(count,6);
		 	    	String mcity= ExcelUtils.getCellData(count,7);
		 	    	String mstate= ExcelUtils.getCellData(count,8);
		 	    	String mzip= ExcelUtils.getCellData(count,9);
		 	    	String mgender= ExcelUtils.getCellData(count,12);	 	    	
		 	   		if (mlname.isEmpty() || mid.isEmpty()) {System.out.println("");}
		 	   		else{
		 	   		System.out.println("-------------------------------------------------------------");
		 	   		System.out.println("Running Members-Delete Members Iteration No: " + ExcelUtils.getCellData(count,0));
		 	   		System.out.println("-------------------------------------------------------------");
		 	   		
		 	   	Log.info("----------------------------------------------------");
	   		 	Log.info("Running Members-Delete Members- Iteration No:  " + ExcelUtils.getCellData(count,0));
	   		 	Log.info("----------------------------------------------------");
		 	   		
		 	   		deleteMultipleMembers(driver, mid, mlname, mfname, mdob, ssn, maddr, mcity, mstate, mzip);
		 	    	
		 	   		}
		 	    	}
	   
	    } catch (IOException e) {
	        System.out.println("Test data file not found");
	        driver.close();
	    }   
	}
 


public  void deleteMultipleMembers(WebDriver driver, String mid, String mLastName, String mFirstName, String mdob, String ssn, String maddr, String mcity, String mstate, String mzip) throws Exception {
	
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
		membersPageObject.deleteMember( mid, mLastName, mFirstName, mdob, ssn, maddr, mcity, mstate, mzip); 
	
}
		  
	@AfterMethod
	  public void afterMethod() throws Exception {
	    System.out.println("Done with Members- Delete Member");
		if (driver !=null) driver.quit();
		if (fis != null)	fis.close();
	}
	
}
