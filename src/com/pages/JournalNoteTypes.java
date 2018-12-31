package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class JournalNoteTypes {

	WebDriver driver;
	WebDriverWait wait;
	
    By JournalNoteTypesAddLink= By.linkText("Add");
    
    By journalnoteTypesCodeInput = By.xpath("//input[@id='code']");
    
    By JournalNoteTypesDescriptionInput= By.xpath("//input[@id='name']");
    
    By JournalNoteTypesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By JournalNoteTypesValidateLink =By.linkText("Validate");
     
    By JournalNoteTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By JournalNoteTypesSaveLink =  By.linkText("Save");
    
    By JournalNoteTypesEditLink = By.linkText("Edit");
    
    By JournalNoteTypesCopyLink = By.linkText("Copy");
    
    By JournalNoteTypesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By JournalNoteTypesCommLink= By.linkText("Commun.");
   
    By JournalNoteTypesExitLink=  By.linkText("Exit");
    
    
    
    
    public JournalNoteTypes(WebDriver driver){
                    this.driver= driver;
                    this.wait = new WebDriverWait(driver, 50);    
    }
    
   
    //add function
    public void addJournalNoteTypes( String journalnoteTypesCode, String journalnoteTypesDescription)throws Exception{
    
                    try{ 
                    	  wait.until(ExpectedConditions.visibilityOfElementLocated(JournalNoteTypesAddLink));
                    driver.findElement(JournalNoteTypesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("journal note types code: "+journalnoteTypesCode);
                    Log.info("log4j msg- journal note types code: "+journalnoteTypesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(journalnoteTypesCodeInput));
                    driver.findElement(journalnoteTypesCodeInput).sendKeys(journalnoteTypesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("journal note types description"+journalnoteTypesDescription);
                    Log.info("log4j msg- journal note types description"+journalnoteTypesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalNoteTypesDescriptionInput));
                    driver.findElement(JournalNoteTypesDescriptionInput).sendKeys(journalnoteTypesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalNoteTypesValidateLink));
                    driver.findElement(JournalNoteTypesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalNoteTypesValidateSaveOKButton));
                    driver.findElement(JournalNoteTypesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
                    
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalNoteTypesSaveLink));
                    driver.findElement(JournalNoteTypesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Journal Note Types ");
                    Log.info("log4j msg- Error in Adding Journal Note Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
                    
    }
    
    //copy function
    
    public void copyJournalNoteTypes( String journalnoteTypesCode, String newjournalnoteTypesCode, String newJournalNoteTypesDescription)throws Exception{
                    
                    try{ 
                    System.out.println("journal note types code"+journalnoteTypesCode);
                    Log.info("log4j msg- journal note types code"+journalnoteTypesCode);
                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalnoteTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalnoteTypesCode+"']")).click();
                    System.out.println("clicked journal note types Code");
                    Log.info("log4j msg- clicked journal note types code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalNoteTypesCopyLink));
                    driver.findElement(JournalNoteTypesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("journal note types new code"+newjournalnoteTypesCode);
                    Log.info("log4j msg- journal note types new code"+newjournalnoteTypesCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(journalnoteTypesCodeInput));
                    driver.findElement(journalnoteTypesCodeInput).clear();
                    driver.findElement(journalnoteTypesCodeInput).sendKeys(newjournalnoteTypesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("journal note types new description"+newJournalNoteTypesDescription);
                    Log.info("log4j msg- journal note types new description"+newJournalNoteTypesDescription);
    //enter new description
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalNoteTypesDescriptionInput));
                    driver.findElement(JournalNoteTypesDescriptionInput).clear();
                    driver.findElement(JournalNoteTypesDescriptionInput).sendKeys(newJournalNoteTypesDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    Thread.sleep(1000);
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalNoteTypesSaveLink));
                    driver.findElement(JournalNoteTypesSaveLink).click();
                    
                    Thread.sleep(1000);

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    Thread.sleep(1000);
                    
                    
                    
                    
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Journal Note Types ");
                    Log.info("log4j msg- Error in Copying Journal Note Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
    
    }
    
    
    
    //edit function
public void editJournalNoteTypes( String journalnoteTypesCode,String JournalNoteTypesDescription, String recordMark)throws Exception{
                    
                    try{  System.out.println("journal note types code"+journalnoteTypesCode);
                    Log.info("log4j msg- journal note types code"+journalnoteTypesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalnoteTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalnoteTypesCode+"']")).click();
                    System.out.println("clicked Journal Note Types");
                    Log.info("log4j msg- clicked Journal Note Types");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalNoteTypesEditLink));
                    driver.findElement(JournalNoteTypesEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("journal note types Record Mark"+recordMark);
                    Log.info("log4j msg- journal note types Record Mark"+recordMark);
                    		          
    //enter new Record Mark
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalNoteTypesRecordMark));
                   driver.findElement(JournalNoteTypesRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(JournalNoteTypesRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new Record Mark");
                    Log.info("log4j msg- Entered new Record Mark");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalNoteTypesSaveLink));
                    driver.findElement(JournalNoteTypesSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Journal Note Types ");
                    Log.info("log4j msg- Error in Editing Journal Note Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
    
    }
    //exit function
    public void exitJournalNoteTypes( String journalnoteTypesCode) throws Exception{
    try{
                    System.out.println("journal note types code"+journalnoteTypesCode);
                    Log.info("log4j msg- journal note types code"+journalnoteTypesCode);
                                    Thread.sleep(1000);
                                    driver.findElement(JournalNoteTypesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Journal Note Types ");
                                    Log.info("log4j msg- clicked exit in  Journal Note Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                   
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Journal Note Types ");
    Log.info("log4j msg- Error in Exiting Journal Note Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    }
    
    
    //add comm function
    public void addCommJournalNoteTypes( String journalnoteTypesCode, String subject, String NoteType, String medium, String notes) throws Exception{
                    
                    try{         System.out.println("journal note types code"+journalnoteTypesCode);
                    Log.info("log4j msg- journal note types code"+journalnoteTypesCode);
                                    //find journal note types
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalnoteTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalnoteTypesCode+"']")).click();
                    System.out.println("clicked Journal Note Types Code");
                    Log.info("log4j msg- clicked Journal Note Types code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalNoteTypesCommLink));
                    driver.findElement(JournalNoteTypesCommLink).click();
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
                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                    driver.quit();
                                                    
                                    } catch (Exception e){
                                    	e.printStackTrace();
                                    System.out.println("Error in adding Comm to Journal Note Types");
                                    Log.info("log4j msg - Error in adding Comm to  Journal Note Types"); 
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit();      
                    }
    }

    
    
    
    
    //delete function
    public void deleteJournalNoteTypes( String journalnoteTypesCode) throws Exception{
                    
                    try{        
                    //find Journal Note Types
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalnoteTypesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+journalnoteTypesCode+"']")).click();
                                                    System.out.println("clicked Journal Note Types Code");
                                                    Log.info("log4j msg- clicked Journal Note Types code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(JournalNoteTypesDeleteLink));
                                                    driver.findElement(JournalNoteTypesDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                    driver.findElement(confirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                                                    driver.quit();
                                                    
                                                    
                    
    } catch (Exception e){System.out.println("Error in deleting Journal Note Types");
                         Log.info("log4j msg - Error in deleting Journal Note Types"); 
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                         driver.quit();
                    }
}

    
    
    
    
    
    
    
    
    
  

}

