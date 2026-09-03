package tests;

import api.clients.HttpBinClient;
import api.models.HttpBinResponse;
import api.spec.RequestSpecFactory;
import base.BaseApiTest;
import com.fasterxml.jackson.core.type.TypeReference;
import data.TestDataProvider;
import io.restassured.response.Response;
import model.EntryForm;
import model.HttpStatusType;
import model.HttpStausData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JsonUtils;

import java.util.List;

public class HttpBinApiTest extends BaseApiTest {
    HttpBinClient httpBinClient = new HttpBinClient();
    protected final Logger log4j= LogManager.getLogger(getClass());


//    @DataProvider
//    public static Object[][] restApiStatusCodes() {
//        List<EntryForm> data= JsonUtils.readList("testdata/restApi.json",
//                new TypeReference<List<EntryForm>>() {});
//
//        return data.stream().map(item -> new Object[]{item}).toArray(Object[][]::new);
//    }


    @Test
    public void deleteApiRequest()
    {
        Response response=httpBinClient.delete();
        HttpBinResponse body=response.as(HttpBinResponse.class);
        System.out.println(body.getHeaders());
    }

    @Test
    public void getApiRequest()
    {
        Response response=httpBinClient.get();
        HttpBinResponse body=response.as(HttpBinResponse.class);
        System.out.println(response.jsonPath().getString("url"));

    }

    @Test
    public void verifyStatusCodes()
    {
        HttpStausData data= TestDataProvider.get(HttpStatusType.OK);
        Response response=httpBinClient.get();
        log4j.info("The Status Code of Response {}", response.statusCode());
        Assert.assertEquals(response.statusCode(),data.getStatusCode());
    }
}
