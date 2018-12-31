package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class TaxPayerAndRateListingPage {
	 
	WebDriver driver;
	WebDriverWait wait;
	
	By TaxPayerAndRateCodeBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.tin']");

	By TaxPayerAndRateNameBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.name']");

	By TaxPayerAndRateSearchButton = By.xpath("//button[text()='Search']");

	By TaxPayerAndRateCodeAddInput = By.xpath("//input[@data-ng-model='taxPayer.tin']");

	By TaxPayerAndRateNameAddInput = By.xpath("//input[@data-ng-model='taxPayer.name']");

	By AddLink = By.linkText("Add");
	
	By AddTaxExemptionDetailsButton = By.xpath("//button[@ng-click='addExamption()']");
	
	By TaxExemptionStartDateInput = By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='01/01/2018']");
	
	By TaxExemptionEndDateInput = By.xpath("(//div[@class='ui-grid-cell-contents ng-binding ng-scope' ])[4]");
	
	By TaxExemptionAmountInput = By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='$0.00']");	
	
	By TaxRateAddButton  = By.xpath("//button[@ng-click='addRate()']");
	
	By TaxRateStartDateInput = By.xpath("//div[@data-ng-model='taxRate.effective']");
	
	By TaxRateEndDateInput=  By.id("terminateddate");
	
	By TaxRatePercentageInput = By.xpath("//input[@data-ng-model='taxRate.tax_rate']");
	
	By ClaimTypeButton = By.xpath("//button[@data-ng-click='openClaimFilter()']");
	
	By ClaimTypeQueryInput =By.xpath("//input[@data-ng-model='taxRate.claim']");
	
	By ClaimTypeSearch = By.xpath("//button[@data-ng-click='search()']");
	
	By ServiceTypeButton = By.xpath("//button[@data-ng-click='openServiceFilter()']");

	By ServiceTypeQueryInput = By.xpath("//input[@data-ng-model='taxRate.service']");
	
	By ServiceTypeSearchButton = By.xpath("//button[@data-ng-click='search()']");
	
	By TaxRateHideButton = By.xpath("//button[@data-ng-click='closeMe()']");
	
	By AddLinkInComm= By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/img[1]");

	By SaveLink = By.linkText("Save");

	By ExitLink = By.linkText("Exit");

	By DeleteLink = By.linkText("Delete");

	By CommLink = By.linkText("Commun.");

	By EditLink = By.linkText("Edit");
	
	By EditRateButton= By.xpath("//button[@ng-click='editRate()']");

	By EditLinkInQuery = By.linkText("Edit");
	
	By EditQueryNameInput= By.xpath("//input[@data-ng-model='query.name']");
	
	By SaveLinkInQuery = By.xpath("id('modalContentQuery')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[2]/li[2]/a[1]/img[1]");
	
	By CopyLink = By.linkText("Copy");

	By ValidateLink = By.linkText("Validate");

	By TaxPayerAndRateNotes = By.xpath("//textarea[@data-ng-model='schedule.notes']");

	By ValidateSaveOKButton= By.xpath("//button[text()='OK']");

	By ConfirmDeleteYesButton = By.xpath("//button[text()='Yes']");
	
	By ReturnSelectionLink = By.linkText("Return Selection");
	
	By AddCommSubjectInput = By.id("txtSubject");

	By AddCommType = By.id("ddlCaseType");
	
	By AddCommFollowupDateInput = By.id("txtFollowup");

	By AddCommPriority = By.id("ddlCasePriority");
			
	By AddCommAddDetailsButton = By.xpath("//button[@data-ng-click='addChildRecord()']");
			
	By AddCommNoteType = By.id("ddlNoteType");

	By AddCommMedium = By.id("ddlMedium");

	By AddCommDetails = By.id("txtNotes");	

	By AddCommHideButton = By.xpath("//button[@data-ng-click='closeMe()']");


	public TaxPayerAndRateListingPage(WebDriver driver){
			this.driver= driver;
			this.wait = new WebDriverWait(driver, 35);    
		}
		

		public int searchTaxPayerAndRateListing( String TaxPayerAndRateCode, String TaxPayerAndRateName) throws Exception{
			
			try{
			//enter  InsurerPayer code
			wait.until(ExpectedConditions.visibilityOfElementLocated(TaxPayerAndRateCodeBeginsInput));
			driver.findElement(TaxPayerAndRateCodeBeginsInput).clear();
			driver.findElement(TaxPayerAndRateCodeBeginsInput).sendKeys(TaxPayerAndRateCode);
			System.out.println("entered TaxPayerAndRate code");
			Log.info("log4j msg- entered TaxPayerAndRate code");
		
		
			//enter  InsurerPayer name
			wait.until(ExpectedConditions.visibilityOfElementLocated(TaxPayerAndRateNameBeginsInput));
			driver.findElement(TaxPayerAndRateNameBeginsInput).clear();
			driver.findElement(TaxPayerAndRateNameBeginsInput).sendKeys(TaxPayerAndRateName);
			System.out.println("entered TaxPayerAndRate name");
			Log.info("log4j msg- entered TaxPayerAndRate  name");
			
			//click search
			wait.until(ExpectedConditions.visibilityOfElementLocated(TaxPayerAndRateSearchButton));
			driver.findElement(TaxPayerAndRateSearchButton).click();
			System.out.println("clicked Search");
			Log.info("log4j msg- clicked Search");
					
			//<div class="ui-grid-cell-contents ng-binding ng-scope" title="ACSC">ACSC</div>
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+TaxPayerAndRateCode+"']")));
			WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+TaxPayerAndRateCode+"']"));
			e.click();
			System.out.println("Found TaxPayerAndRate");
			Log.info("log4j msg- Found TaxPayerAndRate");
		
			return 1;
			}
			
		catch(Exception e){ System.out.println("TaxPayerAndRate Not found"); Log.info("log4j msg-TaxPayerAndRate not found"); return 0;}
			
		}
		

		public void addTaxPayerAndRate( String TaxPayerAndRateCode, String TaxPayerAndRateName, String taxExemptionStartDate, String taxExemptionEndDate, String taxExemptionAmount, String taxRateStartDate, String taxRateEndDate, String taxRatePercentage, String claimType, String serviceType) throws Exception{
			try{
			int i= searchTaxPayerAndRateListing( TaxPayerAndRateCode, TaxPayerAndRateName);
			
			if (i==0){
				System.out.println("TaxPayerAndRate not found, Continue with Add");
				Log.info("log4j msg- TaxPayerAndRate not found, Continue with Add");
			
				//click add
				wait.until(ExpectedConditions.visibilityOfElementLocated(AddLink));
				driver.findElement(AddLink).click();
				Thread.sleep(1000);
				System.out.println("clicked add");
				Log.info("log4j msg- clicked add");
				
				
				
				//enter code
				wait.until(ExpectedConditions.visibilityOfElementLocated(TaxPayerAndRateCodeAddInput));
				driver.findElement(TaxPayerAndRateCodeAddInput).sendKeys(TaxPayerAndRateCode);
				Thread.sleep(1000);
				System.out.println("Entered code");
				Log.info("log4j msg- Entered code");
				
				
				//enter name
				wait.until(ExpectedConditions.visibilityOfElementLocated(TaxPayerAndRateNameAddInput));
				driver.findElement(TaxPayerAndRateNameAddInput).sendKeys(TaxPayerAndRateName);
				Thread.sleep(1000);
				System.out.println("Entered name");
				Log.info("log4j msg- Entered name");
			
				//click add to add details to tax payer exemption table
				wait.until(ExpectedConditions.visibilityOfElementLocated(AddTaxExemptionDetailsButton));
				driver.findElement(AddTaxExemptionDetailsButton).click();
				Thread.sleep(1000);
				System.out.println("clicked Add Exemption Button");
				Log.info("log4j msg- clicked Add Exemption Button");
				
				Thread.sleep(1000);
				//change term date to 12/31 2018
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(TaxExemptionEndDateInput));
				WebElement e= driver.findElement(TaxExemptionEndDateInput);
				System.out.println("Tax exemption end date:"+taxExemptionEndDate);
				Actions action=new Actions(driver);
				//action.moveToElement(e).doubleClick().sendKeys(taxExemptionEndDate).perform();
				//action.moveToElement(e).doubleClick().perform();
				//e.clear();
				action.moveToElement(e).doubleClick().sendKeys(taxExemptionEndDate).perform();
				

				Thread.sleep(1000);
				System.out.println("entered tax exemption end date");
				Log.info("log4j msg- entered tax exemption end date");
				
				//change exemption amt to $1500
				wait.until(ExpectedConditions.visibilityOfElementLocated(TaxExemptionAmountInput));
				WebElement e1= driver.findElement(TaxExemptionAmountInput);
				
				action.moveToElement(e1).doubleClick().sendKeys(taxExemptionAmount).perform();
				
				Thread.sleep(1000);
				System.out.println("entered tax exemption amount");
				Log.info("log4j msg- entered tax exemption amount");
				
				//change tax rate table
				
				//click add
				wait.until(ExpectedConditions.visibilityOfElementLocated(TaxRateAddButton));
				driver.findElement(TaxRateAddButton).click();
				Thread.sleep(1000);
				System.out.println("clicked Add Rate Button");
				Log.info("log4j msg- clicked Add Rate Button");
				
				
				//change start date to 01012018
				
				Thread.sleep(1000);
				
				//change end date to 12/31/2018
				System.out.println("end date"+taxRateEndDate);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(TaxRateEndDateInput));
				driver.findElement(TaxRateEndDateInput).clear();
				driver.findElement(TaxRateEndDateInput).sendKeys(taxRateEndDate);
				Thread.sleep(2000);
				System.out.println("entered tax rate end date");
				Log.info("log4j msg- entered tax rate end date");
				
				
				
				//change rate to 7%
				wait.until(ExpectedConditions.visibilityOfElementLocated(TaxRatePercentageInput));
				driver.findElement(TaxRatePercentageInput).sendKeys(taxRatePercentage);
				Thread.sleep(1000);
				System.out.println("entered tax rate percentage");
				Log.info("log4j msg- entered tax rate percentage");
				
				Thread.sleep(2000);
				
				//enter claim type query
				System.out.println("claim type query" +claimType);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimTypeQueryInput));
				driver.findElement(ClaimTypeQueryInput).sendKeys(claimType);
				Thread.sleep(1000);
				System.out.println("entered claim type");
				Log.info("log4j msg- entered claim type");
				
