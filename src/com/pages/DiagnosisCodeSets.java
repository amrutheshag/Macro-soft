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

public class DiagnosisCodeSets {

	WebDriver driver;
	WebDriverWait wait;

	
	By DiagnosisCodeSetsDescriptionBeginsInput = By.xpath("//input[@data-ng-model='searchOptions.name']");
	
	By DiagnosisCodeSetsSearchButton= By.xpath("//button[@data-ng-click='search()']");
    
    By DiagnosisCodeSetsAddLink= By.linkText("Add");
   
    By DiagnosisCodeSetsDescriptionInput = By.xpath("//input[@id='txtCodeSetName']");
    
    By DiagnosisCodeSetsRecordMark= By.xpath("//input[@id='txtMark']");
    
    By DiagnosisCodeSetsValidateLink =By.linkText("Validate");
    
    By DiagnosisCodeSetsValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By DiagnosisCodeSetsSaveLink =  By.linkText("Save");
    
    By DiagnosisCodeSetsEditLink = By.linkText("Edit");
    
    By DiagnosisCodeSetsCopyLink = By.linkText("Copy");
    
    By DiagnosisCodeSetsDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By DiagnosisCodeSetsCommLink= By.linkText("Commun.");
        
    By DiagnosisCodeSetsExitLink=  By.linkText("Exit");
    
    
    
    
    public DiagnosisCodeSets(WebDriver driver){
                    this.driver= driver;
                    this.wait = new WebDriverWait(driver, 30);
    }
    
    
	public int searchDiagnosisCodeSets( String DiagnosisCodeSetsCode, String DiagnosisCodeSetsName) throws Exception{
		
		try{
		//enter  Diagnosis Code Sets code
		
	
	
		//enter  Diagnosis Code Sets name
		wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsDescriptionBeginsInput));
		driver.findElement(DiagnosisCodeSetsDescriptionBeginsInput).clear();
		driver.findElement(DiagnosisCodeSetsDescriptionBeginsInput).sendKeys(DiagnosisCodeSetsName);
		System.out.println("entered Name");
		Log.info("log4j msg- entered Name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsSearchButton));
		driver.findElement(DiagnosisCodeSetsSearchButton).click();
		System.out.println("clicked Search");
		Log.info("log4j msg- clicked Search");
		System.out.println("Name:"+DiagnosisCodeSetsName);
		String name = DiagnosisCodeSetsName.trim();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(),'"+name+"')]")));
		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(),'"+name+"')]"));
		e.click();
		System.out.println("Found DiagnosisCodeSets");
		Log.info("log4j msg- Found DiagnosisCodeSets");
	
		return 1;
		}
		
	catch(Exception e){
		
		
	System.out.println("error in searching DiagnosisCodeSets"); return 0;}
		
	}

    //add function
    public void addDiagnosisCodeSets( String DiagnosisCodeSetsCode, String DiagnosisCodeSetsDescription)throws Exception{
    
                    try{ 
                     
                    int i= searchDiagnosisCodeSets( DiagnosisCodeSetsCode, DiagnosisCodeSetsDescription);
            		
            		if (i==0){
            			System.out.println("Diagnosis Code Sets not found, Continue with Add");
            			Log.info("log4j msg- Diagnosis Code Sets not found, Continue with Add");
            		
            		
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsAddLink));
                    driver.findElement(DiagnosisCodeSetsAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                   
                    
                    System.out.println("Diagnosis Code Sets description"+DiagnosisCodeSetsDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsDescriptionInput));
                    driver.findElement(DiagnosisCodeSetsDescriptionInput).sendKeys(DiagnosisCodeSetsDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsValidateLink));
                    driver.findElement(DiagnosisCodeSetsValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsValidateSaveOKButton));
                    driver.findElement(DiagnosisCodeSetsValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
            		
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsSaveLink));
                    driver.findElement(DiagnosisCodeSetsSaveLink).click();
                    Thread.sleep(2000);
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                    Thread.sleep(1000);
                    
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                      driver.quit();
                    
                    } else{
            			System.out.println("Diagnosis Code Set is already present, cannot add DiagnosisCodeSets");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsExitLink));
            			driver.findElement(DiagnosisCodeSetsExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			 Thread.sleep(1000);
            			
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
            			 driver.quit(); 
            		}
    
                    }catch (Exception e){System.out.println("Error in Adding DiagnosisCodeSets"); Log.info("Error in Adding DiagnosisCodeSets");driver.quit();}
            		}
                    
    //copy function
    
    public void copyDiagnosisCodeSets( String DiagnosisCodeSetsCode, String DiagnosisCodeSetsName, String newDiagnosisCodeSetsCode, String newDiagnosisCodeSetsDescription)throws Exception{
                    
                    try{ 
                    
                    int i= searchDiagnosisCodeSets(DiagnosisCodeSetsCode, DiagnosisCodeSetsName);
            		
            		if (i==1){
            			System.out.println("Diagnosis Code Sets found, continue with copy");
            			Log.info("log4j msg-Diagnosis Code Sets found, continue with copy");
            		
                    
                    System.out.println("Diagnosis Code name code"+DiagnosisCodeSetsName);
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodeSetsName+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodeSetsName+"']")).click();
                    System.out.println("clicked Diagnosis Code Sets Code");
                    Log.info("log4j msg- clicked Diagnosis Code Sets code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsCopyLink));
                    driver.findElement(DiagnosisCodeSetsCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("Diagnosis Code Sets newcode"+newDiagnosisCodeSetsCode);
                    
                   
    
                    System.out.println("Diagnosis Code Sets new description"+newDiagnosisCodeSetsDescription);
    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsDescriptionInput));
                    driver.findElement(DiagnosisCodeSetsDescriptionInput).clear();
                    driver.findElement(DiagnosisCodeSetsDescriptionInput).sendKeys(newDiagnosisCodeSetsDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsSaveLink));
                    driver.findElement(DiagnosisCodeSetsSaveLink).click();

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                      driver.quit(); 
            		
                    
            		
                    } else{
            			System.out.println("Diagnosis Code Sets is already present, cannot copy DiagnosisCodeSets");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsExitLink));
            			driver.findElement(DiagnosisCodeSetsExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			 Thread.sleep(1000);
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
            			 driver.quit(); 
            		}
    
                    }catch (Exception e){System.out.println("error in copying DiagnosisCodeSets"); }
            		}
            		
            		
    
    
    

    
    //edit function
