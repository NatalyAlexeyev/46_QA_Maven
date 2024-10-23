package demoqa.elements;

import demoqa.core.TestBase;
import demoqa.pages.AddRemoveElementsPage;
import demoqa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public  class AddRemoveElementsTest extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).getAddRemoveElements().hideAds();
    }
    @Test
    public void addRemoveElementsTest() {
        new AddRemoveElementsPage(app.driver).clickAddButton();
        new AddRemoveElementsPage(app.driver).clickDeleteButton();
    }
}




