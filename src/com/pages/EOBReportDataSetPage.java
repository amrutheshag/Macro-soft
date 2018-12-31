package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class EOBReportDataSetPage {
	
	WebDriver driver;
	WebDriverWait wait;

	By NameInput= By.xpath("//input[@data-ng-model='currentRecord.name']");
	
	By UnloggedClaimsOnly = By.xpath("//select[@data-ng-model='currentRecord.unloggedClaim']");
			
	By LogClaimPaymentOrReportingDate = By.xpath("//input[@data-ng-model='currentRecord.logDate']");
	
	By FirstCheckNumber = By.xpath("//input[@data-ng-model= 'currentRecord.firstCheck']");
	
	By BreakChecksOn = By.xpath("//select[@data-ng-model='currentRecord.breakCheck']");
	
	By CheckStubMemo = By.xpath("//input[@data-ng-model='currentRecord.checkMemo']");
	
	By DenyServices = By.xpath("//select[@data-ng-model='currentRecord.allowDenialOfServices']");
	
	By ClaimClearButton =  By.xpath("//button[@class='btn btn-primary clear-bg'][1]");
	
	By MemberPatientClearButton = By.xpath("//button[@class='btn btn-primary clear-bg'][2]");
	
	By ProviderClearButton =  By.xpath("/button[@class='btn btn-primary clear-bg'][3]");
	
	By ClaimServiceClearButton = By.xpath("/button[@class='btn btn-primary clear-bg'][4]");
	
	By InsurerPayerClearButton =  By.xpath("/button[@class='btn btn-primary clear-bg'][5]");
	
	By ClaimQuerySearchButton = By.xpath("(//button[@class='btn btn-primary'])[1]");
			
	By MemberPatientQuerySearchButton =   By.xpath("(//button[@class='btn btn-primary'])[2]");
	
	By ProviderQuerySearchButton =   By.xpath("(//button[@class='btn btn-primary'])[3]");
	
	//By ClaimServiceQuerySearchButton =   By.xpath("(//button[@class='btn btn-primary'])[4]");
	By ClaimServiceQuerySearchButton =   By.xpath("(//button[@class='btn btn-primary'])[1]");
	
	//By ClaimServiceQuerySearchButton =   By.xpath("id('ExplanationBenefitsDefinition')/div[@class='col-sm-12 col-md-12 col-lg-12 general-info batch-defination no-padding']/div[@class='col-sm-12 col-md-21 col-lg-12 grid-contr no-padding']/div[@class='table-responsive']/table[@class='table table-bordered table-hover']/tbody[1]/tr[4]/td[4]/button[@class='btn btn-primary']");
	
	By InsurerPayerQuerySearchButton =   By.xpath("(//button[@class='btn btn-primary'])[5]");
	//By InsurerPayerQuerySearchButton = By.xpath("id('ExplanationBenefitsDefinition')/div[@class='col-sm-12 col-md-12 col-lg-12 general-info batch-defination no-padding']/div[@class='col-sm-12 col-md-21 col-lg-12 grid-contr no-padding']/div[@class='table-responsive']/table[@class='table table-bordered table-hover']/tbody[1]/tr[5]/td[4]/button[@class='btn btn-primary']");
	
	By ScrubClaimsDataGo = By.xpath("(//button[@class='btn btn-primary go'])[1]");
	
	By ExtractClaimsDataGo = By.xpath("(//button[@class='btn btn-primary go'])[2]");
	
	By LogClaimsAsPaidLogChecksToLedgerGo = By.xpath("(//button[@class='btn btn-primary go'])[3]");
	
	By LogWithholdAsPaidLogChecksToLedgerGo =  By.xpath("(//button[@class='btn btn-primary go'])[4]");
	
	By ApportionGlobalFundToListedRecordGo =  By.xpath("(//button[@class='btn btn-primary go'])[5]");
	
	By ApportionGlobalFundANDCopaysToListedRecordsGo = By.xpath("(//button[@class='btn btn-primary go'])[6]");
	
	By LogAllowedAmountBackToOriginalClaimsGo = By.xpath("(//button[@class='btn btn-primary go'])[7]");
	
	By SaveBatchButton = By.xpath("//button[@ng-click='saveBatch()']");
	
	By NewBatchButton = By.xpath("//button[@ng-click='fn_NewBatch()']");
	
	By DropDataButton = By.xpath("//button[@ng-click='fn_DropData('drop')']");
	
	By ExitButton = By.xpath("//button[@ng-click='fn_Exit()']");
	
	By ShowDataButton = By.xpath("//button[@ng-click='reDisplay()']");
	
	By QueryNameInput = By.xpath("//input[@id='txtSearchCode']");
	 
	By QuerySearch = By.xpath("//button[@data-ng-click='search()']");
	
	By ReturnSelectionLink = By.linkText("Return Selection");
	
	By EditLink = By.linkText("Edit");
	
	By SaveLink = By.linkText("Save");
	
	By EditQueryName = By.xpath("//input[@id='name']");
	
	By YesButton = By.xpath("//button[text()='Yes']");
	
	By OKButton= By.xpath("(//button[text()='OK'])[3]");
	
	By PrintLink = By.linkText("Print");
	
	By CloseTotals = By.xpath("(//button[@data-ng-click='closeTotal()'])[2]");
	
	//By CloseReport = By.xpath("id('ExplanationBenefitReportPop01')/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='inner-window']/div[@class='inner-head']/button[@class='close']");
		
	//By CloseReport = By.xpath("//button[@type='button' and @class='close' and  @data-dismiss='modal' and @aria-hidden='true' and  @data-ng-click='closeMe()']");
	By CloseReport = By.xpath("(//button[text()='×'])[1]");
	
	public EOBReportDataSetPage(WebDriver driver){
		this.driver= driver;
		this.wait = new WebDriverWait(driver, 100);
	}

	//Edits the claim query in EOB Report screen
	
	public void editClaimQuery( String newQuery, String newName)throws Exception{
		try{ 	
			
		
			//click search
			wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimQuerySearchButton));
			driver.findElement(ClaimQuerySearchButton).click();
			System.out.println("Clicked search");
			Log.info("log4j msg- clicked search");
			
			
				
			Thread.sleep(10000);
			
			//enter Query name input
			wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
			driver.findElement(QueryNameInput).sendKeys(newQuery);
			System.out.println("entered query name");
			Log.info("log4j msg- entered query name");
			
			//click search
			wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearch));
			driver.findElement(QuerySearch).click();
			System.out.println("clicked search query");
			Log.info("log4j msg- clicked search query");
			
			//click edit
			wait.until(ExpectedConditions.visibilityOfElementLocated(EditLink));
			driver.findElement(EditLink).click();
			System.out.println("clicked edit");
			Log.info("log4j msg- clicked edit");
		
			//edit query
			wait.until(ExpectedConditions.visibilityOfElementLocated(EditQueryName));
			driver.findElement(EditQueryName).clear();
			
			driver.findElement(EditQueryName).sendKeys(newName);
			System.out.println("entered new name");
			Log.info("log4j msg- entered new name");
		
			
			
			//click save
			wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
			driver.findElement(SaveLink).click();
			System.out.println("clicked save");
			Log.info("log4j msg- clicked save");
			
			//click return selection
			wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
			driver.findElement(ReturnSelectionLink).click();
			System.out.println("clicked return selection");
			Log.info("log4j msg- clicked return selection");
			
			
					
					
			BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
			
			exitEOBReport();
			
			driver.quit();
		
			
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("error in editing Query"); 
				Log.info("error in editing Query"); 
				BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
				driver.quit(); 
				
			}
	}



