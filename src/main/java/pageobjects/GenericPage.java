package pageobjects;

import org.openqa.selenium.By;
import pageobjects.BasePage;

public class GenericPage extends BasePage {
    private final By BACK_BUTTON = By.xpath("(//android.widget.ImageButton[@content-desc=\"Navigate up\"])[1]");

    public  void backToPreviousPage() {
        clickElement(BACK_BUTTON);
    }
}
