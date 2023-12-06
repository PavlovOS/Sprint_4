package test;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.object.HomePage;
import page.object.OrderPageAboutRent;
import page.object.OrderPageForWhom;

import static org.junit.Assert.assertEquals;

public class OrderScooterTests {
    private WebDriver driver;
    @Test
    public void OrderByTopButton() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String name = "Олег";
        String surname = "Павлов";
        String address = "Бутырская 5";
        String metro = "Савеловская";
        String phone = "+79348162453";
        String date = "10.12.2023";
        String rentalPeriod = "сутки";
        String colorScooter = "black";
        String comment = "Оставленный коментарий!";
        String resault = "Заказ оформлен";

        HomePage homePage = new HomePage(driver);
        OrderPageForWhom orderPageForWhom = new OrderPageForWhom(driver);
        OrderPageAboutRent orderPageAboutRent = new OrderPageAboutRent(driver);
        homePage.clickTopOrderButton();
        orderPageForWhom.makingOrderForWhom(name, surname, address, metro, phone);
        orderPageAboutRent.makingOrderAboutRent(date, rentalPeriod, colorScooter, comment);
        orderPageAboutRent.confirmOrder();
        assertEquals("Окно \"Заказ оформлен\" не появилось", resault, orderPageAboutRent.orderConfirmationWindow());
    }
    @Test
    public void OrderByMiddleButton() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        String name = "Олег";
        String surname = "Павлов";
        String address = "Бутырская 5";
        String metro = "Сокольники";
        String phone = "+79348162453";
        String date = "10.12.2025";
        String rentalPeriod = "трое суток";
        String colorScooter = "grey";
        String result = "Заказ оформлен";

        HomePage homePage = new HomePage(driver);
        OrderPageForWhom orderPageForWhom = new OrderPageForWhom(driver);
        OrderPageAboutRent orderPageAboutRent = new OrderPageAboutRent(driver);
        homePage.clickMiddleOrderButton();
        orderPageForWhom.makingOrderForWhom(name, surname, address, metro, phone);
        orderPageAboutRent.makingOrderAboutRent(date, rentalPeriod, colorScooter);
        orderPageAboutRent.confirmOrder();
        assertEquals("Окно \"Заказ оформлен\" не появилось", result, orderPageAboutRent.orderConfirmationWindow());
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
