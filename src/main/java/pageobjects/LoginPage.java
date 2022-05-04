package pageobjects;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final By LNK_LOGIN = By.id("com.goodreads:id/sign_in_button");
    private final By TXT_EMAIL = By.id("com.goodreads:id/email");
    private final By TXT_PASSWORD = By.id("com.goodreads:id/password");
    private final By BTN_LOGIN = By.id("com.goodreads:id/login_button");
    private final By MESSSAGE = By.id("android:id/message");

    public void login(String email, String password) {
        clickElement(LNK_LOGIN);
        fillInputField(TXT_EMAIL, email);
        fillInputField(TXT_PASSWORD, password);
        clickElement(BTN_LOGIN);
        waitForInvisibilityOfElement(MESSSAGE);
    }
}
