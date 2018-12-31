package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.JournalNoteTypes;
import com.pages.LoginPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class JournalNoteTypesAddCommTestScript {
	WebDriver driver;
    FileInputStream fis;
                    @Test
                    public void JournalNoteTypesAddCommTestScriptTestScript() throws Exception{
                                    DOMConfigurator.configure("log4j.xml");
                                    System.out.println("\n*****************************************************\n");
                                    Log.info("\n*****************************************************\n");
                                    System.out.println("Executing Journal Note Types- Add Comm");
                                    Log.info("Executing  Journal Note Types- Add Comm");
                                    
                                    
                                    try{
                                                    String Path=Constant.Path_TestData + Constant.File_Add_JournalNoteTypes;
                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                    for (int count=1; count<=rowCount; count++){
                                                    String journalnoteTypesCode= ExcelUtils.getCellData(count,1);
                                                    String journalnoteTypesName=ExcelUtils.getCellData(count,2); 
                                                    String journalnoteTypesNewCode= ExcelUtils.getCellData(count, 3);
                                                    String journalnoteTypesNewName= ExcelUtils.getCellData(count, 4);
                                                    String journalnoteTypesEditName= ExcelUtils.getCellData(count, 5);
                                                    
                                                                                    
                                                                                                                    String journalnoteTypesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                    String  journalnoteTypesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                    String  journalnoteTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                    String  journalnoteTypesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                    
                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
                                                    {System.out.println("End of Test Data");}
                                                    else{
                                                    
                                                    System.out.println("\n----------------------------------------------------\n");
                                                                    System.out.println("Journal Note Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                    System.out.println("\n----------------------------------------------------\n");
                                                                    Log.info("----------------------------------------------------");
                                                                    Log.info("Journal Note Types Add Comm- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                    Log.info("----------------------------------------------------");
                                                                    addCommJournalNoteTypesMultiple(driver,journalnoteTypesCode, journalnoteTypesCommSubject, journalnoteTypesCommNoteType, journalnoteTypesCommNoteMedium, journalnoteTypesCommDetails);
                                                    }
                                    }
                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                    }
                    
                                    
                                    public void addCommJournalNoteTypesMultiple(WebDriver driver,String journalnoteTypesCode, String journalnoteTypesCommSubject, String journalnoteTypesCommNoteType, String journalnoteTypesCommNoteMedium, String journalnoteTypesCommDetails) throws Exception
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
                                    
                                    homePageObject.clickReferencegotoJournalNoteTypes();    
                    				JournalNoteTypes JournalNoteTypesObject = new JournalNoteTypes(driver);
                                    JournalNoteTypesObject.addCommJournalNoteTypes(journalnoteTypesCode, journalnoteTypesCommSubject, journalnoteTypesCommNoteType, journalnoteTypesCommNoteMedium, journalnoteTypesCommDetails);
                                    
                                    }
                                    @AfterMethod
                    	      		public void afterMethod() throws Exception {
                    	      		if (driver!=null) driver.quit();
                    	      		System.out.println("Done with Journal Note Types-Add Comm  \n\n");
                    	      		Log.info("log4j -Done with Journal Note Types-Add Comm  \n\n");
                    	      		if (fis != null) 
                    	      				fis.close();
                    	      	}
                    	      }

