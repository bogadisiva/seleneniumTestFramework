package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementActions {
    private final WaitUtils waitUtils;

    public ElementActions(WebDriver driver) {
        this.waitUtils = new WaitUtils(driver);
    }
    public void click(By locator)
    {
        waitUtils.waitForClickable(locator).click();
    }
    public void type(By locator,String value)
    {
        WebElement element=waitUtils.waitForVisible(locator);
        element.clear();
        element.sendKeys(value);
    }
    public String getText(By locator) {
        return waitUtils
                .waitForVisible(locator)
                .getText()
                .trim();
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitUtils
                    .waitForVisible(locator)
                    .isDisplayed();
        } catch (Exception exception) {
            return false;
        }
    }
}
