package page.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrackPage {
    private WebDriver driver;
    //Окно с информацией, что заказ не найден.
    private By notFound = By.xpath(".//div[@class = 'Track_NotFound__6oaoY']/img");

    public TrackPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getOrderColumns() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(notFound));
        return driver.findElement(notFound).isDisplayed();
    }
}
