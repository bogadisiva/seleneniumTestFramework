package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TutorialPracticePage extends BasePage{
    private final By titlePage=By.xpath("//header//div[2]");

    public TutorialPracticePage(WebDriver driver) {
        super(driver);
    }
    public String verifyTitlePage()
    {
        return elementActions.getText(titlePage);
    }
}
