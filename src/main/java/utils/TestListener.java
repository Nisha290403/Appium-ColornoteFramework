package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.appium.java_client.android.AndroidDriver;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getExtent();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        AndroidDriver driver = DriverFactory.getDriver();
        String path = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
        test.get().pass("Test Passed").addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        AndroidDriver driver = DriverFactory.getDriver();
        String path = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
        test.get().fail(result.getThrowable()).addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        AndroidDriver driver = DriverFactory.getDriver();
        String path = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
        test.get().skip("Test Skipped").addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
