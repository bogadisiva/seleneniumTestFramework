package api.spec;

import config.ConfigManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public final class RequestSpecFactory {

    private RequestSpecFactory() {
    }
    public static RequestSpecification defaultSpec() {
        return new RequestSpecBuilder().setBaseUri(ConfigManager.getApiBaseUrl())
                .setAccept(ContentType.JSON).build();
    }
}