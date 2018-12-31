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

public class EmployerGroups{

         		WebDriver driver;
        		WebDriverWait wait ;
	
				By EmployerGroupsCodeBeginsInput = By.xpath("//input[@data-ng-model='searchOptions.emp']");
				
				By EmployerGroupsNameDescriptionBeginsInput = By.xpath("//input[@data-ng-model='searchOptions.name']");
				
				By EmployerGroupsSearchButton= By.xpath("//button[@data-ng-click='search()']");
                
                By EmployerGroupsEffectiveDate = By.id("txtEffectiveDate");
                
                By EmployerGroupsAddLink= By.linkText("Add");
                
                By EmployerGroupsCodeInput = By.xpath("//input[@id='txtCode']");
                
                By EmployerGroupsDescriptionInput= By.xpath("//input[@id='txtName']");
                
                By EmployerGroupsValidateLink =By.linkText("Validate");
     
                By EmployerGroupsValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
                
                By EmployerGroupsSaveLink =  By.linkText("Save");
                
                By EmployerGroupsEditLink = By.linkText("Edit");
                
                By EmployerGroupsCopyLink = By.linkText("Copy");
                
                By EmployerGroupsDeleteLink= By.linkText("Delete");
                
                By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
                
                By EmployerGroupsCommLink= By.linkText("Commun.");
     
