package pageobjects.home;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageobjects.GenericPage;

public class BookContentPage extends GenericPage {
    private By BUTTON_WANT_TO_READ = By.id("com.goodreads:id/wtr_unshelvedStatus");
    private By BUTTON_WANT_TO_READ_SELECTED = By.id("com.goodreads:id/wtr_shelvedStatus");

    public void clickWantToReadButton() {
        if (isElementVisible(BUTTON_WANT_TO_READ)) {
            clickElement(BUTTON_WANT_TO_READ);
        }
    }

    public void verifyWantToRead() {
        Assert.assertTrue(isElementVisible(BUTTON_WANT_TO_READ_SELECTED), "Want to read is selected");
        clickElement(BUTTON_WANT_TO_READ_SELECTED);
        Assert.assertTrue(isElementVisible(By.xpath("//android.widget.TextView[@text='Add to My Books']")), "Add to My Books modal is displayed");
    }
}
