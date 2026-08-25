package pages;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import utils.ScreenshotUtils;
import io.qameta.allure.Step;

public class TutorialPracticePage extends BasePage
{
    protected final Logger log4j=LogManager.getLogger(getClass());
    private final By titlePage=By.xpath("//header//div[2]");

    public TutorialPracticePage(WebDriver driver) {
        super(driver);
    }

    @Description("Verify Tutorial Home Page")
    public String verifyTitlePage(String expTitle)
    {
        String titleOfPage = elementActions.getText(titlePage);
        log4j.info("Home Page Title: "+titleOfPage);
        Assert.assertEquals(titleOfPage,expTitle,"title is wrong");
//        ScreenshotUtils.capture(driver, "verify title page");
        return elementActions.getText(titlePage);
    }
}
