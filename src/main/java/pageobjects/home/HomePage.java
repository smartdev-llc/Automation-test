package pageobjects.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageobjects.GenericPage;

import java.util.List;

public class HomePage extends GenericPage {
    private final By TXT_SEARCH = By.id("com.goodreads:id/action_search");

    public void searchAndSelectBook(String searchKey) {
        fillInputField(TXT_SEARCH, searchKey);
        By SEARCH_RESULT = By.xpath("//android.widget.RelativeLayout[*[@resource-id='com.goodreads:id/book_title']]");
        List<WebElement> results = findList(SEARCH_RESULT);
        if (results.size() > 0) {
            clickElement(results.get(0));
        } else {
            Assert.fail("There aren't any books that match" + searchKey);
        }
    }

}
