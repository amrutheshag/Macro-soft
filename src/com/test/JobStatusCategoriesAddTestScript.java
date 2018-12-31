package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.JobStatusCategories;
import com.pages.HomePage;
import com.pages.LoginPage;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class JobStatusCategoriesAddTestScript {
                WebDriver driver;
                FileInputStream fis;
                                @Test
                                public void JobStatusCategoriesAddTestScript1() throws Exception{
                                                DOMConfigurator.configure("log4j.xml");
                                                System.out.println("\n*****************************************************\n");
                                                Log.info("\n*****************************************************\n");
                                                System.out.println("Executing Job Status Categories- Add");
                                                Log.info("Executing  Job Status Categories- Add ");
                                                
                                                
                                                try{
                                                                String Path=Constant.Path_TestData + Constant.File_Add_JobStatusCategories;
                                                                int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                                for (int count=1; count<=rowCount; count++){
                                                                String jobstatusCategoriesCode= ExcelUtils.getCellData(count,1);
                                                                String jobstatusCategoriesName=ExcelUtils.getCellData(count,2); 
                                                                String jobstatusCategoriesNewCode= ExcelUtils.getCellData(count, 3);
                                                                String jobstatusCategoriesNewName= ExcelUtils.getCellData(count, 4);
                                                                String jobstatusCategoriesEditName= ExcelUtils.getCellData(count, 5);
                                                                
                                                                                                
                                                                                                                                String jobstatusCategoriesCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                                String  jobstatusCategoriesCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                                String  jobstatusCategoriesCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                                String  jobstatusCategoriesCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                                
                                                                if (ExcelUtils.getCellData(count,0).isEmpty())
                                                                {System.out.println("End of Test Data");}
                                                                else{
                                                                
                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                System.out.println("Job Status Categories Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                System.out.println("\n----------------------------------------------------\n");
                                                                                Log.info("----------------------------------------------------");
                                                                                Log.info("Job Status Categories Add- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                                Log.info("----------------------------------------------------");
                                                                                addjobStatusCategoriesMultiple(driver,jobstatusCategoriesCode, jobstatusCategoriesName);
                                                                }
                                                }
                                                }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                                }
                                
                                                
                                                public void addjobStatusCategoriesMultiple(WebDriver driver,String jobStatusCategoriesCode, String jobStatusCategoriesName) throws Exception
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

                                    			homePageObject.clickReferencegotoJobStatusCategories();	
                                    			   
                                                
                                                
                                                
                                               
                                                //add 
                                                JobStatusCategories JobStatusCategoriesObject = new JobStatusCategories(driver);
                                                JobStatusCategoriesObject.addJobStatusCategories(jobStatusCategoriesCode, jobStatusCategoriesName);
                                                
                                                }

                                                @AfterMethod
                                        		public void afterMethod() throws Exception {
                                        		if (driver!=null) driver.quit();
                                        		System.out.println("Done with Job Status Categories-Add \n\n");
                                        		if (fis != null)
                                        				fis.close();
                                        	}   

}

