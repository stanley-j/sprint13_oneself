package org.report;


import java.io.File;

import org.baseOneSelf.BaseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report extends BaseClass {
	public static ExtentReports extentreport;
	public static ExtentSparkReporter sparkreport;
	public static ExtentTest testcase;

	public static ExtentReports Report() {
		File OutputFolder = new File("./Test Report");
		if (!OutputFolder.exists()) {
			if (OutputFolder.mkdir()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create Directory");
			}
		} else {
			System.out.println("Directory already exists");
		}
		extentreport = new ExtentReports();
		String filepath = System.getProperty("user.dir") + "//Test Report//OneSelfReport.html";
		sparkreport = new ExtentSparkReporter(filepath);
		extentreport.attachReporter(sparkreport);

		return null;
	}

	public static void ReportCooldown() {
		extentreport.flush();
	}

	public static void ReportCreateTestcase(String Title) throws ClassNotFoundException {
		testcase = extentreport.createTest(Title);
	}

	public static void Pass(String passdetails) throws Throwable {
		String ScreenShot = captureScreenshot();
		testcase.pass(passdetails, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot).build());

	}

	public static void Fail(String faildetails) throws Throwable {
		String ScreenShot = captureScreenshot();
		testcase.fail(faildetails, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot).build());

	}
}
