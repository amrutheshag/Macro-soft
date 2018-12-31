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

public class BenefitProductListing {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By BenefitProductAddLink= By.linkText("Add");
	
	By BenefitProductCodeInput = By.xpath("//input[@id='code']");
	
	By BenefitProductDescriptionInput= By.xpath("//input[@id='name']");
	
	By BenefitProductValidateLink =By.linkText("Validate");
	
	By BenefitProductValidateSaveOKButton= By.xpath("//button[@data-bb-handler='Success']");
	
	By BenefitProductSaveLink =  By.linkText("Save");
	
	By BenefitProductEditLink = By.linkText("Edit");
	
	By BenefitProductCopyLink = By.linkText("Copy");
	
	By BenefitProductDeleteLink= By.linkText("Delete");
	
	By confirmDeleteButton= By.xpath("//button[@data-bb-handler='Success']");
	
	By BenefitProductCommLink= By.linkText("Commun.");
	
	By BenefitProductRecordMarkInput= By.xpath("//input[@data-ng-model='CredentialsListing.mark']");
	
	By BenefitProductExitLink=  By.linkText("Exit");
	
	
	public BenefitProductListing(WebDriver driver){
		this.driver= driver;
		this.wait = new WebDriverWait(driver, 25);
	}
	
	public int searchBenefitProduct(String benefitProductCode) throws Exception{
		
		try{
		
			
			
			List<WebElement> list = driver.findElements(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']"));
			java.util.Iterator<WebElement> i = list.iterator();
			
			for(int j=1;j<=173;j++){
				WebElement row = i.next(); 
				System.out.println(row.getText());
				
				if (row.getText().equalsIgnoreCase(benefitProductCode)){
			    	System.out.println("benefit Product found");
			    	Log.info("benefit Product found");
			    	return 1;
			}
		
			}
		}catch (Exception e){ e.printStackTrace(); System.out.println("benefit product not found"); 
		Log.info("benefit product not found");return 0;}
	
		return 0;
	}	
		
	
	

	//add function
	public void addBenefitProduct(String benefitProductCode, String benefitProductDescription)throws Exception{
	
		try{ 
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductAddLink));
		driver.findElement(BenefitProductAddLink).click();
		System.out.println("clicked Add");
		Log.info("log4j msg- clicked Add");
		
		
		System.out.println("benefit Product code: "+benefitProductCode);
		//enter code
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductCodeInput));
		driver.findElement(BenefitProductCodeInput).sendKeys(benefitProductCode);
		Thread.sleep(1000);
		System.out.println("Entered code");
		Log.info("log4j msg- Entered code");
		
		System.out.println("benefit Product description:"+benefitProductDescription);
		Log.info("benefit Product description:"+benefitProductDescription);
		//enter Description
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductDescriptionInput));
		driver.findElement(BenefitProductDescriptionInput).sendKeys(benefitProductDescription);
		Thread.sleep(1000);
		System.out.println("Entered description");
		Log.info("log4j msg- Entered description");
	
		
		//click validate
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductValidateLink));
		driver.findElement(BenefitProductValidateLink).click();
		System.out.println("clicked validate");
		Log.info("log4j msg- clicked validate");
		
		//click ok
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductValidateSaveOKButton));
		driver.findElement(BenefitProductValidateSaveOKButton).click();
		System.out.println("clicked validate ok to save button");
		Log.info("log4j msg- clicked validate ok to save button");
		
		
		//click save
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductSaveLink));
		driver.findElement(BenefitProductSaveLink).click();
		System.out.println("clicked save ");
		Log.info("log4j msg- clicked  save ");
		
		
		}catch (Exception e){e.printStackTrace();System.out.println("Error in Adding Benefit Product ");
		Log.info("log4j msg- Error in Adding Benefit Product "); }
		
		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	}
	
	//copy function
	
	public void copyBenefitProduct(String benefitProductCode, String newBenefitProductCode, String newBenefitProductDescription)throws Exception{
		
		try{
		
		System.out.println("benefit Product code"+benefitProductCode);
		//<div class="ui-grid-cell-contents ng-binding ng-scope" title="ACSC-MCD">ACSC-MCD</div>
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitProductCode+"']")));
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitProductCode+"']")).click();
		System.out.println("clicked Benefit Product Code");
		Log.info("log4j msg- clicked Benefit Product code");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductCopyLink));
		driver.findElement(BenefitProductCopyLink).click();
		System.out.println("clicked Copy");
		Log.info("log4j msg- clicked Copy");
		
		System.out.println("benefit class newcode"+newBenefitProductCode);
		Log.info("benefit class newcode"+newBenefitProductCode);
		//enter new code
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductCodeInput));
		driver.findElement(BenefitProductCodeInput).clear();
		driver.findElement(BenefitProductCodeInput).sendKeys(newBenefitProductCode);
		System.out.println("Entered new code");
		Log.info("log4j msg- Entered new code");
	
		System.out.println("benefit Product new description:"+newBenefitProductDescription);
		Log.info("benefit Product new description:"+newBenefitProductDescription);
		//enter new description
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductDescriptionInput));
		driver.findElement(BenefitProductDescriptionInput).clear();
		driver.findElement(BenefitProductDescriptionInput).sendKeys(newBenefitProductDescription);
		System.out.println("Entered new description");
		Log.info("log4j msg- Entered new description");
		
		
		
		
		
		//click save
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductSaveLink));
		driver.findElement(BenefitProductSaveLink).click();

		System.out.println("Clicked save");
		Log.info("log4j msg- clicked save");
		
		
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Copying Benefit Product ");
		Log.info("log4j msg- Error in Copying Benefit Product "); }
	
	
		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	}
	
	
	
	//edit function
	public void editBenefitProduct( String benefitProductCode,String recordMark)throws Exception{
		
		try{ 
			
		
		System.out.println("benefit class code"+benefitProductCode);
		//<div class="ui-grid-cell-contents ng-binding ng-scope" title="ACSC-MCD">ACSC-MCD</div>
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitProductCode+"']")));
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitProductCode+"']")).click();
		System.out.println("clicked Benefit product Code");
		Log.info("log4j msg- clicked Benefit product code");
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductEditLink));
		driver.findElement(BenefitProductEditLink).click();
		System.out.println("clicked Edit");
		Log.info("log4j msg- clicked Edit");
		
		Thread.sleep(1000);
		System.out.println("benefit product new Record Mark:"+recordMark);
		Log.info("benefit product new Record Mark:"+recordMark);
		
		//enter new description
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductRecordMarkInput));
		driver.findElement(BenefitProductRecordMarkInput).clear();
		Thread.sleep(1000);
		driver.findElement(BenefitProductRecordMarkInput).sendKeys(recordMark);
		System.out.println("Entered Record Mark");
		Log.info("log4j msg- Entered Record Mark");
		
		
		Thread.sleep(1000);
		
		
		//click save
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductSaveLink));
		driver.findElement(BenefitProductSaveLink).click();
		Thread.sleep(1000);
		System.out.println("Clicked save");
		Log.info("log4j msg- clicked save");
		
		
		
		}catch (Exception e){ e.printStackTrace();System.out.println("Error in Editing Benefit Product ");
		Log.info("log4j msg- Error in Editing Benefit Product "); }
	
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());driver.quit();
	}
	




