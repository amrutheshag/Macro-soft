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

public class OtherCredentiallingSourceTypes {
 
	WebDriver driver;
	WebDriverWait wait ;  
	
	By OtherCredentiallingSourceTypesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By OtherCredentiallingSourceTypesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By OtherCredentiallingSourceTypesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By OtherCredentiallingSourceTypesAddLink= By.linkText("Add");
    
    By OtherCredentiallingSourceTypesCodeInput = By.xpath("//input[@id='code']");
    
    By OtherCredentiallingSourceTypesDescriptionInput= By.xpath("//input[@id='name']");
    
    By OtherCredentiallingSourceTypesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By OtherCredentiallingSourceTypesValidateLink =By.linkText("Validate");
    
    By OtherCredentiallingSourceTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By OtherCredentiallingSourceTypesSaveLink =  By.linkText("Save");
    
    By OtherCredentiallingSourceTypesEditLink = By.linkText("Edit");
    
    By OtherCredentiallingSourceTypesCopyLink = By.linkText("Copy");
    
    By OtherCredentiallingSourceTypesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By OtherCredentiallingSourceTypesCommLink= By.linkText("Commun.");
    
    By OtherCredentiallingSourceTypesExitLink=  By.linkText("Exit");
    
    
    public OtherCredentiallingSourceTypes(WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver, 40);  
}


public int searchOtherCredentiallingSourceTypes( String OtherCredentiallingSourceTypesCode, String OtherCredentiallingSourceTypesName) throws Exception{

try{
//enter  Other Credentialling Source Types code
wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesCodeBeginsInput));
driver.findElement(OtherCredentiallingSourceTypesCodeBeginsInput).clear();
driver.findElement(OtherCredentiallingSourceTypesCodeBeginsInput).sendKeys(OtherCredentiallingSourceTypesCode);
System.out.println("entered Other Credentialling Source Types  code");
Log.info("log4j msg- entered Other Credentialling Source Types code");


//enter  Other Credentialling Source Types name
wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesNameDescriptionBeginsInput));
driver.findElement(OtherCredentiallingSourceTypesNameDescriptionBeginsInput).clear();
driver.findElement(OtherCredentiallingSourceTypesNameDescriptionBeginsInput).sendKeys(OtherCredentiallingSourceTypesName);
System.out.println("entered Other Credentialling Source Types name");
Log.info("log4j msg- entered Other Credentialling Source Types name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesSearchButton));
driver.findElement(OtherCredentiallingSourceTypesSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OtherCredentiallingSourceTypesCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OtherCredentiallingSourceTypesCode+"']"));
e.click();
System.out.println("Found OtherCredentiallingSourceTypes");
Log.info("log4j msg- Found OtherCredentiallingSourceTypes");

return 1;
}

catch(Exception e){System.out.println("Other Credentialling Source Types not found"); Log.info("log4j msg- Other Credentialling Source Types not found");return 0;}

}

//add function
public void addOtherCredentiallingSourceTypes( String OtherCredentiallingSourceTypesCode, String OtherCredentiallingSourceTypesDescription)throws Exception{

        try{ 
        int i= searchOtherCredentiallingSourceTypes( OtherCredentiallingSourceTypesCode, OtherCredentiallingSourceTypesDescription);
		
		if (i==0){
			System.out.println("Other Credentialling Source Types not found, Continue with Add");
			Log.info("log4j msg- Other Credentialling Source Types not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesAddLink));
        driver.findElement(OtherCredentiallingSourceTypesAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("Other Credentialling Source Types code: "+OtherCredentiallingSourceTypesCode);
        Log.info("log4j msg- Other Credentialling Source Types code: "+OtherCredentiallingSourceTypesCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesCodeInput));
        driver.findElement(OtherCredentiallingSourceTypesCodeInput).sendKeys(OtherCredentiallingSourceTypesCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("Other Credentialling Source Types description"+OtherCredentiallingSourceTypesDescription);
        Log.info("log4j msg- Other Credentialling Source Types code: "+OtherCredentiallingSourceTypesDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesDescriptionInput));
        driver.findElement(OtherCredentiallingSourceTypesDescriptionInput).sendKeys(OtherCredentiallingSourceTypesDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesValidateLink));
        driver.findElement(OtherCredentiallingSourceTypesValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesValidateSaveOKButton));
        driver.findElement(OtherCredentiallingSourceTypesValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesSaveLink));
        driver.findElement(OtherCredentiallingSourceTypesSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
        } else{
			System.out.println("Other Credentialling Source Types is already present, cannot add Other Credentialling Source Types");
			Log.info("log4j msg- Other Credentialling Source Types is already present, cannot add Other Credentialling Source Types");
			wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesExitLink));
			driver.findElement(OtherCredentiallingSourceTypesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in adding Other Credentialling Source Types");Log.info("log4j msg- Error in adding Other Credentialling Source Types"); }
		}
        
