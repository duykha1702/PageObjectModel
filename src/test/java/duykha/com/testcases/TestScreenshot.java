package duykha.com.testcases;

import duykha.com.common.BaseTest;
import duykha.com.drivers.DriverManager;
import duykha.com.helpers.CaptureHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class TestScreenshot extends BaseTest {
    @Test
    public void testHomePage1(Method method) {
        CaptureHelper.startRecord(method.getName());
        DriverManager.getDriver().get("https://anhtester.com");
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Anh Tester Automation Testing 2");

    }

    @Test
    public void testHomePage2(Method method) {
        CaptureHelper.startRecord(method.getName());
        DriverManager.getDriver().get("https://anhtester.com");
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Anh Tester Automation Testing");

    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {

            CaptureHelper.captureScreenshot(iTestResult.getName());

        }
        CaptureHelper.stopRecord();
    }
}
