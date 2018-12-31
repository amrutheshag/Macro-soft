package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class PayerTypes {

	WebDriver driver;
	WebDriverWait wait ;
	
    By PayerTypesAddLink= By.linkText("Add");
    
    By payerTypesCodeInput = By.xpath("//input[@id='code']");
    
    By PayerTypesDescriptionInput= By.xpath("//input[@id='name']");
    
    By PayerTypesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By PayerTypesValidateLink =By.linkText("Validate");
  
    By PayerTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By PayerTypesSaveLink =  By.linkText("Save");
    
    By PayerTypesEditLink = By.linkText("Edit");
    
    By PayerTypesCopyLink = By.linkText("Copy");
    
    By PayerTypesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By PayerTypesCommLink= By.linkText("Commun.");
    
    By PayerTypesExitLink=  By.linkText("Exit");
    
    
    
    
    public PayerTypes(WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver, 35);    
}



//add function
public void addPayerTypes( String payerTypesCode, String payerTypesDescription)throws Exception{

        try{ 
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PayerTypesAddLink));
        driver.findElement(PayerTypesAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println(" code: "+payerTypesCode);
        Log.info("log4j msg-  code: "+payerTypesCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(payerTypesCodeInput));
        driver.findElement(payerTypesCodeInput).sendKeys(payerTypesCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println(" description: "+payerTypesDescription);
        Log.info("log4j msg- description: "+payerTypesDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(PayerTypesDescriptionInput));
        driver.findElement(PayerTypesDescriptionInput).sendKeys(payerTypesDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PayerTypesValidateLink));
        driver.findElement(PayerTypesValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PayerTypesValidateSaveOKButton));
        driver.findElement(PayerTypesValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
        
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PayerTypesSaveLink));
        driver.findElement(PayerTypesSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
        Thread.sleep(1000);
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
        }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Payer Types ");
        Log.info("log4j msg- Error in Adding Payer Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
        
}

//copy function

public void copyPayerTypes( String payerTypesCode, String newpayerTypesCode, String newPayerTypesDescription)throws Exception{
        try{  
        
        System.out.println("code: "+payerTypesCode);
        Log.info("log4j msg- code: "+payerTypesCode);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+payerTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+payerTypesCode+"']")).click();
        System.out.println("clicked  Code");
        Log.info("log4j msg- clicked  code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PayerTypesCopyLink));
        driver.findElement(PayerTypesCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println(" new code"+newpayerTypesCode);
        Log.info("log4j msg- new code"+newpayerTypesCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(payerTypesCodeInput));
        driver.findElement(payerTypesCodeInput).clear();
        driver.findElement(payerTypesCodeInput).sendKeys(newpayerTypesCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("carrier covergae types new description"+newPayerTypesDescription);
        Log.info("log4j msg- carrier covergae types new description"+newPayerTypesDescription);
//enter new Record Mark
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PayerTypesDescriptionInput));
        driver.findElement(PayerTypesDescriptionInput).clear();
        driver.findElement(PayerTypesDescriptionInput).sendKeys(newPayerTypesDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        Thread.sleep(1000);
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(PayerTypesSaveLink));
        driver.findElement(PayerTypesSaveLink).click();
        
        Thread.sleep(1000);

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
        Thread.sleep(1000);
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
   
        
        
        
        
        
        
        }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Payer Types ");
        Log.info("log4j msg- Error in Copying Payer Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}


}



//edit function
public void editPayerTypes( String payerTypesCode,String payerTypesDescription,String recordMark)throws Exception{
        
        try{ 
        
        System.out.println(" code: "+payerTypesCode);
        Log.info("log4j msg-  code: "+payerTypesCode);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+payerTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+payerTypesCode+"']")).click();
        System.out.println("clicked Payer Types ");
        Log.info("log4j msg- clicked Payer Types ");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PayerTypesEditLink));
        driver.findElement(PayerTypesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("Record Mark: "+recordMark);
        Log.info("log4j msg-  Record Mark: "+recordMark);
        		          
//enter new Record Mark
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PayerTypesRecordMark));
        driver.findElement(PayerTypesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(PayerTypesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(PayerTypesSaveLink));
        driver.findElement(PayerTypesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
        Thread.sleep(1000);
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
        
        }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Payer Types ");
        Log.info("log4j msg- Error in Editing Payer Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}


}
//exit function
public void exitPayerTypes( String payerTypesCode) throws Exception{
try{
        //int i = searchPayerTypes(driver, payerTypesCode);
        System.out.println(" code"+payerTypesCode);
        Log.info("log4j msg- code"+payerTypesCode);
        //if (i==1)
                        Thread.sleep(1000);
                        driver.findElement(PayerTypesExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  Payer Types ");
                        Log.info("log4j msg- clicked exit in  Payer Types "); 
                        Thread.sleep(1000);
                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        //else
                        
                        //driver.findElement(BenefitClassExitLink).click();
                        
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Payer Types ");
Log.info("log4j msg- Error in Exiting Payer Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
}


//add comm function
public void addCommPayerTypes( String payerTypesCode, String subject, String NoteType, String medium, String notes) throws Exception{
        
        try{       
        	
        System.out.println("code"+payerTypesCode);
        Log.info("log4j msg- code"+payerTypesCode);
                     
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+payerTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+payerTypesCode+"']")).click();
        System.out.println("clicked Payer Types Code");
        Log.info("log4j msg- clicked Payer Types code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(PayerTypesCommLink));
        driver.findElement(PayerTypesCommLink).click();
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
                                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                        driver.quit();
                                        
                        } catch (Exception e){
                        e.printStackTrace();
                        System.out.println("Error in adding Comm to Payer Types");
                        Log.info("log4j msg - Error in adding Comm to  Payer Types"); 
                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                        driver.quit();      
        }
}





//delete function
public void deletePayerTypes( String payerTypesCode) throws Exception{
        
        try{            
        
        //find Payer Types
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+payerTypesCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+payerTypesCode+"']")).click();
                                        System.out.println("clicked Payer Types Code");
                                        Log.info("log4j msg- clicked Payer Types code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(PayerTypesDeleteLink));
                                        driver.findElement(PayerTypesDeleteLink).click();
                                        System.out.println("clicked Delete");
                                        Log.info("log4j msg- clicked Delete");
                                        
        
                                        //click confirm delete
                                        
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                        driver.findElement(confirmDeleteButton).click();
                                        System.out.println("clicked confirm Delete");
                                        Log.info("log4j msg- clicked confirm Delete");
                                        Thread.sleep(1000);
                                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                        
                                        
        
} catch (Exception e){e.printStackTrace();
System.out.println("Error in deleting Payer Types");
Log.info("log4j msg - Error in deleting Payer Types"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        }
}
}
