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

public class ProviderTypes {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By ProviderTypesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By ProviderTypesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By ProviderTypesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
	By ProviderTypesAddLink= By.linkText("Add");
   
    By ProviderTypesCodeInput = By.xpath("//input[@id='code']");
    
    By ProviderTypesDescriptionInput= By.xpath("//input[@id='name']");
    
    By ProviderTypesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By ProviderTypesValidateLink =By.linkText("Validate");
    
    By ProviderTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By ProviderTypesSaveLink =  By.linkText("Save");
    
    By ProviderTypesEditLink = By.linkText("Edit");
    
    By ProviderTypesCopyLink = By.linkText("Copy");
    
    By ProviderTypesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By ProviderTypesCommLink= By.linkText("Commun.");
    
    By ProviderTypesExitLink=  By.linkText("Exit");
    
    
    
    
    public ProviderTypes(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, 35);    
}


public int searchProviderTypes( String ProviderTypesCode, String ProviderTypesName) throws Exception{
 
try{
//enter  Provider Types code
wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesCodeBeginsInput));
driver.findElement(ProviderTypesCodeBeginsInput).clear();
driver.findElement(ProviderTypesCodeBeginsInput).sendKeys(ProviderTypesCode);
System.out.println("entered Provider Types  code");
Log.info("log4j msg- entered Provider Types code");


//enter  Provider Types name
wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesNameDescriptionBeginsInput));
driver.findElement(ProviderTypesNameDescriptionBeginsInput).clear();
driver.findElement(ProviderTypesNameDescriptionBeginsInput).sendKeys(ProviderTypesName);
System.out.println("entered Provider Types name");
Log.info("log4j msg- entered Provider Types name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesSearchButton));
driver.findElement(ProviderTypesSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");
	
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderTypesCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderTypesCode+"']"));
e.click();
System.out.println("Found ProviderTypes");
Log.info("log4j msg- Found ProviderTypes");

return 1;
}

catch(Exception e){System.out.println("Provider Types Not found"); Log.info("log4j msg- Provider Types Not found");return 0;}

}

//add function
public void addProviderTypes( String ProviderTypesCode, String ProviderTypesDescription)throws Exception{

        try{ 
        int i= searchProviderTypes( ProviderTypesCode, ProviderTypesDescription);
		
		if (i==0){
			System.out.println("Provider Types not found, Continue with Add");
			Log.info("log4j msg- Provider Types not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesAddLink));
        driver.findElement(ProviderTypesAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("Provider Types code: "+ProviderTypesCode);
        Log.info("log4j msg- Provider Types code: "+ProviderTypesCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesCodeInput));
        driver.findElement(ProviderTypesCodeInput).sendKeys(ProviderTypesCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("Provider Types description"+ProviderTypesDescription);
        Log.info("log4j msg- Provider Types code: "+ProviderTypesDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesDescriptionInput));
        driver.findElement(ProviderTypesDescriptionInput).sendKeys(ProviderTypesDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesValidateLink));
        driver.findElement(ProviderTypesValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesValidateSaveOKButton));
        driver.findElement(ProviderTypesValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesSaveLink));
        driver.findElement(ProviderTypesSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
           BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());   driver.quit();
        
        } else{
			System.out.println("Provider Types is already present, cannot add Provider Types");
			Log.info("log4j msg- Provider Types is already present, cannot add Provider Types");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesExitLink));
			driver.findElement(ProviderTypesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());   driver.quit();
		}

        }catch (Exception e){System.out.println("Error in adding Provider Types");Log.info("log4j msg- Error in adding Provider Types"); }
		}
        
//copy function

public void copyProviderTypes( String ProviderTypesCode, String ProviderTypesName, String newProviderTypesCode, String newProviderTypesDescription)throws Exception{
        
        try{ 
        int i= searchProviderTypes( ProviderTypesCode, ProviderTypesName);
		
		if (i==1){
			System.out.println("Provider Types found, continue with copy");
			Log.info("log4j msg-Provider Types found, continue with copy");
		
        
        System.out.println("Provider Types code"+ProviderTypesCode);
        Log.info("log4j msg-Provider Types code"+ProviderTypesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderTypesCode+"']")).click();
        System.out.println("clicked Provider Types Code");
        Log.info("log4j msg- clicked Provider Types code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesCopyLink));
        driver.findElement(ProviderTypesCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("Provider Types new code"+newProviderTypesCode);
        Log.info("log4j msg- Provider Types new code"+newProviderTypesCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesCodeInput));
        driver.findElement(ProviderTypesCodeInput).clear();
        driver.findElement(ProviderTypesCodeInput).sendKeys(newProviderTypesCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("Provider Types new description"+newProviderTypesDescription);
        Log.info("log4j msg- Provider Types new description"+newProviderTypesDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesDescriptionInput));
        driver.findElement(ProviderTypesDescriptionInput).clear();
        driver.findElement(ProviderTypesDescriptionInput).sendKeys(newProviderTypesDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesSaveLink));
        driver.findElement(ProviderTypesSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
           BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());   driver.quit();
		
        
		
        } else{
			System.out.println("Provider Types is not present, cannot copy Provider Types");
			Log.info("log4j msg- Provider Types is not present, cannot copy Provider Types");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesExitLink));
			driver.findElement(ProviderTypesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());   driver.quit();
		}

        }catch (Exception e){System.out.println("Error in copying Provider Types");Log.info("log4j msg- Error in copying Provider Types"); }
		}
		
		