//Edits claim service query
	
public void editClaimsServiceQuery( String newQuery, String newName)throws Exception{
	try{ 	
		
	
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimServiceQuerySearchButton));
		driver.findElement(ClaimServiceQuerySearchButton).click();
		System.out.println("Clicked search");
		Log.info("log4j msg- clicked search");
		
		
			
		Thread.sleep(10000);
		
		//enter Query name input
		wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
		driver.findElement(QueryNameInput).sendKeys(newQuery);
		System.out.println("entered query name");
		Log.info("log4j msg- entered query name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearch));
		driver.findElement(QuerySearch).click();
		System.out.println("clicked search query");
		Log.info("log4j msg- clicked search query");
		
		//click edit
		wait.until(ExpectedConditions.visibilityOfElementLocated(EditLink));
		driver.findElement(EditLink).click();
		System.out.println("clicked edit");
		Log.info("log4j msg- clicked edit");
	
		//edit query
		wait.until(ExpectedConditions.visibilityOfElementLocated(EditQueryName));
		driver.findElement(EditQueryName).sendKeys(newName);
		System.out.println("entered new name");
		Log.info("log4j msg- entered new name");
	
		
		
		//click save
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
		driver.findElement(SaveLink).click();
		System.out.println("clicked save");
		Log.info("log4j msg- clicked save");
		
		//click return selection
				wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
				driver.findElement(ReturnSelectionLink).click();
				System.out.println("clicked return selection");
				Log.info("log4j msg- clicked return selection");
		
		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		exitEOBReport();
		driver.quit();
		}catch(Exception e)
	{e.printStackTrace();
	System.out.println("error in editing Query"); 
	Log.info("error in editing query");
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit(); 
	}
}



