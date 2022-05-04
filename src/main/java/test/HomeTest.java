package test;

import common.ShareDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.home.BookContentPage;
import pageobjects.home.HomePage;
import pageobjects.LoginPage;

public class HomeTest{
    private LoginPage loginPage;
    private HomePage homePage;
    private BookContentPage bookContentPage;

    @BeforeTest
    public void setUp() {
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
        this.bookContentPage = new BookContentPage();
    }

    @Parameters({"email", "password", "keySearch"})
    @Test
    public void wantToRead(String email, String password, String keySearch) {
        loginPage.login(email, password);
        homePage.searchAndSelectBook(keySearch);
        bookContentPage.clickWantToReadButton();
        bookContentPage.verifyWantToRead();
    }

    @AfterTest
    public void cleanUp() {
        ShareDriver.getDriver().quit();
    }
}
