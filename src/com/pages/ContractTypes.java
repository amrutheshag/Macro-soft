
package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class ContractTypes {

WebDriver driver;
WebDriverWait wait ;

 
By ContractTypesAddLink= By.linkText("Add");

By contractTypesCodeInput = By.xpath("//input[@id='code']");

By ContractTypesDescriptionInput= By.xpath("//input[@id='name']");

By ContractTypesRecordMark= By.xpath("//input[@style='width:20px;']");

By ContractTypesValidateLink =By.linkText("Validate");

By ContractTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");

By ContractTypesSaveLink =  By.linkText("Save");

By ContractTypesEditLink = By.linkText("Edit");

By ContractTypesCopyLink = By.linkText("Copy");

By ContractTypesDeleteLink= By.linkText("Delete");

By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");

By ContractTypesCommLink= By.linkText("Commun.");

By ContractTypesExitLink=  By.linkText("Exit");



public ContractTypes(WebDriver driver){
    this.driver= driver;
    this.wait= new WebDriverWait(driver, 30);
}



//add function
public void addContractTypes( String contractTypesCode, String contractTypesDescription)throws Exception{

    try{ 
    
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(ContractTypesAddLink));
    driver.findElement(ContractTypesAddLink).click();
    System.out.println("clicked Add");
    Log.info("log4j msg- clicked Add");
    
    
    System.out.println("contract type code: "+contractTypesCode);
    Log.info("log4j msg- contract type code: "+contractTypesCode);
    //enter code
    wait.until(ExpectedConditions.visibilityOfElementLocated(contractTypesCodeInput));
    driver.findElement(contractTypesCodeInput).sendKeys(contractTypesCode);
    Thread.sleep(1000);
    System.out.println("Entered code");
    Log.info("log4j msg- Entered code");
    
    System.out.println("contract type description"+contractTypesDescription);
    Log.info("log4j msg- contract type description"+contractTypesDescription);
    //enter Description
    wait.until(ExpectedConditions.visibilityOfElementLocated(ContractTypesDescriptionInput));
    driver.findElement(ContractTypesDescriptionInput).sendKeys(contractTypesDescription);
    Thread.sleep(1000);
    System.out.println("Entered description");
    Log.info("log4j msg- Entered description");

    
    //click validate

    
    wait.until(ExpectedConditions.visibilityOfElementLocated(ContractTypesValidateLink));
    driver.findElement(ContractTypesValidateLink).click();
    System.out.println("clicked validate");
    Log.info("log4j msg- clicked validate");
    
    //click ok
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(ContractTypesValidateSaveOKButton));
    driver.findElement(ContractTypesValidateSaveOKButton).click();
    System.out.println("clicked validate ok to save button");
    Log.info("log4j msg- clicked validate ok to save button");
    
    
    //click save
    Thread.sleep(1000);
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(ContractTypesSaveLink));
    driver.findElement(ContractTypesSaveLink).click();
    System.out.println("clicked save ");
    Log.info("log4j msg- clicked  save ");
    Thread.sleep(1000);
    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
    driver.quit(); 

    
    }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Contract Types ");
    Log.info("log4j msg- Error in Adding Contract Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
    driver.quit(); 
}
    
}

//copy function

public void copyContractTypes( String contractTypesCode, String newcontractTypesCode, String newContractTypesDescription)throws Exception{
    
    try{ 
    
    System.out.println("code"+contractTypesCode);
    Log.info("log4j msg- code"+contractTypesCode);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+contractTypesCode+"']")));
    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+contractTypesCode+"']")).click();
    System.out.println("clicked  Code");
    Log.info("log4j msg- clicked  code");
    
    
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(ContractTypesCopyLink));
    driver.findElement(ContractTypesCopyLink).click();
    System.out.println("clicked Copy");
    Log.info("log4j msg- clicked Copy");
    
    System.out.println(" new code: "+newcontractTypesCode);
    Log.info("log4j msg-  new code: "+newcontractTypesCode);
    //enter new code
    wait.until(ExpectedConditions.visibilityOfElementLocated(contractTypesCodeInput));
    driver.findElement(contractTypesCodeInput).clear();
    driver.findElement(contractTypesCodeInput).sendKeys(newcontractTypesCode);
    System.out.println("Entered new code");
    Log.info("log4j msg- Entered new code");

    System.out.println("new description: "+newContractTypesDescription);
    Log.info("log4j msg- new description: "+newContractTypesDescription);
