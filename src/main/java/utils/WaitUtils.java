package utils;

import config.ConfigManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private final WebDriverWait wait;
    private final WebDriver driver;

    public WaitUtils(WebDriver driver) {
        this.wait = new WebDriverWait(driver, ConfigManager.getExplicitTimeout(), Duration.ofMillis(500));
        this.driver = driver;
    }
    public WebElement waitForVisible(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitForClickable(By locator)
    {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public boolean waitForInvisibility(By locator)
    {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public boolean waitForTitle(String expectedTitle) {
        return wait.until(
                ExpectedConditions.titleIs(expectedTitle)
        );
    }
    public boolean waitForUrlContains(String value) {
        return wait.until(
                ExpectedConditions.urlContains(value)
        );
    }
    public WebElement waitForDynamicElement(By locator) {
        return new FluentWait<>(driver)
                .withTimeout(ConfigManager.getExplicitTimeout())
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .withMessage("Dynamic element was not available: "+ locator)
                .until(currentDriver -> currentDriver.findElement(locator));
    }
}