public void extractClaimsData( String claimQuery, String memberQuery, String providerQuery,  String claimServiceQuery, String insurerPayerQuery) throws Exception
{
	try{ 	
		

		
	/*	
		//click claim query  search
				wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimQuerySearchButton));
				driver.findElement(ClaimQuerySearchButton).click();
				System.out.println("Clicked search");
				Log.info("log4j msg- clicked search");
				
				
					
				Thread.sleep(10000);
				
				//enter Query name input
				wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
				driver.findElement(QueryNameInput).sendKeys(claimQuery);
				System.out.println("entered query name");
				Log.info("log4j msg- entered query name");
				
				//click search
				wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearch));
				driver.findElement(QuerySearch).click();
				System.out.println("clicked search query");
				Log.info("log4j msg- clicked search query");
				
				
				
				//click return selection
						wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
						driver.findElement(ReturnSelectionLink).click();
						System.out.println("clicked return selection");
						Log.info("log4j msg- clicked return selection");
		
						
			*/
		
		
		
		
		
		
		
		
		
		/* 10/19/2018 11.47 am/  */
						WebElement element1=driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.checkMemo']"));
						//Actions builder = new Actions(driver); 
						element1.sendKeys(Keys.PAGE_DOWN);
						//builder.dragAndDropBy(element1, 0,-300).build().perform();
						System.out.println("Page down");
						Log.info("log4j msg- Page down");
						Thread.sleep(2000);
	
		
		
		
						//claim service search
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimServiceQuerySearchButton));
						driver.findElement(ClaimServiceQuerySearchButton).click();
						System.out.println("Clicked search");
						Log.info("log4j msg- clicked search");
						
						
							
						Thread.sleep(10000);
						
						//enter Query name input
						wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
						driver.findElement(QueryNameInput).sendKeys(claimServiceQuery);
						System.out.println("entered query name");
						Log.info("log4j msg- entered query name");
						
						//click search
						wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearch));
						driver.findElement(QuerySearch).click();
						System.out.println("clicked search query");
						Log.info("log4j msg- clicked search query");
						Thread.sleep(4000);
						
						
						//click return selection
								wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
								driver.findElement(ReturnSelectionLink).click();
								System.out.println("clicked return selection");
								Log.info("log4j msg- clicked return selection");
						
						
						
						Thread.sleep(2000);
						
							//click payer/insurer  search
						wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerQuerySearchButton));
						driver.findElement(InsurerPayerQuerySearchButton).click();
						System.out.println("Clicked  insurer/payer query search");
						Log.info("log4j msg- clicked insurer/ payer query search");
						
						
							
						Thread.sleep(10000);
						
						//enter Query name input
						wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
						driver.findElement(QueryNameInput).sendKeys(insurerPayerQuery);
						System.out.println("entered insurer payer query name");
						Log.info("log4j msg- entered insurer payer query name");
						
						//click search
						wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearch));
						driver.findElement(QuerySearch).click();
						System.out.println("clicked search query");
						Log.info("log4j msg- clicked search query");
						
						Thread.sleep(5000);
						
						//click return selection
								wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
								driver.findElement(ReturnSelectionLink).click();
								System.out.println("clicked return selection");
								Log.info("log4j msg- clicked return selection");
						
							
		//click go- extract claims data
		
						wait.until(ExpectedConditions.visibilityOfElementLocated(ExtractClaimsDataGo));
						driver.findElement(ExtractClaimsDataGo).click();
						System.out.println("clicked Go- Extract claims data");
						Log.info("log4j msg- clicked Go- Extract claims data");
						
						
						Thread.sleep(20000);
						
						
						/*
						JavascriptExecutor executor = (JavascriptExecutor)driver;
						executor.executeScript("document.body.style.zoom = '0.67'");
						*/
						/*
						//click on contents
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Payee ID']")));
						driver.findElement(By.xpath("//span[text()='Payee ID']")).click();	
							
						Thread.sleep(2000);
						//close report	
						wait.until(ExpectedConditions.visibilityOfElementLocated(CloseReport));
						driver.findElement(CloseReport).click();
						*/
						/*Actions  action = new Actions(driver);
							WebElement el = driver.findElement(CloseReport);
									action.click(el).perform();*/
								//System.out.println("clicked close report");
							//Log.info("log4j msg- clicked close report");	
							
							
						//click totals
						//click close totals
							//click close
						//click exit
	/*					
		try{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
		driver.findElement(SaveLink).click();
		System.out.println("clicked Save");
		Log.info("log4j msg- clicked Save");
		try{
		//close totals
		wait.until(ExpectedConditions.visibilityOfElementLocated(CloseTotals));
		driver.findElement(CloseTotals).click();
		System.out.println("clicked close totals");
		Log.info("log4j msg- clicked close totals");

		}catch(Exception e){System.out.println("Error in clicking close totals");
		Log.info("log4j msg- Error in clicking close totals");}
					Thread.sleep(2000);
	*/			
				/*WebElement html = driver.findElement(By.tagName("html"));
				html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
*/
				
				//JavascriptExecutor executor = (JavascriptExecutor)driver;
				//executor.executeScript("document.body.style.zoom = '0.75'");
				
				//Thread.sleep(1000);
				
	/*		//close report	
			wait.until(ExpectedConditions.visibilityOfElementLocated(CloseReport));
						
				//driver.findElement(CloseReport).click();
				Actions  action = new Actions(driver);
				WebElement el = driver.findElement(CloseReport);
						action.click(el).perform();
				System.out.println("clicked close report");
				Log.info("log4j msg- clicked close report");	
		*/	
				
				/*
				 ArrayList tabs = new ArrayList (driver.getWindowHandles());
				System.out.println("Tab size when clicking Go" + tabs.size());
					driver.switchTo().window((String) tabs.get(0));
				*/	
		/*		
				System.out.println(driver.getTitle());
				
				// It will return the parent window name as a String
				String parent=driver.getWindowHandle();
				 System.out.println(parent);
				// This will return the number of windows opened by Webdriver and will return Set of St//rings
				Set<String>s1=driver.getWindowHandles();
				 System.out.println(s1);
				 
				// Now we will iterate using Iterator
				Iterator<String> I1= s1.iterator();
				 
				while(I1.hasNext())
				{
				 
				   String child_window=I1.next();
				 System.out.println(driver.getTitle());
				 
				// Here we will compare if parent window is not equal to child window then we            will close
				 
				if(!parent.equals(child_window))
				{
				driver.switchTo().window(child_window);
				 
				System.out.println(driver.switchTo().window(child_window).getTitle());
				 
				driver.close();
				}
				 
				}
				// once all pop up closed now switch to parent window
				driver.switchTo().window(parent);
				System.out.println("switched to parent window");
				
			*/
	//	}catch(Exception e){ System.out.println("Error in clicking Save");
	//	Log.info("log4j msg- Error in clicking Save");
		

		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		//exitEOBReport(driver);
		driver.quit();
		
		
	} catch(Exception e){
		e.printStackTrace();System.out.println("error in extract claims data Report"); 
		Log.info("error in extract claims data Report"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit(); 
	
	}
	
	
}









