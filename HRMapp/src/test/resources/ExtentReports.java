
public class ExtentReports extends BaseClass {
	//public static ThreadLocal<ExtentTest> exTest = new ThreadLocal<ExtentTest>;
	
	public static ExtentReports exReport;
	puublic static ExtentSparkReporter spark;
	public static ExtentTest exTest;
	
	public static void extentTestReporter() {
		exReport = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+
				"/test-output/ExtentReport/"+"MyReport.html");
		extent.attachReporter(spark);
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent Demo");
		extent.setSystemInfo("Project Name", "OrangeHRM");
		extent.setSystemInfo("Tester", "Lavanya");
		

}
