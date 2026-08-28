package config;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;

public final class ConfigManager {
    private static final Properties PROPERTIES=new Properties();
    private static final Environment ENVIRONMENT=resolveEnvironment();
    static {
        loadProperties();
    }
    private ConfigManager()
    {
        throw new UnsupportedOperationException("Config Manager is a utility Class.");
    }
    private static Environment resolveEnvironment(){
        String environment=firstNonBlank(System.getProperty("env"),System.getenv("TEST_ENV"),"dev");
        return Environment.from(environment);

    }
    private static void loadProperties(){
        String fileName=ENVIRONMENT.fileName();
        try (
                InputStream inputStream =
                        ConfigManager.class
                                .getClassLoader()
                                .getResourceAsStream(fileName)
        ) {
            if (inputStream == null) {
                throw new IllegalStateException(
                        "Configuration file was not found: "
                                + fileName
                );
            }

            PROPERTIES.load(inputStream);
        } catch (IOException exception) {
            throw new IllegalStateException(
                    "Unable to load configuration file: "
                            + fileName,
                    exception
            );
        }
    }


    public static String getEnvironment() {
        return ENVIRONMENT
                .name()
                .toLowerCase();
    }
    public static String getBaseUrl(){
        return getRequiredProperty(
                "base.url",
                "BASE_URL"
        );
    }
    public static String getBrowser() {
        return Objects.requireNonNull(firstNonBlank(
                System.getProperty("browser"),
                System.getenv("BROWSER"),
                PROPERTIES.getProperty("browser"),
                "chrome"
        )).toLowerCase();
    }

    public static boolean isHeadless() {
        String value = firstNonBlank(
                System.getProperty("headless"),
                System.getenv("HEADLESS"),
                PROPERTIES.getProperty("headless"),
                "false"
        );

        return Boolean.parseBoolean(value);
    }

    public static Duration getExplicitTimeout() {
        return Duration.ofSeconds(
                getPositiveLong(
                        "explicit.timeout",
                        "EXPLICIT_TIMEOUT",
                        20
                )
        );
    }

    public static Duration getPageLoadTimeout() {
        return Duration.ofSeconds(
                getPositiveLong(
                        "page.load.timeout",
                        "PAGE_LOAD_TIMEOUT",
                        60
                )
        );
    }

    public static Duration getScriptTimeout() {
        return Duration.ofSeconds(
                getPositiveLong(
                        "script.timeout",
                        "SCRIPT_TIMEOUT",
                        30
                )
        );
    }
    private static String getRequiredProperty(
            String propertyKey,
            String environmentVariable
    ) {
        String value = firstNonBlank(
                System.getProperty(propertyKey),
                System.getenv(environmentVariable),
                PROPERTIES.getProperty(propertyKey)
        );

        if (value == null) {
            throw new IllegalStateException(
                    "Required configuration is missing: "
                            + propertyKey
            );
        }

        return value;
    }

    private static long getPositiveLong(
            String propertyKey,
            String environmentVariable,
            long defaultValue
    ) {
        String value = firstNonBlank(
                System.getProperty(propertyKey),
                System.getenv(environmentVariable),
                PROPERTIES.getProperty(propertyKey),
                String.valueOf(defaultValue)
        );

        try {
            long parsedValue =
                    Long.parseLong(value);

            if (parsedValue <= 0) {
                throw new IllegalArgumentException(
                        propertyKey
                                + " must be greater than zero."
                );
            }

            return parsedValue;
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(
                    "Invalid numeric value for "
                            + propertyKey
                            + ": "
                            + value,
                    exception
            );
        }
    }
    private static String firstNonBlank(String... values)
    {
        for (String value : values) {
            if (value != null && !value.isBlank()) {
                return value.trim();
            }
        }
        return null;
    }
    public static String getApiBaseUrl(){
        return getRequiredProperty("api.base.url","API_BASE_URL");
    }
}
