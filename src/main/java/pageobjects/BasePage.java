package pageobjects;

import common.ShareDriver;
import helper.Waiter;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected AndroidDriver driver = ShareDriver.getDriver();
    private static final long DEFAULT_TIMEOUT_IN_SECONDS = 30;
    private static final long SLEEP_IN_MS = 200;

    protected WebElement find(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_IN_SECONDS), Duration.ofMillis(SLEEP_IN_MS))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> findList(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_IN_SECONDS), Duration.ofMillis(SLEEP_IN_MS))
            .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected WebElement find(By locator, long timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds), Duration.ofMillis(SLEEP_IN_MS))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public BasePage clickElement(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_IN_SECONDS), Duration.ofMillis(SLEEP_IN_MS))
            .until(ExpectedConditions.elementToBeClickable(locator))
            .click();
        return this;
    }

    public BasePage clickElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_IN_SECONDS), Duration.ofMillis(SLEEP_IN_MS))
            .until(ExpectedConditions.elementToBeClickable(element))
            .click();
        return this;
    }

    protected void fillInputField(By locator, String input) {
        find(locator, DEFAULT_TIMEOUT_IN_SECONDS)
            .sendKeys(input);
    }

    public void waitForInvisibilityOfElement(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_IN_SECONDS), Duration.ofMillis(SLEEP_IN_MS))
            .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean isElementVisible(By locator) {
        final int MAX_ATTEMPTS = 5;
        int RETRY_COUNTER = 0;
        while (RETRY_COUNTER < MAX_ATTEMPTS) {
            try {
                return find(locator, DEFAULT_TIMEOUT_IN_SECONDS)
                    .isDisplayed();
            } catch (StaleElementReferenceException e) {
            } catch (TimeoutException e) {
                return false;
            }
            RETRY_COUNTER++;
            Waiter.waitWithThreadInterrupt(1000);
        }
        return false;
    }

}
