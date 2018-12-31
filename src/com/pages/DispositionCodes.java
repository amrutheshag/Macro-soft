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

public class DispositionCodes {
	
	WebDriver driver;
	WebDriverWait wait;

	
	By DispositionCodesCodeBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.message']");
	
	By DispositionCodesNameDescriptionBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.name']");
	
	By DispositionCodesContractType = By.xpath("//input[@data-ng-model='filterOptions.contract_type']");
	
	By DispositionCodesSearchButton= By.xpath("//button[@ng-click='search()']");
    
    By DispositionCodesAddLink= By.linkText("Add");
    
    By DispositionCodesCodeInput = By.xpath("//input[@id='txtmessage']");
    
    By DispositionCodesDescriptionInput= By.xpath("//input[@id='txtdesc']");
    
    By DiagnosticCategoryBeginsInput = By.xpath("//select[@data-ng-model='dispositionCode.contract_type']");
    
    By DispositionCodesMemberMessage= By.xpath("//textarea[@data-ng-model='dispositionCode.member_message']");
    
    By DispositionCodesValidateLink =By.linkText("Validate");
       
    By DispositionCodesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
       
    By DispositionCodesSaveLink =  By.linkText("Save");
       
    By DispositionCodesEditLink = By.linkText("Edit");
       
    By DispositionCodesCopyLink = By.linkText("Copy");
       
    By DispositionCodesDeleteLink= By.linkText("Delete");
       
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
       
    By DispositionCodesCommLink= By.linkText("Commun.");
       
