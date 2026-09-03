package data;

import com.fasterxml.jackson.core.type.TypeReference;
import model.EntryForm;
import model.HttpStatusType;
import model.HttpStausData;
import org.openqa.selenium.devtools.latest.domstorage.model.Item;
import org.testng.annotations.DataProvider;
import utils.JsonUtils;

import java.util.List;

public class TestDataProvider {
//    private static final String DATA_FILE = "testdata/restApi.json";
    private TestDataProvider() {
    }
    @DataProvider(name = "entryForm",parallel = false)
    public static Object[][] dataEntryForm() {
//        return new Object[][]{
//                {
//                        new EntryForm("Siva", "Siva Chandrasekhar", "siva.c.bogadi@gmail.com",
//                                "Hyderabad", "Password")},
//                {
//                        new EntryForm("Selenium - Automation Practice Form", "Siva Chandrasekhar",
//                                "siva.c.bogadi@gmail.com", "Hyderabad", "Password")}
//        };

        List<EntryForm> data= JsonUtils.readList("testdata/entry-form.json",
                new TypeReference<List<EntryForm>>() {});

        return data.stream().map(item -> new Object[]{item}).toArray(Object[][]::new);
    }

    @DataProvider(name = "restApiStatusCodes",parallel = false)
    public static Object[][] restApiStatusCodes() {
        List<HttpStausData> data= JsonUtils.readList("testdata/restApi.json",
                new TypeReference<List<HttpStausData>>() {});
        return data.stream().map(item -> new Object[]{item}).toArray(Object[][]::new);
    }

    public static HttpStausData getStatusDataByName(String name){
        List<HttpStausData> statusData = JsonUtils.readList("testdata/restApi.json",
                new TypeReference<List<HttpStausData>>() {});

        return statusData .stream().filter(data->data.getName().equalsIgnoreCase(name)).
                findFirst().orElseThrow(()-> new IllegalStateException("Status test data not found"+name));
    }
    
    public static HttpStausData get(HttpStatusType statusType)
    {
        return getStatusDataByName(statusType.getDataName());
    }



}
