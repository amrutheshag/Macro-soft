package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class FCMCRaceCodes {

	WebDriver driver;
	WebDriverWait wait ;
 
    By FCMCRaceCodesAddLink= By.linkText("Add");
    
    By FCMCRaceCodesCodeInput = By.xpath("//input[@id='code']");
    
    By FCMCRaceCodesDescriptionInput= By.xpath("//input[@id='name']");
    
    By FCMCRaceCodesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By FCMCRaceCodesValidateLink =By.linkText("Validate");
    
    By FCMCRaceCodesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By FCMCRaceCodesSaveLink =  By.linkText("Save");
    
    By FCMCRaceCodesEditLink = By.linkText("Edit");
    
    By FCMCRaceCodesCopyLink = By.linkText("Copy");
    
    By FCMCRaceCodesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By FCMCRaceCodesCommLink= By.linkText("Commun.");
   
    By FCMCRaceCodesExitLink=  By.linkText("Exit");
    
    
    
    
    public FCMCRaceCodes(WebDriver driver){
                    this.driver= driver;
                    this.wait= new WebDriverWait(driver, 20);
    }
    
   

  //add function
    public void addFCMCRaceCodes( String fcmcraceCodesCode, String fcmcraceCodesDescription)throws Exception{
    
                    try{ 
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesAddLink));
                    driver.findElement(FCMCRaceCodesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("FCMC Race Codes code: "+fcmcraceCodesCode);
                    Log.info("log4j msg- FCMC Race Codes code: "+fcmcraceCodesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesCodeInput));
                    driver.findElement(FCMCRaceCodesCodeInput).sendKeys(fcmcraceCodesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("FCMC Race Codes Description"+fcmcraceCodesDescription);
                    Log.info("log4j msg- FCMC Race Codes Description"+fcmcraceCodesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesDescriptionInput));
                    driver.findElement(FCMCRaceCodesDescriptionInput).sendKeys(fcmcraceCodesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered Description");
                    Log.info("log4j msg- Entered Description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesValidateLink));
                    driver.findElement(FCMCRaceCodesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesValidateSaveOKButton));
                    driver.findElement(FCMCRaceCodesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
                    
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesSaveLink));
                    driver.findElement(FCMCRaceCodesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); 
                    
                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding FCMC Race Codes ");
                    Log.info("log4j msg- Error in Adding FCMC Race Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
driver.quit(); }
                    
    }
    
    //copy function
    
    public void copyFCMCRaceCodes( String fcmcraceCodesCode, String newfcmcraceCodesCode, String newFCMCRaceCodesDescription)throws Exception{
                    
                    try{ 
                    
                    System.out.println("FCMC Race Codes code"+fcmcraceCodesCode);
                    Log.info("log4j msg- FCMC Race Codes code"+fcmcraceCodesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcraceCodesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcraceCodesCode+"']")).click();
                    System.out.println("clicked FCMC Race Codes Code");
                    Log.info("log4j msg- clicked FCMC Race Codes code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesCopyLink));
                    driver.findElement(FCMCRaceCodesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("FCMC Race Codes new code"+newfcmcraceCodesCode);
                    Log.info("log4j msg- FCMC Race Codes new code"+newfcmcraceCodesCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesCodeInput));
                    driver.findElement(FCMCRaceCodesCodeInput).clear();
                    driver.findElement(FCMCRaceCodesCodeInput).sendKeys(newfcmcraceCodesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("carrier covergae types new Description"+newFCMCRaceCodesDescription);
                    Log.info("log4j msg- carrier covergae types new Description"+newFCMCRaceCodesDescription);
    //enter new Description
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesDescriptionInput));
                    driver.findElement(FCMCRaceCodesDescriptionInput).clear();
                    driver.findElement(FCMCRaceCodesDescriptionInput).sendKeys(newFCMCRaceCodesDescription);
                    System.out.println("Entered new Description");
                    Log.info("log4j msg- Entered new Description");
                    
                    
                    
                    
                    Thread.sleep(1000);
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesSaveLink));
                    driver.findElement(FCMCRaceCodesSaveLink).click();
                    
                    Thread.sleep(1000);

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                    driver.quit(); 
                    
                    Thread.sleep(1000);
                     }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying FCMC Race Codes ");
                    Log.info("log4j msg- Error in Copying FCMC Race Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); }
    
    
    }
    
    
    
    //edit function
    public void editFCMCRaceCodes( String fcmcraceCodesCode,String FCMCRaceCodesDescription, String recordMark)throws Exception{
        
        try{ 
        	
        System.out.println("FCMC Race Codes code"+fcmcraceCodesCode);
        Log.info("log4j msg- FCMC Race Codes code"+fcmcraceCodesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcraceCodesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcraceCodesCode+"']")).click();
        System.out.println("clicked FCMC Race Codes");
        Log.info("log4j msg- clicked FCMC Race Codes");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesEditLink));
        driver.findElement(FCMCRaceCodesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("FCMC Race Codes Record Mark"+recordMark);
        Log.info("log4j msg- FCMC Race Codes Record Mark"+recordMark);
        		          
//enter new Record Mark
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesRecordMark));
        driver.findElement(FCMCRaceCodesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(FCMCRaceCodesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesSaveLink));
        driver.findElement(FCMCRaceCodesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
        Thread.sleep(1000);
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
        
        
        }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing FCMC Race Codes ");
        Log.info("log4j msg- Error in Editing FCMC Race Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
        driver.quit(); }


}
    //exit function
    public void exitFCMCRaceCodes( String fcmcraceCodesCode) throws Exception{
    try{
                    System.out.println("FCMC Race Codes code"+fcmcraceCodesCode);
                    Log.info("log4j msg- FCMC Race Codes code"+fcmcraceCodesCode);
                                   Thread.sleep(1000);
                                    driver.findElement(FCMCRaceCodesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  FCMC Race Codes ");
                                    Log.info("log4j msg- clicked exit in  FCMC Race Codes ");
                                    Thread.sleep(1000);
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                    driver.quit(); 
                                  
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting FCMC Race Codes ");
    Log.info("log4j msg- Error in Exiting FCMC Race Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
    driver.quit(); }
    }
    
    
    //add comm function
    public void addCommFCMCRaceCodes( String fcmcraceCodesCode, String subject, String NoteType, String medium, String notes) throws Exception{
                    
                    try{       
                      System.out.println("FCMC Race Codes code"+fcmcraceCodesCode);
                    Log.info("log4j msg- FCMC Race Codes code"+fcmcraceCodesCode);
                                    //find FCMC Race Codes
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcraceCodesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcraceCodesCode+"']")).click();
                    System.out.println("clicked FCMC Race Codes Code");
                    Log.info("log4j msg- clicked FCMC Race Codes code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesCommLink));
                    driver.findElement(FCMCRaceCodesCommLink).click();
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
                                                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@data-ng-model='currentRecord.notes']")));
                                                    driver.findElement(By.xpath("//textarea[@data-ng-model='currentRecord.notes']")).sendKeys(Keys.PAGE_DOWN);
                                                    System.out.println("clicked page down");
                                                    Log.info("log4j msg- clicked page down");
                                                    
                                                    Thread.sleep(2000);
                                                    
                                                    
                                                    //click add details
                                                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
                                                    driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
                                                    System.out.println("clicked add details");
                                                    Log.info("log4j msg- clicked add details");
                                                    Thread.sleep(2000);
                                                    
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
                                   
                                                    
                                    } catch (Exception e){
                                    	e.printStackTrace();
                                    System.out.println("Error in adding Comm to FCMC Race Codes");
                                    Log.info("log4j msg - Error in adding Comm to  FCMC Race Codes"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                    driver.quit();      
                    }
    }

    
    
    
    
    //delete function
    public void deleteFCMCRaceCodes( String fcmcraceCodesCode) throws Exception{
                    
                    try{             
                    
                    //find FCMC Race Codes
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcraceCodesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcraceCodesCode+"']")).click();
                                                    System.out.println("clicked FCMC Race Codes Code");
                                                    Log.info("log4j msg- clicked FCMC Race Codes code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCRaceCodesDeleteLink));
                                                    driver.findElement(FCMCRaceCodesDeleteLink).click();
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
                                                    
    } catch (Exception e){System.out.println("Error in deleting FCMC Race Codes");
                          Log.info("log4j msg - Error in deleting FCMC Race Codes"); 
                          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                          driver.quit(); 
                    }
}

    
    
    
    
    
    
    
    
    
    
   
}