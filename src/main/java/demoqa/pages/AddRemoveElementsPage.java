package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddRemoveElementsPage extends BasePage {
    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[text()='Add Element']")

    WebElement addElementButton;
    @FindBy(xpath = "//button[text()='Delete']")
    WebElement deleteElementButton;

    public void clickAddButton() {

        click(addElementButton);
    }
    public void clickDeleteButton() {

        click(deleteElementButton);
    }
}
