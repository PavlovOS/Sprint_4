package test;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.object.HomePage;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class HeaderLogoTests {
    private WebDriver driver;

    @Test
    public void clickScooterLogo() {
        driver = new ChromeDriver();
        String url = "https://qa-scooter.praktikum-services.ru/";
        driver.get(url);
        HomePage homePage = new HomePage(driver);
        homePage.clickLogoScooter();
        assertEquals("Открылась не главная страница \"Самоката\"", url, driver.getCurrentUrl());
    }
    @Test
    public void clickYandexLogo() {
        driver = new ChromeDriver();
        String url = "https://dzen.ru/?yredirect=true";
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage homePage = new HomePage(driver);
        homePage.clickLogoYandex();
        Set<String> handlesCount  = driver.getWindowHandles();
        String currentHandle = driver.getWindowHandle();
        handlesCount.remove(currentHandle);
        driver.switchTo().window(handlesCount.toArray()[0].toString());
        assertEquals("Открылась не главная страница \"Самоката\"", url, driver.getCurrentUrl());
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
