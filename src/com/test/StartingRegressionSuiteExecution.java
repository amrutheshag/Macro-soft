package com.test;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.xml.DOMConfigurator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utility.Log;

public class StartingRegressionSuiteExecution {
	
WebDriver driver;
	@Test
	public void startTimeTestScript() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		final String time = new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(Calendar.getInstance().getTime()); ;
		System.out.println("Starting Regression suite Execution at: "+time);
		Log.info("Starting Regression suite Execution at: "+time);
		
		
		}
}
