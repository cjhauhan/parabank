package com.capstone.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void init() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/ParabankReport.html");
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
    }

    public static void startTest(String name) {
        init();
        test.set(extent.createTest(name));
    }

    public static ExtentTest getTest() { return test.get(); }

    public static void flush() { if (extent != null) extent.flush(); }
}
