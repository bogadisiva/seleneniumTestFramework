package utils;

import org.openqa.selenium.WebDriver;

public class WindowUtils {
    private final WebDriver driver;

    public WindowUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNewWindow(
            String originalWindow
    ) {
        for (String handle :
                driver.getWindowHandles()) {

            if (!handle.equals(originalWindow)) {
                driver.switchTo()
                        .window(handle);
                return;
            }
        }

        throw new IllegalStateException(
                "No new browser window found."
        );
    }

    public void switchToWindow(
            String windowHandle
    ) {
        driver.switchTo()
                .window(windowHandle);
    }
}
