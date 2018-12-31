package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class FCMCEthnicGroupCodes {

	WebDriver driver;
	WebDriverWait wait;

    By FCMCEthnicGroupCodesAddLink= By.linkText("Add");
    
    By FCMCEthnicgroupCodesCodeInput = By.xpath("//input[@id='code']");
    
    By FCMCEthnicGroupCodesDescriptionInput= By.xpath("//input[@id='name']");
    
    By FCMCEthnicGroupCodesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By FCMCEthnicGroupCodesValidateLink =By.linkText("Validate");
    
    By FCMCEthnicGroupCodesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By FCMCEthnicGroupCodesSaveLink =  By.linkText("Save");
    
    By FCMCEthnicGroupCodesEditLink = By.linkText("Edit");
    
    By FCMCEthnicGroupCodesCopyLink = By.linkText("Copy");
    
    By FCMCEthnicGroupCodesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By FCMCEthnicGroupCodesCommLink= By.linkText("Commun.");
    
    By FCMCEthnicGroupCodesExitLink=  By.linkText("Exit");
    
    
    
    
    public FCMCEthnicGroupCodes(WebDriver driver){
                    this.driver= driver;
                    this.wait = new WebDriverWait(driver, 20);
    }
    
   

  //add function
    public void addFCMCEthnicGroupCodes( String fcmcethnicgroupCodesCode, String fcmcethnicgroupCodesDescription)throws Exception{
    
                    try{
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicGroupCodesAddLink));
                    driver.findElement(FCMCEthnicGroupCodesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("FCMC Ethnic Group Code code: "+fcmcethnicgroupCodesCode);
                    Log.info("log4j msg- FCMC Ethnic Group Code code: "+fcmcethnicgroupCodesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicgroupCodesCodeInput));
                    driver.findElement(FCMCEthnicgroupCodesCodeInput).sendKeys(fcmcethnicgroupCodesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("FCMC Ethnic Group Code Description"+fcmcethnicgroupCodesDescription);
                    Log.info("log4j msg- FCMC Ethnic Group Code Description"+fcmcethnicgroupCodesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicGroupCodesDescriptionInput));
                    driver.findElement(FCMCEthnicGroupCodesDescriptionInput).sendKeys(fcmcethnicgroupCodesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered Description");
                    Log.info("log4j msg- Entered Description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicGroupCodesValidateLink));
                    driver.findElement(FCMCEthnicGroupCodesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicGroupCodesValidateSaveOKButton));
                    driver.findElement(FCMCEthnicGroupCodesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
                    
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicGroupCodesSaveLink));
                    driver.findElement(FCMCEthnicGroupCodesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); 
                    
                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding FCMC Ethnic Group Codes ");
                    Log.info("log4j msg- Error in Adding FCMC Ethnic Group Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); }
                    
    }
    
    //copy function
    
    public void copyFCMCEthnicGroupCodes( String fcmcethnicgroupCodesCode, String newfcmcethnicgroupCodesCode, String newFCMCEthnicGroupCodesDescription)throws Exception{
                    
                    try{
                    
                    System.out.println("FCMC Ethnic Group Code code"+fcmcethnicgroupCodesCode);
                    Log.info("log4j msg- FCMC Ethnic Group Code code"+fcmcethnicgroupCodesCode);

                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcethnicgroupCodesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcethnicgroupCodesCode+"']")).click();
                    System.out.println("clicked FCMC Ethnic Group Code Code");
                    Log.info("log4j msg- clicked FCMC Ethnic Group Code code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicGroupCodesCopyLink));
                    driver.findElement(FCMCEthnicGroupCodesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("FCMC Ethnic Group Code new code"+newfcmcethnicgroupCodesCode);
                    Log.info("log4j msg- FCMC Ethnic Group Code new code"+newfcmcethnicgroupCodesCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicgroupCodesCodeInput));
                    driver.findElement(FCMCEthnicgroupCodesCodeInput).clear();
                    driver.findElement(FCMCEthnicgroupCodesCodeInput).sendKeys(newfcmcethnicgroupCodesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("carrier covergae types new Description"+newFCMCEthnicGroupCodesDescription);
                    Log.info("log4j msg- carrier covergae types new Description"+newFCMCEthnicGroupCodesDescription);
    //enter new Description
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicGroupCodesDescriptionInput));
                    driver.findElement(FCMCEthnicGroupCodesDescriptionInput).clear();
                    driver.findElement(FCMCEthnicGroupCodesDescriptionInput).sendKeys(newFCMCEthnicGroupCodesDescription);
                    System.out.println("Entered new Description");
                    Log.info("log4j msg- Entered new Description");
                    
                    
                    
                    
                    Thread.sleep(1000);
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicGroupCodesSaveLink));
                    driver.findElement(FCMCEthnicGroupCodesSaveLink).click();
                    
                    Thread.sleep(1000);

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); 
                    
                    Thread.sleep(1000);
                    
                    
                    
                    
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying FCMC Ethnic Group Codes ");
                    Log.info("log4j msg- Error in Copying FCMC Ethnic Group Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); }
    
    
    }
    
    
    
    //edit function
    public void editFCMCEthnicGroupCodes( String fcmcethnicgroupCodesCode,String FCMCEthnicGroupCodesDescription, String recordMark)throws Exception{
        
        try{ 
        	
        
        System.out.println("FCMC Ethnic Group Code code"+fcmcethnicgroupCodesCode);
        Log.info("log4j msg- FCMC Ethnic Group Code code"+fcmcethnicgroupCodesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcethnicgroupCodesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcethnicgroupCodesCode+"']")).click();
        System.out.println("clicked FCMC Ethnic Group Codes");
        Log.info("log4j msg- clicked FCMC Ethnic Group Codes");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicGroupCodesEditLink));
        driver.findElement(FCMCEthnicGroupCodesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("FCMC Ethnic Group Code Record Mark: "+recordMark);
        Log.info("log4j msg- FCMC Ethnic Group Code Record Mark: "+recordMark);
        		          
//enter new Record Mark
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicGroupCodesRecordMark));
        driver.findElement(FCMCEthnicGroupCodesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(FCMCEthnicGroupCodesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicGroupCodesSaveLink));
        driver.findElement(FCMCEthnicGroupCodesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
        driver.quit(); 
        
        
        }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing FCMC Ethnic Group Codes ");
        Log.info("log4j msg- Error in Editing FCMC Ethnic Group Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
driver.quit(); }


}
    //exit function
    public void exitFCMCEthnicGroupCodes( String fcmcethnicgroupCodesCode) throws Exception{
    try{
                   System.out.println("FCMC Ethnic Group Code code"+fcmcethnicgroupCodesCode);
                    Log.info("log4j msg- FCMC Ethnic Group Code code"+fcmcethnicgroupCodesCode);
                                    Thread.sleep(1000);
                                    driver.findElement(FCMCEthnicGroupCodesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  FCMC Ethnic Group Codes ");
                                    Log.info("log4j msg- clicked exit in  FCMC Ethnic Group Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                    driver.quit(); 
                                  
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting FCMC Ethnic Group Codes ");
    Log.info("log4j msg- Error in Exiting FCMC Ethnic Group Codes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
    driver.quit(); }
    }
    
    
    //add comm function
    public void addCommFCMCEthnicGroupCodes( String fcmcethnicgroupCodesCode, String subject, String NoteType, String medium, String notes) throws Exception{
                    
                    try{        
                    	
                    System.out.println("FCMC Ethnic Group Code code"+fcmcethnicgroupCodesCode);
                    Log.info("log4j msg- FCMC Ethnic Group Code code"+fcmcethnicgroupCodesCode);
                                    //find FCMC Ethnic Group Code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcethnicgroupCodesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcethnicgroupCodesCode+"']")).click();
                    System.out.println("clicked FCMC Ethnic Group Codes Code");
                    Log.info("log4j msg- clicked FCMC Ethnic Group Codes code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicGroupCodesCommLink));
                    driver.findElement(FCMCEthnicGroupCodesCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                                                    
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
                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                                    driver.quit();
                                    
                                                    
                                    } catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to FCMC Ethnic Group Codes");
                                      Log.info("log4j msg - Error in adding Comm to  FCMC Ethnic Group Codes"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                      driver.quit();
             
                    }
    }

    
    
    
    
    //delete function
    public void deleteFCMCEthnicGroupCodes( String fcmcethnicgroupCodesCode) throws Exception{
                    
                    try{        
                                    
                    
                    //find FCMC Ethnic Group Codes
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcethnicgroupCodesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcethnicgroupCodesCode+"']")).click();
                                                    System.out.println("clicked FCMC Ethnic Group Codes Code");
                                                    Log.info("log4j msg- clicked FCMC Ethnic Group Codes code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCEthnicGroupCodesDeleteLink));
                                                    driver.findElement(FCMCEthnicGroupCodesDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                    driver.findElement(confirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                                    driver.quit(); 
                                                    
                                                    
                    
    } catch (Exception e){System.out.println("Error in deleting FCMC Ethnic Group Codes");
      Log.info("log4j msg - Error in deleting FCMC Ethnic Group Codes"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
      driver.quit(); 
                    }
}

}
