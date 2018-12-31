package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class SelectMemberPage {
	
	WebDriver driver;
	WebDriverWait wait ;
	
	By customCodeBeginsInput = 	By.xpath("//input[@data-ng-model='filterOptions.userfield1']");
	
	By nameInput =				By.xpath("//input[@id='txtSearchCode' and @data-ng-model='filterOptions.name']");

	By dobInput = 				By.xpath("//input[@data-ng-model='filterOptions.dob']");

	By ssnInput = 				By.xpath("//input[@data-ng-model='filterOptions.ssn']");
	
	By searchButton = 			By.xpath("//button[@class='btn btn-primary']");
	
	By returnSelection =		By.xpath("//span[text()='Return Selection']");
		
	
	
	
	
	
	public SelectMemberPage(WebDriver driver){
		this.driver= driver;
		this.wait= new WebDriverWait(driver, 35);    
	}
	
public int searchMember( String mid, String mlname, String mfname, String mdob, String mssn) throws Exception{
		try{	
			
			if (mid.isEmpty()){System.out.println("No more data to test"); driver.quit(); return 0; }
			else{
				try{	wait.until(ExpectedConditions.visibilityOfElementLocated(nameInput));
				driver.findElement(nameInput).sendKeys(mlname);
				System.out.println("entered lastname");
				Log.info("log4j msg- entered lastname");
				Thread.sleep(1000);
				}
				catch(Exception e){System.out.println("Select Member page didnot open, cannot find new member");Log.info("Select Member page didnot open, cannot find new member");return 0;}
				
				
		
		//enter  dob
		wait.until(ExpectedConditions.visibilityOfElementLocated(dobInput));
		
		driver.findElement(dobInput).clear();
		Thread.sleep(2000);		

		driver.findElement(dobInput).sendKeys(mdob);
		System.out.println("entered dob");
		Log.info("log4j msg- entered dob");
		Thread.sleep(1000);		
				
				
				
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(customCodeBeginsInput));
		driver.findElement(customCodeBeginsInput).sendKeys(mid);
		Log.info("log4j msg- entered mid");
		
		
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(ssnInput));
		driver.findElement(ssnInput).sendKeys(mssn);
		System.out.println("entered ssn");
		Log.info("log4j msg- entered ssn");
			Thread.sleep(1000);
			
		
			wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
			driver.findElement(searchButton).click();
			System.out.println("clicked search");
		Log.info("log4j msg- clicked search");
		Thread.sleep(5000);
		
		//click on mid
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and contains(text(), '"+mid+"')]")));
		driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope' and text()= '"+mid+"']")).click();
		Log.info("log4j msg- clicked on the mid");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(returnSelection));
		driver.findElement(returnSelection).click();
		System.out.println("member selected");
		Log.info("log4j msg- member selected");
		
		return 1;
			}
		} 
		catch (Exception e) 
		{System.out.println("Member search failed.");
		Log.info("log4j msg- member search failed"); e.printStackTrace();
		return 0;
		}
	}
}
