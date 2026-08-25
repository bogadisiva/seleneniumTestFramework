package reporting;

import config.ConfigManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class AllureEnvironmentWriter {

    public static void write() {
        Path directory = Path.of("target", "allure-results");
        Path file = directory.resolve("environment.properties");
        List<String> properties = List.of(
                "Environment=" + ConfigManager.getEnvironment(),
                "Browser=" + ConfigManager.getBrowser(),
                "Headless=" + ConfigManager.isHeadless(),
                "BaseURL=" + ConfigManager.getBaseUrl());
        try {
            Files.createDirectories(directory);
            Files.write(file, properties);
        } catch (IOException exception) {
            throw new RuntimeException(
                    "Unable to write Allure environment metadata", exception);
        }
    }

}
