package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.LegalRepresentatives;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class LegalRepresentativesCopyTestScript {
                WebDriver driver;
                FileInputStream fis;
                                @Test
                                public void LegalRepresentativesCopyTestScript1() throws Exception{
                                                DOMConfigurator.configure("log4j.xml");
                                                System.out.println("\n*****************************************************\n");
                                                Log.info("\n*****************************************************\n");
                                                System.out.println("Executing Legal Representatives- Copy");
                                                Log.info("Executing  Legal Representatives- Copy ");
                                                
                                                
                                                try{
                                                                String Path=Constant.Path_TestData + Constant.File_Add_LegalRepresentatives;
                                                                int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                                for (int count=1; count<=rowCount; count++){
                                                                String LegalRepresentativesCode= ExcelUtils.getCellData(count,1);
                                                                String LegalRepresentativesDescription=ExcelUtils.getCellData(count,2); 
                                                                String LegalRepresentativesNewCode= ExcelUtils.getCellData(count, 3);
                                                                String LegalRepresentativesNewDescription= ExcelUtils.getCellData(count, 4);
                                                                String LegalRepresentativesEditDescription= ExcelUtils.getCellData(count, 5);
                                                                
                                                                                                
                                                                                                                                String LegalRepresentativesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                                String LegalRepresentativesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                                String LegalRepresentativesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                                String LegalRepresentativesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                                
                                                                if (ExcelUtils.getCellData(count,0).isEmpty())
                                                                {System.out.println("End of Test Data");}
                                                                else{
                                                                
                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                System.out.println("Legal Representatives Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                Log.info("----------------------------------------------------");
                                                                                Log.info("Legal Representatives Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                Log.info("----------------------------------------------------");
                                                copyLegalRepresentativesMultiple(driver,LegalRepresentativesCode, LegalRepresentativesDescription, LegalRepresentativesNewCode, LegalRepresentativesNewDescription);
                                                                }
                                                }
                                                }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                                }
                                
                                                
                                                public void copyLegalRepresentativesMultiple(WebDriver driver,String LegalRepresentativesCode, String LegalRepresentativesDescription, String LegalRepresentativesNewCode, String LegalRepresentativesNewDescription) throws Exception
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
                                                payersPageObject.clickOnLegalRepresentatives();
                                                                                
                                                LegalRepresentatives LegalRepresentativesPageObject = new LegalRepresentatives(driver);
                                                LegalRepresentativesPageObject.copyLegalRepresentatives( LegalRepresentativesCode, LegalRepresentativesDescription, LegalRepresentativesNewCode, LegalRepresentativesNewDescription);
                                                
                                                }

                                @AfterMethod
                                public void afterMethod() throws Exception {
                                if (driver!=null) driver.quit();
                                System.out.println("Done with Legal Representatives-Copy \n\n");
                                if (fis != null)   fis.close();
                                }
}

