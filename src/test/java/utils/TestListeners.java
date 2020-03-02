package test.java.utils;


import org.openqa.selenium.WebDriver;
import org.testng.*;

public class TestListeners implements
        ISuiteListener,
        ITestListener,
        IInvokedMethodListener {


    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("Suite was started");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        System.out.println("Suite was finished");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Test was started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test was succeeded");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ITestContext context = iTestResult.getTestContext();
        WebDriver driver = (WebDriver) context.getAttribute("webDriver");
        Screenshot screenshot = new Screenshot(driver);
        screenshot.saveScreenshot(iTestResult);
        System.out.println("Test was failed");

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}

