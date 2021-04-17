package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage extends BasePage{

    @FindBy(xpath = "//*[text() = 'Страхование для путешественников']")
    public WebElement travelerButton;

    public CatalogPage(WebDriver driver){
        PageFactory.initElements(driver, this);

        // Нажимаем на "Страхование для путешественников"
        driver.findElement(By.xpath("//*[@class = 'kitt-cookie-warning__close']")).click();
    }

}
