import org.junit.jupiter.api.*;
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

public class ShoppingCartTest {
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
    public void beforeEachTest() throws InterruptedException {
        driver.get(baseURL);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement disagreeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("disagree-btn")
        ));
        disagreeBtn.click();

        //log in
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

    @Test
    public void testAddToCart() throws InterruptedException {
        driver.get("https://olx.ba/artikal/73329257");
        String listingName = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/h1")).getText();

        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/button[4]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCart);


        driver.get(baseURL);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[1]/div[2]/button[1]")).click();
        WebElement savedListing = wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText(listingName)
        ));
        WebElement quantity = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[1]/div[2]/button[1]/div/div[2]/div/ul/li/div/div/div[2]"));
        assertEquals("Količina: 2", quantity.getText());
    }

    @Test
    public void testExistingCartPrice() throws InterruptedException {
        driver.get("https://olx.ba/artikal/73329257");

        String price = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/div/span")).getText();
        String substring = price.substring(0, price.length()-3);

        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[2]/div[2]/div/div[2]/div/div[2]/button[4]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCart);
        addToCart.click();

        Thread.sleep(2000);
        driver.get("https://olx.ba/korpa");

        String total = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/div/div[2]/p[2]")).getText();
        String total_substring = total.substring(0, total.length()-6);

        assertEquals(substring, total_substring);
    }

    @AfterEach
    public void cleanup() throws InterruptedException {
        driver.get("https://olx.ba/korpa");
        Thread.sleep(2000);
        try {
            driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[2]/ul/li/ul/li/div/div[2]/button")).click();
        } catch (Exception e) {}
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
