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

public class ProviderListingPage {
 
	WebDriver driver;
	WebDriverWait wait ;
	
	By ContractHideButton= By.xpath("//button[@data-ng-click='closeMe()']");
	
	By addContractButton= By.xpath("//button[@data-ng-click='addCont()']");
	
	By contractEffectiveDate = By.xpath("//input[@id='childhireddate']");
	
	By ContractEndDate = By.xpath("//input[@id='terminateddate']");
	
	By ContractSpecialitySelect= By.xpath("//select[@data-ng-model='provCont.specialty']");
	
	By ContractPayerSelect= By.xpath("//select[@data-ng-model='provCont.payor']");

	By ContractBenefitSelect= By.xpath("//select[@data-ng-model='provCont.ben_class']");
	
	By ContractServiceSiteSelect = By.xpath("//select[@data-ng-model='provCont.addresskey']");
	
	By ContractRedirectToPayee= By.xpath("//input[@data-ng-model='provCont.payee']");
	
	By ContractFeeSchedule= By.xpath("//select[@data-ng-model='provCont.schedule']");
	
	By providerAddFAXInput = By.xpath("//input[@data-ng-model='clinicalBilling.fax']");
	
	By providerAddPhoneInput = By.xpath("//input[@data-ng-model='clinicalBilling.phone']");
	
	By providerAddCountyInput= By.xpath("//input[@data-ng-model='clinicalBilling.county']");
	
	By TaxonomyIDInput = By.xpath("//input[@data-ng-model='clinicalBilling.taxonomy']");
	
	By providerGenderSelect= By.xpath("//select[@data-ng-model='prov.sex']");
	
	By providerAddDOB= By.xpath("//input[@id='birthdate']");
	
	By providerDegreeSelect= By.xpath("//select[@data-ng-model='prov.degree']");

	By providerTypeSelect= By.xpath("//select[@data-ng-model='prov.provtype']");
	
	By providerDeleteLink= By.linkText("Delete");

	By clickOkButton= By.xpath("//button[text()='ok']");

	By clickYesButton= By.xpath("//button[text()='yes']");

	By ContractsLink= By.xpath("//a[text()='3 - Contracts']");

	By providerExitLink= By.linkText("Exit");	

	By providerCommLink = By.linkText("Commun.");

	By providerClickAddComm= By.xpath("id('modalContentComm')/div[@class='inner-window']/div[@class='col-sm-12 bottom-header']/ul[1]/li[2]/a[1]/span[1]");

	By providerNameBeginsInput = By.xpath("//input[@id='txtSearchCode']");

	By providerCodeBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.prov']");

	By providerTaxIDBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.tin']");

	By providerNPIBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.npi']");

	By providerCityBeginsInput= By.xpath("//input[@data-ng-model='filterOptions.city']");

	By providerStateBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.state']");

	By providerZIPBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.zipcode']");

	By providerSpecialityBeginsInput = By.xpath("//input[@data-ng-model='filterOptions.specialty']");

	By providerSearchButton = By.xpath("//button[text()='Search']");

	By providerNewButton = By.xpath("//button[text()='New']");

	By providerAddLink= By.xpath("//a[@data-ng-click='addForm()']");

	By providerAddLastnameInput= By.xpath("//input[@data-ng-model='prov.last_name']");
 
	By providerAddFirstnameInput = By.xpath("//input[@data-ng-model='prov.first_name']");
 
	By providerAddMiddleInitialInput = By.xpath("//input[@data-ng-model='prov.mi']");

	By providerAddCodeInput= By.xpath("//input[@data-ng-model='prov.prov']");
 
	By providerAddNPIInput = By.xpath("//input[@data-ng-model='prov.npi']");
 
	By providerAddStartDateInput = By.xpath("//input[@id='hireddate']");

	By providerAddEndDateInput = By.xpath("//input[@id='terminatedate']");
	
	By providerAddTAXIDInput = By.xpath("//input[@data-ng-model='prov.tin']");

	By providerAddSpecialitySelect = By.xpath("//select[@data-ng-model='prov.specialty']");
 
	By providerAddAddressDetailsButton = By.xpath("//button[@data-ng-click='addAddr()']");
 
	By providerAddSiteStartDateInput= By.xpath("//input[@id='childhireddate']");

	By providerAddSiteEndDateInput = By.xpath("//input[@id='terminateddate']");
 
	By providerAddSiteTypeSelect = By.xpath("//select[@id='officetype']");

	By providerAddUserField1 = By.xpath("//input[@data-ng-model='clinicalBilling.userfield1']");
 		
	By providerAddUserField2 = By.xpath("//input[@data-ng-model='clinicalBilling.userfield2']");
 
	By providerAddAddressInput = By.xpath("//input[@data-ng-model='clinicalBilling.address1']");
 
	By providerAddCityInput = By.xpath("//input[@data-ng-model='clinicalBilling.city']");
 
	By providerAddStateSelect = By.xpath("//select[@data-ng-model='clinicalBilling.state']");
 
