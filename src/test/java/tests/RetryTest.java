package tests;

import org.openqa.selenium.InvalidSelectorException;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class RetryTest {
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void verifyRetry() {

        throw new InvalidSelectorException(
                "Intentional invalid selector for retry test"
        );
    }
}
