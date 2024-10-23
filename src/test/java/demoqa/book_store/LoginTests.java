package demoqa.book_store;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import demoqa.pages.SidePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).getBookStore().hideAds();
        new SidePage(app.driver).selectLogin().hideAds();
    }


    @Test(invocationCount = 1)
    public void loginPositiveTest() {
        new LoginPage(app.driver)
                .enterPersonalData("Sofya", "!Milka_04")
                .clickOnLoginButton()
                .verifyUserName("Sofya");
    }


}
