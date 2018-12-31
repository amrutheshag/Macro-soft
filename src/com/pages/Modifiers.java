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

public class Modifiers {

	WebDriver driver;
	WebDriverWait wait ;  
	
	By ModifiersCodeBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.modifier']");
	
	By ModifiersNameDescriptionBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.name']");
	
	By ModifiersSearchButton= By.xpath("//button[@ng-click='search()']");
     
    By ModifiersAddLink= By.linkText("Add");
    
    By ModifiersCodeInput = By.xpath("//input[@id='txtModifier']");
    
    By ModifiersDescriptionInput= By.xpath("//input[@id='txtName']");
    
    By ModifiersRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By ModifiersValidateLink =By.linkText("Validate");
        
    By ModifiersValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By ModifiersSaveLink =  By.linkText("Save");
    
    By ModifiersEditLink = By.linkText("Edit");
    
    By ModifiersCopyLink = By.linkText("Copy");
    
    By ModifiersDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By ModifiersCommLink= By.linkText("Commun.");
   
   
    
    By ModifiersExitLink=  By.linkText("Exit");
    
    
    
    public Modifiers(WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver, 50);  
}


public int searchModifiers( String ModifiersCode, String ModifiersName) throws Exception{
 
try{
//enter  Modifiers code
wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersCodeBeginsInput));
driver.findElement(ModifiersCodeBeginsInput).clear();
driver.findElement(ModifiersCodeBeginsInput).sendKeys(ModifiersCode);
System.out.println("entered Modifiers  code");
Log.info("log4j msg- entered Modifiers code");


//enter  Modifiers name
wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersNameDescriptionBeginsInput));
driver.findElement(ModifiersNameDescriptionBeginsInput).clear();
driver.findElement(ModifiersNameDescriptionBeginsInput).sendKeys(ModifiersName);
System.out.println("entered Modifiers name");
Log.info("log4j msg- entered Modifiers name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersSearchButton));
driver.findElement(ModifiersSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");
	
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ModifiersCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ModifiersCode+"']"));
e.click();
System.out.println("Found Modifiers");
Log.info("log4j msg- Found Modifiers");

return 1;
}

catch(Exception e){System.out.println("Modifiers not found"); Log.info("log4j msg-Modifiers not found");return 0;}

}

//add function
public void addModifiers( String ModifiersCode, String ModifiersDescription)throws Exception{

        try{ 
        int i= searchModifiers( ModifiersCode, ModifiersDescription);
		
		if (i==0){
			System.out.println("Modifiers not found, Continue with Add");
			Log.info("log4j msg- Modifiers not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersAddLink));
        driver.findElement(ModifiersAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("Modifiers code: "+ModifiersCode);
        Log.info("log4j msg- Modifiers code: "+ModifiersCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersCodeInput));
        driver.findElement(ModifiersCodeInput).sendKeys(ModifiersCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("Modifiers description"+ModifiersDescription);
        Log.info("log4j msg- Modifiers code: "+ModifiersDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersDescriptionInput));
        driver.findElement(ModifiersDescriptionInput).sendKeys(ModifiersDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersValidateLink));
        driver.findElement(ModifiersValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersValidateSaveOKButton));
        driver.findElement(ModifiersValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersSaveLink));
        driver.findElement(ModifiersSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
        } else{
			System.out.println("Modifiers is already present, cannot add Modifiers");
			Log.info("log4j msg- Modifiers is already present, cannot add Modifiers");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersExitLink));
			driver.findElement(ModifiersExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("error in adding Modifiers");Log.info("log4j msg- error in adding Modifiers"); }
		}
        
//copy function

public void copyModifiers( String ModifiersCode, String ModifiersName, String newModifiersCode, String newModifiersDescription)throws Exception{
        
        try{
        int i= searchModifiers( ModifiersCode, ModifiersName);
		
		if (i==1){
			System.out.println("Modifiers found, continue with copy");
			Log.info("log4j msg-Modifiers found, continue with copy");
		
        
        System.out.println("Modifiers code"+ModifiersCode);
        Log.info("log4j msg-Modifiers code"+ModifiersCode);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ModifiersCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ModifiersCode+"']")).click();
        System.out.println("clicked Modifiers Code");
        Log.info("log4j msg- clicked Modifiers code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersCopyLink));
        driver.findElement(ModifiersCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("Modifiers new code"+newModifiersCode);
        Log.info("log4j msg- Modifiers new code"+newModifiersCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersCodeInput));
        driver.findElement(ModifiersCodeInput).clear();
        driver.findElement(ModifiersCodeInput).sendKeys(newModifiersCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("Modifiers new description"+newModifiersDescription);
        Log.info("log4j msg- Modifiers new description"+newModifiersDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersDescriptionInput));
        driver.findElement(ModifiersDescriptionInput).clear();
        driver.findElement(ModifiersDescriptionInput).sendKeys(newModifiersDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersSaveLink));
        driver.findElement(ModifiersSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
        
		
        } else{
			System.out.println("Modifiers is not present, cannot copy Modifiers");
			Log.info("log4j msg- Modifiers is not present, cannot copy Modifiers");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersExitLink));
			driver.findElement(ModifiersExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			 driver.quit();
		}

        }catch (Exception e){
        	System.out.println("error in copying Modifiers");
        	Log.info("log4j msg- error in copying Modifiers");
        	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
			}
		}
		
		





