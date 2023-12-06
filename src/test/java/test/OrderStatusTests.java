package test;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.object.HomePage;
import page.object.TrackPage;

public class OrderStatusTests {
    private WebDriver driver;
    @Test
    public void enterIncorrectOrderNumber() {
        driver = new ChromeDriver();
        String orderNumber = "7823";
        HomePage homePage = new HomePage(driver);
        TrackPage trackPage = new TrackPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePage.checkOrderStatus(orderNumber);
        System.out.println(trackPage.getOrderColumns());
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
