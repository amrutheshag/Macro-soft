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

public class ProviderOrganizationAffiliationTypes {

	WebDriver driver;
	WebDriverWait wait;    
	
	By ProviderOrganizationAffiliationTypesCodeBeginsInput = By.xpath("//input[@id='txtCode']");
	
	By ProviderOrganizationAffiliationTypesNameDescriptionBeginsInput = By.xpath("//input[@id='txtName']");
	
	By ProviderOrganizationAffiliationTypesSearchButton= By.xpath("//button[@data-ng-click='search(0)']");
    
    By ProviderOrganizationAffiliationTypesAddLink= By.linkText("Add");
  
    By ProviderOrganizationAffiliationTypesCodeInput = By.xpath("//input[@id='code']");
   
    By ProviderOrganizationAffiliationTypesDescriptionInput= By.xpath("//input[@id='name']");
    
    By ProviderOrganizationAffiliationTypesRecordMark= By.xpath("//input[@style='width:20px;']");
    
    By ProviderOrganizationAffiliationTypesValidateLink =By.linkText("Validate");
    
    By ProviderOrganizationAffiliationTypesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By ProviderOrganizationAffiliationTypesSaveLink =  By.linkText("Save");
    
    By ProviderOrganizationAffiliationTypesEditLink = By.linkText("Edit");
    
    By ProviderOrganizationAffiliationTypesCopyLink = By.linkText("Copy");
    
    By ProviderOrganizationAffiliationTypesDeleteLink= By.linkText("Delete");
    
    By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
    
    By ProviderOrganizationAffiliationTypesCommLink= By.linkText("Commun.");
    
    By ProviderOrganizationAffiliationTypesExitLink=  By.linkText("Exit");
    
    
    
    public ProviderOrganizationAffiliationTypes(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver, 35);
}


public int searchProviderOrganizationAffiliationTypes( String ProviderOrganizationAffiliationTypesCode, String ProviderOrganizationAffiliationTypesName) throws Exception{

try{
//enter  Provider-Organization Affiliation Types code
wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesCodeBeginsInput));
driver.findElement(ProviderOrganizationAffiliationTypesCodeBeginsInput).clear();
driver.findElement(ProviderOrganizationAffiliationTypesCodeBeginsInput).sendKeys(ProviderOrganizationAffiliationTypesCode);
System.out.println("entered Provider-Organization Affiliation Types  code");
Log.info("log4j msg- entered Provider-Organization Affiliation Types code");


//enter  Provider-Organization Affiliation Types name
wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesNameDescriptionBeginsInput));
driver.findElement(ProviderOrganizationAffiliationTypesNameDescriptionBeginsInput).clear();
driver.findElement(ProviderOrganizationAffiliationTypesNameDescriptionBeginsInput).sendKeys(ProviderOrganizationAffiliationTypesName);
System.out.println("entered Provider-Organization Affiliation Types name");
Log.info("log4j msg- entered Provider-Organization Affiliation Types name");

//click search
wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesSearchButton));
driver.findElement(ProviderOrganizationAffiliationTypesSearchButton).click();
System.out.println("clicked Search");
Log.info("log4j msg- clicked Search");
	
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderOrganizationAffiliationTypesCode+"']")));
WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderOrganizationAffiliationTypesCode+"']"));
e.click();
System.out.println("Found ProviderOrganizationAffiliationTypes");
Log.info("log4j msg- Found ProviderOrganizationAffiliationTypes");

return 1;
}

catch(Exception e){System.out.println("Provider-Organization Affiliation Types not found"); 
Log.info("log4j msg- Provider-Organization Affiliation Types not found");return 0;}

}

