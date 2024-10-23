package demoqa.pages;

import demoqa.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    WebElement firstNameInput;
    @FindBy(id = "lastName")
    WebElement lastNameInput;
    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userNumber")
    WebElement userNumber;

    public PracticeFormPage enterPersonalData(String firstName, String lastName, String email, String number) {
        type(firstNameInput, firstName);
        type(lastNameInput, lastName);
        type(userEmail, email);
        type(userNumber, number);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        try {
            //Нажимает на пол
            String xpathGender = "//label[contains(text(),'" + gender + "')]";
            //Поиск элемента по XPath
            WebElement genderLocator = driver.findElement(By.xpath(xpathGender));
            //Нажимает на элемент
            click(genderLocator);
        } catch (NoSuchElementException e) {
            //Если элемент не найден, выводим сообщение об ошибке
            System.out.println("Gender element not found: [" + gender + "]");
            throw new RuntimeException(e);
        } catch (Exception e) {
            //Если происходит другая ошибка, выводим сообщение об ошибке
            System.out.println("Error selecting gender: [" + gender + "]");
            throw new RuntimeException(e);
        }
        return this;
    }

    @FindBy(css = ".react-datepicker__month-select")
    WebElement monthSelect;
    @FindBy(css = ".react-datepicker__year-select")
    WebElement yearSelect;
    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput;

    public PracticeFormPage chooseDate(String day, String month, String year) {
        //Выбирает дату
        click(dateOfBirthInput);
        //Выбирает месяц
        new Select(monthSelect).selectByVisibleText(month);
        //Выбирает год
        new Select(yearSelect).selectByVisibleText(year);
        //Выбирает день
        driver.findElement(By.xpath("//div[@class='react-datepicker__week']//div[.='" + day + "']")).click();
        return this;
    }

    @FindBy(id = "subjectsInput")
    WebElement subjectsInput;

    public PracticeFormPage enterSubject(String[] subjects) {
        //Вводит предметы
        for (String subject : subjects) {
            //Проверяет, что значение не равно null
            if (subject != null) {
                //Вводит значение в поле
                type(subjectsInput, subject);
                //Нажимает клавишу Enter после ввода значения в поле
                subjectsInput.sendKeys(Keys.ENTER);
            }
        }
        return this;
    }

    public PracticeFormPage chooseHobbies(String[] hobbies) {
        //Выбирает хобби
        for (String hobby : hobbies) {
            try {
                //Нажимает на хобби
                driver.findElement(By.xpath("//label[.='" + hobby + "']")).click();
            } catch (Exception e) {
                //Если хобби не найдено, выводим сообщение об ошибке
                System.out.println("Error selecting hobbies: [" + hobby + "]");
                throw new RuntimeException(e);
            }

        }
        return this;
    }

    @FindBy(id = "uploadPicture")
    WebElement uploadPicture;

    public PracticeFormPage uploadPicture(String imgPath) {
        //Загружает изображение
        uploadPicture.sendKeys(imgPath);
        return this;
    }

    @FindBy(id = "currentAddress")
    WebElement currentAddress;

    public PracticeFormPage enterCurrentAddress(String address) {
        //Вводим адрес
        type(currentAddress, address);
        return this;
    }

    @FindBy(id = "state")
    WebElement stateContainer;

    @FindBy(id = "react-select-3-input")
    WebElement stateInput;

    public PracticeFormPage enterState(String state) {
        //Нажимает на контейнер
        click(stateContainer);
        //Вводит значение в поле
        stateInput.sendKeys(state);
        //Нажимает клавишу Enter после ввода значения в поле
        stateInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirthInput1;
    @FindBy(className = "react-datepicker__month-select")
    WebElement monthSelect1;
    @FindBy(className = "react-datepicker__year-select")
    WebElement yearSelect1;

    public PracticeFormPage chooseDateAsString(String dateString) {
//        click(dateOfBirthInput);
//        String os = System.getProperty("os.name");
//        //type(dateOfBirthInput,date);
//        if(os.contains("Mac")){
//            dateOfBirthInput.sendKeys(Keys.COMMAND, "a");
//        } else {
//            dateOfBirthInput.sendKeys(Keys.CONTROL, "a");
//        }
//        dateOfBirthInput.sendKeys(date);
//        dateOfBirthInput.sendKeys(Keys.ENTER);
//        return this;
        // Разделить строку даты на день, месяц и год
        click(dateOfBirthInput1);
        String[] dateParts = dateString.split(" ");
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];
        //Вызов существующего метода ChooseDate
        chooseDate(day, month, year);

        return this;
    }

    @FindBy(id = "city")
    WebElement cityContainer;

    @FindBy(id = "react-select-4-input")
    WebElement cityInput;

    public PracticeFormPage enterCity(String city) {
        //Нажимает на контейнер
        click(cityContainer);
        //Вводит значение в поле
        cityInput.sendKeys(city);
        //Нажимает клавишу Enter после ввода значения в поле
        cityInput.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(id = "submit")
    WebElement submitButton;

    public PracticeFormPage submitForm() {
        //Нажимает на кнопку
        click(submitButton);
        return this;
    }

    @FindBy(css = "#example-modal-sizes-title-lg")
    WebElement modalTitle;

    public PracticeFormPage verifySuccessRegistration(String expectedMessage) {
        //Подождите, пока появится модальное окно
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#example-modal-sizes-title-lg")));
        // Проверьте сообщение об успехе
        scrollWithPageDown(5);
        shoulHaveText(modalTitle, expectedMessage, 5000);
        return this;
    }

}
