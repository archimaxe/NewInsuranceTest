package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CatalogPage extends BasePage{

    @FindBy(xpath = "//*[text() = 'Страхование для путешественников']")
    public WebElement travelerButton;

    @FindBy(xpath = "//*[@class = 'kitt-cookie-warning__close']")
    public WebElement closeCookiesButton;

    public CatalogPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
