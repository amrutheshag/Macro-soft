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

public class URCaseProblemTypes {

	WebDriver driver;
	WebDriverWait wait;  
	
	By URCaseProblemTypesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By URCaseProblemTypesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By URCaseProblemTypesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By URCaseProblemTypesAddLink= By.linkText("Add");
    
    By URCaseProblemTypesCodeInput = By.xpath("//input[@id='code']");
    
    By URCaseProblemTypesDescriptionInput= By.xpath("//input[@id='name']");
    
    By URCaseProblemTypesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By URCaseProblemTypesValidateLink =By.linkText("Validate");
    
    By URCaseProblemTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By URCaseProblemTypesSaveLink =  By.linkText("Save");
    
    By URCaseProblemTypesEditLink = By.linkText("Edit");
    
    By URCaseProblemTypesCopyLink = By.linkText("Copy");
    
    By URCaseProblemTypesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By URCaseProblemTypesCommLink= By.linkText("Commun.");
    
    By URCaseProblemTypesExitLink=  By.linkText("Exit");
    
    
    
    
    public URCaseProblemTypes(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, 35);  
}


public int searchURCaseProblemTypes( String URCaseProblemTypesCode, String URCaseProblemTypesName) throws Exception{

try{
//enter  UR Case/Problem Types code
wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesCodeBeginsInput));
driver.findElement(URCaseProblemTypesCodeBeginsInput).clear();
driver.findElement(URCaseProblemTypesCodeBeginsInput).sendKeys(URCaseProblemTypesCode);
System.out.println("entered UR Case/Problem Types  code");
Log.info("log4j msg- entered UR Case/Problem Types code");


//enter  UR Case/Problem Types name
wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesNameDescriptionBeginsInput));
driver.findElement(URCaseProblemTypesNameDescriptionBeginsInput).clear();
driver.findElement(URCaseProblemTypesNameDescriptionBeginsInput).sendKeys(URCaseProblemTypesName);
System.out.println("entered UR Case/Problem Types name");
Log.info("log4j msg- entered UR Case/Problem Types name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesSearchButton));
driver.findElement(URCaseProblemTypesSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");
	
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+URCaseProblemTypesCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+URCaseProblemTypesCode+"']"));
e.click();
System.out.println("Found URCaseProblemTypes");
Log.info("log4j msg- Found URCaseProblemTypes");

return 1;
}

catch(Exception e){System.out.println("UR Case/Problem Types Not found"); Log.info("log4j msg- UR Case/Problem Types Not found");return 0;}

}

//add function
public void addURCaseProblemTypes( String URCaseProblemTypesCode, String URCaseProblemTypesDescription)throws Exception{

        try{  
        int i= searchURCaseProblemTypes( URCaseProblemTypesCode, URCaseProblemTypesDescription);
		
		if (i==0){
			System.out.println("UR Case/Problem Types not found, Continue with Add");
			Log.info("log4j msg- UR Case/Problem Types not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesAddLink));
        driver.findElement(URCaseProblemTypesAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("UR Case/Problem Types code: "+URCaseProblemTypesCode);
        Log.info("log4j msg- UR Case/Problem Types code: "+URCaseProblemTypesCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesCodeInput));
        driver.findElement(URCaseProblemTypesCodeInput).sendKeys(URCaseProblemTypesCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("UR Case/Problem Types description"+URCaseProblemTypesDescription);
        Log.info("log4j msg- UR Case/Problem Types code: "+URCaseProblemTypesDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesDescriptionInput));
        driver.findElement(URCaseProblemTypesDescriptionInput).sendKeys(URCaseProblemTypesDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesValidateLink));
        driver.findElement(URCaseProblemTypesValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesValidateSaveOKButton));
        driver.findElement(URCaseProblemTypesValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesSaveLink));
        driver.findElement(URCaseProblemTypesSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
        } else{
			System.out.println("UR Case/Problem Types is already present, cannot add UR Case/Problem Types");
			Log.info("log4j msg- UR Case/Problem Types is already present, cannot add UR Case/Problem Types");
			wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesExitLink));
			driver.findElement(URCaseProblemTypesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in adding UR Case/Problem Types");Log.info("log4j msg- Error in adding UR Case/Problem Types"); }
		}
        
//copy function

