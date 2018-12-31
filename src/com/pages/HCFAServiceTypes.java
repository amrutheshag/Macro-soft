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

public class HCFAServiceTypes {

	WebDriver driver;
	WebDriverWait wait ;

	By HCFAServiceTypesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By HCFAServiceTypesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By HCFAServiceTypesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By HCFAServiceTypesAddLink= By.linkText("Add");
    
    By HCFAServiceTypesCodeInput = By.xpath("//input[@id='code']");
   
    By HCFAServiceTypesDescriptionInput= By.xpath("//input[@id='name']");
    
    By HCFAServiceTypesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By HCFAServiceTypesValidateLink =By.linkText("Validate");
    
    By HCFAServiceTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By HCFAServiceTypesSaveLink =  By.linkText("Save");
    
    By HCFAServiceTypesEditLink = By.linkText("Edit");
    
    By HCFAServiceTypesCopyLink = By.linkText("Copy");
    
    By HCFAServiceTypesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By HCFAServiceTypesCommLink= By.linkText("Commun.");
    
    By HCFAServiceTypesExitLink=  By.linkText("Exit");
    
    
    
    
    public HCFAServiceTypes(WebDriver driver){
                    this.driver= driver;
                    this.wait= new WebDriverWait(driver, 20);
    }
    
    
	public int searchHCFAServiceTypes( String HCFAServiceTypesCode, String HCFAServiceTypesName) throws Exception{
				try{
		//enter  HCFA Service Types code
		wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesCodeBeginsInput));
		driver.findElement(HCFAServiceTypesCodeBeginsInput).clear();
		driver.findElement(HCFAServiceTypesCodeBeginsInput).sendKeys(HCFAServiceTypesCode);
		System.out.println("entered HCFA Service Types  code");
		Log.info("log4j msg- entered HCFA Service Types code");
	
	
		//enter  HCFA Service Types name
		wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesNameDescriptionBeginsInput));
		driver.findElement(HCFAServiceTypesNameDescriptionBeginsInput).clear();
		driver.findElement(HCFAServiceTypesNameDescriptionBeginsInput).sendKeys(HCFAServiceTypesName);
		System.out.println("entered HCFA Service Types name");
		Log.info("log4j msg- entered HCFA Service Types name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesSearchButton));
		driver.findElement(HCFAServiceTypesSearchButton).click();
		System.out.println("clicked Search");
		Log.info("log4j msg- clicked Search");
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+HCFAServiceTypesCode+"']")));
		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+HCFAServiceTypesCode+"']"));
		e.click();
		System.out.println("Found HCFAServiceTypes");
		Log.info("log4j msg- Found HCFAServiceTypes");
	
		return 1;
		}
		
	catch(Exception e){System.out.println("HCFA Service Types not found"); 
	Log.info("log4j msg-HCFA Service Types not found");return 0;}
		
	}

    //add function
    public void addHCFAServiceTypes( String HCFAServiceTypesCode, String HCFAServiceTypesDescription)throws Exception{
    
                    try{
                    int i= searchHCFAServiceTypes( HCFAServiceTypesCode, HCFAServiceTypesDescription);
            		
            		if (i==0){
            			System.out.println("HCFA Service Types not found, Continue with Add");
            			Log.info("log4j msg- HCFA Service Types not found, Continue with Add");
            		
            		
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesAddLink));
                    driver.findElement(HCFAServiceTypesAddLink).click();
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                    
                    
                    System.out.println("HCFA Service Types code: "+HCFAServiceTypesCode);
                    Log.info("log4j msg- HCFA Service Types code: "+HCFAServiceTypesCode);
                    //enter code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesCodeInput));
                    driver.findElement(HCFAServiceTypesCodeInput).sendKeys(HCFAServiceTypesCode);
                    Thread.sleep(1000);
                    System.out.println("Entered code");
                    Log.info("log4j msg- Entered code");
                    
                    System.out.println("HCFA Service Types description"+HCFAServiceTypesDescription);
                    Log.info("log4j msg- HCFA Service Types code: "+HCFAServiceTypesDescription);
                    //enter Description
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesDescriptionInput));
                    driver.findElement(HCFAServiceTypesDescriptionInput).sendKeys(HCFAServiceTypesDescription);
                    Thread.sleep(1000);
                    System.out.println("Entered description");
                    Log.info("log4j msg- Entered description");
    
                    
                    //click validate
    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesValidateLink));
                    driver.findElement(HCFAServiceTypesValidateLink).click();
                    System.out.println("clicked validate");
                    Log.info("log4j msg- clicked validate");
                    
                    //click ok
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesValidateSaveOKButton));
                    driver.findElement(HCFAServiceTypesValidateSaveOKButton).click();
                    System.out.println("clicked validate ok to save button");
                    Log.info("log4j msg- clicked validate ok to save button");
                    
            		
                    //click save
                    Thread.sleep(1000);
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesSaveLink));
                    driver.findElement(HCFAServiceTypesSaveLink).click();
                    System.out.println("clicked save ");
                    Log.info("log4j msg- clicked  save ");
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                    
                    } else{
            			System.out.println("HCFA Service Types is already present, cannot add HCFA Service Types");
            			Log.info("log4j msg- HCFA Service Types is already present, cannot add HCFA Service Types");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesExitLink));
            			driver.findElement(HCFAServiceTypesExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
    
                    }catch (Exception e){System.out.println("error in adding HCFA Service Types");Log.info("log4j msg- error in adding HCFA Service Types"); }
            		}
                    
    //copy function
    
    public void copyHCFAServiceTypes( String HCFAServiceTypesCode, String HCFAServiceTypesName, String newHCFAServiceTypesCode, String newHCFAServiceTypesDescription)throws Exception{
                    
                    try{  int i= searchHCFAServiceTypes( HCFAServiceTypesCode, HCFAServiceTypesName);
            		
            		if (i==1){
            			System.out.println("HCFA Service Types found, continue with copy");
            			Log.info("log4j msg-HCFA Service Types found, continue with copy");
            		
                    
                    System.out.println("HCFA Service Types code"+HCFAServiceTypesCode);
                    Log.info("log4j msg-HCFA Service Types code"+HCFAServiceTypesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+HCFAServiceTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+HCFAServiceTypesCode+"']")).click();
                    System.out.println("clicked HCFA Service Types Code");
                    Log.info("log4j msg- clicked HCFA Service Types code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesCopyLink));
                    driver.findElement(HCFAServiceTypesCopyLink).click();
                    System.out.println("clicked Copy");
                    Log.info("log4j msg- clicked Copy");
                    
                    System.out.println("HCFA Service Types new code"+newHCFAServiceTypesCode);
                    Log.info("log4j msg- HCFA Service Types new code"+newHCFAServiceTypesCode);
                    //enter new code
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesCodeInput));
                    driver.findElement(HCFAServiceTypesCodeInput).clear();
                    driver.findElement(HCFAServiceTypesCodeInput).sendKeys(newHCFAServiceTypesCode);
                    System.out.println("Entered new code");
                    Log.info("log4j msg- Entered new code");
    
                    System.out.println("HCFA Service Types new description"+newHCFAServiceTypesDescription);
                    Log.info("log4j msg- HCFA Service Types new description"+newHCFAServiceTypesDescription);
    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesDescriptionInput));
                    driver.findElement(HCFAServiceTypesDescriptionInput).clear();
                    driver.findElement(HCFAServiceTypesDescriptionInput).sendKeys(newHCFAServiceTypesDescription);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesSaveLink));
                    driver.findElement(HCFAServiceTypesSaveLink).click();

                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		
                    
            		
                    } else{
            			System.out.println("HCFA Service Types is not present, cannot copy HCFA Service Types");
            			Log.info("log4j msg- HCFA Service Types is not present, cannot copy HCFA Service Types");
            			wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesExitLink));
            			driver.findElement(HCFAServiceTypesExitLink).click();
            			System.out.println("clicked Exit");
            			Log.info("log4j msg- clicked Exit");
            			
            			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
    
                    }catch (Exception e){System.out.println("error in copying HCFA Service Types");Log.info("log4j msg- error in copying HCFA Service Types"); }
            		}
            		
            		
    
    
    

    
    //edit function
