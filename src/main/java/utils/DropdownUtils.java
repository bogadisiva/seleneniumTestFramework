package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownUtils {
    public void selectByVisibleText(
            WebElement element,
            String text
    ) {
        new Select(element)
                .selectByVisibleText(text);
    }

    public void selectByValue(
            WebElement element,
            String value
    ) {
        new Select(element)
                .selectByValue(value);
    }

    public void selectByIndex(
            WebElement element,
            int index
    ) {
        new Select(element)
                .selectByIndex(index);
    }
}
