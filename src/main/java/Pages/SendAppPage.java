package Pages;

import org.junit.Assert;
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
        this.driver = driver;
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

        public void fillField(String fieldName, String value) {
            switch (fieldName) {
                case "Фамилия / Surname":
                    fillField(clientSurName, "Иванов");
                    break;
                case "Имя / Name":
                    fillField(clientName, "Иван");
                    break;
                case "Дата рождения" :
                    fillField(clientBirthDate, "29.01.2000");
                    break;
                case "Фамилия" :
                    fillField(insFirstName, "Страховщиков");
                    break;
                case "Имя" :
                    fillField(insLastName, "Страховщик");
                    break;
                case "Отчество" :
                    fillField(insMiddleName, "Страховщикович");
                    break;
                    // java: duplicate case label
//                case "Дата рождения" :
//                    fillField(insBirthDate, "30.12.1999");
//                    break;
                case "Пол" :
                    fillField(gender, "male");
                    break;
                case "Номер паспорта" :
                    fillField(passportNumber, "45 19");
                    break;
                case "Серия паспорта" :
                    fillField(passportSeries, "200000");
                    break;
                case "Дата выдачи" :
                    fillField(documentDate, "01.01.2020");
                    break;
                case "Кем выдан" :
                    fillField(documentIssue, "ТП УФМС РОССИИ");
                    break;
                default :
                    throw new IllegalStateException("Unexpected value: " + fieldName);
            }
        }

        //Что должно делать?
        public String getFillField(String fieldName){
            switch (fieldName){
                case  "Фамилия / Surname":
                    return clientSurName.getAttribute("value");
                case  "Имя / Name":
                    return clientName.getAttribute("value");
                case  "Дата рождения":
                    return clientBirthDate.getAttribute("value");
                case  "Фамилия":
                    return insFirstName.getAttribute("value");
                case  "Имя":
                    return insLastName.getAttribute("value");
                case  "Отчество":
                    return insMiddleName.getAttribute("value");
                case  "Пол":
                    return gender.getAttribute("value");
                case  "Номер паспорта":
                    return passportNumber.getAttribute("value");
                case "Серия паспорта":
                    return passportSeries.getAttribute("value");
                case "Дата выдачи":
                    return documentDate.getAttribute("value");
                case "Кем выдан":
                    return documentIssue.getAttribute("value");
            }
            throw new AssertionError("Поле не объявлено на странице");
        }

    public void checkPageErrorMessage(){
        String xpath = "//*[@class = 'alert-form alert-form-error']";
        String expectedValue = "При заполнении данных произошла ошибка";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        Assert.assertEquals(expectedValue,actualValue);
    }

    public void checkFieldErrorMessage(){
        String xpath = "//span[contains(@class,'invalid-validate form-control__message')]/..//span[contains(text(),'Поле не заполнено.')]";
        String expectedValue = "Поле не заполнено.";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        Assert.assertEquals(expectedValue,actualValue);
        //span[contains(@class,'invalid-validate form-control__message')]/../li//span[contains(text(),'Поле')]
    }
}