	By providerAddZIPInput = By.xpath("//input[@data-ng-model='clinicalBilling.zipcode']");
 
	By providerAddHideButton= By.xpath("//button[@data-ng-click='closeMe()']");
 
	By providerAddSaveLink= By.linkText("Save");

	By providerEditLink = By.linkText("Edit");
 		
 	By providerEmailInput= By.xpath("//input[@data-ng-model='prov.email_address']");
 
 	By providerCopyLink = By.linkText("Copy");

 	By totalNoOfProviders= By.xpath("//div[@class=class='col-sm-2 col-md-3 no-padding record-info ng-binding' and contains(text(),'Records')]");

 	
 	
 	
 	
 	
 	public ProviderListingPage(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 35);    
	}
	
	
	public int searchProvider( String pLastname, String pCode, String pNPI, String pTaxID, String pCity, String pState, String pZip, String pSpeciality) throws Exception{
		try{
		//enter  provider lastname
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerNameBeginsInput));
		driver.findElement(providerNameBeginsInput).clear();
		driver.findElement(providerNameBeginsInput).sendKeys(pLastname);
		System.out.println("entered provider lastname");
		Log.info("log4j msg- entered provider lastname");
		
		//enter provider code
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerCodeBeginsInput));
		driver.findElement(providerCodeBeginsInput).clear();
		driver.findElement(providerCodeBeginsInput).sendKeys(pCode);
		System.out.println("entered provider Code");
		Log.info("log4j msg- entered provider Code");
		
		//enter provider npi
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerNPIBeginsInput));
		driver.findElement(providerNPIBeginsInput).clear();
		driver.findElement(providerNPIBeginsInput).sendKeys(pNPI);
		System.out.println("entered provider NPI");
		Log.info("log4j msg- entered provider NPI");
		
		//enter provider tax id
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerTaxIDBeginsInput));
		driver.findElement(providerTaxIDBeginsInput).clear();
		driver.findElement(providerTaxIDBeginsInput).sendKeys(pTaxID);
		System.out.println("entered provider Tax ID");
		Log.info("log4j msg- entered provider Tax ID");
		
		//enter provider city
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerCityBeginsInput));
		driver.findElement(providerCityBeginsInput).clear();
		driver.findElement(providerCityBeginsInput).sendKeys(pCity);
		System.out.println("entered provider City");
		Log.info("log4j msg- entered provider City");
		
		//enter provider state
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerStateBeginsInput));
		driver.findElement(providerStateBeginsInput).clear();
		driver.findElement(providerStateBeginsInput).sendKeys(pState);
		System.out.println("entered provider State");
		Log.info("log4j msg- entered provider State");
		
		/*
		
		//enter provider zip
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerZIPBeginsInput));
		driver.findElement(providerZIPBeginsInput).clear();
		driver.findElement(providerZIPBeginsInput).sendKeys(pZip);
		System.out.println("entered provider ZIP");
		Log.info("log4j msg- entered provider ZIP");
	
		/*
		
		//enter provider speciality
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerSpecialityBeginsInput));
		driver.findElement(providerSpecialityBeginsInput).clear();
		driver.findElement(providerSpecialityBeginsInput).sendKeys(pSpeciality);
		System.out.println("entered provider Speciality");
		Log.info("log4j msg- entered provider Speciality");
		
		
		*/
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerSearchButton));
		driver.findElement(providerSearchButton).click();
		System.out.println("clicked Search");
		Log.info("log4j msg- clicked Search");
		
		
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+pCode+"']")));
		WebElement e = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()='"+pCode+"']"));
		e.click();
		System.out.println("Found provider");
		Log.info("log4j msg- Found provider");
	
		return 1;
		}
		catch(Exception e) { Log.info("log4j msg- Provider not found");
		System.out.println("Provider not found"); 
		return 0; }
		
		}
		



	
	
	public void addProvider(String pLastname, String pFirstname, String pMiddleInitial, String pCode, String pNPI, String pType, String providerDegree, String pDOB, String pGender, String pActiveFrom, String pTerminationDate, String pTAXid, String pSpeciality,String pSiteStartDate, String pSiteEndDate,String pSiteType, String pTAXONOMYcode, String pAddr, String pCity, String pState, String pZIP, String pCounty,  String pPhNo, String providerFAX,  String pUserField, String specialitiesCurrentStatus, String specialitiesEffectivePeriod, String specialityInfo, String IDType, String IDNumber, String IDEffectivePeriod, String ProviderContractEndDate, String payer, String benefitClass, String serviceSite, String paymentsCreditToTIN, String redirectToPayee, String feeSchedule, String vendorName, String vendorType, String vendorNPI, String vendorAPID, String vendorActiveStatusEndDate, String vendorDefaultTaxID) throws Exception
	{
		//search for provider, if not found, add provider
		
	int i= searchProvider( pLastname, pCode, pNPI, pTAXid, pCity, pState, pZIP, pSpeciality);
		

	if (i==1){
		System.out.println("Provider already present in the system");
		Log.info("log4j msg- Provider already present in the system");
		Thread.sleep(2000);BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	}
	
	else{
		System.out.println(" Adding new provider");
		Log.info("log4j msg- Adding new provider");
		
		
		
		try{
		
			//find providers with name starting with i
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerNameBeginsInput));
			driver.findElement(providerNameBeginsInput).clear();
			driver.findElement(providerNameBeginsInput).sendKeys("k");
			System.out.println("entered k in provider lastname");
			Log.info("log4j msg- entered k in provider lastname");
			
			//clear provider code
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerCodeBeginsInput));
			driver.findElement(providerCodeBeginsInput).clear();
			
		
			
			//clear provider npi
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerNPIBeginsInput));
			driver.findElement(providerNPIBeginsInput).clear();
		
			
			//clear provider tax id
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerTaxIDBeginsInput));
			driver.findElement(providerTaxIDBeginsInput).clear();
			
		
			
			//clear provider city
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerCityBeginsInput));
			driver.findElement(providerCityBeginsInput).clear();
			
			
			//clear provider state
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerStateBeginsInput));
			driver.findElement(providerStateBeginsInput).clear();
			
			
			//clear provider zip
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerZIPBeginsInput));
			driver.findElement(providerZIPBeginsInput).clear();
			
			driver.findElement(providerSearchButton).click();
			System.out.println("clicked Search");
			Log.info("log4j msg- clicked Search");
			
			Thread.sleep(3000);
			String n= driver.findElement(By.xpath("//div[@class='col-sm-2 col-md-3 no-padding record-info ng-binding']")).getText();
			System.out.println("no. of providers with name starting with K="+n);
			Log.info("log4j msg- no. of providers with name starting with K="+n);
			
			//click Add
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddLink));
		driver.findElement(providerAddLink).click();
		System.out.println("clicked provider - Add");
		Log.info("log4j msg- Clicked Provider-Add");
		
		//enter lastname
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddLastnameInput));
		driver.findElement(providerAddLastnameInput).sendKeys(pLastname);
		System.out.println("Entered Provider lastname");
		Log.info("log4j msg- Entered Provider lastname");
		
		//enter firstname
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddFirstnameInput));
		driver.findElement(providerAddFirstnameInput).sendKeys(pFirstname);
		System.out.println("Entered Provider Firstname");
		Log.info("log4j msg- Entered Provider Firstname");
		
		//enter provider middle initial
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddMiddleInitialInput));
		driver.findElement(providerAddMiddleInitialInput).sendKeys(pMiddleInitial);
		System.out.println("Entered Provider Middle Initial");
		Log.info("log4j msg- Entered Provider Middle Initial");
		
		//enter pcode
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddCodeInput));
		driver.findElement(providerAddCodeInput).sendKeys(pCode);
		System.out.println("Entered Provider Code");
		Log.info("log4j msg- Entered Provider Code");
		
		//enter npi
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddNPIInput));
		driver.findElement(providerAddNPIInput).sendKeys(pNPI);
		System.out.println("Entered Provider NPI");
		Log.info("log4j msg- Entered Provider NPI");
		
		Thread.sleep(1000);
		//select Provider TYPE
		System.out.println("Provider Type:"+pType);
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerTypeSelect));
		Select providerType=new Select(driver.findElement(providerTypeSelect));
		
		providerType.selectByVisibleText(pType);
		//siteType.selectByValue(pSiteType);
		
		System.out.println("Selected Provider  Type");
		Log.info("log4j msg- Selected Provider Type");
		
		Thread.sleep(1000);
		
		
		//select DEGREE
		
		System.out.println("Provider Degree:"+providerDegree);
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerDegreeSelect));
		Select degreeSelect=new Select(driver.findElement(providerDegreeSelect));
		
		degreeSelect.selectByVisibleText(providerDegree);
		//siteType.selectByValue(pSiteType);
		
		System.out.println("Selected Provider Degree");
		Log.info("log4j msg- Selected Provider Degree");
		}catch (Exception e){System.out.println("exception in entering degreee");}
		Thread.sleep(2000);
		
		
		//ENTER DOB
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddDOB));
		driver.findElement(providerAddDOB).sendKeys(pDOB);
		System.out.println("Entered Provider DOB");
		Log.info("log4j msg- Entered Provider DOB");
		
		//ENTER GENDER
		
		System.out.println("Provider Gender:"+pGender);
		
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerGenderSelect));
		
		Select pGenderSelect=new Select(driver.findElement(providerGenderSelect));
		
		pGenderSelect.selectByVisibleText(pGender);
		//siteType.selectByValue(pSiteType);
		
		System.out.println("Selected Provider Gender");
		Log.info("log4j msg- Selected Provider Gender");
		} catch(Exception e){System.out.println("exception in gender");}
		Thread.sleep(2000);
		
		
		//enter Hired date
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddStartDateInput));
		driver.findElement(providerAddStartDateInput).sendKeys(pActiveFrom);
		System.out.println("Entered Provider Hired Date");
		Log.info("log4j msg- Entered Provider Hired Date");
		
		//enter Termination date
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddEndDateInput));
		driver.findElement(providerAddEndDateInput).sendKeys(pTerminationDate);
		System.out.println("Entered Provider Termination Date");
		Log.info("log4j msg- Entered Provider Termination Date");
		
		
		//enter tax id
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddTAXIDInput));
		driver.findElement(providerAddTAXIDInput).sendKeys(pTAXid);
		System.out.println("Entered Provider TAX ID");
		Log.info("log4j msg- Entered Provider TAX ID");
		
		
		Thread.sleep(1000);
		//select default speciality
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddSpecialitySelect));
		
		Select speciality=new Select(driver.findElement(providerAddSpecialitySelect));
		speciality.selectByVisibleText(pSpeciality);

		
		//click Add Address button
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddAddressDetailsButton));
		driver.findElement(providerAddAddressDetailsButton).click();
		System.out.println("Clicked Add button to add address details");
		Log.info("log4j msg- Clicked Add button to add address details");
		Thread.sleep(2000);
		
		//enter site start date
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddSiteStartDateInput));
		driver.findElement(providerAddSiteStartDateInput).sendKeys(pSiteStartDate);
		System.out.println("Entered Provider Site Start Date");
		Log.info("log4j msg- Entered Provider Site Start Date");
		Thread.sleep(2000);
		
		//enter site end date
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddSiteEndDateInput));
		driver.findElement(providerAddSiteEndDateInput).sendKeys(pSiteEndDate);
		System.out.println("Entered Provider Site End Date");
		Log.info("log4j msg- Entered Provider Site End Date");
		Thread.sleep(1000);
		
		//enter site type
		System.out.println("Site Type:"+pSiteType);
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddSiteTypeSelect));
		Select siteType1=new Select(driver.findElement(providerAddSiteTypeSelect));
		
		siteType1.selectByVisibleText(pSiteType);
		//siteType.selectByValue(pSiteType);
		//siteType1.selectByIndex(0);
		System.out.println("Selected Provider Site Type");
		Log.info("log4j msg- Selected Provider Site Type");
		}catch(Exception e){System.out.println("exception in entering site type");}
		Thread.sleep(1000);
		
		//ENTER TAXONOMY ID 
		wait.until(ExpectedConditions.visibilityOfElementLocated(TaxonomyIDInput));
		driver.findElement(TaxonomyIDInput).sendKeys(pTAXONOMYcode);
		System.out.println("Entered Taxonomy Code");
		Log.info("log4j msg- Entered Taxonomy code");
		Thread.sleep(2000);
		
		//enter address		
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddAddressInput));
		driver.findElement(providerAddAddressInput).sendKeys(pAddr);
		System.out.println("Selected Provider Address");
		Log.info("log4j msg- Selected Provider Address");
		Thread.sleep(1000);
		
		//enter city
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddCityInput));
		driver.findElement(providerAddCityInput).sendKeys(pCity);
		System.out.println("Selected Provider City");
		Log.info("log4j msg- Selected Provider City");
		Thread.sleep(1000);
		
		//enter state
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddStateSelect));
		Select state=new Select(driver.findElement(providerAddStateSelect));
		state.selectByVisibleText(pState);
		//state.selectByValue(pState);
		//state.selectByIndex(32);
		
		System.out.println("Selected Provider State");
		Log.info("log4j msg- Selected Provider State");
		Thread.sleep(1000);
		} catch(Exception e){System.out.println("Exception in entering state");}
		
		//enter zip		
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddZIPInput));
		driver.findElement(providerAddZIPInput).sendKeys(pZIP);
		System.out.println("Selected Provider ZIP");
		Log.info("log4j msg- Selected Provider ZIP");
		
		Thread.sleep(1000);
		
		
		
		//ENTER COUNTY
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddCountyInput));
		driver.findElement(providerAddCountyInput).sendKeys(pCounty);
		System.out.println("Entered Provider County");
		Log.info("log4j msg-Entered Provider County");
		
		Thread.sleep(1000);
		
		//ENTER PHONE
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddPhoneInput));
		driver.findElement(providerAddPhoneInput).sendKeys(pPhNo);
		System.out.println("Entered Provider Phone");
		Log.info("log4j msg-Entered Provider Phone");
		
		Thread.sleep(1000);
		
		
		
		
		//ENTER FAX
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddFAXInput));
		driver.findElement(providerAddFAXInput).sendKeys(providerFAX);
		System.out.println("Entered Provider FAX");
		Log.info("log4j msg-Entered Provider FAX");
		
		Thread.sleep(1000);
		
		
		
		if (pState.contentEquals("TX") || pState.contentEquals("GA") ||pState.contentEquals("IN") ||pState.contentEquals("PA"))
		//enter userfield 1
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddUserField1));
	
		driver.findElement(providerAddUserField1).sendKeys(pUserField);
		System.out.println("Entered Provider User Field 1");
		Log.info("log4j msg- Entered Provider User Field 1");
		}
	
		else
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddUserField2));
			driver.findElement(providerAddUserField2).sendKeys(pUserField);
			System.out.println("Entered Provider User Field 2");
			Log.info("log4j msg- Entered Provider User Field 2");
			
		}
		
	
		

		Thread.sleep(1000);
		//click hide
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddHideButton));
		driver.findElement(providerAddHideButton).click();
		System.out.println("Clicked Hide Button");
		Log.info("log4j msg- Clicked Hide Button");
		
		
		driver.findElement(By.xpath("//input[@data-ng-model='prov.userfield1']")).sendKeys(Keys.PAGE_UP);
		
		
		//click 3- contracts
		System.out.println("Adding Contract now");
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContractsLink));
		driver.findElement(ContractsLink).click();
		System.out.println("Clicked Contracts");
		Log.info("log4j msg- Clicked Contracts");
		
		}catch(Exception e){System.out.println("exception on clicking contracts");}
		
		//click add contract details
		wait.until(ExpectedConditions.visibilityOfElementLocated(addContractButton));
		driver.findElement(addContractButton).click();
		System.out.println("Clicked Add Contract Button");
		Log.info("log4j msg- Clicked Add Contract Button");
		Thread.sleep(3000);
		//enter contract effective date
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(contractEffectiveDate));
		driver.findElement(contractEffectiveDate).sendKeys("01012001");
		System.out.println("Clicked contract Effective Date");
		Log.info("log4j msg- Clicked Contract Effective Date");
		Thread.sleep(3000);
		//enter contract end date
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContractEndDate));
		driver.findElement(ContractEndDate).sendKeys(ProviderContractEndDate);
		System.out.println("Clicked contract End Date");
		Log.info("log4j msg- Clicked Contract End Date");
		
		
		Thread.sleep(1000);
		//select speciality
		System.out.println("Contract speciality:"+pSpeciality);
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContractSpecialitySelect));
		Select contractSpeciality=new Select(driver.findElement(ContractSpecialitySelect));
		
		contractSpeciality.selectByVisibleText(pSpeciality);
		//siteType.selectByValue(pSiteType);
		//siteType1.selectByIndex(0);
		System.out.println("Selected contract speciality type");
		Log.info("log4j msg- Selected speciality type");
		}catch(Exception e){System.out.println("Exception on entering contract speciality");}
		Thread.sleep(1000);
		
		
		//select payer
		
		System.out.println("Contract payer:"+payer);
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContractPayerSelect));
		Select contractPayer=new Select(driver.findElement(ContractPayerSelect));
		
		contractPayer.selectByVisibleText(payer);
		//siteType.selectByValue(pSiteType);
		//siteType1.selectByIndex(0);
		System.out.println("Selected contract payer");
		Log.info("log4j msg- Selected payer");
		
		}catch(Exception e){System.out.println("Exception in selecting payer");}
		Thread.sleep(1000);
		//select benefit class
		System.out.println("Benefit class:"+benefitClass);
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContractBenefitSelect));
		Select contractBenefitClass=new Select(driver.findElement(ContractBenefitSelect));
		
		contractBenefitClass.selectByVisibleText(benefitClass);
		//siteType.selectByValue(pSiteType);
		//siteType1.selectByIndex(0);
		System.out.println("Selected Benefit Class");
		Log.info("log4j msg- Selected Benefit Class");
		
		}catch(Exception e){System.out.println("exception in selecting benefit class");}
		Thread.sleep(1000);
		//select service site address
		
		System.out.println("Service site:"+serviceSite);
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContractServiceSiteSelect));
		Select contractServiceSite=new Select(driver.findElement(ContractServiceSiteSelect));
		
		contractServiceSite.selectByVisibleText(serviceSite);
		//siteType.selectByValue(pSiteType);
		//siteType1.selectByIndex(0);
		System.out.println("Selected service site");
		Log.info("log4j msg- Selected service site");
		}catch(Exception e){System.out.println("Exception in selecting service site");}
		Thread.sleep(1000);
		//enter new contract tin
		driver.findElement(By.xpath("//input[@data-ng-model='provCont.tin']")).clear();
		driver.findElement(By.xpath("//input[@data-ng-model='provCont.tin']")).sendKeys(paymentsCreditToTIN);
		
		
		
		
		
		/* Getting error here- checking
		
		
		//enter redirect to payee details
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContractRedirectToPayee));
		driver.findElement(ContractRedirectToPayee).sendKeys(redirectToPayee);
		System.out.println("entered redirect to payee info");
		Log.info("log4j msg-entered redirect to payee info");
		
		*/
		
		Thread.sleep(3000);
		//select the fee schedule
		System.out.println("fee schedule:"+feeSchedule);
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContractFeeSchedule));
		Select contractFeeSchedule=new Select(driver.findElement(ContractFeeSchedule));
		
		contractFeeSchedule.selectByVisibleText(feeSchedule);
		//siteType.selectByValue(pSiteType);
		//siteType1.selectByIndex(0);
		System.out.println("Selected fee schedule");
		Log.info("log4j msg- Selected fee schedule");
		
		}catch(Exception e){System.out.println("Exception in entering fee schedule");}
		Thread.sleep(2000);
		//click hide
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(ContractHideButton));
		driver.findElement(ContractHideButton).click();
		System.out.println("click hide");
		Log.info("log4j msg-click hide");
		Thread.sleep(2000);
		}catch(Exception e) {
			e.printStackTrace(); 
			System.out.println("error in clicking hide");
			Log.info("error in clicking hide");
		
		}
		
		
		
		
		
		Thread.sleep(3000);
		
		//save
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddSaveLink));
		driver.findElement(providerAddSaveLink).click();
		System.out.println("Clicked Save Link");
		Log.info("log4j msg- Clicked Save Link");
		Thread.sleep(2000);
		
		}catch(Exception e) {
			e.printStackTrace(); 
			System.out.println("error in clicking save");
			Log.info("error in clicking save");
		
		}
		Thread.sleep(3000);		
		
		
		Thread.sleep(2000);
		//validation
		System.out.println("Searching for provider");
		
		int j= searchProvider( pLastname, pCode, pNPI, pTAXid, pCity, pState, pZIP, pSpeciality);
	if (j==1){
		
		
		//click contracts
		//driver.findElement(By.linkText("3-Contracts")).click();
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(ContractsLink));
		
		driver.findElement(ContractsLink).click();
		Thread.sleep(3000);
		
		System.out.println("clicked contracts link");
		}catch(Exception e) { System.out.println("error in clicking contracts link");}
		
		
		
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()= '"+paymentsCreditToTIN+"']")));
			driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()= '"+paymentsCreditToTIN+"']")).click();
			Thread.sleep(2000);
			System.out.println("clicked contract");
			
			
			System.out.println("add success");
			Log.info("log4j msg- add success");
			
			//find number of providers with name starting with k
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerNameBeginsInput));
			driver.findElement(providerNameBeginsInput).clear();
			driver.findElement(providerNameBeginsInput).sendKeys("k");
			System.out.println("entered k in provider lastname");
			
			//clear provider code
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerCodeBeginsInput));
			driver.findElement(providerCodeBeginsInput).clear();
			
		
			
			//clear provider npi
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerNPIBeginsInput));
			driver.findElement(providerNPIBeginsInput).clear();
		
			
			//clear provider tax id
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerTaxIDBeginsInput));
			driver.findElement(providerTaxIDBeginsInput).clear();
			
		
			
			//clear provider city
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerCityBeginsInput));
			driver.findElement(providerCityBeginsInput).clear();
			
			
			//clear provider state
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerStateBeginsInput));
			driver.findElement(providerStateBeginsInput).clear();
			
			
			//clear provider zip
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerZIPBeginsInput));
			driver.findElement(providerZIPBeginsInput).clear();
			
			driver.findElement(providerSearchButton).click();
			System.out.println("clicked Search");
			Log.info("log4j msg- clicked Search");
		Thread.sleep(3000);
			
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		
		
			String m= driver.findElement(By.xpath("//div[@class='col-sm-2 col-md-3 no-padding record-info ng-binding']")).getText();
			System.out.println("no. of providers with name starting with k="+m);
			Log.info("log4j msg- no. of providers with name starting with k="+m);
			//int mLength= m.length();
			//int nLength=n.length();
			int a = Integer.parseInt(m.substring(0,2)+m.substring(3,6));
			int b =  Integer.parseInt(n.substring(0,2)+n.substring(3,6));
			System.out.println("Initial number of providers whose  name starts with 'K': "+ b);
			Log.info("Initial number of providers whose  name starts with 'K': "+ b);
			System.out.println("Total number of providers whose name starts with 'K' now: "+a);
			Log.info("Total number of providers whose name starts with 'K' now: "+a);
			
			if(a-b==1){

			System.out.println("Provider Add- Validation Successful");
			Log.info("log4j msg-Provider Add- Validation Successful");
			
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
			driver.quit();
			
			}
			
		}catch(Exception e){
			e.printStackTrace(); 
			System.out.println("error in adding new provider contract tin starting with 0");
			Log.info("log4j msg- error in adding provider contract new tin starting with 0");
			}
		
	}
	else
	{ 
		System.out.println("add failed");
		Log.info("log4j msg- add failed");
	
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		}}catch (Exception e)
		{
		e.printStackTrace(); 
		System.out.println("Exception in adding Provider"); 
		Log.info("exception in adding Provider"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());  
		driver.quit();
		}			
	}	
	}
	public void editProvider(String pLastname, String pFirstname,String pMiddleInitial, String pCode, String pNPI,String pTAXid, String pAddress, String pCity, String pState, String pZIP, String pSpeciality, String pEditField, String pNewValue) throws Exception
	{
		
		int i= searchProvider( pLastname, pCode, pNPI, pTAXid, pCity, pState, pZIP, pSpeciality);
			
		
		if (i==1){
			System.out.println("Provider present in the system");
			Log.info("log4j msg- Provider present in the system");
			
			//click edit
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerEditLink));
			driver.findElement(providerEditLink).click();
			System.out.println("Clicked Edit Link");
			Log.info("log4j msg- Clicked Edit Link");
			
			
			//edit the field
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerEmailInput));
			driver.findElement(providerEmailInput).clear();
			driver.findElement(providerEmailInput).sendKeys(pNewValue);
			System.out.println("Edited provider email");
			Log.info("log4j msg- edited provider email");
			
			
			Thread.sleep(2000);
			//save
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddSaveLink));
			driver.findElement(providerAddSaveLink).click();	
			System.out.println("Clicked save");
			Log.info("log4j msg- clicked save");
			
			
			Thread.sleep(3000);
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}
		
		else{
			System.out.println(" Provider is not present, cannot proceed with edit");
			Log.info("log4j msg- Provider is not present, cannot proceed with edit");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
	}

	
	
	}

	public void copyProvider(String pLastname, String pFirstname,String pMiddleInitial, String pCode, String pNPI,String pTAXid, String pAddress, String pCity, String pState, String pZIP, String pSpeciality, String pnewNPI, String pnewPCode, String pnewTaxid, String pnewLastname, String pnewFirstname, String pnewMiddleInitial) throws Exception
	{
		int i= searchProvider( pLastname, pCode, pNPI, pTAXid, pCity, pState, pZIP, pSpeciality);
			
		
		if (i==1){
			System.out.println("Provider present in the system");
			Log.info("log4j msg- Provider present in the system");
			
			//click edit
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerCopyLink));
			driver.findElement(providerCopyLink).click();
			System.out.println("Clicked Copy Link");
			Log.info("log4j msg- Clicked Copy Link");

			Thread.sleep(2000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddLastnameInput));
			driver.findElement(providerAddLastnameInput).clear();
			driver.findElement(providerAddLastnameInput).sendKeys(pnewLastname);
			System.out.println("entered new lastname");
			Log.info("log4j msg- entered new lastname");
			
			Thread.sleep(1000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddFirstnameInput));
			driver.findElement(providerAddFirstnameInput).clear();
			driver.findElement(providerAddFirstnameInput).sendKeys(pnewFirstname);
			System.out.println("entered new firstname");
			Log.info("log4j msg- entered new firstname");
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddMiddleInitialInput));
			driver.findElement(providerAddMiddleInitialInput).clear();
			driver.findElement(providerAddMiddleInitialInput).sendKeys(pnewMiddleInitial);
			System.out.println("entered new middle initial");
			Log.info("log4j msg- entered new middle initial");
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddCodeInput));
			driver.findElement(providerAddCodeInput).sendKeys(pnewPCode);
			System.out.println("entered new pcode");
			Log.info("log4j msg- entered new pcode");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddNPIInput));
			driver.findElement(providerAddNPIInput).clear();
			Thread.sleep(1000);
			driver.findElement(providerAddNPIInput).sendKeys(pnewNPI);
			System.out.println("entered new npi");
			Log.info("log4j msg- entered new npi");
			Thread.sleep(1000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddTAXIDInput));
			driver.findElement(providerAddTAXIDInput).clear();
			Thread.sleep(1000);
			driver.findElement(providerAddTAXIDInput).sendKeys(pnewTaxid);
			System.out.println("entered new tax id");
			Log.info("log4j msg- entered new tax id");
			
			Thread.sleep(1000);
			
			//click ok
			
			try{
				//wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddSaveLink));
				driver.findElement(clickOkButton).click();
				System.out.println("clicked ok");
				Log.info("log4j msg- clicked ok");	
			} catch(Exception e){System.out.println("no ok button");}
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerAddSaveLink));
			driver.findElement(providerAddSaveLink).click();
			System.out.println("clicked save");
			Log.info("log4j msg- clicked save");
			
		
			Thread.sleep(3000);
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		
	}

		else{
			System.out.println(" Provider is not present, cannot proceed with copy");
			Log.info("Provider is not present, cannot proceed with copy");
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
	}

}
	
	public void exitProvider( String pLastname, String pCode, String pNPI, String pTaxID, String pCity, String pState, String pZip, String pSpeciality) throws Exception{
try{	
		int i= searchProvider( pLastname, pCode, pNPI, pTaxID, pCity, pState, pZip, pSpeciality);
			
		
		if (i==1){
			System.out.println("Provider present in the system");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerExitLink));
			driver.findElement(providerExitLink).click();
			System.out.println("clicked exit");
			Log.info("log4j msg- clicked exit");
			
			
			
			Thread.sleep(2000);BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}
		
		else{
			System.out.println(" Given Provider not present in the system");
			Log.info("Given provider is not present in the system");
			Thread.sleep(2000);BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
	}
	}catch(Exception e){System.out.println("error in exit provider"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); }
	
	}
	
	public void deleteProvider( String pLastname, String pCode, String pNPI, String pTaxID, String pCity, String pState, String pZip, String pSpeciality) throws Exception{
	try{	
		int i= searchProvider(pLastname, pCode, pNPI, pTaxID, pCity, pState, pZip, pSpeciality);
			
		
		if (i==1){
			System.out.println("Provider present in the system");
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(providerDeleteLink));
			driver.findElement(providerDeleteLink).click();
			System.out.println("clicked delete");
			Log.info("log4j msg- clicked delete");
			//<div class="modal-footer"><button data-bb-handler="Success" type="button" class="btn btn-primary btn-bottom02">Yes</button><button data-bb-handler="No" type="button" class="btn btn-secondary btn-bottom02">No</button></div>
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-footer']/button[@data-bb-handler='Success' and @class='btn btn-primary btn-bottom02' and text()='Yes']")));
			driver.findElement(By.xpath("//div[@class='modal-footer']/button[@data-bb-handler='Success' and @class='btn btn-primary btn-bottom02' and text()='Yes']")).click();
			
			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(clickYesButton));
			//driver.findElement(clickYesButton).click();
			System.out.println("clicked Yes to confirm delete");
			Log.info("log4j msg- clicked Yes to confirm delete");
			
			
			
			Thread.sleep(2000);
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
		}
		
		else{
			System.out.println(" Given Provider not present in the system");
			Log.info("Given provider is not present in the system");
			Thread.sleep(2000);BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
	}
	}catch (Exception e){System.out.println("error in deleting the provider"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); }
	
	}
	
	public void addCommProvider( String pLastname, String pCode, String pNPI, String pTaxID, String pCity, String pState, String pZip, String pSpeciality, String subject, String caseNote, String noteType, String details) throws Exception
	{
		try{	
			int i= searchProvider(pLastname, pCode, pNPI, pTaxID, pCity, pState, pZip, pSpeciality);
				
			
			if (i==1){
				System.out.println("Provider present in the system");
				
				
				
				//add commm
				
				
				//click comm
				wait.until(ExpectedConditions.visibilityOfElementLocated(providerCommLink));
				driver.findElement(providerCommLink).click();
				System.out.println("clicked Comm");
				Log.info("log4j msg- clicked Comm");
				Thread.sleep(1000);
				//click add comm
				wait.until(ExpectedConditions.visibilityOfElementLocated(providerClickAddComm));
				driver.findElement(providerClickAddComm).click();
				System.out.println("clicked Add Comm");
				Log.info("log4j msg- clicked Add Comm");
				
				//enter subject
				//<input type="text" id="txtSubject" tabindex="1" class="form-control ng-valid ng-valid-maxlength ng-not-empty ng-dirty ng-valid-parse ng-touched" maxlength="70" data-ng-model="currentRecord.subject" data-ng-disabled="isAuditing" style="width: 100%;">
				driver.findElement(By.xpath("//input[@id='txtSubject' and @data-ng-model='currentRecord.subject']")).sendKeys(subject);
				System.out.println("entered subject");
				Log.info("log4j msg-entered subject");
				
				//select case type
				
				
				
				Thread.sleep(3000);
				//click add
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("id('tabGeneral')/div[@class='row']/div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 button-wrap']/div[@class='col-lg-10 col-md-10 col-sm-12 col-xs-12 no-padding text-right pull-right']/button[@class='btn btn-primary btn-bottom01' and @data-ng-click='addChildRecord()']")));
				driver.findElement(By.xpath("id('tabGeneral')/div[@class='row']/div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 button-wrap']/div[@class='col-lg-10 col-md-10 col-sm-12 col-xs-12 no-padding text-right pull-right']/button[@class='btn btn-primary btn-bottom01' and @data-ng-click='addChildRecord()']")).click();
				System.out.println("clicked add");
				Log.info("log4j msg-clicked add");
				
				//select note type
				Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlNoteType")));
				Select notetypes=new Select(driver.findElement(By.id("ddlNoteType")));
				Thread.sleep(3000);
				System.out.println("note type:"+ noteType);
				notetypes.selectByVisibleText(noteType);
				System.out.println("selected notetype");
				Log.info("log4j msg-selected notetype");
				Thread.sleep(1000);
				//enter details
				driver.findElement(By.xpath("//textarea[@id='txtNotes']")).sendKeys(details);

				System.out.println("entered comm details");
				Log.info("log4j msg-entered communication details");
				
				//click hide
				driver.findElement(By.xpath("//button[@data-ng-click='closeMe()']")).click();
				System.out.println("clicked on hide");
				Log.info("log4j msg-clicked on hide");
				
				//click close case
				driver.findElement(By.xpath("//button[@data-ng-click='closeCase()']")).click();

				System.out.println("clicked on close case");
				Log.info("log4j msg-clicked on close case");
				Thread.sleep(1000);
				//click validate
				
				//click save
				
				driver.findElement(By.linkText("Save")).click();
				System.out.println("clicked on save");
				Log.info("log4j msg- clicked on save");
	
				
				Thread.sleep(2000);BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
			}
			
			else{
				System.out.println(" Given Provider not present in the system");
				Log.info("Given provider is not present in the system");
				Thread.sleep(2000);BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
		}
		}catch(Exception e){System.out.println("error in provider add communication"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); }
		
	}
	
	
	
}
