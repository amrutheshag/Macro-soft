package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.CommunicationsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MyOpenCasesForFollowUpListingPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class MyOpenCasesForFollowUpAdd {
	FileInputStream fis;
	WebDriver driver;
	@Test
	public  void MyOpenCasesForFollowUpAddTestScript () throws Exception{
		
		DOMConfigurator.configure("log4j.xml");
		System.out.println("\n********************************************************************");
		System.out.println("Executing  Add My Open Cases for Followup ");
	try{
		 	    	String Path=Constant.Path_TestData + Constant.File_TestDataForMyOpenCasesForFollowup;
		 	    	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		 	    	for (int count=1; count<=rowCount; count++){
		 	    	String date= ExcelUtils.getCellData(count,1);
		 	       	String subject= ExcelUtils.getCellData(count,2);
		 	    	//String followUpDate= ExcelUtils.getCellData(count,3);
		 	       
		 	    	String type= ExcelUtils.getCellData(count,4);
		 	    	String status= ExcelUtils.getCellData(count,5);
		 	    	String priority= ExcelUtils.getCellData(count,6);
		 	 
		 	    	String noteType= ExcelUtils.getCellData(count,7);
		 	    	String medium= ExcelUtils.getCellData(count,8);
		 	    	String details= ExcelUtils.getCellData(count,9);
		 	    	
		 	    	
		 	    	 // Create object of SimpleDateFormat class and decide the format
		 	    	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		 	    	 
		 	    	 //get current date time with Date()
		 	    	 Date fdate = new Date();
		 	    	 
		 	    	 // Now format the date
		 	    	 String followUpDate= dateFormat.format(fdate);

		 	    	
		 	    	
		 	    	
		 	   		if (date.isEmpty() || subject.isEmpty()) {System.out.println("");}
		 	   		else{
		 	   		System.out.println("-------------------------------------------------------------");
		 	   		System.out.println("Running Add My Open cases for Followup- Iteration No: " + ExcelUtils.getCellData(count,0));
		 	   		System.out.println("-------------------------------------------------------------");
		 	   
		 	   	Log.info("----------------------------------------------------");
	   		 	Log.info("Running Add My Open Cases for Followup- Iteration No:  " + ExcelUtils.getCellData(count,0));
	   		 	Log.info("----------------------------------------------------");
		 	   		
		 	   		
		 	   		
		 	   		addMyOpenCasesMultiple(driver,subject,  type,  status, priority, followUpDate, noteType, medium, details);
		 	   		
		 	   	
		 	    	}
		 	    	}
	   
	    } catch (IOException e) {
	        System.out.println("Test data file not found");
	   
	    }   
	}
 


public  void addMyOpenCasesMultiple(WebDriver driver, String subject, String type,  String status, String priority, String followUpDate, String noteType, String medium, String details) throws Exception {
	
		// Start a browser driver and navigate to Google
		driver= BrowserUtils.openChromeBrowser();
		
		//open risk manager
		driver.get(Constant.URL);
		
		//click network user
		LoginPage loginPageObject = new LoginPage(driver);
		loginPageObject.clickNetworkUser();
		

		HomePage homePageObject = new HomePage(driver);
		
		try{
			homePageObject.clickExitMyOpenCaseListing();
		}catch(Exception e)
		{ System.out.println("Blank Home Page");
		Log.info("log4j - msg -Blank Home Page");}
		
		homePageObject.clickCommunications();	
		
		//click my open cases
		CommunicationsPage communicationsPageObject= new CommunicationsPage(driver);
		communicationsPageObject.clickMyOpenCasesForFollowUp();
		
		
	
		MyOpenCasesForFollowUpListingPage myOpenCasesForFollowUpPageObject= new MyOpenCasesForFollowUpListingPage(driver);
		myOpenCasesForFollowUpPageObject.addMyOpenCasesForFollowUp(subject,  type,  status, priority, followUpDate, noteType, medium, details);

}
		  
	@AfterMethod
	  public void afterMethod() throws Exception {
	    System.out.println("Done with My Open Cases For Followup- Add");
		if (driver !=null) driver.quit();
		
	    if (fis != null) 	fis.close();
	}
	
}
