package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import driver.BaseClass;

public class Listener extends BaseClass implements ITestListener {
	
		public void onTestStart(ITestResult result) {  
			System.out.println("We are starting the test : "+result.getName());
		// TODO Auto-generated method stub  
		}  
		  
		public void onTestSuccess(ITestResult result) {  
		// TODO Auto-generated method stub  
			System.out.println("Success of test cases and its details are : "+result.getName());
			
			try {
				takeSnapShot(driver,"screenshots/"+result.getName()+".png");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void onTestFailure(ITestResult result) {  
		// TODO Auto-generated method stub  
			System.out.println("This test case has failed : "+result.getName());  
			
			try {
				takeSnapShot(driver,"screenshots/"+result.getName()+".png");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  

		public void onTestSkipped(ITestResult result) {  
		// TODO Auto-generated method stub  
			System.out.println("Skip of test cases and its details are : "+result.getName());  
		}  

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
		// TODO Auto-generated method stub  
		System.out.println("Failure of test cases and its details are : "+result.getName());  
		}  

		public void onStart(ITestContext context) {  
		// TODO Auto-generated method stub  
		}  

		public void onFinish(ITestContext context) {  
		// TODO Auto-generated method stub  
		} 
		
		public void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot = ((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file

	        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	        //Move image file to new destination

	        File DestFile=new File(fileWithPath);

	        //Copy file at destination

	        FileUtils.copyFile(SrcFile, DestFile);

	    }

}
