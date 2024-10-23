package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePage extends BasePage {
    public SidePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement login;

    public LoginPage selectLogin() {
        click(login);
        //clickWitJS(login, 0, 600);
        return new LoginPage(driver);
    }

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alerts;

    public AlertsPage selectAlerts() {
        click(alerts);
        //  clickWitJS(alerts, 0, 300);
        return new AlertsPage(driver);
    }

    @FindBy(xpath = "//span[.='Select Menu']")
    WebElement selectMenu;

    public WidgetsPage selectSelectMenu() {
        click(selectMenu);
        //  clickWitJS(selectMenu, 0, 300);
        return new WidgetsPage(driver);
    }

    //* BrowserWindows
    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindows;

    public BasePage selectBrowserWindows() {
        click(browserWindows);
        return this;
    }

    @FindBy(xpath = "//span[.='Buttons']")
    WebElement buttons;

    public BasePage selectButtons() {
        click(buttons);
        return new ButtonsPage(driver);
    }

    @FindBy(id = "item-0")
    WebElement textBox;

    public TextBoxPage selectTextBox() {
        click(textBox);
        return new TextBoxPage(driver);
    }
    @FindBy(xpath = "//span[.='Practice Form']")
    WebElement practiceForm;

    public PracticeFormPage selectPracticeForm() {
        click(practiceForm);
        return new PracticeFormPage(driver);
    }
    @FindBy(xpath = "//span[.='Auto Complete']")
    WebElement autoCompleteMenu;

    public AutoCompletePage selectAutoCompleteMenu() {
        click(autoCompleteMenu);
        return new AutoCompletePage(driver);
    }

    @FindBy(xpath = "//span[.='Broken Links - Images']")
    WebElement brokenLinksImages;

    public BrokenLinksImagesPage selectBrokenLinksImages() {
        click(brokenLinksImages);
        return new BrokenLinksImagesPage(driver);
    }

}