public void editDiagnosisCodeSets( String DiagnosisCodeSetsCode, String diagnosisCodeSetsDescription, String recordMark)throws Exception{
                    
                    try{ 
                   
                    int i= searchDiagnosisCodeSets( DiagnosisCodeSetsCode, diagnosisCodeSetsDescription);
            		
            		if (i==1){
            			System.out.println("Diagnosis Code Sets  found, Continue with edit");
            			Log.info("log4j msg- Diagnosis Code Sets  found, Continue with edit");
            	
            		
            		 System.out.println("Diagnosis Code Sets code"+DiagnosisCodeSetsCode);
                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+diagnosisCodeSetsDescription+"']")));
                     driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+diagnosisCodeSetsDescription+"']")).click();
                     System.out.println("clicked Diagnosis Code Sets Record Mark");
                     Log.info("log4j msg- clicked Diagnosis Code Sets Record Mark");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsEditLink));
                    driver.findElement(DiagnosisCodeSetsEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("Diagnosis Code Sets Record Mark"+recordMark);
                                                   
    //enter record mark
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsRecordMark));
                    System.out.println("current description: "+driver.findElement(DiagnosisCodeSetsRecordMark).getText());
                    driver.findElement(DiagnosisCodeSetsRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(DiagnosisCodeSetsRecordMark).sendKeys(recordMark);
                    System.out.println("Entered Record Mark");
                    Log.info("log4j msg- Entered Record Mark");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsSaveLink));
                    driver.findElement(DiagnosisCodeSetsSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(1000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                      driver.quit(); 
            		
            		} else{System.out.println(" Not found, cannot edit"); 
            		Log.info("log4j msg- Not Found, cannot edit"); 
            		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
            		driver.quit(); }
            		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Diagnosis Code Sets ");
                    Log.info("log4j msg- Error in Editing Diagnosis Code Sets ");  
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                    driver.quit(); }
    
    
                    }
    //exit function
    public void exitDiagnosisCodeSets( String DiagnosisCodeSetsCode) throws Exception{
    try{  System.out.println("Diagnosis Code Sets code"+DiagnosisCodeSetsCode);
                                     Thread.sleep(1000);
                                    driver.findElement(DiagnosisCodeSetsExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  Diagnosis Code Sets ");
                                    Log.info("log4j msg- clicked exit in  Diagnosis Code Sets ");   
                                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
                                    driver.quit(); 
                                     
    	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Diagnosis Code Sets ");
    Log.info("log4j msg- Error in Editing Diagnosis Code Sets ");   
    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
    driver.quit(); }}
    
    //add comm function
    public void addCommDiagnosisCodeSets( String DiagnosisCodeSetsCode, String DiagnosisCodeSetsName, String DiagnosisCodeSetsCommsubject, String DiagnosisCodeSetsCommNoteType, String DiagnosisCodeSetsCommMedium, String DiagnosisCodeSetsCommDetails) throws Exception{
                    
                    try{        
                     
                    int i= searchDiagnosisCodeSets( DiagnosisCodeSetsCode, DiagnosisCodeSetsName);
            		
            		if (i==1){
            			System.out.println("Diagnosis Code Sets not found, Continue with Add Comm");
            			Log.info("log4j msg- Diagnosis Code Sets not found, Continue with Add Comm");
            		
            		
                    System.out.println("Diagnosis Code Sets code"+DiagnosisCodeSetsName);
                                    //find DiagnosisCodeSets
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodeSetsName+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+DiagnosisCodeSetsName+"']")).click();
                    System.out.println("clicked Diagnosis Code Sets Code");
                    Log.info("log4j msg- clicked Diagnosis Code Sets code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsCommLink));
                    driver.findElement(DiagnosisCodeSetsCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                                                    
                                                    
                                                    //click add
                                                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                                    driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                                    
                                                     System.out.println("clicked Add");
                                                    Log.info("log4j msg- clicked Add");
                                                    
                                                    //enter subject
                                                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                    driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(DiagnosisCodeSetsCommsubject);
                                                    System.out.println("entered subject");
                                                    Log.info("log4j msg- entered subject");
                                                    
                                                    
                                                    //page down
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtFollowup']")));
                                                    driver.findElement(By.xpath("//input[@id='txtFollowup']")).sendKeys(Keys.PAGE_DOWN);
                                                    System.out.println("clicked page down");
                                                    Log.info("log4j msg- clicked page down");
                                                    
                                                    
                                                    
                                                    
                                                    //click add details
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@data-ng-click='addChildRecord()'])[2]")));
                                                    driver.findElement(By.xpath("(//button[@data-ng-click='addChildRecord()'])[2]")).click();
                                                    System.out.println("clicked add details");
                                                    Log.info("log4j msg- clicked add details");
                                                    
                                                    Thread.sleep(1000);
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType"))); 
                                                    Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                                    placeOfService.selectByVisibleText(DiagnosisCodeSetsCommNoteType);
                                                    System.out.println("selected note type");
                                                    Log.info("log4j msg-selected note type");
                                                    
                                                    Thread.sleep(1000);
                                                    //enter note details
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                    driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(DiagnosisCodeSetsCommDetails);
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
                                         
                                                    }
            		driver.quit();
                                                    
            		}catch (Exception e){e.printStackTrace();System.out.println("error in adding Comm to DiagnosisCodeSets");
                     Log.info("log4j msg - error in adding Comm to  DiagnosisCodeSets"); 
                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();  
                     }   
                                     
                                     }
                    
    
    
    //delete function
    public void deleteDiagnosisCodeSets( String DiagnosisCodeSetsCode, String DiagnosisCodeSetsDescription) throws Exception{
                    
                    try{         
                    	             
                    int i= searchDiagnosisCodeSets( DiagnosisCodeSetsCode, DiagnosisCodeSetsDescription);
            		
            		if (i==1){
            			System.out.println("Diagnosis Code Sets found, continue with delete");
            			Log.info("log4j msg-Diagnosis Code Sets found, continue with delete");
            			
                                               //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsDeleteLink));
                                                    driver.findElement(DiagnosisCodeSetsDeleteLink).click();
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
                                                    
                                                    
                    


    
    
} else{
	System.out.println("cannot find Diagnosis Code Sets ");
	Log.info("log4j msg- cannot find Diagnosis Code Sets ");
	wait.until(ExpectedConditions.visibilityOfElementLocated(DiagnosisCodeSetsExitLink));
	driver.findElement(DiagnosisCodeSetsExitLink).click();
	System.out.println("clicked Exit");
	Log.info("log4j msg- clicked Exit");
	 Thread.sleep(1000);
	
	 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 

	
}} catch (Exception e){
	e.printStackTrace();
System.out.println("error in deleting Diagnosis Code Sets ");
Log.info("log4j msg - error in deleting Diagnosis Code Sets "); 
BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 


}   
    }


}
  




	