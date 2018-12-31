package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class AdjustmentTypes {

WebDriver driver;
WebDriverWait wait;


By AdjustmentTypesAddLink= By.linkText("Add");

By adjustmentTypesCodeInput = By.xpath("//input[@data-ng-model='AdjustmentTypeListing.code']");

By AdjustmentTypesDescriptionInput= By.xpath("//input[@data-ng-model='AdjustmentTypeListing.description']");

By AdjustmentTypesRecordMark= By.xpath("//input[@id='txtMark']");

By AdjustmentTypesValidateLink =By.linkText("Validate");

By AdjustmentTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");

By AdjustmentTypesSaveLink =  By.linkText("Save");

By AdjustmentTypesEditLink = By.linkText("Edit");

By AdjustmentTypesCopyLink = By.linkText("Copy");

By AdjustmentTypesDeleteLink= By.linkText("Delete");

By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");

By AdjustmentTypesCommLink= By.linkText("Commun.");

By AdjustmentTypesExitLink=  By.linkText("Exit");




public AdjustmentTypes(WebDriver driver){
                this.driver= driver;
                this.wait= new WebDriverWait(driver, 25);
}



//add function
public void addAdjustmentTypes(String adjustmentTypesCode, String adjustmentTypesDescription)throws Exception{

                try{ 
                wait.until(ExpectedConditions.visibilityOfElementLocated(AdjustmentTypesAddLink));
                driver.findElement(AdjustmentTypesAddLink).click();
                System.out.println("clicked Add");
                Log.info("log4j msg- clicked Add");
                
                
                System.out.println("code: "+adjustmentTypesCode);
                Log.info("log4j msg- code: "+adjustmentTypesCode);
                //enter code
                wait.until(ExpectedConditions.visibilityOfElementLocated(adjustmentTypesCodeInput));
                driver.findElement(adjustmentTypesCodeInput).sendKeys(adjustmentTypesCode);
                Thread.sleep(1000);
                System.out.println("Entered code");
                Log.info("log4j msg- Entered code");
                
                System.out.println("Description: "+adjustmentTypesDescription);
                Log.info("log4j msg-Description: "+adjustmentTypesDescription);
                //enter Description
                wait.until(ExpectedConditions.visibilityOfElementLocated(AdjustmentTypesDescriptionInput));
                driver.findElement(AdjustmentTypesDescriptionInput).sendKeys(adjustmentTypesDescription);
                Thread.sleep(1000);
                System.out.println("Entered description");
                Log.info("log4j msg- Entered description");

                
                //click validate

                
                wait.until(ExpectedConditions.visibilityOfElementLocated(AdjustmentTypesValidateLink));
                driver.findElement(AdjustmentTypesValidateLink).click();
                System.out.println("clicked validate");
                Log.info("log4j msg- clicked validate");
                
                //click ok
                
                wait.until(ExpectedConditions.visibilityOfElementLocated(AdjustmentTypesValidateSaveOKButton));
                driver.findElement(AdjustmentTypesValidateSaveOKButton).click();
                System.out.println("clicked validate ok to save button");
                Log.info("log4j msg- clicked validate ok to save button");
                
                
                //click save
                Thread.sleep(1000);
                
                wait.until(ExpectedConditions.visibilityOfElementLocated(AdjustmentTypesSaveLink));
                driver.findElement(AdjustmentTypesSaveLink).click();
                System.out.println("clicked save ");
                Log.info("log4j msg- clicked  save ");
                BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
                
                }catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Adjustment Types ");
                Log.info("log4j msg- Error in Adding Adjustment Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); }
                
}

//copy function

public void copyAdjustmentTypes(String adjustmentTypesCode, String newadjustmentTypesCode, String newAdjustmentTypesDescription)throws Exception{
                
                try{ 
                	
                System.out.println("code: "+adjustmentTypesCode);
                Log.info("log4j msg-code: "+adjustmentTypesCode);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+adjustmentTypesCode+"']")));
                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+adjustmentTypesCode+"']")).click();
                System.out.println("clicked  Code");
                Log.info("log4j msg- clicked  code");
                
                
                
                wait.until(ExpectedConditions.visibilityOfElementLocated(AdjustmentTypesCopyLink));
                driver.findElement(AdjustmentTypesCopyLink).click();
                System.out.println("clicked Copy");
                Log.info("log4j msg- clicked Copy");
                
                System.out.println(" new code: "+newadjustmentTypesCode);
                Log.info("log4j msg-  new code: "+newadjustmentTypesCode);
                //enter new code
                wait.until(ExpectedConditions.visibilityOfElementLocated(adjustmentTypesCodeInput));
                driver.findElement(adjustmentTypesCodeInput).clear();
                driver.findElement(adjustmentTypesCodeInput).sendKeys(newadjustmentTypesCode);
                System.out.println("Entered new code");
                Log.info("log4j msg- Entered new code");

                System.out.println("new description: "+newAdjustmentTypesDescription);
                Log.info("log4j msg- new description: "+newAdjustmentTypesDescription);
                //enter new description
                Thread.sleep(1000);
                wait.until(ExpectedConditions.visibilityOfElementLocated(AdjustmentTypesDescriptionInput));
                driver.findElement(AdjustmentTypesDescriptionInput).clear();
                driver.findElement(AdjustmentTypesDescriptionInput).sendKeys(newAdjustmentTypesDescription);
                System.out.println("Entered new description");
                Log.info("log4j msg- Entered new description");
                
                
                
                
                Thread.sleep(1000);
                
                //click save
                wait.until(ExpectedConditions.visibilityOfElementLocated(AdjustmentTypesSaveLink));
                driver.findElement(AdjustmentTypesSaveLink).click();
                
                Thread.sleep(1000);

                System.out.println("Clicked save");
                Log.info("log4j msg- clicked save");
                BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                driver.quit(); 
                
                Thread.sleep(1000);
                
                }catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Adjustment Types ");
                Log.info("log4j msg- Error in Copying Adjustment Types ");
                BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                driver.quit(); }


}



