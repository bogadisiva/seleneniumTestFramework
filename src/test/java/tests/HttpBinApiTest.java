package tests;

import api.clients.HttpBinClient;
import api.spec.RequestSpecFactory;
import base.BaseApiTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class HttpBinApiTest extends BaseApiTest {
    HttpBinClient httpBinClient = new HttpBinClient();

    @Test
    public void deleteApiRequest()
    {
        Response response=httpBinClient.delete();
        System.out.println(response.getBody());
    }

    @Test
    public void getApiRequest()
    {
        Response response=httpBinClient.get();
        System.out.println(response.getBody().asString());
    }
}
