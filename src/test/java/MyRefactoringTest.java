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

        // Надо проверить, что title соответствует

        PreSendAppPage preSendAppPage = new PreSendAppPage(driver);
        scrollDown();
        preSendAppPage.chooseTarif();
        scrollDown();
        preSendAppPage.pressOrderButton();
        Thread.sleep(1500);

        SendAppPage sendAppPage = new SendAppPage(driver);
        sendAppPage.fillField(sendAppPage.clientSurName, "Иванов");
        sendAppPage.fillField("Имя / Name", "Иван");
        sendAppPage.fillField("Дата рождения", "20.10.1999\n");
        sendAppPage.fillField("Фамилия", "Иванов");
        sendAppPage.fillField("Имя", "Иван");
        sendAppPage.fillField("Отчество", "Иванович");
        sendAppPage.fillField("Дата рождения", "10.06.1979");
        sendAppPage.fillField("Серия паспорта", "4545");
        sendAppPage.fillField("Номер паспорта", "200000");
        sendAppPage.fillField("Дата выдачи", "10.06.2019");
        sendAppPage.fillField("Кем выдан", "ТП УФМС AUTOTEST123");

        sendAppPage.submitButton.click();

        Assert.assertEquals("При заполнении данных произошла ошибка",
                driver.findElement(By.xpath("//*[@class = 'alert-form alert-form-error']")).getText());

        sendAppPage.checkPageErrorMessage();
        sendAppPage.checkFieldErrorMessage();


//


//        sendAppPage.checkFillField();
    }
}
