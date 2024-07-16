package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsTestNG {

	public static ExtentReports extentReport() {
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Report");
		reporter.config().setReportName("Automation Report");
		
		ExtentReports ex=new ExtentReports();
		ex.attachReporter(reporter);
		ex.setSystemInfo("Tester", "Aditya");
		return ex;
	}
}
