package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class FCMCLevelofCareCodes {

	WebDriver driver;
	WebDriverWait wait;

    By FCMCLevelofCareCodesAddLink= By.linkText("Add");
    
    By FCMCLevelofcareCodesCodeInput = By.xpath("//input[@id='code']");
    
    By FCMCLevelofCareCodesDescriptionInput= By.xpath("//input[@id='name']");
    
    By FCMCLevelofCareCodesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By FCMCLevelofCareCodesValidateLink =By.linkText("Validate");
    
    By FCMCLevelofCareCodesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By FCMCLevelofCareCodesSaveLink =  By.linkText("Save");
    
    By FCMCLevelofCareCodesEditLink = By.linkText("Edit");
    
    By FCMCLevelofCareCodesCopyLink = By.linkText("Copy");
    
    By FCMCLevelofCareCodesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By FCMCLevelofCareCodesCommLink= By.linkText("Commun.");
    
    By FCMCLevelofCareCodesExitLink=  By.linkText("Exit");
    
     
    public FCMCLevelofCareCodes(WebDriver driver){
                    this.driver= driver;
                    this.wait = new WebDriverWait(driver, 20);
    }
    
   

  //add function
    public void addFCMCLevelofCareCodes( String fcmclevelofcareCodesCode, String fcmclevelofcareCodesDescription)throws Exception{
    
                    try{ 
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofCareCodesAddLink));
                    driver.findElement(FCMCLevelofCareCodesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("FCMC Level of Care code: "+fcmclevelofcareCodesCode);
                    Log.info("log4j msg- FCMC Level of Care code: "+fcmclevelofcareCodesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofcareCodesCodeInput));
                    driver.findElement(FCMCLevelofcareCodesCodeInput).sendKeys(fcmclevelofcareCodesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("FCMC Level of Care Description"+fcmclevelofcareCodesDescription);
                    Log.info("log4j msg- FCMC Level of Care Description"+fcmclevelofcareCodesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofCareCodesDescriptionInput));
                    driver.findElement(FCMCLevelofCareCodesDescriptionInput).sendKeys(fcmclevelofcareCodesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered Description");
                    Log.info("log4j msg- Entered Description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofCareCodesValidateLink));
                    driver.findElement(FCMCLevelofCareCodesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofCareCodesValidateSaveOKButton));
                    driver.findElement(FCMCLevelofCareCodesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
                    
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofCareCodesSaveLink));
                    driver.findElement(FCMCLevelofCareCodesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); 
                    
                    }catch (Exception e){
                    e.printStackTrace(); 
                    System.out.println("Error in Adding FCMC Level of Care Codes ");
                    Log.info("log4j msg- Error in Adding FCMC Level of Care Codes "); 
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); }
                    
    }
    
    //copy function
    
    public void copyFCMCLevelofCareCodes( String fcmclevelofcareCodesCode, String newfcmclevelofcareCodesCode, String newFCMCLevelofCareCodesDescription)throws Exception{
                    
                    try{ 
                    
                    System.out.println("FCMC Level of Care code"+fcmclevelofcareCodesCode);
                    Log.info("log4j msg- FCMC Level of Care code"+fcmclevelofcareCodesCode);
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmclevelofcareCodesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmclevelofcareCodesCode+"']")).click();
                    System.out.println("clicked FCMC Level of Care Code");
                    Log.info("log4j msg- clicked FCMC Level of Care code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofCareCodesCopyLink));
                    driver.findElement(FCMCLevelofCareCodesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("FCMC Level of Care new code"+newfcmclevelofcareCodesCode);
                    Log.info("log4j msg- FCMC Level of Care new code"+newfcmclevelofcareCodesCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofcareCodesCodeInput));
                    driver.findElement(FCMCLevelofcareCodesCodeInput).clear();
                    driver.findElement(FCMCLevelofcareCodesCodeInput).sendKeys(newfcmclevelofcareCodesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("carrier covergae types new Description"+newFCMCLevelofCareCodesDescription);
                    Log.info("log4j msg- carrier covergae types new Description"+newFCMCLevelofCareCodesDescription);
    //enter new Description
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofCareCodesDescriptionInput));
                    driver.findElement(FCMCLevelofCareCodesDescriptionInput).clear();
                    driver.findElement(FCMCLevelofCareCodesDescriptionInput).sendKeys(newFCMCLevelofCareCodesDescription);
                    System.out.println("Entered new Description");
                    Log.info("log4j msg- Entered new Description");
                    
                    
                    
                    
                    Thread.sleep(1000);
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofCareCodesSaveLink));
                    driver.findElement(FCMCLevelofCareCodesSaveLink).click();
                    
                    Thread.sleep(1000);

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit();
                 
                    
                    }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("Error in Copying FCMC Level of Care Codes ");
                    Log.info("log4j msg- Error in Copying FCMC Level of Care Codes "); 
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); }
    
    
    }
    
    
    
    //edit function
    public void editFCMCLevelofCareCodes( String fcmclevelofcareCodesCode,String FCMCLevelofCareCodesDescription, String recordMark)throws Exception{
        
        try{ 
        
        System.out.println("FCMC Level of Care code"+fcmclevelofcareCodesCode);
        Log.info("log4j msg- FCMC Level of Care code"+fcmclevelofcareCodesCode);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmclevelofcareCodesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmclevelofcareCodesCode+"']")).click();
        System.out.println("clicked FCMC Level of Care Codes");
        Log.info("log4j msg- clicked FCMC Level of Care Codes");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofCareCodesEditLink));
        driver.findElement(FCMCLevelofCareCodesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("FCMC Level of Care Record Mark: "+recordMark);
        Log.info("log4j msg- FCMC Level of Care Record Mark: "+recordMark);
        		          
//enter new Record Mark
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofCareCodesRecordMark));
        driver.findElement(FCMCLevelofCareCodesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(FCMCLevelofCareCodesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofCareCodesSaveLink));
        driver.findElement(FCMCLevelofCareCodesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
        Thread.sleep(1000);
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
        driver.quit(); 
        
        
        }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing FCMC Level of Care Codes ");
        Log.info("log4j msg- Error in Editing FCMC Level of Care Codes "); 
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
        driver.quit(); }


}
    //exit function
    public void exitFCMCLevelofCareCodes( String fcmclevelofcareCodesCode) throws Exception{
    try{
                    System.out.println("FCMC Level of Care code"+fcmclevelofcareCodesCode);
                    Log.info("log4j msg- FCMC Level of Care code"+fcmclevelofcareCodesCode);
                                   Thread.sleep(1000);
                                    driver.findElement(FCMCLevelofCareCodesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  FCMC Level of Care Codes ");
                                    Log.info("log4j msg- clicked exit in  FCMC Level of Care Codes "); 
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                    driver.quit(); 
                                 
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting FCMC Level of Care Codes ");
    Log.info("log4j msg- Error in Exiting FCMC Level of Care Codes "); 
    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
    driver.quit(); }
    }
    
    
    //add comm function
    public void addCommFCMCLevelofCareCodes( String fcmclevelofcareCodesCode, String subject, String NoteType, String medium, String notes) throws Exception{
                    
                    try{        
                    System.out.println("FCMC Level of Care code"+fcmclevelofcareCodesCode);
                    Log.info("log4j msg- FCMC Level of Care code"+fcmclevelofcareCodesCode);
                                    //find FCMC Level of Care
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmclevelofcareCodesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmclevelofcareCodesCode+"']")).click();
                    System.out.println("clicked FCMC Level of Care Codes Code");
                    Log.info("log4j msg- clicked FCMC Level of Care Codes code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofCareCodesCommLink));
                    driver.findElement(FCMCLevelofCareCodesCommLink).click();
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

                                                    
                                    } catch (Exception e){
                                    e.printStackTrace();
                                    System.out.println("Error in adding Comm to FCMC Level of Care Codes");
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                    Log.info("log4j msg - Error in adding Comm to  FCMC Level of Care Codes"); 
                                    driver.quit();
                       
                    }
    }

    
    
    
    
    //delete function
    public void deleteFCMCLevelofCareCodes( String fcmclevelofcareCodesCode) throws Exception{
                    
                    try{        
                                    
                    
                    //find FCMC Level of Care Codes
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmclevelofcareCodesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmclevelofcareCodesCode+"']")).click();
                                                    System.out.println("clicked FCMC Level of Care Codes Code");
                                                    Log.info("log4j msg- clicked FCMC Level of Care Codes code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCLevelofCareCodesDeleteLink));
                                                    driver.findElement(FCMCLevelofCareCodesDeleteLink).click();
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
                                                    
                                                    
                    
                    } catch (Exception e){
                    	System.out.println("Error in deleting FCMC Level of Care Codes");
                    	Log.info("log4j msg - Error in deleting FCMC Level of Care Codes"); 
                    	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    	driver.quit(); 
                    }
    		}	

    
   
 

}