//click claim type
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimTypeButton));
				driver.findElement(ClaimTypeButton).click();
				Thread.sleep(1000);
				System.out.println("clicked claim type button");
				Log.info("log4j msg- clicked claim type button");
				
				Thread.sleep(3000);
				
				
				//click search
				wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimTypeSearch));
				driver.findElement(ClaimTypeSearch).click();
				Thread.sleep(1000);
				System.out.println("clicked claim type search button");
				Log.info("log4j msg- clicked claim type search button");
				
				//click return selection
				wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
				driver.findElement(ReturnSelectionLink).click();
				Thread.sleep(1000);
				System.out.println("clicked Return Selection");
				Log.info("log4j msg- clicked Return Selection");
				
				//click save
				Thread.sleep(1000);
				//click close
				
				//enter service type
				wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceTypeQueryInput));
				driver.findElement(ServiceTypeQueryInput).sendKeys(serviceType);
				Thread.sleep(1000);
				System.out.println("entered service type");
				Log.info("log4j msg- entered service type");
				
				
				
				//click service type
				wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceTypeButton));
				driver.findElement(ServiceTypeButton).click();
				Thread.sleep(1000);
				System.out.println("clicked service type button");
				Log.info("log4j msg- clicked service type button");
				
				
				//click search
				wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceTypeSearchButton));
				driver.findElement(ServiceTypeSearchButton).click();
				Thread.sleep(1000);
				System.out.println("clicked service type search button");
				Log.info("log4j msg- clicked service type search button");
				
				Thread.sleep(1000);
				//click return selection
				wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
				driver.findElement(ReturnSelectionLink).click();
				Thread.sleep(1000);
				System.out.println("clicked Return Selection");
				Log.info("log4j msg- clicked Return Selection");
				
				//click hide
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(TaxRateHideButton));
				driver.findElement(TaxRateHideButton).click();
				System.out.println("clicked Hide");
				Log.info("log4j msg- clicked Hide");
								
				//click validate
			
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLink));
				driver.findElement(ValidateLink).click();
				System.out.println("clicked validate");
				Log.info("log4j msg- clicked validate");
				
				//click ok
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateSaveOKButton));
				driver.findElement(ValidateSaveOKButton).click();
				System.out.println("clicked validate ok to save button");
				Log.info("log4j msg- clicked validate ok to save button");
				
				Thread.sleep(2000);
				//click save
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
				driver.findElement(SaveLink).click();
				System.out.println("clicked save ");
				Log.info("log4j msg- clicked  save ");
	
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
				driver.quit();
				
				}
			else { 
			System.out.println("Already present"); Log.info("log4j msg - Already present");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
			}
			}catch (Exception e){e.printStackTrace();System.out.println("Error in Adding TaxPayerAndRate ");
			Log.info("log4j msg- Error in Adding TaxPayerAndRate "); 
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
			}
				
			}

	public void copyTaxPayerAndRate( String TaxPayerAndRateCode, String TaxPayerAndRateName, String newCode, String newName) throws Exception{
		
		try{
		int i= searchTaxPayerAndRateListing( TaxPayerAndRateCode, TaxPayerAndRateName);
		
		if (i==1){
			System.out.println("TaxPayerAndRate found, Continue with Copy");
			Log.info("log4j msg- TaxPayerAndRate found, Continue with Copy");
		
			//click copy
			wait.until(ExpectedConditions.visibilityOfElementLocated(CopyLink));
			driver.findElement(CopyLink).click();
			Thread.sleep(1000);
			System.out.println("clicked copy");
			Log.info("log4j msg- clicked copy");
			
			System.out.println("new tax id"+newCode);
			//enter code
			wait.until(ExpectedConditions.visibilityOfElementLocated(TaxPayerAndRateCodeAddInput));
			driver.findElement(TaxPayerAndRateCodeAddInput).clear();
			driver.findElement(TaxPayerAndRateCodeAddInput).sendKeys(newCode);
			Thread.sleep(1000);
			System.out.println("Entered new code");
			Log.info("log4j msg- Entered new code");
			
			System.out.println("new tax id"+newName);
			//enter name
			wait.until(ExpectedConditions.visibilityOfElementLocated(TaxPayerAndRateNameAddInput));
			driver.findElement(TaxPayerAndRateNameAddInput).clear();
			driver.findElement(TaxPayerAndRateNameAddInput).sendKeys(newName);
			Thread.sleep(1000);
			System.out.println("Entered new name");
			Log.info("log4j msg- Entered new  name");
		
			Thread.sleep(1000);
			//click validate
					
			wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLink));
			driver.findElement(ValidateLink).click();
			System.out.println("clicked validate");
			Log.info("log4j msg- clicked validate");
			
			//click ok
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateSaveOKButton));
			driver.findElement(ValidateSaveOKButton).click();
			System.out.println("clicked validate ok to save button");
			Log.info("log4j msg- clicked validate ok to save button");
			
			Thread.sleep(1000);
			//click save
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
			driver.findElement(SaveLink).click();
			System.out.println("clicked save ");
			Log.info("log4j msg- clicked  save ");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
			
			}
		else { System.out.println("Not present"); Log.info("log4j msg - Not present"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();}
		}
		catch (Exception e){e.printStackTrace();System.out.println("Error in Copying TaxPayerAndRate ");
		Log.info("log4j msg- Error in Copying TaxPayerAndRate "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();
		}
			
		}


	public void editTaxPayerAndRate( String TaxPayerAndRateCode, String TaxPayerAndRateName, String editClaimQuery, String editServiceQuery) throws Exception{
		
		try{
		int i= searchTaxPayerAndRateListing( TaxPayerAndRateCode, TaxPayerAndRateName);
		
		if (i==1){
			System.out.println("TaxPayerAndRate found, Continue with Edit");
			Log.info("log4j msg- TaxPayerAndRate found, Continue with Edit");
		
			//click edit
			wait.until(ExpectedConditions.visibilityOfElementLocated(EditLink));
			driver.findElement(EditLink).click();
			Thread.sleep(1000);
			System.out.println("clicked Edit");
			Log.info("log4j msg- clicked Edit");
			
			
			//click edit rate
			wait.until(ExpectedConditions.visibilityOfElementLocated(EditRateButton));
			driver.findElement(EditRateButton).click();
			Thread.sleep(1000);
			System.out.println("clicked Edit Rate button");
			Log.info("log4j msg- clicked Edit rate button");
			Thread.sleep(1000);
			//click claim type
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimTypeButton));
			driver.findElement(ClaimTypeButton).click();
			Thread.sleep(1000);
			System.out.println("clicked claim type button");
			Log.info("log4j msg- clicked claim type  button");
			
			Thread.sleep(1000);
			//click edit query link
			wait.until(ExpectedConditions.visibilityOfElementLocated(EditLinkInQuery));
			driver.findElement(EditLinkInQuery).click();
			Thread.sleep(1000);
			System.out.println("clicked edit link");
			Log.info("log4j msg- clicked edit link");
			
			
			
			
			
			//enter new query
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(EditQueryNameInput));
			driver.findElement(EditQueryNameInput).clear();
			driver.findElement(EditQueryNameInput).sendKeys(editClaimQuery);
			Thread.sleep(1000);
			System.out.println("entered new query");
			Log.info("log4j msg- entered new query");
			
			
			
			Thread.sleep(1000);
			//click save
			wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLinkInQuery));
			driver.findElement(SaveLinkInQuery).click();
			Thread.sleep(1000);
			System.out.println("clicked save");
			Log.info("log4j msg- clicked save");
			
			////click return selection
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
			driver.findElement(ReturnSelectionLink).click();
			Thread.sleep(1000);
			System.out.println("clicked return selection");
			Log.info("log4j msg- clicked return selection");
			
			
			//click service type
			wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceTypeButton));
			driver.findElement(ServiceTypeButton).click();
			Thread.sleep(1000);
			System.out.println("clicked service type button");
			Log.info("log4j msg- clicked service type button");
			
			//click edit
			//click edit query link
			wait.until(ExpectedConditions.visibilityOfElementLocated(EditLinkInQuery));
			driver.findElement(EditLinkInQuery).click();
			Thread.sleep(1000);
			System.out.println("clicked edit link");
			Log.info("log4j msg- clicked edit link");
			
			//enter new query
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(EditQueryNameInput));
			driver.findElement(EditQueryNameInput).clear();
			driver.findElement(EditQueryNameInput).sendKeys(editServiceQuery);
			Thread.sleep(1000);
			System.out.println("entered new service query");
			Log.info("log4j msg- entered new service query");
			
			Thread.sleep(1000);
			//click save
			wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLinkInQuery));
			driver.findElement(SaveLinkInQuery).click();
			Thread.sleep(1000);
			System.out.println("clicked save");
			Log.info("log4j msg- clicked save");
			
			////click return selection
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
			driver.findElement(ReturnSelectionLink).click();
			Thread.sleep(1000);
			System.out.println("clicked return selection");
			Log.info("log4j msg- clicked return selection");
	
			//click hide
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(TaxRateHideButton));
			driver.findElement(TaxRateHideButton).click();
			Thread.sleep(1000);
			System.out.println("clicked hide button");
			Log.info("log4j msg- clicked hide button");
			
			
			
			Thread.sleep(1000);
			//click validate
			wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLink));
			driver.findElement(ValidateLink).click();
			System.out.println("clicked validate");
			Log.info("log4j msg- clicked validate");
			
			//click ok
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateSaveOKButton));
			driver.findElement(ValidateSaveOKButton).click();
			System.out.println("clicked validate ok to save button");
			Log.info("log4j msg- clicked validate ok to save button");
			
			Thread.sleep(1000);
			//click save
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
			driver.findElement(SaveLink).click();
			System.out.println("clicked save ");
			Log.info("log4j msg- clicked  save ");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
			
			}
		else { System.out.println("Not present"); Log.info("log4j msg - Not present");BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();}
		}
		catch (Exception e){e.printStackTrace();System.out.println("Error in Editing TaxPayerAndRate ");
		Log.info("log4j msg- Error in Editing TaxPayerAndRate "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();
		}
			
		}

