package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class BenefitClass {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By BenefitClassAddLink= 			By.linkText("Add");
	
	By BenefitClassCodeInput = 			By.xpath("//input[@id='txtSearchCode']");
	
	By BenefitClassDescriptionInput= 	By.xpath("//input[@id='txtName']");
	
	By BenefitClassValidateLink =		By.linkText("Validate");

	By BenefitClassValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
	
	By BenefitClassSaveLink =  			By.linkText("Save");
	
	By BenefitClassEditLink = 			By.linkText("Edit");
	
	By BenefitClassCopyLink = 			By.linkText("Copy");
	
	By BenefitClassDeleteLink= 			By.linkText("Delete");
	
	By confirmDeleteButton= 			By.xpath("//button[@data-bb-handler='Success']");
	
	By BenefitClassCommLink= 			By.linkText("Commun.");
	
	By BenefitClassExitLink=  			By.linkText("Exit");
	
	
	
	
	public BenefitClass(WebDriver driver){
		this.driver= driver;
		this.wait=  new WebDriverWait(driver, 40);
	}
	
	public int searchBenefitClass( String benefitClassCode) throws Exception{
		
		try{
		
				
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']"));
			java.util.Iterator<WebElement> i = list.iterator();
			
			
			for(int j=1;j<=173;j++){
				WebElement row = i.next(); 
				System.out.println(row.getText());
				
				if (row.getText().equalsIgnoreCase(benefitClassCode)){
			    	System.out.println("benefit class found");
			    	return 1;
			}
		
			}
		}catch (Exception e){ e.printStackTrace(); System.out.println("benefit class not found"); return 0;}
	
		return 0;
	}	
		
	
	

	//add function
	public void addBenefitClass(String benefitClassCode, String benefitClassDescription)throws Exception{
	
		try{ 
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassAddLink));
		driver.findElement(BenefitClassAddLink).click();
		System.out.println("clicked Add");
		Log.info("log4j msg- clicked Add");
		
		
		System.out.println("benefit class code: "+benefitClassCode);
		//enter code
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassCodeInput));
		driver.findElement(BenefitClassCodeInput).sendKeys(benefitClassCode);
		Thread.sleep(1000);
		System.out.println("Entered code:"+benefitClassCode);
		Log.info("log4j msg- Entered code"+benefitClassCode);
		
		System.out.println("benefit class description:"+benefitClassDescription);
		//enter Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassDescriptionInput));
		driver.findElement(BenefitClassDescriptionInput).sendKeys(benefitClassDescription);
		Thread.sleep(1000);
		System.out.println("Entered description");
		Log.info("log4j msg- Entered description");
	
		
		//click validate
	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassValidateLink));
		driver.findElement(BenefitClassValidateLink).click();
		System.out.println("clicked validate");
		Log.info("log4j msg- clicked validate");
		
		//click ok
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassValidateSaveOKButton));
		driver.findElement(BenefitClassValidateSaveOKButton).click();
		System.out.println("clicked validate ok to save button");
		Log.info("log4j msg- clicked validate ok to save button");
		
		
		//click save
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassSaveLink));
		driver.findElement(BenefitClassSaveLink).click();
		System.out.println("clicked save ");
		Log.info("log4j msg- clicked  save ");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		driver.quit(); 
		
		}catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Benefit Class ");
		Log.info("log4j msg- Error in Adding Benefit Class "); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit(); 
		}
		
	}
	
	//copy function
	
	public void copyBenefitClass(String benefitClassCode, String newBenefitClassCode, String newBenefitClassDescription)throws Exception{
		
		try{ 
		
		System.out.println("benefit class code"+benefitClassCode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitClassCode+"']")));
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitClassCode+"']")).click();
		System.out.println("clicked Benefit Class Code");
		Log.info("log4j msg- clicked Benefit Class code");
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassCopyLink));
		driver.findElement(BenefitClassCopyLink).click();
		System.out.println("clicked Copy");
		Log.info("log4j msg- clicked Copy");
		
		System.out.println("benefit class newcode"+newBenefitClassCode);
		
		//enter new code
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassCodeInput));
		driver.findElement(BenefitClassCodeInput).clear();
		driver.findElement(BenefitClassCodeInput).sendKeys(newBenefitClassCode);
		System.out.println("Entered new code");
		Log.info("log4j msg- Entered new code");
	
		System.out.println("benefit class new description:"+newBenefitClassDescription);
	Log.info("log4j msg- benefit class new description:"+newBenefitClassDescription);
		//enter new description
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassDescriptionInput));
		driver.findElement(BenefitClassDescriptionInput).clear();
		driver.findElement(BenefitClassDescriptionInput).sendKeys(newBenefitClassDescription);
		System.out.println("Entered new description");
		Log.info("log4j msg- Entered new description");
		
		//click save
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassSaveLink));
		driver.findElement(BenefitClassSaveLink).click();

		System.out.println("Clicked save");
		Log.info("log4j msg- clicked save");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Benefit Class ");
		Log.info("log4j msg- Error in Copying Benefit Class "); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit(); }
	
	
	}
	
	
	
	//edit function
