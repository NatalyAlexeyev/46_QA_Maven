package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonsPage extends BasePage {
    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "doubleClickBtn")
    WebElement doubleClickButton;

    public ButtonsPage doubleClick() {
        new Actions(driver).doubleClick(doubleClickButton).perform();
        return this;
    }

    @FindBy(id = "doubleClickMessage")
    WebElement doubleClickMessage;

    public ButtonsPage verifyDoubleClickMessage(String textToFind) {
        shoulHaveText(doubleClickMessage, textToFind, 2000);
        assert doubleClickMessage.getText().equalsIgnoreCase(textToFind);
        return this;
    }

    @FindBy(id = "rightClickBtn")
    WebElement rightClickBtn;

    public ButtonsPage rightClickButton() throws InterruptedException {
       Thread.sleep(2000);
       scrollTo(300);
        new Actions(driver).contextClick(rightClickBtn).perform();
        return this;
    }

    @FindBy(id = "rightClickMessage")
    WebElement rightClickMessage;

    public ButtonsPage verifyRightClickMessage(String textToFind) {
        shoulHaveText(rightClickMessage, textToFind, 2000);
        assert rightClickMessage.getText().equalsIgnoreCase(textToFind);
        return this;
    }

    @FindBy(xpath = "//button[text()='Click Me']")
    WebElement dynamicClickButton;
    public ButtonsPage dynamicClickButton() {
        scrollTo(300);
        click(dynamicClickButton);
        return this;
    }
    @FindBy(id = "dynamicClickMessage")
    WebElement dynamicClickMessage;

    public ButtonsPage verifyDynamicClickMessage(String textToFind) {
        shoulHaveText(dynamicClickMessage, textToFind, 2000);
        assert dynamicClickMessage.getText().equalsIgnoreCase(textToFind);
        return this;
    }
}
