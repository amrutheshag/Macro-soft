package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class BenefitPremiumPaymentModes {

WebDriver driver;
WebDriverWait wait;
   
By BenefitPremiumPaymentModesAddLink= By.xpath("//span[text()='Add']");

By benefitpremiumpaymentModesCodeInput = By.xpath("//input[@id='code']");

By BenefitPremiumPaymentModesDescriptionInput= By.xpath("//input[@id='name']");

By BenefitPremiumPaymentModesRecordMark= By.xpath("//input[@style='width:20px;']");

By BenefitPremiumPaymentModesValidateLink =By.linkText("Validate");

By BenefitPremiumPaymentModesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");

By BenefitPremiumPaymentModesSaveLink =  By.linkText("Save");

By BenefitPremiumPaymentModesEditLink = By.linkText("Edit");

By BenefitPremiumPaymentModesCopyLink = By.linkText("Copy");

By BenefitPremiumPaymentModesDeleteLink= By.linkText("Delete");

By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");

By BenefitPremiumPaymentModesCommLink= By.linkText("Commun.");

By BenefitPremiumPaymentModesExitLink=  By.linkText("Exit");

public BenefitPremiumPaymentModes(WebDriver driver){
    this.driver= driver;
    this.wait=  new WebDriverWait(driver, 25);
}



//add function
public void addBenefitPremiumPaymentModes( String benefitpremiumpaymentModesCode, String benefitpremiumpaymentModesDescription)throws Exception{

    try{ 
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPremiumPaymentModesAddLink));
    driver.findElement(BenefitPremiumPaymentModesAddLink).click();
    System.out.println("clicked Add");
    Log.info("log4j msg- clicked Add");
    
    
    System.out.println(" code: "+benefitpremiumpaymentModesCode);
    Log.info("log4j msg-  code: "+benefitpremiumpaymentModesCode);
    //enter code
    wait.until(ExpectedConditions.visibilityOfElementLocated(benefitpremiumpaymentModesCodeInput));
    driver.findElement(benefitpremiumpaymentModesCodeInput).sendKeys(benefitpremiumpaymentModesCode);
    Thread.sleep(1000);
    System.out.println("Entered code");
    Log.info("log4j msg- Entered code");
    
    System.out.println("description"+benefitpremiumpaymentModesDescription);
    Log.info("log4j msg- description"+benefitpremiumpaymentModesDescription);
    //enter Description
    wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPremiumPaymentModesDescriptionInput));
    driver.findElement(BenefitPremiumPaymentModesDescriptionInput).sendKeys(benefitpremiumpaymentModesDescription);
    Thread.sleep(1000);
    System.out.println("Entered description");
    Log.info("log4j msg- Entered description");

    
    //click validate

    
    wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPremiumPaymentModesValidateLink));
    driver.findElement(BenefitPremiumPaymentModesValidateLink).click();
    System.out.println("clicked validate");
    Log.info("log4j msg- clicked validate");
    
    //click ok
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPremiumPaymentModesValidateSaveOKButton));
    driver.findElement(BenefitPremiumPaymentModesValidateSaveOKButton).click();
    System.out.println("clicked validate ok to save button");
    Log.info("log4j msg- clicked validate ok to save button");
    
    
    //click save
    Thread.sleep(1000);
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPremiumPaymentModesSaveLink));
    driver.findElement(BenefitPremiumPaymentModesSaveLink).click();
    System.out.println("clicked save ");
    Log.info("log4j msg- clicked  save ");
    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
    
    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Benefit Premium Payment Modes ");
    Log.info("log4j msg- Error in Adding Benefit Premium Payment Modes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
}

//copy function

