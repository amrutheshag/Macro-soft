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

public class InitialResponseatIntakes {

	WebDriver driver;
	WebDriverWait wait ;
	
	By InitialResponseatIntakesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By InitialResponseatIntakesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By InitialResponseatIntakesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By InitialResponseatIntakesAddLink= By.linkText("Add");
    
    By InitialResponseatIntakesCodeInput = By.xpath("//input[@id='code']");
    
    By InitialResponseatIntakesDescriptionInput= By.xpath("//input[@id='name']");
    
    By InitialResponseatIntakesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By InitialResponseatIntakesValidateLink =By.linkText("Validate");
    
    By InitialResponseatIntakesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By InitialResponseatIntakesSaveLink =  By.linkText("Save");
    
    By InitialResponseatIntakesEditLink = By.linkText("Edit");
    
    By InitialResponseatIntakesCopyLink = By.linkText("Copy");
    
    By InitialResponseatIntakesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By InitialResponseatIntakesCommLink= By.linkText("Commun.");
    
    By InitialResponseatIntakesExitLink=  By.linkText("Exit");
    
    
    
    
    public InitialResponseatIntakes(WebDriver driver){
                    this.driver= driver;
                    this.wait= new WebDriverWait(driver, 30);
    }
    
    


public int searchInitialResponseatIntakes( String InitialResponseatIntakesCode, String InitialResponseatIntakesName) throws Exception{

try{
//enter  Initial Response at Intakes code
wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesCodeBeginsInput));
driver.findElement(InitialResponseatIntakesCodeBeginsInput).clear();
driver.findElement(InitialResponseatIntakesCodeBeginsInput).sendKeys(InitialResponseatIntakesCode);
System.out.println("entered Initial Response at Intakes  code");
Log.info("log4j msg- entered Initial Response at Intakes code");


//enter  Initial Response at Intakes name
wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesNameDescriptionBeginsInput));
driver.findElement(InitialResponseatIntakesNameDescriptionBeginsInput).clear();
driver.findElement(InitialResponseatIntakesNameDescriptionBeginsInput).sendKeys(InitialResponseatIntakesName);
System.out.println("entered Initial Response at Intakes name");
Log.info("log4j msg- entered Initial Response at Intakes name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesSearchButton));
driver.findElement(InitialResponseatIntakesSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");
	
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+InitialResponseatIntakesCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+InitialResponseatIntakesCode+"']"));
e.click();
System.out.println("Found InitialResponseatIntakes");
Log.info("log4j msg- Found InitialResponseatIntakes");

return 1;
}

catch(Exception e){System.out.println("Initial Response at Intakes not found"); Log.info("log4j msg- Initial Response at Intakes not found");return 0;}

}

//add function
public void addInitialResponseatIntakes( String InitialResponseatIntakesCode, String InitialResponseatIntakesDescription)throws Exception{

        try{ 
        
        int i= searchInitialResponseatIntakes(InitialResponseatIntakesCode, InitialResponseatIntakesDescription);
		
		if (i==0){
			System.out.println("Initial Response at Intakes not found, Continue with Add");
			Log.info("log4j msg- Initial Response at Intakes not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesAddLink));
        driver.findElement(InitialResponseatIntakesAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("Initial Response at Intakes code: "+InitialResponseatIntakesCode);
        Log.info("log4j msg- Initial Response at Intakes code: "+InitialResponseatIntakesCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesCodeInput));
        driver.findElement(InitialResponseatIntakesCodeInput).sendKeys(InitialResponseatIntakesCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("Initial Response at Intakes description"+InitialResponseatIntakesDescription);
        Log.info("log4j msg- Initial Response at Intakes code: "+InitialResponseatIntakesDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesDescriptionInput));
        driver.findElement(InitialResponseatIntakesDescriptionInput).sendKeys(InitialResponseatIntakesDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesValidateLink));
        driver.findElement(InitialResponseatIntakesValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesValidateSaveOKButton));
        driver.findElement(InitialResponseatIntakesValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesSaveLink));
        driver.findElement(InitialResponseatIntakesSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
        } else{
			System.out.println("Initial Response at Intakes is already present, cannot add Initial Response at Intakes");
			Log.info("log4j msg- Initial Response at Intakes is already present, cannot add Initial Response at Intakes");
			wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesExitLink));
			driver.findElement(InitialResponseatIntakesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in adding Initial Response at Intakes");Log.info("log4j msg- Error in adding Initial Response at Intakes"); }
		}
        