public void editHCFAServiceTypes( String HCFAServiceTypesCode, String hcfaserviceTypesDescription, String recordMark)throws Exception{
                    
                    try{ 
                    int i= searchHCFAServiceTypes( HCFAServiceTypesCode, hcfaserviceTypesDescription);
            		
            		if (i==1){
            			System.out.println("HCFA Service Types  found, Continue with Edit");
            			Log.info("log4j msg- HCFA Service Types  found, Continue with Edit");
            		
            		
                    System.out.println("HCFA Service Types code"+HCFAServiceTypesCode);
                    Log.info("log4j msg- HCFA Service Types code"+HCFAServiceTypesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+HCFAServiceTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+HCFAServiceTypesCode+"']")).click();
                    System.out.println("clicked HCFA Service Types Record Mark");
                    Log.info("log4j msg- clicked HCFA Service Types Record Mark");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesEditLink));
                    driver.findElement(HCFAServiceTypesEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("HCFA Service Types Record Mark"+recordMark);
                    Log.info("log4j msg-HCFA Service Types Record Mark"+recordMark);
                                                   
    //enter new description
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesRecordMark));
                    driver.findElement(HCFAServiceTypesRecordMark).clear();
                    Thread.sleep(1000);
                    driver.findElement(HCFAServiceTypesRecordMark).sendKeys(recordMark);
                    System.out.println("Entered new description");
                    Log.info("log4j msg- Entered new description");
                    
                    
                    
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesSaveLink));
                    driver.findElement(HCFAServiceTypesSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
                    
            		else{System.out.println("HCFA Service Types not found, cannot edit HCFA Service Types");
                    Log.info("log4j msg- HCFA Service Types not found, cannot edit HCFA Service Types");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
            		
            		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing HCFA Service Types ");
                    Log.info("log4j msg- Error in Editing HCFA Service Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
    
                    }
    //exit function
    public void exitHCFAServiceTypes( String HCFAServiceTypesCode) throws Exception{
    try{
                     System.out.println("HCFA Service Types code"+HCFAServiceTypesCode);
                    Log.info("log4j msg- HCFA Service Types code"+HCFAServiceTypesCode);
                                    Thread.sleep(1000);
                                    driver.findElement(HCFAServiceTypesExitLink).click();
                                    Thread.sleep(1000);
                                    System.out.println("Clicked exit in  HCFA Service Types ");
                                    Log.info("log4j msg- clicked exit in  HCFA Service Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                
    	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting HCFA Service Types ");
    Log.info("log4j msg- Error in Exiting HCFA Service Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
    
    //add comm function
    public void addCommHCFAServiceTypes( String HCFAServiceTypesCode, String HCFAServiceTypesName, String HCFAServiceTypesCommsubject, String HCFAServiceTypesCommNoteType, String HCFAServiceTypesCommMedium, String HCFAServiceTypesCommDetails) throws Exception{
                    
                    try{                     int i= searchHCFAServiceTypes( HCFAServiceTypesCode, HCFAServiceTypesName);
            		
            		if (i==1){
            			System.out.println("HCFA Service Types  found, Continue with Add Communication");
            			Log.info("log4j msg- HCFA Service Types  found, Continue with Add Communication");
            		
            		
                    System.out.println("HCFA Service Types code"+HCFAServiceTypesCode);
                    Log.info("log4j msg- HCFA Service Types code"+HCFAServiceTypesCode);
                                    //find HCFAServiceTypes
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+HCFAServiceTypesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+HCFAServiceTypesCode+"']")).click();
                    System.out.println("clicked HCFA Service Types Code");
                    Log.info("log4j msg- clicked HCFA Service Types code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesCommLink));
                    driver.findElement(HCFAServiceTypesCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                                                    
                                                    
                                                    //click add
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                                    driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                                    
                                                    System.out.println("clicked Add");
                                                    Log.info("log4j msg- clicked Add");
                                                    
                                                    //enter subject
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                    driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(HCFAServiceTypesCommsubject);
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
                                                    
                                                    Thread.sleep(1000);
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType"))); 
                                                    Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                                    placeOfService.selectByVisibleText(HCFAServiceTypesCommNoteType);
                                                    System.out.println("selected note type");
                                                    Log.info("log4j msg-selected note type");
                                                    
                                                    Thread.sleep(1000);
                                                    //enter note details
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                    driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(HCFAServiceTypesCommDetails);
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
                                                    
                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
                                                    
                                     catch (Exception e){
                                    	 e.printStackTrace();
                                    	 System.out.println("error in adding Comm to HCFA Service Types");
                                         Log.info("log4j msg - error in adding Comm to  HCFA Service Types"); 
                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                     driver.quit();   }   
                                     
                                     }
                    
    
    
    //delete function
    public void deleteHCFAServiceTypes( String HCFAServiceTypesCode, String HCFAServiceTypesDescription) throws Exception{
                    
                    try{             
                    int i= searchHCFAServiceTypes( HCFAServiceTypesCode, HCFAServiceTypesDescription);
            		
            		if (i==1){
            			System.out.println("HCFA Service Types found, continue with delete");
            			Log.info("log4j msg-HCFA Service Types found, continue with delete");
            			
                    //find HCFAServiceTypes
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+HCFAServiceTypesCode+"']")));
                                                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+HCFAServiceTypesCode+"']")).click();
                                                    System.out.println("clicked HCFA Service Types Code");
                                                    Log.info("log4j msg- clicked HCFA Service Types code");
                                    
                                                    //click delete
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesDeleteLink));
                                                    driver.findElement(HCFAServiceTypesDeleteLink).click();
                                                    System.out.println("clicked Delete");
                                                    Log.info("log4j msg- clicked Delete");
                                                    
                    
                                                    //click confirm delete
                                                    
                                                    
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                    driver.findElement(confirmDeleteButton).click();
                                                    System.out.println("clicked confirm Delete");
                                                    Log.info("log4j msg- clicked confirm Delete");
                                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                                    
                                                    
                    


    
    
} else{
	System.out.println("cannot find HCFA Service Types, cannot delete HCFA Service Types ");
	Log.info("log4j msg- cannot find HCFA Service Types, cannot delete HCFA Service Types ");
	wait.until(ExpectedConditions.visibilityOfElementLocated(HCFAServiceTypesExitLink));
	driver.findElement(HCFAServiceTypesExitLink).click();
	System.out.println("clicked Exit");
	Log.info("log4j msg- clicked Exit");
	
	
	 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	
}} catch (Exception e){System.out.println("error in deleting HCFA Service Types ");
Log.info("log4j msg - error in deleting HCFA Service Types "); 

}   
    }


}