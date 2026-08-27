package pages;

import io.qameta.allure.Description;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class TutorialPracticePage extends BasePage
{
    protected final Logger log4j=LogManager.getLogger(getClass());
    private final By titlePage=By.xpath("//header//div[2]");
    private final By fullNameInput = By.cssSelector("#fullname");
    private final By emailInput = By.cssSelector("#email");
    private final By currentAddressInput = By.cssSelector("#address");
    private final By passwordInput = By.cssSelector("#password");
    private final By submitButton = By.cssSelector("#TextForm input[type='submit']");
    private final By expectedMessage = By.cssSelector("//header//Span");
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

    @Description("Enter Full Name")
    public void enterFullName(String fullName)
    {
        log4j.info("Entering Full Name: " + fullName);
        elementActions.type(fullNameInput, fullName);
    }

    @Description("Enter Email")
    public void enterEmail(String email)
    {
        log4j.info("Entering Email: " + email);
        elementActions.type(emailInput, email);
    }

    @Description("Enter Current Address")
    public void enterCurrentAddress(String address)
    {
        log4j.info("Entering Current Address: " + address);
        elementActions.type(currentAddressInput, address);
    }

    @Description("Enter Password")
    public void enterPassword(String password)
    {
        log4j.info("Entering Password");
        elementActions.type(passwordInput, password);
    }

    @Description("Click Submit Button")
    public void clickSubmitButton()
    {
        log4j.info("Clicking Submit Button");
        elementActions.click(submitButton);
    }

    @Description("Get Expected Message")
    public void getExpectedMessage()
    {
        log4j.info("Get Expected Message");
        elementActions.getText(expectedMessage);
    }
}
