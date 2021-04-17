package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelerPage extends BasePage{

    @FindBy(xpath = "//*[@class = 'kitt-col kitt-col_xs_12 kitt-col_md_6 kitt-col_lg_5 kitt-col_xl_6']")
    public WebElement sendButton;

    public TravelerPage(WebDriver driver){
        PageFactory.initElements(driver, this);

//        driver.findElement(By.xpath("//*[@class = 'kitt-button__text']")).click();
    }

    public void pressTravelerSendButton (){
        sendButton.findElement(By.xpath("//*[@class = 'kitt-button__text']")).click();
    }
}
