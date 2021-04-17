package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreSendAppPage extends BasePage {
    @FindBy(xpath = "//*[@class = 'kitt-heading  page-teaser-dict__header kitt-heading_size_l']")
    public WebElement preTitle;

    @FindBy(xpath = "/html/body/app/ng-component/div/div/div/navigate-header/div/div/div")
    public WebElement tarif;

    @FindBy(xpath = "//*[@class = 'col-12 centered-col']")
    public WebElement orderButton;

    public PreSendAppPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void chooseTarif (){
        tarif.findElement(By.xpath("//*[@class = 'online-card-program selected']")).click();
    }

    public void pressOrderButton (){
        orderButton.findElement(By.xpath("//*[@class = 'btn btn-primary btn-large']")).click();
    }
}
