package demoqa.book_store;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.LoginPage;
import demoqa.pages.SidePage;
import demoqa.utils.LoginDateProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).getBookStore().hideAds();
        new SidePage(app.driver).selectLogin().hideAds();
    }


    @Test
    @Parameters({"username", "password"})
   public void loginPositiveTest(String username, String password) {
        new LoginPage(app.driver)
                .enterPersonalData(username, password)
                .clickOnLoginButton()
                .verifyUserName(username);
   }


}
