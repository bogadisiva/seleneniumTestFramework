package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertUtils {
    private final WebDriver driver;

    public AlertUtils(WebDriver driver) {
        this.driver = driver;
    }
    public String getAlertText() {
        return driver.switchTo()
                .alert()
                .getText();
    }
    public void acceptAlert() {
        driver.switchTo()
                .alert()
                .accept();
    }

    public void dismissAlert() {
        driver.switchTo()
                .alert()
                .dismiss();
    }

    public void enterText(
            String text
    ) {
        Alert alert =
                driver.switchTo()
                        .alert();
        alert.sendKeys(text);
    }
}