//copy function

public void copyInitialResponseatIntakes( String InitialResponseatIntakesCode, String InitialResponseatIntakesName, String newInitialResponseatIntakesCode, String newInitialResponseatIntakesDescription)throws Exception{
        
        try{ 
        
        int i= searchInitialResponseatIntakes( InitialResponseatIntakesCode, InitialResponseatIntakesName);
		
		if (i==1){
			System.out.println("Initial Response at Intakes found, continue with copy");
			Log.info("log4j msg-Initial Response at Intakes found, continue with copy");
		
        
        System.out.println("Initial Response at Intakes code"+InitialResponseatIntakesCode);
        Log.info("log4j msg-Initial Response at Intakes code"+InitialResponseatIntakesCode);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+InitialResponseatIntakesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+InitialResponseatIntakesCode+"']")).click();
        System.out.println("clicked Initial Response at Intakes Code");
        Log.info("log4j msg- clicked Initial Response at Intakes code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesCopyLink));
        driver.findElement(InitialResponseatIntakesCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("Initial Response at Intakes new code"+newInitialResponseatIntakesCode);
        Log.info("log4j msg- Initial Response at Intakes new code"+newInitialResponseatIntakesCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesCodeInput));
        driver.findElement(InitialResponseatIntakesCodeInput).clear();
        driver.findElement(InitialResponseatIntakesCodeInput).sendKeys(newInitialResponseatIntakesCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("Initial Response at Intakes new description"+newInitialResponseatIntakesDescription);
        Log.info("log4j msg- Initial Response at Intakes new description"+newInitialResponseatIntakesDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesDescriptionInput));
        driver.findElement(InitialResponseatIntakesDescriptionInput).clear();
        driver.findElement(InitialResponseatIntakesDescriptionInput).sendKeys(newInitialResponseatIntakesDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesSaveLink));
        driver.findElement(InitialResponseatIntakesSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
        
		
        } else{
			System.out.println("Initial Response at Intakes is not present, cannot copy Initial Response at Intakes");
			Log.info("log4j msg- Initial Response at Intakes is not present, cannot copy Initial Response at Intakes");
			wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesExitLink));
			driver.findElement(InitialResponseatIntakesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in copying Initial Response at Intakes");Log.info("log4j msg- Error in copying Initial Response at Intakes"); }
		}
		
		





