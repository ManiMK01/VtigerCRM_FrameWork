package java.com.camcast.crm.listenerutility;

import java.com.camcast.crm.baseclass.BaseClass;
import java.com.comcast.crm.generic.Webdriverutility.JavaUtility;
import java.com.comcast.crm.generic.Webdriverutility.UtilityClassObject;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImpClass implements ITestListener, ISuiteListener  {

	JavaUtility ju = new JavaUtility();
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	
	@Override
	public void onStart(ISuite suite) {
		
		String timestamp = LocalDateTime.now().toString().replace(":", "_");
		//Create spark report config
		spark = new ExtentSparkReporter("./HTML_Report/ExtentReport_"+ju.getCurrentTimeAndDate()+".html");
		spark.config().setDocumentTitle("CRM TestSuite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		// Add Environment Info & Create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "WINDOWS-11");
		report.setSystemInfo("BROWSER", "CHROME");
		//ISuiteListener.super.onStart(suite);
		
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, "=====> TESTSCRIPT STARTED <=====");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.INFO, "=====> TESTSCRIPT COMPLETED <=====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sDriver;
		
		// Take ScreenShot 
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File desp = new File("./Screenshots/"+testName+"_"+ju.getCurrentTimeAndDate()+".png");
		try {
			FileHandler.copy(temp, desp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Store Screenshot in Html_Report
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64),result.getName()+"="+ju.getCurrentTimeAndDate()+".html");
//		test.addScreenCaptureFromBase64String(temp, result.getMethod().getMethodName());
		test.log(Status.FAIL, testName+"=====> FAILED <=====");
		Reporter.log(testName+"FAIL",true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.INFO, "=====> TESTSCRIPT SKIPPED <=====");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
	
}
