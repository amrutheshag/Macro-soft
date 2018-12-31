package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class FCMCRelationCodes {

	WebDriver driver;
	WebDriverWait wait ;

    By FCMCRelationCodesAddLink= By.linkText("Add");
    
    By fcmcrelationCodesCodeInput = By.xpath("//input[@id='code']");
    
    By FCMCRelationCodesDescriptionInput= By.xpath("//input[@id='name']");
    
    By FCMCRelationCodesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By FCMCRelationCodesValidateLink =By.linkText("Validate");
    
    By FCMCRelationCodesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By FCMCRelationCodesSaveLink =  By.linkText("Save");
    
    By FCMCRelationCodesEditLink = By.linkText("Edit");
    
    By FCMCRelationCodesCopyLink = By.linkText("Copy");
    
    By FCMCRelationCodesDeleteLink= By.linkText("Delete");
   
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By FCMCRelationCodesCommLink= By.linkText("Commun.");
    
    By FCMCRelationCodesExitLink=  By.linkText("Exit");
    
    
    
    
    public FCMCRelationCodes(WebDriver driver){
                    this.driver= driver;
                    this.wait= new WebDriverWait(driver, 20);
    }
    
   

  //add function
    public void addFCMCRelationCodes( String fcmcrelationCodesCode, String fcmcrelationCodesDescription)throws Exception{
    
                    try{  
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRelationCodesAddLink));
                    driver.findElement(FCMCRelationCodesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("FCMC Relation Codes code: "+fcmcrelationCodesCode);
                    Log.info("log4j msg- FCMC Relation Codes code: "+fcmcrelationCodesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(fcmcrelationCodesCodeInput));
                    driver.findElement(fcmcrelationCodesCodeInput).sendKeys(fcmcrelationCodesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("FCMC Relation Codes Description"+fcmcrelationCodesDescription);
                    Log.info("log4j msg- FCMC Relation Codes Description"+fcmcrelationCodesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRelationCodesDescriptionInput));
                    driver.findElement(FCMCRelationCodesDescriptionInput).sendKeys(fcmcrelationCodesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered Description");
                    Log.info("log4j msg- Entered Description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRelationCodesValidateLink));
                    driver.findElement(FCMCRelationCodesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRelationCodesValidateSaveOKButton));
                    driver.findElement(FCMCRelationCodesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
                    
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRelationCodesSaveLink));
                    driver.findElement(FCMCRelationCodesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                    driver.quit();
                    
                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding FCMC Realtion Codes ");
                    Log.info("log4j msg- Error in Adding FCMC Realtion Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
                    
    }
    
    //copy function
    
    public void copyFCMCRelationCodes( String fcmcrelationCodesCode, String newfcmcrelationCodesCode, String newFCMCRelationCodesDescription)throws Exception{
                    
                    try{
                    System.out.println("FCMC Relation Codes code"+fcmcrelationCodesCode);
                    Log.info("log4j msg- FCMC Relation Codes code"+fcmcrelationCodesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcrelationCodesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcrelationCodesCode+"']")).click();
                    System.out.println("clicked FCMC Relation Codes Code");
                    Log.info("log4j msg- clicked FCMC Relation Codes code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRelationCodesCopyLink));
                    driver.findElement(FCMCRelationCodesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("FCMC Relation Codes new code"+newfcmcrelationCodesCode);
                    Log.info("log4j msg- FCMC Relation Codes new code"+newfcmcrelationCodesCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(fcmcrelationCodesCodeInput));
                    driver.findElement(fcmcrelationCodesCodeInput).clear();
                    driver.findElement(fcmcrelationCodesCodeInput).sendKeys(newfcmcrelationCodesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("carrier covergae types new Description"+newFCMCRelationCodesDescription);
                    Log.info("log4j msg- carrier covergae types new Description"+newFCMCRelationCodesDescription);
    //enter new Description
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRelationCodesDescriptionInput));
                    driver.findElement(FCMCRelationCodesDescriptionInput).clear();
                    driver.findElement(FCMCRelationCodesDescriptionInput).sendKeys(newFCMCRelationCodesDescription);
                    System.out.println("Entered new Description");
                    Log.info("log4j msg- Entered new Description");
                    
                    
                    
                    
                    Thread.sleep(1000);
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRelationCodesSaveLink));
                    driver.findElement(FCMCRelationCodesSaveLink).click();
                    
                    Thread.sleep(1000);

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit();
                    
                    Thread.sleep(1000);
                    
                    
                    
                    
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying FCMC Realtion Codes ");
                    Log.info("log4j msg- Error in Copying FCMC Realtion Codes "); 
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                    driver.quit();}
    
    
    }
    
    
    
    //edit function
    public void editFCMCRelationCodes( String fcmcrelationCodesCode,String FCMCRelationCodesDescription, String recordMark)throws Exception{
        
        try{ 
        System.out.println("FCMC Relation Codes code"+fcmcrelationCodesCode);
        Log.info("log4j msg- FCMC Relation Codes code"+fcmcrelationCodesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcrelationCodesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcrelationCodesCode+"']")).click();
        System.out.println("clicked FCMC Realtion Codes");
        Log.info("log4j msg- clicked FCMC Realtion Codes");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRelationCodesEditLink));
        driver.findElement(FCMCRelationCodesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("FCMC Relation Codes Record Mark: "+recordMark);
        Log.info("log4j msg- FCMC Relation Codes Record Mark: "+recordMark);
        		          
//enter new Record Mark
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRelationCodesRecordMark));
        driver.findElement(FCMCRelationCodesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(FCMCRelationCodesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRelationCodesSaveLink));
        driver.findElement(FCMCRelationCodesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
        Thread.sleep(1000);
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
        driver.quit();
        
        
        }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing FCMC Realtion Codes ");
        Log.info("log4j msg- Error in Editing FCMC Realtion Codes "); 
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit();}


}
    //exit function
    public void exitFCMCRelationCodes( String fcmcrelationCodesCode) throws Exception{
    try{
                   System.out.println("FCMC Relation Codes code"+fcmcrelationCodesCode);
                    Log.info("log4j msg- FCMC Relation Codes code"+fcmcrelationCodesCode);
                                    Thread.sleep(1000);
                                    driver.findElement(FCMCRelationCodesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  FCMC Realtion Codes ");
                                    Log.info("log4j msg- clicked exit in  FCMC Realtion Codes "); 
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                                    driver.quit();
                                  
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting FCMC Realtion Codes ");
    Log.info("log4j msg- Error in Exiting FCMC Realtion Codes "); 
    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
    driver.quit();}
    }
    
    
    //add comm function
    public void addCommFCMCRelationCodes( String fcmcrelationCodesCode, String subject, String NoteType, String medium, String notes) throws Exception{
                    
                    try{        System.out.println("FCMC Relation Codes code"+fcmcrelationCodesCode);
                    Log.info("log4j msg- FCMC Relation Codes code"+fcmcrelationCodesCode);
                                    //find FCMC Relation Codes
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcrelationCodesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcrelationCodesCode+"']")).click();
                    System.out.println("clicked FCMC Realtion Codes Code");
                    Log.info("log4j msg- clicked FCMC Realtion Codes code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRelationCodesCommLink));
                    driver.findElement(FCMCRelationCodesCommLink).click();
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
                                                    
                                    } catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to FCMC Realtion Codes");
                                      Log.info("log4j msg - Error in adding Comm to  FCMC Realtion Codes");
                                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                      driver.quit();      
                    }
    }

    
    
    
    
    //delete function
    public void deleteFCMCRelationCodes( String fcmcrelationCodesCode) throws Exception{
                    
                    try{        
                    //find FCMC Realtion Codes
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcrelationCodesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcrelationCodesCode+"']")).click();
                                                    System.out.println("clicked FCMC Realtion Codes Code");
                                                    Log.info("log4j msg- clicked FCMC Realtion Codes code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRelationCodesDeleteLink));
                                                    driver.findElement(FCMCRelationCodesDeleteLink).click();
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
                                                    
                                                    
                    
    } catch (Exception e){System.out.println("Error in deleting FCMC Realtion Codes");
      Log.info("log4j msg - Error in deleting FCMC Realtion Codes"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
      driver.quit();
                    }
}


}