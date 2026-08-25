package base;

import config.ConfigManager;
import driver.DriverFactory;
import driver.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected final Logger log4j=  LogManager.getLogger(getClass());

    @BeforeMethod
    public void setUp() {
        DriverManager.setDriver(DriverFactory.createDriver());
        configureTimeouts();
        if (!ConfigManager.isHeadless()) {
            DriverManager.getDriver().manage().window().maximize();
        }
        DriverManager.getDriver().get(ConfigManager.getBaseUrl());
        log4j.info("Environment: " + ConfigManager.getEnvironment());
        log4j.info("Browser: " + ConfigManager.getBrowser());
        log4j.info("Headless: " + ConfigManager.isHeadless());
        log4j.info("URL: " + ConfigManager.getBaseUrl());


    }
    private void configureTimeouts() {
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(ConfigManager.getPageLoadTimeout());
        DriverManager.getDriver().manage().timeouts().scriptTimeout(ConfigManager.getScriptTimeout());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log4j.info("Closing Browser on thread");
        DriverManager.unloadDriver();
    }
}