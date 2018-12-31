package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.AdjustmentTypes;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class AdjustmentTypesCopyTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void AdjustmentTypesCopyTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing Adjustment Types- Copy");
                                     Log.info("Executing  Adjustment Types- Copy ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_AdjustmentTypes;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String adjustmentTypesCode= ExcelUtils.getCellData(count,1);
                                                     String adjustmentTypesDescription=ExcelUtils.getCellData(count,2); 
                                                     String adjustmentTypesNewCode= ExcelUtils.getCellData(count, 3);
                                                     String adjustmentTypesNewDescription= ExcelUtils.getCellData(count, 4);
                                                     String adjustmentTypesEditDescription= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String adjustmentTypesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String adjustmentTypesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String adjustmentTypesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String adjustmentTypesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("Adjustment Types Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("Adjustment Types Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                     copyAdjustmentTypesMultiple(driver,adjustmentTypesCode, adjustmentTypesNewCode, adjustmentTypesNewDescription);
                                                     }
                                     }
                                     }catch (Exception e) {e.printStackTrace();System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void copyAdjustmentTypesMultiple(WebDriver driver,String adjustmentTypesCode, String adjustmentTypesNewCode, String adjustmentTypesNewDescription) throws Exception
                                     {
                                     
                                     
                                     // Launch Chrome Browser
                                     driver= BrowserUtils.openChromeBrowser();
                                                                                     
                                     //open risk manager
                                     driver.get(Constant.URL);
                                     System.out.println("Launched Browser");
                                                                                     
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

                                     homePageObject.clickReferencegotoAdjustmentTypes();     
                                     
                                     AdjustmentTypes adjustmentTypesPageObject = new AdjustmentTypes(driver);
                                     adjustmentTypesPageObject.copyAdjustmentTypes( adjustmentTypesCode, adjustmentTypesNewCode, adjustmentTypesNewDescription);
                                     
                                     }

                     @AfterMethod
                     public void afterMethod() throws Exception {
                     if (driver!=null) driver.quit();
                     System.out.println("Done with Adjustment Types-Copy \n\n");
                     if (fis != null)
                                                     fis.close();
                                                     
                     }
}



