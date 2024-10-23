package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinksImagesTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new HomePage(app.driver).getElements().hideAds();
        new SidePage(app.driver).selectBrokenLinksImages().hideAds();
    }

    @Test
    public void brokenLinksTest() {
        new BrokenLinksImagesPage(app.driver)
                .checkBrokenLinksImages();
    }


    public static class ButtonsTests extends TestBase {
        @BeforeMethod
        public void precondition() {
            new HomePage(app.driver).getElements().hideAds();
            new SidePage(app.driver).selectButtons().hideAds();

        }

        @Test
        public void doubleClickButtonsTest() {
            new ButtonsPage(app.driver)
                    .doubleClick()
                    .verifyDoubleClickMessage("You have done a double click");
        }

        @Test
        public void rightClickButtonsTest() throws InterruptedException {
            new ButtonsPage(app.driver)
                    .rightClickButton()
                    .verifyRightClickMessage("You have done a right click");
        }

        @Test(invocationCount = 2)
        public void dynamicClickButtonsTest() {
            new ButtonsPage(app.driver)
                    .dynamicClickButton()
                    .verifyDynamicClickMessage("You have done a dynamic click");
        }
    }
}
