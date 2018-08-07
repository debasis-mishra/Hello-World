package screenshot;

import org.apache.commons.io.FileUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ListenerTest implements ITestListener {

	String destDir = "C:/ErrorScreenshot";
	
	public void onTestFailure(ITestResult result)
	{
		String funcName = "";
		
		if(result!=null)
		{
			funcName = result.getName().toString().trim();
		}
		
		System.out.println("test name" + funcName);
		
		try
		{
			captureScreenShot(ScreenshotsEx.driver, new File(destDir + "/" + funcName + ".png"));
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	
	public void onTestSkipped(ITestResult result)
	{
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		
	}
	
	public void onTestStart(ITestResult result)
	{
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}
	
	public void takeScreenshot(String methodName)
	{
		
	}
	
	public void captureScreenShot(WebDriver driver, File image) throws IOException
	{
		System.out.println("Taking screenshot....");
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcFile, image);
	}
}
