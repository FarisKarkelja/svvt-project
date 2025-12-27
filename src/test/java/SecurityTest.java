import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecurityTest {
    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        baseUrl = "https://olx.ba/";
    }

    @BeforeEach
    public void beforeEachTest() {
        driver.get(baseUrl);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement disagreeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("disagree-btn")
        ));
        disagreeBtn.click();
    }

    @Test
    void testHttpsEnforced() {
        driver.get("http://olx.ba");
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.startsWith("https://"));
    }

    @Test
    void testApiSessionCookie() {
        Cookie olxSession = driver.manage().getCookieNamed("olx_api_session");
        assertNotNull(olxSession, "olx_api_session should exist");
        assertTrue(olxSession.isHttpOnly(), "olx_api_session should be HttpOnly");
        assertTrue(olxSession.isSecure(), "olx_api_session should be Secure");
    }
}
