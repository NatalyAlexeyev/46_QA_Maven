package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.*;

import static org.testng.Assert.assertTrue;

public class WidgetsPage extends BasePage {
    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "oldSelectMenu")
    WebElement oldStyleSelectMenu;

    public WidgetsPage selectOldStyle(String color) {
        Select select = new Select(oldStyleSelectMenu);
        select.selectByVisibleText(color);
        return this;
    }


//    @FindBy(css = "html")
//    WebElement space;

    //* MultiSelectMenu
    @FindBy(id = "react-select-4-input")
    WebElement inputSelect;

    public WidgetsPage multiSelect(String[] colors) {
        for (String color : colors) {
            if (color != null) {
                inputSelect.sendKeys(color);
                inputSelect.sendKeys(Keys.ENTER);
            }
            inputSelect.sendKeys(Keys.ESCAPE);
//            click(space);
        }
        return this;
    }

    @FindBy(xpath = "//select[@id='cars']")
    WebElement selectCars;

    public WidgetsPage multiCarSelect(String car) {
        Select select = new Select(selectCars);
        select.selectByVisibleText(car);
        return this;
    }

    @FindBy(className = "css-12jo7m5")
    List<WebElement> selectedColorsElements;

    public boolean areColorsSelected(String[] colors) {
        List<String> selectedText = new ArrayList<>();
        for (WebElement element : selectedColorsElements) {
            selectedText.add(element.getText());
        }
        for (String color : colors) {
            if (!selectedText.contains(color)) {
                return false;
            }
        }
        return true;
    }

    @FindBy(id = "cars")
    WebElement carsSelect;

    public boolean areCarsSelected(String cars) {
        return carsSelect.getText().contains(cars);
    }

    public WidgetsPage verifyColorSelected(String[] colorsSelect) {
        assertTrue(new WidgetsPage(driver).areColorsSelected(colorsSelect));
        return this;
    }

    public WidgetsPage verifyCarsSelected(String carsSelect) {
        assertTrue(new WidgetsPage(driver).areCarsSelected(carsSelect));
        return this;
    }


    @FindBy(xpath = "//select[@id='cars']")
    WebElement selectCars1;

    public WidgetsPage multiCarSelect(String[] cars) {
        Select select = new Select(selectCars1);
        for (String car : cars) {
            select.selectByVisibleText(car);
        }
        return this;
    }

    @FindBy(id = "cars")
    WebElement carsSelect1;

    public boolean areCarsSelected(String[] cars) {
        List<String> selectedOptions = new ArrayList<>();
        for (WebElement option : new Select(carsSelect1).getAllSelectedOptions()) {
            selectedOptions.add(option.getText());
        }
        for (String car : cars) {
            if (!selectedOptions.contains(car)) {
                return false;
            }
        }
        return true;
    }

    public WidgetsPage verifyCarsSelected(String[] carsSelect) {
        assertTrue(areCarsSelected(carsSelect));
        return this;
    }

    @FindBy(id = "cars")
    WebElement cars;

    public WidgetsPage standardMultiSelectByIndex(int index) {
        Select select = new Select(cars);
        if (select.isMultiple()) {
            select.selectByIndex(index);
        }
        List<WebElement> options = select.getOptions();
        String selectedText = options.get(index).getText();
        System.out.println(selectedText);
        return this;
    }

    public WidgetsPage verifyByIndex(int index) {
        Select select = new Select(cars);
        List<WebElement> options = select.getOptions();
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        String selectedText = options.get(index).getText();
        boolean textFound = false;
        for (WebElement element : selectedOptions) {
            if (element.getText().equals(selectedText)) {
                textFound = true;
                break;

            }
        }
        System.out.println(selectedText);
        Assert.assertTrue(textFound); //Assert
        return this;
    }

    public WidgetsPage standardMultiSelectByCars(String[] car) {
        Select select = new Select(cars);
        if (select.isMultiple()) {
            for (String element : car) {
                select.selectByVisibleText(element);
            }
        }
        return this;
    }

    public WidgetsPage verifyMultiSelectedByCars(String[] expected) {
        Select select = new Select(cars);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        List<String> selectedText = new ArrayList<>();

        for (WebElement option : selectedOptions) {
            selectedText.add(option.getText());
        }
        List<String> expectedText = Arrays.asList(expected);

        assert new HashSet<>(selectedText).containsAll(expectedText);

        return this;
    }
}
