package Pages;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.Select;


import java.util.stream.Stream;

public class SendAppPage extends BasePage {

    @FindBy(id = "surname_vzr_ins_0")
    public WebElement clientSurName;

    @FindBy(id = "name_vzr_ins_0")
    public WebElement clientName;

    @FindBy(id = "birthDate_vzr_ins_0")
    public WebElement clientBirthDate;

    @FindBy(id = "person_lastName")
    public WebElement insLastName;

    @FindBy(id = "person_firstName")
    public WebElement insFirstName;

    @FindBy(id = "person_middleName")
    public WebElement insMiddleName;

    @FindBy(id = "person_birthDate")
    public WebElement insBirthDate;

    @FindBy(xpath = "//*[text() = 'Женский']")
    public WebElement gender;

    @FindBy(id = "passportSeries")
    public WebElement passportSeries;

    @FindBy(id = "passportNumber")
    public WebElement passportNumber;

    @FindBy(id = "documentDate")
    public WebElement documentDate;

    @FindBy(id = "documentIssue")
    public WebElement documentIssue;

    @FindBy(xpath = "//*[@type = 'submit']")
    public WebElement submitButton;

    public SendAppPage(WebDriver driver){
        PageFactory.initElements(driver, this);
//        (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.visibilityOf(title));
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

        public void fillFielder(String fieldName, String value) {
            switch (fieldName){
                case "Фамилия / Surname":
                    fillField(clientSurName);
                    break;
                case "Имя / Name":
                    fillField(clientName);
                    break;
                case "Дата рождения":
                    fillField(clientBirthDate);
                    break;
                case "Фамилия":
                    fillField(insFirstName);
                    break;
                case "Имя":
                    fillField(insLastName);
                    break;
                case "Отчество":
                    fillField(insMiddleName);
                    break;
                case "Дата рождения":
                    fillField(insBirthDate);
                    break;
                case "Пол":
                    fillField(gender);
                    break;
                case "Номер паспорта":
                    fillField(passportNumber);
                    break;
                case "Серия паспорта":
                    fillField(passportSeries);
                    break;
                case "Дата выдачи":
                    fillField(documentDate);
                    break;
                case "Кем выдан ":
                    fillField(documentIssue);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + fieldName);
            }

        }

        //Что должно делать?
        public String getFillField(String fieldName){
            switch (fieldName){
                case  "Фамилия":
                    return lastName.getAttribute("value");
                case  "Имя":
                    return firstName.getAttribute("value");
                case  "Отчество":
                    return middleName.getAttribute("value");
                case  "Телефон":
                    return phone.getAttribute("value");
                case  "Регион":
                    return new Select(region).getAllSelectedOptions().get(0).getText();
                case  "Эл. почта":
                    return email.getAttribute("value");
                case  "Комментарии":
                    return comment.getAttribute("value");
                case  "Дата контакта":
                    return contactDate.getAttribute("value");
            }
            throw new AssertionError("Поле не объявлено на странице");
        }

    public void checkFieldErrorMessage(String field, String errorMessage){
        String xpath = "//*[text()='"+ field +"']/..//*[@class = 'invalid-validate form-control__message']";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        org.junit.Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage),
                actualValue.contains(errorMessage));
    }

}
