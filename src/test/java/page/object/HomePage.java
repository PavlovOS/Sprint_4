package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    //Кнопка "Заказать" вверху страницы.
    private By topOrderButton = By.className("Button_Button__ra12g");
    //Кнопка "Заказать" в центре страницы.
    private By middleOrderButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    //Логотип "Самокат".
    private By logoScooter = By.className("Header_LogoScooter__3lsAR");
    //Логотип "Яндекс".
    private By logoYandex = By.className("Header_LogoYandex__3TSOI");
    //Кнопка "Статус заказа"
    private By orderStatus = By.className("Header_Link__1TAG7");
    //Поле ввода номера заказа.
    private By orderNumber = By.cssSelector(".Input_Input__1iN_Z.Header_Input__xIoUq");
    //Кнопка поиска по номеру заказа Go!
    private By buttonGo = By.cssSelector(".Button_Button__ra12g.Header_Button__28dPO");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }
    public void clickMiddleOrderButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(middleOrderButton));
        driver.findElement(middleOrderButton).click();
    }
    public void clickQuestionButton(String question) {
        By questionButton = By.xpath(".//div[text() = '" + question + "']");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questionButton));
        driver.findElement(questionButton).click();
    }
    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }
    public void clickOrderStatus() {
        driver.findElement(orderStatus).click();
    }
    public void enterOrderNumber(String orderNumber) {
        driver.findElement(this.orderNumber).sendKeys(orderNumber);
    }
    public void clickButtonGo() {
        driver.findElement(buttonGo).click();
    }
    public void clickOrderButton(String location) {
        if ("Top".equals(location)) {
            clickTopOrderButton();
        } else {
            clickMiddleOrderButton();
        }
    }
    public String getAnswer(String question) {
        By questionAnswer = By.xpath(".//div[text() = '" + question + "']/../../div[2]/p");
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(questionAnswer));
        return driver.findElement(questionAnswer).getText();
    }
    public boolean checkVisibilityAnswer(String question) {
        By questionAnswer = By.xpath(".//div[text() = '" + question + "']/../../div[2]/p");
        return driver.findElement(questionAnswer).isDisplayed();
    }
    public void checkOrderStatus(String orderNumber) {
        clickOrderStatus();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(this.orderNumber));
        enterOrderNumber(orderNumber);
        clickButtonGo();
    }
}
