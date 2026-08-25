package listeners;

import config.ConfigManager;
import driver.DriverManager;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.AllureEnvironmentWriter;
import utils.ScreenshotUtils;

import java.nio.file.Path;

public class TestListener implements ITestListener, IExecutionListener {
    protected final Logger log4j= LogManager.getLogger(getClass());

    @Override
    public void onExecutionStart(){
        AllureEnvironmentWriter.write();
        log4j.info("Automation execution started");
    }
    @Override
    public void onTestStart(ITestResult result){
        log4j.info("TEST STARTED: {}",result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result)
    {
//        log4j.info("TEST PASSED: {}",result.getMethod().getMethodName());
        long duration = result.getEndMillis() - result.getStartMillis();
        log4j.info("TEST PASSED: {} | Duration={} ms", result.getMethod().getMethodName(),duration
        );
    }
    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        log4j.error("TEST FAILED: {}", testName, result.getThrowable());
        try {
            WebDriver driver = DriverManager.getDriver();
            ScreenshotUtils.captureToFile(driver, testName);
            logFailureMetadata(result,driver);

            byte[] screenshot1 = ScreenshotUtils.captureAsBytes(driver);
            Allure.getLifecycle().addAttachment(testName+"-Failure Screenshot","image/png","png",screenshot1);
//            log4j.info("Failure screenshot: {}",screenshot);

        } catch (Exception exception) {

            log4j.error(
                    "Unable to capture failure screenshot",
                    exception
            );
        }
    }
    @Override
    public void onTestSkipped(ITestResult result){
        log4j.warn(
                "TEST SKIPPED: {}",
                result.getMethod()
                        .getMethodName()
        );
    }
    @Override
    public void onStart(ITestContext context)
    {
        log4j.info(
                "TEST CONTEXT STARTED: {}",
                context.getName()
        );
    }
    @Override
    public void onFinish(ITestContext context)
    {
        log4j.info("TEST CONTEXT FINISHED: {}",context.getName());
    }
    private void logFailureMetadata(
            ITestResult result,
            WebDriver driver
    ) {

        log4j.error(
                "Test Name: {}",
                result.getMethod()
                        .getMethodName()
        );

        log4j.error(
                "Thread ID: {}",
                Thread.currentThread()
                        .threadId()
        );

        log4j.error(
                "Browser: {}",
                ConfigManager.getBrowser()
        );

        log4j.error(
                "Environment: {}",
                ConfigManager.getEnvironment()
        );

        log4j.error(
                "Current URL: {}",
                driver.getCurrentUrl()
        );

        log4j.error(
                "Page Title: {}",
                driver.getTitle()
        );
    }
}
