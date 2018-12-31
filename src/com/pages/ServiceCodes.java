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

public class ServiceCodes {
 
	WebDriver driver;
	WebDriverWait wait ;    
	
	By ServiceCodesCodeBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.servcode']");
	
	By ServiceCodesNameDescriptionBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.name']");
	
	By ServiceCodesSearchButton= By.xpath("//button[@ng-click='search()']");
    
    By ServiceCodesAddLink= By.linkText("Add");
    
    By ServiceCodesCodeInput = By.xpath("//input[@id='txtservCode']");
   
    By ServiceCodesDescriptionInput= By.xpath("//input[@id='txtName']");
    
    By DiagnosticCategoryBeginsInput = By.xpath("//select[@data-ng-model='serviceCode.servcat']");
    
    By ServiceCodesFollowupDays= By.xpath("//input[@data-ng-model='serviceCode.followup_days']");
    
    By ServiceCodesValidateLink =By.linkText("Validate");
        
    By ServiceCodesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
       
    By ServiceCodesSaveLink =  By.linkText("Save");
      
    By ServiceCodesEditLink = By.linkText("Edit");
    
    By ServiceCodesCopyLink = By.linkText("Copy");
       
    By ServiceCodesDeleteLink= By.linkText("Delete");
       
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
       
    By ServiceCodesCommLink= By.linkText("Commun.");
       