public void extractClaimsDataFLCloseout( String claimQuery, String memberQuery, String providerQuery,  String claimServiceQuery, String insurerPayerQuery) throws Exception
{
	try{ 	
	
			WebElement element1=driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.checkMemo']"));
						//Actions builder = new Actions(driver); 
						element1.sendKeys(Keys.PAGE_DOWN);
						System.out.println("moved to another position");
						Log.info("log4j msg-clicked and pulled the window up to be able to see the other queries");
						Thread.sleep(2000);
						
						//claim service search
						
						wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimServiceQuerySearchButton));
						driver.findElement(ClaimServiceQuerySearchButton).click();
						System.out.println("Clicked search");
						Log.info("log4j msg- clicked search");
						Thread.sleep(10000);
						
						//enter Query name input
						wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
						driver.findElement(QueryNameInput).sendKeys(claimServiceQuery);
						System.out.println("entered query name");
						Log.info("log4j msg- entered query name");
						
						//click search
						wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearch));
						driver.findElement(QuerySearch).click();
						System.out.println("clicked search query");
						Log.info("log4j msg- clicked search query");
						Thread.sleep(3000);
						//click return selection
								wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
								driver.findElement(ReturnSelectionLink).click();
								System.out.println("clicked return selection");
								Log.info("log4j msg- clicked return selection");
						Thread.sleep(2000);
						
							//click payer/insurer  search
						wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerQuerySearchButton));
						driver.findElement(InsurerPayerQuerySearchButton).click();
						System.out.println("Clicked  insurer/payer query search");
						Log.info("log4j msg- clicked insurer/ payer query search");
						
						Thread.sleep(10000);
						
						//enter Query name input
						wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
						driver.findElement(QueryNameInput).sendKeys(insurerPayerQuery);
						System.out.println("entered insurer payer query name");
						Log.info("log4j msg- entered insurer payer query name");
						
						//click search
						wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearch));
						driver.findElement(QuerySearch).click();
						System.out.println("clicked search query");
						Log.info("log4j msg- clicked search query");
						
						//click return selection
								wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
								driver.findElement(ReturnSelectionLink).click();
								System.out.println("clicked return selection");
								Log.info("log4j msg- clicked return selection");
							
		//click go- extract claims data
		
						wait.until(ExpectedConditions.visibilityOfElementLocated(ExtractClaimsDataGo));
						driver.findElement(ExtractClaimsDataGo).click();
						System.out.println("clicked Go- Extract claims data");
						Log.info("log4j msg- clicked Go- Extract claims data");
			
		try{
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
			driver.findElement(SaveLink).click();
			System.out.println("clicked Save");
			Log.info("log4j msg- clicked Save");
		}catch(Exception e){
			System.out.println("Error in clicking Save");
			Log.info("log4j msg- Error in clicking Save");
		}
		
		try{
		//close totals
		wait.until(ExpectedConditions.visibilityOfElementLocated(CloseTotals));
		driver.findElement(CloseTotals).click();
		System.out.println("clicked close totals");
		Log.info("log4j msg- clicked close totals");

		}catch(Exception e){System.out.println("Error in clicking close totals");
		Log.info("log4j msg- Error in clicking close totals");}
				
				
		Thread.sleep(2000);
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		exitEOBReport();
		driver.quit();
		
	} catch(Exception e){
		e.printStackTrace();
		System.out.println("error in extract claims data Report"); 
		Log.info("error in extract claims data Report"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit(); 
	
	}
	
}




