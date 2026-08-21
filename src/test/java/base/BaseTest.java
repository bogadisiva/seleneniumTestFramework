package base;

import config.ConfigManager;
import config.Environment;
import driver.DriverFactory;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

//    protected WebDriver driver;
//    protected WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        DriverManager.setDriver(DriverFactory.createDriver());
        configureTimeouts();
        if (!ConfigManager.isHeadless()) {
            DriverManager.getDriver().manage().window().maximize();
        }
        DriverManager.getDriver().get(ConfigManager.getBaseUrl());
//        System.out.println("Environment: " + ConfigManager.getEnvironment());
//        System.out.println("Browser: " + ConfigManager.getBrowser());
//        System.out.println("Headless: " + ConfigManager.isHeadless());
//        System.out.println("URL: " + ConfigManager.getBaseUrl());


    }
    private void configureTimeouts() {
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(ConfigManager.getPageLoadTimeout());
        DriverManager.getDriver().manage().timeouts().scriptTimeout(ConfigManager.getScriptTimeout());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.unloadDriver();
    }
}