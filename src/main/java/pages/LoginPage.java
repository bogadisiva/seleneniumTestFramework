package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    private final By usernameField =
            By.name("loginfmt");

    private final By nextButton =
            By.id("idSIButton9");

    private final By passwordField =
            By.name("passwd");

    private final By signInButton =
            By.id("idSIButton9");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterUserName(String userName) {
        elementActions.type(usernameField, userName);
    }

    public void clickNext() {
        elementActions.click(nextButton);
    }

    public void enterPassword(String passwrd) {
        elementActions.type(passwordField, passwrd);
    }

    public void clickSignInButton() throws InterruptedException {
        elementActions.click(signInButton);
        Thread.sleep(18000);
    }
}