public void editBenefitClass( String benefitClassCode,String newBenefitClassDescription)throws Exception{
		
		try{ 
		
		System.out.println("benefit class code"+benefitClassCode);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitClassCode+"']")));
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitClassCode+"']")).click();
		System.out.println("clicked Benefit Class Code");
		Log.info("log4j msg- clicked Benefit Class code");
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassEditLink));
		driver.findElement(BenefitClassEditLink).click();
		System.out.println("clicked Edit");
		Log.info("log4j msg- clicked Edit");
		
		Thread.sleep(1000);
		System.out.println("benefit class new Description"+newBenefitClassDescription);
		
		//enter new description
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassDescriptionInput));
		System.out.println("current description: "+driver.findElement(BenefitClassDescriptionInput).getText());
		driver.findElement(BenefitClassDescriptionInput).clear();
		Thread.sleep(1000);
		driver.findElement(BenefitClassDescriptionInput).sendKeys(newBenefitClassDescription);
		System.out.println("Entered new description");
		Log.info("log4j msg- Entered new description");
		
		
		Thread.sleep(1000);
		
		
		//click save
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassSaveLink));
		driver.findElement(BenefitClassSaveLink).click();
		Thread.sleep(1000);
		System.out.println("Clicked save");
		Log.info("log4j msg- clicked save");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Benefit Class ");
		Log.info("log4j msg- Error in Editing Benefit Class "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();}
	
	
	}

	//exit function
	public void exitBenefitClass( String benefitClassCode) throws Exception{
	try{
		System.out.println("benefit class code"+benefitClassCode);
				Thread.sleep(1000);
			driver.findElement(BenefitClassExitLink).click();
			Thread.sleep(1000);
			System.out.println("Clicked exit in  Benefit Class ");
			Log.info("log4j msg- clicked exit in  Benefit Class "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
				
	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Benefit Class -exit ");
	Log.info("log4j msg- Error in  Benefit Class - exit"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();}
	}
	
	
	//add comm function
	public void addCommBenefitClass( String benefitClassCode, String subject, String NoteType, String medium, String notes) throws Exception{
		
		try{ 	
			
		System.out.println("benefit class code"+benefitClassCode);
			
		//find benefit class
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitClassCode+"']")));
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitClassCode+"']")).click();
		System.out.println("clicked Benefit Class Code");
		Log.info("log4j msg- clicked Benefit Class code");
		
				//click comm
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassCommLink));
				driver.findElement(BenefitClassCommLink).click();
				System.out.println("clicked Comm");
				Log.info("log4j msg- clicked Comm");
				
				
				//click add
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
				driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
				
				System.out.println("clicked Add");
				Log.info("log4j msg- clicked Add");
				
				//enter subject
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSubject']")));
				driver.findElement(By.xpath("//input[@id='txtSubject']")).sendKeys(subject);
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
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlNoteType']")));
				Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
				placeOfService.selectByVisibleText(NoteType);
				System.out.println("selected note type");
				Log.info("log4j msg-selected note type");
				
				Thread.sleep(2000);
				//enter note details
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
				driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(notes);
				System.out.println("entered notes details");
				Log.info("log4j msg- entered notes details");
				Thread.sleep(2000);
				
				
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
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
				
				
			} catch (Exception e){e.printStackTrace();
			System.out.println("error in adding Comm to Benefit Class");
			Log.info("log4j msg - error in adding Comm to  Benefit Class"); 
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
			driver.quit();
		
		}
	}

	
	
	
	
	//delete function
	public void deleteBenefitClass(String benefitClassCode) throws Exception{
		
		try{	
		
				//find benefit class
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitClassCode+"']")));
				driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitClassCode+"']")).click();
				System.out.println("clicked Benefit Class Code");
				Log.info("log4j msg- clicked Benefit Class code");
			
				//click delete
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitClassDeleteLink));
				driver.findElement(BenefitClassDeleteLink).click();
				System.out.println("clicked Delete");
				Log.info("log4j msg- clicked Delete");
				
		
				//click confirm delete
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
				driver.findElement(confirmDeleteButton).click();
				System.out.println("clicked confirm Delete");
				Log.info("log4j msg- clicked confirm Delete");
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
				driver.quit();
				
				
		
	} catch (Exception e){System.out.println("error in deleting Benefit Class");
							Log.info("log4j msg - error in deleting Benefit Class"); 
							BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
							driver.quit();
		}
}

	
	
	
	
	
	
	

}
