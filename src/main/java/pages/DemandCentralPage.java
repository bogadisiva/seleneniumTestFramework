package pages;

import config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DemandCentralPage extends BasePage {

    private final By demandCentralTab= By.xpath("//span[text()='Demand Central']/ancestor::li/span");
    public DemandCentralPage(WebDriver driver)
    {
        super(driver);

    }
    public void demandCentralTabButton()
    {
       elementActions.click(demandCentralTab);
    }
    public String getDemandCentralPageTitle()
    {
        String demandCentralTitle=null;
        demandCentralTitle=elementActions.getText(demandCentralTab);
        return demandCentralTitle;
    }
}