//enter new Record Mark
    Thread.sleep(1000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(ContractTypesDescriptionInput));
    driver.findElement(ContractTypesDescriptionInput).clear();
    driver.findElement(ContractTypesDescriptionInput).sendKeys(newContractTypesDescription);
    System.out.println("Entered new description");
    Log.info("log4j msg- Entered new description");
    
    
    
    
    Thread.sleep(1000);
    
    //click save
    wait.until(ExpectedConditions.visibilityOfElementLocated(ContractTypesSaveLink));
    driver.findElement(ContractTypesSaveLink).click();
    
    Thread.sleep(1000);

    System.out.println("Clicked save");
    Log.info("log4j msg- clicked save");
    Thread.sleep(1000);
    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 

    
    Thread.sleep(1000);
    
       
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Contract Types ");
    Log.info("log4j msg- Error in Copying Contract Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
}


}



//edit function
public void editContractTypes( String contractTypesCode,String recordMark)throws Exception{
    
    try{ 
    
    System.out.println("code: "+contractTypesCode);
    Log.info("log4j msg- code: "+contractTypesCode);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+contractTypesCode+"']")));
    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+contractTypesCode+"']")).click();
    System.out.println("clicked Contract Types ");
    Log.info("log4j msg- clicked Contract Types ");
    
    
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(ContractTypesEditLink));
    driver.findElement(ContractTypesEditLink).click();
    System.out.println("clicked Edit");
    Log.info("log4j msg- clicked Edit");
    
    System.out.println("Record Mark: "+recordMark);
    Log.info("log4j msg- Record Mark: "+recordMark);
    		          
//enter new Record Mark
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(ContractTypesRecordMark));
    driver.findElement(ContractTypesRecordMark).clear();
    Thread.sleep(1000);
    driver.findElement(ContractTypesRecordMark).sendKeys(recordMark);
    System.out.println("Entered new Record Mark");
    Log.info("log4j msg- Entered new Record Mark");
    
    
    
    
    
    //click save
    wait.until(ExpectedConditions.visibilityOfElementLocated(ContractTypesSaveLink));
    driver.findElement(ContractTypesSaveLink).click();
    System.out.println("Clicked save");
    Log.info("log4j msg- clicked save");
    Thread.sleep(1000);
    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();

    
    
    }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Contract Types ");
    Log.info("log4j msg- Error in Editing Contract Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
}


}
//exit function
public void exitContractTypes( String contractTypesCode) throws Exception{
try{
      Thread.sleep(1000);
                    driver.findElement(ContractTypesExitLink).click();
                    Thread.sleep(1000);
                    System.out.println("Clicked exit in  Contract Types ");
                    Log.info("log4j msg- clicked exit in  Contract Types ");
                    Thread.sleep(1000);
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 

 
                    
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Contract Types ");
Log.info("log4j msg- Error in Exiting Contract Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
}
}


//add comm function
public void addCommContractTypes( String contractTypesCode, String subject, String NoteType, String medium, String notes) throws Exception{
    
    try{        
    System.out.println("code: "+contractTypesCode);
    Log.info("log4j msg- code: "+contractTypesCode);
                    //find 
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+contractTypesCode+"']")));
    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+contractTypesCode+"']")).click();
    System.out.println("clicked Contract Types Code");
    Log.info("log4j msg- clicked Contract Types code");
    
                                    //click comm
                                    
    wait.until(ExpectedConditions.visibilityOfElementLocated(ContractTypesCommLink));
    driver.findElement(ContractTypesCommLink).click();
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
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();


                                    
                    } catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to Contract Types");
                    Log.info("log4j msg - Error in adding Comm to  Contract Types"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();

    
    }
}





//delete function
public void deleteContractTypes( String contractTypesCode) throws Exception{
    
    try{         
                    
    
    //find Contract Types
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+contractTypesCode+"']")));
                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+contractTypesCode+"']")).click();
                                    System.out.println("clicked Contract Types Code");
                                    Log.info("log4j msg- clicked Contract Types code");
                    
                                    //click delete
                                    
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(ContractTypesDeleteLink));
                                    driver.findElement(ContractTypesDeleteLink).click();
                                    System.out.println("clicked Delete");
                                    Log.info("log4j msg- clicked Delete");
                                    
    
                                    //click confirm delete
                                    
                                    
                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                    driver.findElement(confirmDeleteButton).click();
                                    System.out.println("clicked confirm Delete");
                                    Log.info("log4j msg- clicked confirm Delete");
                                    Thread.sleep(1000);
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 

                                    
                                    
    
} catch (Exception e){System.out.println("Error in deleting Contract Types");
                      Log.info("log4j msg - Error in deleting Contract Types"); 
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                      driver.quit(); 

    }
}













}

