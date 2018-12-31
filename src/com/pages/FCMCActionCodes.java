package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class FCMCActionCodes {

	WebDriver driver;
	WebDriverWait wait ;
 
    By FCMCActionCodesAddLink= By.linkText("Add");
   
    By fcmcactionCodesCodeInput = By.xpath("//input[@id='code']");
    
    By FCMCActionCodesDescriptionInput= By.xpath("//input[@id='name']");
    
    By FCMCActionCodesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By FCMCActionCodesValidateLink =By.linkText("Validate");
   
    By FCMCActionCodesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By FCMCActionCodesSaveLink =  By.linkText("Save");
    
    By FCMCActionCodesEditLink = By.linkText("Edit");
    
    By FCMCActionCodesCopyLink = By.linkText("Copy");
    
    By FCMCActionCodesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By FCMCActionCodesCommLink= By.linkText("Commun.");
    
    By FCMCActionCodesExitLink=  By.linkText("Exit");
    
    
    
    
    public FCMCActionCodes(WebDriver driver){
                    this.driver= driver;
                    this.wait= new WebDriverWait(driver, 20);
    }
    
   

    //add function
    public void addFCMCActionCodes( String fcmcactionCodesCode, String fcmcactionCodesDescription)throws Exception{
    
                    try{ 
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCActionCodesAddLink));
                    driver.findElement(FCMCActionCodesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("FCMC Action Codes code: "+fcmcactionCodesCode);
                    Log.info("log4j msg- FCMC Action Codes code: "+fcmcactionCodesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(fcmcactionCodesCodeInput));
                    driver.findElement(fcmcactionCodesCodeInput).sendKeys(fcmcactionCodesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("FCMC Action Codes description"+fcmcactionCodesDescription);
                    Log.info("log4j msg- FCMC Action Codes description"+fcmcactionCodesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCActionCodesDescriptionInput));
                    driver.findElement(FCMCActionCodesDescriptionInput).sendKeys(fcmcactionCodesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCActionCodesValidateLink));
                    driver.findElement(FCMCActionCodesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCActionCodesValidateSaveOKButton));
                    driver.findElement(FCMCActionCodesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
                    
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCActionCodesSaveLink));
                    driver.findElement(FCMCActionCodesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                    
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); 
                    
                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding FCMC Action Codes ");
                    Log.info("log4j msg- Error in Adding FCMC Action Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                    driver.quit(); }
                    
    }
    
    //copy function
    
    public void copyFCMCActionCodes( String fcmcactionCodesCode, String newfcmcactionCodesCode, String newFCMCActionCodesDescription)throws Exception{
                    
                    try{ 
                    
                    System.out.println("FCMC Action Codes code"+fcmcactionCodesCode);
                    Log.info("log4j msg- FCMC Action Codes code"+fcmcactionCodesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcactionCodesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcactionCodesCode+"']")).click();
                    System.out.println("clicked FCMC Action Codes Code");
                    Log.info("log4j msg- clicked FCMC Action Codes code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCActionCodesCopyLink));
                    driver.findElement(FCMCActionCodesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("FCMC Action Codes new code"+newfcmcactionCodesCode);
                    Log.info("log4j msg- FCMC Action Codes new code"+newfcmcactionCodesCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(fcmcactionCodesCodeInput));
                    driver.findElement(fcmcactionCodesCodeInput).clear();
                    driver.findElement(fcmcactionCodesCodeInput).sendKeys(newfcmcactionCodesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("carrier covergae types new description"+newFCMCActionCodesDescription);
                    Log.info("log4j msg- carrier covergae types new description"+newFCMCActionCodesDescription);
    //enter new description
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCActionCodesDescriptionInput));
                    driver.findElement(FCMCActionCodesDescriptionInput).clear();
                    driver.findElement(FCMCActionCodesDescriptionInput).sendKeys(newFCMCActionCodesDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    Thread.sleep(1000);
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCActionCodesSaveLink));
                    driver.findElement(FCMCActionCodesSaveLink).click();
                    
                    Thread.sleep(1000);

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); 
                    
                    Thread.sleep(1000);
                    
                    
                    
                    
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying FCMC Action Codes ");
                    Log.info("log4j msg- Error in Copying FCMC Action Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); }
    
    
    }
    
    
    
    //edit function
