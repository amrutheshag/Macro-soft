package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class InsuranceCoverageExtents {

	WebDriver driver;
	WebDriverWait wait ;   
	
    By InsuranceCoverageExtentsAddLink= By.linkText("Add");
    
    By insurancecoverageExtentsCodeInput = By.xpath("//input[@id='code']");
    
    By InsuranceCoverageExtentsDescriptionInput= By.xpath("//input[@id='name']");
    
    By InsuranceCoverageExtentsRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By InsuranceCoverageExtentsValidateLink =By.linkText("Validate");
 
    By InsuranceCoverageExtentsValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By InsuranceCoverageExtentsSaveLink =  By.linkText("Save");
    
    By InsuranceCoverageExtentsEditLink = By.linkText("Edit");
    
    By InsuranceCoverageExtentsCopyLink = By.linkText("Copy");
    
    By InsuranceCoverageExtentsDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By InsuranceCoverageExtentsCommLink= By.linkText("Commun.");
 
    By InsuranceCoverageExtentsExitLink=  By.linkText("Exit");
    
    
    
    
    public InsuranceCoverageExtents(WebDriver driver){
                    this.driver= driver;
                    this.wait= new WebDriverWait(driver, 35); 
    }
    
   

    //add function
    public void addInsuranceCoverageExtents( String insurancecoverageExtentsCode, String insurancecoverageExtentsDescription)throws Exception{
    
                    try{ 
                    	 wait.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCoverageExtentsAddLink));
                    driver.findElement(InsuranceCoverageExtentsAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("Insurage coverage extent code: "+insurancecoverageExtentsCode);
                    Log.info("log4j msg- Insurance coverage extent code: "+insurancecoverageExtentsCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(insurancecoverageExtentsCodeInput));
                    driver.findElement(insurancecoverageExtentsCodeInput).sendKeys(insurancecoverageExtentsCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("Description"+insurancecoverageExtentsDescription);
                    Log.info("log4j msg- Description"+insurancecoverageExtentsDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCoverageExtentsDescriptionInput));
                    driver.findElement(InsuranceCoverageExtentsDescriptionInput).sendKeys(insurancecoverageExtentsDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCoverageExtentsValidateLink));
                    driver.findElement(InsuranceCoverageExtentsValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCoverageExtentsValidateSaveOKButton));
                    driver.findElement(InsuranceCoverageExtentsValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
                    
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCoverageExtentsSaveLink));
                    driver.findElement(InsuranceCoverageExtentsSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Insurance Coverage Extents ");
                    Log.info("log4j msg- Error in Adding Insurance Coverage Extents "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
                    
    }
    
    //copy function
    
    public void copyInsuranceCoverageExtents( String insurancecoverageExtentsCode, String newinsurancecoverageExtentsCode, String newInsuranceCoverageExtentsDescription)throws Exception{
                    
                    try{ 
                     System.out.println(" code"+insurancecoverageExtentsCode);
                    Log.info("log4j msg-  code"+insurancecoverageExtentsCode);
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+insurancecoverageExtentsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+insurancecoverageExtentsCode+"']")).click();
                    System.out.println("clicked  Code");
                    Log.info("log4j msg- clicked  code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCoverageExtentsCopyLink));
                    driver.findElement(InsuranceCoverageExtentsCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println(" new code"+newinsurancecoverageExtentsCode);
                    Log.info("log4j msg- new code"+newinsurancecoverageExtentsCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(insurancecoverageExtentsCodeInput));
                    driver.findElement(insurancecoverageExtentsCodeInput).clear();
                    driver.findElement(insurancecoverageExtentsCodeInput).sendKeys(newinsurancecoverageExtentsCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("new description"+newInsuranceCoverageExtentsDescription);
                    Log.info("log4j msg- new description"+newInsuranceCoverageExtentsDescription);
    //enter new Record Mark
                    Thread.sleep(1000);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCoverageExtentsDescriptionInput));
                    driver.findElement(InsuranceCoverageExtentsDescriptionInput).clear();
                    driver.findElement(InsuranceCoverageExtentsDescriptionInput).sendKeys(newInsuranceCoverageExtentsDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    Thread.sleep(1000);
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCoverageExtentsSaveLink));
                    driver.findElement(InsuranceCoverageExtentsSaveLink).click();
                    
                    Thread.sleep(1000);

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    Thread.sleep(1000);
                    
                    
                    
                    
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Insurance Coverage Extents ");
                    Log.info("log4j msg- Error in Copying Insurance Coverage Extents "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
    
    }
    
    
    
    //edit function
public void editInsuranceCoverageExtents( String insurancecoverageExtentsCode,String insurancecoverageExtentsDescription, String recordMark)throws Exception{
                    
                    try{
                     System.out.println(" code"+insurancecoverageExtentsCode);
                    Log.info("log4j msg-  code"+insurancecoverageExtentsCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+insurancecoverageExtentsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+insurancecoverageExtentsCode+"']")).click();
                    System.out.println("clicked Insurance Coverage Extents ");
                    Log.info("log4j msg- clicked Insurance Coverage Extents ");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCoverageExtentsEditLink));
                    driver.findElement(InsuranceCoverageExtentsEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("Record Mark"+recordMark);
                    Log.info("log4j msg-Record Mark"+recordMark);
                    		          
    //enter new Record Mark
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCoverageExtentsRecordMark));
                    driver.findElement(InsuranceCoverageExtentsRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(InsuranceCoverageExtentsRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new Record Mark");
                    Log.info("log4j msg- Entered new Record Mark");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCoverageExtentsSaveLink));
                    driver.findElement(InsuranceCoverageExtentsSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Insurance Coverage Extents ");
                    Log.info("log4j msg- Error in Editing Insurance Coverage Extents "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
    
    }
    //exit function
    public void exitInsuranceCoverageExtents( String insurancecoverageExtentsCode) throws Exception{
    try{
                    System.out.println(" code"+insurancecoverageExtentsCode);
                    Log.info("log4j msg-  code"+insurancecoverageExtentsCode);
                                    Thread.sleep(1000);
                                    driver.findElement(InsuranceCoverageExtentsExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Insurance Coverage Extents ");
                                    Log.info("log4j msg- clicked exit in  Insurance Coverage Extents "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                  
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Insurance Coverage Extents ");
    Log.info("log4j msg- Error in Exiting Insurance Coverage Extents "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    }
    
    
    //add comm function
    public void addCommInsuranceCoverageExtents( String insurancecoverageExtentsCode, String subject, String NoteType, String medium, String notes) throws Exception{
                    
                    try{        
                    System.out.println(" code"+insurancecoverageExtentsCode);
                    Log.info("log4j msg-  code"+insurancecoverageExtentsCode);
                                    //find
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+insurancecoverageExtentsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+insurancecoverageExtentsCode+"']")).click();
                    System.out.println("clicked Insurance Coverage Extents Code");
                    Log.info("log4j msg- clicked Insurance Coverage Extents code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCoverageExtentsCommLink));
                    driver.findElement(InsuranceCoverageExtentsCommLink).click();
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
                                                    Select noteType = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                                   noteType.selectByVisibleText(NoteType);
                                                   
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
                                                    
                                    } catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to Insurance Coverage Extents");
                                                                                                                    Log.info("log4j msg - Error in adding Comm to  Insurance Coverage Extents"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit();      
                    }
    }

    
    
    
    
    //delete function
    public void deleteInsuranceCoverageExtents( String insurancecoverageExtentsCode) throws Exception{
                    
                    try{         
                    //find Insurance Coverage Extents
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+insurancecoverageExtentsCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+insurancecoverageExtentsCode+"']")).click();
                                                    System.out.println("clicked Insurance Coverage Extents Code");
                                                    Log.info("log4j msg- clicked Insurance Coverage Extents code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(InsuranceCoverageExtentsDeleteLink));
                                                    driver.findElement(InsuranceCoverageExtentsDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                    driver.findElement(confirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                    Thread.sleep(1000);
                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                                    
                                                    
                    
    } catch (Exception e){System.out.println("Error in deleting Insurance Coverage Extents");
                         Log.info("log4j msg - Error in deleting Insurance Coverage Extents");
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                         driver.quit();
                    }
}

    
    
    
    
    
    
    
    
    
    
}

