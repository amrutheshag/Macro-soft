package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MemberSubscriberRelationships;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class MemberSubscriberRelationshipsEditTestScript {
	WebDriver driver;
	FileInputStream fis;
		@Test
		public void MemberSubscriberRelationshipsEditTestScript1() throws Exception{
			DOMConfigurator.configure("log4j.xml");
			System.out.println("\n*****************************************************\n");
			Log.info("\n*****************************************************\n");
			System.out.println("Executing Member-Subscriber Relationships- Edit");
			Log.info("Executing  Member-Subscriber Relationships- Edit ");
			
			
			try{
				String Path=Constant.Path_TestData + Constant.File_Add_MemberSubscriberRelationships;
			   	int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
		    	for (int count=1; count<=rowCount; count++){
		    		String membersubscriberRelationshipsCode= ExcelUtils.getCellData(count,1);
		    		String membersubscriberRelationshipsDescription=ExcelUtils.getCellData(count,2);	
		    		String membersubscriberRelationshipsNewCode= ExcelUtils.getCellData(count, 3);
		    		String membersubscriberRelationshipsNewDescription= ExcelUtils.getCellData(count, 4);
		    		String membersubscriberRelationshipsRecordMark= ExcelUtils.getCellData(count, 5);
		    		
		    				
		    						//String membersubscriberRelationshipsCommSubject= ExcelUtils.getCellData(count, 6);
		    						///String membersubscriberRelationshipsCommNoteType = ExcelUtils.getCellData(count, 7);
		    						//String membersubscriberRelationshipsCommNoteMedium = ExcelUtils.getCellData(count, 8);
		    				//		String membersubscriberRelationshipsCommDetails = ExcelUtils.getCellData(count, 9);
		    						
		    		if (ExcelUtils.getCellData(count,0).isEmpty())
		    		{System.out.println("End of Test Data");}
		    		else{
		    		
		    		System.out.println("\n----------------------------------------------------\n");
		   		 	System.out.println("Member-Subscriber Relationships Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	System.out.println("\n----------------------------------------------------\n");
		   		 	Log.info("----------------------------------------------------");
		   		 	Log.info("Member-Subscriber Relationships Edit- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
		   		 	Log.info("----------------------------------------------------");
   		 	editMemberSubscriberRelationshipsMultiple(driver,membersubscriberRelationshipsCode, membersubscriberRelationshipsDescription, membersubscriberRelationshipsRecordMark);
		    		}
		    	}
			}catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
		}
		
			
			public void editMemberSubscriberRelationshipsMultiple(WebDriver driver,String MemberSubscriberRelationshipsCode, String MemberSubscriberRelationshipsDescription, String MemberSubscriberRelationshipsRecordMark) throws Exception
			{
			
			// Launch Chrome Browser
			driver= BrowserUtils.openChromeBrowser();
						
			//open risk manager
			driver.get(Constant.URL);
			System.out.println("opened browser");
						
			//click network user
			LoginPage loginPageObject = new LoginPage(driver);
			loginPageObject.clickNetworkUser();
			System.out.println("clicked Network user");
								
			HomePage homePageObject = new HomePage(driver);
			try{
                homePageObject.clickExitMyOpenCaseListing();
           }
			catch(Exception e){ 
				System.out.println("Blank Home Page");
				Log.info("log4j - msg -Blank Home Page");
			}
			homePageObject.clickReferencegotoMemberSubscriberRelationships();	
			
			Thread.sleep(2000);
			
         	MemberSubscriberRelationships membersubscriberRelationshipsPageObject = new MemberSubscriberRelationships(driver);
			membersubscriberRelationshipsPageObject.editMemberSubscriberRelationships( MemberSubscriberRelationshipsCode, MemberSubscriberRelationshipsDescription, MemberSubscriberRelationshipsRecordMark);
			
			}

		@AfterMethod
		public void afterMethod() throws Exception {
		if (driver!=null) driver.quit();
		System.out.println("Done with Member-Subscriber Relationships-Edit \n\n");
		if (fis != null) 	fis.close();
	}
}