    By DispositionCodesExitLink=  By.linkText("Exit");
      
       
       
       
       public DispositionCodes(WebDriver driver){
                       this.driver= driver;
                       this.wait = new WebDriverWait(driver, 20);
       }
       
       
   	public int searchDispositionCodes( String DispositionCodesCode, String DispositionCodesName) throws Exception{
   		try{
   		//enter  Disposition Codes code
   		wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesCodeBeginsInput));
   		driver.findElement(DispositionCodesCodeBeginsInput).clear();
   		driver.findElement(DispositionCodesCodeBeginsInput).sendKeys(DispositionCodesCode);
   		System.out.println("entered Disposition Codes  Representivescode");
   		Log.info("log4j msg- entered Disposition Codes code");
   	
   	
   		//enter  Disposition Codes name
   		wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesNameDescriptionBeginsInput));
   		driver.findElement(DispositionCodesNameDescriptionBeginsInput).clear();
   		driver.findElement(DispositionCodesNameDescriptionBeginsInput).sendKeys(DispositionCodesName);
   		System.out.println("entered Disposition Codes name");
   		Log.info("log4j msg- entered Disposition Codes name");
   		
   		//click search
   		wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesSearchButton));
   		driver.findElement(DispositionCodesSearchButton).click();
   		System.out.println("clicked Search");
   		Log.info("log4j msg- clicked Search");
   				
   		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DispositionCodesCode+"']")));
   		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DispositionCodesCode+"']"));
   		e.click();
   		System.out.println("Found DispositionCodes");
   		Log.info("log4j msg- Found DispositionCodes");
   	
   		return 1;
   		}
   		
   	catch(Exception e){
   		System.out.println("Disposition Codes not found"); 
   		Log.info("log4j msg- Disposition Codes not found");
   		return 0;}
   		
   	}

       //add function
       public void addDispositionCodes( String DispositionCodesCode, String DispositionCodesDescription, String contractType)throws Exception{
       
                       try{ 
                    	
                       int i= searchDispositionCodes( DispositionCodesCode, DispositionCodesDescription);
               		
               		if (i==0){
               			System.out.println("Disposition Codes not found, Continue with Add");
               			Log.info("log4j msg- Disposition Codes not found, Continue with Add");
               		
               		
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesAddLink));
                       driver.findElement(DispositionCodesAddLink).click();
                       System.out.println("clicked Add");
                       Log.info("log4j msg- clicked Add");
                       
                       
                       System.out.println("Disposition Codes code: "+DispositionCodesCode);
                       Log.info("log4j msg- Disposition Codes code: "+DispositionCodesCode);
                       //enter code
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesCodeInput));
                       driver.findElement(DispositionCodesCodeInput).sendKeys(DispositionCodesCode);
                       System.out.println("Entered code");
                       Log.info("log4j msg- Entered code");
                       Thread.sleep(1000);
                       System.out.println("Disposition Codes description"+DispositionCodesDescription);
                       Log.info("log4j msg- Disposition Codes description"+DispositionCodesDescription);
                       //enter Description
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesDescriptionInput));
                       driver.findElement(DispositionCodesDescriptionInput).sendKeys(DispositionCodesDescription);
                       System.out.println("Entered description");
                       Log.info("log4j msg- Entered description");
                       Thread.sleep(1000);
                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlDxContractType']"))); 
                       Select ContractType = new Select(driver.findElement(By.xpath("//select[@id='ddlDxContractType']")));
                       ContractType.selectByVisibleText(contractType);
                       System.out.println("selected contract type");
                       Log.info("log4j msg-selected contract type");
       
                       
                       //click validate
       
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesValidateLink));
                       driver.findElement(DispositionCodesValidateLink).click();
                       System.out.println("clicked validate");
                       Log.info("log4j msg- clicked validate");
                       
                       //click ok
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesValidateSaveOKButton));
                       driver.findElement(DispositionCodesValidateSaveOKButton).click();
                       System.out.println("clicked validate ok to save button");
                       Log.info("log4j msg- clicked validate ok to save button");
                       
               		
                       //click save
                       Thread.sleep(1000);
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesSaveLink));
                       driver.findElement(DispositionCodesSaveLink).click();
                       System.out.println("clicked save ");
                       Log.info("log4j msg- clicked  save ");
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                         driver.quit(); 
                       
                       } else{
               			System.out.println("Disposition Codes is already present, cannot add Disposition Codes");
               			Log.info("log4j msg- Disposition Codes is already present, cannot add Disposition Codes");
               			wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesExitLink));
               			driver.findElement(DispositionCodesExitLink).click();
               			System.out.println("clicked Exit");
               			Log.info("log4j msg- clicked Exit");
               			
               			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
               			 driver.quit(); 
               		}
       
                       }catch (Exception e){ e.printStackTrace();System.out.println("error in Adding Disposition Codes"); 
                       Log.info("log4j msg- Error in Adding Disposition Codes"); 
                       BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                       driver.quit();
                       }
               		}
                       
       //copy function
       
       public void copyDispositionCodes( String DispositionCodesCode, String DispositionCodesName, String newDispositionCodesCode, String newDispositionCodesDescription)throws Exception{
                       
                       try{
                    	
                       int i= searchDispositionCodes( DispositionCodesCode, DispositionCodesName);
               		
               		if (i==1){
               			System.out.println("Disposition Codes found, continue with copy");
               			Log.info("log4j msg-Disposition Codes found, continue with copy");
               		
                       
                       System.out.println("Disposition Codes code"+DispositionCodesCode);
                       Log.info("log4j msg- Disposition Codes code"+DispositionCodesCode);
                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DispositionCodesCode+"']")));
                       driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DispositionCodesCode+"']")).click();
                       System.out.println("clicked Disposition Codes Code");
                       Log.info("log4j msg- clicked Disposition Codes code");
                       
                       
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesCopyLink));
                       driver.findElement(DispositionCodesCopyLink).click();
                       System.out.println("clicked Copy");
                       Log.info("log4j msg- clicked Copy");
                       
                       System.out.println("Disposition Codes newcode"+newDispositionCodesCode);
                       Log.info("log4j msg- Disposition Codes newcode"+newDispositionCodesCode);
                       //enter new code
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesCodeInput));
                       driver.findElement(DispositionCodesCodeInput).clear();
                       driver.findElement(DispositionCodesCodeInput).sendKeys(newDispositionCodesCode);
                       System.out.println("Entered new code");
                       Log.info("log4j msg- Entered new code");
       
                       System.out.println("Disposition Codes new description"+newDispositionCodesDescription);

                       Log.info("log4j msg- Disposition Codes new description"+newDispositionCodesDescription);
       //enter new description
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesDescriptionInput));
                       driver.findElement(DispositionCodesDescriptionInput).clear();
                       driver.findElement(DispositionCodesDescriptionInput).sendKeys(newDispositionCodesDescription);
                       System.out.println("Entered new description");
                       Log.info("log4j msg- Entered new description");
                       
                       
                       
                       
                       
                       //click save
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesSaveLink));
                       driver.findElement(DispositionCodesSaveLink).click();

                       System.out.println("Clicked save");
                       Log.info("log4j msg- clicked save");
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                         driver.quit(); 
               		
                       
               		
                       } else{
               			System.out.println("Disposition Codes is not present, cannot copy Disposition Codes");
               			Log.info("log4j msg- Disposition Codes is not present, cannot copy Disposition Codes");
               			wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesExitLink));
               			driver.findElement(DispositionCodesExitLink).click();
               			System.out.println("clicked Exit");
               			Log.info("log4j msg- clicked Exit");
               			
               			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
               			 driver.quit(); 
               			}
       
                       }
                       catch (Exception e){
                       System.out.println("error in Copying DispositionCodes");     
                       Log.info("log4j msg- error in Copying DispositionCodes");
                       BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
             		   driver.quit(); 
                       }
               		}
               		
               		
       
       
       

       
       //edit function
   public void editDispositionCodes( String DispositionCodesCode, String dispositionCodesDescription, String memberMessage)throws Exception{
                       
                       try{ 
                    	 
                       int i= searchDispositionCodes( DispositionCodesCode, dispositionCodesDescription);
               		
               		if (i==1){
               			System.out.println("Disposition Codes  found, Continue with Edit");
               			Log.info("log4j msg- Disposition Codes  found, Continue with Edit");
               		
               		
                       System.out.println("Disposition Codes code"+DispositionCodesCode);
                       Log.info("log4j msg- Disposition Codes code"+DispositionCodesCode);
                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DispositionCodesCode+"']")));
                       driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DispositionCodesCode+"']")).click();
                       System.out.println("clicked Disposition Codes Record Mark");
                       Log.info("log4j msg- clicked Disposition Codes Record Mark");
                       
                       
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesEditLink));
                       driver.findElement(DispositionCodesEditLink).click();
                       System.out.println("clicked Edit");
                       Log.info("log4j msg- clicked Edit");
                       
                       System.out.println("Disposition Codes Member Message"+memberMessage);
                       Log.info("log4j msg- Disposition Codes Member Message"+memberMessage);                         
       //enter new description
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesMemberMessage));
                       System.out.println("current description: "+driver.findElement(DispositionCodesMemberMessage).getText());
                       Log.info("current description: "+driver.findElement(DispositionCodesMemberMessage));
                       driver.findElement(DispositionCodesMemberMessage).clear();
                       Thread.sleep(1000);
                       driver.findElement(DispositionCodesMemberMessage).sendKeys(memberMessage);
                       System.out.println("Entered new description");
                       Log.info("log4j msg- Entered new description");
                       
                       
                       
                       
                       //click save
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesSaveLink));
                       driver.findElement(DispositionCodesSaveLink).click();
                       System.out.println("Clicked save");
                       Log.info("log4j msg- clicked save");
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                         driver.quit(); 
               		}
                       
               		else{System.out.println("Disposition Codes not found, cannot edit disposition codes");
                       Log.info("log4j msg- Disposition Codes not found, cannot edit disposition codes");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                       driver.quit(); }
               		
               		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Disposition Codes ");
                       Log.info("log4j msg- Error in Editing Disposition Codes ");   
                       BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                       driver.quit(); 
                       }
       
       
                       }
       //exit function
       public void exitDispositionCodes( String DispositionCodesCode) throws Exception{
       try{   System.out.println("Disposition Codes code: "+DispositionCodesCode);
                       Log.info("log4j msg- Disposition Codes code: "+DispositionCodesCode); 
                                        Thread.sleep(1000);
                                       driver.findElement(DispositionCodesExitLink).click();
                                       Thread.sleep(1000);
                                       System.out.println("Clicked exit in  Disposition Codes ");
                                       Log.info("log4j msg- clicked exit in  Disposition Codes ");   
                                       BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                                       driver.quit(); 
                      
       	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exit- Disposition Codes ");
       Log.info("log4j msg- Error in Exit- Disposition Codes ");   
       BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
       driver.quit(); 
}}
       
       //add comm function
       public void addCommDispositionCodes( String DispositionCodesCode, String DispositionCodesName, String DispositionCodesCommsubject, String DispositionCodesCommNoteType, String DispositionCodesCommMedium, String DispositionCodesCommDetails) throws Exception{
                       
                       try{         
                    	  
                       int i= searchDispositionCodes( DispositionCodesCode, DispositionCodesName);
               		
               		if (i==1){
               			System.out.println("Disposition Codes  found, Continue with Add Communication");
               			Log.info("log4j msg- Disposition Codes  found, Continue with Add Communication");
               		
               		
                       System.out.println("Disposition Codes code"+DispositionCodesCode);
                       Log.info("log4j msg- Disposition Codes code"+DispositionCodesCode);
                                       //find DispositionCodes
                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DispositionCodesCode+"']")));
                       driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DispositionCodesCode+"']")).click();
                       System.out.println("clicked Disposition Codes Code");
                       Log.info("log4j msg- clicked Disposition Codes code");
                       
                                                       //click comm
                                                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesCommLink));
                       driver.findElement(DispositionCodesCommLink).click();
                       System.out.println("clicked Comm");
                       Log.info("log4j msg- clicked Comm");

                                                       
                                                       
                                                       //click add
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                                       driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                                       
                                                       System.out.println("clicked Add");
                                                       Log.info("log4j msg- clicked Add");
                                                       
                                                       //enter subject
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                       driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(DispositionCodesCommsubject);
                                                       System.out.println("entered subject");
                                                       Log.info("log4j msg- entered subject");
                                                       
                                                       
                                                       //page down
                                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-ng-model='currentRecord.followup']")));
                                                       driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.followup']")).sendKeys(Keys.PAGE_DOWN);
                                                       System.out.println("clicked page down");
                                                       Log.info("log4j msg- clicked page down");
                                                       
                                                       
                                                       
                                                       
                                                       //click add details
                                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
                                                       driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
                                                       System.out.println("clicked add details");
                                                       Log.info("log4j msg- clicked add details");
                                                       
                                                       
                                                      
                                                       
                                                       Thread.sleep(2000);
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType"))); 
                                                       Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                                       placeOfService.selectByVisibleText(DispositionCodesCommNoteType);
                                                       System.out.println("selected note type");
                                                       Log.info("log4j msg-selected note type");
                                                       
                                                    
                                                       //enter note details
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                       driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(DispositionCodesCommDetails);
                                                       System.out.println("entered notes details");
                                                       Log.info("log4j msg- entered notes details");
                                                       
                                                       
                                                       
                                                       
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
                                       
                                        }}
                                                       
                        catch (Exception e){
                        e.printStackTrace();
                        System.out.println("error in adding Comm to DispositionCodes");
                        Log.info("log4j msg-  error in adding Comm to DispositionCodes");                                                                                              Log.info("log4j msg - error in adding Comm to  DispositionCodes"); 
                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                        driver.quit();
                       
                        }   
                                        
                 }
                       
       
       
       
       
       //delete function
       public void deleteDispositionCodes( String DispositionCodesCode, String DispositionCodesDescription) throws Exception{
                       
                       try{        
                    	   
                    	                 
                       int i= searchDispositionCodes( DispositionCodesCode, DispositionCodesDescription);
               		
               		if (i==1){
               			System.out.println("Disposition Codes found, continue with delete");
               			Log.info("log4j msg-Disposition Codes found, continue with delete");
               			
                       //find DispositionCodes
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DispositionCodesCode+"']")));
                                                       driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DispositionCodesCode+"']")).click();
                                                       System.out.println("clicked Disposition Codes Code");
                                                       Log.info("log4j msg- clicked Disposition Codes code");
                                       
                                                       //click delete
                                                       
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesDeleteLink));
                                                       driver.findElement(DispositionCodesDeleteLink).click();
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
   	System.out.println("cannot find Disposition Codes, cannot delete disposition codes ");
   	Log.info("log4j msg- cannot find Disposition Codes, cannot delete disposition codes ");
   	wait.until(ExpectedConditions.visibilityOfElementLocated(DispositionCodesExitLink));
   	driver.findElement(DispositionCodesExitLink).click();
   	System.out.println("clicked Exit");
   	Log.info("log4j msg- clicked Exit");
   	
   	
   	 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
   	driver.quit();
   }} catch (Exception e){System.out.println("error in deleting Disposition Codes ");
   Log.info("log4j msg - error in deleting Disposition Codes "); 
   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
  	driver.quit();
   

   }   
       }
   

   }
     