//copy function

public void copyOtherCredentiallingSourceTypes( String OtherCredentiallingSourceTypesCode, String OtherCredentiallingSourceTypesName, String newOtherCredentiallingSourceTypesCode, String newOtherCredentiallingSourceTypesDescription)throws Exception{
        
        try{ 
        int i= searchOtherCredentiallingSourceTypes( OtherCredentiallingSourceTypesCode, OtherCredentiallingSourceTypesName);
		
		if (i==1){
			System.out.println("Other Credentialling Source Types found, continue with copy");
			Log.info("log4j msg-Other Credentialling Source Types found, continue with copy");
		
        
        System.out.println("Other Credentialling Source Types code"+OtherCredentiallingSourceTypesCode);
        Log.info("log4j msg-Other Credentialling Source Types code"+OtherCredentiallingSourceTypesCode);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OtherCredentiallingSourceTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OtherCredentiallingSourceTypesCode+"']")).click();
        System.out.println("clicked Other Credentialling Source Types Code");
        Log.info("log4j msg- clicked Other Credentialling Source Types code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesCopyLink));
        driver.findElement(OtherCredentiallingSourceTypesCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("Other Credentialling Source Types new code"+newOtherCredentiallingSourceTypesCode);
        Log.info("log4j msg- Other Credentialling Source Types new code"+newOtherCredentiallingSourceTypesCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesCodeInput));
        driver.findElement(OtherCredentiallingSourceTypesCodeInput).clear();
        driver.findElement(OtherCredentiallingSourceTypesCodeInput).sendKeys(newOtherCredentiallingSourceTypesCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("Other Credentialling Source Types new description"+newOtherCredentiallingSourceTypesDescription);
        Log.info("log4j msg- Other Credentialling Source Types new description"+newOtherCredentiallingSourceTypesDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesDescriptionInput));
        driver.findElement(OtherCredentiallingSourceTypesDescriptionInput).clear();
        driver.findElement(OtherCredentiallingSourceTypesDescriptionInput).sendKeys(newOtherCredentiallingSourceTypesDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesSaveLink));
        driver.findElement(OtherCredentiallingSourceTypesSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
        
		
        } else{
			System.out.println("Other Credentialling Source Types is not present, cannot copy Other Credentialling Source Types");
			Log.info("log4j msg- Other Credentialling Source Types is not present, cannot copy Other Credentialling Source Types");
			wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesExitLink));
			driver.findElement(OtherCredentiallingSourceTypesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in copying Other Credentialling Source Types");Log.info("log4j msg- Error in copying Other Credentialling Source Types"); }
		}
		
		





