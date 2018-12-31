package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.BenefitPremiumPaymentModes;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class BenefitPremiumPaymentModesCopyTestScript {
	 WebDriver driver;
     FileInputStream fis;
                     @Test
                     public void BenefitPremiumPaymentModesCopyTestScript1() throws Exception{
                                     DOMConfigurator.configure("log4j.xml");
                                     System.out.println("\n*****************************************************\n");
                                     Log.info("\n*****************************************************\n");
                                     System.out.println("Executing Benefit Premium Payment Modes- Copy");
                                     Log.info("Executing  Benefit Premium Payment Modes- Copy ");
                                     
                                     
                                     try{
                                                     String Path=Constant.Path_TestData + Constant.File_Add_BenefitPremiumPaymentModes;
                                                     int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                     for (int count=1; count<=rowCount; count++){
                                                     String benefitpremiumpaymentModesCode= ExcelUtils.getCellData(count,1);
                                                     String benefitpremiumpaymentModesDescription=ExcelUtils.getCellData(count,2); 
                                                     String benefitpremiumpaymentModesNewCode= ExcelUtils.getCellData(count, 3);
                                                     String benefitpremiumpaymentModesNewDescription= ExcelUtils.getCellData(count, 4);
                                                     String benefitpremiumpaymentModesEditDescription= ExcelUtils.getCellData(count, 5);
                                                     
                                                                                     
                                                                                                                     String benefitpremiumpaymentModesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                     String benefitpremiumpaymentModesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                     String benefitpremiumpaymentModesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                     String benefitpremiumpaymentModesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                     
                                                     if (ExcelUtils.getCellData(count,0).isEmpty())
                                                     {System.out.println("End of Test Data");}
                                                     else{
                                                     
                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     System.out.println("Benefit Premium Payment Modes Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     System.out.println("\n----------------------------------------------------\n");
                                                                     Log.info("----------------------------------------------------");
                                                                     Log.info("Benefit Premium Payment Modes Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                     Log.info("----------------------------------------------------");
                                     copyBenefitPremiumPaymentModesMultiple(driver,benefitpremiumpaymentModesCode, benefitpremiumpaymentModesNewCode, benefitpremiumpaymentModesNewDescription);
                                                     }
                                     }
                                     }catch (Exception e) {e.printStackTrace();System.out.println("Test Data File not found");e.printStackTrace();}
                     }
                     
                                     
                                     public void copyBenefitPremiumPaymentModesMultiple(WebDriver driver,String benefitpremiumpaymentModesCode, String benefitpremiumpaymentModesNewCode, String benefitpremiumpaymentModesNewDescription) throws Exception
                                     {
                                     
                                     
                                     // Launch Chrome Browser
                                     driver= BrowserUtils.openChromeBrowser();
                                                                                     
                                     //open risk manager
                                     driver.get(Constant.URL);
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

                                     homePageObject.clickReferencegotoBenefitPremiumPaymentModes();     
                                     
                                     
                                     
                         BenefitPremiumPaymentModes benefitpremiumpaymentModesPageObject = new BenefitPremiumPaymentModes(driver);
                                     benefitpremiumpaymentModesPageObject.copyBenefitPremiumPaymentModes( benefitpremiumpaymentModesCode, benefitpremiumpaymentModesNewCode, benefitpremiumpaymentModesNewDescription);
                                     
                                     }

                     @AfterMethod
                     public void afterMethod() throws Exception {
                     if (driver!=null) driver.quit();
                     System.out.println("Done with Benefit Premium Payment Modes-Copy \n\n");
                     Log.info("log4j -Done with Benefit Premium Payment Modes-Copy \n\n");
                     if (fis != null)
                                                     fis.close();
                                                    
     }
}


