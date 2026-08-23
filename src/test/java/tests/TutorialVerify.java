package tests;

import base.BaseTest;
import driver.DriverManager;
import org.testng.annotations.Test;
import pages.TutorialPracticePage;

public class TutorialVerify extends BaseTest {

    @Test
    public void verifyTutorialVerify(){
        TutorialPracticePage tpp=new TutorialPracticePage(DriverManager.getDriver());
        System.out.println(tpp.verifyTitlePage());
    }
}
