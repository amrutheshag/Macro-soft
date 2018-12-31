package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class CommunicationCaseStatuses {

	WebDriver driver;
	WebDriverWait wait;
  
	By CommunicationCaseStatusesAddLink= By.linkText("Add");

	By CommunicationCaseStatusesCodeInput = By.xpath("//input[@id='code']");

	By CommunicationCaseStatusesDescriptionInput= By.xpath("//input[@id='name']");

	By CommunicationCaseStatusesRecordMark= By.xpath("//input[@style='width:20px;']");

	By CommunicationCaseStatusesValidateLink =By.linkText("Validate");

	By CommunicationCaseStatusesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");

	By CommunicationCaseStatusesSaveLink =  By.linkText("Save");

	By CommunicationCaseStatusesEditLink = By.linkText("Edit");

	By CommunicationCaseStatusesCopyLink = By.linkText("Copy");

	By CommunicationCaseStatusesDeleteLink= By.linkText("Delete");
	
	By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");

	By CommunicationCaseStatusesCommLink= By.linkText("Commun.");

	By CommunicationCaseStatusesExitLink=  By.linkText("Exit");




	public CommunicationCaseStatuses(WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver, 50);
}


	 //add function
    public void addCommunicationCaseStatuses( String communicationcaseTypesCode, String communicationcaseTypesDescription)throws Exception{
    
                    try{ 
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesAddLink));
                    driver.findElement(CommunicationCaseStatusesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println(" code: "+communicationcaseTypesCode);
                    Log.info("log4j msg-  code: "+communicationcaseTypesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesCodeInput));
                    driver.findElement(CommunicationCaseStatusesCodeInput).sendKeys(communicationcaseTypesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println(" description"+communicationcaseTypesDescription);
                    Log.info("log4j msg-  description"+communicationcaseTypesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesDescriptionInput));
                    driver.findElement(CommunicationCaseStatusesDescriptionInput).sendKeys(communicationcaseTypesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesValidateLink));
                    driver.findElement(CommunicationCaseStatusesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesValidateSaveOKButton));
                    driver.findElement(CommunicationCaseStatusesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
                    
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesSaveLink));
                    driver.findElement(CommunicationCaseStatusesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                    driver.quit(); 
                    
                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Communication Case Statuses ");
                    Log.info("log4j msg- Error in Adding Communication Case Statuses "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); }
                    
    }
    
    //copy function
    
    public void copyCommunicationCaseStatuses( String communicationcaseTypesCode, String newcommunicationcaseTypesCode, String newCommunicationCaseStatusesDescription)throws Exception{
                    
                    try{
                    
                    System.out.println(" code"+communicationcaseTypesCode);
                    Log.info("log4j msg-  code"+communicationcaseTypesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+communicationcaseTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+communicationcaseTypesCode+"']")).click();
                    System.out.println("clicked  Code");
                    Log.info("log4j msg- clicked  code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesCopyLink));
                    driver.findElement(CommunicationCaseStatusesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println(" new code"+newcommunicationcaseTypesCode);
                    Log.info("log4j msg-  new code"+newcommunicationcaseTypesCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesCodeInput));
                    driver.findElement(CommunicationCaseStatusesCodeInput).clear();
                    driver.findElement(CommunicationCaseStatusesCodeInput).sendKeys(newcommunicationcaseTypesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("carrier covergae types new description"+newCommunicationCaseStatusesDescription);
                    Log.info("log4j msg- carrier covergae types new description"+newCommunicationCaseStatusesDescription);
    //enter new description
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesDescriptionInput));
                    driver.findElement(CommunicationCaseStatusesDescriptionInput).clear();
                    driver.findElement(CommunicationCaseStatusesDescriptionInput).sendKeys(newCommunicationCaseStatusesDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    Thread.sleep(1000);
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesSaveLink));
                    driver.findElement(CommunicationCaseStatusesSaveLink).click();
                    
                    Thread.sleep(1000);

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); 
                   }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Communication Case Statuses ");
                    Log.info("log4j msg- Error in Copying Communication Case Statuses "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit();}
    
    
    }
    
    
    
    //edit function
public void editCommunicationCaseStatuses( String ommunicationcaseTypesCode,String CommunicationCaseStatusesDescription, String recordMark)throws Exception{
                    
                    try{
                    	
                    
                    System.out.println("code"+ommunicationcaseTypesCode);
                    Log.info("log4j msg- code"+ommunicationcaseTypesCode);
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ommunicationcaseTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ommunicationcaseTypesCode+"']")).click();
                    System.out.println("clicked Communication Case Statuses");
                    Log.info("log4j msg- clicked Communication Case Statuses");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesEditLink));
                    driver.findElement(CommunicationCaseStatusesEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println(" Record Mark: "+recordMark);
                    Log.info("log4j msg-  Record Mark: "+recordMark);
                    		          
    //enter new Record Mark
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesRecordMark));
                    driver.findElement(CommunicationCaseStatusesRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(CommunicationCaseStatusesRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new Record Mark");
                    Log.info("log4j msg- Entered new Record Mark");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesSaveLink));
                    driver.findElement(CommunicationCaseStatusesSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit();  }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Communication Case Statuses ");
                    Log.info("log4j msg- Error in Editing Communication Case Statuses "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); }
    
    
    }
    //exit function
    public void exitCommunicationCaseStatuses( String communicationcaseTypesCode) throws Exception{
    try{
                 
                    System.out.println("code"+communicationcaseTypesCode);
                    Log.info("log4j msg- code"+communicationcaseTypesCode);
                    
                                    Thread.sleep(1000);
                                    driver.findElement(CommunicationCaseStatusesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Communication Case Statuses ");
                                    Log.info("log4j msg- clicked exit in  Communication Case Statuses "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                    driver.quit(); 
                        
                                  
                                    
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Communication Case Statuses ");
    Log.info("log4j msg- Error in Exiting Communication Case Statuses "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
    driver.quit(); }
    }
    
    
    //add comm function
    public void addCommCommunicationCaseStatuses( String communicationcaseTypesCode, String subject, String NoteType, String medium, String notes) throws Exception{
                    
                    try{         
                    System.out.println("code"+communicationcaseTypesCode);
                    Log.info("log4j msg- code"+communicationcaseTypesCode);
                                    //find 
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+communicationcaseTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+communicationcaseTypesCode+"']")).click();
                    System.out.println("clicked Communication Case Statuses Code");
                    Log.info("log4j msg- clicked Communication Case Statuses code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesCommLink));
                    driver.findElement(CommunicationCaseStatusesCommLink).click();
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
                                  
                                                    
                                    } catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to Communication Case Statuses");
                                    Log.info("log4j msg - Error in adding Comm to  Communication Case Statuses"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                                    driver.quit();
                               }
    }
    //delete function
    public void deleteCommunicationCaseStatuses( String ommunicationcaseTypesCode) throws Exception{
                    
                    try{        
                                    
                    
                    //find Communication Case Statuses
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ommunicationcaseTypesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ommunicationcaseTypesCode+"']")).click();
                                                    System.out.println("clicked Communication Case Statuses Code");
                                                    Log.info("log4j msg- clicked Communication Case Statuses code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(CommunicationCaseStatusesDeleteLink));
                                                    driver.findElement(CommunicationCaseStatusesDeleteLink).click();
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
    	System.out.println("Error in deleting Communication Case Statuses");
        Log.info("log4j msg - Error in deleting Communication Case Statuses"); 
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
        driver.quit(); 
        }
}

    
    
    
    
    
    
    
    
    
    
 

}