//add function
public void addProviderOrganizationAffiliationTypes( String ProviderOrganizationAffiliationTypesCode, String ProviderOrganizationAffiliationTypesDescription)throws Exception{

        try{ 
        int i= searchProviderOrganizationAffiliationTypes( ProviderOrganizationAffiliationTypesCode, ProviderOrganizationAffiliationTypesDescription);
		
		if (i==0){
			System.out.println("Provider-Organization Affiliation Types not found, Continue with Add");
			Log.info("log4j msg- Provider-Organization Affiliation Types not found, Continue with Add");
		
		
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesAddLink));
        driver.findElement(ProviderOrganizationAffiliationTypesAddLink).click();
        System.out.println("clicked Add");
        Log.info("log4j msg- clicked Add");
        
        
        System.out.println("Provider-Organization Affiliation Types code: "+ProviderOrganizationAffiliationTypesCode);
        Log.info("log4j msg- Provider-Organization Affiliation Types code: "+ProviderOrganizationAffiliationTypesCode);
        //enter code
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesCodeInput));
        driver.findElement(ProviderOrganizationAffiliationTypesCodeInput).sendKeys(ProviderOrganizationAffiliationTypesCode);
        Thread.sleep(1000);
        System.out.println("Entered code");
        Log.info("log4j msg- Entered code");
        
        System.out.println("Provider-Organization Affiliation Types description"+ProviderOrganizationAffiliationTypesDescription);
        Log.info("log4j msg- Provider-Organization Affiliation Types code: "+ProviderOrganizationAffiliationTypesDescription);
        //enter Description
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesDescriptionInput));
        driver.findElement(ProviderOrganizationAffiliationTypesDescriptionInput).sendKeys(ProviderOrganizationAffiliationTypesDescription);
        Thread.sleep(1000);
        System.out.println("Entered description");
        Log.info("log4j msg- Entered description");

        
        //click validate

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesValidateLink));
        driver.findElement(ProviderOrganizationAffiliationTypesValidateLink).click();
        System.out.println("clicked validate");
        Log.info("log4j msg- clicked validate");
        
        //click ok
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesValidateSaveOKButton));
        driver.findElement(ProviderOrganizationAffiliationTypesValidateSaveOKButton).click();
        System.out.println("clicked validate ok to save button");
        Log.info("log4j msg- clicked validate ok to save button");
        
		
        //click save
        Thread.sleep(1000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesSaveLink));
        driver.findElement(ProviderOrganizationAffiliationTypesSaveLink).click();
        System.out.println("clicked save ");
        Log.info("log4j msg- clicked  save ");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
        
        } else{
			System.out.println("Provider-Organization Affiliation Types is already present, cannot add Provider-Organization Affiliation Types");
			Log.info("log4j msg- Provider-Organization Affiliation Types is already present, cannot add Provider-Organization Affiliation Types");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesExitLink));
			driver.findElement(ProviderOrganizationAffiliationTypesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in adding Provider-Organization Affiliation Types");Log.info("log4j msg- Error in adding Provider-Organization Affiliation Types"); }
		}
        
//copy function

public void copyProviderOrganizationAffiliationTypes( String ProviderOrganizationAffiliationTypesCode, String ProviderOrganizationAffiliationTypesName, String newProviderOrganizationAffiliationTypesCode, String newProviderOrganizationAffiliationTypesDescription)throws Exception{
        
        try{         int i= searchProviderOrganizationAffiliationTypes( ProviderOrganizationAffiliationTypesCode, ProviderOrganizationAffiliationTypesName);
		
		if (i==1){
			System.out.println("Provider-Organization Affiliation Types found, continue with copy");
			Log.info("log4j msg-Provider-Organization Affiliation Types found, continue with copy");
		
        
        System.out.println("Provider-Organization Affiliation Types code"+ProviderOrganizationAffiliationTypesCode);
        Log.info("log4j msg-Provider-Organization Affiliation Types code"+ProviderOrganizationAffiliationTypesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderOrganizationAffiliationTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderOrganizationAffiliationTypesCode+"']")).click();
        System.out.println("clicked Provider-Organization Affiliation Types Code");
        Log.info("log4j msg- clicked Provider-Organization Affiliation Types code");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesCopyLink));
        driver.findElement(ProviderOrganizationAffiliationTypesCopyLink).click();
        System.out.println("clicked Copy");
        Log.info("log4j msg- clicked Copy");
        
        System.out.println("Provider-Organization Affiliation Types new code"+newProviderOrganizationAffiliationTypesCode);
        Log.info("log4j msg- Provider-Organization Affiliation Types new code"+newProviderOrganizationAffiliationTypesCode);
        //enter new code
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesCodeInput));
        driver.findElement(ProviderOrganizationAffiliationTypesCodeInput).clear();
        driver.findElement(ProviderOrganizationAffiliationTypesCodeInput).sendKeys(newProviderOrganizationAffiliationTypesCode);
        System.out.println("Entered new code");
        Log.info("log4j msg- Entered new code");

        System.out.println("Provider-Organization Affiliation Types new description"+newProviderOrganizationAffiliationTypesDescription);
        Log.info("log4j msg- Provider-Organization Affiliation Types new description"+newProviderOrganizationAffiliationTypesDescription);
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesDescriptionInput));
        driver.findElement(ProviderOrganizationAffiliationTypesDescriptionInput).clear();
        driver.findElement(ProviderOrganizationAffiliationTypesDescriptionInput).sendKeys(newProviderOrganizationAffiliationTypesDescription);
        System.out.println("Entered new description");
        Log.info("log4j msg- Entered new description");
        
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesSaveLink));
        driver.findElement(ProviderOrganizationAffiliationTypesSaveLink).click();

        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
        
		
        } else{
			System.out.println("Provider-Organization Affiliation Types is not present, cannot copy Provider-Organization Affiliation Types");
			Log.info("log4j msg- Provider-Organization Affiliation Types is not present, cannot copy Provider-Organization Affiliation Types");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesExitLink));
			driver.findElement(ProviderOrganizationAffiliationTypesExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			
			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}

        }catch (Exception e){System.out.println("Error in copying Provider-Organization Affiliation Types");Log.info("log4j msg- Error in copying Provider-Organization Affiliation Types"); }
		}
		
		