public void editFCMCActionCodes( String fcmcactionCodesCode,String FCMCActionCodesDescription, String recordMark)throws Exception{
                    
                    try{ 
                    
                    System.out.println("FCMC Action Codes code"+fcmcactionCodesCode);
                    Log.info("log4j msg- FCMC Action Codes code"+fcmcactionCodesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcactionCodesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcactionCodesCode+"']")).click();
                    System.out.println("clicked FCMC Action Codes");
                    Log.info("log4j msg- clicked FCMC Action Codes");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCActionCodesEditLink));
                    driver.findElement(FCMCActionCodesEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("FCMC Action Codes Record Mark: "+recordMark);
                    Log.info("log4j msg- FCMC Action Codes Record Mark: "+recordMark);
                    		          
    //enter new Record Mark
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCActionCodesRecordMark));
                    driver.findElement(FCMCActionCodesRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(FCMCActionCodesRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new Record Mark");
                    Log.info("log4j msg- Entered new Record Mark");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCActionCodesSaveLink));
                    driver.findElement(FCMCActionCodesSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); 
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing FCMC Action Codes ");
                    Log.info("log4j msg- Error in Editing FCMC Action Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); }
    
    
    }
    //exit function
    public void exitFCMCActionCodes( String fcmcactionCodesCode) throws Exception{
    try{
                    System.out.println("FCMC Action Codes code"+fcmcactionCodesCode);
                    Log.info("log4j msg- FCMC Action Codes code"+fcmcactionCodesCode);
                                   Thread.sleep(1000);
                                    driver.findElement(FCMCActionCodesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  FCMC Action Codes ");
                                    Log.info("log4j msg- clicked exit in  FCMC Action Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                                    driver.quit();
                                   
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting FCMC Action Codes ");
    Log.info("log4j msg- Error in Exiting FCMC Action Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
    driver.quit();}
    }
    
    
    //add comm function
    public void addCommFCMCActionCodes( String fcmcactionCodesCode, String subject, String NoteType, String medium, String notes) throws Exception{
                    
                    try{        
                    System.out.println("FCMC Action Codes code"+fcmcactionCodesCode);
                    Log.info("log4j msg- FCMC Action Codes code"+fcmcactionCodesCode);
                                    //find FCMC Action Codes
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcactionCodesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcactionCodesCode+"']")).click();
                    System.out.println("clicked FCMC Action Codes Code");
                    Log.info("log4j msg- clicked FCMC Action Codes code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCActionCodesCommLink));
                    driver.findElement(FCMCActionCodesCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                                                    
                                                    
                                                    //click add
                                                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                                    driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                                   System.out.println("clicked Add");
                                                    Log.info("log4j msg- clicked Add");
                                                    
                                                    //enter subject
                                                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                    driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(subject);
                                                    System.out.println("entered subject");
                                                    Log.info("log4j msg- entered subject");
                                                    
                                                    
                                                    //page down
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtFollowup']")));
                                                    driver.findElement(By.xpath("//input[@id='txtFollowup']")).sendKeys(Keys.PAGE_DOWN);
                                                    System.out.println("clicked page down");
                                                    Log.info("log4j msg- clicked page down");
                                                    
                                                    
                                                    
                                                    
                                                    //click add details
                                                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
                                                    driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
                                                    System.out.println("clicked add details");
                                                    Log.info("log4j msg- clicked add details");
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlNoteType']")));
                                                    Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                                    placeOfService.selectByVisibleText(NoteType);
                                                    Thread.sleep(1000);
                                                    System.out.println("selected note type");
                                                    Log.info("log4j msg-selected note type");
                                                    
                                                    Thread.sleep(1000);
                                                    //enter note details
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                    driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(notes);
                                                    System.out.println("entered notes details");
                                                    Log.info("log4j msg- entered notes details");
                                                    Thread.sleep(1000);
                                                    
                                                    
                                                    //click hide
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
                                                    driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
                                                    System.out.println("clicked hide");
                                                    Log.info("log4j msg- clicked hide");
                                                    Thread.sleep(2000);
                                                    //click close case
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeCase()']")));
                                                    driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();
                                                    System.out.println("clicked close case");
                                                    Log.info("log4j msg- clicked close case");
                                                    
                                                    //click save
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
                                                    driver.findElement(By.linkText("Save")).click();
                                                    System.out.println("clicked save");
                                                    Log.info("log4j msg- clicked save");
                                                    Thread.sleep(1000);
                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                                    driver.quit();

                                                    
                                    } catch (Exception e){
                                    e.printStackTrace();
                                    System.out.println("Error in adding Comm to FCMC Action Codes");
                                    Log.info("log4j msg - Error in adding Comm to  FCMC Action Codes"); 
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                    driver.quit();
                   
                    }
    }

    
    
    
    
    //delete function
    public void deleteFCMCActionCodes( String fcmcactionCodesCode) throws Exception{
                    
                    try{        
                                    
                    
                    //find FCMC Action Codes
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcactionCodesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcactionCodesCode+"']")).click();
                                                    System.out.println("clicked FCMC Action Codes Code");
                                                    Log.info("log4j msg- clicked FCMC Action Codes code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCActionCodesDeleteLink));
                                                    driver.findElement(FCMCActionCodesDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                    driver.findElement(confirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                    Thread.sleep(1000);
                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                                    driver.quit(); 
                                                  
    } catch (Exception e){System.out.println("Error in deleting FCMC Action Codes");
      Log.info("log4j msg - Error in deleting FCMC Action Codes"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
      driver.quit(); 
      }
}

    
    
    
    
    
    
    
    
    
    
    
    

}

