package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.JournalContactMedias;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class JournalContactMediasAddCommTestScript {
	 WebDriver driver;
	    FileInputStream fis;
	                    @Test
	                    public void JournalContactMediasAddCommTestScriptTestScript() throws Exception{
	                                    DOMConfigurator.configure("log4j.xml");
	                                    System.out.println("\n*****************************************************\n");
	                                    Log.info("\n*****************************************************\n");
	                                    System.out.println("Executing Journal Contact Medias- Add Comm");
	                                    Log.info("Executing  Journal Contact Medias- Add Comm");
	                                    
	                                    
	                                    try{
	                                                    String Path=Constant.Path_TestData + Constant.File_Add_JournalContactMedias;
	                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
	                                    for (int count=1; count<=rowCount; count++){
	                                                    String journalcontactMediasCode= ExcelUtils.getCellData(count,1);
	                                                    String journalcontactMediasName=ExcelUtils.getCellData(count,2); 
	                                                    String journalcontactMediasNewCode= ExcelUtils.getCellData(count, 3);
	                                                    String journalcontactMediasNewName= ExcelUtils.getCellData(count, 4);
	                                                    String journalcontactMediasEditName= ExcelUtils.getCellData(count, 5);
	                                                    
	                                                                                    
	                                                                                                                    String journalcontactMediasCommSubject= ExcelUtils.getCellData(count, 6);
	                                                                                                                    String  journalcontactMediasCommNoteType = ExcelUtils.getCellData(count, 7);
	                                                                                                                    String  journalcontactMediasCommNoteMedium = ExcelUtils.getCellData(count, 8);
	                                                                                                                    String  journalcontactMediasCommDetails = ExcelUtils.getCellData(count, 9);
	                                                                                                                    
	                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
	                                                    {System.out.println("End of Test Data");}
	                                                    else{
	                                                    
	                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    System.out.println("Journal Contact Medias Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    System.out.println("\n----------------------------------------------------\n");
	                                                                    Log.info("----------------------------------------------------");
	                                                                    Log.info("Journal Contact Medias Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
	                                                                    Log.info("----------------------------------------------------");
	                                                                    addCommJournalContactMediasMultiple(driver,journalcontactMediasCode, journalcontactMediasCommSubject, journalcontactMediasCommNoteType, journalcontactMediasCommNoteMedium, journalcontactMediasCommDetails);
	                                                    }
	                                    }
	                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
	                    }
	                    
	                                    
	                                    public void addCommJournalContactMediasMultiple(WebDriver driver,String journalcontactMediasCode, String journalcontactMediasCommSubject, String journalcontactMediasCommNoteType, String journalcontactMediasCommNoteMedium, String journalcontactMediasCommDetails) throws Exception
	                                    {
	                                    
	                                    
	                                    // Launch Chrome Browser
	                                    driver= BrowserUtils.openChromeBrowser();
	                                                                                    
	                                    //open risk manager
	                                    driver.get(Constant.URL);
	                                    System.out.println("opened browser");
	                                                                                    
	                                    //click network user
	                                    LoginPage loginPageObject = new LoginPage(driver);
	                                    loginPageObject.clickNetworkUser();
	                                    HomePage homePageObject = new HomePage(driver);
	                                    
	                                    try{
	                                         homePageObject.clickExitMyOpenCaseListing();
	                                    }
	                                    catch(Exception e){ 
	                                    	System.out.println("Blank Home Page");
	                                    	Log.info("log4j - msg -Blank Home Page");
	                                    }
	                                    
	                                    homePageObject.clickReferencegotoJournalContactMedias();    

	                                    JournalContactMedias JournalContactMediasObject = new JournalContactMedias(driver);
	                                    JournalContactMediasObject.addCommJournalContactMedias(journalcontactMediasCode, journalcontactMediasCommSubject, journalcontactMediasCommNoteType, journalcontactMediasCommNoteMedium, journalcontactMediasCommDetails);
	                                    
	                                    }
	                                    @AfterMethod
	                    	      		public void afterMethod() throws Exception {
	                    	      		if (driver!=null) driver.quit();
	                    	      		System.out.println("Done with Journal Contact Medias-Add Comm  \n\n");
	                    	      		Log.info("log4j -Done with Journal Contact Medias-Add Comm  \n\n");
	                    	      		if (fis != null)
	                    	      				fis.close();
	                    	      	}
	                    	      }