public void editTaxPayerAndRateClaimTypeQuery( String TaxPayerAndRateCode, String TaxPayerAndRateName, String editClaimQuery, String editServiceQuery) throws Exception{
		
		try{
		int i= searchTaxPayerAndRateListing( TaxPayerAndRateCode, TaxPayerAndRateName);
		
		if (i==1){
			System.out.println("TaxPayerAndRate found, Continue with Edit");
			Log.info("log4j msg- TaxPayerAndRate found, Continue with Edit");
		
			//click edit
			wait.until(ExpectedConditions.visibilityOfElementLocated(EditLink));
			driver.findElement(EditLink).click();
			Thread.sleep(1000);
			System.out.println("clicked Edit");
			Log.info("log4j msg- clicked Edit");
			
			
			//click edit rate
			wait.until(ExpectedConditions.visibilityOfElementLocated(EditRateButton));
			driver.findElement(EditRateButton).click();
			Thread.sleep(1000);
			System.out.println("clicked Edit Rate button");
			Log.info("log4j msg- clicked Edit rate button");
			
			//click claim type
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimTypeButton));
			driver.findElement(ClaimTypeButton).click();
			Thread.sleep(1000);
			System.out.println("clicked claim type button");
			Log.info("log4j msg- clicked claim type  button");
			
			
			//click edit query link
			wait.until(ExpectedConditions.visibilityOfElementLocated(EditLinkInQuery));
			driver.findElement(EditLinkInQuery).click();
			Thread.sleep(1000);
			System.out.println("clicked edit link");
			Log.info("log4j msg- clicked edit link");
			
			
			
			
			Thread.sleep(1000);
			//enter new query
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(EditQueryNameInput));
			driver.findElement(EditQueryNameInput).clear();
			driver.findElement(EditQueryNameInput).sendKeys(editClaimQuery);
			Thread.sleep(1000);
			System.out.println("entered new query");
			Log.info("log4j msg- entered new query");
			
			
			
			
			//click save
			wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLinkInQuery));
			driver.findElement(SaveLinkInQuery).click();
			Thread.sleep(1000);
			System.out.println("clicked save");
			Log.info("log4j msg- clicked save");
			
			////click return selection
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
			driver.findElement(ReturnSelectionLink).click();
			Thread.sleep(1000);
			System.out.println("clicked return selection");
			Log.info("log4j msg- clicked return selection");
	
			//click hide
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(TaxRateHideButton));
			driver.findElement(TaxRateHideButton).click();
			Thread.sleep(1000);
			System.out.println("clicked hide button");
			Log.info("log4j msg- clicked hide button");
			
			
			
			Thread.sleep(1000);
			//click validate
			wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLink));
			driver.findElement(ValidateLink).click();
			System.out.println("clicked validate");
			Log.info("log4j msg- clicked validate");
			
			//click ok
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateSaveOKButton));
			driver.findElement(ValidateSaveOKButton).click();
			System.out.println("clicked validate ok to save button");
			Log.info("log4j msg- clicked validate ok to save button");
			
			Thread.sleep(1000);
			//click save
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
			driver.findElement(SaveLink).click();
			System.out.println("clicked save ");
			Log.info("log4j msg- clicked  save ");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
			
			}
		else { System.out.println("Not present"); Log.info("log4j msg - Not present");BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();}
		}
		catch (Exception e){e.printStackTrace();System.out.println("Error in Editing TaxPayerAndRate claim type query ");
		Log.info("log4j msg- Error in Editing TaxPayerAndRate claim Type Query "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();
		}
			
		}

