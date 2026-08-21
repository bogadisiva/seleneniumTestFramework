package utils;

import config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.wait = new WebDriverWait(driver, ConfigManager.getExplicitTimeout());
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
}
