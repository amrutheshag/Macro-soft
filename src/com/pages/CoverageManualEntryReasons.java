package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class CoverageManualEntryReasons {

	WebDriver driver;
	WebDriverWait wait;

    
    By CoverageManualEntryReasonsAddLink= By.linkText("Add");
    
    By coveragemanualentryReasonsCodeInput = By.xpath("//input[@id='code']");
    
    By CoverageManualEntryReasonsDescriptionInput= By.xpath("//input[@id='name']");
    
    By CoverageManualEntryReasonsRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By CoverageManualEntryReasonsValidateLink =By.linkText("Validate");
   
    By CoverageManualEntryReasonsValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By CoverageManualEntryReasonsSaveLink =  By.linkText("Save");
    
    By CoverageManualEntryReasonsEditLink = By.linkText("Edit");
    
    By CoverageManualEntryReasonsCopyLink = By.linkText("Copy");
    
    By CoverageManualEntryReasonsDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By CoverageManualEntryReasonsCommLink= By.linkText("Commun.");
    
    By CoverageManualEntryReasonsExitLink=  By.linkText("Exit");
    
    
    
    
    public CoverageManualEntryReasons(WebDriver driver){
                    this.driver= driver;
                    this.wait = new WebDriverWait(driver, 30);
    }
    
   

    //add function
    public void addCoverageManualEntryReasons( String coveragemanualentryReasonsCode, String coveragemanualentryReasonsDescription)throws Exception{
    
                    try{ 
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageManualEntryReasonsAddLink));
                    driver.findElement(CoverageManualEntryReasonsAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("coverage manual entry reasons code: "+coveragemanualentryReasonsCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(coveragemanualentryReasonsCodeInput));
                    driver.findElement(coveragemanualentryReasonsCodeInput).sendKeys(coveragemanualentryReasonsCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("coverage manual entry reasonss Record Mark"+coveragemanualentryReasonsDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageManualEntryReasonsDescriptionInput));
                    driver.findElement(CoverageManualEntryReasonsDescriptionInput).sendKeys(coveragemanualentryReasonsDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered Record Mark");
                    Log.info("log4j msg- Entered Record Mark");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageManualEntryReasonsValidateLink));
                    driver.findElement(CoverageManualEntryReasonsValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageManualEntryReasonsValidateSaveOKButton));
                    driver.findElement(CoverageManualEntryReasonsValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
                    
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageManualEntryReasonsSaveLink));
                    driver.findElement(CoverageManualEntryReasonsSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit();
                    
                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Coverage Manual Entry Reasons ");
                    Log.info("log4j msg- Error in Adding Coverage Manual Entry Reasons "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                    driver.quit(); }
                    
    }
    
    //copy function
    
    public void copyCoverageManualEntryReasons( String coveragemanualentryReasonsCode, String newcoveragemanualentryReasonsCode, String newCoverageManualEntryReasonsDescription)throws Exception{
                    
                    try{ 
                    
                    System.out.println("coverage manual entry reasonss code"+coveragemanualentryReasonsCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+coveragemanualentryReasonsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+coveragemanualentryReasonsCode+"']")).click();
                    System.out.println("clicked coverage manual entry reasons Code");
                    Log.info("log4j msg- clicked coverage manual entry reasons code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageManualEntryReasonsCopyLink));
                    driver.findElement(CoverageManualEntryReasonsCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("coverage manual entry reasonss newcode"+newcoveragemanualentryReasonsCode);
                    
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(coveragemanualentryReasonsCodeInput));
                    driver.findElement(coveragemanualentryReasonsCodeInput).clear();
                    driver.findElement(coveragemanualentryReasonsCodeInput).sendKeys(newcoveragemanualentryReasonsCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("carrier covergae types new Record Mark"+newCoverageManualEntryReasonsDescription);
    //enter new Record Mark
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageManualEntryReasonsDescriptionInput));
                    driver.findElement(CoverageManualEntryReasonsDescriptionInput).clear();
                    driver.findElement(CoverageManualEntryReasonsDescriptionInput).sendKeys(newCoverageManualEntryReasonsDescription);
                    System.out.println("Entered new Record Mark");
                    Log.info("log4j msg- Entered new Record Mark");
                    
                    
                    
                    
                    Thread.sleep(1000);
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageManualEntryReasonsSaveLink));
                    driver.findElement(CoverageManualEntryReasonsSaveLink).click();
                    
                    Thread.sleep(1000);

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
                    
                    Thread.sleep(1000);
                    
                    
                    
                    
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Coverage Manual Entry Reasons ");
                    Log.info("log4j msg- Error in Copying Coverage Manual Entry Reasons "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
driver.quit(); }
    
    
    }
    
    
    
    //edit function
