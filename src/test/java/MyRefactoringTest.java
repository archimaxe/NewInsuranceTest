import Pages.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class MyRefactoringTest extends BaseTest{
    @Test
    public void newInsuranceTest() throws Exception{
        driver.get(baseUrl);
        Thread.sleep(1500);

        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Перейти в каталог");

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.closeCookiesButton.click();
        scrollDown();
        catalogPage.travelerButton.click();
        Thread.sleep(1500);

        TravelerPage travelerPage = new TravelerPage(driver);
        String expectedTitle = "Страхование для путешественников — СберБанк";
        Assert.assertEquals(expectedTitle, driver.getTitle());
        travelerPage.pressTravelerSendButton();
        Thread.sleep(1500);

        PreSendAppPage preSendAppPage = new PreSendAppPage(driver);
        scrollDown();
        preSendAppPage.chooseTarif();
        scrollDown();
        preSendAppPage.pressOrderButton();
        Thread.sleep(1500);

        SendAppPage sendAppPage = new SendAppPage(driver);

        sendAppPage.fillField(sendAppPage.clientSurName, "Иванов");
        sendAppPage.fillField("Имя / Name", "Иван");
        sendAppPage.fillField("Дата рождения", "29.01.2000\n");
        sendAppPage.fillField("Фамилия", "Страховщиков");
        sendAppPage.fillField("Имя", "Страховщик");
        sendAppPage.fillField("Отчество", "Страховщикович");
        sendAppPage.pressFemaleGenderButton();
        sendAppPage.fillField("Дата рождения страхователя", "30.12.1999\n");
        sendAppPage.fillField("Серия паспорта", "4520");
        sendAppPage.fillField("Номер паспорта", "200000");
        sendAppPage.fillField("Дата выдачи", "01.01.2020");
        sendAppPage.fillField("Кем выдан", "ТП УФМС РОССИИ");

        sendAppPage.submitButton.click();

        Assert.assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.xpath("//*[@class = 'alert-form alert-form-error']")).getText());

        sendAppPage.checkPageErrorMessage();
        sendAppPage.checkFieldErrorMessage("Мобильный телефон");
        sendAppPage.checkFieldErrorMessage("Электронная почта");
        sendAppPage.checkFieldErrorMessage("Повтор электронной почты");

        checkFillField(sendAppPage.getFillField("Фамилия / Surname"), By.id("surname_vzr_ins_0"));
        checkFillField(sendAppPage.getFillField("Имя / Name"), By.id("name_vzr_ins_0"));
        checkFillField(sendAppPage.getFillField("Дата рождения"), By.id("birthDate_vzr_ins_0"));
        checkFillField(sendAppPage.getFillField("Фамилия"), By.id("person_lastName"));
        checkFillField(sendAppPage.getFillField("Имя"), By.id("person_firstName"));
        checkFillField(sendAppPage.getFillField("Отчество"), By.id("person_middleName"));
        checkFillField(sendAppPage.getFillField("Пол"), By.xpath("//*[text() = 'Женский']"));
        checkFillField(sendAppPage.getFillField("Дата рождения страхователя"), By.id("person_birthDate"));
        checkFillField(sendAppPage.getFillField("Серия паспорта"), By.id("passportSeries"));
        checkFillField(sendAppPage.getFillField("Номер паспорта"), By.id("passportNumber"));
        checkFillField(sendAppPage.getFillField("Дата выдачи"), By.id("documentDate"));
        checkFillField(sendAppPage.getFillField("Кем выдан"), By.id("documentIssue"));
    }
}
