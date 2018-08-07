package extentreportex;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.io.File;
import java.net.*;

public class ExtentReportsClassVersion3 {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	public void startReport() throws UnknownHostException
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/TestReport.html");
		htmlReporter.loadXMLConfig(
				new File(System.getProperty("user.dir")+"/extent-config.xml"));
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		//htmlReporter.config().setDocumentTitle("Summary report");
		//htmlReporter.config().setReportName("Expense report");
		//htmlReporter.config().setTheme(Theme.DARK);
		//ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		UtilsEx utils = new UtilsEx();
		String hostName = utils.getHostName();
		String loginUser = utils.getCurrentUserName();
		
		extent.setSystemInfo("Host Name", hostName);
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", loginUser);
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		}
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
	
	@Test
	public void passTest(){
		logger = extent.createTest("passTest");
		Assert.assertTrue(true);
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
	}
	
	@Test
	public void failTest(){
		logger = extent.createTest("failTest");
		Assert.assertTrue(false);
		logger.log(Status.PASS, "Test Case (failTest) Status is passed");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test Case (failTest) Status is passed", ExtentColor.GREEN));
	}
	
	@Test
	public void skipTest(){
		logger = extent.createTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
}
