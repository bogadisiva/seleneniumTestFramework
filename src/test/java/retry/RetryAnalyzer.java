package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static org.apache.logging.log4j.core.util.Throwables.getRootCause;

public class RetryAnalyzer implements IRetryAnalyzer {
    private static Logger log4j =
            LogManager.getLogger(RetryAnalyzer.class);
    private static final int MAX_RETRIES=1;
    private int retryCount=0;

    @Override
    public boolean retry(ITestResult result) {
        Throwable rootCause = getRootCause(result.getThrowable());
        if (!isRetryable(rootCause)) {
            log4j.info("Test {} will not be retried. Failure type: {}", result.getMethod().getMethodName(),
                    rootCause == null ? "Unknown" : rootCause.getClass().getSimpleName());
            return false;
        }
        if (retryCount >= MAX_RETRIES) {
            return false;
        }
        retryCount++;
        log4j.warn("Retrying test {} because of {}. Retry {}/{}", result.getMethod().getMethodName(),
                rootCause.getClass().getSimpleName(),
                retryCount,
                MAX_RETRIES
        );
        return true;
    }

    private boolean isRetryable(Throwable throwable)
    {
        return throwable instanceof TimeoutException || throwable instanceof StaleElementReferenceException;

    }

    private Throwable getRootCause(Throwable throwable) {
        if (throwable == null) {
            return null;
        }
        Throwable root = throwable;
        while (root.getCause() != null && root.getCause() != root) {
            root = root.getCause();
        }
        return root;
    }
}
