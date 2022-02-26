package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportPSL
{
	 static ExtentReports extents;
	public static ExtentReports getReport()
	{
		String path= System.getProperty("user.dir")+"\\reports1\\index.html";
		ExtentSparkReporter spark=new ExtentSparkReporter(path);
		
		spark.config().setDocumentTitle("Dattas Frameword");
		spark.config().setReportName("Tarl Framwork");
		
		extents=new ExtentReports();
		extents.attachReporter(spark);
		extents.setSystemInfo("datta", "Tester");
		
		return extents;
		
	
	}

	
}
