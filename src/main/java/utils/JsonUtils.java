package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class JsonUtils {
    public static final ObjectMapper MAPPER = new ObjectMapper();
    private JsonUtils() {
    }
        public static <T> List<T> readList(
                String resourcePath,
                TypeReference<List<T>> typeReference
        ) {
            System.out.println(JsonUtils.class.getClassLoader().getResource(resourcePath));
            try (InputStream inputStream = JsonUtils.class.getClassLoader().getResourceAsStream(resourcePath)) {
                if (inputStream == null) {
                    throw new IllegalStateException("Test data file not found: " + resourcePath);
                }
                return MAPPER.readValue(inputStream, typeReference);
            } catch (Exception exception) {
                throw new IllegalStateException(
                        "Unable to read JSON test data: "
                                + resourcePath, exception
                );
            }
}
}
