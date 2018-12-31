package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.OccupationalClasses;
import com.pages.LoginPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class OccupationalClassesCopyTestScript {
    WebDriver driver;
    FileInputStream fis;
                    @Test
                    public void OccupationalClassesCopyTestScript1() throws Exception{
                                    DOMConfigurator.configure("log4j.xml");
                                    System.out.println("\n*****************************************************\n");
                                    Log.info("\n*****************************************************\n");
                                    System.out.println("Executing Occupational Classes- Copy");
                                    Log.info("Executing  Occupational Classes- Copy ");
                                    
                                    
                                    try{
                                                    String Path=Constant.Path_TestData + Constant.File_Add_OccupationalClasses;
                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                    for (int count=1; count<=rowCount; count++){
                                                    String occupationalClassesCode= ExcelUtils.getCellData(count,1);
                                                    String occupationalClassesDescription=ExcelUtils.getCellData(count,2); 
                                                    String occupationalClassesNewCode= ExcelUtils.getCellData(count, 3);
                                                    String occupationalClassesNewDescription= ExcelUtils.getCellData(count, 4);
                                                    String occupationalClassesEditDescription= ExcelUtils.getCellData(count, 5);
                                                    
                                                                                    
                                                                                                                    String occupationalClassesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                    String occupationalClassesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                    String occupationalClassesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                    String occupationalClassesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                    
                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
                                                    {System.out.println("End of Test Data");}
                                                    else{
                                                    
                                                    System.out.println("\n----------------------------------------------------\n");
                                                                    System.out.println("Occupational Classes Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                    System.out.println("\n----------------------------------------------------\n");
                                                                    Log.info("----------------------------------------------------");
                                                                    Log.info("Occupational Classes Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                    Log.info("----------------------------------------------------");
                                    copyOccupationalClassesMultiple(driver,occupationalClassesCode, occupationalClassesDescription, occupationalClassesNewCode, occupationalClassesNewDescription);
                                                    }
                                    }
                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                    }
                    
                                    
                                    public void copyOccupationalClassesMultiple(WebDriver driver,String OccupationalClassesCode, String occupationalClassesDescription, String occupationalClassesNewCode, String occupationalClassesNewDescription) throws Exception
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
                                                                                                                    
                                    //click Payers-Emps
                                    HomePage homePageObject = new HomePage(driver);
                        			try{
                                        homePageObject.clickExitMyOpenCaseListing();
                                   }
                        			catch(Exception e){ 
                        				System.out.println("Blank Home Page");
                                   Log.info("log4j - msg -Blank Home Page");
                        			}

                        			homePageObject.clickReferencegotoOccupationalClasses();	
                                    
                                 
                                    //copy
                                    OccupationalClasses occupationalClassesPageObject = new OccupationalClasses(driver);
                                    occupationalClassesPageObject.copyOccupationalClasses( OccupationalClassesCode, occupationalClassesDescription, occupationalClassesNewCode, occupationalClassesNewDescription);
                                    
                                    }

                    @AfterMethod
                    public void afterMethod() throws Exception {
                    if (driver!=null) driver.quit();
                    System.out.println("Done with Occupational Classes-Copy \n\n");
                    if (fis != null)              fis.close();
                                                   
    }
}


