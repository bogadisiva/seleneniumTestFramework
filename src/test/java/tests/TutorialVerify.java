package tests;

import base.BaseTest;
import driver.DriverManager;
import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TutorialPracticePage;

public class TutorialVerify extends BaseTest {


    @Epic("Tutorial verify")
    @Feature("Feature tutorial verify")
    @Story("Tutorial Test Feature")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify Successful")

    @Test(dataProvider = "homePage")
    public void verifyTutorialVerify(String title){
        TutorialPracticePage tpp=new TutorialPracticePage(DriverManager.getDriver());
        System.out.println(tpp.verifyTitlePage(title));
    }

    @DataProvider(name = "homePage")
    public Object[][] homePage() {
        return new Object[][]{
                {"Siva"},
                {"Selenium - Automation Practice Form"}
        };
    }
}