//edit function
public void editModifiers( String ModifiersCode, String ModifiersDescription, String recordMark)throws Exception{
        
        try{ 
        int i= searchModifiers(ModifiersCode, ModifiersDescription);
		
		if (i==1){
			System.out.println("Modifiers  found, Continue with Edit");
			Log.info("log4j msg- Modifiers  found, Continue with Edit");
		
		
        System.out.println("Modifiers code"+ModifiersCode);
        Log.info("log4j msg- Modifiers code"+ModifiersCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ModifiersCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ModifiersCode+"']")).click();
        System.out.println("clicked Modifiers Record Mark");
        Log.info("log4j msg- clicked Modifiers Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersEditLink));
        driver.findElement(ModifiersEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("Modifiers Record Mark"+recordMark);
        Log.info("log4j msg-Modifiers Record Mark"+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersRecordMark));
        driver.findElement(ModifiersRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(ModifiersRecordMark).sendKeys(recordMark);
        System.out.println("Entered new record mark");
        Log.info("log4j msg- Entered new record mark");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersSaveLink));
        driver.findElement(ModifiersSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}
        
		else{System.out.println("Modifiers not found, cannot edit Modifiers");
        Log.info("log4j msg- Modifiers not found, cannot edit Modifiers");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Modifiers ");
        Log.info("log4j msg- Error in Editing Modifiers ");  
        BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
        driver.quit();}


        }
//exit function
public void exitModifiers( String ModifiersCode) throws Exception{
try{
        System.out.println("Modifiers code"+ModifiersCode);
        Log.info("log4j msg- Modifiers code"+ModifiersCode);
                        Thread.sleep(1000);
                        driver.findElement(ModifiersExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  Modifiers ");
                        Log.info("log4j msg- clicked exit in  Modifiers ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                      
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Modifiers ");
Log.info("log4j msg- Error in Exiting Modifiers ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}

//add comm function
public void addCommModifiers( String ModifiersCode, String ModifiersName, String ModifiersCommsubject, String ModifiersCommNoteType, String ModifiersCommMedium, String ModifiersCommDetails) throws Exception{
        
        try{       
        int i= searchModifiers( ModifiersCode, ModifiersName);
		
		if (i==1){
			System.out.println("Modifiers  found, Continue with Add Communication");
			Log.info("log4j msg- Modifiers  found, Continue with Add Communication");
		
		
        System.out.println("Modifiers code"+ModifiersCode);
        Log.info("log4j msg- Modifiers code"+ModifiersCode);
                        //find Modifiers
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ModifiersCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ModifiersCode+"']")).click();
        System.out.println("clicked Modifiers Code");
        Log.info("log4j msg- clicked Modifiers code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersCommLink));
        driver.findElement(ModifiersCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                        //click add
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                        
                                        System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(ModifiersCommsubject);
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
                                        placeOfService.selectByVisibleText(ModifiersCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(1000);
                                        //enter note details
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(ModifiersCommDetails);
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
                        	 System.out.println("error in adding Comm to Modifiers");
                        	 Log.info("log4j msg - error in adding Comm to  Modifiers"); 
                        	 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                        	 driver.quit();  
                        	 }   
                         
                         }
        


//delete function
public void deleteModifiers( String ModifiersCode, String ModifiersDescription) throws Exception{
        
        try{            
        int i= searchModifiers( ModifiersCode, ModifiersDescription);
		
		if (i==1){
			System.out.println("Modifiers found, continue with delete");
			Log.info("log4j msg-Modifiers found, continue with delete");
			
        //find Modifiers
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ModifiersCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ModifiersCode+"']")).click();
                                        System.out.println("clicked Modifiers Code");
                                        Log.info("log4j msg- clicked Modifiers code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersDeleteLink));
                                        driver.findElement(ModifiersDeleteLink).click();
                                        System.out.println("clicked Delete");
                                        Log.info("log4j msg- clicked Delete");
                                        
        
                                        //click confirm delete
                                        
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                        driver.findElement(confirmDeleteButton).click();
                                        System.out.println("clicked confirm Delete");
                                        Log.info("log4j msg- clicked confirm Delete");
                                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                        
                                        
        




} else{
System.out.println("cannot find Modifiers, cannot delete Modifiers ");
Log.info("log4j msg- cannot find Modifiers, cannot delete Modifiers ");
wait.until(ExpectedConditions.visibilityOfElementLocated(ModifiersExitLink));
driver.findElement(ModifiersExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");


BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();

}} catch (Exception e){System.out.println("error in deleting Modifiers ");
Log.info("log4j msg - error in deleting Modifiers "); 

}   
}


}
