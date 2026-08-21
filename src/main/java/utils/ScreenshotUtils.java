package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtils {

    private final WebDriver driver;

    public ScreenshotUtils(WebDriver driver) {
        this.driver = driver;
    }

    public Path capture(
            String testName
    ) {

        String timestamp =
                LocalDateTime.now()
                        .format(
                                DateTimeFormatter
                                        .ofPattern(
                                                "yyyyMMdd-HHmmss"
                                        )
                        );

        Path destination =
                Path.of(
                        "target",
                        "screenshots",
                        testName
                                + "-"
                                + timestamp
                                + ".png"
                );

        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(
                                OutputType.FILE
                        );

        try {
            Files.createDirectories(
                    destination.getParent()
            );

            Files.copy(
                    source.toPath(),
                    destination
            );

            return destination;

        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to save screenshot.",
                    e
            );
        }
    }
}