                By EmployerGroupsExitLink=  By.linkText("Exit");
                
                
                public EmployerGroups(WebDriver driver){
                                this.driver= driver;
                                this.wait= new WebDriverWait(driver, 20);
                }
                
                
            	public int searchEmployerGroups( String EmployerGroupsCode, String EmployerGroupsName) throws Exception{
            		
            		try{
            		//enter  EmployerGroupscode
            		wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsCodeBeginsInput));
            		driver.findElement(EmployerGroupsCodeBeginsInput).clear();
            		driver.findElement(EmployerGroupsCodeBeginsInput).sendKeys(EmployerGroupsCode);
            		System.out.println("entered Employer Groups  code");
            		Log.info("log4j msg- entered Employer Groups  code");
            	
            	
            		//enter  EmployerGroupsname
            		wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsNameDescriptionBeginsInput));
            		driver.findElement(EmployerGroupsNameDescriptionBeginsInput).clear();
            		driver.findElement(EmployerGroupsNameDescriptionBeginsInput).sendKeys(EmployerGroupsName);
            		System.out.println("entered Employer Groups  name");
            		Log.info("log4j msg- entered Employer Groups  name");
            		
            		//click search
            		wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsSearchButton));
            		driver.findElement(EmployerGroupsSearchButton).click();
            		System.out.println("clicked Search");
            		Log.info("log4j msg- clicked Search");
          
            		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EmployerGroupsCode+"']")));
            		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EmployerGroupsCode+"']"));
            		e.click();
            		System.out.println("Found EmployerGroups");
            		Log.info("log4j msg- Found EmployerGroups");
            	
            		return 1;
            		}
            		
            	catch(Exception e){
            		//e.printStackTrace(); 
            		Log.info("log4j msg-EmployerGroups Not found"); 
            		System.out.println("EmployerGroups Not found"); return 0;}
            		
            	}

                //add function
                public void addEmployerGroups( String EmployerGroupsCode, String EmployerGroupsDescription)throws Exception{
                
                                try{ 
                                
                                int i= searchEmployerGroups( EmployerGroupsCode, EmployerGroupsDescription);
                        		
                        		if (i==0){
                        			System.out.println("Employer Groups not found, Continue with Add");
                        			Log.info("log4j msg- Employer Groups not found, Continue with Add");
                        		
                        		
                                wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsAddLink));
                                driver.findElement(EmployerGroupsAddLink).click();
                                System.out.println("clicked Add");
                                Log.info("log4j msg- clicked Add");
                                
                                Thread.sleep(1000);
                                System.out.println("Employer Groups code: "+EmployerGroupsCode);
                                
                                //enter code
                                wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsCodeInput));
                                driver.findElement(EmployerGroupsCodeInput).sendKeys(EmployerGroupsCode);
                                Thread.sleep(1000);
                                System.out.println("Entered code");
                                Log.info("log4j msg- Entered code");
                                Thread.sleep(1000);
                                System.out.println("Employer Groups description"+EmployerGroupsDescription);
                               
                                //enter Description
                                wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsDescriptionInput));
                                driver.findElement(EmployerGroupsDescriptionInput).sendKeys(EmployerGroupsDescription);
                                Thread.sleep(1000);
                                System.out.println("Entered description");
                                Log.info("log4j msg- Entered description");
                
                                
                                //click validate
                
                                Thread.sleep(1000);
                                wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsValidateLink));
                                driver.findElement(EmployerGroupsValidateLink).click();
                                System.out.println("clicked validate");
                                Log.info("log4j msg- clicked validate");
                                
                                //click ok
                                Thread.sleep(2000);
                                wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsValidateSaveOKButton));
                                driver.findElement(EmployerGroupsValidateSaveOKButton).click();
                                System.out.println("clicked validate ok to save button");
                                Log.info("log4j msg- clicked validate ok to save button");
                                
                        		
                                //click save
                                Thread.sleep(2000);
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsSaveLink));
                                driver.findElement(EmployerGroupsSaveLink).click();
                                System.out.println("clicked save ");
                                Log.info("log4j msg- clicked  save ");
                                
                                Thread.sleep(2000);
                                  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                  driver.quit();
                                  
                                
                                } else{
                        			System.out.println("Employer Groups is already present, cannot add Employer Groups");
                        			Log.info("log4j msg-Employer Groups is already present, cannot add Employer Groups");
                        			wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsExitLink));
                        			driver.findElement(EmployerGroupsExitLink).click();
                        			System.out.println("clicked Exit");
                        			Log.info("log4j msg- clicked Exit");
                        			
                        			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                        			 driver.quit(); 
                        		}
                
                                }catch (Exception e){ e.printStackTrace(); 
                                System.out.println("error in adding EmployerGroups");
                                Log.info("log4j msg-error in adding EmployerGroups");  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
                                driver.quit();  }
                        		}
                                
                //copy function
                
                public void copyEmployerGroups( String EmployerGroupsCode, String EmployerGroupsName, String newEmployerGroupsCode, String newEmployerGroupsDescription)throws Exception{
                                
                                try{ 
                                
                                int i= searchEmployerGroups( EmployerGroupsCode, EmployerGroupsName);
                        		
                        		if (i==1){
                        			System.out.println("Employer Groups found, continue with copy");
                        			Log.info("log4j msg-Employer Groups found, continue with copy");
                        		
                                
                                System.out.println("Employer Groups code"+EmployerGroupsCode);
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EmployerGroupsCode+"']")));
                                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EmployerGroupsCode+"']")).click();
                                System.out.println("clicked Employer Groups Code");
                                Log.info("log4j msg- clicked Employer Groups code");
                                
                                
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsCopyLink));
                                driver.findElement(EmployerGroupsCopyLink).click();
                                System.out.println("clicked Copy");
                                Log.info("log4j msg- clicked Copy");
                                
                                System.out.println("Employer Groups newcode"+newEmployerGroupsCode);
                                
                                //enter new code
                                wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsCodeInput));
                                driver.findElement(EmployerGroupsCodeInput).clear();
                                driver.findElement(EmployerGroupsCodeInput).sendKeys(newEmployerGroupsCode);
                                System.out.println("Entered new code");
                                Log.info("log4j msg- Entered new code");
                
                                System.out.println("Employer Groups new description"+newEmployerGroupsDescription);
                
                                //enter new description
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsDescriptionInput));
                                driver.findElement(EmployerGroupsDescriptionInput).clear();
                                driver.findElement(EmployerGroupsDescriptionInput).sendKeys(newEmployerGroupsDescription);
                                System.out.println("Entered new description");
                                Log.info("log4j msg- Entered new description");
                                
                                
                                //click save
                                wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsSaveLink));
                                driver.findElement(EmployerGroupsSaveLink).click();

                                System.out.println("Clicked save");
                                Log.info("log4j msg- clicked save");
                                Thread.sleep(2000);
                                BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
                        		
                                
                        		
                                } else{
                        			System.out.println("Employer Groups not found, cannot copy EmployerGroups");
                        			wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsExitLink));
                        			driver.findElement(EmployerGroupsExitLink).click();
                        			System.out.println("clicked Exit");
                        			Log.info("log4j msg- clicked Exit");
                        			
                        			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
                        		}
                
                                }catch (Exception e){System.out.println("error in Copying EmployerGroups"); 
                                Log.info("log4j msg-error in Copying EmployerGroups");  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();   }
                        		}
                        		
                 
                //edit function
                public void editEmployerGroups( String EmployerGroupsCode, String EmployerGroupsDescription, String effectiveDate)throws Exception{
                    
                    try{ 
                    
                    int i= searchEmployerGroups( EmployerGroupsCode, EmployerGroupsDescription);
            		
            		if (i==1){
            			System.out.println("Employer Groups  found, Continue with edit");
            			Log.info("log4j msg- Employer Groups found, Continue with edit");
            		
            		
                    System.out.println("Employer Groups code"+EmployerGroupsCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EmployerGroupsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EmployerGroupsCode+"']")).click();
                    System.out.println("clicked Employer Groups Code");
                    Log.info("log4j msg- clicked Employer Groups code");
                    
                    
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsEditLink));
                    driver.findElement(EmployerGroupsEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("Employer Groups Effective date"+ effectiveDate);                           
                    //enter effective date
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsEffectiveDate));
                    driver.findElement(EmployerGroupsEffectiveDate).clear();
                    Thread.sleep(1000);
                    driver.findElement(EmployerGroupsEffectiveDate).sendKeys(effectiveDate);
                    System.out.println("Entered effective date");
                    Log.info("log4j msg- Entered effective date");
                              
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsSaveLink));
                    driver.findElement(EmployerGroupsSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                    Thread.sleep(2000);
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
            		}
            		else{System.out.println(" Employer Group not found ");
                    Log.info("log4j msg-  Employer Group not found ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); }
                    
            		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Employer Groups ");
                    Log.info("log4j msg- Error in Editing Employer Groups ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); }
    
    
                    }
               
               
                
                
                
                
                //exit function
                public void exitEmployerGroups( String EmployerGroupsCode) throws Exception{
                try{
                                System.out.println("Employer Groups code"+EmployerGroupsCode);
                                                 Thread.sleep(1000);
                                                driver.findElement(EmployerGroupsExitLink).click();
                                                Thread.sleep(1000);
                                                System.out.println("Clicked exit in  Employer Groups ");
                                                Log.info("log4j msg- clicked exit in  Employer Groups ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
                                               
                	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exit Employer Groups ");
                Log.info("log4j msg- Error in Exit- Employer Groups ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); }}
                
               
                
                
                
                
                
                //add comm function
                public void addCommEmployerGroups( String EmployerGroupsCode, String EmployerGroupsName, String EmployerGroupsCommsubject, String EmployerGroupsCommNoteType, String EmployerGroupsCommMedium, String EmployerGroupsCommDetails) throws Exception{
                    
                    try{         
                    
                    int i= searchEmployerGroups( EmployerGroupsCode, EmployerGroupsName);
            		
            		if (i==1){
            			System.out.println("Employer Groups  found, Continue with Add communication");
            			Log.info("log4j msg- Employer Groups  found, Continue with Add communication");
            		
            		
                    System.out.println("Employer Groups code"+EmployerGroupsCode);
                  
                    //find EmployerGroups
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EmployerGroupsCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EmployerGroupsCode+"']")).click();
                    System.out.println("clicked Employer Groups Code");
                    Log.info("log4j msg- clicked Employer Groups code");
                    
                    //click comm                                
                    wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsCommLink));
                    driver.findElement(EmployerGroupsCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
                    driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
                                                    
                    System.out.println("clicked Add");
                    Log.info("log4j msg- clicked Add");
                                                    
                    //enter subject
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                    driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(EmployerGroupsCommsubject);
                    System.out.println("entered subject");
                    Log.info("log4j msg- entered subject");
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtFollowup']")));
                    driver.findElement(By.xpath("//input[@id='txtFollowup']")).sendKeys(Keys.PAGE_DOWN);
                    System.out.println("clicked page down");
                    Log.info("log4j msg- clicked page down");
                             Thread.sleep(2000);                       
                    //click add details
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@data-ng-click='addChildRecord()'])[2]")));
                    driver.findElement(By.xpath("(//button[@data-ng-click='addChildRecord()'])[2]")).click();
                    System.out.println("clicked add details");
                    Log.info("log4j msg- clicked add details");
                    Thread.sleep(2000);
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType"))); 
                                                    Select type = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                                    type.selectByVisibleText(EmployerGroupsCommNoteType);
                                                    System.out.println("selected note type");
                                                    Log.info("log4j msg-selected note type");
                                                    
                                                    Thread.sleep(2000);
                                                    //enter note details
                                                     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                    driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(EmployerGroupsCommDetails);
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
                                                    Thread.sleep(2000);
                                                    
                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); }
            		
                    
            		else{
            			 System.out.println("Employer Group not found, cannot add comm");
                         Log.info("log4j msg- Employer Group not found, cannot add comm");
                         
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); }
            			}
               catch (Exception e){e.printStackTrace();System.out.println("error in adding Comm to EmployerGroups"); 
               Log.info("error in adding Comm to EmployerGroups");
                    BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();    }   
       }
                    
    
               
                
                //delete function
        public void deleteEmployerGroups( String EmployerGroupsCode, String EmployerGroupsName) throws Exception{
                                
                                try{         
                                                
                                int i= searchEmployerGroups( EmployerGroupsCode, EmployerGroupsName);
                        		
                        		if (i==1){
                        			System.out.println("Employer Groups  found, continue with delete");
                        			Log.info("log4j msg-Employer Groups  found, continue with delete");
                        			
                                //find EmployerGroups
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EmployerGroupsCode+"']")));
                                                                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+EmployerGroupsCode+"']")).click();
                                                                System.out.println("clicked Employer GroupsCode");
                                                                Log.info("log4j msg- clicked Employer Groupscode");
                                                
                                                                //click delete
                                                                
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsDeleteLink));
                                                                driver.findElement(EmployerGroupsDeleteLink).click();
                                                                System.out.println("clicked Delete");
                                                                Log.info("log4j msg- clicked Delete");
                                                                
                                
                                                                //click confirm delete
                                                                
                                                                
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                                                driver.findElement(confirmDeleteButton).click();
                                                                System.out.println("clicked confirm Delete");
                                                                Log.info("log4j msg- clicked confirm Delete");
                                                                 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
                                                                
                                                                
                                
         

                
                
            } else{
    			System.out.println("cannot find Employer Groups");
    			Log.info("log4j msg- cannot find Employer Groups");
    			wait.until(ExpectedConditions.visibilityOfElementLocated(EmployerGroupsExitLink));
    			driver.findElement(EmployerGroupsExitLink).click();
    			System.out.println("clicked Exit");
    			Log.info("log4j msg- clicked Exit");
    			
    			
    			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
    			
            }} catch (Exception e){System.out.println("error in deleting Employer Groups");
            Log.info("log4j msg - error in deleting Employer Groups"); 
            BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit(); 
            }   
                }

}
                
                
                
                
              


