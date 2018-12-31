package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.NorthAmericanIndustrialClassifications;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class NorthAmericanIndustrialClassificationsCopyTestScript {
                WebDriver driver;
                FileInputStream fis;
                                @Test
                                public void NorthAmericanIndustrialClassificationsCopyTestScript1() throws Exception{
                                                DOMConfigurator.configure("log4j.xml");
                                                System.out.println("\n*****************************************************\n");
                                                Log.info("\n*****************************************************\n");
                                                System.out.println("Executing North American Industrial Classifications- Copy");
                                                Log.info("Executing  North American Industrial Classifications- Copy ");
                                                
                                                
                                                try{
                                                                String Path=Constant.Path_TestData + Constant.File_Add_NorthAmericanIndustrialClassifications;
                                                                int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                                for (int count=1; count<=rowCount; count++){
                                                                String northamericanindustrialClassificationsCode= ExcelUtils.getCellData(count,1);
                                                                String northamericanindustrialClassificationsDescription=ExcelUtils.getCellData(count,2); 
                                                                String northamericanindustrialClassificationsNewCode= ExcelUtils.getCellData(count, 3);
                                                                String northamericanindustrialClassificationsNewDescription= ExcelUtils.getCellData(count, 4);
                                                                String northamericanindustrialClassificationsEditDescription= ExcelUtils.getCellData(count, 5);
                                                                
                                                                                                
                                                                                                                                String northamericanindustrialClassificationsCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                                String northamericanindustrialClassificationsCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                                String northamericanindustrialClassificationsCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                                String northamericanindustrialClassificationsCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                                
                                                                if (ExcelUtils.getCellData(count,0).isEmpty())
                                                                {System.out.println("End of Test Data");}
                                                                else{
                                                                
                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                System.out.println("North American Industrial Classifications Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                Log.info("----------------------------------------------------");
                                                                                Log.info("North American Industrial Classifications Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                Log.info("----------------------------------------------------");
                                                copyNorthAmericanIndustrialClassificationsMultiple(driver,northamericanindustrialClassificationsCode, northamericanindustrialClassificationsDescription, northamericanindustrialClassificationsNewCode, northamericanindustrialClassificationsNewDescription);
                                                                }
                                                }
                                                }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                                }
                                
                                                
                                                public void copyNorthAmericanIndustrialClassificationsMultiple(WebDriver driver,String northamericanindustrialClassificationsCode, String northamericanindustrialClassificationsDescription, String northamericanindustrialClassificationsNewCode, String northamericanindustrialClassificationsNewDescription) throws Exception
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
                                                homePageObject.clickPayersEmps();     
                                                
                                                PayersPage payersPageObject = new PayersPage(driver);
                                                payersPageObject.clickOnNorthAmericanIndustrialClassifications();
                                                                                
                                                NorthAmericanIndustrialClassifications northamericanindustrialClassificationsPageObject = new NorthAmericanIndustrialClassifications(driver);
                                                northamericanindustrialClassificationsPageObject.copyNorthAmericanIndustrialClassifications( northamericanindustrialClassificationsCode, northamericanindustrialClassificationsDescription, northamericanindustrialClassificationsNewCode, northamericanindustrialClassificationsNewDescription);
                                                
                                                }

                                @AfterMethod
                                public void afterMethod() throws Exception {
                                if (driver!=null) driver.quit();
                                System.out.println("Done with North American Industrial Classifications-Copy \n\n");
                                if (fis != null)     fis.close();
                }
}

