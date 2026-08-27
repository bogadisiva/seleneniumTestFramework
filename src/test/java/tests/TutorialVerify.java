package tests;

import base.BaseTest;
import data.TestDataProvider;
import driver.DriverManager;
import io.qameta.allure.*;
import model.EntryForm;
import org.testng.annotations.Test;
import pages.TutorialPracticePage;

public class TutorialVerify extends BaseTest {



    @Epic("Tutorial verify")
    @Feature("Feature tutorial verify")
    @Story("Tutorial Test Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Successful")
    @Test(dataProvider = "entryForm", dataProviderClass = TestDataProvider.class)
    public void verifyTutorialVerify(EntryForm data){
        TutorialPracticePage tpp=new TutorialPracticePage(DriverManager.getDriver());
        System.out.println(tpp.verifyTitlePage(data.getTitle()));
//        tpp.getExpectedMessage();
        tpp.enterFullName(data.getFullName());
        tpp.enterEmail(data.getEmail());
        tpp.enterCurrentAddress(data.getAddress());
        tpp.enterPassword(data.getPassword());
        tpp.clickSubmitButton();

    }
}
