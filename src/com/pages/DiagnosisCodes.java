package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class DiagnosisCodes {

	WebDriver driver;
	WebDriverWait wait;

	
	By DiagnosisCodesCodeBeginsInput = By.xpath("//input[@id='search_icd']");
	
	By DiagnosisCodesNameDescriptionBeginsInput = By.xpath("//input[@id='search_name']");
	
	By DiagnosisCodesSearchButton= By.xpath("//button[@class='btn btn-primary']");
     
    By DiagnosisCodesAddLink= By.linkText("Add");
 
    By DiagnosisCodesCodeInput = By.xpath("//input[@id='txtIcd']");
    
    By DiagnosisCodesDescriptionInput= By.xpath("//textarea[@id='txtName']");
    
    By DiagnosticCategoryBeginsInput = By.xpath("//select[@data-ng-model='currentRecord.dxcategory']");
    
    By DiagnosisCodesRecordMark= By.xpath("//input[@style='width: 20px;']");
    
    By DiagnosisCodesValidateLink =By.linkText("Validate");
          
    By DiagnosisCodesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
       
    By DiagnosisCodesSaveLink =  By.linkText("Save");
       
    By DiagnosisCodesEditLink = By.linkText("Edit");
       
    By DiagnosisCodesCopyLink = By.linkText("Copy");
       
    By DiagnosisCodesDeleteLink= By.linkText("Delete");
       
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
       
    By DiagnosisCodesCommLink= By.linkText("Commun.");
            
    By DiagnosisCodesExitLink=  By.linkText("Exit");
       
       
       
       
       public DiagnosisCodes(WebDriver driver){
                       this.driver= driver;
                       this.wait = new WebDriverWait(driver, 35);
       }
       
       
   	public int searchDiagnosisCodes( String DiagnosisCodesCode, String DiagnosisCodesName) throws Exception{
   		
   		try{
   		//enter  Diagnosis Codes code
   		wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesCodeBeginsInput));
   		driver.findElement(DiagnosisCodesCodeBeginsInput).clear();
   		driver.findElement(DiagnosisCodesCodeBeginsInput).sendKeys(DiagnosisCodesCode);
   		System.out.println("Entered Diagnosis Code ");
   		Log.info("log4j msg- Entered Diagnosis Code");
   	
   	Thread.sleep(1000);
   		//enter  Diagnosis Codes name
   		wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesNameDescriptionBeginsInput));
   		driver.findElement(DiagnosisCodesNameDescriptionBeginsInput).clear();
   		driver.findElement(DiagnosisCodesNameDescriptionBeginsInput).sendKeys(DiagnosisCodesName);
   		System.out.println("Entered Diagnosis Code name");
   		Log.info("log4j msg- Entered Diagnosis Code name");
   		Thread.sleep(1000);
   		//click search
   		wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesSearchButton));
   		driver.findElement(DiagnosisCodesSearchButton).click();
   		System.out.println("clicked Search");
   		Log.info("log4j msg- clicked Search");
   				
   		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodesCode+"']")));
   		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodesCode+"']"));
   		e.click();
   		System.out.println("Found Diagnosis Code");
   		Log.info("log4j msg- Found Diagnosis Code ");
   	
   		return 1;
   		}
   		
   	catch(Exception e){System.out.println("Diagnosis Code not found"); 
   	Log.info("log4j msg- Diagnosis Code not found"); return 0;}
   		
   	}

       //add function
       public void addDiagnosisCodes( String DiagnosisCodesCode, String DiagnosisCodesDescription, String DiagnosticCategory)throws Exception{
       
                       try{
                       
                       int i= searchDiagnosisCodes( DiagnosisCodesCode, DiagnosisCodesDescription);
               		
               		if (i==0){
               			System.out.println("Diagnosis Code not found, Continue with Add");
               			Log.info("log4j msg- Diagnosis Code not found, Continue with Add");
               		
               		
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesAddLink));
                       driver.findElement(DiagnosisCodesAddLink).click();
                       System.out.println("clicked Add");
                       Log.info("log4j msg- clicked Add");
                       
                       
                       System.out.println("Diagnosis code: "+DiagnosisCodesCode);
                       //enter code
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesCodeInput));
                       driver.findElement(DiagnosisCodesCodeInput).sendKeys(DiagnosisCodesCode);
                       System.out.println("Entered code");
                       Log.info("log4j msg- Entered code");
                       Thread.sleep(1000);
                       System.out.println("Diagnosis Code description: "+DiagnosisCodesDescription);
                       //enter Description
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesDescriptionInput));
                       driver.findElement(DiagnosisCodesDescriptionInput).sendKeys(DiagnosisCodesDescription);
                       System.out.println("Entered description");
                       Log.info("log4j msg- Entered description");
                       Thread.sleep(1000);
                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlDxCategory']"))); 
                       Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlDxCategory']")));
                       placeOfService.selectByVisibleText(DiagnosticCategory);
                       System.out.println("selected note type");
                       Log.info("log4j msg-selected note type");
       
                       Thread.sleep(1000);
                       //click validate
       
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesValidateLink));
                       driver.findElement(DiagnosisCodesValidateLink).click();
                       System.out.println("clicked validate");
                       Log.info("log4j msg- clicked validate");
                       
                       //click ok
                       Thread.sleep(1000);
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesValidateSaveOKButton));
                       driver.findElement(DiagnosisCodesValidateSaveOKButton).click();
                       System.out.println("clicked validate ok to save button");
                       Log.info("log4j msg- clicked validate ok to save button");
                       Thread.sleep(1000);
               		
                       //click save
                       Thread.sleep(1000);
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesSaveLink));
                       driver.findElement(DiagnosisCodesSaveLink).click();
                       System.out.println("clicked save ");
                       Log.info("log4j msg- clicked  save ");
                       Thread.sleep(1000);
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                         driver.quit(); 
                       
                       } else{
               			System.out.println("Diagnosis Codes is already present, cannot add DiagnosisCodes");
               			Log.info("log4j msg- Diagnosis Codes is already present, cannot add DiagnosisCodes");
               			wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesExitLink));
               			driver.findElement(DiagnosisCodesExitLink).click();
               			System.out.println("clicked Exit");
               			Log.info("log4j msg- clicked Exit");
               			Thread.sleep(1000);
               			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
               			 driver.quit(); 
               		}
       
                       }catch (Exception e){
                    	   e.printStackTrace();
                    	   System.out.println("Error in adding Diagnosis Code"); 
                       	   Log.info("log4j msg- Error in adding Diagnosis Code");
                       	   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
              			 driver.quit(); 
                       
                       
                       }
               		}
                       
       //copy function
       
       public void copyDiagnosisCodes( String DiagnosisCodesCode, String DiagnosisCodesName, String newDiagnosisCodesCode, String newDiagnosisCodesDescription)throws Exception{
                       
                       try{ 
                       
                       int i= searchDiagnosisCodes( DiagnosisCodesCode, DiagnosisCodesName);
               		
               		if (i==1){
               			System.out.println("Diagnosis Code found, continue with copy");
               			Log.info("log4j msg-Diagnosis Code found, continue with copy");
               		
                       
                       System.out.println("Diagnosis Code: "+DiagnosisCodesCode);
                       Log.info("log4j msg- Diagnosis Code: "+DiagnosisCodesCode);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodesCode+"']")));
                       driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodesCode+"']")).click();
                       System.out.println("clicked Diagnosis Code");
                       Log.info("log4j msg- clicked Diagnosis code");
                       
                       
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesCopyLink));
                       driver.findElement(DiagnosisCodesCopyLink).click();
                       System.out.println("clicked Copy");
                       Log.info("log4j msg- clicked Copy");
                       
                       System.out.println("New code"+newDiagnosisCodesCode);
                       Log.info("log4j msg- New code"+newDiagnosisCodesCode);
                       //enter new code
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesCodeInput));
                       driver.findElement(DiagnosisCodesCodeInput).clear();
                       driver.findElement(DiagnosisCodesCodeInput).sendKeys(newDiagnosisCodesCode);
                       System.out.println("Entered new code");
                       Log.info("log4j msg- Entered new code");
       
                       System.out.println("Diagnosis Code new description"+newDiagnosisCodesDescription);
                       Log.info("log4j msg- Diagnosis Code new description"+newDiagnosisCodesDescription);
       //enter new description
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesDescriptionInput));
                       driver.findElement(DiagnosisCodesDescriptionInput).clear();
                       driver.findElement(DiagnosisCodesDescriptionInput).sendKeys(newDiagnosisCodesDescription);
                       System.out.println("Entered new description");
                       Log.info("log4j msg- Entered new description");
                       
                       
                       
                       Thread.sleep(1000);
                       
                       //click save
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesSaveLink));
                       driver.findElement(DiagnosisCodesSaveLink).click();

                       System.out.println("Clicked save");
                       Log.info("log4j msg- clicked save");
                       Thread.sleep(1000);
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                         driver.quit(); 
               		
                       
               		
                       } else{
               			System.out.println("Diagnosis Code is not present, cannot copy Diagnosis Code");
               			Log.info("log4j msg- Diagnosis Code is already present, cannot add Diagnosis Code");
               			wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesExitLink));
               			driver.findElement(DiagnosisCodesExitLink).click();
               			System.out.println("clicked Exit");
               			Log.info("log4j msg- clicked Exit");
               			Thread.sleep(1000);
               			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
               			 driver.quit(); 
               		}
       
                       }catch (Exception e){
                    	   System.out.println("Error in copying Diagnosis Code"); 
                    	   Log.info("log4j msg- Error in copying Diagnosis Code");
                    	   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    	   driver.quit();
                       
               		}
       }
               		
               		
       
       
       

       
       //edit function
   public void editDiagnosisCodes( String DiagnosisCodesCode, String diagnosisCodesDescription, String recordMark)throws Exception{
                       
                       try{
                       
                       int i= searchDiagnosisCodes(DiagnosisCodesCode, diagnosisCodesDescription);
               		
               		if (i==1){
               			System.out.println("Diagnosis Code  found, Continue with Edit");
               			Log.info("log4j msg- Diagnosis Code  found, Continue with Edit");
               		
               		
                       System.out.println("Diagnosis code:"+DiagnosisCodesCode);
                       Log.info("log4j msg- Diagnosis code:"+DiagnosisCodesCode);
                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodesCode+"']")));
                       driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodesCode+"']")).click();
                       System.out.println("clicked Diagnosis Code Record Mark");
                       Log.info("log4j msg- clicked Diagnosis Code Record Mark");
                       
                       
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesEditLink));
                       driver.findElement(DiagnosisCodesEditLink).click();
                       System.out.println("clicked Edit");
                       Log.info("log4j msg- clicked Edit");
                       
                       System.out.println("Diagnosis Code Record Mark: "+recordMark);
                       Log.info("log4j msg- Diagnosis Code Record Mark: "+recordMark);                               
       //enter new description
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesRecordMark));
                       driver.findElement(DiagnosisCodesRecordMark).clear();
                       Thread.sleep(1000);
                       driver.findElement(DiagnosisCodesRecordMark).sendKeys(recordMark);
                       System.out.println("Entered Record Mark");
                       Log.info("log4j msg- Entered Record Mark");
                       
                       
                       
                       Thread.sleep(1000);
                       //click save
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesSaveLink));
                       driver.findElement(DiagnosisCodesSaveLink).click();
                       System.out.println("Clicked save");
                       Log.info("log4j msg- clicked save");
                       Thread.sleep(1000);
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                         driver.quit(); 
               		}
                       
               		else{System.out.println("Diagnosis Code not found, cannot edit Diagnosis Code");
                       Log.info("log4j msg- Diagnosis Code not found, cannot edit Diagnosis Code");  
                       BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                       driver.quit();}
               		
               		}catch (Exception e){ e.printStackTrace();System.out.println("Error in  Editing Diagnosis Code ");
                       Log.info("log4j msg- Error in  Editing Diagnosis Code ");   
                       BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                       driver.quit(); 
}
       
       
                       }
       //exit function
       public void exitDiagnosisCodes( String DiagnosisCodesCode) throws Exception{
       try{
                       System.out.println("Diagnosis code"+DiagnosisCodesCode);
                       Log.info("log4j msg- Diagnosis code"+DiagnosisCodesCode);
                                      Thread.sleep(1000);
                                       driver.findElement(DiagnosisCodesExitLink).click();
                                       Thread.sleep(1000);
                                       System.out.println("Clicked exit in  Diagnosis Code ");
                                       Log.info("log4j msg- clicked exit in  Diagnosis Code ");   
                                       BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                       driver.quit(); 
                                       
       	}catch (Exception e){ e.printStackTrace();System.out.println("Error in  Exiting Diagnosis Code ");
       Log.info("log4j msg- Error in  Exiting Diagnosis Code ");   
       BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
       driver.quit(); }}
       
       //add comm function
       public void addCommDiagnosisCodes( String DiagnosisCodesCode, String DiagnosisCodesName, String DiagnosisCodesCommsubject, String DiagnosisCodesCommNoteType, String DiagnosisCodesCommMedium, String DiagnosisCodesCommDetails) throws Exception{
                       
                       try{         
                       
                       int i= searchDiagnosisCodes(DiagnosisCodesCode, DiagnosisCodesName);
               		
               		if (i==1){
               			System.out.println("Diagnosis Codes  found, Continue with Add Communication");
               			Log.info("log4j msg- Diagnosis Codes  found, Continue with Add Communication");
               		
               		
                       System.out.println("Diagnosis code: "+DiagnosisCodesCode);
                       Log.info("log4j msg- Diagnosis code: "+DiagnosisCodesCode);
                                       //find DiagnosisCodes
                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodesCode+"']")));
                       driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodesCode+"']")).click();
                       System.out.println("clicked Diagnosis Code");
                       Log.info("log4j msg- clicked Diagnosis code");
                       
                                                       //click comm
                                                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesCommLink));
                       driver.findElement(DiagnosisCodesCommLink).click();
                       System.out.println("clicked Comm");
                       Log.info("log4j msg- clicked Comm");

                                                       
                       Thread.sleep(1000);
                                                       //click add
                                                       
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                                       driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                                      
                                                       System.out.println("clicked Add");
                                                       Log.info("log4j msg- clicked Add");
                                                       
                                                       //enter subject
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                       driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(DiagnosisCodesCommsubject);
                                                       System.out.println("entered subject");
                                                       Log.info("log4j msg- entered subject");
                                                       
                                                        //page down
                                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='currentRecord.followup']")));
                                                       driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.followup']")).sendKeys(Keys.PAGE_DOWN);
                                                       System.out.println("clicked page down");
                                                       Log.info("log4j msg- clicked page down");
                                                       
                                                       Thread.sleep(3000);
                                                       //click add details
                                                      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
                                                       driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
                                                       System.out.println("clicked add details");
                                                       Log.info("log4j msg- clicked add details");
                                                       
                                                       
                                                      
                                                       
                                                       Thread.sleep(2000);
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType"))); 
                                                       Select noteType = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                                       noteType.selectByVisibleText(DiagnosisCodesCommNoteType);
                                                       System.out.println("selected note type");
                                                       Log.info("log4j msg-selected note type");
                                                       
                                                    Thread.sleep(2000);
                                                       //enter note details
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes' and @data-ng-model='currentJournalRecord.notes']")));

                                                       driver.findElement(By.xpath("//textarea[@id='txtNotes'and @data-ng-model='currentJournalRecord.notes']")).sendKeys(DiagnosisCodesCommDetails);
                                                       System.out.println("entered notes details");
                                                       Log.info("log4j msg- entered notes details");
                                                       
                                                       Thread.sleep(2000);
                                                       
                                                       
                                                       //click hide
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
                                                       driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
                                                       System.out.println("clicked hide");
                                                       Log.info("log4j msg- clicked hide");
                                                       Thread.sleep(2000);
                                                       //click close case
                                                      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeCase()']")));
                                                       driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();
                                                       System.out.println("clicked close case");
                                                       Log.info("log4j msg- clicked close case");
                                                       Thread.sleep(1000);
                                                       //click save
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
                                                       driver.findElement(By.linkText("Save")).click();
                                                       System.out.println("clicked save");
                                                       Log.info("log4j msg- clicked save");
                                                       Thread.sleep(1000);
                                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                        driver.quit(); 
                                        
                                        }}
                                                       
                                        catch (Exception e){
                                        	e.printStackTrace();
                                        	System.out.println("Error in adding Comm to Diagnosis Code");
                                            Log.info("log4j msg - Error in adding Comm to  Diagnosis Code"); 
                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                        driver.quit();
                        
                        }   
                                        
                   }
                       
       
       
       
       
       
       //delete function
       public void deleteDiagnosisCodes( String DiagnosisCodesCode, String DiagnosisCodesDescription) throws Exception{
                       
                       try{        
                                       
                       int i= searchDiagnosisCodes( DiagnosisCodesCode, DiagnosisCodesDescription);
               		
               		if (i==1){
               			System.out.println("Diagnosis Code found, continue with delete");
               			Log.info("log4j msg-Diagnosis Code found, continue with delete");
               			
                       //find DiagnosisCodes
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodesCode+"']")));
                                                       driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodesCode+"']")).click();
                                                       System.out.println("clicked Diagnosis Code");
                                                       Log.info("log4j msg- clicked Diagnosis code");
                                       
                                                       //click delete
                                                       
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesDeleteLink));
                                                       driver.findElement(DiagnosisCodesDeleteLink).click();
                                                       System.out.println("clicked Delete");
                                                       Log.info("log4j msg- clicked Delete");
                                                       
                       
                                                       //click confirm delete
                                                       
                                                       
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                       driver.findElement(confirmDeleteButton).click();
                                                       System.out.println("clicked confirm Delete");
                                                       Log.info("log4j msg- clicked confirm Delete");
                                                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                                        driver.quit();
                                                       
                                                       
                       


       
       
   } else{
   	System.out.println("cannot find Diagnosis Code, cannot delete Diagnosis Code ");
   	Log.info("log4j msg- cannot find Diagnosis Code, cannot delete Diagnosis Code ");
   	wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodesExitLink));
   	driver.findElement(DiagnosisCodesExitLink).click();
   	System.out.println("clicked Exit");
   	Log.info("log4j msg- clicked Exit");
    Thread.sleep(1000);
   	
   	 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
   	 driver.quit(); 
   	
   }} catch (Exception e){
	   System.out.println("Error in deleting Diagnosis Code ");
	   Log.info("log4j msg - Error in deleting Diagnosis Code "); 
	   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	   	 driver.quit(); 

   }   
       }
  
   }
     


