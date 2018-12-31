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

public class LegalRepresentatives{

				WebDriver driver;
				WebDriverWait wait; 
				
				By LegalRepresentativesCodeBeginsInput = By.xpath("//input[@data-ng-model='searchOptions.legalrep']");
				
				By LegalRepresentativesNameDescriptionBeginsInput = By.xpath("//input[@data-ng-model='searchOptions.name']");

				By LegalRepresentativesSearchButton= By.xpath("//button[@data-ng-click='search()']");
                
                By LegalRepresentativesEffectiveDate = By.id("txtEffectiveDate");
                
                By LegalRepresentativesAddLink= By.linkText("Add");
                
                By LegalRepresentativesCodeInput = By.xpath("//input[@id='txtCode']");
 
                By LegalRepresentativesDescriptionInput= By.xpath("//input[@id='txtName']");
                
                By LegalRepresentativesFirm = By.xpath("//input[@id='txtFirm']");
                
                By LegalRepresentativesValidateLink =By.linkText("Validate");
                
                By LegalRepresentativesValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
                
                By LegalRepresentativesSaveLink =  By.linkText("Save");
                
                By LegalRepresentativesEditLink = By.linkText("Edit");
                
                By LegalRepresentativesCopyLink = By.linkText("Copy");
                
                By LegalRepresentativesDeleteLink= By.linkText("Delete");
                
                By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
                
                By LegalRepresentativesCommLink= By.linkText("Commun.");
                