public void logClaimsAsPaid( String claimQuery, String memberQuery, String providerQuery,  String claimServiceQuery, String insurerPayerQuery) throws Exception
{
	
	try{ 	
	
		
	/*	
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.body.style.zoom = '0.75'"); */
		
	/*	WebElement element1=driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.checkMemo']"));
		Actions builder = new Actions(driver); 
		element1.sendKeys(Keys.PAGE_DOWN);
		//builder.dragAndDropBy(element1, 0,-300).build().perform();
		System.out.println("page down");
		Log.info("log4j msg-page down");
		Thread.sleep(2000);
	*/	
		
		
		
		WebElement element1=driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.checkMemo']"));
		//Actions builder = new Actions(driver); 
		element1.sendKeys(Keys.PAGE_DOWN);
		//builder.dragAndDropBy(element1, 0,-300).build().perform();
		System.out.println("moved to another position");
		Log.info("log4j msg-clicked and pulled the window up to be able to see the other queries");
		Thread.sleep(2000);
		
		
		//claim service search
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimServiceQuerySearchButton));
		driver.findElement(ClaimServiceQuerySearchButton).click();
		System.out.println("Clicked search");
		Log.info("log4j msg- clicked search");
		
		
			
		Thread.sleep(10000);
		
		//enter Query name input
		wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
		driver.findElement(QueryNameInput).sendKeys(claimServiceQuery);
		System.out.println("entered query name");
		Log.info("log4j msg- entered query name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearch));
		driver.findElement(QuerySearch).click();
		System.out.println("clicked search query");
		Log.info("log4j msg- clicked search query");
		
		
		
		//click return selection
				wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
				driver.findElement(ReturnSelectionLink).click();
				System.out.println("clicked return selection");
				Log.info("log4j msg- clicked return selection");
		
		
		
		
		
			//click payer/insurer  search
		wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerQuerySearchButton));
		driver.findElement(InsurerPayerQuerySearchButton).click();
		System.out.println("Clicked  insurer/payer query search");
		Log.info("log4j msg- clicked insurer/ payer query search");
		
		
			
		Thread.sleep(10000);
		
		//enter Query name input
		wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
		driver.findElement(QueryNameInput).sendKeys(insurerPayerQuery);
		System.out.println("entered insurer payer query name");
		Log.info("log4j msg- entered insurer payer query name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearch));
		driver.findElement(QuerySearch).click();
		System.out.println("clicked search query");
		Log.info("log4j msg- clicked search query");
		
		
		
		//click return selection
				wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
				driver.findElement(ReturnSelectionLink).click();
				System.out.println("clicked return selection");
				Log.info("log4j msg- clicked return selection");
		
		
		
		
	/*	
		
		
//click go- extract claims data

		wait.until(ExpectedConditions.visibilityOfElementLocated(ExtractClaimsDataGo));
		driver.findElement(ExtractClaimsDataGo).click();
		System.out.println("clicked Go- Extract claims data");
		Log.info("log4j msg- clicked Go- Extract claims data");


Thread.sleep(2000);
wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
driver.findElement(SaveLink).click();
System.out.println("clicked Save");
Log.info("log4j msg- clicked Save");
		
		
		
		
//close totals
wait.until(ExpectedConditions.visibilityOfElementLocated(CloseTotals));
driver.findElement(CloseTotals).click();
System.out.println("clicked close totals");
Log.info("log4j msg- clicked close totals");


		
		
		Thread.sleep(2000);
		
	//close report	
		wait.until(ExpectedConditions.visibilityOfElementLocated(CloseReport));
		driver.findElement(CloseReport).click();
		System.out.println("clicked close report");
		Log.info("log4j msg- clicked close report");	
		
		
		
		*/
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(LogClaimsAsPaidLogChecksToLedgerGo));
		driver.findElement(LogClaimsAsPaidLogChecksToLedgerGo).click();
		System.out.println("clicked log claims as paid, log checks to ledger Go Button");
		Log.info("log4j msg- clicked log claims as paid, log checks to ledger Go Button");	
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(OKButton));
		driver.findElement(OKButton).click();
		System.out.println("clicked ok Button");
		Log.info("log4j msg- clicked ok Button");
		}catch(Exception e){e.printStackTrace();}
		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		exitEOBReport();
		driver.quit();
	
		
	} catch(Exception e){
	e.printStackTrace(); 
	System.out.println("error in log claims as paid  Report"); 
	Log.info("log4j msg- error in log claims as paid Report"); 
	BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	driver.quit(); 
	}
		
	
}

