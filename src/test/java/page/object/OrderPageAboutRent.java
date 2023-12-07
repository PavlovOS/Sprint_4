package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPageAboutRent {
    private WebDriver driver;
    //Поле для ввода/выбора даты.
    private By inputDate = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //Поле выбора срока аренды.
    private By rentalPeriod = By.className("Dropdown-placeholder");
    //Поле ввода коментария.
    private By comment = By.xpath(".//*[@placeholder = 'Комментарий для курьера']");
    //Кнопка "Заказать"
    private By buttonOrder = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Заказать']");
    //Кнопка "Да" в окне подтверждения заказа.
    private By buttonYes = By.xpath(".//div[@class = 'Order_Buttons__1xGrp']/button[text() = 'Да']");
    //Окно подтверждения заказа с текстом "Хотите оформить заказ?".
    private By confirmationWindow = By.cssSelector(".Order_ModalHeader__3FDaJ");

    public OrderPageAboutRent(WebDriver driver) {
        this.driver = driver;
    }
    public void enterDate(String date) {
        driver.findElement(inputDate).sendKeys(date, Keys.ENTER);
    }
    public void enterRentalPeriod(String rentalPeriod) {
        driver.findElement(this.rentalPeriod).click();
        driver.findElement(By.xpath(".//div[@class = 'Dropdown-option' and text() = '" + rentalPeriod + "']")).click();
    }
    public void enterColorScooter(String colorScooter) {
        driver.findElement(By.xpath(".//label[@for = '" + colorScooter + "']")).click();
    }
    public void enterComment(String comment) {
        driver.findElement(this.comment).sendKeys(comment);
    }
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }
    //Заполнение всех полей на странице "Про аренду"
    public void makingOrderAboutRent(String date, String rentalPeriod, String colorScooter, String comment) {
        enterDate(date);
        enterRentalPeriod(rentalPeriod);
        enterColorScooter(colorScooter);
        enterComment(comment);
        clickButtonOrder();
    }
    //Не заполнено поле комментарий на странице "Про аренду"
    public void makingOrderAboutRent(String date, String rentalPeriod, String colorScooter) {
        enterDate(date);
        enterRentalPeriod(rentalPeriod);
        enterColorScooter(colorScooter);
        clickButtonOrder();
    }
    public void confirmOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonYes));
        clickButtonYes();
    }
    public String orderConfirmationWindow() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(confirmationWindow));
        return driver.findElement(confirmationWindow).getText();
    }
}