//edit function
public void editAdjustmentTypes(String adjustmentTypesCode,String AdjustmentTypesDescription, String recordMark)throws Exception{
                
                try{ 
                	//WebDriverWait wait = new WebDriverWait(driver, 25);
                
                System.out.println("code: "+adjustmentTypesCode);
                Log.info("log4j msg-code: "+adjustmentTypesCode);
                 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+adjustmentTypesCode+"']")));
                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+adjustmentTypesCode+"']")).click();
                System.out.println("clicked Adjustment Types");
                Log.info("log4j msg- clicked Adjustment Types");
                
                
                
                wait.until(ExpectedConditions.visibilityOfElementLocated(AdjustmentTypesEditLink));
                driver.findElement(AdjustmentTypesEditLink).click();
                System.out.println("clicked Edit");
                Log.info("log4j msg- clicked Edit");
                
                System.out.println("Record Mark: "+recordMark);
                Log.info("log4j msg-Record Mark: "+recordMark);
                		          
//enter new Record Mark
                
                wait.until(ExpectedConditions.visibilityOfElementLocated(AdjustmentTypesRecordMark));
               driver.findElement(AdjustmentTypesRecordMark).clear();
                Thread.sleep(1000);
                driver.findElement(AdjustmentTypesRecordMark).sendKeys(recordMark);
                System.out.println("Entered new Record Mark");
                Log.info("log4j msg- Entered new Record Mark");
                
                
                
                
                
                //click save
                wait.until(ExpectedConditions.visibilityOfElementLocated(AdjustmentTypesSaveLink));
                driver.findElement(AdjustmentTypesSaveLink).click();
                System.out.println("Clicked save");
                Log.info("log4j msg- clicked save");
                BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
                
                
                }catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Adjustment Types ");
                Log.info("log4j msg- Error in Editing Adjustment Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); }


}
//exit function
public void exitAdjustmentTypes(String adjustmentTypesCode) throws Exception{
try{
                System.out.println("code: "+adjustmentTypesCode);
                Log.info("log4j msg-code: "+adjustmentTypesCode);
              
                                Thread.sleep(1000);
                                driver.findElement(AdjustmentTypesExitLink).click();
                                Thread.sleep(1000);
                                System.out.println("Clicked exit in  Adjustment Types ");
                                Log.info("log4j msg- clicked exit in  Adjustment Types "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
               
                                
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Adjustment Types ");
Log.info("log4j msg- Error in Exiting Adjustment Types ");
BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
driver.quit(); 
}
}


//add comm function
public void addCommAdjustmentTypes(String adjustmentTypesCode, String subject, String NoteType, String medium, String notes) throws Exception{
                
                try{         
                System.out.println(" code: "+adjustmentTypesCode);
                Log.info("log4j msg-  code: "+adjustmentTypesCode);
                                //find 
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+adjustmentTypesCode+"']")));
                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+adjustmentTypesCode+"']")).click();
                System.out.println("clicked Adjustment Types Code");
                Log.info("log4j msg- clicked Adjustment Types code");
                
                                                //click comm
                                                
                wait.until(ExpectedConditions.visibilityOfElementLocated(AdjustmentTypesCommLink));
                driver.findElement(AdjustmentTypesCommLink).click();
                System.out.println("clicked Comm");
                Log.info("log4j msg- clicked Comm");

                                            
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
                                                
                                                /* Thread added by amruthesh*/

                                                Thread.sleep(6000);
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlNoteType']")));
                                               
                                                /* Thread added by amruthesh*/
                                                Thread.sleep(3000);
                                                Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                                Thread.sleep(5000);
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
                                                BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
                                
                                                
                                } catch (Exception e){
                                	e.printStackTrace();
                                	System.out.println("Error in adding Comm to Adjustment Types");
                                	Log.info("log4j msg - Error in adding Comm to  Adjustment Types"); 
                                	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                	driver.quit();      
                }
}





//delete function
public void deleteAdjustmentTypes(String adjustmentTypesCode) throws Exception{
                
                try{         
                 //find Adjustment Types
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+adjustmentTypesCode+"']")));
                                                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+adjustmentTypesCode+"']")).click();
                                                System.out.println("clicked Adjustment Types Code");
                                                Log.info("log4j msg- clicked Adjustment Types code");
                                
                                                //click delete
                                                
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(AdjustmentTypesDeleteLink));
                                                driver.findElement(AdjustmentTypesDeleteLink).click();
                                                System.out.println("clicked Delete");
                                                Log.info("log4j msg- clicked Delete");
                                                
                
                                                //click confirm delete
                                                
                                                
                                                wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                driver.findElement(confirmDeleteButton).click();
                                                System.out.println("clicked confirm Delete");
                                                Log.info("log4j msg- clicked confirm Delete");
                                                BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
                                                
                                                
                
} catch (Exception e){System.out.println("Error in deleting Adjustment Types");
                      Log.info("log4j msg - Error in deleting Adjustment Types");
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                      driver.quit(); 
                }
}





}

