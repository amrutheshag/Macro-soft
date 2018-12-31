package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.EmployerGroups;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PayersPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class EmployerGroupsCopyTestScript {
                WebDriver driver;
                FileInputStream fis;
                                @Test
                                public void EmployerGroupsCopyTestScript1() throws Exception{
                                                DOMConfigurator.configure("log4j.xml");
                                                System.out.println("\n*****************************************************\n");
                                                Log.info("\n*****************************************************\n");
                                                System.out.println("Executing Employer Groups- Copy");
                                                Log.info("Executing  Employer Groups- Copy ");
                                                
                                                
                                                try{
                                                                String Path=Constant.Path_TestData + Constant.File_Add_EmployerGroups;
                                                                int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                                for (int count=1; count<=rowCount; count++){
                                                                String EmployerGroupsCode= ExcelUtils.getCellData(count,1);
                                                                String EmployerGroupsDescription=ExcelUtils.getCellData(count,2); 
                                                                String EmployerGroupsNewCode= ExcelUtils.getCellData(count, 3);
                                                                String EmployerGroupsNewDescription= ExcelUtils.getCellData(count, 4);
                                                                String EmployerGroupsEditDescription= ExcelUtils.getCellData(count, 5);
                                                                
                                                                                                
                                                                                                                                String EmployerGroupsCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                                String EmployerGroupsCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                                String EmployerGroupsCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                                String EmployerGroupsCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                                
                                                                if (ExcelUtils.getCellData(count,0).isEmpty())
                                                                {System.out.println("End of Test Data");}
                                                                else{
                                                                
                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                System.out.println("Employer Groups Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                Log.info("----------------------------------------------------");
                                                                                Log.info("Employer Groups Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                Log.info("----------------------------------------------------");
                                                copyEmployerGroupsMultiple(driver,EmployerGroupsCode, EmployerGroupsDescription, EmployerGroupsNewCode, EmployerGroupsNewDescription);
                                                                }
                                                }
                                                }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                                }
                                
                                                
                                                public void copyEmployerGroupsMultiple(WebDriver driver,String EmployerGroupsCode, String EmployerGroupsDescription, String EmployerGroupsNewCode, String EmployerGroupsNewDescription) throws Exception
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
                                        		}catch(Exception e)
                                        		{ System.out.println("Blank Home Page");
                                        		Log.info("log4j - msg -Blank Home Page");}
                                                homePageObject.clickPayersEmps();     
                                                
                                                PayersPage payersPageObject = new PayersPage(driver);
                                                payersPageObject.clickOnEmployerGroups();
                                                                                
                                                EmployerGroups EmployerGroupsPageObject = new EmployerGroups(driver);
                                                EmployerGroupsPageObject.copyEmployerGroups( EmployerGroupsCode, EmployerGroupsDescription, EmployerGroupsNewCode, EmployerGroupsNewDescription);
                                                
                                                }

                                @AfterMethod
                                public void afterMethod() throws Exception {
                                if (driver!=null) driver.quit();
                                System.out.println("Done with Employer Groups-Copy \n\n");
                                if (fis != null)              fis.close();
                                               
                }
}

