package duykha.com.listeners;

import com.aventstack.extentreports.Status;
import duykha.com.helpers.CaptureHelper;
import duykha.com.helpers.PropertiesHelper;
import duykha.com.reports.ExtentReportManager;
import duykha.com.reports.ExtentTestManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }
    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }


    @Override
    public void onStart(ITestContext result) {

        PropertiesHelper.loadAllFiles();

    }
    @Override
    public void onFinish(ITestContext result) {


        ExtentReportManager.getExtentReports().flush();



    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Đây là test case bị fail: " + result.getName());
        CaptureHelper.captureScreenshot(result.getName());
        System.out.println(result.getThrowable().toString());
        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("Đây là test case bị bỏ qua: " + result.getName());
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));


    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("Đây là test case chạy thành công: " + result.getName());
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");
    }

}
