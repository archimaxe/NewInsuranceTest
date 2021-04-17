package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    // Блок с меню - зачем нужен?
    @FindBy(xpath = "//*[@class = ' kitt-top-menu kitt-top-menu_icons kitt-top-menu_wide']")
    WebElement mainMenu;

    // Субменю при нажатии "Страхование"
    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[4]/nav/div/ul/li[9]/div/div[1]")
    WebElement subMenu;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // Страхование
    public void selectMainMenu(String menuItem){
        mainMenu.findElement(By.xpath("//*[@aria-label = '"+ menuItem +"']")).click();
    }

    //div[contains(@class, 'kitt-top-menu__dropdown kitt-top-menu__dropdown_icons')]//li//a[contains(text(), 'Перейти в каталог')]
    public void selectSubMenu(String subMenuItem){
        subMenu.findElement(By.xpath("//div[contains(@class, 'kitt-top-menu__dropdown kitt-top-menu__dropdown_icons')]//li//a[contains(text(), '" + subMenuItem +"')]")).click();

    }
}
