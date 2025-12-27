import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ListingManagementTest {
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
    public void beforeEachTest() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@id='disagree-btn']/span")).click();
        Thread.sleep(1000);
    }

    @Test
    public void testListingCreation() throws InterruptedException {
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

        driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[1]/div[2]/div/button/div/img")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div/div/div[2]/div/div/div[2]/div/div[1]/div/button[1]/div/p")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div[2]/button[3]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div/div[3]/div[2]/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div/div[3]/div[2]/div[2]/button[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[6]/div/div/button[2]/div/p")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/button[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/button[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/button[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[2]/input")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[2]/input")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[2]/input")).sendKeys("160000");
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement kubikaza = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[6]/div[2]/div")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", kubikaza);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(kubikaza)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", kubikaza);
        }

        WebDriverWait waitV2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement kubikazaV2 = waitV2.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/button[1]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", kubikazaV2);
        try {
            waitV2.until(ExpectedConditions.elementToBeClickable(kubikazaV2)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", kubikazaV2);
        }

        Thread.sleep(2000);

        WebDriverWait waitV3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement kw = waitV3.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[7]/div[2]/input")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", kw);
        try {
            waitV3.until(ExpectedConditions.elementToBeClickable(kw)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", kw);
        }

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[7]/div[2]/input")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[7]/div[2]/input")).sendKeys("84");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[8]/div[2]/button[1]")).click();
        Thread.sleep(1000);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
