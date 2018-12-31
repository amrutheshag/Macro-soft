package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class FCMCConsenterTypes {

	WebDriver driver;
	WebDriverWait wait;

    By FCMCConsenterTypesAddLink= By.linkText("Add");
    
    By FcmcconsenterTypesCodeInput = By.xpath("//input[@id='code']");
    
    By FCMCConsenterTypesDescriptionInput= By.xpath("//input[@id='name']");
    
    By FCMCConsenterTypesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By FCMCConsenterTypesValidateLink =By.linkText("Validate");
    
    By FCMCConsenterTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By FCMCConsenterTypesSaveLink =  By.linkText("Save");
    
    By FCMCConsenterTypesEditLink = By.linkText("Edit");
    
    By FCMCConsenterTypesCopyLink = By.linkText("Copy");
    
    By FCMCConsenterTypesDeleteLink= By.linkText("Delete");
    
    By ConfirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By FCMCConsenterTypesCommLink= By.linkText("Commun.");
    
    By FCMCConsenterTypesExitLink=  By.linkText("Exit");
    
    
    
    
    public FCMCConsenterTypes(WebDriver driver){
                    this.driver= driver;
                    this.wait = new WebDriverWait(driver, 20);
    }
    
   

    //add function
    public void addFCMCConsenterTypes( String fcmcconsenterTypesCode, String fcmcconsenterTypesDescription)throws Exception{
    
                    try{ 
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCConsenterTypesAddLink));
                    driver.findElement(FCMCConsenterTypesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("FCMC Constenter Type code: "+fcmcconsenterTypesCode);
                    Log.info("log4j msg- FCMC Constenter Type code: "+fcmcconsenterTypesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FcmcconsenterTypesCodeInput));
                    driver.findElement(FcmcconsenterTypesCodeInput).sendKeys(fcmcconsenterTypesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("FCMC Constenter Type Description"+fcmcconsenterTypesDescription);
                    Log.info("log4j msg- FCMC Constenter Type Description"+fcmcconsenterTypesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCConsenterTypesDescriptionInput));
                    driver.findElement(FCMCConsenterTypesDescriptionInput).sendKeys(fcmcconsenterTypesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered Description");
                    Log.info("log4j msg- Entered Description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCConsenterTypesValidateLink));
                    driver.findElement(FCMCConsenterTypesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCConsenterTypesValidateSaveOKButton));
                    driver.findElement(FCMCConsenterTypesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
                    
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCConsenterTypesSaveLink));
                    driver.findElement(FCMCConsenterTypesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                    
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit();
                    
                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding FCMC Consenter Types ");
                    Log.info("log4j msg- Error in Adding FCMC Consenter Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); }
                    
    }
    
    //copy function
    
    public void copyFCMCConsenterTypes( String fcmcconsenterTypesCode, String newfcmcconsenterTypesCode, String newFCMCConsenterTypesDescription)throws Exception{
                    
                    try{ 
                    
                    System.out.println("FCMC Constenter Type code"+fcmcconsenterTypesCode);
                    Log.info("log4j msg- FCMC Constenter Type code"+fcmcconsenterTypesCode);
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcconsenterTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcconsenterTypesCode+"']")).click();
                    System.out.println("clicked FCMC Constenter Type Code");
                    Log.info("log4j msg- clicked FCMC Constenter Type code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCConsenterTypesCopyLink));
                    driver.findElement(FCMCConsenterTypesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("FCMC Constenter Type new code"+newfcmcconsenterTypesCode);
                    Log.info("log4j msg- FCMC Constenter Type new code"+newfcmcconsenterTypesCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FcmcconsenterTypesCodeInput));
                    driver.findElement(FcmcconsenterTypesCodeInput).clear();
                    driver.findElement(FcmcconsenterTypesCodeInput).sendKeys(newfcmcconsenterTypesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("carrier covergae types new Description"+newFCMCConsenterTypesDescription);
                    Log.info("log4j msg- carrier covergae types new Description"+newFCMCConsenterTypesDescription);
    //enter new Description
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCConsenterTypesDescriptionInput));
                    driver.findElement(FCMCConsenterTypesDescriptionInput).clear();
                    driver.findElement(FCMCConsenterTypesDescriptionInput).sendKeys(newFCMCConsenterTypesDescription);
                    System.out.println("Entered new Description");
                    Log.info("log4j msg- Entered new Description");
                    
                    
                    
                    
                    Thread.sleep(1000);
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCConsenterTypesSaveLink));
                    driver.findElement(FCMCConsenterTypesSaveLink).click();
                    
                    Thread.sleep(1000);

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); 
            
                    
                    
                    
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying FCMC Consenter Types ");
                    Log.info("log4j msg- Error in Copying FCMC Consenter Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); }
    
    
    }
    
    
    
    //edit function
    public void editFCMCConsenterTypes( String fcmcconsenterTypesCode,String FCMCConsenterTypesDescription, String recordMark)throws Exception{
        
        try{ 
        
        System.out.println("FCMC Constenter Type code"+fcmcconsenterTypesCode);
        Log.info("log4j msg- FCMC Constenter Type code"+fcmcconsenterTypesCode);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcconsenterTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcconsenterTypesCode+"']")).click();
        System.out.println("clicked FCMC Consenter Types");
        Log.info("log4j msg- clicked FCMC Consenter Types");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCConsenterTypesEditLink));
        driver.findElement(FCMCConsenterTypesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("FCMC Constenter Type Record Mark: "+recordMark);
        Log.info("log4j msg- FCMC Constenter Type Record Mark: "+recordMark);
        		          
//enter new Record Mark
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCConsenterTypesRecordMark));
        driver.findElement(FCMCConsenterTypesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(FCMCConsenterTypesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCConsenterTypesSaveLink));
        driver.findElement(FCMCConsenterTypesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
        Thread.sleep(1000);
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
        driver.quit(); 
        
        
        }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing FCMC Consenter Types ");
        Log.info("log4j msg- Error in Editing FCMC Consenter Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
        driver.quit(); }


}
    //exit function
    public void exitFCMCConsenterTypes( String fcmcconsenterTypesCode) throws Exception{
    try{
                    System.out.println("FCMC Constenter Type code"+fcmcconsenterTypesCode);
                    Log.info("log4j msg- FCMC Constenter Type code"+fcmcconsenterTypesCode);
                                    Thread.sleep(1000);
                                    driver.findElement(FCMCConsenterTypesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  FCMC Consenter Types ");
                                    Log.info("log4j msg- clicked exit in  FCMC Consenter Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                    driver.quit(); 
                                  
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting FCMC Consenter Types ");
    Log.info("log4j msg- Error in Exiting FCMC Consenter Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
    driver.quit(); }
    }
    
    
    //add comm function
    public void addCommFCMCConsenterTypes( String fcmcconsenterTypesCode, String subject, String NoteType, String medium, String notes) throws Exception{
                    
                    try{         
                    System.out.println("FCMC Constenter Type code"+fcmcconsenterTypesCode);
                    Log.info("log4j msg- FCMC Constenter Type code"+fcmcconsenterTypesCode);
                                    //find FCMC Constenter Type
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcconsenterTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcconsenterTypesCode+"']")).click();
                    System.out.println("clicked FCMC Consenter Types Code");
                    Log.info("log4j msg- clicked FCMC Consenter Types code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCConsenterTypesCommLink));
                    driver.findElement(FCMCConsenterTypesCommLink).click();
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
                                    
                                                    
                                    } catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to FCMC Consenter Types");
                                      Log.info("log4j msg - Error in adding Comm to  FCMC Consenter Types"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                      driver.quit();
                   
                    }
    }

    
    
    
    
    //delete function
    public void deleteFCMCConsenterTypes( String fcmcconsenterTypesCode) throws Exception{
                    
    	
                    try{        
                                    
                    
                    //find FCMC Consenter Types
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcconsenterTypesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+fcmcconsenterTypesCode+"']")).click();
                                                    System.out.println("clicked FCMC Consenter Types Code");
                                                    Log.info("log4j msg- clicked FCMC Consenter Types code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(FCMCConsenterTypesDeleteLink));
                                                    driver.findElement(FCMCConsenterTypesDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmDeleteButton));
                                                    driver.findElement(ConfirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                    Thread.sleep(1000);
                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                                                    driver.quit(); 
                                                    
                                                    
                    
    } catch (Exception e){System.out.println("Error in deleting FCMC Consenter Types");
                          Log.info("log4j msg - Error in deleting FCMC Consenter Types"); 
                          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                          driver.quit(); 

                    }
}

    
    
    
    
    
    
    
    
    
    
    

}