public void exitEOBReport() throws Exception{
	
	try{ 	
		
		//clicked exit
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExitButton));
		driver.findElement(ExitButton).click();
		System.out.println("clicked exit");
		Log.info("log4j msg- clicked exit");	
		
		Thread.sleep(2000);
		try{
		//confirm save yes/no
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(YesButton));
		driver.findElement(YesButton).click();
		System.out.println("clicked yes to save");
		Log.info("log4j msg- clicked yes to save");
		
		Thread.sleep(2000);
		}catch(Exception e) { 
			
			//System.out.println("Error in Clicking Yes to Save");	
			//Log.info("Error in Clicking Yes to Save");
			
		}
	
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Error in exit EOB Report"); 
		Log.info("log4j msg- Error in exit EOB Report"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		driver.quit();
		}
	
}


public void showDataEOB( String claimQuery, String memberQuery, String providerQuery,  String claimServiceQuery, String insurerPayerQuery) throws Exception
{
	try{ 	
		
		WebElement element1=driver.findElement(By.xpath("//input[@data-ng-model='currentRecord.checkMemo']"));
		//Actions builder = new Actions(driver); 
		element1.sendKeys(Keys.PAGE_DOWN);
		//builder.dragAndDropBy(element1, 0,-300).build().perform();
		System.out.println("moved to another position");
		Log.info("log4j msg- clicked and pulled the window up to be able to see the other queries");
		Thread.sleep(2000);
		
		//claim service search
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(ClaimServiceQuerySearchButton));
		driver.findElement(ClaimServiceQuerySearchButton).click();
		System.out.println("Clicked search");
		Log.info("log4j msg- clicked search");
		
		
			
		Thread.sleep(10000);
		
		//enter Query name input
		wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
		driver.findElement(QueryNameInput).sendKeys(claimServiceQuery);
		System.out.println("entered query name");
		Log.info("log4j msg- entered query name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearch));
		driver.findElement(QuerySearch).click();
		System.out.println("clicked search query");
		Log.info("log4j msg- clicked search query");
		
		Thread.sleep(10000);
		//click return selection
		wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
		driver.findElement(ReturnSelectionLink).click();
		System.out.println("clicked return selection");
		Log.info("log4j msg- clicked return selection");
		
		//click payer/insurer  search
		wait.until(ExpectedConditions.visibilityOfElementLocated(InsurerPayerQuerySearchButton));
		driver.findElement(InsurerPayerQuerySearchButton).click();
		System.out.println("Clicked  insurer/payer query search");
		Log.info("log4j msg- clicked insurer/ payer query search");
		
			
		Thread.sleep(10000);
		//enter Query name input
		wait.until(ExpectedConditions.visibilityOfElementLocated(QueryNameInput));
		driver.findElement(QueryNameInput).sendKeys(insurerPayerQuery);
		System.out.println("entered insurer payer query name");
		Log.info("log4j msg- entered insurer payer query name");
		
		//click search
		wait.until(ExpectedConditions.visibilityOfElementLocated(QuerySearch));
		driver.findElement(QuerySearch).click();
		System.out.println("clicked search query");
		Log.info("log4j msg- clicked search query");
		
		Thread.sleep(10000);
		//click return selection
		wait.until(ExpectedConditions.visibilityOfElementLocated(ReturnSelectionLink));
		driver.findElement(ReturnSelectionLink).click();
		System.out.println("clicked return selection");
		Log.info("log4j msg- clicked return selection");
		
		//click go- extract claims data
		wait.until(ExpectedConditions.visibilityOfElementLocated(ExtractClaimsDataGo));
		driver.findElement(ExtractClaimsDataGo).click();
		System.out.println("clicked Go- Extract claims data");
		Log.info("log4j msg- clicked Go- Extract claims data");

/*
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(SaveLink));
		driver.findElement(SaveLink).click();
		System.out.println("clicked Save");
		Log.info("log4j msg- clicked Save");
		*/
		/*
		Thread.sleep(2000);
		//close totals
		wait.until(ExpectedConditions.visibilityOfElementLocated(CloseTotals));
		driver.findElement(CloseTotals).click();
		System.out.println("clicked close totals");
		Log.info("log4j msg- clicked close totals");

		Thread.sleep(3000);
		*/
		
		
		//goto claim
		
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Claim']")));
				WebElement claimElement= driver.findElement(By.xpath("//span[text()='Claim']"));
				claimElement.click();
				System.out.println("clicked claim");
				Log.info("log4j msg- clicked claim");
				Actions builder = new Actions(driver); 
				
				
				builder.moveToElement(claimElement).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
				System.out.println("clicked tab thrice");
				Log.info("log4j msg- clicked tab thrice");
		
		
		
		/*
		
		//goto Interest
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Interest']")));
		driver.findElement(By.xpath("//span[text()='Interest']")).click();
		System.out.println("clicked Interest");
		Log.info("log4j msg- clicked Interest");
		*/
		
	try{
		//close report	
		wait.until(ExpectedConditions.visibilityOfElementLocated(CloseReport));
		driver.findElement(CloseReport).click();
		System.out.println("clicked close report");
		Log.info("log4j msg- clicked close report");	
	
		
		/*
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.body.style.zoom = '0.75'");
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(CloseReport));
		WebElement element = driver.findElement(CloseReport);
		executor.executeScript("arguments[0].click();", element);
		*/
		
		//clicked show data
		wait.until(ExpectedConditions.visibilityOfElementLocated(ShowDataButton));
		driver.findElement(ShowDataButton).click();
		System.out.println("clicked show data");
		Log.info("log4j msg- clicked show data");	
		
		Thread.sleep(10000);
		
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		
		//close report	
				wait.until(ExpectedConditions.visibilityOfElementLocated(CloseReport));
				driver.findElement(CloseReport).click();
				System.out.println("clicked close report");
				Log.info("log4j msg- clicked close report");	
				
			
			
		/*
		//click print
		wait.until(ExpectedConditions.visibilityOfElementLocated(PrintLink));
		driver.findElement(PrintLink).click();
		System.out.println("clicked print");
		Log.info("log4j msg- clicked print");
		*/
		Thread.sleep(10000);
		
		//BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		exitEOBReport();
		driver.quit();
		}catch(Exception e1){ e1.printStackTrace();
		System.out.println("Error in closing Report"); Log.info("Error in closing report");
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		driver.quit(); 
	
	}
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("error in show data EOB Report"); 
		Log.info("log4j msg- error in show data EOB Report"); 
		BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName());
		driver.quit(); 
		}
	
}	

}
