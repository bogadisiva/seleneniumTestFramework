package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtils {

    private final JavascriptExecutor js;

    public ScrollUtils(WebDriver driver) {
        this.js = (JavascriptExecutor) driver;
    }

    public void scrollToElement(
            WebElement element
    ) {
        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                element
        );
    }

    public void scrollToBottom() {
        js.executeScript(
                "window.scrollTo(0, document.body.scrollHeight);"
        );
    }

    public void scrollToTop() {
        js.executeScript(
                "window.scrollTo(0, 0);"
        );
    }
}
