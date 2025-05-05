package utils;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

//    private static ExtentReports extent;
//
//    public static ExtentReports getReportInstance() {
//        if (extent == null) {
//        	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/extentReport.html");
//        	extent = new ExtentReports();
//        	extent.attachReporter(sparkReporter);
//
//        }
//        return extent;
//    }
    
    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/extentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        return extent;
    }
}