//edit function
public void editProviderOrganizationAffiliationTypes( String ProviderOrganizationAffiliationTypesCode, String providerorganizationaffiliationTypesDescription, String recordMark)throws Exception{
        
        try{ 
        int i= searchProviderOrganizationAffiliationTypes( ProviderOrganizationAffiliationTypesCode, providerorganizationaffiliationTypesDescription);
		
		if (i==1){
			System.out.println("Provider-Organization Affiliation Types  found, Continue with Edit");
			Log.info("log4j msg- Provider-Organization Affiliation Types  found, Continue with Edit");
		
		
        System.out.println("Provider-Organization Affiliation Types code"+ProviderOrganizationAffiliationTypesCode);
        Log.info("log4j msg- Provider-Organization Affiliation Types code"+ProviderOrganizationAffiliationTypesCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderOrganizationAffiliationTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderOrganizationAffiliationTypesCode+"']")).click();
        System.out.println("clicked Provider-Organization Affiliation Types Record Mark");
        Log.info("log4j msg- clicked Provider-Organization Affiliation Types Record Mark");
        
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesEditLink));
        driver.findElement(ProviderOrganizationAffiliationTypesEditLink).click();
        System.out.println("clicked Edit");
        Log.info("log4j msg- clicked Edit");
        
        System.out.println("Provider-Organization Affiliation Types Record Mark"+recordMark);
        Log.info("log4j msg-Provider-Organization Affiliation Types Record Mark"+recordMark);
                                       
