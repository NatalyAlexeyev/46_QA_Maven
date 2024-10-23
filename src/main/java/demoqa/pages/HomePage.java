package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".top-card:nth-child(6)")
    WebElement bookStore;

    public SidePage getBookStore() {
        click(bookStore);
       // scrollToElement(bookStore);
       // clickWitJS(bookStore, 0, 600);
       // clickWitJS(bookStore, 0, 600);
        return new SidePage(driver);
    }

    @FindBy(css = ".top-card:nth-child(3)")
    WebElement alertsFrameWindow;

    public BasePage getAlertsFrameWindow() {
        click(alertsFrameWindow);
       // clickWitJS(alertsFrameWindow, 0, 300);
        return new SidePage(driver);
    }
    @FindBy(css = ".top-card:nth-child(4)")
    WebElement widgets;

    public BasePage getWidgets() {
       // scrollTo(300);
        click(widgets);
       // clickWitJS(widgets, 0, 300);
        return new SidePage(driver);
    }

    @FindBy(css = ".top-card:nth-child(1)")
    WebElement elements;

    public BasePage getElements() {
        click(elements);
        return new SidePage(driver);
    }
    @FindBy(css = ".top-card:nth-child(2)")
    WebElement forms;
    public BasePage getForms() {
        click(forms);
        return new SidePage(driver);
    }
    @FindBy(css = ".top-card:nth-child(5)")
    WebElement practiceForm;

    public AddRemoveElementsPage getAddRemoveElements() {
        click(bookStore);
        return new AddRemoveElementsPage(driver);
    }
}