                By LegalRepresentativesExitLink=  By.linkText("Exit");
                
                
                
                
                public LegalRepresentatives(WebDriver driver){
                                this.driver= driver;
                                this.wait = new WebDriverWait(driver, 35);   
                }
                
                
            	public int searchLegalRepresentatives( String LegalRepresentativesCode, String LegalRepresentativesName) throws Exception{
            			
            		try{
            		//enter  LegalRepresentativescode
            		wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesCodeBeginsInput));
            		driver.findElement(LegalRepresentativesCodeBeginsInput).clear();
            		driver.findElement(LegalRepresentativesCodeBeginsInput).sendKeys(LegalRepresentativesCode);
            		System.out.println("entered Legal Representatives code");
            		Log.info("log4j msg- entered Legal Representatives code");
            	
            	
            		//enter  LegalRepresentativesname
            		wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesNameDescriptionBeginsInput));
            		driver.findElement(LegalRepresentativesNameDescriptionBeginsInput).clear();
            		driver.findElement(LegalRepresentativesNameDescriptionBeginsInput).sendKeys(LegalRepresentativesName);
            		System.out.println("entered Legal Representatives name");
            		Log.info("log4j msg- entered Legal Representatives name");
            		
            		//click search
            		wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesSearchButton));
            		driver.findElement(LegalRepresentativesSearchButton).click();
            		System.out.println("clicked Search");
            		Log.info("log4j msg- clicked Search");
            				
            		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+LegalRepresentativesCode+"']")));
            		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+LegalRepresentativesCode+"']"));
            		e.click();
            		System.out.println("Found LegalRepresentatives");
            		Log.info("log4j msg- Found LegalRepresentatives");
            	
            		return 1;
            		}
            		
            	catch(Exception e){
             		Log.info("log4j msg- LegalRepresentatives not found"); System.out.println("LegalRepresentatives not found"); return 0;}
            		
            	}

                //add function
                public void addLegalRepresentatives( String LegalRepresentativesCode, String LegalRepresentativesDescription)throws Exception{
                
                                try{ 
                                int i= searchLegalRepresentatives( LegalRepresentativesCode, LegalRepresentativesDescription);
                        		
                        		if (i==0){
                        			System.out.println("Legal Representatives not found, Continue with Add");
                        			Log.info("log4j msg- Legal Representatives not found, Continue with Add");
                        		
                        		
                                wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesAddLink));
                                driver.findElement(LegalRepresentativesAddLink).click();
                                System.out.println("clicked Add");
                                Log.info("log4j msg- clicked Add");
                                
                                Thread.sleep(1000);
                                System.out.println("Legal Representatives code: "+LegalRepresentativesCode);
                                
                                //enter code
                                wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesCodeInput));
                                driver.findElement(LegalRepresentativesCodeInput).sendKeys(LegalRepresentativesCode);
                                Thread.sleep(1000);
                                System.out.println("Entered code");
                                Log.info("log4j msg- Entered code");
                                Thread.sleep(1000);
                                
                                System.out.println("Legal Representatives description"+LegalRepresentativesDescription);
                                //enter Description
                                wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesDescriptionInput));
                                driver.findElement(LegalRepresentativesDescriptionInput).sendKeys(LegalRepresentativesDescription);
                                Thread.sleep(1000);
                                System.out.println("Entered description");
                                Log.info("log4j msg- Entered description");
                                
                                //click validate
                
                                Thread.sleep(1000);
                                wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesValidateLink));
                                driver.findElement(LegalRepresentativesValidateLink).click();
                                System.out.println("clicked validate");
                                Log.info("log4j msg- clicked validate");
                                
                                //click ok
                                Thread.sleep(2000);
                                wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesValidateSaveOKButton));
                                driver.findElement(LegalRepresentativesValidateSaveOKButton).click();
                                System.out.println("clicked validate ok to save button");
                                Log.info("log4j msg- clicked validate ok to save button");
                                
                        		
                                //click save
                                Thread.sleep(2000);
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesSaveLink));
                                driver.findElement(LegalRepresentativesSaveLink).click();
                                System.out.println("clicked save ");
                                Log.info("log4j msg- clicked  save ");
                                
                                Thread.sleep(2000);
                                  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                
                                } else{
                        			System.out.println("Legal Representatives is already present, cannot add Legal Representatives");
                        			Log.info("log4j msg-Legal Representatives is already present, cannot add Legal Representatives");
                        			wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesExitLink));
                        			driver.findElement(LegalRepresentativesExitLink).click();
                        			System.out.println("clicked Exit");
                        			Log.info("log4j msg- clicked Exit");
                        			
                        			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                        		}
                
                                }catch (Exception e){ e.printStackTrace(); System.out.println("error in adding LegalRepresentatives"); Log.info("log4j msg-error in adding LegalRepresentatives");  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit(); }
                        		}
                                
                //copy function
                
                public void copyLegalRepresentatives( String LegalRepresentativesCode, String LegalRepresentativesName, String newLegalRepresentativesCode, String newLegalRepresentativesDescription)throws Exception{
                                
                                try{
                                int i= searchLegalRepresentatives( LegalRepresentativesCode, LegalRepresentativesName);
                        		
                        		if (i==1){
                        			System.out.println("Legal Representatives found, continue with copy");
                        			Log.info("log4j msg-Legal Representatives found, continue with copy");
                        		
                                
                                System.out.println("Legal Representatives code"+LegalRepresentativesCode);
                                 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+LegalRepresentativesCode+"']")));
                                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+LegalRepresentativesCode+"']")).click();
                                System.out.println("clicked Legal Representatives Code");
                                Log.info("log4j msg- clicked Legal Representatives code");
                                
                                
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesCopyLink));
                                driver.findElement(LegalRepresentativesCopyLink).click();
                                System.out.println("clicked Copy");
                                Log.info("log4j msg- clicked Copy");
                                
                                System.out.println("Legal Representatives newcode"+newLegalRepresentativesCode);
                                
                                //enter new code
                                wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesCodeInput));
                                driver.findElement(LegalRepresentativesCodeInput).clear();
                                driver.findElement(LegalRepresentativesCodeInput).sendKeys(newLegalRepresentativesCode);
                                System.out.println("Entered new code");
                                Log.info("log4j msg- Entered new code");
                
                                System.out.println("Legal Representatives new description"+newLegalRepresentativesDescription);
                                
                                //enter new description
                                
                                wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesDescriptionInput));
                                driver.findElement(LegalRepresentativesDescriptionInput).clear();
                                driver.findElement(LegalRepresentativesDescriptionInput).sendKeys(newLegalRepresentativesDescription);
                                System.out.println("Entered new description");
                                Log.info("log4j msg- Entered new description");
                                
                                
                                //click save
                                wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesSaveLink));
                                driver.findElement(LegalRepresentativesSaveLink).click();

                                System.out.println("Clicked save");
                                Log.info("log4j msg- clicked save");
                                BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                        		
                                } else{
                        			System.out.println("Legal Representatives not found, cannot copy LegalRepresentatives");
                        			wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesExitLink));
                        			driver.findElement(LegalRepresentativesExitLink).click();
                        			System.out.println("clicked Exit");
                        			Log.info("log4j msg- clicked Exit");
                        			
                        			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                        		}
                
                                }catch (Exception e){System.out.println("error in Copying LegalRepresentatives"); Log.info("log4j msg-error in Copying LegalRepresentatives");  BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();   }
                        		}
                        		
                        		
                
                //edit function
                public void editLegalRepresentatives( String LegalRepresentativesCode, String LegalRepresentativesDescription, String firmName)throws Exception{
                    
                    try{
                    int i= searchLegalRepresentatives( LegalRepresentativesCode, LegalRepresentativesDescription);
            		
            		if (i==1){
            			System.out.println("Legal Representatives  found, Continue with edit");
            			Log.info("log4j msg- Legal Representatives found, Continue with edit");
            		
            		
                    System.out.println("Legal Representatives code"+LegalRepresentativesCode);
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+LegalRepresentativesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+LegalRepresentativesCode+"']")).click();
                    System.out.println("clicked Legal Representatives firm");
                    Log.info("log4j msg- clicked Legal Representatives firm");
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesEditLink));
                    driver.findElement(LegalRepresentativesEditLink).click();
                    System.out.println("clicked Edit");
                    Log.info("log4j msg- clicked Edit");
                    
                    System.out.println("Legal Representatives firm name"+ firmName);
                                                   
                    //enter Firm
                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesFirm));
                    driver.findElement(LegalRepresentativesFirm).clear();
                    Thread.sleep(1000);
                    driver.findElement(LegalRepresentativesFirm).sendKeys(firmName);
                    System.out.println("Entered  firm");
                    Log.info("log4j msg- Entered  firm");
                    
                    //click save
                    wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesSaveLink));
                    driver.findElement(LegalRepresentativesSaveLink).click();
                    System.out.println("Clicked save");
                    Log.info("log4j msg- clicked save");
                      BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
            		}
            		else{System.out.println(" Employer Group not found ");
                    Log.info("log4j msg-  Employer Group not found ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
                    
            		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Legal Representatives ");
                    Log.info("log4j msg- Error in Editing Legal Representatives ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
    
    
                    }
                
                
                
                //exit function
                public void exitLegalRepresentatives( String LegalRepresentativesCode) throws Exception{
                try{
                	System.out.println("Legal Representatives code"+LegalRepresentativesCode);
                                               Thread.sleep(1000);
                                                driver.findElement(LegalRepresentativesExitLink).click();
                                                Thread.sleep(1000);
                                                System.out.println("Clicked exit in  Legal Representatives ");
                                                Log.info("log4j msg- clicked exit in  Legal Representatives ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                                                
                	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Exit Legal Representatives ");
                Log.info("log4j msg- Error in Exit- Legal Representatives ");   BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}}
               
                
                
                
                //add  function
                public void addCommLegalRepresentatives( String LegalRepresentativesCode, String LegalRepresentativesName, String LegalRepresentativesCommsubject, String LegalRepresentativesCommNoteType, String LegalRepresentativesCommMedium, String LegalRepresentativesCommDetails) throws Exception{
                    
                    try{   
                    int i= searchLegalRepresentatives( LegalRepresentativesCode, LegalRepresentativesName);
            		
            		if (i==1){
            			System.out.println("Legal Representatives  found, Continue with Add communication");
            			Log.info("log4j msg- Legal Representatives  found, Continue with Add communication");
            		
            		
                    System.out.println("Legal Representatives code"+LegalRepresentativesCode);
                                    //find LegalRepresentatives
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+LegalRepresentativesCode+"']")));
                    driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+LegalRepresentativesCode+"']")).click();
                    System.out.println("clicked Legal Representatives Code");
                    Log.info("log4j msg- clicked Legal Representatives code");
                    
                                                    //click comm
                                                    
                    wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesCommLink));
                    driver.findElement(LegalRepresentativesCommLink).click();
                    System.out.println("clicked Comm");
                    Log.info("log4j msg- clicked Comm");

                                                    
                                                    
                                                    //click add
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/img[1]")));
                                                    driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/img[1]")).click();
                                                    
                                                   
                                                    
                                                    System.out.println("clicked Add");
                                                    Log.info("log4j msg- clicked Add");
                                                    
                                                    //enter subject
                                                   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
                                                    driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(LegalRepresentativesCommsubject);
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
                                                    
                                                    Thread.sleep(1000);
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType"))); 
                                                    Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
                                                    placeOfService.selectByVisibleText(LegalRepresentativesCommNoteType);
                                                    System.out.println("selected note type");
                                                    Log.info("log4j msg-selected note type");
                                                    
                                                    Thread.sleep(1000);
                                                    //enter note details
                                                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
                                                    driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(LegalRepresentativesCommDetails);
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
                                                    
                                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
            		
                    
            		else{
            			 System.out.println("Legal Representative not found, cannot add comm");
                         Log.info("log4j msg- Legal Representative not found, cannot add comm");
                         
                         BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
            			}
                    
                                                    
                                     catch (Exception e){
                                    	 e.printStackTrace();
                                     System.out.println("error in adding Comm to LegalRepresentatives");
                                     Log.info("log4j msg - error in adding Comm to  LegalRepresentatives"); 
                     BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
                     driver.quit();   }   
                                     
                                     }
                    
    

                            	
                                                
                                
                
                
                //delete function
                public void deleteLegalRepresentatives( String LegalRepresentativesCode, String LegalRepresentativesName) throws Exception{
                                
                                try{            
                                int i= searchLegalRepresentatives( LegalRepresentativesCode, LegalRepresentativesName);
                        		
                        		if (i==1){
                        			System.out.println("Legal Representatives  found, continue with delete");
                        			Log.info("log4j msg-Legal Representatives  found, continue with delete");
                        			
                                //find LegalRepresentatives
                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+LegalRepresentativesCode+"']")));
                                driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+LegalRepresentativesCode+"']")).click();
                                System.out.println("clicked Legal RepresentativesCode");
                                Log.info("log4j msg- clicked Legal Representativescode");
                            
                                //click delete
                                wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesDeleteLink));
                                driver.findElement(LegalRepresentativesDeleteLink).click();
                                System.out.println("clicked Delete");
                                Log.info("log4j msg- clicked Delete");
                                                                
                                
                                //click confirm delete
                                wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
                                driver.findElement(confirmDeleteButton).click();
                                System.out.println("clicked confirm Delete");
                                Log.info("log4j msg- clicked confirm Delete");
                                BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
                } else{
    			System.out.println("cannot find Legal Representatives");
    			Log.info("log4j msg- cannot find Legal Representatives");
    			wait.until(ExpectedConditions.visibilityOfElementLocated(LegalRepresentativesExitLink));
    			driver.findElement(LegalRepresentativesExitLink).click();
    			System.out.println("clicked Exit");
    			Log.info("log4j msg- clicked Exit");
    			
    			
    			 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
    			
            }} catch (Exception e){System.out.println("error in deleting Legal Representatives");
            Log.info("log4j msg - error in deleting Legal Representatives"); 
            BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
            driver.quit();
            }   
                }


}
                
                
                
                
              


