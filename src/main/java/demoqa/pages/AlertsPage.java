package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage clickAlertWithTimer() {
        click(timerAlertButton);
        //clickWitJS(timerAlertButton, 0, 200);

        wait.until(ExpectedConditions.alertIsPresent())
                .accept();
        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPage clickOnConfirmButton() {
        //clickWitJS(confirmButton, 0, 300);
        click(confirmButton);
        return this;
    }

    //@FindBy

    public AlertsPage selectResult(String confirm) {
        if (confirm != null && confirm.equals("OK")) {
            driver.switchTo().alert().accept();
        } else if (confirm != null && confirm.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }else {
            System.out.println("error alert command!");
        }
        return this;
    }

    @FindBy(id="confirmResult")
    WebElement confirmResult;

    public AlertsPage verifyResult(String result) {
        shoulHaveText(confirmResult, result,5000);
        return this;
    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage clickOnPromtButton() {
        //clickWitJS(promtButton, 0, 400);
        click(promtButton);
        //click(promtButton);
        return this;
    }

    public AlertsPage sendTextToAlert(String textToFind) {
        driver.switchTo().alert().sendKeys(textToFind);
        driver.switchTo().alert().accept();

        return this;
    }

    @FindBy(id = "promptResult")
    WebElement promptResult;

    public AlertsPage verifyAlertText(String textToFind) {
        shoulHaveText(promptResult, textToFind,5000);
        assert promptResult.getText().contains(textToFind);
        return this;
    }
}
