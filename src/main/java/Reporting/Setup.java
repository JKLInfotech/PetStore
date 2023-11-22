package Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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

}