//exit function
	public void exitBenefitProduct(String benefitProductCode) throws Exception{
	try{
		System.out.println("benefit product code"+benefitProductCode);
			Thread.sleep(1000);
			driver.findElement(BenefitProductExitLink).click();
			Thread.sleep(1000);
			System.out.println("Clicked exit in  Benefit Product ");
			Log.info("log4j msg- clicked exit in  Benefit Product "); 
			
	}catch (Exception e){ e.printStackTrace();System.out.println("Error in Adding Benefit Product ");
	Log.info("log4j msg- Error in Adding Benefit Product "); }
	
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  driver.quit();
	
	}
	
	
	//add comm function
	public void addCommBenefitProduct( String benefitProductCode, String subject, String NoteType, String medium, String notes) throws Exception{
		
		try{ 	
			
		System.out.println("benefit class product"+benefitProductCode);
			
		//find benefit class
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitProductCode+"']")));
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitProductCode+"']")).click();
		System.out.println("clicked Benefit product Code");
		Log.info("log4j msg- clicked Benefit product code");
		
				//click comm
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductCommLink));
				driver.findElement(BenefitProductCommLink).click();
				System.out.println("clicked Comm");
				Log.info("log4j msg- clicked Comm");
				
				Thread.sleep(2000);
				//click add
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")));
				driver.findElement(By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]")).click();
				System.out.println("clicked Add");
				Log.info("log4j msg- clicked Add");
				Thread.sleep(1000);
				
				//enter subject
				//<input type="text" id="txtSubject" tabindex="1" class="form-control ng-pristine ng-valid ng-empty ng-valid-maxlength ng-touched" maxlength="70" data-ng-model="currentRecord.subject" data-ng-disabled="isAuditing" style="width: 100%;">
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
				
				
				//select note type
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
				
			} catch (Exception e){e.printStackTrace();System.out.println("error in adding Comm to Benefit Product");
								Log.info("log4j msg - error in adding Comm to  Benefit Product"); 
		}
	
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
		
	
	}

	
	
	
	
	//delete function
	public void deleteBenefitProduct( String benefitProductCode) throws Exception{
		
		try{	
			
			
		
				//find benefit class
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitProductCode+"']")));
				driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+benefitProductCode+"']")).click();
				System.out.println("clicked Benefit Product Code");
				Log.info("log4j msg- clicked Benefit Product code");
			
				//click delete
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitProductDeleteLink));
				driver.findElement(BenefitProductDeleteLink).click();
				System.out.println("clicked Delete");
				Log.info("log4j msg- clicked Delete");
				
		
				//click confirm delete
				wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
				driver.findElement(confirmDeleteButton).click();
				System.out.println("clicked confirm Delete");
				Log.info("log4j msg- clicked confirm Delete");
				
		} catch (Exception e){System.out.println("error in deleting Benefit Product");
							Log.info("log4j msg - error in deleting Benefit Product"); 
		}

	
	
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	}


}
