package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.Carriers;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class CarriersCopyTestScript {
    WebDriver driver;
    FileInputStream fis;
                    @Test
                    public void CarriersCopyTestScript1() throws Exception{
                                    DOMConfigurator.configure("log4j.xml");
                                    System.out.println("\n*****************************************************\n");
                                    Log.info("\n*****************************************************\n");
                                    System.out.println("Executing Carriers- Copy");
                                    Log.info("Executing  Carriers- Copy ");
                                    
                                    
                                    try{
                                                    String Path=Constant.Path_TestData + Constant.File_Add_Carriers;
                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                    for (int count=1; count<=rowCount; count++){
                                                    String CarriersCode= ExcelUtils.getCellData(count,1);
                                                    String CarriersDescription=ExcelUtils.getCellData(count,2); 
                                                    String CarriersNewCode= ExcelUtils.getCellData(count, 3);
                                                    String CarriersNewDescription= ExcelUtils.getCellData(count, 4);
                                                    String CarriersEditDescription= ExcelUtils.getCellData(count, 5);
                                                    
                                                                                    
                                                                                                                    String CarriersCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                    String CarriersCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                    String CarriersCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                    String CarriersCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                    
                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
                                                    {System.out.println("End of Test Data");}
                                                    else{
                                                    
                                                    System.out.println("\n----------------------------------------------------\n");
                                                                    System.out.println("Carriers Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                    System.out.println("\n----------------------------------------------------\n");
                                                                    Log.info("----------------------------------------------------");
                                                                    Log.info("Carriers Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                    Log.info("----------------------------------------------------");
                                    copyCarriersMultiple(driver,CarriersCode, CarriersDescription, CarriersNewCode, CarriersNewDescription);
                                                    }
                                    }
                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                    }
                    
                                    
                                    public void copyCarriersMultiple(WebDriver driver,String CarriersCode, String CarriersDescription, String CarriersNewCode, String CarriersNewDescription) throws Exception
                                    {
                                    
                                    
                                    // Launch Chrome Browser
                                    driver= BrowserUtils.openChromeBrowser();
                                                                                    
                                    //open risk manager
                                    driver.get(Constant.URL);
                                    
                                                                                    
                                    //click network user
                                    LoginPage loginPageObject = new LoginPage(driver);
                                    loginPageObject.clickNetworkUser();
                                  
                                                                                                                    
                                    //click Payers-Emps
                                    HomePage homePageObject = new HomePage(driver);
                                    try{  homePageObject.clickExitMyOpenCaseListing();   }
                       	         catch(Exception e){ 	System.out.println("Blank Home Page");  Log.info("log4j - msg -Blank Home Page");   }
                                    homePageObject.clickPayersEmps();     
                                    
                                    
                                    
                                    
                                 
                                    PayersPage payersPageObject = new PayersPage(driver);
                                    payersPageObject.clickOnCarriers();
                                                                    
                                  
                                    
                              
                                    Carriers CarriersPageObject = new Carriers(driver);
                                    CarriersPageObject.copyCarriers(CarriersCode, CarriersDescription, CarriersNewCode, CarriersNewDescription);
                                    
                                    }

                    @AfterMethod
                    public void afterMethod() throws Exception {
                    if (driver!=null) driver.quit();
                    System.out.println("Done with Carriers-Copy \n\n");
                    if (fis != null) 
                                                    fis.close();
                                                   
    }
}

