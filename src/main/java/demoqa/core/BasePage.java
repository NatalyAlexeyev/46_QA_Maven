package demoqa.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);

    }

    protected void scrollWithPageDown(int count){
        try {
            Robot robot = new Robot();
            for(int i = 0; i < count; i++){
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
                robot.delay(100);
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    protected void click(WebElement element) {
        scrollToElement(element);
        element.click();
        //  logger.info("[{}] and {} is pressed", locator, locator);
    }

    public void hideAds() {
        js.executeScript("document.getElementById('adplus-anchor').style.display='none';");
        js.executeScript("document.querySelector('footer').style.display='none';");
    }

    protected void type(WebElement element, String text) {
        if (text != null) {
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    protected void typeScrollWithJS(WebElement element, String text, int y) {
        if (text != null) {
            click(element);
            // clickWitJS(element, 0, y);
            element.clear();
            element.sendKeys(text);
        }
    }

    protected void scrollTo(int y) {
        js.executeScript("window.scrollBy(" + 0 + "," + y + ")");
    }

    public void scrollToElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void clickWitJS(WebElement element, int x, int y) {
        //window.scrollBy(0, 100);
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        //js.executeScript("window.scrollBy({},{})",x,y);
        click(element);
    }

    protected void shoulHaveText(WebElement element, String text, int teimout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(teimout));
        try {
            boolean isTextPresent = wait.until(ExpectedConditions.textToBePresentInElement(element, text));
            //String actualText = element.getText();
            Assert.assertTrue(isTextPresent,
                    "Expected text: [" + text + "], actual text: [" + element.getText() + "] in element: [" + element + "]");
        } catch (TimeoutException e) {
            throw new TimeoutException(e);
        }

    }

    public void selectFromDropdown(WebElement element, String visibleText) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(visibleText);
    }

    public void verifyLink(String urlToCheck) {
        try {
            URL url = new URL(urlToCheck);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(3000);
            connection.connect();
            //Получаем код ответа
            int responseCode = connection.getResponseCode();
           //
            String responseMessage = connection.getResponseMessage();

            if (responseCode >= 400) {
                // broken link
                System.err.println("URL to check: [" + urlToCheck + "], " + "response code: [" + responseCode + "], " + "response message: [" + responseMessage + "] is broken link");
            } else {
                // correct link
                System.out.println("URL to check: [" + urlToCheck + "], " + "response code: [" + responseCode + "], " + "response message: [" + responseMessage + "] is valid link");
            }

        } catch (MalformedURLException error) {
            System.err.println("Error: Malformed URL: ["+urlToCheck+"], error message: [" + error.getMessage()+"]");
            //throw new RuntimeException(e);
        } catch (IOException error) {
            System.err.println("Error occurred: ["+error.getMessage()+"] for URL: [" + urlToCheck +"]");
            //throw new RuntimeException(e);
        }
    }
}
