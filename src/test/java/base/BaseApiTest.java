package base;

import config.ConfigManager;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseApiTest {

    @BeforeSuite
    public void configureApi(){
        RestAssured.baseURI= ConfigManager.getApiBaseUrl();
    }

}
