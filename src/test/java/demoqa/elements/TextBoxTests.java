package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.TextBoxPage;
import demoqa.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class TextBoxTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getElements().hideAds();
        new SidePage(app.driver).selectTextBox().hideAds();
    }

    @Test
    public void keyboardEventTest() {
        try {
            new TextBoxPage(app.driver)
                    .enterPersonalData("Name", "email@gmail.com", "address sfdsf sfs sfsf dddd")
                    .keyboardEvent()
                    .verifyCopyPasteAddress();
        } catch (AWTException e) {
            System.err.println("AWTException occurred: " + e.getMessage());
            Assert.fail("Keyboard event failed due to AWTException");
        }
    }

    //    public void keyboardEventTest() {
    //        new TextBoxPage(driver)
    //                .enterPersonalData("Name", "email@gmail.com", "address sfdsf sfs sfsf dddd")
    //                .keyboardEvent()
    //                .verifyCopyPasteAddress();
    //    }

    @Test(dataProvider = "addNewUserFormFormCSVFile", dataProviderClass = DataProviders.class)
    public void keyboardEventDataProviderTest(String firstName, String email, String address) throws AWTException {
        new TextBoxPage(app.driver)
                .enterPersonalData(firstName, email, address)
                .keyboardEvent()
                .verifyCopyPasteAddress();
    }
}