//enter new description
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesRecordMark));
      driver.findElement(ProviderOrganizationAffiliationTypesRecordMark).clear();
        Thread.sleep(1000);
        driver.findElement(ProviderOrganizationAffiliationTypesRecordMark).sendKeys(recordMark);
        System.out.println("Entered new Record Mark");
        Log.info("log4j msg- Entered new Record Mark");
        
        
        
        
        //click save
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesSaveLink));
        driver.findElement(ProviderOrganizationAffiliationTypesSaveLink).click();
        System.out.println("Clicked save");
        Log.info("log4j msg- clicked save");
          BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		}
        
		else{System.out.println("Provider-Organization Affiliation Types not found, cannot edit Provider-Organization Affiliation Types");
        Log.info("log4j msg- Provider-Organization Affiliation Types not found, cannot edit Provider-Organization Affiliation Types");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Provider-Organization Affiliation Types ");
        Log.info("log4j msg- Error in Editing Provider-Organization Affiliation Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}


        }
//exit function
public void exitProviderOrganizationAffiliationTypes( String ProviderOrganizationAffiliationTypesCode) throws Exception{
try{
        System.out.println("Provider-Organization Affiliation Types code"+ProviderOrganizationAffiliationTypesCode);
        Log.info("log4j msg- Provider-Organization Affiliation Types code"+ProviderOrganizationAffiliationTypesCode);
                        Thread.sleep(1000);
                        driver.findElement(ProviderOrganizationAffiliationTypesExitLink).click();
                        Thread.sleep(1000);
                        System.out.println("Clicked exit in  Provider-Organization Affiliation Types ");
                        Log.info("log4j msg- clicked exit in  Provider-Organization Affiliation Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                       
}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exiting Provider-Organization Affiliation Types ");
Log.info("log4j msg- Error in Exiting Provider-Organization Affiliation Types ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}

//add comm function
public void addCommProviderOrganizationAffiliationTypes( String ProviderOrganizationAffiliationTypesCode, String ProviderOrganizationAffiliationTypesName, String ProviderOrganizationAffiliationTypesCommsubject, String ProviderOrganizationAffiliationTypesCommNoteType, String ProviderOrganizationAffiliationTypesCommMedium, String ProviderOrganizationAffiliationTypesCommDetails) throws Exception{
        
        try{
        int i= searchProviderOrganizationAffiliationTypes( ProviderOrganizationAffiliationTypesCode, ProviderOrganizationAffiliationTypesName);
		
		if (i==1){
			System.out.println("Provider-Organization Affiliation Types  found, Continue with Add Communication");
			Log.info("log4j msg- Provider-Organization Affiliation Types  found, Continue with Add Communication");
		
		
        System.out.println("Provider-Organization Affiliation Types code"+ProviderOrganizationAffiliationTypesCode);
        Log.info("log4j msg- Provider-Organization Affiliation Types code"+ProviderOrganizationAffiliationTypesCode);
                        //find ProviderOrganizationAffiliationTypes
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderOrganizationAffiliationTypesCode+"']")));
        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderOrganizationAffiliationTypesCode+"']")).click();
        System.out.println("clicked Provider-Organization Affiliation Types Code");
        Log.info("log4j msg- clicked Provider-Organization Affiliation Types code");
        
                                        //click comm
                                        
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesCommLink));
        driver.findElement(ProviderOrganizationAffiliationTypesCommLink).click();
        System.out.println("clicked Comm");
        Log.info("log4j msg- clicked Comm");

                                        
                                        
                                        //click add
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                                        driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                       System.out.println("clicked Add");
                                        Log.info("log4j msg- clicked Add");
                                        
                                        //enter subject
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                        driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(ProviderOrganizationAffiliationTypesCommsubject);
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
                                        Select providerorganizationaffiliationTypes = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                        providerorganizationaffiliationTypes.selectByVisibleText(ProviderOrganizationAffiliationTypesCommNoteType);
                                        System.out.println("selected note type");
                                        Log.info("log4j msg-selected note type");
                                        
                                        Thread.sleep(1000);
                                        //enter note details
                                       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                        driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(ProviderOrganizationAffiliationTypesCommDetails);
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
                                        
                         catch (Exception e){e.printStackTrace();System.out.println("Error in adding Comm to Provider-Organization Affiliation Types");
                                                                                                        Log.info("log4j msg - Error in adding Comm to  Provider-Organization Affiliation Types"); 
         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();   }   
                         
                         }
        


//delete function
public void deleteProviderOrganizationAffiliationTypes( String ProviderOrganizationAffiliationTypesCode, String ProviderOrganizationAffiliationTypesDescription) throws Exception{
        
        try{            
        int i= searchProviderOrganizationAffiliationTypes(ProviderOrganizationAffiliationTypesCode, ProviderOrganizationAffiliationTypesDescription);
		
		if (i==1){
			System.out.println("Provider-Organization Affiliation Types found, continue with delete");
			Log.info("log4j msg-Provider-Organization Affiliation Types found, continue with delete");
			
        //find ProviderOrganizationAffiliationTypes
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderOrganizationAffiliationTypesCode+"']")));
                                        driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+ProviderOrganizationAffiliationTypesCode+"']")).click();
                                        System.out.println("clicked Provider-Organization Affiliation Types Code");
                                        Log.info("log4j msg- clicked Provider-Organization Affiliation Types code");
                        
                                        //click delete
                                        
                                        wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesDeleteLink));
                                        driver.findElement(ProviderOrganizationAffiliationTypesDeleteLink).click();
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
System.out.println("cannot find Provider-Organization Affiliation Types, cannot delete Provider-Organization Affiliation Types ");
Log.info("log4j msg- cannot find Provider-Organization Affiliation Types, cannot delete Provider-Organization Affiliation Types ");
wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderOrganizationAffiliationTypesExitLink));
driver.findElement(ProviderOrganizationAffiliationTypesExitLink).click();
System.out.println("clicked Exit");
Log.info("log4j msg- clicked Exit");


BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();

}} catch (Exception e){System.out.println("Error in deleting Provider-Organization Affiliation Types ");
Log.info("log4j msg - Error in deleting Provider-Organization Affiliation Types "); 

}   
}


}