//edit function
public void editProviderTypes( String ProviderTypesCode, String providerTypesDescription, String recordMark)throws Exception{
        
        try{ 
        int i= searchProviderTypes( ProviderTypesCode, providerTypesDescription);
		
		if (i==1){
			System.out.println("Provider Types  found, Continue with Edit");
			Log.info("log4j msg- Provider Types  found, Continue with Edit");
		
		
        System.out.println("Provider Types code"+ProviderTypesCode);
        Log.info("log4j msg- Provider Types code"+ProviderTypesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderTypesCode+"']")).click();
        System.out.println("clicked Provider Types Record Mark");
        Log.info("log4j msg- clicked Provider Types Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesEditLink));
        driver.findElement(ProviderTypesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("Provider Types Record Mark: "+recordMark);
        Log.info("log4j msg-Provider Types Record Mark: "+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesRecordMark));
       driver.findElement(ProviderTypesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(ProviderTypesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesSaveLink));
        driver.findElement(ProviderTypesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
           BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());   driver.quit();
		}
        
		else{System.out.println("Provider Types not found, cannot edit Provider Types");
        Log.info("log4j msg- Provider Types not found, cannot edit Provider Types");    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());   driver.quit();}
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Provider Types ");
        Log.info("log4j msg- Error in Editing Provider Types ");    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());   driver.quit();}


        }
//exit function
public void exitProviderTypes( String ProviderTypesCode) throws Exception{
try{
        System.out.println("Provider Types code"+ProviderTypesCode);
        Log.info("log4j msg- Provider Types code"+ProviderTypesCode);
                       Thread.sleep(1000);
                        driver.findElement(ProviderTypesExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  Provider Types ");
                        Log.info("log4j msg- clicked exit in  Provider Types ");    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());   driver.quit();
                      
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Provider Types ");
Log.info("log4j msg- Error in Exiting Provider Types ");    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());   driver.quit();}}

//add comm function
public void addCommProviderTypes( String ProviderTypesCode, String ProviderTypesName, String ProviderTypesCommsubject, String ProviderTypesCommNoteType, String ProviderTypesCommMedium, String ProviderTypesCommDetails) throws Exception{
        
        try{ 
        int i= searchProviderTypes( ProviderTypesCode, ProviderTypesName);
		
		if (i==1){
			System.out.println("Provider Types  found, Continue with Add Communication");
			Log.info("log4j msg- Provider Types  found, Continue with Add Communication");
		
		
        System.out.println("Provider Types code"+ProviderTypesCode);
        Log.info("log4j msg- Provider Types code"+ProviderTypesCode);
                        //find ProviderTypes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderTypesCode+"']")).click();
        System.out.println("clicked Provider Types Code");
        Log.info("log4j msg- clicked Provider Types code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesCommLink));
        driver.findElement(ProviderTypesCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                        //click add
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                        
                                       System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(ProviderTypesCommsubject);
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
                                        Select providerTypes = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                        providerTypes.selectByVisibleText(ProviderTypesCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(1000);
                                        //enter note details
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(ProviderTypesCommDetails);
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
                                        
                          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());   driver.quit();}}
                                        
                         catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to Provider Types");
                                                                                                        Log.info("log4j msg - Error in adding Comm to  Provider Types"); 
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());   driver.quit();   }   
                         
                         }
        


//delete function
public void deleteProviderTypes( String ProviderTypesCode, String ProviderTypesDescription) throws Exception{
        
        try{            
        int i= searchProviderTypes( ProviderTypesCode, ProviderTypesDescription);
		
		if (i==1){
			System.out.println("Provider Types found, continue with delete");
			Log.info("log4j msg-Provider Types found, continue with delete");
			
        //find ProviderTypes
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderTypesCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderTypesCode+"']")).click();
                                        System.out.println("clicked Provider Types Code");
                                        Log.info("log4j msg- clicked Provider Types code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesDeleteLink));
                                        driver.findElement(ProviderTypesDeleteLink).click();
                                        System.out.println("clicked Delete");
                                        Log.info("log4j msg- clicked Delete");
                                        
        
                                        //click confirm delete
                                        
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                        driver.findElement(confirmDeleteButton).click();
                                        System.out.println("clicked confirm Delete");
                                        Log.info("log4j msg- clicked confirm Delete");
                                          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());   driver.quit();
                                        
                                        
        




} else{
System.out.println("cannot find Provider Types, cannot delete Provider Types ");
Log.info("log4j msg- cannot find Provider Types, cannot delete Provider Types ");
wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderTypesExitLink));
driver.findElement(ProviderTypesExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");


 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());   driver.quit();

}} catch (Exception e){System.out.println("Error in deleting Provider Types ");
Log.info("log4j msg - Error in deleting Provider Types "); 

}   
}


}




