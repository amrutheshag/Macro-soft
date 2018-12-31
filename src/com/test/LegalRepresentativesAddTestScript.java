package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import com.pages.HomePage;
import com.pages.LegalRepresentatives;
import com.pages.LoginPage;
import com.pages.PayersPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class LegalRepresentativesAddTestScript {
                WebDriver driver;
                FileInputStream fis;
                                @Test
                                public void LegalRepresentativesAddTestScript1() throws Exception{
                                                DOMConfigurator.configure("log4j.xml");
                                                System.out.println("\n*****************************************************\n");
                                                Log.info("\n*****************************************************\n");
                                                System.out.println("Executing LegalRepresentatives- Add");
                                                Log.info("Executing  LegalRepresentatives- Add ");
                                                
                                                
                                                try{
                                                                String Path=Constant.Path_TestData + Constant.File_Add_LegalRepresentatives;
                                                                int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                                for (int count=1; count<=rowCount; count++){
                                                                String legalRepresentativesCode= ExcelUtils.getCellData(count,1);
                                                                String legalRepresentativesName=ExcelUtils.getCellData(count,2); 
                                                                String legalRepresentativesNewCode= ExcelUtils.getCellData(count, 3);
                                                                String legalRepresentativesNewName= ExcelUtils.getCellData(count, 4);
                                                                String legalRepresentativesEditName= ExcelUtils.getCellData(count, 5);
                                                                
                                                                                                
                                                                                                                                String legalRepresentativesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                                String  legalRepresentativesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                                String  legalRepresentativesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                                String  legalRepresentativesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                                
                                                                if (ExcelUtils.getCellData(count,0).isEmpty())
                                                                {System.out.println("End of Test Data");}
                                                                else{
                                                                
                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                System.out.println("Legal Representatives Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                Log.info("----------------------------------------------------");
                                                                                Log.info("Legal Representatives Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                Log.info("----------------------------------------------------");
                                                                                addLegalRepresentativesMultiple(driver,legalRepresentativesCode, legalRepresentativesName);
                                                                }
                                                }
                                                }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                                }
                                
                                                
                                                public void addLegalRepresentativesMultiple(WebDriver driver,String LegalRepresentativesCode, String LegalRepresentativesName) throws Exception
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
                                                
                                                PayersPage PayersPageObject = new PayersPage(driver);
                                        		PayersPageObject.clickOnLegalRepresentatives(); 
                                                LegalRepresentatives LegalRepresentativesObject = new LegalRepresentatives(driver);
                                                LegalRepresentativesObject.addLegalRepresentatives(LegalRepresentativesCode, LegalRepresentativesName);
                                                
                                                }
                                                
                                                
                                                @AfterMethod
                                                public void afterMethod() throws Exception {
                                                if (driver!=null) driver.quit();
                                                System.out.println("Done with Legal Representatives Add\n\n");
                                                if (fis != null)   fis.close();
                                                }        

                               

}

