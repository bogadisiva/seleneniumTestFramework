package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {
    private final JavascriptExecutor js;
    public JavaScriptUtils(WebDriver driver)
    {
        this.js= (JavascriptExecutor) driver;
    }
    public void click(WebElement element)
    {
        js.executeScript("arguments[0].click();",element);
    }
    public void scrollIntoView(WebElement element) {
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );
    }

    public String getPageReadyState() {
        return String.valueOf(
                js.executeScript(
                        "return document.readyState;"
                )
        );
    }
}
