package api.clients;

import api.spec.RequestSpecFactory;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HttpBinClient {
    public Response delete(){
        return given().spec(RequestSpecFactory.defaultSpec()).when().delete("/delete");
    }
    public Response get(){
        return given().spec(RequestSpecFactory.defaultSpec()).when().get("/get");
    }
}
