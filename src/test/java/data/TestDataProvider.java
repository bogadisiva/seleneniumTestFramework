package data;

import com.fasterxml.jackson.core.type.TypeReference;
import model.EntryForm;
import org.openqa.selenium.devtools.latest.domstorage.model.Item;
import org.testng.annotations.DataProvider;
import utils.JsonUtils;

import java.util.List;

public class TestDataProvider {

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
}
