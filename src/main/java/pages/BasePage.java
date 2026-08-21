package pages;

import org.openqa.selenium.WebDriver;
import utils.ActionsUtils;
import utils.ElementActions;
import utils.JavaScriptUtils;
import utils.WaitUtils;


public abstract class BasePage {
    protected final WebDriver driver;
    protected final WaitUtils waitUtils;
    protected final ElementActions elementActions;
    protected final JavaScriptUtils javaScriptUtils;
    protected final ActionsUtils actionsUtils;

    public BasePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException(
                    "WebDriver cannot be null"
            );
        }
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        this.elementActions = new ElementActions(driver);
        this.javaScriptUtils=new JavaScriptUtils(driver);
        this.actionsUtils=new ActionsUtils(driver);
    }
}