public void copyBenefitPremiumPaymentModes( String benefitpremiumpaymentModesCode, String newbenefitpremiumpaymentModesCode, String newBenefitPremiumPaymentModesDescription)throws Exception{
    
    try{ 
    
    System.out.println("code"+benefitpremiumpaymentModesCode);
    Log.info("log4j msg- code"+benefitpremiumpaymentModesCode);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitpremiumpaymentModesCode+"']")));
    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitpremiumpaymentModesCode+"']")).click();
    System.out.println("clicked  Code");
    Log.info("log4j msg- clicked code");
    
    
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPremiumPaymentModesCopyLink));
    driver.findElement(BenefitPremiumPaymentModesCopyLink).click();
    System.out.println("clicked Copy");
    Log.info("log4j msg- clicked Copy");
    
    System.out.println(" new code"+newbenefitpremiumpaymentModesCode);
    Log.info("log4j msg-  new code"+newbenefitpremiumpaymentModesCode);
    //enter new code
    wait.until(ExpectedConditions.visibilityOfElementLocated(benefitpremiumpaymentModesCodeInput));
    driver.findElement(benefitpremiumpaymentModesCodeInput).clear();
    driver.findElement(benefitpremiumpaymentModesCodeInput).sendKeys(newbenefitpremiumpaymentModesCode);
    System.out.println("Entered new code");
    Log.info("log4j msg- Entered new code");

    System.out.println(" new description"+newBenefitPremiumPaymentModesDescription);
    Log.info("log4j msg-  new description"+newBenefitPremiumPaymentModesDescription);
//enter new Record Mark
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPremiumPaymentModesDescriptionInput));
    driver.findElement(BenefitPremiumPaymentModesDescriptionInput).clear();
    driver.findElement(BenefitPremiumPaymentModesDescriptionInput).sendKeys(newBenefitPremiumPaymentModesDescription);
    System.out.println("Entered new description");
    Log.info("log4j msg- Entered new description");
    
    
    
    
    Thread.sleep(1000);
    
    //click save
    wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPremiumPaymentModesSaveLink));
    driver.findElement(BenefitPremiumPaymentModesSaveLink).click();
    
    Thread.sleep(1000);

    System.out.println("Clicked save");
    Log.info("log4j msg- clicked save");
    Thread.sleep(1000);
    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
    
    Thread.sleep(1000);
    
    
    
    
    
    
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Benefit Premium Payment Modes ");
    Log.info("log4j msg- Error in Copying Benefit Premium Payment Modes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); }


}



//edit function
public void editBenefitPremiumPaymentModes( String benefitpremiumpaymentModesCode,String benefitpremiumpaymentModesDescription, String recordMark)throws Exception{
    
    try{ 
    
    System.out.println(" code: "+benefitpremiumpaymentModesCode);
    Log.info("log4j msg- code: "+benefitpremiumpaymentModesCode);
    //<div class="form-control text-box-10-chactr ng-pristine ng-untouched ng-valid ng-isolate-scope ng-not-empty ng-valid-maxlength" title="ACSC-MCD">ACSC-MCD</div>
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitpremiumpaymentModesCode+"']")));
    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitpremiumpaymentModesCode+"']")).click();
    System.out.println("clicked Benefit Premium Payment Modes ");
    Log.info("log4j msg- clicked Benefit Premium Payment Modes ");
    
    
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPremiumPaymentModesEditLink));
    driver.findElement(BenefitPremiumPaymentModesEditLink).click();
    System.out.println("clicked Edit");
    Log.info("log4j msg- clicked Edit");
    
    System.out.println(" Record Mark: "+recordMark);
    Log.info("log4j msg-  Record Mark: "+recordMark);
    		          
