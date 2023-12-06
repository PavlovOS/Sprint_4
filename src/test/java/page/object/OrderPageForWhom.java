package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPageForWhom {
    private WebDriver driver;
    //Поле для ввода имени.
    private By inputName = By.xpath(".//*[@placeholder = '* Имя']");
    //Поле для ввода фамилии.
    private By inputSurname = By.xpath(".//*[@placeholder = '* Фамилия']");
    //Поле для ввода адреса.
    private By inputAddress = By.xpath(".//*[@placeholder = '* Адрес: куда привезти заказ']");
    //Поле ввода/выбора станции метро.
    private By inputMetro = By.className("select-search__input");
    //Поле для ввода телефона.
    private By inputPhone = By.xpath(".//*[@placeholder = '* Телефон: на него позвонит курьер']");
    //Кнопка "Далее".
    private By buttonNext = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public OrderPageForWhom(WebDriver driver) {
        this.driver = driver;
    }
    public void enterName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }
    public void enterSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
    }
    public void enterAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }
    public void enterMetro(String metro) {
        driver.findElement(inputMetro).sendKeys(metro, Keys.DOWN, Keys.ENTER);
    }
    public void enterPhone(String phone) {
        driver.findElement(inputPhone).sendKeys(phone);
    }
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void makingOrderForWhom(String name, String surname, String address, String metro, String phone) {
        enterName(name);
        enterSurname(surname);
        enterAddress(address);
        enterMetro(metro);
        enterPhone(phone);
        clickButtonNext();
    }
}