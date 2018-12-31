package utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;


public class BrowserUtils {

	public static WebDriver openChromeBrowser() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
		
			WebDriver driver;
		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
		
		
		 	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
		 	System.setProperty("current.date", dateFormat.format(new Date()));
		
		
		
		return driver;
	}
	public static void takeScreenshot(WebDriver driver,String s) throws Exception {
		try{
		String timeStamp;
		File screenShotName;
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in o drive with name "timestamp.png"
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
		screenShotName = new File("C:\\Opticare\\Screenshots\\"+timeStamp+s+".png");
		FileUtils.copyFile(scrFile, screenShotName);

		String filePath = screenShotName.toString();
		String path = "<img src=\"file://" + filePath + "\" alt=\"\"/>";
		Reporter.log(path);
		}catch(Exception e){ 
			e.printStackTrace();
			System.out.println("Error in taking screenshot"); 
			Log.info("Error in taking screenshot");
			driver.quit();
		}
		
	}
	
	
	
	public static  String findStartTime(WebDriver driver) throws Exception{
		final String startTime;
		startTime= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,sss").format(Calendar.getInstance().getTime()); 
			//2018-10-05 00:31:50,324 INFO  [Log]
		return startTime;

}

}







