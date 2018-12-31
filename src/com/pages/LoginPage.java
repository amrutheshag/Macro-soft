package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.BrowserUtils;
import utility.Log;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;

	//By networkUserBtn=By.xpath("//input[@class ='btn btn-default involve-user']");
	By nonnetworkUserBtn=By.xpath("//*[@id='LoginScreen']/div/div/div/div[3]/form[2]/button");
	By userName = By.xpath("//*[@id='login-username']");
	By password = By.xpath("//*[@id='login-password']");
	By loginBtn = By.xpath("//*[@id='LoginSelectScreen']/div/div/div/div[3]/form/button");
	public LoginPage(WebDriver driver){
		this.driver= driver;
		this.wait = new WebDriverWait(driver, 35); 
	}
	
	
	public void clickNetworkUser() throws Exception {
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(nonnetworkUserBtn));
		driver.findElement(nonnetworkUserBtn).click();
		
		
		System.out.println("Non-Network User Clicked");
		Log.info("Log4j msg- Non-Network User Clicked");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(userName));
		driver.findElement(userName).sendKeys("rm");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		driver.findElement(password).sendKeys("rm");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
		driver.findElement(loginBtn).click();
		
		}catch(Exception e){System.out.println("Network User button is not found, problem with opening Login Page.");
		 Log.info("Network User button is not found, problem with opening Login Page."); 
		 BrowserUtils. takeScreenshot(driver, Thread.currentThread().getStackTrace()[2].getMethodName()); 
		 driver.quit();
		
		}		
	}

	



}
