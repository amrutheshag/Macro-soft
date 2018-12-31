package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class ClaimITReportPage {
	
	WebDriver driver;
	WebDriverWait wait ;
	
	By ReturnSelectionLink= By.linkText("Return Selection");
	
	By ApprovedServiceOnly= By.xpath("//select[@data-ng-model='claimitreportparam.approvedserviceonly']");
	
	By OpenClaimsOnly= By.xpath("//select[@data-ng-model='claimitreportparam.openclaimsonly']");
	
	By ExtractClaimAndServiceData = By.xpath("//select[@data-ng-model='claimitreportparam.requerydata']");
	
	By DenyServices = By.xpath("//select[@data-ng-model='claimitreportparam.denialOfService']");
	
	By ProviderIDInput= By.xpath("//input[@data-ng-model='claimitreportparam.providerID']");
	
	By MemberIDInput= By.xpath("//input[@data-ng-model='claimitreportparam.memberID']");
	
	By FromDateInput= By.xpath("//input[@data-ng-model='claimitreportparam.fromDateOfSerivce']");
	
	By ToDateInput= By.xpath("//input[@data-ng-model='claimitreportparam.toDateOfSerivce']");
	
	By ClaimQuerySearchButton= By.xpath("(//button[@class='btn btn-primary'])[1]");
	
	By InsurerPayorSearchButton = By.xpath("(//button[@class='btn btn-primary'])[2]");
	
	By GoButton = By.xpath("//button[@ng-click='fn_Exit()']");
	
	By CheckBilaterals = By.xpath("//input[@data-ng-model='claimitreportparam.bilaterals']");
	
	By CheckCCI = By.xpath("//input[@data-ng-model='claimitreportparam.cCI']");
	
	By CheckGlobalPeriods = By.xpath("//input[@data-ng-model='claimitreportparam.globalPeriods']");
	
	By CheckLCPDiagnosis = By.xpath("//input[@data-ng-model='claimitreportparam.lCPDiagnosis']");
	
	By CheckAssistantSurgeon = By.xpath("//input[@data-ng-model='claimitreportparam.assistantSurgeon']");
	
	By PrintResultsButton = By.xpath("//button[@class='btn btn-secondary btn-bottom02 pull-right' and text() = 'Print Results']");
			//By.xpath("/html[@class='ng-scope']/body[@class='ng-scope modal-open']/div[@class='modal fade claimitresultChild in']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='inner-window ng-scope']/div[@class='general-ledger claim-it-results']/div[@class='col-sm-12 col-md-12 col-lg-12 grid-contr']/div[@class='col-sm-12 no-padding service-btn-wrap]/button[@class='btn btn-secondary btn-bottom02 pull-right']");
		
			//By.xpath("//button[@class='btn btn-secondary btn-bottom02 pull-right' and text() = 'Print Results']");
	
	By PrintLink = By.xpath("//a[@data-ng-click='previewReport()']");
	
	By ExitLink =  By.xpath("//a[@data-ng-click='closeMe()']");
			
	By ClientFaultInputInClaimITResults= By.xpath("//input[@data-ng-model='filterOptions.client_fault']");
	
	By ProviderIDInputInClaimITResults= By.xpath("//input[@data-ng-model='filterOptions.payor']");
	
	By PayorInputInClaimsITResults = By.xpath("//input[@data-ng-model='filterOptions.providerID']");
	
	By SearchButtonInClaimITResults = By.xpath("//button[@ng-click='search()']");

	By QueryNameDescriptionBeginsInput = By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptions.name']");

	By QuerySearchButton = By.xpath("(//button[text()='Search'])[3]");
	
	
	public ClaimITReportPage(WebDriver driver){
		this.driver= driver;
		this.wait = new WebDriverWait(driver, 40);
	}
	
	
	public void searchOnDatesPrintClaimITReport( String approvedServiceOnly, String openClaimsOnly, String extractClaimAndServiceData, String denyServices, String providerID, String memberID, String payor, String from, String to, String claimQuery, String insurerPayor, String checkBilaterals, String checkCCI, String checkGlobalPeriods, String checkLCPDiagnosis, String assistantSurgeon) throws Exception{
		
		try{ 	
			
			
			//select no for approved service only
			wait.until(ExpectedConditions.visibilityOfElementLocated(ApprovedServiceOnly)); 
	        Select ApprovedServiceSelect = new Select(driver.findElement(ApprovedServiceOnly));
	        ApprovedServiceSelect.selectByVisibleText(approvedServiceOnly);
	        System.out.println("selected Approved Service Only yes/no");
	        Log.info("log4j msg-selected Approved Service Only yes/no");
	        
	        
			//select no for open claims only
	        wait.until(ExpectedConditions.visibilityOfElementLocated(OpenClaimsOnly)); 
	        Select OpenClaimsOnlySelect = new Select(driver.findElement(OpenClaimsOnly));
	        OpenClaimsOnlySelect.selectByVisibleText(openClaimsOnly);
	        System.out.println("selected open claims Only yes/no");
	        Log.info("log4j msg-selected open claims Only yes/no");
	        
	        
			//select no for extract claim & service data
	        wait.until(ExpectedConditions.visibilityOfElementLocated(ExtractClaimAndServiceData)); 
	        Select ExtractClaimAndServiceDataSelect = new Select(driver.findElement(ExtractClaimAndServiceData));
	        ExtractClaimAndServiceDataSelect.selectByVisibleText(extractClaimAndServiceData);
	        System.out.println("selected extract claim and service data yes/no");
	        Log.info("log4j msg-selected extract claim and service data yes/no");
	        
	        
			//select no for deny services
	        wait.until(ExpectedConditions.visibilityOfElementLocated(DenyServices)); 
	        Select DenyServicesSelect = new Select(driver.findElement(DenyServices));
	        DenyServicesSelect.selectByVisibleText(denyServices);
	        System.out.println("selected deny services yes/no");
	        Log.info("log4j msg-selected deny services yes/no");
	        
			
			//provider id
			
			//member id
			
			//payor
			
			//from (date of service)
	        wait.until(ExpectedConditions.visibilityOfElementLocated(FromDateInput));
			driver.findElement(FromDateInput).sendKeys(from);
			System.out.println("entered from date");
			Log.info("log4j msg- entered from date");
			
			
			//to (date of service)
			 wait.until(ExpectedConditions.visibilityOfElementLocated(ToDateInput));
				driver.findElement(ToDateInput).sendKeys(to);
				System.out.println("entered to date");
				Log.info("log4j msg- entered to date");
			
			
			
			//claim query search
			
			//insurer/ payor query search
			
			
			//check bilaterals
			
				if (checkBilaterals.equalsIgnoreCase("yes")){
				 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckBilaterals));
					driver.findElement(CheckBilaterals).click();
					System.out.println("checked - Check Bilaterals checkbox");
					Log.info("log4j msg- checked - check bilaterals checkbox");
					
				}
				
			//check cci
				if (checkCCI.equalsIgnoreCase("yes")){
					 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckCCI));
						driver.findElement(CheckCCI).click();
						System.out.println("checked - Check CCI checkbox");
						Log.info("log4j msg- checked - check CCI checkbox");
				}		
			//check global periods
						if (checkGlobalPeriods.equalsIgnoreCase("yes")){
						 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckGlobalPeriods));
							driver.findElement(CheckGlobalPeriods).click();
							System.out.println("checked - Check Global Periods checkbox");
							Log.info("log4j msg- checked - check Global Periods checkbox");
						}
			//check lcp diagnosis
			if (checkLCPDiagnosis.equalsIgnoreCase("yes")){
							wait.until(ExpectedConditions.visibilityOfElementLocated(CheckLCPDiagnosis));
							driver.findElement(CheckLCPDiagnosis).click();
							System.out.println("checked - Check LCPD Diagnosis checkbox");
							Log.info("log4j msg- checked - check LCPD Diagnosis checkbox");
			}
			//check assistant surgeon
			if (assistantSurgeon.equalsIgnoreCase("yes")){	
			wait.until(ExpectedConditions.visibilityOfElementLocated(CheckAssistantSurgeon));
							driver.findElement(CheckAssistantSurgeon).click();
							System.out.println("checked - Check Assistant Surgeon checkbox");
							Log.info("log4j msg- checked - check Assistant Surgeon checkbox");
			}
			System.out.println(driver.getTitle());
			
			//click go
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(GoButton));
							driver.findElement(GoButton).click();
							System.out.println("clicked Go");
							Log.info("log4j msg- clicked Go");	
							
							Thread.sleep(10000);
							try{
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Internal Server Error']")));
							System.out.println("Internal Server error");
							Log.info("Internal Server Error");
							BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
							driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();		
							System.out.println("clicked ok");
							Log.info("clicked ok");
							driver.quit();
						
							
							}catch(Exception e){
							
							try{
								
								
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='No Violations andor Service Reductions were identified.']")));
								System.out.println("No Violations");
								Log.info("No Violations");
								BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
							
							
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
								driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
								System.out.println("clicked ok");
								Log.info("clicked ok");
								driver.quit();
							
							
							}catch (Exception e1){ System.out.println("continue with report");
									
								
							ArrayList tabs = new ArrayList<Object> (driver.getWindowHandles());
							int i = tabs.size();
							System.out.println("Tab size when clicking Go" + i);
							driver.switchTo().window((String) tabs.get(i-1));
							
							System.out.println(driver.getTitle());
							
							//driver.switchTo().frame(0);
							
							
						/*
							ArrayList tabs = new ArrayList (driver.getWindowHandles());
							int i = tabs.size();
						System.out.println("Tab size when clicking Go" + i);
							driver.switchTo().window((String) tabs.get(i));
							
							System.out.println(driver.getTitle());
						*/
							
							//waitForNumberofWindowsToEqual(2);//this method is for wait
							

						/*	 for (String handle : driver.getWindowHandles()) {

							    driver.switchTo().window(handle);}

							 System.out.println(driver.getTitle());
							 
						*/
						/*
							//Switching between windows with Iterators:
							 

							 


							 driver.findElement(By.id(“id of the link which opens new window”)).click();

							 //wait till two windows are not opened

							 waitForNumberofWindowsToEqual(2);//this method is for wait

							 Set handles = driver.getWindowHandles();

							 firstWinHandle = driver.getWindowHandle(); handles.remove(firstWinHandle);

							 String winHandle=handles.iterator().next();

							 if (winHandle!=firstWinHandle){

							 //To retrieve the handle of second window, extracting the handle which does not match to first window handle

							 secondWinHandle=winHandle; //Storing handle of second window handle

							//Switch control to new window

							 driver.switchTo().window(secondWinHandle);


							  driver.findElement(By.id(“id of the link which opens new window”)).click();
							 
							 //wait till two windows are not opened
							 
							 waitForNumberofWindowsToEqual(2);//this method is for wait
							 
							 Set handles = driver.getWindowHandles();
							 
							 firstWinHandle = driver.getWindowHandle(); handles.remove(firstWinHandle);
							 
							 String winHandle=handles.iterator().next();
							 
							 if (winHandle!=firstWinHandle){
							 
							 //To retrieve the handle of second window, extracting the handle which does not match to first window handle
							 
							 secondWinHandle=winHandle; //Storing handle of second window handle
							 
							//Switch control to new window
							 
							 driver.switchTo().window(secondWinHandle);

							 

						*/	
							 
							 
							 
							

					/*		//enter client fault
							

							wait.until(ExpectedConditions.visibilityOfElementLocated(ClientFaultInputInClaimITResults));
							driver.findElement(ClientFaultInputInClaimITResults).sendKeys("D");
							System.out.println("entered client fault");
							Log.info("log4j msg- entered client fault");	
							
						*/	
			//click print button
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(PrintResultsButton));
							driver.findElement(PrintResultsButton).click();
							System.out.println("clicked print results");
							Log.info("log4j msg- clicked print results");			
			
			//click print link
			
							wait.until(ExpectedConditions.visibilityOfElementLocated(PrintLink));
							driver.findElement(PrintLink).click();
							System.out.println("clicked print claim IT Report");
							Log.info("log4j msg- clicked print claim IT Report ");		
							
							Thread.sleep(5000);
							BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
							driver.quit();
					
							}}
							}catch(Exception e){ e.printStackTrace();
		System.out.println("error in claim IT report");
		Log.info("error in claim IT Report"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		}
	}

	
	public void searchOnProviderPrintClaimITReport( String approvedServiceOnly, String openClaimsOnly, String extractClaimAndServiceData, String denyServices, String providerID, String memberID, String payor, String from, String to, String claimQuery, String insurerPayor, String checkBilaterals, String checkCCI, String checkGlobalPeriods, String checkLCPDiagnosis, String assistantSurgeon, String clientFault, String providerIDInClaimITReport, String payorInClaimITReport) throws Exception{
		
		try{ 	
			
			
			//select no for approved service only
			wait.until(ExpectedConditions.visibilityOfElementLocated(ApprovedServiceOnly)); 
	        Select ApprovedServiceSelect = new Select(driver.findElement(ApprovedServiceOnly));
	        ApprovedServiceSelect.selectByVisibleText(approvedServiceOnly);
	        System.out.println("selected Approved Service Only yes/no");
	        Log.info("log4j msg-selected Approved Service Only yes/no");
	        
	        
			//select no for open claims only
	        wait.until(ExpectedConditions.visibilityOfElementLocated(OpenClaimsOnly)); 
	        Select OpenClaimsOnlySelect = new Select(driver.findElement(OpenClaimsOnly));
	        OpenClaimsOnlySelect.selectByVisibleText(openClaimsOnly);
	        System.out.println("selected open claims Only yes/no");
	        Log.info("log4j msg-selected open claims Only yes/no");
	        
	        
			//select no for extract claim & service data
	        wait.until(ExpectedConditions.visibilityOfElementLocated(ExtractClaimAndServiceData)); 
	        Select ExtractClaimAndServiceDataSelect = new Select(driver.findElement(ExtractClaimAndServiceData));
	        ExtractClaimAndServiceDataSelect.selectByVisibleText(extractClaimAndServiceData);
	        System.out.println("selected extract claim and service data yes/no");
	        Log.info("log4j msg-selected extract claim and service data yes/no");
	        
	        
			//select no for deny services
	        wait.until(ExpectedConditions.visibilityOfElementLocated(DenyServices)); 
	        Select DenyServicesSelect = new Select(driver.findElement(DenyServices));
	        DenyServicesSelect.selectByVisibleText(denyServices);
	        System.out.println("selected deny services yes/no");
	        Log.info("log4j msg-selected deny services yes/no");
	        
			
			//provider id
			
			//member id
			
			//payor
			
			//from (date of service)
	        wait.until(ExpectedConditions.visibilityOfElementLocated(FromDateInput));
			driver.findElement(FromDateInput).sendKeys(from);
			System.out.println("entered from date");
			Log.info("log4j msg- entered from date");
			
			
			//to (date of service)
			 wait.until(ExpectedConditions.visibilityOfElementLocated(ToDateInput));
				driver.findElement(ToDateInput).sendKeys(to);
				System.out.println("entered to date");
				Log.info("log4j msg- entered to date");
			
			
			
			//claim query search
			
			//insurer/ payor query search
			
			
			//check bilaterals
			
				if (checkBilaterals.equalsIgnoreCase("yes")){
				 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckBilaterals));
					driver.findElement(CheckBilaterals).click();
					System.out.println("checked - Check Bilaterals checkbox");
					Log.info("log4j msg- checked - check bilaterals checkbox");
					
				}
				
			//check cci
				if (checkCCI.equalsIgnoreCase("yes")){
					 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckCCI));
						driver.findElement(CheckCCI).click();
						System.out.println("checked - Check CCI checkbox");
						Log.info("log4j msg- checked - check CCI checkbox");
				}		
			//check global periods
						if (checkGlobalPeriods.equalsIgnoreCase("yes")){
						 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckGlobalPeriods));
							driver.findElement(CheckGlobalPeriods).click();
							System.out.println("checked - Check Global Periods checkbox");
							Log.info("log4j msg- checked - check Global Periods checkbox");
						}
			//check lcp diagnosis
			if (checkLCPDiagnosis.equalsIgnoreCase("yes")){
							wait.until(ExpectedConditions.visibilityOfElementLocated(CheckLCPDiagnosis));
							driver.findElement(CheckLCPDiagnosis).click();
							System.out.println("checked - Check LCPD Diagnosis checkbox");
							Log.info("log4j msg- checked - check LCPD Diagnosis checkbox");
			}
			//check assistant surgeon
			if (assistantSurgeon.equalsIgnoreCase("yes")){	
			wait.until(ExpectedConditions.visibilityOfElementLocated(CheckAssistantSurgeon));
							driver.findElement(CheckAssistantSurgeon).click();
							System.out.println("checked - Check Assistant Surgeon checkbox");
							Log.info("log4j msg- checked - check Assistant Surgeon checkbox");
			}
			System.out.println(driver.getTitle());
			
			//click go
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(GoButton));
							driver.findElement(GoButton).click();
							System.out.println("clicked Go");
							Log.info("log4j msg- clicked Go");	
							
							Thread.sleep(10000);

							try{
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Internal Server Error']")));
								System.out.println("Internal Server error");
								Log.info("Internal Server Error");
								BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
								
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
								driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();		
								System.out.println("clicked ok");
								Log.info("clicked ok");
								driver.quit();
							
								
								}catch(Exception e){
								
								try{
									
									
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='No Violations andor Service Reductions were identified.']")));
									System.out.println("No Violations");
									Log.info("No Violations");
									BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
								
								
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
									driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
									System.out.println("clicked ok");
									Log.info("clicked ok");
									driver.quit();
								
								
								}catch (Exception e1){ System.out.println("continue with report");
									
							ArrayList tabs = new ArrayList<Object> (driver.getWindowHandles());
							int i = tabs.size();
							System.out.println("Tab size when clicking Go" + i);
							driver.switchTo().window((String) tabs.get(i-1));
							
							System.out.println(driver.getTitle());
							
					 
								
							
							
							//enter provider id
							wait.until(ExpectedConditions.visibilityOfElementLocated(ProviderIDInputInClaimITResults));
							driver.findElement(ProviderIDInputInClaimITResults).sendKeys(providerIDInClaimITReport);
							System.out.println("entered provider id");
							Log.info("log4j msg- entered provider id");
							
							
							//click search
							wait.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonInClaimITResults));
							driver.findElement(SearchButtonInClaimITResults).click();
							System.out.println("clicked search");
							Log.info("log4j msg- clicked search");
							
			//click print button
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(PrintResultsButton));
							driver.findElement(PrintResultsButton).click();
							System.out.println("clicked print results");
							Log.info("log4j msg- clicked print results");			
			
			//click print link
			
							wait.until(ExpectedConditions.visibilityOfElementLocated(PrintLink));
							driver.findElement(PrintLink).click();
							System.out.println("clicked print claim IT Report");
							Log.info("log4j msg- clicked print claim IT Report ");		
							
							Thread.sleep(5000);
							BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
							driver.quit();
					}}
		}
		catch(Exception e){ e.printStackTrace();
		System.out.println("error in claim IT report");
		Log.info("error in claim IT Report");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
		}
	}
	
	
	public void searchOnPayorPrintClaimITReport( String approvedServiceOnly, String openClaimsOnly, String extractClaimAndServiceData, String denyServices, String providerID, String memberID, String payor, String from, String to, String claimQuery, String insurerPayor, String checkBilaterals, String checkCCI, String checkGlobalPeriods, String checkLCPDiagnosis, String assistantSurgeon,String clientFault, String providerIDInClaimITReport, String payorInClaimITReport) throws Exception{
		
		try{ 	
			
			
			//select no for approved service only
			wait.until(ExpectedConditions.visibilityOfElementLocated(ApprovedServiceOnly)); 
	        Select ApprovedServiceSelect = new Select(driver.findElement(ApprovedServiceOnly));
	        ApprovedServiceSelect.selectByVisibleText(approvedServiceOnly);
	        System.out.println("selected Approved Service Only yes/no");
	        Log.info("log4j msg-selected Approved Service Only yes/no");
	        
	        
			//select no for open claims only
	        wait.until(ExpectedConditions.visibilityOfElementLocated(OpenClaimsOnly)); 
	        Select OpenClaimsOnlySelect = new Select(driver.findElement(OpenClaimsOnly));
	        OpenClaimsOnlySelect.selectByVisibleText(openClaimsOnly);
	        System.out.println("selected open claims Only yes/no");
	        Log.info("log4j msg-selected open claims Only yes/no");
	        
	        
			//select no for extract claim & service data
	        wait.until(ExpectedConditions.visibilityOfElementLocated(ExtractClaimAndServiceData)); 
	        Select ExtractClaimAndServiceDataSelect = new Select(driver.findElement(ExtractClaimAndServiceData));
	        ExtractClaimAndServiceDataSelect.selectByVisibleText(extractClaimAndServiceData);
	        System.out.println("selected extract claim and service data yes/no");
	        Log.info("log4j msg-selected extract claim and service data yes/no");
	        
	        
			//select no for deny services
	        wait.until(ExpectedConditions.visibilityOfElementLocated(DenyServices)); 
	        Select DenyServicesSelect = new Select(driver.findElement(DenyServices));
	        DenyServicesSelect.selectByVisibleText(denyServices);
	        System.out.println("selected deny services yes/no");
	        Log.info("log4j msg-selected deny services yes/no");
	        
			
			//provider id
			
			//member id
			
			//payor
			
			//from (date of service)
	        wait.until(ExpectedConditions.visibilityOfElementLocated(FromDateInput));
			driver.findElement(FromDateInput).sendKeys(from);
			System.out.println("entered from date");
			Log.info("log4j msg- entered from date");
			
			
			//to (date of service)
			 wait.until(ExpectedConditions.visibilityOfElementLocated(ToDateInput));
				driver.findElement(ToDateInput).sendKeys(to);
				System.out.println("entered to date");
				Log.info("log4j msg- entered to date");
			
			
			
			//claim query search
			
			//insurer/ payor query search
			
			
			//check bilaterals
			
				if (checkBilaterals.equalsIgnoreCase("yes")){
				 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckBilaterals));
					driver.findElement(CheckBilaterals).click();
					System.out.println("checked - Check Bilaterals checkbox");
					Log.info("log4j msg- checked - check bilaterals checkbox");
					
				}
				
			//check cci
				if (checkCCI.equalsIgnoreCase("yes")){
					 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckCCI));
						driver.findElement(CheckCCI).click();
						System.out.println("checked - Check CCI checkbox");
						Log.info("log4j msg- checked - check CCI checkbox");
				}		
			//check global periods
						if (checkGlobalPeriods.equalsIgnoreCase("yes")){
						 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckGlobalPeriods));
							driver.findElement(CheckGlobalPeriods).click();
							System.out.println("checked - Check Global Periods checkbox");
							Log.info("log4j msg- checked - check Global Periods checkbox");
						}
			//check lcp diagnosis
			if (checkLCPDiagnosis.equalsIgnoreCase("yes")){
							wait.until(ExpectedConditions.visibilityOfElementLocated(CheckLCPDiagnosis));
							driver.findElement(CheckLCPDiagnosis).click();
							System.out.println("checked - Check LCPD Diagnosis checkbox");
							Log.info("log4j msg- checked - check LCPD Diagnosis checkbox");
			}
			//check assistant surgeon
			if (assistantSurgeon.equalsIgnoreCase("yes")){	
			wait.until(ExpectedConditions.visibilityOfElementLocated(CheckAssistantSurgeon));
							driver.findElement(CheckAssistantSurgeon).click();
							System.out.println("checked - Check Assistant Surgeon checkbox");
							Log.info("log4j msg- checked - check Assistant Surgeon checkbox");
			}
			System.out.println(driver.getTitle());
			
			//click go
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(GoButton));
							driver.findElement(GoButton).click();
							System.out.println("clicked Go");
							Log.info("log4j msg- clicked Go");	
							
							Thread.sleep(10000);
							

							try{
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Internal Server Error']")));
								System.out.println("Internal Server error");
								Log.info("Internal Server Error");
								BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
								
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
								driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();		
								System.out.println("clicked ok");
								Log.info("clicked ok");
								driver.quit();
							
								
								}catch(Exception e){
								
								try{
									
									
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='No Violations andor Service Reductions were identified.']")));
									System.out.println("No Violations");
									Log.info("No Violations");
									BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
								
								
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
									driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
									System.out.println("clicked ok");
									Log.info("clicked ok");
									driver.quit();
								
								
								}catch (Exception e1){ System.out.println("continue with report");
									
							ArrayList tabs = new ArrayList<Object> (driver.getWindowHandles());
							int i = tabs.size();
							System.out.println("Tab size when clicking Go" + i);
							driver.switchTo().window((String) tabs.get(i-1));
							
							System.out.println(driver.getTitle());
							
					 
								
							
							
							//enter payor
							wait.until(ExpectedConditions.visibilityOfElementLocated(PayorInputInClaimsITResults));
							driver.findElement(PayorInputInClaimsITResults).sendKeys(payorInClaimITReport);
							System.out.println("entered payor");
							Log.info("log4j msg- entered payor");
							
							
							//click search
							wait.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonInClaimITResults));
							driver.findElement(SearchButtonInClaimITResults).click();
							System.out.println("clicked search");
							Log.info("log4j msg- clicked search");
							
			//click print button
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(PrintResultsButton));
							driver.findElement(PrintResultsButton).click();
							System.out.println("clicked print results");
							Log.info("log4j msg- clicked print results");			
			
			//click print link
			
							wait.until(ExpectedConditions.visibilityOfElementLocated(PrintLink));
							driver.findElement(PrintLink).click();
							System.out.println("clicked print claim IT Report");
							Log.info("log4j msg- clicked print claim IT Report ");		
							
							Thread.sleep(5000);
							BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
							driver.quit();
		}}
		}catch(Exception e){ e.printStackTrace();
		System.out.println("error in claim IT report");
		Log.info("error in claim IT Report"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	
		}
	}
	
	public void searchOnFaultPrintClaimITReport( String approvedServiceOnly, String openClaimsOnly, String extractClaimAndServiceData, String denyServices, String providerID, String memberID, String payor, String from, String to, String claimQuery, String insurerPayor, String checkBilaterals, String checkCCI, String checkGlobalPeriods, String checkLCPDiagnosis, String assistantSurgeon,String clientFault, String providerIDInClaimITReport, String payorInClaimITReport) throws Exception{
		
		try{ 	
			
			
			//select no for approved service only
			wait.until(ExpectedConditions.visibilityOfElementLocated(ApprovedServiceOnly)); 
	        Select ApprovedServiceSelect = new Select(driver.findElement(ApprovedServiceOnly));
	        ApprovedServiceSelect.selectByVisibleText(approvedServiceOnly);
	        System.out.println("selected Approved Service Only yes/no");
	        Log.info("log4j msg-selected Approved Service Only yes/no");
	        
	        
			//select no for open claims only
	        wait.until(ExpectedConditions.visibilityOfElementLocated(OpenClaimsOnly)); 
	        Select OpenClaimsOnlySelect = new Select(driver.findElement(OpenClaimsOnly));
	        OpenClaimsOnlySelect.selectByVisibleText(openClaimsOnly);
	        System.out.println("selected open claims Only yes/no");
	        Log.info("log4j msg-selected open claims Only yes/no");
	        
	        
			//select no for extract claim & service data
	        wait.until(ExpectedConditions.visibilityOfElementLocated(ExtractClaimAndServiceData)); 
	        Select ExtractClaimAndServiceDataSelect = new Select(driver.findElement(ExtractClaimAndServiceData));
	        ExtractClaimAndServiceDataSelect.selectByVisibleText(extractClaimAndServiceData);
	        System.out.println("selected extract claim and service data yes/no");
	        Log.info("log4j msg-selected extract claim and service data yes/no");
	        
	        
			//select no for deny services
	        wait.until(ExpectedConditions.visibilityOfElementLocated(DenyServices)); 
	        Select DenyServicesSelect = new Select(driver.findElement(DenyServices));
	        DenyServicesSelect.selectByVisibleText(denyServices);
	        System.out.println("selected deny services yes/no");
	        Log.info("log4j msg-selected deny services yes/no");
	        
			
			//provider id
			
			//member id
			
			//payor
			
			//from (date of service)
	        wait.until(ExpectedConditions.visibilityOfElementLocated(FromDateInput));
			driver.findElement(FromDateInput).sendKeys(from);
			System.out.println("entered from date");
			Log.info("log4j msg- entered from date");
			
			
			//to (date of service)
			 wait.until(ExpectedConditions.visibilityOfElementLocated(ToDateInput));
				driver.findElement(ToDateInput).sendKeys(to);
				System.out.println("entered to date");
				Log.info("log4j msg- entered to date");
			
			
			
			//claim query search
			
			//insurer/ payor query search
			
			
			//check bilaterals
			
				if (checkBilaterals.equalsIgnoreCase("yes")){
				 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckBilaterals));
					driver.findElement(CheckBilaterals).click();
					System.out.println("checked - Check Bilaterals checkbox");
					Log.info("log4j msg- checked - check bilaterals checkbox");
					
				}
				
			//check cci
				if (checkCCI.equalsIgnoreCase("yes")){
					 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckCCI));
						driver.findElement(CheckCCI).click();
						System.out.println("checked - Check CCI checkbox");
						Log.info("log4j msg- checked - check CCI checkbox");
				}		
			//check global periods
						if (checkGlobalPeriods.equalsIgnoreCase("yes")){
						 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckGlobalPeriods));
							driver.findElement(CheckGlobalPeriods).click();
							System.out.println("checked - Check Global Periods checkbox");
							Log.info("log4j msg- checked - check Global Periods checkbox");
						}
			//check lcp diagnosis
			if (checkLCPDiagnosis.equalsIgnoreCase("yes")){
							wait.until(ExpectedConditions.visibilityOfElementLocated(CheckLCPDiagnosis));
							driver.findElement(CheckLCPDiagnosis).click();
							System.out.println("checked - Check LCPD Diagnosis checkbox");
							Log.info("log4j msg- checked - check LCPD Diagnosis checkbox");
			}
			//check assistant surgeon
			if (assistantSurgeon.equalsIgnoreCase("yes")){	
			wait.until(ExpectedConditions.visibilityOfElementLocated(CheckAssistantSurgeon));
							driver.findElement(CheckAssistantSurgeon).click();
							System.out.println("checked - Check Assistant Surgeon checkbox");
							Log.info("log4j msg- checked - check Assistant Surgeon checkbox");
			}
			System.out.println(driver.getTitle());
			
			//click go
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(GoButton));
							driver.findElement(GoButton).click();
							System.out.println("clicked Go");
							Log.info("log4j msg- clicked Go");	
							
							Thread.sleep(10000);
							
							
							
							try{
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Internal Server Error']")));
								System.out.println("Internal Server error");
								Log.info("Internal Server Error");
								BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
								
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
								driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();		
								System.out.println("clicked ok");
								Log.info("clicked ok");
								driver.quit();
							
								
								}catch(Exception e){
								
								try{
									
									
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='No Violations andor Service Reductions were identified.']")));
									System.out.println("No Violations");
									Log.info("No Violations");
									BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
								
								
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
									driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
									System.out.println("clicked ok");
									Log.info("clicked ok");
									driver.quit();
								
								
								}catch (Exception e1){ System.out.println("continue with report");
									
							ArrayList tabs = new ArrayList<Object> (driver.getWindowHandles());
							int i = tabs.size();
							System.out.println("Tab size when clicking Go" + i);
							driver.switchTo().window((String) tabs.get(i-1));
							
							System.out.println(driver.getTitle());
							
					 
								
							
							
							//enter client fault
							wait.until(ExpectedConditions.visibilityOfElementLocated(ClientFaultInputInClaimITResults));
							driver.findElement(ClientFaultInputInClaimITResults).sendKeys(clientFault);
							System.out.println("entered client fault");
							Log.info("log4j msg- entered client fault");
							
							
							//click search
							wait.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonInClaimITResults));
							driver.findElement(SearchButtonInClaimITResults).click();
							System.out.println("clicked search");
							Log.info("log4j msg- clicked search");
							
			//click print button
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(PrintResultsButton));
							driver.findElement(PrintResultsButton).click();
							System.out.println("clicked print results");
							Log.info("log4j msg- clicked print results");			
			
			//click print link
			
							wait.until(ExpectedConditions.visibilityOfElementLocated(PrintLink));
							driver.findElement(PrintLink).click();
							System.out.println("clicked print claim IT Report");
							Log.info("log4j msg- clicked print claim IT Report ");		
							
							Thread.sleep(5000);
							BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
							driver.quit();
		}} 
		}catch(Exception e){ e.printStackTrace();
			System.out.println("error in claim IT report");
			Log.info("error in claim IT Report"); 
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			driver.quit();
			
			}
		
	}
	
	public void searchOnClaimQueryPrintClaimITReport( String approvedServiceOnly, String openClaimsOnly, String extractClaimAndServiceData, String denyServices, String providerID, String memberID, String payor, String from, String to, String claimQuery, String insurerPayor, String checkBilaterals, String checkCCI, String checkGlobalPeriods, String checkLCPDiagnosis, String assistantSurgeon) throws Exception{
		
		try{ 	
			
			
			//select no for approved service only
			wait.until(ExpectedConditions.visibilityOfElementLocated(ApprovedServiceOnly)); 
	        Select ApprovedServiceSelect = new Select(driver.findElement(ApprovedServiceOnly));
	        ApprovedServiceSelect.selectByVisibleText(approvedServiceOnly);
	        System.out.println("selected Approved Service Only yes/no");
	        Log.info("log4j msg-selected Approved Service Only yes/no");
	        
	        
			//select no for open claims only
	        wait.until(ExpectedConditions.visibilityOfElementLocated(OpenClaimsOnly)); 
	        Select OpenClaimsOnlySelect = new Select(driver.findElement(OpenClaimsOnly));
	        OpenClaimsOnlySelect.selectByVisibleText(openClaimsOnly);
	        System.out.println("selected open claims Only yes/no");
	        Log.info("log4j msg-selected open claims Only yes/no");
	        
	        
			//select no for extract claim & service data
	        wait.until(ExpectedConditions.visibilityOfElementLocated(ExtractClaimAndServiceData)); 
	        Select ExtractClaimAndServiceDataSelect = new Select(driver.findElement(ExtractClaimAndServiceData));
	        ExtractClaimAndServiceDataSelect.selectByVisibleText(extractClaimAndServiceData);
	        System.out.println("selected extract claim and service data yes/no");
	        Log.info("log4j msg-selected extract claim and service data yes/no");
	        
	        
			//select no for deny services
	        wait.until(ExpectedConditions.visibilityOfElementLocated(DenyServices)); 
	        Select DenyServicesSelect = new Select(driver.findElement(DenyServices));
	        DenyServicesSelect.selectByVisibleText(denyServices);
	        System.out.println("selected deny services yes/no");
	        Log.info("log4j msg-selected deny services yes/no");
	        
			
			//provider id
			
			//member id
			
			//payor
			
			//from (date of service)
	        wait.until(ExpectedConditions.visibilityOfElementLocated(FromDateInput));
			driver.findElement(FromDateInput).sendKeys(from);
			System.out.println("entered from date");
			Log.info("log4j msg- entered from date");
			
			
			//to (date of service)
			 wait.until(ExpectedConditions.visibilityOfElementLocated(ToDateInput));
				driver.findElement(ToDateInput).sendKeys(to);
				System.out.println("entered to date");
				Log.info("log4j msg- entered to date");
			
			
			
			//claim query search
			
				 wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimQuerySearchButton));
					driver.findElement(ClaimQuerySearchButton).click();
					System.out.println("clicked claim query search");
					Log.info("log4j msg- claim query search");
				
					

					//enter query
					wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameDescriptionBeginsInput));
					driver.findElement(QueryNameDescriptionBeginsInput).clear();
					driver.findElement(QueryNameDescriptionBeginsInput).sendKeys(claimQuery);
					System.out.println("entered claim query");
					Log.info("log4j msg- entered claim query");
					
					
					//click search
					wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearchButton));
					driver.findElement(QuerySearchButton).click();
					System.out.println("clicked search");
					Log.info("log4j msg- clicked search");
					
				//click return selection
				
					wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
					driver.findElement(ReturnSelectionLink).click();
					System.out.println("clicked return selection");
					Log.info("log4j msg- clicked return selection");
				
				
			//insurer/ payor query search
			
			Thread.sleep(3000);
			
			
			 try{wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
				driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
				System.out.println("clicked ok");
				Log.info("clicked ok");
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit();
				
				
				}catch(Exception e){
			
			//check bilaterals
			
				if (checkBilaterals.equalsIgnoreCase("yes")){
				 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckBilaterals));
					driver.findElement(CheckBilaterals).click();
					System.out.println("checked - Check Bilaterals checkbox");
					Log.info("log4j msg- checked - check bilaterals checkbox");
					
				}
				
			//check cci
				if (checkCCI.equalsIgnoreCase("yes")){
					 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckCCI));
						driver.findElement(CheckCCI).click();
						System.out.println("checked - Check CCI checkbox");
						Log.info("log4j msg- checked - check CCI checkbox");
				}		
			//check global periods
						if (checkGlobalPeriods.equalsIgnoreCase("yes")){
						 wait.until(ExpectedConditions.visibilityOfElementLocated(CheckGlobalPeriods));
							driver.findElement(CheckGlobalPeriods).click();
							System.out.println("checked - Check Global Periods checkbox");
							Log.info("log4j msg- checked - check Global Periods checkbox");
						}
			//check lcp diagnosis
			if (checkLCPDiagnosis.equalsIgnoreCase("yes")){
							wait.until(ExpectedConditions.visibilityOfElementLocated(CheckLCPDiagnosis));
							driver.findElement(CheckLCPDiagnosis).click();
							System.out.println("checked - Check LCPD Diagnosis checkbox");
							Log.info("log4j msg- checked - check LCPD Diagnosis checkbox");
			}
			//check assistant surgeon
			if (assistantSurgeon.equalsIgnoreCase("yes")){	
			wait.until(ExpectedConditions.visibilityOfElementLocated(CheckAssistantSurgeon));
							driver.findElement(CheckAssistantSurgeon).click();
							System.out.println("checked - Check Assistant Surgeon checkbox");
							Log.info("log4j msg- checked - check Assistant Surgeon checkbox");
			}
			System.out.println(driver.getTitle());
			
			//click go
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(GoButton));
							driver.findElement(GoButton).click();
							System.out.println("clicked Go");
							Log.info("log4j msg- clicked Go");	
							
							Thread.sleep(10000);
							
							
							
							try{
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[text()='Internal Server Error']")));
								System.out.println("Internal Server error");
								Log.info("Internal Server Error");
								BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
								
								wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
								driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();		
								System.out.println("clicked ok");
								Log.info("clicked ok");
								driver.quit();
							
								
								}catch(Exception e2){
								
								try{
									
									
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='No Violations andor Service Reductions were identified.']")));
									System.out.println("No Violations");
									Log.info("No Violations");
									BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
								
								
									wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")));
									driver.findElement(By.xpath("//button[@data-bb-handler='Success' and text()='OK']")).click();
									System.out.println("clicked ok");
									Log.info("clicked ok");
									driver.quit();
								
								
								}catch (Exception e1){ System.out.println("continue with report");
									
							try{	ArrayList tabs = new ArrayList<Object> (driver.getWindowHandles());
								int i = tabs.size();
								System.out.println("Tab size when clicking Go" + i);
								driver.switchTo().window((String) tabs.get(i-1));
								
								System.out.println(driver.getTitle());
								
							//enter payor
							wait.until(ExpectedConditions.visibilityOfElementLocated(PayorInputInClaimsITResults));
							driver.findElement(PayorInputInClaimsITResults).sendKeys(payor);
							System.out.println("entered payor");
							Log.info("log4j msg- entered payor");
							
							
							//click search
							wait.until(ExpectedConditions.visibilityOfElementLocated(SearchButtonInClaimITResults));
							driver.findElement(SearchButtonInClaimITResults).click();
							System.out.println("clicked search");
							Log.info("log4j msg- clicked search");
							
			//click print button
							
							wait.until(ExpectedConditions.visibilityOfElementLocated(PrintResultsButton));
							driver.findElement(PrintResultsButton).click();
							System.out.println("clicked print results");
							Log.info("log4j msg- clicked print results");			
			
			//click print link
			
							Thread.sleep(2000);
							wait.until(ExpectedConditions.visibilityOfElementLocated(PrintLink));
							driver.findElement(PrintLink).click();
							System.out.println("clicked print claim IT Report");
							Log.info("log4j msg- clicked print claim IT Report ");		
							
							Thread.sleep(5000);
							BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
							driver.quit();
					
								} catch(Exception e3){e3.printStackTrace();
							System.out.println("error in getting results"); 
							Log.info("error in getting results");}
							}}
		
		}}catch(Exception e){ e.printStackTrace();
		System.out.println("error in claim IT report");
		Log.info("error in claim IT Report"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
	
		}
	}
		
	
	
	
	
	
}
