package test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigurationWebDriver {
    public WebDriver driver;
    @Before
    public void createDriver() {
        driver = new ChromeDriver();
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