//edit function
public void editInitialResponseatIntakes( String InitialResponseatIntakesCode, String initialresponseatIntakesDescription, String recordMark)throws Exception{
        
        try{ 
        
        int i= searchInitialResponseatIntakes(InitialResponseatIntakesCode, initialresponseatIntakesDescription);
		
		if (i==1){
			System.out.println("Initial Response at Intakes  found, Continue with Edit");
			Log.info("log4j msg- Initial Response at Intakes  found, Continue with Edit");
		
		
        System.out.println("Initial Response at Intakes code"+InitialResponseatIntakesCode);
        Log.info("log4j msg- Initial Response at Intakes code"+InitialResponseatIntakesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+InitialResponseatIntakesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+InitialResponseatIntakesCode+"']")).click();
        System.out.println("clicked Initial Response at Intakes Record Mark");
        Log.info("log4j msg- clicked Initial Response at Intakes Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesEditLink));
        driver.findElement(InitialResponseatIntakesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("Initial Response at Intakes Record Mark"+recordMark);
        Log.info("log4j msg-Initial Response at Intakes Record Mark"+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesRecordMark));
       driver.findElement(InitialResponseatIntakesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(InitialResponseatIntakesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesSaveLink));
        driver.findElement(InitialResponseatIntakesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}
        
		else{System.out.println("Initial Response at Intakes not found, cannot edit Initial Response at Intakes");
        Log.info("log4j msg- Initial Response at Intakes not found, cannot edit Initial Response at Intakes");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Initial Response at Intakes ");
        Log.info("log4j msg- Error in Editing Initial Response at Intakes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}


        }
//exit function
public void exitInitialResponseatIntakes( String InitialResponseatIntakesCode) throws Exception{
try{
        System.out.println("Initial Response at Intakes code"+InitialResponseatIntakesCode);
        Log.info("log4j msg- Initial Response at Intakes code"+InitialResponseatIntakesCode);
                        Thread.sleep(1000);
                        driver.findElement(InitialResponseatIntakesExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  Initial Response at Intakes ");
                        Log.info("log4j msg- clicked exit in  Initial Response at Intakes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
                        
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Initial Response at Intakes ");
Log.info("log4j msg- Error in Exiting Initial Response at Intakes ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}

//add comm function
public void addCommInitialResponseatIntakes( String InitialResponseatIntakesCode, String InitialResponseatIntakesName, String InitialResponseatIntakesCommsubject, String InitialResponseatIntakesCommNoteType, String InitialResponseatIntakesCommMedium, String InitialResponseatIntakesCommDetails) throws Exception{
        
        try{         
        	
        
        int i= searchInitialResponseatIntakes( InitialResponseatIntakesCode, InitialResponseatIntakesName);
		
		if (i==1){
			System.out.println("Initial Response at Intakes  found, Continue with Add Communication");
			Log.info("log4j msg- Initial Response at Intakes  found, Continue with Add Communication");
		
		
        System.out.println("Initial Response at Intakes code"+InitialResponseatIntakesCode);
        Log.info("log4j msg- Initial Response at Intakes code"+InitialResponseatIntakesCode);
                        //find InitialResponseatIntakes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+InitialResponseatIntakesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+InitialResponseatIntakesCode+"']")).click();
        System.out.println("clicked Initial Response at Intakes Code");
        Log.info("log4j msg- clicked Initial Response at Intakes code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesCommLink));
        driver.findElement(InitialResponseatIntakesCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                        //click add
                                       
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                        
                                        System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(InitialResponseatIntakesCommsubject);
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
                                        
                                        Thread.sleep(3000);
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType"))); 
                                        
                                        Thread.sleep(2000);
                                        Select initialresponseatIntakes = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                        
                                        Thread.sleep(4000);
                                        initialresponseatIntakes.selectByVisibleText(InitialResponseatIntakesCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(1000);
                                        //enter note details
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(InitialResponseatIntakesCommDetails);
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
                         System.out.println("Error in adding Comm to Initial Response at Intakes");
                         Log.info("log4j msg - Error in adding Comm to  Initial Response at Intakes"); 
         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
         driver.quit();   }   
                         
                         }
        


//delete function
public void deleteInitialResponseatIntakes( String InitialResponseatIntakesCode, String InitialResponseatIntakesDescription) throws Exception{
        
        try{         
                        
        int i= searchInitialResponseatIntakes( InitialResponseatIntakesCode, InitialResponseatIntakesDescription);
		
		if (i==1){
			System.out.println("Initial Response at Intakes found, continue with delete");
			Log.info("log4j msg-Initial Response at Intakes found, continue with delete");
			
        //find InitialResponseatIntakes
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+InitialResponseatIntakesCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+InitialResponseatIntakesCode+"']")).click();
                                        System.out.println("clicked Initial Response at Intakes Code");
                                        Log.info("log4j msg- clicked Initial Response at Intakes code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesDeleteLink));
                                        driver.findElement(InitialResponseatIntakesDeleteLink).click();
                                        System.out.println("clicked Delete");
                                        Log.info("log4j msg- clicked Delete");
                                        
        
                                        //click confirm delete
                                        
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                        driver.findElement(confirmDeleteButton).click();
                                        System.out.println("clicked confirm Delete");
                                        Log.info("log4j msg- clicked confirm Delete");
                                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                        
                                        
        




} else{
System.out.println("cannot find Initial Response at Intakes, cannot delete Initial Response at Intakes ");
Log.info("log4j msg- cannot find Initial Response at Intakes, cannot delete Initial Response at Intakes ");
wait.until(ExpectedConditions.visibilityOfElementLocated(InitialResponseatIntakesExitLink));
driver.findElement(InitialResponseatIntakesExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");


BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();

}} catch (Exception e){System.out.println("Error in deleting Initial Response at Intakes ");
Log.info("log4j msg - Error in deleting Initial Response at Intakes "); 

}   
}


}




