package tests;

import config.ConfigManager;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteApiTest {

    @Test
    public void verifyDeleteRequest(){
        Response response=given().baseUri(ConfigManager.getApiBaseUrl())
                                .headers("Accept","application/json").when().delete("/delete");

        Assert.assertEquals(response.statusCode(),200,"Incorrect status code");
        Assert.assertTrue(response.contentType().contains("application/json"),"incorrect content type");
        Assert.assertEquals(response.jsonPath().getString("url"),"https://httpbin.org/delete");
        Assert.assertEquals(response.jsonPath().getString("headers.Accept"),"application/json");
        Assert.assertNull(response.jsonPath().get("json"));
    }

}
