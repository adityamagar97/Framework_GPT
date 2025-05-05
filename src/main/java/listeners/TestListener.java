package listeners;

import base.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;
import org.apache.log4j.Logger;

public class TestListener implements ITestListener {

//    ExtentReports extent = ExtentReportManager.getReportInstance();
//    ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//    Logger log = Logger.getLogger(TestListener.class);
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        test.set(extent.createTest(result.getMethod().getMethodName()));
//        log.info("Test Started: " + result.getMethod().getMethodName());
//        System.out.println("started" + result.getName());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        test.get().log(Status.PASS, "Test Passed");
//        log.info("Test Passed: " + result.getMethod().getMethodName());
//        System.out.println("success" + result.getName());
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        test.get().log(Status.FAIL, result.getThrowable());
//        log.error("Test Failed: " + result.getThrowable());
//
//        String path = ScreenshotUtil.captureScreenshot(BaseClass.driver);
//     
//        test.get().addScreenCaptureFromPath(path);
//        log.info("Screenshot captured at: " + path);
//        System.out.println("failed" + result.getName());
//    }
//
//    @Override
//    public void onFinish(org.testng.ITestContext context) {
//        extent.flush();
//        log.info("Extent report flushed");
//        System.out.println("finished" + context.getName());
//    }
	
	
	 ExtentReports extent = ExtentReportManager.getReportInstance();
	    ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	    Logger log = Logger.getLogger(TestListener.class);

	    @Override
	    public void onTestStart(ITestResult result) {
	        test.set(extent.createTest(result.getMethod().getMethodName()));
	        log.info("Test Started: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.get().log(Status.PASS, "Test Passed");
	        log.info("Test Passed: " + result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.get().log(Status.FAIL, result.getThrowable());
	        log.error("Test Failed: " + result.getThrowable());

	        String screenshotPath = ScreenshotUtil.captureScreenshot(BaseClass.driver);

	        try {
	            test.get().addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        log.info("Screenshot captured at: " + screenshotPath);
	    }

	    @Override
	    public void onFinish(org.testng.ITestContext context) {
	        extent.flush();
	        log.info("Extent report flushed");
	    }
}
