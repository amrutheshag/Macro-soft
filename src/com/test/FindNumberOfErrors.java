package com.test;

import java.io.FileReader;
import java.io.LineNumberReader;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utility.Log;
public class FindNumberOfErrors {
	
		static WebDriver driver;
		@Test
		public void FindNumberOfErrorsTestScript() throws Exception{
			
		try{
			System.out.println("Finding Number of Failures");
			Log.info("log4j msg- Finding Number of Failures");
			String userid1= System.getProperty("user.dir");
		String wordname = "error";
		
		
		String filename1=userid1+"\\logs\\logfile.log";
		int m= getStartLine(filename1);
		int count1 = countStringInFile(wordname, filename1, m);
		
			System.out.println("Total number of failures in the Regression suite: "+count1+"\n\n\n"); 
			Log.info("log4j msg- Total number of failures in the Regression suite: "+count1+"\n\n\n"); 
			
		
			
		}catch(Exception e){
			System.out.println("Exception occured in finding number of errors");
			Log.info("log4j msg- Exception occured in finding number of errors");
			e.printStackTrace();
			}

	}
	
		public static int getStartLine(String filename1) throws Exception {
	    	 
			int n=0;
			
        	String x= "Starting Regression suite Execution at: ";
        	
	        try (LineNumberReader r = new LineNumberReader(new FileReader(filename1))) {
	        	String line;
	        	
	        	while ((line = r.readLine()) != null){
	        		if(line.contains(x)){
	        			n=r.getLineNumber();
	        		 }
	        		else{
	        			continue;
	        		}
	        		
	           	}
	       }
	       System.out.println("Current Regression suite Execution Started at Line: "+n);
	       Log.info("log4j msg- Current Regression suite Execution Started at Line: "+n);
	       return n;   	
   	    }

public static int countStringInFile(String wordname, String filename1, int m) throws Exception {
	 
    int count = 0;
    String line;
    
    try (LineNumberReader r = new LineNumberReader(new FileReader(filename1))) {
    	while ((line = r.readLine()) != null) {
    		for (String element : line.split(" ")) {
    			if (r.getLineNumber()>=m && element.equalsIgnoreCase(wordname)) {
    				count++;
    				
    				System.out.println("Issue found at line " + r.getLineNumber()  );
    				Log.info("log4j msg- Issue found at line " + r.getLineNumber()  );
    				
    			}
    		}
    	}
    }
    return count;
	}

}
		