    By ServiceCodesExitLink=  By.linkText("Exit");
       
       
       public ServiceCodes(WebDriver driver){
                       this.driver= driver;
                       this.wait= new WebDriverWait(driver, 50);
       }
       
       
   	public int searchServiceCodes( String ServiceCodesCode, String ServiceCodesName) throws Exception{
   		
   		try{
   		//enter  Service Codes code
   		wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesCodeBeginsInput));
   		driver.findElement(ServiceCodesCodeBeginsInput).clear();
   		driver.findElement(ServiceCodesCodeBeginsInput).sendKeys(ServiceCodesCode);
   		System.out.println("entered Service Codes  Representivescode");
   		Log.info("log4j msg- entered Service Codes code");
   	
   	
   		//enter  Service Codes name
   		wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesNameDescriptionBeginsInput));
   		driver.findElement(ServiceCodesNameDescriptionBeginsInput).clear();
   		driver.findElement(ServiceCodesNameDescriptionBeginsInput).sendKeys(ServiceCodesName);
   		System.out.println("entered Service Codes name");
   		Log.info("log4j msg- entered Service Codes name");
   		
   		//click search
   		wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesSearchButton));
   		driver.findElement(ServiceCodesSearchButton).click();
   		System.out.println("clicked Search");
   		Log.info("log4j msg- clicked Search");
   				
   		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCodesCode+"']")));
   		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCodesCode+"']"));
   		e.click();
   		System.out.println("Found ServiceCodes");
   		Log.info("log4j msg- Found ServiceCodes");
   	
   		return 1;
   		}
   		
   	catch(Exception e){
   		
   	System.out.println("error in searching ServiceCodes"); return 0;}
   		
   	}

       //add function
       public void addServiceCodes( String ServiceCodesCode, String ServiceCodesDescription, String Category)throws Exception{
       
                       try{ 
                       int i= searchServiceCodes( ServiceCodesCode, ServiceCodesDescription);
               		
               		if (i==0){
               			System.out.println("Service Codes not found, Continue with Add");
               			Log.info("log4j msg- Service Codes not found, Continue with Add");
               		
               		
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesAddLink));
                       driver.findElement(ServiceCodesAddLink).click();
                       System.out.println("clicked Add");
                       Log.info("log4j msg- clicked Add");
                       
                       
                       System.out.println("Service Codes code: "+ServiceCodesCode);
                       //enter code
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesCodeInput));
                       driver.findElement(ServiceCodesCodeInput).sendKeys(ServiceCodesCode);
                       System.out.println("Entered code");
                       Log.info("log4j msg- Entered code");
                       
                       System.out.println("Service Codes description"+ServiceCodesDescription);
                       //enter Description
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesDescriptionInput));
                       driver.findElement(ServiceCodesDescriptionInput).sendKeys(ServiceCodesDescription);
                       System.out.println("Entered description");
                       Log.info("log4j msg- Entered description");
                       
                     //select category
                       Thread.sleep(2000);
                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlservCat"))); 
                       Select category = new Select(driver.findElement(By.id("ddlservCat")));
                       category.selectByVisibleText(Category);
                       System.out.println("selected category");
                       Log.info("log4j msg-selected category");
                       
                       //click validate
       
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesValidateLink));
                       driver.findElement(ServiceCodesValidateLink).click();
                       System.out.println("clicked validate");
                       Log.info("log4j msg- clicked validate");
                       
                       //click ok
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesValidateSaveOKButton));
                       driver.findElement(ServiceCodesValidateSaveOKButton).click();
                       System.out.println("clicked validate ok to save button");
                       Log.info("log4j msg- clicked validate ok to save button");
                       
               		
                       //click save
                       Thread.sleep(1000);
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesSaveLink));
                       driver.findElement(ServiceCodesSaveLink).click();
                       System.out.println("clicked save ");
                       Log.info("log4j msg- clicked  save ");
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                       
                       } else{
               			System.out.println("Service Codes is already present, cannot add ServiceCodes");
               			wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesExitLink));
               			driver.findElement(ServiceCodesExitLink).click();
               			System.out.println("clicked Exit");
               			Log.info("log4j msg- clicked Exit");
               			
               			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
               		}
       
                       }catch (Exception e){ e.printStackTrace();System.out.println("error in searching ServiceCodes"); }
               		}
                       
       //copy function
       
       public void copyServiceCodes( String ServiceCodesCode, String ServiceCodesName, String newServiceCodesCode, String newServiceCodesDescription)throws Exception{
                       
                       try{  
                       int i= searchServiceCodes( ServiceCodesCode, ServiceCodesName);
               		
               		if (i==1){
               			System.out.println("Service Codes found, continue with copy");
               			Log.info("log4j msg-Service Codes found, continue with copy");
               		
                       
                       System.out.println("Service Codes code"+ServiceCodesCode);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCodesCode+"']")));
                       driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCodesCode+"']")).click();
                       System.out.println("clicked Service Codes Code");
                       Log.info("log4j msg- clicked Service Codes code");
                       
                       
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesCopyLink));
                       driver.findElement(ServiceCodesCopyLink).click();
                       System.out.println("clicked Copy");
                       Log.info("log4j msg- clicked Copy");
                       
                       System.out.println("Service Codes newcode"+newServiceCodesCode);
                       
                       //enter new code
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesCodeInput));
                       driver.findElement(ServiceCodesCodeInput).clear();
                       driver.findElement(ServiceCodesCodeInput).sendKeys(newServiceCodesCode);
                       System.out.println("Entered new code");
                       Log.info("log4j msg- Entered new code");
       
                       System.out.println("Service Codes new description"+newServiceCodesDescription);
       //enter new description
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesDescriptionInput));
                       driver.findElement(ServiceCodesDescriptionInput).clear();
                       driver.findElement(ServiceCodesDescriptionInput).sendKeys(newServiceCodesDescription);
                       System.out.println("Entered new description");
                       Log.info("log4j msg- Entered new description");
                       
                       
                       
                       
                       
                       //click save
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesSaveLink));
                       driver.findElement(ServiceCodesSaveLink).click();

                       System.out.println("Clicked save");
                       Log.info("log4j msg- clicked save");
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
               		
                       
               		
                       } else{
               			System.out.println("Service Codes is already present, cannot copy ServiceCodes");
               			wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesExitLink));
               			driver.findElement(ServiceCodesExitLink).click();
               			System.out.println("clicked Exit");
               			Log.info("log4j msg- clicked Exit");
               			
               			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
               		}
       
                       }catch (Exception e){System.out.println("error in searching ServiceCodes"); }
               		}
               		
               		
       
       
       

       
       //edit function
   public void editServiceCodes( String ServiceCodesCode, String serviceCodesDescription, String followupDays)throws Exception{
                       
                       try{  
                       int i= searchServiceCodes(ServiceCodesCode, serviceCodesDescription);
               		
               		if (i==1){
               			System.out.println("Service Codes  found, Continue with Edit");
               			Log.info("log4j msg- Service Codes  found, Continue with Edit");
               		
               		
                       System.out.println("Service Codes code"+ServiceCodesCode);
                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCodesCode+"']")));
                       driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCodesCode+"']")).click();
                       System.out.println("clicked Service Codes ");
                       Log.info("log4j msg- clicked Service Codes ");
                       
                       
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesEditLink));
                       driver.findElement(ServiceCodesEditLink).click();
                       System.out.println("clicked Edit");
                       Log.info("log4j msg- clicked Edit");
                       
                       System.out.println("Service Codes follow up days"+followupDays);
                                                      
       //enter new followup days
                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesFollowupDays));
                       System.out.println("current followup days: "+driver.findElement(ServiceCodesFollowupDays).getText());
                       driver.findElement(ServiceCodesFollowupDays).clear();
                       Thread.sleep(1000);
                       driver.findElement(ServiceCodesFollowupDays).sendKeys(followupDays);
                       System.out.println("Entered followup days");
                       Log.info("log4j msg- Entered followup days");
                       
                       
                       
                       
                       //click save
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesSaveLink));
                       driver.findElement(ServiceCodesSaveLink).click();
                       System.out.println("Clicked save");
                       Log.info("log4j msg- clicked save");
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
               		}
                       
               		else{System.out.println("Service Codes not found ");
                       Log.info("log4j msg- Service Codes not found ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
               		
               		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Service Codes ");
                       Log.info("log4j msg- Error in Editing Service Codes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
       
       
                       }
       //exit function
       public void exitServiceCodes( String ServiceCodesCode) throws Exception{
       try{
                       System.out.println("Service Codes code"+ServiceCodesCode);
                       Thread.sleep(1000);
                                       driver.findElement(ServiceCodesExitLink).click();
                                       Thread.sleep(1000);
                                       System.out.println("Clicked exit in  Service Codes ");
                                       Log.info("log4j msg- clicked exit in  Service Codes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                   
       	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Service Codes ");
       Log.info("log4j msg- Error in Editing Service Codes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
       
       //add comm function
       public void addCommServiceCodes( String ServiceCodesCode, String ServiceCodesName, String ServiceCodesCommsubject, String ServiceCodesCommNoteType, String ServiceCodesCommMedium, String ServiceCodesCommDetails) throws Exception{
                       
                       try{     
                       int i= searchServiceCodes( ServiceCodesCode, ServiceCodesName);
               		
               		if (i==1){
               			System.out.println("Service Codes  found, Continue with Add Communication");
               			Log.info("log4j msg- Service Codes  found, Continue with Add Communication");
               		
               		
                       System.out.println("Service Codes code"+ServiceCodesCode);
                                       //find ServiceCodes
                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCodesCode+"']")));
                       driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCodesCode+"']")).click();
                       System.out.println("clicked Service Codes Code");
                       Log.info("log4j msg- clicked Service Codes code");
                       
                                                       //click comm
                                                       
                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesCommLink));
                       driver.findElement(ServiceCodesCommLink).click();
                       System.out.println("clicked Comm");
                       Log.info("log4j msg- clicked Comm");

                                                       
                                                       
                                                       //click add
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                                       driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                                         System.out.println("clicked Add");
                                                       Log.info("log4j msg- clicked Add");
                                                       
                                                       //enter subject
                                                       //<input type="text" id="txtSubject" tabindex="1" class="form-control ng-pristine ng-valid ng-empty ng-valid-maxlength ng-touched" maxlength="70" data-ng-model="currentRecord.subject" data-ng-disabled="isAuditing" style="width: 100%;">
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                       driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(ServiceCodesCommsubject);
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
                                                       placeOfService.selectByVisibleText(ServiceCodesCommNoteType);
                                                       System.out.println("selected note type");
                                                       Log.info("log4j msg-selected note type");
                                                       
                                                    
                                                       //enter note details
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@data-ng-model='currentJournalRecord.notes']")));
                                                       driver.findElement(By.xpath("//textarea[@data-ng-model='currentJournalRecord.notes']")).sendKeys(ServiceCodesCommDetails);
                                                       System.out.println("entered notes details");
                                                       Log.info("log4j msg- entered notes details");
                                                       
                                                       
                                                       
                                                       
                                                       //click hide
                                                      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
                                                       driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
                                                       System.out.println("clicked hide");
                                                       Log.info("log4j msg- clicked hide");
                                                      
                                                       
                                                       /*
                                                       //click close case
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeCase()']")));
                                                       driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();
                                                       System.out.println("clicked close case");
                                                       Log.info("log4j msg- clicked close case");
                                                       */ 
                                                       //click save
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
                                                       driver.findElement(By.linkText("Save")).click();
                                                       System.out.println("clicked save");
                                                       Log.info("log4j msg- clicked save");
                                                       
                                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                                        driver.quit();
                                        }}
                                                       
                                        catch (Exception e){e.printStackTrace();System.out.println("error in adding Comm to ServiceCodes");
                                                                                                                       Log.info("log4j msg - error in adding Comm to  ServiceCodes"); 
                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                        driver.quit();  
                        }   
                                        
                                        }
                       
       
       
       
       
       //delete function
       public void deleteServiceCodes( String ServiceCodesCode, String ServiceCodesDescription) throws Exception{
                       
                       try{            
                       int i= searchServiceCodes( ServiceCodesCode, ServiceCodesDescription);
               		
               		if (i==1){
               			System.out.println("Service Codes found, continue with delete");
               			Log.info("log4j msg-Service Codes found, continue with delete");
               			
                       //find ServiceCodes
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCodesCode+"']")));
                                                       driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ServiceCodesCode+"']")).click();
                                                       System.out.println("clicked Service Codes Code");
                                                       Log.info("log4j msg- clicked Service Codes code");
                                       
                                                       //click delete
                                                       
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesDeleteLink));
                                                       driver.findElement(ServiceCodesDeleteLink).click();
                                                       System.out.println("clicked Delete");
                                                       Log.info("log4j msg- clicked Delete");
                                                       
                       
                                                       //click confirm delete
                                                       
                                                       
                                                       wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                       driver.findElement(confirmDeleteButton).click();
                                                       System.out.println("clicked confirm Delete");
                                                       Log.info("log4j msg- clicked confirm Delete");
                                                        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                                       
                                                       
                       


       
       
   } else{
   	System.out.println("cannot find Service Codes ");
   	Log.info("log4j msg- cannot find Service Codes ");
   	wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceCodesExitLink));
   	driver.findElement(ServiceCodesExitLink).click();
   	System.out.println("clicked Exit");
   	Log.info("log4j msg- clicked Exit");
   	
   	
   	 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
   	
   }} catch (Exception e){System.out.println("error in deleting Service Codes ");
   Log.info("log4j msg - error in deleting Service Codes "); 

   }   
       }
   

   }
     


