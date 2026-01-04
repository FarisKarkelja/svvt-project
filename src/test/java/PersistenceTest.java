import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersistenceTest {
    static WebDriver driver;
    static String baseURL;
    static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        baseURL = "https://olx.ba/";
        driver.get(baseURL);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@id='disagree-btn']/span")).click();
    }

    private static void login() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.linkText("Prijavi se")).click();
        Thread.sleep(500);

        driver.findElement(By.name("username")).click();
        Thread.sleep(500);

        driver.findElement(By.name("username")).clear();
        Thread.sleep(500);

        driver.findElement(By.name("username")).sendKeys("fkarkelja149@gmail.com");
        Thread.sleep(500);

        driver.findElement(By.name("password")).click();
        Thread.sleep(500);

        driver.findElement(By.name("password")).clear();
        Thread.sleep(500);

        driver.findElement(By.name("password")).sendKeys("Faris!2004");
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/button")).click();
        Thread.sleep(2000);
    }

    private static void logout() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[1]/div[2]/div/img[2]")).click();
        Thread.sleep(1000);
        WebElement odjava = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[3]/div[2]/div[2]/a[22]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", odjava);
        Thread.sleep(1000);
        odjava.click();
    }

    @Test
    public void testSavedListingsPersistence() throws InterruptedException {
        login();

        WebElement search = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[2]/form/div/input"));
        search.sendKeys("Mercedes S", Keys.ENTER);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".w-full.flex.cardd")
        ));
        driver.findElement(By.cssSelector(".w-full.flex.cardd")).click();
        Thread.sleep(1000);

        String listingName = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/h1")).getText();
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[2]/button[3]")).click();

        logout();

        login();

        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[1]/div[2]/div/img[2]")).click();
        WebElement savedListings = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[3]/div[2]/div[2]/a[13]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", savedListings);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", savedListings);
        Thread.sleep(2000);

        String pageText = driver.findElement(By.tagName("body")).getText();

        assertTrue(pageText.contains(listingName),
                "Page should contain the saved listing");

    }

    @Test
    public void testSavedSearches() throws InterruptedException {
        login();

        WebElement search = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[2]/form/div/input"));
        search.sendKeys("Man tgx", Keys.ENTER);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement results = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".w-full.flex.cardd")
        ));

        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[2]/form/div[2]/img")).click();

        logout();

        login();

        driver.get("https://olx.ba/mojolx/spaseno/pretrage");
        Thread.sleep(2000);

        String pageText = driver.findElement(By.tagName("body")).getText();
        assertTrue(pageText.contains("Man tgx"),
                "Page should contain the saved search");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
