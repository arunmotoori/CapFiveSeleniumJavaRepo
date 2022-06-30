package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports getExtentReport() {
		
		String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		reporter.config().setReportName("TutorialsNinja Automation Results");
		reporter.config().setDocumentTitle("TutorialsNinja Test Results");
		
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System","Windows 11");
		extentReport.setSystemInfo("Tests Run By","Arun Motoori");
		extentReport.setSystemInfo("Application","TutorialsNinja");
		
		return extentReport;
	}

}