public void copyURCaseProblemTypes( String URCaseProblemTypesCode, String URCaseProblemTypesName, String newURCaseProblemTypesCode, String newURCaseProblemTypesDescription)throws Exception{
        
        try{ 
        int i= searchURCaseProblemTypes( URCaseProblemTypesCode, URCaseProblemTypesName);
		
		if (i==1){
			System.out.println("UR Case/Problem Types found, continue with copy");
			Log.info("log4j msg-UR Case/Problem Types found, continue with copy");
		
        
        System.out.println("UR Case/Problem Types code"+URCaseProblemTypesCode);
        Log.info("log4j msg-UR Case/Problem Types code"+URCaseProblemTypesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+URCaseProblemTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+URCaseProblemTypesCode+"']")).click();
        System.out.println("clicked UR Case/Problem Types Code");
        Log.info("log4j msg- clicked UR Case/Problem Types code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesCopyLink));
        driver.findElement(URCaseProblemTypesCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("UR Case/Problem Types new code"+newURCaseProblemTypesCode);
        Log.info("log4j msg- UR Case/Problem Types new code"+newURCaseProblemTypesCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesCodeInput));
        driver.findElement(URCaseProblemTypesCodeInput).clear();
        driver.findElement(URCaseProblemTypesCodeInput).sendKeys(newURCaseProblemTypesCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("UR Case/Problem Types new description"+newURCaseProblemTypesDescription);
        Log.info("log4j msg- UR Case/Problem Types new description"+newURCaseProblemTypesDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesDescriptionInput));
        driver.findElement(URCaseProblemTypesDescriptionInput).clear();
        driver.findElement(URCaseProblemTypesDescriptionInput).sendKeys(newURCaseProblemTypesDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesSaveLink));
        driver.findElement(URCaseProblemTypesSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
        
		
        } else{
			System.out.println("UR Case/Problem Types is not present, cannot copy UR Case/Problem Types");
			Log.info("log4j msg- UR Case/Problem Types is not present, cannot copy UR Case/Problem Types");
			wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesExitLink));
			driver.findElement(URCaseProblemTypesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in copying UR Case/Problem Types");Log.info("log4j msg- Error in copying UR Case/Problem Types"); }
		}
		
		





//edit function
public void editURCaseProblemTypes( String URCaseProblemTypesCode, String urcaseproblemTypesDescription, String recordMark)throws Exception{
        
        try{
        int i= searchURCaseProblemTypes(URCaseProblemTypesCode, urcaseproblemTypesDescription);
		
		if (i==1){
			System.out.println("UR Case/Problem Types  found, Continue with Edit");
			Log.info("log4j msg- UR Case/Problem Types  found, Continue with Edit");
		
		
        System.out.println("UR Case/Problem Types code"+URCaseProblemTypesCode);
        Log.info("log4j msg- UR Case/Problem Types code"+URCaseProblemTypesCode);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+URCaseProblemTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+URCaseProblemTypesCode+"']")).click();
        System.out.println("clicked UR Case/Problem Types Record Mark");
        Log.info("log4j msg- clicked UR Case/Problem Types Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesEditLink));
        driver.findElement(URCaseProblemTypesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("UR Case/Problem Types Record Mark"+recordMark);
        Log.info("log4j msg-UR Case/Problem Types Record Mark"+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesRecordMark));
       driver.findElement(URCaseProblemTypesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(URCaseProblemTypesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesSaveLink));
        driver.findElement(URCaseProblemTypesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}
        
		else{System.out.println("UR Case/Problem Types not found, cannot edit UR Case/Problem Types");
        Log.info("log4j msg- UR Case/Problem Types not found, cannot edit UR Case/Problem Types");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing UR Case/Problem Types ");
        Log.info("log4j msg- Error in Editing UR Case/Problem Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}


        }
//exit function
public void exitURCaseProblemTypes( String URCaseProblemTypesCode) throws Exception{
try{
        System.out.println("UR Case/Problem Types code"+URCaseProblemTypesCode);
        Log.info("log4j msg- UR Case/Problem Types code"+URCaseProblemTypesCode);
                        Thread.sleep(1000);
                        driver.findElement(URCaseProblemTypesExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  UR Case/Problem Types ");
                        Log.info("log4j msg- clicked exit in  UR Case/Problem Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                         
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting UR Case/Problem Types ");
Log.info("log4j msg- Error in Exiting UR Case/Problem Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}

//add comm function
public void addCommURCaseProblemTypes( String URCaseProblemTypesCode, String URCaseProblemTypesName, String URCaseProblemTypesCommsubject, String URCaseProblemTypesCommNoteType, String URCaseProblemTypesCommMedium, String URCaseProblemTypesCommDetails) throws Exception{
        
        try{  
        int i= searchURCaseProblemTypes( URCaseProblemTypesCode, URCaseProblemTypesName);
		
		if (i==1){
			System.out.println("UR Case/Problem Types  found, Continue with Add Communication");
			Log.info("log4j msg- UR Case/Problem Types  found, Continue with Add Communication");
		
		
        System.out.println("UR Case/Problem Types code"+URCaseProblemTypesCode);
        Log.info("log4j msg- UR Case/Problem Types code"+URCaseProblemTypesCode);
                        //find URCaseProblemTypes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+URCaseProblemTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+URCaseProblemTypesCode+"']")).click();
        System.out.println("clicked UR Case/Problem Types Code");
        Log.info("log4j msg- clicked UR Case/Problem Types code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesCommLink));
        driver.findElement(URCaseProblemTypesCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                        //click add
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                         System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(URCaseProblemTypesCommsubject);
                                        System.out.println("entered subject");
                                        Log.info("log4j msg- entered subject");
                                        
                                        
                                        //page down
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtFollowup']")));
                                        driver.findElement(By.xpath("//input[@id='txtFollowup']")).sendKeys(Keys.PAGE_DOWN);
                                        System.out.println("clicked page down");
                                        Log.info("log4j msg- clicked page down");
                                        
                                        
                                        Thread.sleep(2000);
                                        
                                        //click add details
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
                                        driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
                                        System.out.println("clicked add details");
                                        Log.info("log4j msg- clicked add details");
                                        
                                        Thread.sleep(2000);
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType"))); 
                                        Select urcaseproblemTypes = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                        urcaseproblemTypes.selectByVisibleText(URCaseProblemTypesCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(1000);
                                        //enter note details
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(URCaseProblemTypesCommDetails);
                                        System.out.println("entered notes details");
                                        Log.info("log4j msg- entered notes details");
                                        Thread.sleep(1000);
                                        
                                        
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
                                        Thread.sleep(2000);
                                        //click save
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
                                        driver.findElement(By.linkText("Save")).click();
                                        System.out.println("clicked save");
                                        Log.info("log4j msg- clicked save");
                                        
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
                                        
                         catch (Exception e){
                        	 e.printStackTrace();
                        	 System.out.println("Error in adding Comm to UR Case/Problem Types");
                             Log.info("log4j msg - Error in adding Comm to  UR Case/Problem Types"); 
         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
         driver.quit();   
         }   
                         
                         }
        


//delete function
public void deleteURCaseProblemTypes( String URCaseProblemTypesCode, String URCaseProblemTypesDescription) throws Exception{
        
        try{            
        int i= searchURCaseProblemTypes(URCaseProblemTypesCode, URCaseProblemTypesDescription);
		
		if (i==1){
			System.out.println("UR Case/Problem Types found, continue with delete");
			Log.info("log4j msg-UR Case/Problem Types found, continue with delete");
			
        //find URCaseProblemTypes
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+URCaseProblemTypesCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+URCaseProblemTypesCode+"']")).click();
                                        System.out.println("clicked UR Case/Problem Types Code");
                                        Log.info("log4j msg- clicked UR Case/Problem Types code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesDeleteLink));
                                        driver.findElement(URCaseProblemTypesDeleteLink).click();
                                        System.out.println("clicked Delete");
                                        Log.info("log4j msg- clicked Delete");
                                        
        
                                        //click confirm delete
                                        
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                        driver.findElement(confirmDeleteButton).click();
                                        System.out.println("clicked confirm Delete");
                                        Log.info("log4j msg- clicked confirm Delete");
                                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                        
 } else{
System.out.println("cannot find UR Case/Problem Types, cannot delete UR Case/Problem Types ");
Log.info("log4j msg- cannot find UR Case/Problem Types, cannot delete UR Case/Problem Types ");
wait.until(ExpectedConditions.visibilityOfElementLocated(URCaseProblemTypesExitLink));
driver.findElement(URCaseProblemTypesExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");


BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();

}} catch (Exception e){System.out.println("Error in deleting UR Case/Problem Types ");
Log.info("log4j msg - Error in deleting UR Case/Problem Types "); 

}   
}
}




