package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class JournalContactMedias {

	WebDriver driver;
	WebDriverWait wait ;    
    
    By JournalContactMediasAddLink= By.linkText("Add");
  
    By journalcontactMediasCodeInput = By.xpath("//input[@id='code']");
    
    By JournalContactMediasDescriptionInput= By.xpath("//input[@id='name']");
    
    By JournalContactMediasRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By JournalContactMediasValidateLink =By.linkText("Validate");
    
    By JournalContactMediasValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By JournalContactMediasSaveLink =  By.linkText("Save");
    
    By JournalContactMediasEditLink = By.linkText("Edit");
    
    By JournalContactMediasCopyLink = By.linkText("Copy");
    
    By JournalContactMediasDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By JournalContactMediasCommLink= By.linkText("Commun.");
      
    By JournalContactMediasExitLink=  By.linkText("Exit");
    
    
    
    
    public JournalContactMedias(WebDriver driver){
                    this.driver= driver;
                    this.wait= new WebDriverWait(driver, 35);
    }
    
   
    //add function
    public void addJournalContactMedias( String journalcontactMediasCode, String journalcontactMediasDescription)throws Exception{
    
                    try{ 
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalContactMediasAddLink));
                    driver.findElement(JournalContactMediasAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("journal contact medias code: "+journalcontactMediasCode);
                    Log.info("log4j msg- journal contact medias code: "+journalcontactMediasCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(journalcontactMediasCodeInput));
                    driver.findElement(journalcontactMediasCodeInput).sendKeys(journalcontactMediasCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("journal contact medias description"+journalcontactMediasDescription);
                    Log.info("log4j msg- journal contact medias description"+journalcontactMediasDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalContactMediasDescriptionInput));
                    driver.findElement(JournalContactMediasDescriptionInput).sendKeys(journalcontactMediasDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalContactMediasValidateLink));
                    driver.findElement(JournalContactMediasValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalContactMediasValidateSaveOKButton));
                    driver.findElement(JournalContactMediasValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
                    
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalContactMediasSaveLink));
                    driver.findElement(JournalContactMediasSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Journal Contact Medias ");
                    Log.info("log4j msg- Error in Adding Journal Contact Medias "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
                    
    }
    
    //copy function
    
    public void copyJournalContactMedias( String journalcontactMediasCode, String newjournalcontactMediasCode, String newJournalContactMediasDescription)throws Exception{
                    
                    try{
                    
                    System.out.println("journal contact medias code"+journalcontactMediasCode);
                    Log.info("log4j msg- journal contact medias code"+journalcontactMediasCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalcontactMediasCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalcontactMediasCode+"']")).click();
                    System.out.println("clicked journal contact medias Code");
                    Log.info("log4j msg- clicked journal contact medias code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalContactMediasCopyLink));
                    driver.findElement(JournalContactMediasCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("journal contact medias new code"+newjournalcontactMediasCode);
                    Log.info("log4j msg- journal contact medias new code"+newjournalcontactMediasCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(journalcontactMediasCodeInput));
                    driver.findElement(journalcontactMediasCodeInput).clear();
                    driver.findElement(journalcontactMediasCodeInput).sendKeys(newjournalcontactMediasCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("journal contact medias new description"+newJournalContactMediasDescription);
                    Log.info("log4j msg- journal contact medias new description"+newJournalContactMediasDescription);
    //enter new description
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalContactMediasDescriptionInput));
                    driver.findElement(JournalContactMediasDescriptionInput).clear();
                    driver.findElement(JournalContactMediasDescriptionInput).sendKeys(newJournalContactMediasDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    Thread.sleep(1000);
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalContactMediasSaveLink));
                    driver.findElement(JournalContactMediasSaveLink).click();
                    
                    Thread.sleep(1000);

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
           
                    
                    
                    
                    
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Journal Contact Medias ");
                    Log.info("log4j msg- Error in Copying Journal Contact Medias "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
    
    }
    
    
    
    //edit function
public void editJournalContactMedias( String journalcontactMediasCode,String JournalContactMediasDescription, String recordMark)throws Exception{
                    
                    try{ 
                    System.out.println("journal contact medias code"+journalcontactMediasCode);
                    Log.info("log4j msg- journal contact medias code"+journalcontactMediasCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalcontactMediasCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalcontactMediasCode+"']")).click();
                    System.out.println("clicked Journal Contact Medias");
                    Log.info("log4j msg- clicked Journal Contact Medias");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalContactMediasEditLink));
                    driver.findElement(JournalContactMediasEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("journal contact medias Record Mark"+recordMark);
                    Log.info("log4j msg- journal contact medias Record Mark"+recordMark);
                    		          
    //enter new Record Mark
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalContactMediasRecordMark));
                  driver.findElement(JournalContactMediasRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(JournalContactMediasRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new Record Mark");
                    Log.info("log4j msg- Entered new Record Mark");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalContactMediasSaveLink));
                    driver.findElement(JournalContactMediasSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Journal Contact Medias ");
                    Log.info("log4j msg- Error in Editing Journal Contact Medias "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
    
    }
    //exit function
    public void exitJournalContactMedias( String journalcontactMediasCode) throws Exception{
    try{
                   System.out.println("journal contact medias code"+journalcontactMediasCode);
                    Log.info("log4j msg- journal contact medias code"+journalcontactMediasCode);
                                    Thread.sleep(1000);
                                    driver.findElement(JournalContactMediasExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Journal Contact Medias ");
                                    Log.info("log4j msg- clicked exit in  Journal Contact Medias "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                   
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Journal Contact Medias ");
    Log.info("log4j msg- Error in Exiting Journal Contact Medias "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    }
    
    
    //add comm function
    public void addCommJournalContactMedias( String journalcontactMediasCode, String subject, String NoteType, String medium, String notes) throws Exception{
                    
                    try{       
                     System.out.println("journal contact medias code"+journalcontactMediasCode);
                    Log.info("log4j msg- journal contact medias code"+journalcontactMediasCode);
                                    //find journal contact medias
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalcontactMediasCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalcontactMediasCode+"']")).click();
                    System.out.println("clicked Journal Contact Medias Code");
                    Log.info("log4j msg- clicked Journal Contact Medias code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalContactMediasCommLink));
                    driver.findElement(JournalContactMediasCommLink).click();
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
                                                    
                                    } catch (Exception e){e.printStackTrace();
                                    System.out.println("Error in adding Comm to Journal Contact Medias");
                                    Log.info("log4j msg - Error in adding Comm to  Journal Contact Medias"); 
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit();      
                    }
    }

    
    
    
    
    //delete function
    public void deleteJournalContactMedias( String journalcontactMediasCode) throws Exception{
                    
                    try{       
                    //find Journal Contact Medias
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalcontactMediasCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalcontactMediasCode+"']")).click();
                                                    System.out.println("clicked Journal Contact Medias Code");
                                                    Log.info("log4j msg- clicked Journal Contact Medias code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalContactMediasDeleteLink));
                                                    driver.findElement(JournalContactMediasDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                    driver.findElement(confirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                    Thread.sleep(1000);
                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                                    
                                                    
                    
    } catch (Exception e){System.out.println("Error in deleting Journal Contact Medias");
                          Log.info("log4j msg - Error in deleting Journal Contact Medias"); 
                          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                          driver.quit();
                    }
}

    
    
    
    
    
    
    
    
    
    
   

}