public void editTaxPayerAndRateServiceTypeQuery( String TaxPayerAndRateCode, String TaxPayerAndRateName, String editClaimQuery, String editServiceQuery) throws Exception{
	
	try{
	int i= searchTaxPayerAndRateListing( TaxPayerAndRateCode, TaxPayerAndRateName);
	
	if (i==1){
		System.out.println("TaxPayerAndRate found, Continue with Edit");
		Log.info("log4j msg- TaxPayerAndRate found, Continue with Edit");
	
		//click edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(EditLink));
		driver.findElement(EditLink).click();
		Thread.sleep(1000);
		System.out.println("clicked Edit");
		Log.info("log4j msg- clicked Edit");
		
		
		//click edit rate
		wait.until(ExpectedConditions.visibilityOfElementLocated(EditRateButton));
		driver.findElement(EditRateButton).click();
		Thread.sleep(1000);
		System.out.println("clicked Edit Rate button");
		Log.info("log4j msg- clicked Edit rate button");
		
		
		
		//click service type
		wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceTypeButton));
		driver.findElement(ServiceTypeButton).click();
		Thread.sleep(1000);
		System.out.println("clicked service type button");
		Log.info("log4j msg- clicked service type button");
		
		//click edit
		//click edit query link
		wait.until(ExpectedConditions.visibilityOfElementLocated(EditLinkInQuery));
		driver.findElement(EditLinkInQuery).click();
		Thread.sleep(1000);
		System.out.println("clicked edit link");
		Log.info("log4j msg- clicked edit link");
		
		//enter new query
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(EditQueryNameInput));
		driver.findElement(EditQueryNameInput).clear();
		driver.findElement(EditQueryNameInput).sendKeys(editServiceQuery);
		Thread.sleep(1000);
		System.out.println("entered new service query");
		Log.info("log4j msg- entered new service query");
		
		
		//click save
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLinkInQuery));
		driver.findElement(SaveLinkInQuery).click();
		Thread.sleep(1000);
		System.out.println("clicked save");
		Log.info("log4j msg- clicked save");
		
		////click return selection
		wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
		driver.findElement(ReturnSelectionLink).click();
		Thread.sleep(1000);
		System.out.println("clicked return selection");
		Log.info("log4j msg- clicked return selection");

		//click hide
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(TaxRateHideButton));
		driver.findElement(TaxRateHideButton).click();
		Thread.sleep(1000);
		System.out.println("clicked hide button");
		Log.info("log4j msg- clicked hide button");
		
		
		
		Thread.sleep(1000);
		//click validate
		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLink));
		driver.findElement(ValidateLink).click();
		System.out.println("clicked validate");
		Log.info("log4j msg- clicked validate");
		
		//click ok
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateSaveOKButton));
		driver.findElement(ValidateSaveOKButton).click();
		System.out.println("clicked validate ok to save button");
		Log.info("log4j msg- clicked validate ok to save button");
		
		Thread.sleep(1000);
		//click save
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
		driver.findElement(SaveLink).click();
		System.out.println("clicked save ");
		Log.info("log4j msg- clicked  save ");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();
		
		}
	else { System.out.println("Not present"); Log.info("log4j msg - Not present");BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
	driver.quit();}
	}
	catch (Exception e){e.printStackTrace();System.out.println("Error in Editing TaxPayerAndRate Service type query ");
	Log.info("log4j msg- Error in Editing TaxPayerAndRate Service Type Query "); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
	driver.quit();
	}
		
	}








	public void addCommTaxPayerAndRate( String TaxPayerAndRateCode, String TaxPayerAndRateName, String subject, String type,  String status, String priority, String followupDate, String notetype, String medium, String details) throws Exception{
		try{
		int i= searchTaxPayerAndRateListing( TaxPayerAndRateCode, TaxPayerAndRateName);
		
		if (i==1){
			System.out.println("Found TaxPayerAndRate, continue with commun.");
			Log.info("log4j msg- Found TaxPayerAndRate, continue with commun.");
		
			//click comm
			wait.until(ExpectedConditions.visibilityOfElementLocated(CommLink));
			driver.findElement(CommLink).click();
			System.out.println("clicked commun.");
			Log.info("log4j msg- clicked commun.");	
			
			Thread.sleep(1000);
			//click add comm
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddLinkInComm));
			driver.findElement(AddLinkInComm).click();
			System.out.println("clicked  add  in commun.");
			Log.info("log4j msg- clicked add in commun.");	
			
			//enter  comm subject
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommSubjectInput));
			driver.findElement(AddCommSubjectInput).sendKeys(subject);
			System.out.println("entered subject.");
			Log.info("log4j msg- entered subject in commun.");	
			
			//enter comm type
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommType));
			Select commType = new Select(driver.findElement(AddCommType));
			commType.selectByVisibleText(type);
			System.out.println("selected comm type.");
			Log.info("log4j msg- selected comm type.");	
			
			Thread.sleep(3000);
			//enter comm followup date
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommFollowupDateInput));
			driver.findElement(AddCommFollowupDateInput).sendKeys(followupDate);
			System.out.println("entered followup date");
			Log.info("log4j msg- entered followup date");	
			
			Thread.sleep(2000);
			//enter comm priority
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommPriority));
			Select priorityLevel = new Select(driver.findElement(AddCommPriority));
			priorityLevel.selectByVisibleText(priority);
			System.out.println("selected priority");
			Log.info("log4j msg- selected priority");	
			
			
			Thread.sleep(2000);
			//page down
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommFollowupDateInput));
			driver.findElement(AddCommFollowupDateInput).sendKeys(Keys.PAGE_DOWN);
			System.out.println("page down");
			Log.info("log4j msg- page down");	
			
			Thread.sleep(5000);
			//click comm details add
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommAddDetailsButton));
			driver.findElement(AddCommAddDetailsButton).click();
			System.out.println("clicked add button");
			Log.info("log4j msg- clicked add button");		
			
			Thread.sleep(2000);
			//enter comm details note type
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommNoteType));
			Select detailsNotetype = new Select(driver.findElement(AddCommNoteType));
			detailsNotetype.selectByVisibleText(notetype);
			Thread.sleep(2000);
			System.out.println("selected note type");
			Log.info("log4j msg- selected note type");	
			
			Thread.sleep(1000);
			//enter comm details medium
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommMedium));
			Select detailsMedium = new Select(driver.findElement(AddCommMedium));
			detailsMedium.selectByVisibleText(medium);
			System.out.println("selected medium");
			Log.info("log4j msg- selected medium");	
			
			//enter comm details
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommDetails));
			driver.findElement(AddCommDetails).sendKeys(details);
			System.out.println("entered details");
			Log.info("log4j msg- entered details");		
			
			//click comm details hide
			wait.until(ExpectedConditions.visibilityOfElementLocated(AddCommHideButton));
			driver.findElement(AddCommHideButton).click();
			System.out.println("clicked hide");
			Log.info("log4j msg- clicked hide");		
			
			Thread.sleep(2000);
			//click comm validate
			wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLink));
			driver.findElement(ValidateLink).click();
			System.out.println("clicked validate");
			Log.info("log4j msg- clicked validate");		
			
			//click ok
			wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateSaveOKButton));
			driver.findElement(ValidateSaveOKButton).click();
			System.out.println("clicked ok to save");
			Log.info("log4j msg- clicked ok to save");		
			
			
			Thread.sleep(3000);
			//click comm save
			wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
			driver.findElement(SaveLink).click();
			System.out.println("clicked save");
			Log.info("log4j msg- clicked save");	
			
			
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		} else{
			System.out.println("cannot find TaxPayerAndRate");
			Log.info("log4j msg- cannot find TaxPayerAndRate");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
			driver.findElement(ExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		} 
		}catch(Exception e){ e.printStackTrace(); System.out.println("error in TaxPayerAndRate add comm");
		Log.info("log4j msg- error in TaxPayerAndRate add comm"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		}
	}

	public void exitTaxPayerAndRate( String TaxPayerAndRateCode, String TaxPayerAndRateName) throws Exception{
		try{
		int i= searchTaxPayerAndRateListing(TaxPayerAndRateCode, TaxPayerAndRateName);
		
		if (i==1){
			System.out.println("Found TaxPayerAndRate, continue with exit");
		Log.info("Found TaxPayerAndRate, continue with exit");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
		driver.findElement(ExitLink).click();
		System.out.println("clicked Exit");
		Log.info("log4j msg- clicked Exit");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		} else{
			System.out.println("cannot find TaxPayerAndRate");
			Log.info("log4j msg- cannot find TaxPayerAndRate");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
			driver.findElement(ExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		} 
		}catch(Exception e){ System.out.println("error in TaxPayerAndRate exit");
		Log.info("log4j msg- error in TaxPayerAndRate exit"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();}
	}	

	public void deleteTaxPayerAndRate( String TaxPayerAndRateCode, String TaxPayerAndRateName) throws Exception{
		try{
		int i= searchTaxPayerAndRateListing(TaxPayerAndRateCode, TaxPayerAndRateName);
		
		if (i==1){
			System.out.println("Found TaxPayerAndRate, continue with delete");
			Log.info("log4j msg- Found TaxPayerAndRate, continue with delete");
		//delete
		wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteLink));
		driver.findElement(DeleteLink).click();
		System.out.println("clicked Delete");
		Log.info("log4j msg- clicked Delete");
		
		
		//confirm delete
		wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmDeleteYesButton));
		driver.findElement(ConfirmDeleteYesButton).click();
		System.out.println("clicked ok to confirm Delete");
		Log.info("log4j msg- clicked ok to confirm Delete");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		} else{
			System.out.println("cannot find TaxPayerAndRate");
			Log.info("log4j msg- cannot find TaxPayerAndRate");
			wait.until(ExpectedConditions.visibilityOfElementLocated(ExitLink));
			driver.findElement(ExitLink).click();
			System.out.println("clicked Exit");
			Log.info("log4j msg- clicked Exit");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}	}catch(Exception e){ System.out.println("error in TaxPayerAndRate delete");
		Log.info("log4j msg- error in TaxPayerAndRate delete"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();}
	}

	

	}



