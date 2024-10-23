package demoqa.widgets;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePage;
import demoqa.pages.WidgetsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        new HomePage(app.driver).getWidgets().hideAds();
        new SidePage(app.driver).selectSelectMenu().hideAds();
    }

    @Test
    public void oldStyleSelectMenuTest() {
        new WidgetsPage(app.driver)
                .selectOldStyle("Indigo");
    }

    @Test
    public void multiSelectTest() {
        String[] colorsSelect = {"Green", "Blue"};
        new WidgetsPage(app.driver)
                .multiSelect(colorsSelect)
                .verifyColorSelected(colorsSelect);
    }

    @Test
    public void multiSelectTest1() {
        String car = "Audi";//{, "Audi"};
        new WidgetsPage(app.driver)
                .multiCarSelect(car)
                .verifyCarsSelected(car);
    }

    @Test
    public void multiCarSelectTest2() {
        String[] carsSelect1 = {"Volvo", "Audi"};
        new WidgetsPage(app.driver)
                .multiCarSelect(carsSelect1)
                .verifyCarsSelected(carsSelect1);
    }

    @Test
    public void standardMultiSelectByIndexTest() {
        new WidgetsPage(app.driver)
                .standardMultiSelectByIndex(2)
                .verifyByIndex(2);
    }

    @Test
    public void standardMultiSelectByCarsTest1() {
        String[] cars = {"Volvo", "Opel","Saab"};
        new WidgetsPage(app.driver)
                .standardMultiSelectByCars(cars)
                .verifyMultiSelectedByCars(cars);
    }

}
