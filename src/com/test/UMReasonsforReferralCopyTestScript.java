package com.test;

import java.io.FileInputStream;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.UMReasonsforReferral;

import utility.BrowserUtils;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;

public class UMReasonsforReferralCopyTestScript {
	WebDriver driver;
    FileInputStream fis;
                    @Test
                    public void UMReasonsforReferralCopyTestScript1() throws Exception{
                                    DOMConfigurator.configure("log4j.xml");
                                    System.out.println("\n*****************************************************\n");
                                    Log.info("\n*****************************************************\n");
                                    System.out.println("Executing UM Reasons for Referral- Copy");
                                    Log.info("Executing  UM Reasons for Referral- Copy ");
                                    
                                    
                                    try{
                                                    String Path=Constant.Path_TestData + Constant.File_Add_UMReasonsforReferral;
                                                    int rowCount=ExcelUtils.setExcelFile(Path, "Sheet1");
                                    for (int count=1; count<=rowCount; count++){
                                                    String umreasonsforReferralCode= ExcelUtils.getCellData(count,1);
                                                    String umreasonsforReferralDescription=ExcelUtils.getCellData(count,2); 
                                                    String umreasonsforReferralNewCode= ExcelUtils.getCellData(count, 3);
                                                    String umreasonsforReferralNewDescription= ExcelUtils.getCellData(count, 4);
                                                    String umreasonsforReferralEditDescription= ExcelUtils.getCellData(count, 5);
                                                    
                                                                                    
                                                                                                                    String umreasonsforReferralCommSubject= ExcelUtils.getCellData(count, 6);
                                                                                                                    String umreasonsforReferralCommNoteType = ExcelUtils.getCellData(count, 7);
                                                                                                                    String umreasonsforReferralCommNoteMedium = ExcelUtils.getCellData(count, 8);
                                                                                                                    String umreasonsforReferralCommDetails = ExcelUtils.getCellData(count, 9);
                                                                                                                    
                                                    if (ExcelUtils.getCellData(count,0).isEmpty())
                                                    {System.out.println("End of Test Data");}
                                                    else{
                                                    
                                                    System.out.println("\n----------------------------------------------------\n");
                                                                    System.out.println("UM Reasons for Referral Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                    System.out.println("\n----------------------------------------------------\n");
                                                                    Log.info("----------------------------------------------------");
                                                                    Log.info("UM Reasons for Referral Copy- Running Iteration No:  " + ExcelUtils.getCellData(count,0));
                                                                    Log.info("----------------------------------------------------");
                                    copyUMReasonsforReferralMultiple(driver,umreasonsforReferralCode, umreasonsforReferralDescription, umreasonsforReferralNewCode, umreasonsforReferralNewDescription);
                                                    }
                                    }
                                    }catch (Exception e) {System.out.println("Test Data File not found");e.printStackTrace();}
                    }
                    
                                    
                                    public void copyUMReasonsforReferralMultiple(WebDriver driver,String UMReasonsforReferralCode, String umreasonsforReferralDescription, String umreasonsforReferralNewCode, String umreasonsforReferralNewDescription) throws Exception
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

                        			homePageObject.clickReferencegotoUMReasonsforReferral();	
                                    UMReasonsforReferral umreasonsforReferralPageObject = new UMReasonsforReferral(driver);
                                    umreasonsforReferralPageObject.copyUMReasonsforReferral( UMReasonsforReferralCode, umreasonsforReferralDescription, umreasonsforReferralNewCode, umreasonsforReferralNewDescription);
                                    
                                    }

                              	  @AfterMethod
                            		public void afterMethod() throws Exception {
                            		if (driver!=null) driver.quit();
                            		System.out.println("Done with UM Reasons for Referral-Copy \n\n");
                            		Log.info("log4j-Done with UM Reasons for Referral-Copy \n\n");
                            		if (fis != null)	fis.close();
                            	}
                            }







