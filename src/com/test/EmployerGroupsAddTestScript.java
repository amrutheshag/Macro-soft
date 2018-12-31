package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.pages.HomePage;
import com.pages.EmployerGroups;
import com.pages.LoginPage;
import com.pages.PayersPage;
import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class EmployerGroupsAddTestScript {
          WebDriver driver;
          FileInputStream fis;
          @Test
          public void EmployerGroupsAddTestScript1() throws Exception{
                  DOMConfigurator.configure("log4j.xml");
                  System.out.println("\n*****************************************************\n");
                  Log.info("\n*****************************************************\n");
                  System.out.println("Executing EmployerGroups- Add");
                  Log.info("Executing  EmployerGroups- Add ");
                                                
                                                
                  try{
                  String Path=Constant.Path_TestData + Constant.File_Add_EmployerGroups;
                  int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                  for (int count=1; count<=rowCount; count++){
                         String employerGroupsCode= ExcelUtils.getCellData(count,1);
                         String employerGroupsName=ExcelUtils.getCellData(count,2); 
                         String employerGroupsNewCode= ExcelUtils.getCellData(count, 3);
                         String employerGroupsNewName= ExcelUtils.getCellData(count, 4);
                         String employerGroupsEditName= ExcelUtils.getCellData(count, 5);
                                                                
                                                      
                         String employerGroupsCommSubject= ExcelUtils.getCellData(count, 6);
                         String  employerGroupsCommNoteType = ExcelUtils.getCellData(count, 7);
                         String  employerGroupsCommNoteMedium = ExcelUtils.getCellData(count, 8);
                         String  employerGroupsCommDetails = ExcelUtils.getCellData(count, 9);
                         if (ExcelUtils.getCellData(count,0).isEmpty())
                         {System.out.println("End of Test Data");}
                         else{
                         
                        	 System.out.println("\n----------------------------------------------------\n");
                        	 System.out.println("Employer Groups Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                             System.out.println("\n----------------------------------------------------\n");
                             Log.info("----------------------------------------------------");
                             Log.info("Employers Groups Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                             Log.info("----------------------------------------------------");
                             addEmployerGroupsMultiple(driver,employerGroupsCode, employerGroupsName);            
                         }                                                                            
                                                               
                    }
              }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
          }
                                
                                                
          public void addEmployerGroupsMultiple(WebDriver driver,String EmployerGroupsCode, String EmployerGroupsName) throws Exception
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
                                                                                          
          HomePage homePageObject = new HomePage(driver);
          try{
  			homePageObject.clickExitMyOpenCaseListing();
  			}catch(Exception e)
  			{ System.out.println("Blank Home Page");
  			Log.info("log4j - msg -Blank Home Page");}
          	homePageObject.clickPayersEmps();     
          
          
       
          PayersPage PayersPageObject = new PayersPage(driver);
  		  PayersPageObject.clickOnEmployerGroups(); 
 
          EmployerGroups EmployerGroupsObject = new EmployerGroups(driver);
          EmployerGroupsObject.addEmployerGroups(EmployerGroupsCode, EmployerGroupsName);
          
          }
                                       
          @AfterMethod
          public void afterMethod() throws Exception {
        	 if (driver!=null) driver.quit();
            System.out.println("Done withEmployerGroups Add  \n \n");
            Log.info(" Done withEmployerGroups Add  \n \n");
            if (fis != null )
        			fis.close();
        			
         }                          

}