//enter new Record Mark
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPremiumPaymentModesRecordMark));
    driver.findElement(BenefitPremiumPaymentModesRecordMark).clear();
    Thread.sleep(1000);
    driver.findElement(BenefitPremiumPaymentModesRecordMark).sendKeys(recordMark);
    System.out.println("Entered new Record Mark");
    Log.info("log4j msg- Entered new Record Mark");
    
    
    
    
    
    //click save
    wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPremiumPaymentModesSaveLink));
    driver.findElement(BenefitPremiumPaymentModesSaveLink).click();
    System.out.println("Clicked save");
    Log.info("log4j msg- clicked save");
    Thread.sleep(1000);
    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
    
    
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Benefit Premium Payment Modes ");
    Log.info("log4j msg- Error in Editing Benefit Premium Payment Modes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();}


}
//exit function
public void exitBenefitPremiumPaymentModes( String benefitpremiumpaymentModesCode) throws Exception{
try{
               Thread.sleep(1000);
                    driver.findElement(BenefitPremiumPaymentModesExitLink).click();
                    Thread.sleep(1000);
                    System.out.println("Clicked exit in  Benefit Premium Payment Modes ");
                    Log.info("log4j msg- clicked exit in  Benefit Premium Payment Modes "); 
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
                  
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Benefit Premium Payment Modes ");
Log.info("log4j msg- Error in Exiting Benefit Premium Payment Modes "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();}
}


//add comm function
public void addCommBenefitPremiumPaymentModes( String benefitpremiumpaymentModesCode, String subject, String NoteType, String medium, String notes) throws Exception{
    
    try{         
    System.out.println(" code"+benefitpremiumpaymentModesCode);
    Log.info("log4j msg-  code"+benefitpremiumpaymentModesCode);
                    //find
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitpremiumpaymentModesCode+"']")));
    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitpremiumpaymentModesCode+"']")).click();
    System.out.println("clicked Benefit Premium Payment Modes Code");
    Log.info("log4j msg- clicked Benefit Premium Payment Modes code");
    
                                    //click comm
                                    
    wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPremiumPaymentModesCommLink));
    driver.findElement(BenefitPremiumPaymentModesCommLink).click();
    System.out.println("clicked Comm");
    Log.info("log4j msg- clicked Comm");

                                    
                                    
                                    //click add
                                    //<img src="../Content/images/icon-add-white.png" width="30" height="30">
                                    //id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]
                                    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]]")));
                                    //driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]]")).click();
                                    
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]")));
                                    driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]")).click();
                                    
                                    //id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]
                                    
                                    
                                    
                                    
                                    
                                    System.out.println("clicked Add");
                                    Log.info("log4j msg- clicked Add");
                                    
                                    //enter subject
                                    //<input type="text" id="txtSubject" tabindex="1" class="form-control ng-pristine ng-valid ng-empty ng-valid-maxlength ng-touched" maxlength="70" data-ng-model="currentRecord.subject" data-ng-disabled="isAuditing" style="width: 100%;">
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
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
                
                                    
                    } catch (Exception e){e.printStackTrace();
                    System.out.println("Error in adding Comm to Benefit Premium Payment Modes");
                    Log.info("log4j msg - Error in adding Comm to  Benefit Premium Payment Modes"); 
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
    driver.quit();      
    }
}





//delete function
public void deleteBenefitPremiumPaymentModes(String benefitpremiumpaymentModesCode) throws Exception{
    
    try{        
                    
    
    //find Benefit Premium Payment Modes
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitpremiumpaymentModesCode+"']")));
                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitpremiumpaymentModesCode+"']")).click();
                                    System.out.println("clicked Benefit Premium Payment Modes Code");
                                    Log.info("log4j msg- clicked Benefit Premium Payment Modes code");
                    
                                    //click delete
                                    
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPremiumPaymentModesDeleteLink));
                                    driver.findElement(BenefitPremiumPaymentModesDeleteLink).click();
                                    System.out.println("clicked Delete");
                                    Log.info("log4j msg- clicked Delete");
                                    
    
                                    //click confirm delete
                                    
                                    
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                    driver.findElement(confirmDeleteButton).click();
                                    System.out.println("clicked confirm Delete");
                                    Log.info("log4j msg- clicked confirm Delete");
                                    Thread.sleep(1000);
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
                                    
                                    
    
} catch (Exception e){
	System.out.println("Error in deleting Benefit Premium Payment Modes");
  Log.info("log4j msg - Error in deleting Benefit Premium Payment Modes"); 
  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
  driver.quit(); 
    }
}











}

