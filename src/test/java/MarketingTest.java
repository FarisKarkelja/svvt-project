import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarketingTest {
    static WebDriver driver;
    static String baseURL;
    static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        baseURL = "https://olx.ba/";
    }

    @BeforeEach
    public void beforeEach() {
        driver.get(baseURL);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement disagreeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("disagree-btn")
        ));
        disagreeBtn.click();
    }

    @Test
    public void testPricing() {
        driver.get("https://marketing.olx.ba/");
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"menu-item-704\"]/a")
        ));
        button.click();

        WebElement slide = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[4]/div/div[1]/div[2]/div[3]/div/div/div/div[8]/button/span/div/img")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", slide);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", slide);

        WebElement interstitial = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"p14R_mc50\"]/span[9]/span")
        ));
        String price = interstitial.getText();

        assertEquals("40 KM", price);
    }

    @Test
    public void testDemoVideo() {
        driver.get("https://marketing.olx.ba/");
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"menu-item-704\"]/a")
        ));
        button.click();

        WebElement slide = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/div[4]/div/div[1]/div[2]/div[3]/div/div/div/div[25]/button/span/div/img")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", slide);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", slide);

        WebElement demoLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"pdfjs_internal_id_250R\"]")
        ));
        demoLink.click();

        String currentURL = driver.getCurrentUrl();
        assertTrue(currentURL.endsWith("mp4"));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