public void editCoverageManualEntryReasons( String coveragemanualentryReasonsCode,String recordMark)throws Exception{
                    
                    try{ 
                    
                    System.out.println("coverage manual entry reasons code: "+coveragemanualentryReasonsCode);
                    Log.info("log4j msg- coverage manual entry reasons code: "+coveragemanualentryReasonsCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+coveragemanualentryReasonsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+coveragemanualentryReasonsCode+"']")).click();
                    System.out.println("clicked Coverage Manual Entry Reasons ");
                    Log.info("log4j msg- clicked Coverage Manual Entry Reasons ");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageManualEntryReasonsEditLink));
                    driver.findElement(CoverageManualEntryReasonsEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("coverage manual entry reasons Record Mark: "+recordMark);
                    Log.info("log4j msg- coverage manual entry reasons Record Mark: "+recordMark);
                    		          
    //enter new Record Mark
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageManualEntryReasonsRecordMark));
                    driver.findElement(CoverageManualEntryReasonsRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(CoverageManualEntryReasonsRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new Record Mark");
                    Log.info("log4j msg- Entered new Record Mark");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageManualEntryReasonsSaveLink));
                    driver.findElement(CoverageManualEntryReasonsSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Coverage Manual Entry Reasons ");
                    Log.info("log4j msg- Error in Editing Coverage Manual Entry Reasons "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); }
    
    
    }
    //exit function
    public void exitCoverageManualEntryReasons( String coveragemanualentryReasonsCode) throws Exception{
    try{
                    System.out.println("coverage manual entry reasons code"+coveragemanualentryReasonsCode);
                    Log.info("log4j msg- coverage manual entry reasons code"+coveragemanualentryReasonsCode);
                                    Thread.sleep(1000);
                                    driver.findElement(CoverageManualEntryReasonsExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Coverage Manual Entry Reasons ");
                                    Log.info("log4j msg- clicked exit in  Coverage Manual Entry Reasons "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
                                   
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Coverage Manual Entry Reasons ");
    Log.info("log4j msg- Error in Exiting Coverage Manual Entry Reasons "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); }
    }
    
    
    //add comm function
    public void addCommCoverageManualEntryReasons( String coveragemanualentryReasonsCode, String subject, String NoteType, String medium, String notes) throws Exception{
                    
                    try{         
                    System.out.println("coverage manual entry reasons code"+coveragemanualentryReasonsCode);
                    Log.info("log4j msg- coverage manual entry reasons code"+coveragemanualentryReasonsCode);
                                    //find coverage manual entry reasonss
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+coveragemanualentryReasonsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+coveragemanualentryReasonsCode+"']")).click();
                    System.out.println("clicked Coverage Manual Entry Reasons Code");
                    Log.info("log4j msg- clicked Coverage Manual Entry Reasons code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageManualEntryReasonsCommLink));
                    driver.findElement(CoverageManualEntryReasonsCommLink).click();
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
                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
                                
                                                    
                                    } catch (Exception e){
                                    	e.printStackTrace();
                                    	System.out.println("error in adding Comm to Coverage Manual Entry Reasons");
                                        Log.info("log4j msg - error in adding Comm to  Coverage Manual Entry Reasons");
                                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                        driver.quit();
                      
                    }
    }

    
    
    
    
    //delete function
    public void deleteCoverageManualEntryReasons( String coveragemanualentryReasonsCode) throws Exception{
                    
                    try{         
                                    
                    
                    //find Coverage Manual Entry Reasons
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+coveragemanualentryReasonsCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+coveragemanualentryReasonsCode+"']")).click();
                                                    System.out.println("clicked Coverage Manual Entry Reasons Code");
                                                    Log.info("log4j msg- clicked Coverage Manual Entry Reasons code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageManualEntryReasonsDeleteLink));
                                                    driver.findElement(CoverageManualEntryReasonsDeleteLink).click();
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
                                                    
                                                    
                    
    } catch (Exception e){System.out.println("error in deleting Coverage Manual Entry Reasons");
                          Log.info("log4j msg - error in deleting Coverage Manual Entry Reasons"); 
                          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                          driver.quit(); 
                    }
}

    
    
    
    
    
    
    
    
    
    
    
}

