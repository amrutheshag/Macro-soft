package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class MemberActivityPage {
	
	WebDriver driver;
	WebDriverWait wait   ;
	
	By membersClaimsLink = 		By.linkText("Member's Claims");
	By claimsExaminerView = 	By.linkText("Claims, Examiner View");
	By members = 				By.linkText("Members");
	By membersAuthorizations= 	By.linkText("Member's Authorizations");
	By authorizationsExaminerView = By.linkText("Authorizations, Examiner View");
	By memberAccumulators=		By.linkText("Member Accumulators");
	
	public MemberActivityPage(WebDriver driver){
		this.driver= driver;
		this.wait = new WebDriverWait(driver, 35); 
	}
	
	public void clickMembersClaims() throws Exception{
		try{
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(membersClaimsLink));
		driver.findElement(membersClaimsLink).click();
		System.out.println("clicked Member's claims");
		Log.info("Log4j msg- clicked Member's claims");
		}catch(Exception e) {
			System.out.println("error in clicking member claims");
			Log.info("error in clicking member claims"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		}
	}

	public void clickClaimsExaminerView() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(claimsExaminerView));
		driver.findElement(claimsExaminerView).click();
		Log.info("Log4j msg- clicked Claims Examiner View");
		System.out.println("Clicked Claims Examiner View");
	}catch(Exception e) {
		System.out.println("error in clicking member claims");
		Log.info("error in clicking member claims"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	}
	}

	public void clickMembers() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(members));
			driver.findElement(members).click();
			Log.info("log4j msg - clicked Members");
			System.out.println("Clicked Members");
		}catch(Exception e) {
			System.out.println("error in clicking member claims");
			Log.info("error in clicking member claims"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	}
	}

	public void clickMembersAuthorizations() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(membersAuthorizations));
			driver.findElement(membersAuthorizations).click();
			Log.info("log4j msg - clicked Member's Authorizations");
			System.out.println("Clicked Member's Authorizations");
		}catch(Exception e) {
			System.out.println("error in clicking member claims");
			Log.info("error in clicking member claims"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	}
	}

	public void clickAuthorizationsExaminerView() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(authorizationsExaminerView));
			driver.findElement(authorizationsExaminerView).click();
			Log.info("log4j msg - clicked Authorizations Examiner View");
			System.out.println("Clicked Authorizations Examiner View");
		}catch(Exception e) {
			System.out.println("error in clicking member claims");
			Log.info("error in clicking member claims"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
	}
	}

	public void clickMemberAccumulators() throws Exception{
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(memberAccumulators));
			driver.findElement(memberAccumulators).click();
			Log.info("log4j msg - clicked Member Accumulators");
			System.out.println("Clicked Member Accumulators");
		}catch(Exception e) {
			System.out.println("error in clicking member claims");
			Log.info("error in clicking member claims"); BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		}
	}

	
	
}
