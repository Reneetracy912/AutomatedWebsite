package ReneeDishPractice.resources;

import ReneeDishPractice.ExtendTests.ExtentReports;
import ReneeDishPractice.ExtendTests.ExtentSparkReporter;

public class ExtendReporters {
	public static ExtentReports getReportsObject() {
		String path = System.getProperty("user.dir")+ "\\reports\\index.html";
		//intatiating class
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		//Using method from that class for report name
		reporter.config().setReportName("Web Automation results");
		reporter.config().setDocumentTitle("Web Automation results");
		//main class that drive reporting execution create and console test execution
	 ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","RahulShetty");
		return extent;
		
	}

}