//edit function
public void editOtherCredentiallingSourceTypes( String OtherCredentiallingSourceTypesCode, String othercredentiallingsourceTypesDescription, String recordMark)throws Exception{
        
        try{ 
        int i= searchOtherCredentiallingSourceTypes( OtherCredentiallingSourceTypesCode, othercredentiallingsourceTypesDescription);
		
		if (i==1){
			System.out.println("Other Credentialling Source Types  found, Continue with Edit");
			Log.info("log4j msg- Other Credentialling Source Types  found, Continue with Edit");
		
		
        System.out.println("Other Credentialling Source Types code"+OtherCredentiallingSourceTypesCode);
        Log.info("log4j msg- Other Credentialling Source Types code"+OtherCredentiallingSourceTypesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OtherCredentiallingSourceTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OtherCredentiallingSourceTypesCode+"']")).click();
        System.out.println("clicked Other Credentialling Source Types Record Mark");
        Log.info("log4j msg- clicked Other Credentialling Source Types Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesEditLink));
        driver.findElement(OtherCredentiallingSourceTypesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("Other Credentialling Source Types Record Mark: "+recordMark);
        Log.info("log4j msg-Other Credentialling Source Types Record Mark: "+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesRecordMark));
        driver.findElement(OtherCredentiallingSourceTypesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(OtherCredentiallingSourceTypesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesSaveLink));
        driver.findElement(OtherCredentiallingSourceTypesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}
        
		else{System.out.println("Other Credentialling Source Types not found, cannot edit Other Credentialling Source Types");
        Log.info("log4j msg- Other Credentialling Source Types not found, cannot edit Other Credentialling Source Types");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Other Credentialling Source Types ");
        Log.info("log4j msg- Error in Editing Other Credentialling Source Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}


        }
//exit function
public void exitOtherCredentiallingSourceTypes( String OtherCredentiallingSourceTypesCode) throws Exception{
try{
        System.out.println("Other Credentialling Source Types code"+OtherCredentiallingSourceTypesCode);
        Log.info("log4j msg- Other Credentialling Source Types code"+OtherCredentiallingSourceTypesCode);
                      Thread.sleep(1000);
                        driver.findElement(OtherCredentiallingSourceTypesExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  Other Credentialling Source Types ");
                        Log.info("log4j msg- clicked exit in  Other Credentialling Source Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
      
                        
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Other Credentialling Source Types ");
Log.info("log4j msg- Error in Exiting Other Credentialling Source Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}

//add comm function
public void addCommOtherCredentiallingSourceTypes( String OtherCredentiallingSourceTypesCode, String OtherCredentiallingSourceTypesName, String OtherCredentiallingSourceTypesCommsubject, String OtherCredentiallingSourceTypesCommNoteType, String OtherCredentiallingSourceTypesCommMedium, String OtherCredentiallingSourceTypesCommDetails) throws Exception{
        
        try{  
        int i= searchOtherCredentiallingSourceTypes( OtherCredentiallingSourceTypesCode, OtherCredentiallingSourceTypesName);
		
		if (i==1){
			System.out.println("Other Credentialling Source Types  found, Continue with Add Communication");
			Log.info("log4j msg- Other Credentialling Source Types  found, Continue with Add Communication");
		
		
        System.out.println("Other Credentialling Source Types code"+OtherCredentiallingSourceTypesCode);
        Log.info("log4j msg- Other Credentialling Source Types code"+OtherCredentiallingSourceTypesCode);
                        //find OtherCredentiallingSourceTypes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OtherCredentiallingSourceTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OtherCredentiallingSourceTypesCode+"']")).click();
        System.out.println("clicked Other Credentialling Source Types Code");
        Log.info("log4j msg- clicked Other Credentialling Source Types code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesCommLink));
        driver.findElement(OtherCredentiallingSourceTypesCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                        //click add
                                       
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                        
                                        
                                        System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(OtherCredentiallingSourceTypesCommsubject);
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
                                        Select othercredentiallingsourceTypes = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                        othercredentiallingsourceTypes.selectByVisibleText(OtherCredentiallingSourceTypesCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(2000);
                                        //enter note details
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(OtherCredentiallingSourceTypesCommDetails);
                                        System.out.println("entered notes details");
                                        Log.info("log4j msg- entered notes details");
                                        Thread.sleep(2000);
                                        
                                        
                                        //click hide
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='closeMe()']")));
                                        driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
                                        System.out.println("clicked hide");
                                        Log.info("log4j msg- clicked hide");
                                   Thread.sleep(2000);
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
                                        Thread.sleep(2000);
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
                                        
                         catch (Exception e){
                        	 e.printStackTrace();
                        	 System.out.println("Error in adding Comm to Other Credentialling Source Types");
         Log.info("log4j msg - Error in adding Comm to  Other Credentialling Source Types"); 
         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
         driver.quit();   }   
                         
                         }
        


//delete function
public void deleteOtherCredentiallingSourceTypes( String OtherCredentiallingSourceTypesCode, String OtherCredentiallingSourceTypesDescription) throws Exception{
        
        try{           
        int i= searchOtherCredentiallingSourceTypes(OtherCredentiallingSourceTypesCode, OtherCredentiallingSourceTypesDescription);
		
		if (i==1){
			System.out.println("Other Credentialling Source Types found, continue with delete");
			Log.info("log4j msg-Other Credentialling Source Types found, continue with delete");
			
        //find OtherCredentiallingSourceTypes
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OtherCredentiallingSourceTypesCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+OtherCredentiallingSourceTypesCode+"']")).click();
                                        System.out.println("clicked Other Credentialling Source Types Code");
                                        Log.info("log4j msg- clicked Other Credentialling Source Types code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesDeleteLink));
                                        driver.findElement(OtherCredentiallingSourceTypesDeleteLink).click();
                                        System.out.println("clicked Delete");
                                        Log.info("log4j msg- clicked Delete");
                                        
        
                                        //click confirm delete
                                        
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                        driver.findElement(confirmDeleteButton).click();
                                        System.out.println("clicked confirm Delete");
                                        Log.info("log4j msg- clicked confirm Delete");
                                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                        
                                        
        




} else{
System.out.println("cannot find Other Credentialling Source Types, cannot delete Other Credentialling Source Types ");
Log.info("log4j msg- cannot find Other Credentialling Source Types, cannot delete Other Credentialling Source Types ");
wait.until(ExpectedConditions.visibilityOfElementLocated(OtherCredentiallingSourceTypesExitLink));
driver.findElement(OtherCredentiallingSourceTypesExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");


BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();

}} catch (Exception e){System.out.println("Error in deleting Other Credentialling Source Types ");
Log.info("log4j msg - Error in deleting Other Credentialling Source Types "); 

}   
}

}




