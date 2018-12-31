package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class CarrierRelationshipTypes {
	
	WebDriver driver;
	WebDriverWait wait;
 
    By CarrierRelationshipTypesAddLink= By.linkText("Add");
    
    By carrierrelationshipTypeCodeInput = By.xpath("//input[@id='code']");
    
    By CarrierRelationshipTypesDescriptionInput= By.xpath("//input[@id='name']");
    
    By CarrierRelationshipTypesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By CarrierRelationshipTypesValidateLink =By.linkText("Validate");
    
    By CarrierRelationshipTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By CarrierRelationshipTypesSaveLink =  By.linkText("Save");
    
    By CarrierRelationshipTypesEditLink = By.linkText("Edit");
    
    By CarrierRelationshipTypesCopyLink = By.linkText("Copy");
    
    By CarrierRelationshipTypesDeleteLink= By.linkText("Delete");
  
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By CarrierRelationshipTypesCommLink= By.linkText("Commun.");
    
    By CarrierRelationshipTypesExitLink=  By.linkText("Exit");
    
    
    
    
    public CarrierRelationshipTypes(WebDriver driver){
                    this.driver= driver;
                    this.wait = new WebDriverWait(driver, 35);
    }
    
   

    //add function
    public void addCarrierRelationshipTypes( String carrierrelationshipTypeCode, String carrierrelationshipTypesDescription)throws Exception{
    
                    try{ 
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypesAddLink));
                    driver.findElement(CarrierRelationshipTypesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("carrier relationship type code: "+carrierrelationshipTypeCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(carrierrelationshipTypeCodeInput));
                    driver.findElement(carrierrelationshipTypeCodeInput).sendKeys(carrierrelationshipTypeCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("carrier relationship types description"+carrierrelationshipTypesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypesDescriptionInput));
                    driver.findElement(CarrierRelationshipTypesDescriptionInput).sendKeys(carrierrelationshipTypesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypesValidateLink));
                    driver.findElement(CarrierRelationshipTypesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypesValidateSaveOKButton));
                    driver.findElement(CarrierRelationshipTypesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
                    
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypesSaveLink));
                    driver.findElement(CarrierRelationshipTypesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); 
                    
                    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Carrier Relationship Types ");
                    Log.info("log4j msg- Error in Adding Carrier Relationship Types "); 
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit();}
                    
    }
    
    //copy function
    
    public void copyCarrierRelationshipTypes( String carrierrelationshipTypeCode, String newcarrierrelationshipTypeCode, String newCarrierRelationshipTypesDescription)throws Exception{
                    
                    try{ 
                    
                    System.out.println("carrier relationship types code"+carrierrelationshipTypeCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+carrierrelationshipTypeCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+carrierrelationshipTypeCode+"']")).click();
                    System.out.println("clicked carrier relationship type Code");
                    Log.info("log4j msg- clicked carrier relationship type code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypesCopyLink));
                    driver.findElement(CarrierRelationshipTypesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("carrier relationship types newcode"+newcarrierrelationshipTypeCode);
                    
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(carrierrelationshipTypeCodeInput));
                    driver.findElement(carrierrelationshipTypeCodeInput).clear();
                    driver.findElement(carrierrelationshipTypeCodeInput).sendKeys(newcarrierrelationshipTypeCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("carrier relationship types new description"+newCarrierRelationshipTypesDescription);
    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypesDescriptionInput));
                    driver.findElement(CarrierRelationshipTypesDescriptionInput).clear();
                    driver.findElement(CarrierRelationshipTypesDescriptionInput).sendKeys(newCarrierRelationshipTypesDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypesSaveLink));
                    driver.findElement(CarrierRelationshipTypesSaveLink).click();

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
                    
                    
                    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Carrier Relationship Types ");
                    Log.info("log4j msg- Error in Copying Carrier Relationship Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();}
    
    
    }
    
    
    
    //edit function
    public void editCarrierRelationshipTypes( String CarrierRelationshipTypesCode,String CarrierRelationshipTypesDescription, String recordMark)throws Exception{
        
        try{ 
        
        System.out.println("coverage manual entry reasons code"+CarrierRelationshipTypesCode);
        //<div class="form-control text-box-10-chactr ng-pristine ng-untouched ng-valid ng-isolate-scope ng-not-empty ng-valid-maxlength" title="ACSC-MCD">ACSC-MCD</div>
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CarrierRelationshipTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+CarrierRelationshipTypesCode+"']")).click();
        System.out.println("clicked Carrier Relationship Types Record Mark");
        Log.info("log4j msg- clicked Carrier Relationship Types Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypesEditLink));
        driver.findElement(CarrierRelationshipTypesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("coverage manual entry reasonss Record Mark: "+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypesRecordMark));
        System.out.println("current description: "+driver.findElement(CarrierRelationshipTypesRecordMark).getText());
        driver.findElement(CarrierRelationshipTypesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(CarrierRelationshipTypesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypesSaveLink));
        driver.findElement(CarrierRelationshipTypesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
         }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Carrier Relationship Types ");
        Log.info("log4j msg- Error in Editing Carrier Relationship Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
}
    //exit function
    public void exitCarrierRelationshipTypes( String carrierrelationshipTypeCode) throws Exception{
    try{
                    System.out.println("carrier relationship type code"+carrierrelationshipTypeCode);
                                    Thread.sleep(1000);
                                    driver.findElement(CarrierRelationshipTypesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Carrier Relationship Types ");
                                    Log.info("log4j msg- clicked exit in  Carrier Relationship Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                     
    }catch (Exception e){
    	e.printStackTrace();
    	System.out.println("Error in Adding Carrier Relationship Types ");
    Log.info("log4j msg- Error in Carrier Relationship Types ");
    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
    driver.quit();}
    }
    
    
    //add comm function
    public void addCommCarrierRelationshipTypes( String carrierrelationshipTypeCode, String subject, String NoteType, String medium, String notes) throws Exception{
                    
                    try{        
                    
                    System.out.println("carrier relationship type code"+carrierrelationshipTypeCode);
                                    //find carrier Relationship types
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+carrierrelationshipTypeCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+carrierrelationshipTypeCode+"']")).click();
                    System.out.println("clicked Carrier Relationship Type Code");
                    Log.info("log4j msg- clicked Carrier Relationship Type code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypesCommLink));
                    driver.findElement(CarrierRelationshipTypesCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                                                    
                                                    
                                                    //click add
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]")));
                                                    driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]")).click();
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
                                                    
                                                   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlNoteType' and @class='selectpicker ng-pristine ng-valid ng-empty ng-touched']")));
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlNoteType' ]")));
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
                                    	System.out.println("error in adding Comm to Carrier Relationship Types");
                                        Log.info("log4j msg - error in adding Comm to  Carrier Relationship Types"); 
                                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                        driver.quit();
                    }
    }

    
    
    
    
    //delete function
    public void deleteCarrierRelationshipTypes( String carrierrelationshipTypeCode) throws Exception{
                    
                    try{        
                                    
                    
                    //find Carrier Relationship Types
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+carrierrelationshipTypeCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+carrierrelationshipTypeCode+"']")).click();
                                                    System.out.println("clicked Carrier Relationship Types Code");
                                                    Log.info("log4j msg- clicked Carrier Relationship Types code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(CarrierRelationshipTypesDeleteLink));
                                                    driver.findElement(CarrierRelationshipTypesDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                    driver.findElement(confirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                                    driver.quit(); 
    } catch (Exception e){System.out.println("error in deleting Carrier Relationship Type");
     Log.info("log4j msg - error in deleting Carrier Relationship Type"); 
     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
     driver.quit(); 
    }
}

}
