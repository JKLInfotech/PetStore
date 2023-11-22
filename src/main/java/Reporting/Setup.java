package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class Setup implements ITestListener {

   public static ExtentReports extentReports = null;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public void onStart(ITestContext context){

        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String reportPath = System.getProperty("user.dir")+"\\Report\\"+fileName;
        extentReports = ExtentReportManager.createInstance(reportPath,"Report","Api automation");

    }

    public  void onFinish(ITestContext context){
        if(extentReports != null){
            extentReports.flush();
        }
    }

    public void onTestStart(ITestResult result){
        ExtentTest test = extentReports.createTest("Test Name: "+result.getMethod().getMethodName());
        extentTest.set(test);

    }

    public void onTestPassed(ITestResult result){
        ExtentTest test = extentReports.createTest("Test Name: "+result.getMethod().getMethodName());
        extentTest.set(test);

    }

    public void onTestFailure(ITestResult result){
        ExtentReportManager.logFailDetails("<div style='color: #000000;'>"+result.getThrowable().getMessage()+"</div>");
        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        String stackTraceFormatted = stackTrace.replaceAll(",","<br>");
        String stackTraceViewMore = "<details>\n" +
                "<summary>View More Exception Details</summary>\n" +
                ""+stackTraceFormatted+"\n" +
                "</details>";
        ExtentReportManager.logExceptionDetails(stackTraceViewMore);

    }
    public void onTestSkipped(ITestResult result){
        ExtentTest test = extentReports.createTest("Test Name: "+result.getMethod().getMethodName());
        extentTest.set(test);

    }

}
