package tests;

import base.BaseTest;
import config.SecretManager;
import driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DemandCentralPage;
import pages.LoginPage;


public class WorkBenchLogin extends BaseTest {

    @Test
    public void verifyTitleAfterSuccessfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DemandCentralPage dcPage = new DemandCentralPage(DriverManager.getDriver());

        loginPage.enterUserName(SecretManager.getuserName());
        loginPage.clickNext();
        loginPage.enterPassword(SecretManager.getPassword());
        Thread.sleep(2000);
        loginPage.clickSignInButton();
        Thread.sleep(18000);

        String pageTitle = DriverManager.getDriver().getTitle();
        Assert.assertEquals(pageTitle, "Altimetrik Dex Workbench");

        dcPage.demandCentralTabButton();
        String demandCentralTitle = dcPage.getDemandCentralPageTitle();
        System.out.println(demandCentralTitle);
        Assert.assertEquals(demandCentralTitle, "Demand Central");
    }
}
