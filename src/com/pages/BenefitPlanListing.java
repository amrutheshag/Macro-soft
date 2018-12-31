package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class BenefitPlanListing {

	WebDriver driver;
	WebDriverWait wait;
	
	By BenefitCodeBeginsSearchInput= By.xpath("//input[@id='txtSearchCode']");
	
	By BenefitNameBeginsSearchInput= By.xpath("//input[@id='txtSearchName']");
	
	By PayerCarrierOfferingPlanBeginsSearchInput= By.xpath("//input[@id='txtSearchPayer']");
	
	By BenefitPlanSearchButton= By.xpath("//button[@data-ng-click='search()']");
	
	By BenefitPlanNameInput = By.xpath("//input[@id='txtName']");
			
	By BenefitPlanCodeInput= By.xpath("//input[@id='txtCode']");	 
	
	By AccountInput= By.xpath("//input[@id='txtAccount']");
	
	By PlanStartDateInput= By.xpath("//input[@id='txtEffectiveOn']");
		
	By PlanEndDateInput= By.xpath("//input[@id='txtTerminatedOn']");
	
	By DiagnosisSet9InputStartDate = By.xpath("//input[@id='txt_dx_codes_v1_eff']");
	
	By DiagnosisSet9InputEndDate= By.xpath("//input[@id='txt_dx_codes_v1_term']");
	
	By DiagnosisSet10InputStartDate= By.xpath("//input[@id='txt_dx_codes_v2_eff']");
	
	By DiagnosisSet10InputEndDate= By.xpath("//input[@id='txt_dx_codes_v2_term']");
	
	By CopaysOfficeVisitInput= By.xpath("//input[@id='txt_ovcopay']");

	By CopayMedicalOfficeVisitInput= By.xpath("//input[@id='txt_medical_copay']");

	By AnnualMemberStopLossPercentInput= By.xpath("//input[@id='txt_mcstoploss']");

	By PercentAccumToTriggerNoticeInput= By.xpath("//input[@id='txt_mcstopwarn']");

	By ClaimSubmissionRunOutInput = By.xpath("//input[@id='txt_claims_runout']");
	//use above for pagedown, pageup
	
	By ClaimsArePaidCheckBox= By.xpath("//input[@data-ng-model='currentRecord.payclaims']");

	By ClaimsAreMarkedUpCheckBox= By.xpath("//input[@data-ng-model='currentRecord.billoutffs']");

	By ClaismAreAdjudicatedCheckBox= By.xpath("//input[@data-ng-model='currentRecord.manualclms']");

	By ClaimsProcessingNotifiesCheckBox= By.xpath("//input[@data-ng-model='currentRecord.claimrefnotice']");

	By PlanIsAdministeredPerContractCheckBox= By.xpath("//input[@data-ng-model='currentRecord.administer']");

	By ServiceRulesLink= By.linkText("2 - Service Rules");
	
	By TypeOfServiceDiv= By.xpath("(//div[@ng-style='colContainer.getViewportStyle()'])[2]");

	By ServiceRulesAddButton= By.xpath("//button[@data-ng-click='tabServiceRules.add()']");

	By CoveredServiceURRulesExplanationInput= By.xpath("//input[@id='explainationBox']");

	By ClaimTypeInput=By.xpath("//input[@data-ng-model='tabServiceRules.selectedRecord.claim']");

	By ServiceTypeInput= By.xpath("//input[@data-ng-model='tabServiceRules.selectedRecord.service']");
	
	By ClaimTypeButton= By.xpath("//button[@data-ng-click='openBenefitCoveredClaimPopup()']");
	
	By ServiceTypeButton= By.xpath("//button[@data-ng-click='openBenefitCoveredServicePopup()']");

	By QueryCopyLink= By.linkText("Copy");
	
	By QueryNameInput = By.id("name");
	
	By QueryAddLink= By.linkText("Add");
	
	By QuerySaveLink = By.xpath("(//span[text()='Save'])[2]");
	
	By DeleteQueryLink = By.linkText("Delete");
	
	By QueryReturnSelection = By.linkText("Return Selection");
	
	By QueriesHideButton = By.xpath("(//button[@data-dismiss='modal' and text()='Hide'])[4]");
	
	By EOCCheckBox= By.xpath("//input[@data-ng-model='tabServiceRules.selectedRecord.episodereq']");

	By TxPrgCheckBox= By.xpath("//input[@data-ng-model='tabServiceRules.selectedRecord.tx_progreq']" );

	By referToPayerInsurerForPaymentCheckBox=By.xpath("//input[@data-ng-model='tabServiceRules.selectedRecord.payorpays']");

	By SpecialOverridingDispositionInput= By.xpath("//input[@id='txtSOD']");

	By CoveredServiceURRulesHideButton= By.xpath("//input[@data-dismiss='modal']");

	By EditServiceRuleButton= By.xpath("//button[@data-ng-click='tabServiceRules.edit()']");
	
	By ClaimTypeButtonInCoveredService = By.xpath("//button[@data-ng-click='openBenefitCoveredClaimPopup()']");
	
	By ServiceTypeButtonInCoveredService = By.xpath("//button[@data-ng-click='openBenefitCoveredServicePopup()']");
	
	By EditInFileQueryLink= By.xpath("//a[@id='edit' and @data-ng-click='editForm()']'");
	
	By SaveInFileQueryLink = By.xpath("//a[@data-ng-click='saveForm()']");
	
	By ReturnSelectionLinkToSelectAQuery= By.linkText("Return Selection");
	
	By ClaimPricingLink = By.linkText("3-Claim Pricing");

	By ClaimPricingExplanationDiv= By.xpath("//div[@ng-style='colContainer.getViewportStyle()']");
	//Use this for pagedown
		
	By ClaimPricingAddButton = By.xpath("//button[@data-ng-click='tabClaimPricing.add()']");
	
	By ClaimPricingExplanationInput= By.xpath("//input[@id='explan']");
	
	By ProcessingOrder= By.xpath("//input[@data-ng-disabled='isAuditing']");
	
	By ClaimPricingStartDate= By.xpath("//input[@data-ng-model='tabClaimPricing.selectedRecord.effective']");

	By ClaimProcessingEndDate = By.xpath("//input[@data-ng-model='tabClaimPricing.selectedRecord.terminates']");
	
	By ClaimPricingClaimType = By.xpath("//input[@data-ng-model='tabClaimPricing.selectedRecord.claim1']");
	
	By ClaimPricingServiceType = By.xpath("//input[@data-ng-model='tabClaimPricing.selectedRecord.service1']");
	
	By EditClaimPricingButton= By.xpath("//button[@data-ng-click='tabClaimPricing.edit()']");
	
	By ClaimTypeInClaimPricingButton= By.xpath("//button[@data-ng-click='openBenefitPlanPaymentClaim1Popup()']");
	
	By ServiceTypeInClaimPricingButton = By.xpath("//button[@data-ng-click='openBenefitPlanPaymentService1Popup()']");
	
	By QueryNameDescriptionBeginsInput = By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptions.name']");

	By ClaimPricingMemberPaymentInput = By.xpath("//input[@data-ng-model='tabClaimPricing.selectedRecord.ptPmtOther']");
	
	By AccessOnlyOneObligationPerVisitCheckBox= By.xpath("//input[@data-ng-model='tabClaimPricing.selectedRecord.pervisit']");
	
	By PaymentScenarioDependsUponAccumulatedCostsCheckBox= By.xpath("//input[@data-ng-model='tabClaimPricing.selectedRecord.accumDependent']");
	
	By TermResetsInACycleOfInput = By.xpath("//input[@data-ng-model='tabClaimPricing.selectedRecord.accumperun']");
	
	By AccumulationRageStartInput= By.xpath("//input[@data-ng-model='tabClaimPricing.selectedRecord.accumlo']");
	
	By AccumulationRangeEndInput = By.xpath("//input[@data-ng-model='tabClaimPricing.selectedRecord.accumhi']");
	
	By SubtractMemberPaymentsFromAllowedCheckBox = By.xpath("//input[@data-ng-model='tabClaimPricing.selectedRecord.pt_pmt_reduces_allow']");
	
	By WeightInput = By.xpath("//input[@data-ng-model='tabClaimPricing.selectedRecord.weight2']");
	
	By ClaimPricingHideButton = By.xpath("(//button[@class='btn btn-secondary btn-bottom01 pull-right' and @data-dismiss='modal' and text()='Hide'])[4]");
	
	By PremiumRatesLink= By.linkText("4 - Premium Rates");
	
	By PremiumRatesAddButton= By.xpath("//button[@data-ng-click='tabPremiumRates.add()']");
	
	By PremiumStartDateInput= By.xpath("//input[@id='pex']");
	
	By VisionPremiumInput=  By.xpath("//input[@data-ng-model='tabPremiumRates.selectedRecord.vision']");
		
	By CoverageExtendSelect = By.xpath("//select[@data-ng-model='tabPremiumRates.selectedRecord.covextent']");
	
	By PremiumHideButton= By.xpath("(//button[@class='btn btn-secondary btn-bottom01 pull-right' and text()='Hide'])[4]");
	
	By NotesLink = By.xpath("//a[text()= '6 - Notes']");
	
	By NotesTextBox = By.xpath("//textarea[@data-ng-model='currentRecord.notes']");
	
	By SaveLink = By.linkText("Save");
	
	By BenefitPlanAddLink = By.linkText("Add");
	
	By BenefitPlanExitLink = By.linkText("Exit");
	
	By BenefitPlanDeleteLink = By.linkText("Delete");
	
	By BenefitPlanConfirmDeleteButton= By.xpath("//button[@class='btn btn-primary btn-bottom02']");
	
	By BenefitPlanEditLink = By.linkText("Edit");
	
	By BenefitPlanCopyLink = By.linkText("Copy");
	
	By BenefitPlanCommLink = By.linkText("Commun.");
	
	By ValidateLink = By.linkText("Validate");
	
	By OKButton= By.xpath("//button[text()='OK']");
	
	By QuerySearchButton = By.xpath("(//button[text()='Search'])[2]");
	
	
	public  BenefitPlanListing(WebDriver driver){
		this.driver= driver;
		this.wait=   new WebDriverWait(driver, 25);
	}

	//search function
	public int searchBenefitPlan(String benefitPlanCode, String benefitPlanName, String benefitPlanPayer) throws Exception{
		
		try{
			System.out.println("Benefit plan Code:"+benefitPlanCode);
			System.out.println("Benefit Plan Name:"+benefitPlanName);
			System.out.println("Benefit Plan Payer:"+benefitPlanPayer);
			
			Log.info("Benefit plan Code:"+benefitPlanCode);
			Log.info("Benefit Plan Name:"+benefitPlanName);
			Log.info("Benefit Plan Payer:"+benefitPlanPayer);
			
			
		
			//enter code
			wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitCodeBeginsSearchInput));
			driver.findElement(BenefitCodeBeginsSearchInput).sendKeys(benefitPlanCode);
			System.out.println("entered Benefit Plan code");
			Log.info("log4j msg- entered Benefit plan Code");
			Thread.sleep(1000);
			
			
			//enter name
			wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitNameBeginsSearchInput));
			driver.findElement( BenefitNameBeginsSearchInput).sendKeys(benefitPlanName);
			System.out.println("entered Benefit Plan Name");
			Log.info("log4j msg- entered Benefit plan Name");
			Thread.sleep(1000);
			
			//enter payer
			wait.until(ExpectedConditions.visibilityOfElementLocated(PayerCarrierOfferingPlanBeginsSearchInput));
			driver.findElement(PayerCarrierOfferingPlanBeginsSearchInput).sendKeys(benefitPlanPayer);
			System.out.println("entered Benefit Plan Payer/ Carrier Name");
			Log.info("log4j msg- entered Benefit Plan Payer/ Carrier Name");
			Thread.sleep(1000);
			
			
			//click search
			wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanSearchButton));
			driver.findElement(BenefitPlanSearchButton).click();
			System.out.println("clicked search");
			Log.info("log4j msg- clicked search");
			Thread.sleep(1000);
			
			//check if benefit plan is returned
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(), '"+benefitPlanCode+"')]")));
			driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(), '"+benefitPlanCode+"')]")).click();
			System.out.println("Found Benefit plan, clicked on Benefit Plan");
			Log.info("log4j msg- Found Benefit Plan, clicked on Benefit Plan");
			
			
			return 1;
		} catch(Exception e){System.out.println("Benefit Plan not found");Log.info("Benefit Plan not found");
		return 0;
		}
	
	}
	
	
	
	//add function
	public void addBenefitPlan( String benefitPlanCode, String benefitPlanName, String benefitPlanPayer) throws Exception{
		try{
			
			
			int i= searchBenefitPlan(benefitPlanCode, benefitPlanName, benefitPlanPayer); 

			if(i==0) {
				
				 //click add
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanAddLink));
				driver.findElement(BenefitPlanAddLink).click(); 
				System.out.println("Clicked Add");
				Log.info("log4j msg- clicked Add");
				
				//enter name
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanNameInput));
				driver.findElement( BenefitPlanNameInput).sendKeys(benefitPlanName);
				System.out.println("entered Benefit Plan Name");
				Log.info("log4j msg- entered Benefit plan Name");
				Thread.sleep(1000);
				
				//enter code
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanCodeInput));
				driver.findElement( BenefitPlanCodeInput).sendKeys(benefitPlanCode);
				System.out.println("entered Benefit Plan Code");
				Log.info("log4j msg- entered Benefit plan Code");
				Thread.sleep(2000);
				
				
				//click save
				wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
				driver.findElement(SaveLink).click(); 
				System.out.println("Clicked Save");
				Log.info("log4j msg- clicked Save");
				Thread.sleep(1000);
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
			
			}
			else
			{
				System.out.println("Cannot add, Benefit Plan already present");
				Log.info("log4j msg- Cannot add, Benefit Plan already present");
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
			
				
			}
			
		}catch(Exception e){System.out.println("Error in adding Benefit Plan");
		Log.info("log4j msg- Error in adding Benefit Plan");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
		
		
		}
	}
	
	//edit function
	public void editBenefitPlan( String benefitPlanCode, String benefitPlanName, String benefitPlanPayer, String newDetailsToEdit) throws Exception{
		try{
				
			System.out.println("Benefit Plan new Account Number:"+newDetailsToEdit);
			Log.info("Benefit plan new Account Number:"+newDetailsToEdit);
			
			int i= searchBenefitPlan(benefitPlanCode, benefitPlanName, benefitPlanPayer); 

			if(i==1) {
				
				//click edit
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanEditLink));
				driver.findElement(BenefitPlanEditLink).click(); 
				System.out.println("Clicked Edit");
				Log.info("log4j msg- clicked Edit");
				
				//make changes 
				wait.until(ExpectedConditions.visibilityOfElementLocated(AccountInput));
				driver.findElement(AccountInput).clear();
				driver.findElement(AccountInput).sendKeys(newDetailsToEdit);
				System.out.println("entered new Account");
				Log.info("log4j msg- entered new Account");
				Thread.sleep(2000);		
				
				//click save
				wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
				driver.findElement(SaveLink).click(); 
				System.out.println("Clicked Save");
				Log.info("log4j msg- clicked Save");
			
			Thread.sleep(1000);
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
				
			
			
			}
			else
			{
				System.out.println("Cannot edit, Benefit Plan not present");
				Log.info("log4j msg- Cannot edit, Benefit Plan not present");
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
			
				
			}
			
		}catch(Exception e){System.out.println("Error in editing Benefit Plan");
		Log.info("log4j msg- Error in editing Benefit Plan");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
	
		
		}
	}
	
	//copy function
	public void copyBenefitPlan( String benefitPlanCode, String benefitPlanName, String benefitPlanPayer, String newBenefitPlanCode, String newBenefitPlanName, String newBenefitPlanPayer,String newClaimTypeQuery, String newServiceTypeQuery, String premiumStartDate, String visionPremium, String newNotes) throws Exception{
		try{
			
			
			
			
			
			int i= searchBenefitPlan(benefitPlanCode, benefitPlanName, benefitPlanPayer); 

			if(i==1) {
				
				//click copy
			
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanCopyLink));
				driver.findElement(BenefitPlanCopyLink).click(); 
				System.out.println("Clicked Copy");
				Log.info("log4j msg- clicked Copy");
				
				System.out.println("Benefit plan new Code:"+newBenefitPlanCode);
				System.out.println("Benefit Plan new Name:"+newBenefitPlanName);
				System.out.println("Benefit Plan new Payer:"+newBenefitPlanPayer);
				
				Log.info("Benefit plan new Code:"+newBenefitPlanCode);
				Log.info("Benefit Plan new Name:"+newBenefitPlanName);
				Log.info("Benefit Plan new Payer:"+newBenefitPlanPayer);
				//make changes to name
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanNameInput));
				driver.findElement(BenefitPlanNameInput).clear();
				driver.findElement(BenefitPlanNameInput).sendKeys(newBenefitPlanName);
				System.out.println("entered new Benefit Plan Name");
				Log.info("log4j msg- entered new Benefit plan Name");
				Thread.sleep(2000);		
		
				//make changes to code

				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanCodeInput));
				driver.findElement( BenefitPlanCodeInput).clear();
				driver.findElement( BenefitPlanCodeInput).sendKeys(newBenefitPlanCode);
				System.out.println("entered new Benefit Plan Code");
				Log.info("log4j msg- entered new Benefit plan Code");
				Thread.sleep(2000);		
				
				//click save
				wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
				driver.findElement(SaveLink).click();
				System.out.println("Clicked save");
				Log.info("log4j msg- Clicked save");
				
				Thread.sleep(1000);
				
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
			
				
			}
			else
			{
				System.out.println("Cannot copy, Benefit Plan not present");
				Log.info("log4j msg- Cannot copy, Benefit Plan not present");
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
				
				
			}
			
		}catch(Exception e){e.printStackTrace(); 
		System.out.println("Error in copying Benefit Plan");
		Log.info("log4j msg- Error in copying Benefit Plan");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		}	
	}
	
	
	//copy function with Add Premium Rates
		public void copyBenefitPlanAddPremiumRates( String benefitPlanCode, String benefitPlanName, String benefitPlanPayer, String newBenefitPlanCode, String newBenefitPlanName, String newBenefitPlanPayer,String newClaimTypeQuery, String newServiceTypeQuery, String premiumStartDate, String visionPremium, String CoverageExtend, String newNotes) throws Exception{
			try{
				System.out.println("Benefit plan Code:"+benefitPlanCode);
				System.out.println("Benefit Plan Name:"+benefitPlanName);
				System.out.println("Benefit Plan Payer:"+benefitPlanPayer);
				
				Log.info("Benefit plan Code:"+benefitPlanCode);
				Log.info("Benefit Plan Name:"+benefitPlanName);
				Log.info("Benefit Plan Payer:"+benefitPlanPayer);
				
				int i= searchBenefitPlan(benefitPlanCode, benefitPlanName, benefitPlanPayer); 

				if(i==1) {
					
					//click copy
				
					wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanCopyLink));
					driver.findElement(BenefitPlanCopyLink).click(); 
					System.out.println("Clicked Copy");
					Log.info("log4j msg- clicked Copy");
					
					
					//make changes to name
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanNameInput));
					driver.findElement(BenefitPlanNameInput).clear();
					driver.findElement(BenefitPlanNameInput).sendKeys(newBenefitPlanName);
					System.out.println("entered new Benefit Plan Name");
					Log.info("log4j msg- entered new Benefit plan Name");
					Thread.sleep(2000);		
			
					//make changes to code

					wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanCodeInput));
					driver.findElement( BenefitPlanCodeInput).clear();
					driver.findElement( BenefitPlanCodeInput).sendKeys(newBenefitPlanCode);
					System.out.println("entered new Benefit Plan Code");
					Log.info("log4j msg- entered new Benefit plan Code");
					Thread.sleep(2000);		
					
					
					//click premium rates
					//Enter Tab 4 - Premium Rates
					wait.until(ExpectedConditions.visibilityOfElementLocated(PremiumRatesLink));
					driver.findElement(PremiumRatesLink).click();
					System.out.println("Clicked Premium Rates");
					Log.info("log4j msg- Clicked Premium Rates");
					
					
					//click premium rate add button

					wait.until(ExpectedConditions.visibilityOfElementLocated(PremiumRatesAddButton));
					driver.findElement(PremiumRatesAddButton).click();
					System.out.println("Clicked Premium Rates Add button ");
					Log.info("log4j msg- Clicked Premium Rates Add button ");
					
					//enter start date
					wait.until(ExpectedConditions.visibilityOfElementLocated(PremiumStartDateInput));
					driver.findElement(PremiumStartDateInput).sendKeys(premiumStartDate);
					System.out.println("entered premium start date");
					Log.info("log4j msg- entered premium start date");
					
					
					Thread.sleep(1000);
					
					System.out.println("selecting coverage now"); Log.info("selecting coverage now");
					//select coverage extend
					wait.until(ExpectedConditions.visibilityOfElementLocated(CoverageExtendSelect));
					Select coverage = new Select(driver.findElement(CoverageExtendSelect));
					coverage.selectByIndex(1);
					
					//coverage.selectByVisibleText(CoverageExtend);
					System.out.println("selected Coverage");
					Log.info("log4j msg-selected Coverage");
					Thread.sleep(2000);
					
					//enter vision premium
					wait.until(ExpectedConditions.visibilityOfElementLocated(VisionPremiumInput));
					driver.findElement(VisionPremiumInput).sendKeys(visionPremium);
					System.out.println("entered vision premium");
					Log.info("log4j msg- entered vision premium");
					
					
					
					
					Thread.sleep(1000);
					//click hide
					wait.until(ExpectedConditions.visibilityOfElementLocated(PremiumHideButton));
					driver.findElement(PremiumHideButton).click();
					System.out.println("clicked premium hide button");
					Log.info("log4j msg- clicked premium hide button");
					Thread.sleep(2000);
					
					//click notes
					wait.until(ExpectedConditions.visibilityOfElementLocated(NotesLink));
					driver.findElement(NotesLink).click();
					System.out.println("clicked Notes");
					Log.info("log4j msg- clicked Notes");
					
					//enter notes
					wait.until(ExpectedConditions.visibilityOfElementLocated(NotesTextBox));
					driver.findElement(NotesTextBox).sendKeys(newNotes);
					System.out.println("entered new notes");
					Log.info("log4j msg- entered new notes");
					Thread.sleep(1000);
					//click save
					wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
					driver.findElement(SaveLink).click();
					System.out.println("Clicked save");
					Log.info("log4j msg- Clicked save");
					
					
					Thread.sleep(1000);
					BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
				
					
				}
				else
				{
					System.out.println("Cannot copy, Benefit Plan not present");
					Log.info("log4j msg- Cannot copy, Benefit Plan not present");
					BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
				
					
				}
				
			}catch(Exception e){e.printStackTrace();
			System.out.println("Error in copying Benefit Plan");
			Log.info("log4j msg- Error in copying Benefit Plan");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
		
			
			}	
		}
	
	
		public void editBenefitPlanCopyClaimType(String benefitPlanCode, String benefitPlanName, String benefitPlanPayer, String newBenefitPlanCode, String newBenefitPlanName, String newBenefitPlanPayer, String newClaimTypeQuery, String newServiceTypeQuery, String premiumStartDate, String visionPremium, String CoverageExtend, String newNotes) throws Exception
		{ 
			
			
			try{
			
			int i= searchBenefitPlan(benefitPlanCode, benefitPlanName, benefitPlanPayer); 

			if(i==1) {
				
				//click edit
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanEditLink));
				driver.findElement(BenefitPlanEditLink).click(); 
				System.out.println("Clicked Edit");
				Log.info("log4j msg- clicked Edit");
				
			
			
			//click service rules
				wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceRulesLink));
				driver.findElement(ServiceRulesLink).click();
				System.out.println("Clicked Service Rules");
				Log.info("log4j msg- Clicked Service Rules");
				Thread.sleep(2000);		
			
				//click edit button
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(EditServiceRuleButton));
				driver.findElement(EditServiceRuleButton).click();
				System.out.println("Clicked Edit Button in Service Rules");
				Log.info("log4j msg- Clicked Edit Button in Service Rules");
				
				
				//click claim Type
				//make changes
				wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimTypeButton));
				driver.findElement(ClaimTypeButton).click();
				System.out.println("Clicked claim type button");
				Log.info("log4j msg- Clicked claim type button");
				
				Thread.sleep(2000);
				//enter query
				wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameDescriptionBeginsInput));
				driver.findElement(QueryNameDescriptionBeginsInput).clear();
				driver.findElement(QueryNameDescriptionBeginsInput).sendKeys(newClaimTypeQuery);
				System.out.println("entered claim query");
				Log.info("log4j msg- entered claim query");
				
				Thread.sleep(2000);
				//click search
				wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearchButton));
				driver.findElement(QuerySearchButton).click();
				System.out.println("clicked search");
				Log.info("log4j msg- clicked search");
				
				
				
				//click copy
				wait.until(ExpectedConditions.visibilityOfElementLocated(QueryCopyLink));
				driver.findElement(QueryCopyLink).click();
				System.out.println("Clicked Copy query");
				Log.info("log4j msg- Clicked Copy query");
				
				//click query name
				wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
				driver.findElement(QueryNameInput).sendKeys("Copy");
				System.out.println("entered query name");
				Log.info("log4j msg- entered query name");
				
				
				Thread.sleep(1000);
				//click save
				wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySaveLink));
				driver.findElement(QuerySaveLink).click();
				System.out.println("Clicked save query");
				Log.info("log4j msg- Clicked save query");
				
				try{
					driver.findElement(By.xpath("//button[text()='OK']")).click();
					System.out.println("Clicked ok for duplicate");
					Log.info("log4j msg- Clicked ok for duplicate");
					
				}catch (Exception e){System.out.println("no duplicate msg");}
				
				
				//click return selection
				try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(QueryReturnSelection));
				driver.findElement(QueryReturnSelection).click();
				System.out.println("Clicked return selection");
				Log.info("log4j msg- Clicked return selection");
				}catch(Exception e){System.out.println("error in clicking return selection");Log.info("error in clicking return selection");}
				
				try{
					driver.findElement(By.linkText("Undo")).click();
					System.out.println("Clicked undo");
					Log.info("log4j msg- Clicked undo");	
					
					driver.findElement(By.xpath("//button[text()='YES']")).click();
					System.out.println("Clicked yes");
					Log.info("log4j msg- Clicked yes");	
					
					
					
				}catch(Exception e){System.out.println("No clicking undo");Log.info("No clicking undo ");}
				
				
				
				
				
				//click hide
				wait.until(ExpectedConditions.visibilityOfElementLocated(QueriesHideButton));
				driver.findElement(QueriesHideButton).click();
				System.out.println("Clicked Hide");
				Log.info("log4j msg- Clicked Hide");	
				Thread.sleep(2000);
					//click validate
				wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLink));
				driver.findElement(ValidateLink).click();
				System.out.println("Clicked validate");
				Log.info("log4j msg- Clicked validate");	
				
				//click ok
				wait.until(ExpectedConditions.visibilityOfElementLocated(OKButton));
				driver.findElement(OKButton).click();
				System.out.println("Clicked OK");
				Log.info("log4j msg- Clicked OK");	
				
				Thread.sleep(2000);
				//click save
				wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
				driver.findElement(SaveLink).click();
				System.out.println("Clicked save");
				Log.info("log4j msg- Clicked save");	
				Thread.sleep(1000);
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
		
				
				
			}	else
			{
				System.out.println("Cannot edit,benefit Plan not present");
				Log.info("log4j msg- Cannot edit,  Benefit Plan not present");
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
	
			}
			
		}catch(Exception e){e.printStackTrace(); 
		System.out.println("Error in copying claim type in  Benefit Plan");
		Log.info("log4j msg- Error in copying claim type in  Benefit Plan");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();

		
		}	
	
		}
	
	
	
		public void editBenefitPlanCopyServiceType(String benefitPlanCode, String benefitPlanName, String benefitPlanPayer, String newBenefitPlanCode, String newBenefitPlanName, String newBenefitPlanPayer, String newClaimTypeQuery, String newServiceTypeQuery, String premiumStartDate, String visionPremium, String CoverageExtend, String newNotes) throws Exception
		{ try{
			
			
			
			int i= searchBenefitPlan(benefitPlanCode, benefitPlanName, benefitPlanPayer); 

			if(i==1) {
				
				//click edit
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanEditLink));
				driver.findElement(BenefitPlanEditLink).click(); 
				System.out.println("Clicked Edit");
				Log.info("log4j msg- clicked Edit");
				
			
			
				//click service rules
				wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceRulesLink));
				driver.findElement(ServiceRulesLink).click();
				System.out.println("Clicked Service Rules");
				Log.info("log4j msg- Clicked Service Rules");
				Thread.sleep(2000);		
			
				//click edit button
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(EditServiceRuleButton));
				driver.findElement(EditServiceRuleButton).click();
				System.out.println("Clicked Edit Button in Service Rules");
				Log.info("log4j msg- Clicked Edit Button in Service Rules");
				
				//click service type
				wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceTypeButton));
				driver.findElement(ServiceTypeButton).click();		
				System.out.println("Clicked ServiceType Button in Covered Service & UR Rules");
				Log.info("log4j msg- Clicked ServiceType Button in Covered Service & UR Rules");
				
				//enter query
				wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameDescriptionBeginsInput));
				driver.findElement(QueryNameDescriptionBeginsInput).clear();
				driver.findElement(QueryNameDescriptionBeginsInput).sendKeys(newServiceTypeQuery);
				System.out.println("entered claim query");
				Log.info("log4j msg- entered claim query");
				
				
				//click search
				wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearchButton));
				driver.findElement(QuerySearchButton).click();
				System.out.println("clicked search");
				Log.info("log4j msg- clicked search");
				
				
				
				//click copy
				wait.until(ExpectedConditions.visibilityOfElementLocated(QueryCopyLink));
				driver.findElement(QueryCopyLink).click();
				System.out.println("Clicked Copy query");
				Log.info("log4j msg- Clicked Copy query");
				
				//click query name
				wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
				driver.findElement(QueryNameInput).sendKeys("Copy");
				System.out.println("entered query name");
				Log.info("log4j msg- entered query name");
				
				
				
				//click save
				wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySaveLink));
				driver.findElement(QuerySaveLink).click();
				System.out.println("Clicked save query");
				Log.info("log4j msg- Clicked save query");
				Thread.sleep(1000);

				try{
					driver.findElement(By.xpath("//button[text()='OK']")).click();
					System.out.println("Clicked ok for duplicate");
					Log.info("log4j msg- Clicked ok for duplicate");
					
				}catch (Exception e){System.out.println("no duplicate msg");}
				
				try{
				
				//click return selection
				wait.until(ExpectedConditions.visibilityOfElementLocated(QueryReturnSelection));
				driver.findElement(QueryReturnSelection).click();
				System.out.println("Clicked return selection");
				Log.info("log4j msg- Clicked return selection");
				
				}catch(Exception e){ System.out.println("error in clicking return selection");}
				
				try{
					driver.findElement(By.linkText("Undo")).click();
					System.out.println("Clicked undo");
					Log.info("log4j msg- Clicked undo");	
					
					driver.findElement(By.xpath("//button[text()='YES']")).click();
					System.out.println("Clicked yes");
					Log.info("log4j msg- Clicked yes");	
					
					
					
				}catch(Exception e){System.out.println("error in copying, clicking undo and yes");}
				//click hide
				wait.until(ExpectedConditions.visibilityOfElementLocated(QueriesHideButton));
				driver.findElement(QueriesHideButton).click();
				System.out.println("Clicked Hide");
				Log.info("log4j msg- Clicked Hide");	
				
				//click validate
				wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLink));
				driver.findElement(ValidateLink).click();
				System.out.println("Clicked validate");
				Log.info("log4j msg- Clicked validate");	
				
				//click ok
				wait.until(ExpectedConditions.visibilityOfElementLocated(OKButton));
				driver.findElement(OKButton).click();
				System.out.println("Clicked OK");
				Log.info("log4j msg- Clicked OK");	
				
				
				//click save
				wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
				driver.findElement(SaveLink).click();
				System.out.println("Clicked save");
				Log.info("log4j msg- Clicked save");	
				Thread.sleep(1000);
				
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
			
				
				
				}	else
			{
				System.out.println("Cannot edit,benefit Plan not present");
				Log.info("log4j msg- Cannot edit,  Benefit Plan not present");
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
				
				
			}
			
		}catch(Exception e){e.printStackTrace(); System.out.println("Error in copying  service type in  Benefit Plan");
		Log.info("log4j msg- Error in copying  service type in  Benefit Plan");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();

		
		}	
	
		}
	
		public void deleteBenefitPlanCopyClaimTypeServiceType( String benefitPlanCode, String  benefitPlanName, String benefitPlanPayer, String  deleteClaimQuery, String deleteServiceQuery) throws Exception
		{
			
		System.out.println("claim query"+deleteClaimQuery);
		System.out.println("service query"+deleteServiceQuery);
				try{
				
					int i= searchBenefitPlan(benefitPlanCode, benefitPlanName, benefitPlanPayer); 

				if(i==1) {
					
					//click edit
					wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanEditLink));
					driver.findElement(BenefitPlanEditLink).click(); 
					System.out.println("Clicked Edit");
					Log.info("log4j msg- clicked Edit");
					
				
				
					//click service rules
					wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceRulesLink));
					driver.findElement(ServiceRulesLink).click();
					System.out.println("Clicked Service Rules");
					Log.info("log4j msg- Clicked Service Rules");
					Thread.sleep(2000);		
				
					//click edit button
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(EditServiceRuleButton));
					driver.findElement(EditServiceRuleButton).click();
					System.out.println("Clicked Edit Button in Service Rules");
					Log.info("log4j msg- Clicked Edit Button in Service Rules");
					
					//click Claim type
					wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimTypeButton));
					driver.findElement(ClaimTypeButton).click();
					
					System.out.println("Clicked claim Type Button in Covered Service & UR Rules");
					Log.info("log4j msg- Clicked claimType Button in Covered Service & UR Rules");
					try{
					//enter query
					wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameDescriptionBeginsInput));
					driver.findElement(QueryNameDescriptionBeginsInput).clear();
					driver.findElement(QueryNameDescriptionBeginsInput).sendKeys(deleteClaimQuery);
					System.out.println("entered  claim query");
					Log.info("log4j msg- entered claim  query");
					} catch (Exception e){System.out.println("Error in entering claim claim query");}
				
					try{
					//click search
					wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearchButton));
					driver.findElement(QuerySearchButton).click();
					System.out.println("clicked search");
					Log.info("log4j msg- clicked search");
					
					}catch(Exception e){System.out.println("error in clicking search");}
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteQueryLink));
					driver.findElement(DeleteQueryLink).click();
					System.out.println("clicked delete");
					Log.info("log4j msg- clicked delete");
					
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Yes']")));
						driver.findElement(By.xpath("//button[text()='Yes']")).click();
						System.out.println("clicked yes");
						Log.info("log4j msg- clicked yes");
					}catch (Exception e){System.out.println("no yes");}
					
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='YES']")));
						driver.findElement(By.xpath("//button[text()='YES']")).click();
						System.out.println("clicked yes");
						Log.info("log4j msg- clicked yes");
					}catch (Exception e){System.out.println("no yes");}
					
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[text()='OK']"))));
						driver.findElement(By.xpath("//button[ text()='OK']")).click();
						System.out.println("clicked ok");
						Log.info("log4j msg- clicked ok");
					}catch (Exception e){ System.out.println("no ok");}
					
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[text()='Ok']"))));
						driver.findElement(By.xpath("//button[ text()='Ok']")).click();
						System.out.println("clicked ok");
						Log.info("log4j msg- clicked ok");
					}catch (Exception e){ System.out.println("no ok");}
					
					
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Cancel Selection")));
						driver.findElement(By.linkText("Cancel Selection")).click();
						System.out.println("clicked Cancel Selection");
						Log.info("log4j msg- clicked Cancel Selection");
						
						}catch(Exception e){ System.out.println("error in clicking cancel selection");}
						
					Thread.sleep(2000);
					
				try{
					 //click service type
				wait.until(ExpectedConditions.visibilityOfElementLocated(ServiceTypeButton));
				driver.findElement(ServiceTypeButton).click();
				System.out.println("Clicked ServiceType Button in Covered Service & UR Rules");
				Log.info("log4j msg- Clicked ServiceType Button in Covered Service & UR Rules");
				
				
				try {
					//enter query
				wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameDescriptionBeginsInput));
				driver.findElement(QueryNameDescriptionBeginsInput).clear();
				driver.findElement(QueryNameDescriptionBeginsInput).sendKeys(deleteServiceQuery);
				System.out.println("entered service query");
				Log.info("log4j msg- entered service  query");
				
				}catch(Exception e){System.out.println("error in entering service query");}
				//click search
				
				try{
				wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearchButton));
				driver.findElement(QuerySearchButton).click();
				System.out.println("clicked search");
				Log.info("log4j msg- clicked search");
				} catch(Exception e){System.out.println("error in clicking search");}
				
				try{
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteQueryLink));
					driver.findElement(DeleteQueryLink).click();
					System.out.println("clicked delete");
					Log.info("log4j msg- clicked delete");
				}catch(Exception e){System.out.println("error in clicking delete query link");}
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Yes']")));
						driver.findElement(By.xpath("//button[text()='Yes']")).click();
						System.out.println("clicked Yes");
						Log.info("log4j msg- clicked Yes");
					}catch (Exception e){System.out.println("no Yes");}
					
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='YES']")));
						driver.findElement(By.xpath("//button[text()='YES']")).click();
						System.out.println("clicked YES");
						Log.info("log4j msg- clicked YES");
					}catch (Exception e){System.out.println("no YES");}
					
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[text()='OK']"))));
						driver.findElement(By.xpath("//button[ text()='OK']")).click();
						System.out.println("clicked OK");
						Log.info("log4j msg- clicked OK");
					}catch (Exception e){System.out.println("no OK");}
					
					try{
						wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[text()='Ok']"))));
						driver.findElement(By.xpath("//button[ text()='Ok']")).click();
						System.out.println("clicked Ok");
						Log.info("log4j msg- clicked Ok");
					}catch (Exception e){ System.out.println("no Ok");}
					
						try{
							wait.until(ExpectedConditions.visibilityOfElementLocated((By.linkText("Cancel Selection"))));
							driver.findElement(By.linkText("Cancel Selection")).click();
							System.out.println("clicked Cancel Selection");
							Log.info("log4j msg- clicked Cancel Selection");
							
							}catch(Exception e){e.printStackTrace(); System.out.println("Error in clicking cancel selection");Log.info("Error in clicking cancel selection");}
							
				}catch (Exception e){e.printStackTrace(); System.out.println("error in clicking service type button"); Log.info("error in clicking service type button");}		
					
				try{	
					
					//click hide
					wait.until(ExpectedConditions.visibilityOfElementLocated(QueriesHideButton));
					driver.findElement(QueriesHideButton).click();
					System.out.println("Clicked Hide");
					Log.info("log4j msg- Clicked Hide");	
					
				}catch (Exception e){ e.printStackTrace(); System.out.println("error in clicking hide");Log.info("error in clicking hide");}
				
			/*	
				try{//click validate
					wait.until(ExpectedConditions.visibilityOfElementLocated(ValidateLink));
					driver.findElement(ValidateLink).click();
					System.out.println("Clicked validate");
					Log.info("log4j msg- Clicked validate");	
				} catch(Exception e){e.printStackTrace(); System.out.println("error in clicking validate");}
				
				
				try{//click ok
					wait.until(ExpectedConditions.visibilityOfElementLocated(OKButton));
					driver.findElement(OKButton).click();
					System.out.println("Clicked OK");
					Log.info("log4j msg- Clicked OK");	
				}catch(Exception e){e.printStackTrace(); System.out.println("error in clicking ok");}
				*/
				
				try{	//click save
					wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
					driver.findElement(SaveLink).click();
					System.out.println("Clicked save");
					Log.info("log4j msg- Clicked save");	
					
					Thread.sleep(2000);
					BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
			
					
				} catch(Exception e){e.printStackTrace(); System.out.println("error in clicking save");Log.info("error in clicking save");}
			}
						
					else
					{
						System.out.println("Cannot continue, Benefit Plan not present");
						Log.info("log4j msg- Cannot continue, Benefit Plan not present");
						BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();

						
					}
				} catch (Exception e){
					e.printStackTrace();
					System.out.println("error in deleting query in Benefit plan");
					Log.info("log4j msg - error in deleting query in Benefit Plan"); 
					BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
					

				}
		}
					
		
	
	//add communication function
	public void addCommBenefitPlan( String benefitPlanCode, String benefitPlanName, String benefitPlanPayer, String subject, String noteType, String noteMedium, String noteDetails) throws Exception{
		try{ 	
			
	
			//find benefit plan
		int i= searchBenefitPlan(benefitPlanCode, benefitPlanName, benefitPlanPayer); 

		if(i==1) {
			//click comm
		
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanCommLink));
				driver.findElement(BenefitPlanCommLink).click();
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
				Thread.sleep(3000);
				//click add details
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-ng-click='addChildRecord()']")));
				driver.findElement(By.xpath("//button[@data-ng-click='addChildRecord()']")).click();
				System.out.println("clicked add details");
				Log.info("log4j msg- clicked add details");
				
				Thread.sleep(1000);
				//select note type
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ddlNoteType']")));
				Select placeOfService = new Select(driver.findElement(By.xpath("//select[@id='ddlNoteType']")));
				placeOfService.selectByVisibleText(noteType);
				System.out.println("selected note type");
				Log.info("log4j msg-selected note type");
				
				Thread.sleep(1000);
				//enter note details
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='txtNotes']")));
				driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(noteDetails);
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
				Thread.sleep(1000);
				//click save
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Save")));
				driver.findElement(By.linkText("Save")).click();
				System.out.println("clicked save");
				Log.info("log4j msg- clicked save");
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
		
				
		}
		else
			{
				System.out.println("Cannot Add Comm, Benefit Plan not present");
				Log.info("log4j msg- Cannot Add Comm, Benefit Plan not present");
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
	
				
			}
			} catch (Exception e){e.printStackTrace();
			System.out.println("error in adding Comm to Benefit Plan");
			Log.info("log4j msg - error in adding Comm to  Benefit Plan"); 
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
		
		}	
	}
	
	// exit function
	public void exitBenefitPlan(String benefitPlanCode, String benefitPlanName, String benefitPlanPayer) throws Exception{
	 try{	
		 	
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanExitLink));
		driver.findElement(BenefitPlanExitLink).click(); 
		System.out.println("Clicked exit");
		Log.info("log4j msg- clicked exit");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
	
		
	 } catch (Exception e){ 
		System.out.println("Error in exiting Benefit Plan");
		Log.info("log4j msg- Error in exiting Benefit Plan");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
	
		
		}
	}
	
	//delete function	
	public void deleteBenefitPlan( String benefitPlanCode, String benefitPlanName, String benefitPlanPayer) throws Exception{
	
try{

	
	int i= searchBenefitPlan(benefitPlanCode, benefitPlanName, benefitPlanPayer); 

			if(i==1) {
				
				//click delete
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanDeleteLink));
				driver.findElement(BenefitPlanDeleteLink).click(); 
				System.out.println("Clicked Delete");
				Log.info("log4j msg- clicked Delete");
				
				//click confirm delete
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(BenefitPlanConfirmDeleteButton));
				driver.findElement(BenefitPlanConfirmDeleteButton).click(); 
				System.out.println("Clicked confirm Delete");
				Log.info("log4j msg- clicked confirm Delete");
				Thread.sleep(2000);
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
			
		
			}
			else
			{
				System.out.println("Cannot Delete, Benefit Plan not present");
				Log.info("log4j msg- Cannot Delete, Benefit Plan not present");
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
		
			}
			
		}catch(Exception e){
		System.out.println("Error in Deleting Benefit Plan");
		Log.info("log4j msg- Error in Deleting Benefit Plan");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); driver.quit();
	
		}		
	}

	
}
