package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    public WebElement femGender;

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
        this.driver = driver;
    }

    public void pressFemaleGenderButton(){
        femGender.click();
    }

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

        public void fillField(String fieldName, String value) {
            switch (fieldName) {
                case "Фамилия / Surname":
                    fillField(clientSurName, value);
                    break;
                case "Имя / Name":
                    fillField(clientName, value);
                    break;
                case "Дата рождения" :
                    fillField(clientBirthDate, value);
                    break;
                case "Фамилия" :
                    fillField(insLastName, value);
                    break;
                case "Имя" :
                    fillField(insFirstName, value);
                    break;
                case "Отчество" :
                    fillField(insMiddleName, value);
                    break;
                case "Дата рождения страхователя" :
                    fillField(insBirthDate, value);
                    break;
                case "Пол" :
                    fillField(femGender, value);
                    break;
                case "Номер паспорта" :
                    fillField(passportNumber, value);
                    break;
                case "Серия паспорта" :
                    fillField(passportSeries, value);
                    break;
                case "Дата выдачи" :
                    fillField(documentDate, value);
                    break;
                case "Кем выдан" :
                    fillField(documentIssue, value);
                    break;
                default :
                    throw new IllegalStateException("Unexpected value: " + fieldName);
            }
        }

        public String getFillField(String fieldName){
            switch (fieldName){
                case  "Фамилия / Surname":
                    return clientSurName.getAttribute("value");
                case  "Имя / Name":
                    return clientName.getAttribute("value");
                case  "Дата рождения":
                    return clientBirthDate.getAttribute("value");
                case  "Фамилия":
                    return insLastName.getAttribute("value");
                case  "Имя":
                    return insFirstName.getAttribute("value");
                case  "Отчество":
                    return insMiddleName.getAttribute("value");
                case  "Пол":
                    return femGender.getAttribute("value");
                case  "Номер паспорта":
                    return passportNumber.getAttribute("value");
                case "Дата рождения страхователя":
                    return insBirthDate.getAttribute("value");
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

    public void checkFieldErrorMessage(String fieldName){
        String xpath = "//span[@class='control-label'][contains(text(),'" + fieldName+ "')]/..//span[contains(@class,'invalid-validate form-control__message')]";
        String expectedValue = "Поле не заполнено.";
        String actualValue = driver.findElement(By.xpath(xpath)).getText();
        Assert.assertEquals(expectedValue,actualValue);
    }
}
